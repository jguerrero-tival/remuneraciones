package org.rem.control.institucion;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.MutualDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Mutual;
import org.rem.util.Palabra;

public class ControlMutual {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	public int respUtilizado = 3;
	
	public int respFija = 4;
	
	public int respBloqueado = 5;

	/**
	 * Agrega una mutual:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un mutual con el nombre de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Sino verifica que esté bloqueada.
	 * <li>Si está bloqueada la desbloquea.
	 * <li>Si existe o si no está bloqueado no la agrega.
	 * </ul>
	 * @param valor
	 * @param tipo
	 * @return Respuesta
	 */
	public int addMutual(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
			Mutual mutual = mutualDao.findByNombre(nombre);
			if (mutual == null) {
				mutualDao.makePersistent(new Mutual(nombre));
				respuesta = respExito;
			} else if (mutual.isBloqueado()) {
				mutual.setBloqueado(new Boolean(false));
				mutualDao.makePersistent(mutual);
				respuesta = respExito;
			}
			else {
				respuesta = respExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	/**
	 * Eliminar un mutual:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mutual con el nombre de entrada.
	 * <li>Si existe se bloquea.
	 * <li>Si no existe no se bloquea.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int removeMutual(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
			Mutual mutual = mutualDao.findByNombre(nombre);
			if (mutual != null) {
					mutual.setBloqueado(new Boolean(true));
					mutualDao.makePersistent(mutual);
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
	 * Actualizar un mutual:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un mutual con el nombre de entrada.
	 * <li>Si existe:
	 *		<ul><li>Verifica que no sea bloqueado.
	 *			<li>Si no es bloqueado:
	 *				<ul><li>Verifica que no exista un mutual con el mismo newNombre.
	 *				<li>Si no existe se actualiza.
	 *				<li>Si existe no se actualiza.</ul>
	 *			<li>Si es bloqueado no se actualiza.</u>
	 * <li>Si no existe no se actualiza.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	//TODO No se puede actualizar a nombres de mutuales eliminadas
	public int updateMutual(String nombre, String newNombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
			Mutual mutual = mutualDao.findByNombre(nombre);
			if (mutual != null) {
				if (!mutual.isBloqueado()) {
					if (mutualDao.findByNombre(newNombre)==null) {
						mutual.setNombre(newNombre);
						mutualDao.makePersistent(mutual);
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
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	/**
	 * @return ComboBoxModel de todas las mutuals no bloqueadas
	 */
	public ComboBoxModel getComboBoxModelMutualNoBloqueado() {
		List<Mutual> list = new LinkedList<Mutual>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
			list = mutualDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}
	
	public ComboBoxModel getComboBoxModelMutualNoBloqueadoSin() {
		List<Mutual> list = new LinkedList<Mutual>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement(Palabra.institucionSin);
		HibernateUtil.beginTransaction();
		try {
			MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
			list = mutualDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}
	
	public Mutual getMutual(String nombre) {
		Mutual mutual = null;
		HibernateUtil.beginTransaction();
		try {
			MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
			mutual = mutualDao.findByNombre(nombre);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return mutual;
	}
	
}