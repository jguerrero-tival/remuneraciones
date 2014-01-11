package org.rem.control.mes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.ImpuestoDao;
import org.rem.dao.MesDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Impuesto;
import org.rem.model.Mes;

public class ControlImpuesto {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;
	
	public int respCasiFijo = 3;
	
	public int respNoExisteMes = 4;
	
	/**
	 * Agrega un impuesto:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mes con la fecha de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que no exista un impuesto con el mismo inicio de entrada.
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
	public int addImpuesto(Date fecha, Double inicio, Double factor, Double rebaja) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				if(impuestoDao.findByMesInicio(mes, inicio)==null) {
					mes.addImpuesto(new Impuesto(inicio, factor, rebaja));
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
	 * Eliminar un impuesto:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mes con la fecha de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que exista un impuesto con el mismo inicio de entrada.
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
	public int removeImpuesto(Date fecha, Double inicio) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				Impuesto impuesto = impuestoDao.findByMesInicio(mes, inicio);
				if (impuesto!=null) {
					if(!impuesto.isCasiFijo()) {
						impuestoDao.makeTransient(impuesto);
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
	 * Modificar un impuesto:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mes con la fecha de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que exista un impuesto con el mismo inicio de entrada.
	 * 		<li>Si existe:
	 * 			<ul><li>Verifica que no exista un impuesto con el mismo newInicio de entrada. 
	 * 					Si cumple, actualiza los datos. No actualiza el inicio si el impuesto es casi fijo.
	 * 			<li>Sino, verifica que el impuesto obtenido con inicio sea el mismo obtenido con newInicio.
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
	public int updateImpuesto (Date fecha, Double inicio, Double newInicio, Double newFactor, Double newRebaja) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				Impuesto impuesto = impuestoDao.findByMesInicio(mes, inicio);
				if (impuesto!=null) {
					Impuesto newImpuesto = impuestoDao.findByMesInicio(mes, newInicio);
					if (newImpuesto==null) {
						if(!impuesto.isCasiFijo()) {
							impuesto.setInicio(newInicio);
						}
						impuesto.setFactor(newFactor);
						impuesto.setRebaja(newRebaja);
						impuestoDao.makePersistent(impuesto);
						respuesta = respExito;
					} else if (impuesto.equals(newImpuesto)) {
						impuesto.setFactor(newFactor);
						impuesto.setRebaja(newRebaja);
						impuestoDao.makePersistent(impuesto);
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
	
	public Double getFactor(Date fecha, Double inicio) {
		Double factor;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				Impuesto impuesto = impuestoDao.findByMesInicio(mes, inicio);
				if (impuesto!=null) {
					factor = impuesto.getFactor();					
				} else {
					factor = new Double(0);
				}
			}
			else {
				factor = new Double(0);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return factor;
	}
	
	public Double getRebaja(Date fecha, Double inicio) {
		Double rebaja;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				Impuesto impuesto = impuestoDao.findByMesInicio(mes, inicio);
				if (impuesto!=null) {
					rebaja = impuesto.getRebaja();					
				} else {
					rebaja = new Double(0);
				}
			}
			else {
				rebaja = new Double(0);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return rebaja;
	}
	
	public Double getFin(Date fecha, Double inicio) {
		Double fin;
		List<Impuesto> list = new LinkedList<Impuesto>();
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				list = impuestoDao.findByMes(mes);
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
	
	public ComboBoxModel getComboBoxModelImpuestoInicio(Date fecha) {
		List<Impuesto> list;
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				list = impuestoDao.findByMes(mes);
				HibernateUtil.commitTransaction();
			} else {
				list = new LinkedList<Impuesto>();
			}
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i=0; i<list.size(); i++) {
			model.addElement(list.get(i).getInicio());
		}
		return model;
	}
	
	public ComboBoxModel getComboBoxModelImpuestoInicioNoCasiFijo(Date fecha) {
		List<Impuesto> list;
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				list = impuestoDao.findByMesNoCasiFijo(mes);
				HibernateUtil.commitTransaction();
			} else {
				list = new LinkedList<Impuesto>();
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