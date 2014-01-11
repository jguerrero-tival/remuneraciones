package org.rem.control.institucion;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.CajaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Caja;
import org.rem.util.Palabra;

public class ControlCaja {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	public int respUtilizado = 3;
	
	public int respFija = 4;
	
	public int respBloqueado = 5;

	/**
	 * Agrega una caja:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un caja con el nombre de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Sino verifica que esté bloqueada.
	 * <li>Si está bloqueada la desbloquea.
	 * <li>Si existe o si no está bloqueado no la agrega.
	 * </ul>
	 * @param valor
	 * @param tipo
	 * @return Respuesta
	 */
	public int addCaja(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
			Caja caja = cajaDao.findByNombre(nombre);
			if (caja == null) {
				cajaDao.makePersistent(new Caja(nombre));
				respuesta = respExito;
			} else if (caja.isBloqueado()) {
				caja.setBloqueado(new Boolean(false));
				cajaDao.makePersistent(caja);
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
	 * Eliminar un caja:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un caja con el nombre de entrada.
	 * <li>Si existe se bloquea.
	 * <li>Si no existe no se bloquea.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int removeCaja(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
			Caja caja = cajaDao.findByNombre(nombre);
			if (caja != null) {
					caja.setBloqueado(new Boolean(true));
					cajaDao.makePersistent(caja);
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
	 * Actualizar un caja:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un caja con el nombre de entrada.
	 * <li>Si existe:
	 *		<ul><li>Verifica que no sea bloqueado.
	 *			<li>Si no es bloqueado:
	 *				<ul><li>Verifica que no exista un caja con el mismo newNombre.
	 *				<li>Si no existe se actualiza.
	 *				<li>Si existe no se actualiza.</ul>
	 *			<li>Si es bloqueado no se actualiza.</u>
	 * <li>Si no existe no se actualiza.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	//TODO No se puede actualizar a nombres de cajas eliminadas
	public int updateCaja(String nombre, String newNombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
			Caja caja = cajaDao.findByNombre(nombre);
			if (caja != null) {
				if (!caja.isBloqueado()) {
					if (cajaDao.findByNombre(newNombre)==null) {
						caja.setNombre(newNombre);
						cajaDao.makePersistent(caja);
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
	 * @return ComboBoxModel de todas las cajas no bloqueadas
	 */
	public ComboBoxModel getComboBoxModelCajaNoBloqueado() {
		List<Caja> list = new LinkedList<Caja>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
			list = cajaDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}
	
	public ComboBoxModel getComboBoxModelCajaNoBloqueadoSin() {
		List<Caja> list = new LinkedList<Caja>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement(Palabra.institucionSin);
		HibernateUtil.beginTransaction();
		try {
			CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
			list = cajaDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}
	
	public Caja getCaja(String nombre) {
		Caja caja = null;
		HibernateUtil.beginTransaction();
		try {
			CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
			caja = cajaDao.findByNombre(nombre);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return caja;
	}
	
}