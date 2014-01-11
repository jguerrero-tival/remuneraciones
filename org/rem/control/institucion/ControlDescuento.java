package org.rem.control.institucion;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.DescuentoDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Descuento;

public class ControlDescuento {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	public int respUtilizado = 3;
	
	public int respFija = 4;
	
	public int respBloqueado = 5;

	/**
	 * Agrega un descuento:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un descuento con el nombre de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Sino verifica que esteé bloqueado.
	 * <li>Si está bloqueado lo desbloquea.
	 * <li>Si existe o si no está bloqueado no la agrega.
	 * </ul>
	 * @param valor
	 * @param tipo
	 * @return Respuesta
	 */
	public int addDescuento(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			DescuentoDao descuentoDao = DaoFactory.getInstance().getDescuentoDao();
			Descuento descuento = descuentoDao.findByNombre(nombre);
			if (descuento == null) {
				descuentoDao.makePersistent(new Descuento(nombre));
				respuesta = respExito;
			} else if (descuento.isBloqueado()) {
				descuento.setBloqueado(new Boolean(false));
				descuentoDao.makePersistent(descuento);
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
	 * Eliminar un descuento:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un descuento con el nombre de entrada.
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
	public int removeDescuento(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			DescuentoDao descuentoDao = DaoFactory.getInstance().getDescuentoDao();
			Descuento descuento = descuentoDao.findByNombre(nombre);
			if (descuento != null) {
				if (!descuento.isFijo()) {
					descuento.setBloqueado(new Boolean(true));
					descuentoDao.makePersistent(descuento);
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
	 * Actualizar un descuento:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un descuento con el nombre de entrada.
	 * <li>Si existe:
	 * 		<ul><li>Verifica que no sea fijo.
	 * 		<li>Si no es fija:
	 * 			<ul><li>Verifica que no sea bloqueado.
	 * 				<li>Si no es bloqueado:
	 * 					<ul><li>Verifica que no exista un descuento con el mismo newNombre.
	 * 					<li>Si no existe se actualiza.
	 * 					<li>Si existe no se actualiza.</ul>
	 * 				<li>Si es bloqueado no se actualiza.</u>
	 * 		<li>Si es fija no se actualiza.</ul>
	 * <li>Si no existe no se actualiza.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int updateDescuento(String nombre, String newNombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			DescuentoDao descuentoDao = DaoFactory.getInstance().getDescuentoDao();
			Descuento descuento = descuentoDao.findByNombre(nombre);
			if (descuento != null) {
				if (!descuento.isFijo()) {
					if (!descuento.isBloqueado()) {
						if (descuentoDao.findByNombre(newNombre)==null) {
							descuento.setNombre(newNombre);
							descuentoDao.makePersistent(descuento);
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
	 * @return ComboBoxModel de todas las descuentos no fijos y no bloqueados
	 */
	public ComboBoxModel getComboBoxModelDescuentoNoBloqueadoNoFijo() {
		List<Descuento> list = new LinkedList<Descuento>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			DescuentoDao descuentoDao = DaoFactory.getInstance().getDescuentoDao();
			list = descuentoDao.findByNoBloqueadoNoFijo();
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