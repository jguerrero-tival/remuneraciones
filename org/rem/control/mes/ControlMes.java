package org.rem.control.mes;

import java.util.Date;
import java.util.List;

import org.rem.dao.AfpDao;
import org.rem.dao.AsignacionDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.ImpuestoDao;
import org.rem.dao.MesDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Afp;
import org.rem.model.Asignacion;
import org.rem.model.Impuesto;
import org.rem.model.Mes;

public class ControlMes {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	/**
	 * Agrega un mes:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un mes con la fecha de entrada.
	 * <li>Si no existe, lo agrega. Además copia del ultimo mes los 
	 * impuestos y asignaciones en caso de que exista un ultimo mes.
	 * <li>Si existe no lo agrega
	 * </ul>
	 * @param fecha
	 * @param sueldoMinimo
	 * @param uf
	 * @param utm
	 * @param previsionAfpTope
	 * @param previsionApvTope
	 * @param previsionSeguroInvalidez
	 * @param mutualCotizacionBasica
	 * @param saludCotizacionBasica
	 * @param saludTope
	 * @param seguroCesantiaPorcentaje
	 * @param seguroCesantiaTope
	 * @param gratificacionPorcentaje
	 * @param gratificacionFactorAnual
	 * @param modelImpuesto
	 * @param modelAsignacion
	 * @return
	 */
	public int addMes(Date fecha, Double sueldoMinimo, Double uf, Double utm,
			Double previsionAfpTope, Double previsionApvTope, Double previsionSeguroInvalidez,
			Double mutualCotizacionBasica, Double saludCotizacionBasica,
			Double saludTope, Double seguroCesantiaPorcentaje,
			Double seguroCesantiaTope, Double gratificacionPorcentaje,
			Double gratificacionFactorAnual) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			if (mesDao.findByFecha(fecha) == null) {
				Mes mes = new Mes(fecha, sueldoMinimo, uf, utm,
						previsionAfpTope, previsionApvTope, previsionSeguroInvalidez,
						mutualCotizacionBasica, saludCotizacionBasica,
						saludTope, seguroCesantiaPorcentaje,
						seguroCesantiaTope, gratificacionPorcentaje,
						gratificacionFactorAnual);
				Mes lastMes = mesDao.findByLastMes();
				if (lastMes!=null) {
					ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
					List<Impuesto> listImpuesto = impuestoDao.findByMes(lastMes);
					for (int i=0; i<listImpuesto.size(); i++) {
						mes.addImpuesto(new Impuesto(listImpuesto.get(i)));
					}
					AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
					List<Asignacion> listAsignacion = asignacionDao.findByMes(lastMes);
					for (int i=0; i<listAsignacion.size(); i++) {
						mes.addAsignacion(new Asignacion(listAsignacion.get(i)));
					}
					AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
					List<Afp> listAfp = afpDao.findByNoBloqueadoMes(lastMes);
					for (int i=0; i<listAfp.size(); i++) {
						mes.addAfp(new Afp(listAfp.get(i)));
					}
				}
				mesDao.makePersistent(mes);
				respuesta = respExito;
			} else {
				respuesta = respExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	/**
	 * Modificar un mes:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mes con la fecha de entrada.
	 * <li>Si existe, lo modifica. No toma en cuenta las modificaciones a asignacion
	 * <li>Si no existe no lo modifica.
	 * </ul>
	 * @param fecha
	 * @param sueldoMinimo
	 * @param uf
	 * @param utm
	 * @param previsionAfpTope
	 * @param previsionApvTope
	 * @param mutualCotizacionBasica
	 * @param saludCotizacionBasica
	 * @param saludTope
	 * @param seguroCesantiaPorcentaje
	 * @param seguroCesantiaTope
	 * @param gratificacionPorcentaje
	 * @param gratificacionFactorAnual
	 * @return
	 */
	public int updateMes(Date fecha, Double sueldoMinimo, Double uf,
			Double utm, Double previsionAfpTope, Double previsionApvTope, Double previsionSeguroInvalidez, 
			Double mutualCotizacionBasica, Double saludCotizacionBasica,
			Double saludTope, Double seguroCesantiaPorcentaje,
			Double seguroCesantiaTope, Double gratificacionPorcentaje,
			Double gratificacionFactorAnual) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			if (mes != null) {
				mes.setSueldoMinimo(sueldoMinimo);
				mes.setUf(uf);
				mes.setUtm(utm);
				mes.setPrevisionAfpTope(previsionAfpTope);
				mes.setPrevisionApvTope(previsionApvTope);
				mes.setPrevisionSeguroInvalidez(previsionSeguroInvalidez);
				mes.setMutualCotizacionBasica(mutualCotizacionBasica);
				mes.setSaludCotizacionBasica(saludCotizacionBasica);
				mes.setSaludTope(saludTope);
				mes.setSeguroCesantiaPorcentaje(seguroCesantiaPorcentaje);
				mes.setSeguroCesantiaTope(seguroCesantiaTope);
				mes.setGratificacionPorcentaje(gratificacionPorcentaje);
				mes.setGratificacionFactorAnual(gratificacionFactorAnual);
				mesDao.makePersistent(mes);
				respuesta = respExito;
			} else {
				respuesta = respNoExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	/**
	 * Sueldo Mínimo de un Mes:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mes con la fecha de entrada.
	 * <li>Si existe retornar el sueldo mínimo
	 * <li>Si no existe, retornar 0
	 * </ul>
	 * @param fecha
	 * @return
	 */
	public Long getSueldoMinimo(Date fecha) {
		Long sueldoMinimo;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				sueldoMinimo = new Long(mes.getSueldoMinimo().longValue());
			}
			else {
				sueldoMinimo = new Long(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return sueldoMinimo;
	}

	public Double getUf(Date fecha) {
		Double uf;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				uf = mes.getUf();
			}
			else {
				uf = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return uf;
	}
	
	public Double getUtm(Date fecha) {
		Double utm;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				utm = mes.getUtm();
			}
			else {
				utm = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return utm;
	}
	
	public Double getPrevisionAfpTope(Date fecha) {
		Double previsionAfpTope;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				previsionAfpTope = mes.getPrevisionAfpTope();
			}
			else {
				previsionAfpTope = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return previsionAfpTope;
	}
	
	public Double getPrevisionApvTope(Date fecha) {
		Double previsionApvTope;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				previsionApvTope = mes.getPrevisionApvTope();
			}
			else {
				previsionApvTope = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return previsionApvTope;
	}
	
	public Double getPrevisionSeguroInvalidez(Date fecha) {
		Double previsionSeguroInvalidez;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				previsionSeguroInvalidez = mes.getPrevisionSeguroInvalidez();
			}
			else {
				previsionSeguroInvalidez = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return previsionSeguroInvalidez;
	}
	
	public Double getMutualCotizacionBasica(Date fecha) {
		Double mutualCotizacionBasica;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				mutualCotizacionBasica = mes.getMutualCotizacionBasica();
			}
			else {
				mutualCotizacionBasica = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return mutualCotizacionBasica;
	}
	
	public Double getSaludCotizacionBasica(Date fecha) {
		Double saludCotizacionBasica;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				saludCotizacionBasica = mes.getSaludCotizacionBasica();
			}
			else {
				saludCotizacionBasica = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return saludCotizacionBasica;
	}
	
	public Double getSaludTope(Date fecha) {
		Double saludTope;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				saludTope = mes.getSaludTope();
			}
			else {
				saludTope = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return saludTope;
	}
	
	public Double getSeguroCesantiaPorcentaje(Date fecha) {
		Double seguroCesantiaPorcentaje;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				seguroCesantiaPorcentaje = mes.getSeguroCesantiaPorcentaje();
			}
			else {
				seguroCesantiaPorcentaje = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return seguroCesantiaPorcentaje;
	}
	
	public Double getSeguroCesantiaTope(Date fecha) {
		Double seguroCesantiaTope;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				seguroCesantiaTope = mes.getSeguroCesantiaTope();
			}
			else {
				seguroCesantiaTope = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return seguroCesantiaTope;
	}

	public Double getGratificacionPorcentaje(Date fecha) {
		Double gratificacionPorcentaje;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				gratificacionPorcentaje = mes.getGratificacionPorcentaje();
			}
			else {
				gratificacionPorcentaje = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return gratificacionPorcentaje;
	}

	public Double getGratificacionFactorAnual(Date fecha) {
		Double gratificacionFactorAnual;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				gratificacionFactorAnual = mes.getGratificacionFactorAnual();
			}
			else {
				gratificacionFactorAnual = new Double(0);
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return gratificacionFactorAnual;
	}
	
	public Date getFechaLastMes() {
		Date lastFecha = null;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByLastMes();
			HibernateUtil.commitTransaction();
			if (mes!=null) {
				lastFecha = mes.getFecha();
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return lastFecha;
	}
}