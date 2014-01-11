package org.rem.control.haberDescuento;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.ImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Imponible;

public class ControlImponible {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	public int respUtilizado = 3;
	
	public int respFija = 4;
	
	public int respBloqueado = 5;

	/**
	 * Agrega un imponible:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un imponible con el nombre de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Sino verifica que esteé bloqueado.
	 * <li>Si está bloqueado lo desbloquea.
	 * <li>Si existe o si no está bloqueado no la agrega.
	 * </ul>
	 * @param valor
	 * @param tipo
	 * @return Respuesta
	 */
	public int addImponible(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			ImponibleDao imponibleDao = DaoFactory.getInstance().getImponibleDao();
			Imponible imponible = imponibleDao.findByNombre(nombre);
			if (imponible == null) {
				imponibleDao.makePersistent(new Imponible(nombre));
				respuesta = respExito;
			} else if (imponible.isBloqueado()) {
				imponible.setBloqueado(new Boolean(false));
				imponibleDao.makePersistent(imponible);
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
	 * Eliminar un imponible:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un imponible con el nombre de entrada.
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
	public int removeImponible(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			ImponibleDao imponibleDao = DaoFactory.getInstance().getImponibleDao();
			Imponible imponible = imponibleDao.findByNombre(nombre);
			if (imponible != null) {
				if (!imponible.isFijo() && !imponible.isColegio()) {
					imponible.setBloqueado(new Boolean(true));
					imponibleDao.makePersistent(imponible);
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
	 * Actualizar un imponible:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un imponible con el nombre de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que no sea fijo.
	 * 		<li>Si no es fija:
	 * 			<ul><li>Verifica que no sea bloqueado.
	 * 				<li>Si no es bloqueado:
	 * 					<ul><li>Verifica que no exista un imponible con el mismo newNombre.
	 * 					<li>Si no existe se actualiza.
	 * 					<li>Si existe no se actualiza.</ul>
	 * 				<li>Si es bloqueado no se actualiza.</u>
	 * 		<li>Si es fija no se actualiza.</ul>
	 * <li>Si no existe no se actualiza.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int updateImponible(String nombre, String newNombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			ImponibleDao imponibleDao = DaoFactory.getInstance().getImponibleDao();
			Imponible imponible = imponibleDao.findByNombre(nombre);
			if (imponible != null) {
				if (!imponible.isFijo() && !imponible.isColegio()) {
					if (!imponible.isBloqueado()) {
						if (imponibleDao.findByNombre(newNombre)==null) {
							imponible.setNombre(newNombre);
							imponibleDao.makePersistent(imponible);
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
	 * @return ComboBoxModel de todas las imponibles no fijos y no bloqueados
	 */
	public ComboBoxModel getComboBoxModelImponibleNoBloqueadoNoFijo() {
		List<Imponible> list = new LinkedList<Imponible>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			ImponibleDao imponibleDao = DaoFactory.getInstance().getImponibleDao();
			list = imponibleDao.findByNoBloqueadoNoFijo();//incluye no colegio
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