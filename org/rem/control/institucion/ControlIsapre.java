package org.rem.control.institucion;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.IsapreDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Isapre;
import org.rem.util.Palabra;

public class ControlIsapre {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	public int respUtilizado = 3;
	
	public int respFija = 4;
	
	public int respBloqueado = 5;

	/**
	 * Agrega una isapre:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD un isapre con el nombre de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Sino verifica que esté bloqueada.
	 * <li>Si está bloqueada la desbloquea.
	 * <li>Si existe o si no está bloqueado no la agrega.
	 * </ul>
	 * @param valor
	 * @param tipo
	 * @return Respuesta
	 */
	public int addIsapre(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			IsapreDao isapreDao = DaoFactory.getInstance().getIsapreDao();
			Isapre isapre = isapreDao.findByNombre(nombre);
			if (isapre == null) {
				isapreDao.makePersistent(new Isapre(nombre));
				respuesta = respExito;
			} else if (isapre.isBloqueado()) {
				isapre.setBloqueado(new Boolean(false));
				isapreDao.makePersistent(isapre);
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
	 * Eliminar un isapre:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un isapre con el nombre de entrada.
	 * <li>Si existe se bloquea.
	 * <li>Si no existe no se bloquea.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int removeIsapre(String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			IsapreDao isapreDao = DaoFactory.getInstance().getIsapreDao();
			Isapre isapre = isapreDao.findByNombre(nombre);
			if (isapre != null) {
					isapre.setBloqueado(new Boolean(true));
					isapreDao.makePersistent(isapre);
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
	 * Actualizar un isapre:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD un isapre con el nombre de entrada.
	 * <li>Si existe:
	 *		<ul><li>Verifica que no sea bloqueado.
	 *			<li>Si no es bloqueado:
	 *				<ul><li>Verifica que no exista un isapre con el mismo newNombre.
	 *				<li>Si no existe se actualiza.
	 *				<li>Si existe no se actualiza.</ul>
	 *			<li>Si es bloqueado no se actualiza.</u>
	 * <li>Si no existe no se actualiza.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	//TODO No se puede actualizar a nombres de isapres eliminadas
	public int updateIsapre(String nombre, String newNombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			IsapreDao isapreDao = DaoFactory.getInstance().getIsapreDao();
			Isapre isapre = isapreDao.findByNombre(nombre);
			if (isapre != null) {
				if (!isapre.isBloqueado()) {
					if (isapreDao.findByNombre(newNombre)==null) {
						isapre.setNombre(newNombre);
						isapreDao.makePersistent(isapre);
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
	 * @return ComboBoxModel de todas las isapres no bloqueadas
	 */
	public ComboBoxModel getComboBoxModelIsapreNoBloqueado() {
		List<Isapre> list = new LinkedList<Isapre>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			IsapreDao isapreDao = DaoFactory.getInstance().getIsapreDao();
			list = isapreDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}

	public ComboBoxModel getComboBoxModelIsapreNoBloqueadoFonasa() {
		List<Isapre> list = new LinkedList<Isapre>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		model.addElement(Palabra.institucionFonasa);
		HibernateUtil.beginTransaction();
		try {
			IsapreDao isapreDao = DaoFactory.getInstance().getIsapreDao();
			list = isapreDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNombre());
		}
		return model;
	}
	
	public Isapre getIsapre(String nombre) {
		Isapre isapre = null;
		HibernateUtil.beginTransaction();
		try {
			IsapreDao isapreDao = DaoFactory.getInstance().getIsapreDao();
			isapre = isapreDao.findByNombre(nombre);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return isapre;
	}
	
}