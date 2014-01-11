package org.rem.control.haberDescuento;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.NoImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.NoImponible;

public class ControlNoImponible {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	public int respUtilizado = 3;
	
	public int respFija = 4;
	
	public int respBloqueado = 5;

	/**
	 * Agrega un noImponible:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un noImponible con el nombre de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Sino verifica que esteé bloqueado.
	 * <li>Si está bloqueado lo desbloquea.
	 * <li>Si existe o si no está bloqueado no la agrega.
	 * </ul>
	 * @param valor
	 * @param tipo
	 * @return Respuesta
	 */
	public int addNoImponible(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			NoImponibleDao noImponibleDao = DaoFactory.getInstance().getNoImponibleDao();
			NoImponible noImponible = noImponibleDao.findByNombre(nombre);
			if (noImponible == null) {
				noImponibleDao.makePersistent(new NoImponible(nombre));
				respuesta = respExito;
			} else if (noImponible.isBloqueado()) {
				noImponible.setBloqueado(new Boolean(false));
				noImponibleDao.makePersistent(noImponible);
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
	 * Eliminar un noImponible:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un noImponible con el nombre de entrada.
	 * <li>Si existe:
	 * <ul>
	 * <li>Verifica que no sea fijo.
	 * <li>Si no es fijo se bloquea.
	 * <li>Si es fijo no se bloquea.
	 * </ul>
	 * <li>Si no existe no se bloquea.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int removeNoImponible(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			NoImponibleDao noImponibleDao = DaoFactory.getInstance().getNoImponibleDao();
			NoImponible noImponible = noImponibleDao.findByNombre(nombre);
			if (noImponible != null) {
				if (!noImponible.isFijo()) {
					noImponible.setBloqueado(new Boolean(true));
					noImponibleDao.makePersistent(noImponible);
					respuesta = respExito;		
				} else {
					respuesta = respFija;
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
	 * Actualizar un noImponible:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un noImponible con el nombre de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que no sea fijo.
	 * 		<li>Si no es fija:
	 * 			<ul><li>Verifica que no sea bloqueado.
	 * 				<li>Si no es bloqueado:
	 * 					<ul><li>Verifica que no exista un noImponible con el mismo newNombre.
	 * 					<li>Si no existe se actualiza.
	 * 					<li>Si existe no se actualiza.</ul>
	 * 				<li>Si es bloqueado no se actualiza.</u>
	 * 		<li>Si es fija no se actualiza.</ul>
	 * <li>Si no existe no se actualiza.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int updateNoImponible(String nombre, String newNombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			NoImponibleDao noImponibleDao = DaoFactory.getInstance().getNoImponibleDao();
			NoImponible noImponible = noImponibleDao.findByNombre(nombre);
			if (noImponible != null) {
				if (!noImponible.isFijo()) {
					if (!noImponible.isBloqueado()) {
						if (noImponibleDao.findByNombre(newNombre)==null) {
							noImponible.setNombre(newNombre);
							noImponibleDao.makePersistent(noImponible);
							respuesta = respExito;										
						} else {
							respuesta = respExiste;
						}
					} else {
						respuesta = respBloqueado;
					}
				} else {
					respuesta = respFija;
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
	 * @return ComboBoxModel de todas las noImponibles no fijos y no bloqueados
	 */
	public ComboBoxModel getComboBoxModelNoImponibleNoBloqueadoNoFijo() {
		List<NoImponible> list = new LinkedList<NoImponible>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			NoImponibleDao noImponibleDao = DaoFactory.getInstance().getNoImponibleDao();
			list = noImponibleDao.findByNoBloqueadoNoFijo();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}
	
}