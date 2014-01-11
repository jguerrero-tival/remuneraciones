package org.rem.control.empresa;

import java.util.Date;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaDao;
import org.rem.dao.TrabajadorDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Direccion;
import org.rem.model.Empresa;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Trabajador;
import org.rem.model.Persona;

public class ControlTrabajador {

	public int respExito = 0;

	public int respExitoBloqueado = 1;

	public int respExiste = 2;

	public int respNoExiste = 3;

	public int respNoExisteEmpresa = 4;

	public int addTrabajador(Empresa empresa, Persona datosPersonales,
			Direccion direccion, Date fechaIngreso, Date fechaEgreso) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			TrabajadorDao trabajadorDao = DaoFactory.getInstance().getTrabajadorDao();
			Trabajador trabajador = trabajadorDao.findByEmpresaRutTrabajador(empresa, datosPersonales.getRut());
			EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
			empresa = empresaDao.findByRutEmpresa(empresa.getRutEmpresa());
			if (empresa != null) {
				if (trabajador == null) {
					Trabajador newTrabajador = new Trabajador(datosPersonales,
							direccion, fechaIngreso, fechaEgreso);
					empresa.addTrabajador(newTrabajador);
					empresaDao.makePersistent(empresa);
					respuesta = respExito;
				} else if (trabajador.isBloqueado()) {
					trabajador.setBloqueado(new Boolean(false));
					trabajadorDao.makePersistent(trabajador);
					respuesta = respExitoBloqueado;
				} else {
					respuesta = respExiste;
				}
			} else {
				respuesta = respNoExisteEmpresa;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	public int removeTrabajador(Empresa empresa, Trabajador trabajador) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresa != null) {
				if (trabajador != null) {
					TrabajadorDao trabajadorDao = DaoFactory.getInstance()
							.getTrabajadorDao();
					trabajador.setBloqueado(new Boolean(true));
					trabajadorDao.makePersistent(trabajador);
					respuesta = respExito;
				} else {
					respuesta = respNoExiste;
				}
			} else {
				respuesta = respNoExisteEmpresa;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	public int updateTrabajador(Empresa empresa, Trabajador trabajador,
			Persona newDatosPersonales, Direccion newDireccion,
			Date newFechaIngreso, Date newFechaEgreso) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresa != null) {
				if (trabajador != null) {
					TrabajadorDao trabajadorDao = DaoFactory.getInstance()
							.getTrabajadorDao();
					trabajador.setDatosPersonales(newDatosPersonales);
					trabajador.setDireccion(newDireccion);
					trabajador.setFechaIngreso(newFechaIngreso);
					trabajador.setFechaEgreso(newFechaEgreso);
					trabajadorDao.makePersistent(trabajador);
					respuesta = respExito;
				} else {
					respuesta = respNoExiste;
				}
			} else {
				respuesta = respNoExisteEmpresa;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	public Trabajador getTrabajadorBloqueado(Empresa empresa,
			String rutTrabajador) {
		Trabajador trabajador;
		HibernateUtil.beginTransaction();
		try {
			TrabajadorDao trabajadorDao = DaoFactory.getInstance()
					.getTrabajadorDao();
			if (trabajadorDao.isBloqueado(empresa, rutTrabajador)
					.booleanValue()) {
				trabajador = trabajadorDao.findByEmpresaRutTrabajador(empresa,
						rutTrabajador);
			} else {
				trabajador = null;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return trabajador;
	}

	public Persona getDatosPersonales(EmpresaCuenta empresaCuenta,
			String rutTrabajador) {
		Persona datosPersonales = null;
		HibernateUtil.beginTransaction();
		try {
			HibernateUtil.commitTransaction();
			TrabajadorDao trabajadorDao = DaoFactory.getInstance()
					.getTrabajadorDao();
			Trabajador trabajador = trabajadorDao.findByEmpresaRutTrabajador(
					empresaCuenta.getEmpresa(), rutTrabajador);
			if (trabajador != null) {
				datosPersonales = trabajador.getDatosPersonales();
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return datosPersonales;
	}

	public Trabajador getTrabajador(EmpresaCuenta empresaCuenta,
			String rutTrabajador) {
		Trabajador trabajador = null;
		HibernateUtil.beginTransaction();
		try {
			HibernateUtil.commitTransaction();
			TrabajadorDao trabajadorDao = DaoFactory.getInstance()
					.getTrabajadorDao();
			trabajador = trabajadorDao.findByEmpresaRutTrabajador(empresaCuenta
					.getEmpresa(), rutTrabajador);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return trabajador;
	}

}