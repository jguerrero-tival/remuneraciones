package org.rem.control.mes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.AsignacionDao;
import org.rem.dao.MesDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Asignacion;
import org.rem.model.Mes;

public class ControlAsignacion {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;
	
	public int respCasiFijo = 3;
	
	public int respNoExisteMes = 4;
	
	/**
	 * Agrega un asignacion:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mes con la fecha de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que no exista un asignacion con el mismo inicio de entrada.
	 * 		<li>Si no existe, lo agrega.
	 * 		<li>Si existe, no lo agrega</ul>
	 * <li>Si no existe no lo agrega.
	 * </ul>
	 * @param fecha
	 * @param inicio
	 * @param factor
	 * @param rebaja
	 * @return Respuesta
	 */
	public int addAsignacion(Date fecha, Double inicio, Double monto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
				if(asignacionDao.findByMesInicio(mes, inicio)==null) {
					mes.addAsignacion(new Asignacion(inicio, monto));
					mesDao.makePersistent(mes);
					respuesta = respExito;
				} else {
					respuesta = respExiste;
				}				
			} else {
				respuesta = respNoExisteMes;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	/**
	 * Eliminar un asignacion:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mes con la fecha de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que exista un asignacion con el mismo inicio de entrada.
	 * 		<li>Si existe:
	 * 			<ul><li>Verifica que no sea casi fijo.
	 * 			<li>Si no es casi fijo, lo elimina.
	 * 			<li>Si es casi fijo, no lo elimina.
	 * 		<li>Si no existe, no lo elimina</ul>
	 * <li>Si no existe no lo elimina.
	 * </ul>
	 * @param fecha
	 * @param inicio
	 * @return
	 */
	public int removeAsignacion(Date fecha, Double inicio) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
				Asignacion asignacion = asignacionDao.findByMesInicio(mes, inicio);
				if (asignacion!=null) {
					if(!asignacion.isCasiFijo()) {
						asignacionDao.makeTransient(asignacion);
						respuesta = respExito;
					} else {
						respuesta = respCasiFijo;
					}
				} else {
					respuesta = respNoExiste;
				}
			} else {
				respuesta = respNoExisteMes;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	/**
	 * Modificar un asignacion:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mes con la fecha de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que exista un asignacion con el mismo inicio de entrada.
	 * 		<li>Si existe:
	 * 			<ul><li>Verifica que no exista un asignacion con el mismo newInicio de entrada. 
	 * 					Si cumple, actualiza los datos. No actualiza el inicio si el asignacion es casi fijo.
	 * 			<li>Sino, verifica que el asignacion obtenido con inicio sea el mismo obtenido con newInicio.
	 * 				Si cumple actualiza los datos menos el inicio.
	 * 			<li>Sino, no lo modifica.
	 * 		<li>Si no existe, no lo modifica</ul>
	 * <li>Si no existe no lo modifica.
	 * </ul> 
	 * @param fecha
	 * @param inicio
	 * @param newInicio
	 * @param newFactor
	 * @param newRebaja
	 * @return
	 */
	public int updateAsignacion (Date fecha, Double inicio, Double newInicio, Double newMonto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
				Asignacion asignacion = asignacionDao.findByMesInicio(mes, inicio);
				if (asignacion!=null) {
					Asignacion newAsignacion = asignacionDao.findByMesInicio(mes, newInicio);
					if (newAsignacion==null) {
						if(!asignacion.isCasiFijo()) {
							asignacion.setInicio(newInicio);
						}
						asignacion.setMonto(newMonto);
						asignacionDao.makePersistent(asignacion);
						respuesta = respExito;
					} else if (asignacion.equals(newAsignacion)) {
						asignacion.setMonto(newMonto);
						asignacionDao.makePersistent(asignacion);
						respuesta = respExito;
					} else {
						respuesta = respExiste;
					}
				} else {
					respuesta = respNoExiste;
				}
			} else {
				respuesta = respNoExisteMes;
			}		
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	public Double getMonto(Date fecha, Double inicio) {
		Double monto;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
				Asignacion asignacion = asignacionDao.findByMesInicio(mes, inicio);
				if (asignacion!=null) {
					monto = asignacion.getMonto();					
				} else {
					monto = new Double(0);
				}
			}
			else {
				monto = new Double(0);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return monto;
	}
	
	public Double getFin(Date fecha, Double inicio) {
		Double fin;
		List<Asignacion> list = new LinkedList<Asignacion>();
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
				list = asignacionDao.findByMes(mes);
			}
			HibernateUtil.commitTransaction();	
		} finally {
			HibernateUtil.closeSession();
		}
		fin = Double.POSITIVE_INFINITY;
		for (int i=0; i<list.size(); i++) {
			if (inicio.doubleValue()<list.get(i).getInicio().doubleValue()) {
				fin = list.get(i).getInicio();
				break;
			}
		}
		return fin;
	}
	
	public ComboBoxModel getComboBoxModelAsignacionInicio(Date fecha) {
		List<Asignacion> list;
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
				list = asignacionDao.findByMes(mes);
				HibernateUtil.commitTransaction();
			} else {
				list = new LinkedList<Asignacion>();
			}
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i=0; i<list.size(); i++) {
			model.addElement(list.get(i).getInicio());
		}
		return model;
	}
	
	public ComboBoxModel getComboBoxModelAsignacionInicioNoCasiFijo(Date fecha) {
		List<Asignacion> list;
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
				list = asignacionDao.findByMesNoCasiFijo(mes);
				HibernateUtil.commitTransaction();
			} else {
				list = new LinkedList<Asignacion>();
			}
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i=0; i<list.size(); i++) {
			model.addElement(list.get(i).getInicio());
		}
		return model;
	}
	
}