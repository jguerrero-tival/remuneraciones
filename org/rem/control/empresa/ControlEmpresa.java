package org.rem.control.empresa;

import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Direccion;
import org.rem.model.Empresa;
import org.rem.model.Persona;

public class ControlEmpresa {

	public int respExito = 0;
	
	public int respExitoBloqueado = 1;

	public int respExiste = 2;

	public int respNoExiste = 3;

	public int respUtilizado = 4;

	public int respBloqueado = 5;

	/**
	 * Agrega una empresa:
	 * <p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un empresa con el nombre de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Sino verifica que esté bloqueada.
	 * <li>Si está bloqueada la desbloquea.
	 * <li>Si existe o si no está bloqueado no la agrega.
	 * </ul>
	 * 
	 * @param valor
	 * @param tipo
	 * @return Respuesta
	 */
	public int addEmpresa(String rutEmpresa, String razonSocial,
			Boolean colegio, String actividad, String fono, String email,
			Direccion direccion, Persona representante) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
			Empresa empresa = empresaDao.findByRutEmpresa(rutEmpresa);
			if (empresa == null) {
				empresaDao.makePersistent(new Empresa(rutEmpresa, razonSocial,
						colegio, actividad, fono, email, direccion, representante));
				respuesta = respExito;
			} else if (empresa.isBloqueado()) {
				empresa.setBloqueado(new Boolean(false));
				empresaDao.makePersistent(empresa);
				respuesta = respExitoBloqueado;
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
	 * Eliminar un empresa:
	 * <p>
	 * <ul>
	 * <li>Se verifica que la empresa no sea null:
	 * <li>Si la empresa es null se bloquea.
	 * <li>Si no es null no se bloquea.
	 * </ul>
	 * 
	 * @param valor
	 * @return Respuesta
	 */
	public int removeEmpresa(Empresa empresa) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresa != null) {
				EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
				empresa.setBloqueado(new Boolean(true));
				empresaDao.makePersistent(empresa);
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
	 * Actualizar un empresa:
	 * <p>
	 * <ul>
	 * <li>Se verifica que la empresa no sea null:
	 * <li>Si la empresa no es null se actualiza.
	 * <li>Si es null no se actualiza.
	 * </ul>
	 * 
	 * @param valor
	 * @return Respuesta
	 */
	public int updateEmpresa(Empresa empresa, String newRazonSocial,
			Boolean newColegio, String newActividad, String newFono, String newEmail,
			Direccion newDireccion, Persona newRepresentante) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresa != null) {
				EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
				empresa.setRazonSocial(newRazonSocial);
				empresa.setColegio(newColegio);
				empresa.setActividad(newActividad);
				empresa.setFono(newFono);
				empresa.setEmail(newEmail);
				empresa.setDireccion(newDireccion);
				empresa.setRepresentante(newRepresentante);
				empresaDao.makePersistent(empresa);
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

	public Empresa getEmpresaBloqueada(String rutEmpresa) {
		Empresa empresa;
		HibernateUtil.beginTransaction();
		try {
			EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
			if (empresaDao.isBloqueado(rutEmpresa).booleanValue()) {
				empresa = empresaDao.findByRutEmpresa(rutEmpresa);	
			} else {
				empresa = null;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return empresa;
	}
	
}