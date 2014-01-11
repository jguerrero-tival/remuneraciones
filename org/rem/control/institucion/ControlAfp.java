package org.rem.control.institucion;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import org.rem.dao.AsignacionDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.AfpDao;
import org.rem.dao.EmpresaCuentaDao;
import org.rem.dao.MesDao;
import org.rem.dao.TrabajadorCuentaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Afp;
import org.rem.model.Asignacion;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Mes;
import org.rem.model.TrabajadorCuenta;
import org.rem.util.Palabra;

public class ControlAfp {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	public int respUtilizado = 3;
	
	public int respFija = 4;
	
	public int respBloqueado = 5;

	public int respNoExisteMes = 6;
	
	/**
	 * Agrega una afp:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un afp con el nombre de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Sino verifica que esté bloqueada.
	 * <li>Si está bloqueada la desbloquea.
	 * <li>Si existe o si no está bloqueado no la agrega.
	 * </ul>
	 * @param valor
	 * @param tipo
	 * @return respuesta
	 */
	public int addAfp(Date fecha, String nombre, String regimen, Double cotizacion) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				Afp afp = afpDao.findByMesNombre(mes, nombre);
				if (afp == null) {
					mes.addAfp(new Afp(nombre, regimen, cotizacion));
					mesDao.makePersistent(mes);
					//afpDao.makePersistent(new Afp(nombre, regimen, cotizacion));
					respuesta = respExito;
				} else if (afp.isBloqueado()) {
					afp.setBloqueado(new Boolean(false));
					afp.setRegimen(regimen);
					afp.setCotizacion(cotizacion);
					afpDao.makePersistent(afp);
					respuesta = respExito;
				}
				else {
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
	 * Eliminar un afp:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un afp con el nombre de entrada.
	 * <li>Si existe se bloquea.
	 * <li>Si no existe no se bloquea.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int removeAfp(Date fecha, String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				Afp afp = afpDao.findByMesNombre(mes, nombre);
				if (afp != null) {
						afp.setBloqueado(new Boolean(true));
						afpDao.makePersistent(afp);
						respuesta = respExito;
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
	 * Actualizar un afp:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un afp con el nombre de entrada.
	 * <li>Si existe:
	 *		<ul><li>Verifica que no sea bloqueado.
	 *			<li>Si no es bloqueado:
	 *				<ul><li>Verifica que no exista un afp con el mismo newNombre.
	 *				<li>Si no existe se actualiza.
	 *				<li>Si existe no se actualiza.</ul>
	 *			<li>Si es bloqueado no se actualiza.</u>
	 * <li>Si no existe no se actualiza.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	//TODO No se puede actualizar a nombres de afps eliminadas
	public int updateAfp(Date fecha, String nombre, String newNombre, String newRegimen, Double newCotizacion) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				Afp afp = afpDao.findByMesNombre(mes, nombre);
				if (afp != null) {
					if (!afp.isBloqueado()) {
						if (nombre.equals(newNombre)) {
							afp.setRegimen(newRegimen);
							afp.setCotizacion(newCotizacion);
							afpDao.makePersistent(afp);
							respuesta = respExito;										
						}
						else if (afpDao.findByMesNombre(mes, newNombre)==null) {
							afp.setNombre(newNombre);
							afp.setRegimen(newRegimen);
							afp.setCotizacion(newCotizacion);
							afpDao.makePersistent(afp);
							respuesta = respExito;										
						} else {
							respuesta = respExiste;
						}
					} else {
						respuesta = respBloqueado;
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
	 * @return ComboBoxModel de todas las afps no bloqueadas
	 */
	public ComboBoxModel getComboBoxModelAfpNoBloqueado(Date fecha) {
		List<Afp> list = new LinkedList<Afp>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				list = afpDao.findByNoBloqueadoMes(mes);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}
	
	/**
	 * @return ComboBoxModel de todas las afps no bloqueadas del regimen nuevo
	 */
	public ComboBoxModel getComboBoxModelAfpNuevoNoBloqueado(Date fecha) {
		List<Afp> list = new LinkedList<Afp>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				list = afpDao.findByNoBloqueadoMes(mes);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getRegimen().equals(Palabra.regimenNuevo)) {
				model.addElement(list.get(i).getNombre());
			}	
		}
		return model;
	}
	
	public ComboBoxModel getComboBoxModelAfpNoBloqueadoSin(Date fecha) {
		List<Afp> list = new LinkedList<Afp>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement(Palabra.institucionSin);
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				list = afpDao.findByNoBloqueadoMes(mes);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}
		
	/**
	 * Régimen de una afp:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD una afp con el nombre de entrada.
	 * <li>Si existe retornar el régimen
	 * <li>Si no existe, retornar string en blanco
	 * </ul>
	 * @param nombre
	 * @return
	 */
	public String getRegimen(Date fecha, String nombre) {
		String regimen;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			Afp afp = null;
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				afp = afpDao.findByMesNombre(mes, nombre);
			}
			HibernateUtil.commitTransaction();
			if (afp!=null) {
				regimen = afp.getRegimen();
			}
			else {
				regimen = "";
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return regimen;
	}

	/**
	 * Cotización de una afp:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD una afp con el nombre de entrada.
	 * <li>Si existe retornar la cotización.
	 * <li>Si no existe, retornar "0".
	 * </ul>
	 * @param nombre
	 * @return
	 */
	public Double getCotizacion(Date fecha, String nombre) {
		Double cotizacion;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			Afp afp = null;
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				afp = afpDao.findByMesNombre(mes, nombre);
			}
			HibernateUtil.commitTransaction();
			if (afp!=null) {
				cotizacion = afp.getCotizacion();
			}
			else {
				cotizacion = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return cotizacion;
	}

	public Afp getAfp(Date fecha, String nombre) {
		Afp afp = null;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
				afp = afpDao.findByMesNombre(mes, nombre);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return afp;
	}
	
	public static void reassignAfpToTrabajadorCuenta(EmpresaCuenta empresaCuenta) {
		HibernateUtil.beginTransaction();
		try {
			EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
			empresaCuenta = empresaCuentaDao.findByEmpresaMes(empresaCuenta.getEmpresa(), empresaCuenta.getMes());
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(empresaCuenta.getMes().getFecha());
			TrabajadorCuentaDao trabajadorCuentaDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
			List<TrabajadorCuenta> trabajadorCuentas = trabajadorCuentaDao.findByEmpresaCuenta(empresaCuenta);
			AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
			for (int i=0 ; i<trabajadorCuentas.size(); i++) {
				Afp afp = trabajadorCuentas.get(i).getAfp();
				Afp afp2 = trabajadorCuentas.get(i).getAfp2();
				if ( afp != null ) {
					afp = afpDao.findByMesNombre(mes, trabajadorCuentas.get(i).getAfp().getNombre());
					trabajadorCuentas.get(i).setAfp(afp);
				} else {
					trabajadorCuentas.get(i).setAfp(null);
				}
				if ( afp2 != null ) {
					afp2 = afpDao.findByMesNombre(mes, trabajadorCuentas.get(i).getAfp().getNombre());				
					trabajadorCuentas.get(i).setAfp2(afp2);
				} else {
					trabajadorCuentas.get(i).setAfp2(null);
				}
			}
			HibernateUtil.commitTransaction();
		} finally {
			//HibernateUtil.closeSession();
		}
		
	}
	
}