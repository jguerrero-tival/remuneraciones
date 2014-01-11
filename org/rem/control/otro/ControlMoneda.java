package org.rem.control.otro;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DaoFactory;
import org.rem.dao.MonedaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Moneda;

public class ControlMoneda {

	public int respExito = 0;

	public int respExiste = 1;

	public int respNoExiste = 2;

	public int respUtilizado = 3;
	
	public int respFija = 4;

	/**
	 * Agrega una moneda:<p>
	 * <ul>
	 * <li>Verifica que no exista en la BD una moneda con el valor de entrada.
	 * <li>Si no existe, la agrega.
	 * <li>Si existe no la agrega
	 * </ul>
	 * @param valor
	 * @param tipo
	 * @return Respuesta
	 */
	public int addMoneda(Double valor, String tipo) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MonedaDao monedaDao = DaoFactory.getInstance().getMonedaDao();
			if (monedaDao.findByValor(valor) == null) {
				monedaDao.makePersistent(new Moneda(valor, tipo));
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
	 * Eliminar una moneda:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD una moneda con el valor de entrada.
	 * <li>Si existe:
	 * <ul>
	 * <li>Verifica que no sea fija.
	 * <li>Si no es fija se elimina.
	 * <li>Si es fija no se elimina.
	 * </ul>
	 * <li>Si no existe no la elimina.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int removeMoneda(Double valor) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MonedaDao monedaDao = DaoFactory.getInstance().getMonedaDao();
			Moneda moneda = monedaDao.findByValor(valor);
			if (moneda != null) {
				if (!moneda.isFijo()) {
					monedaDao.makeTransient(moneda);
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
	 * Actualizar una moneda:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD una moneda con el valor de entrada.
	 * <li>Si existe:
	 * <ul>
	 * <li>Verifica que no sea fija.
	 * <li>Si no es fija se actualiza.
	 * <li>Si es fija no se actualiza.
	 * </ul>
	 * <li>Si no existe no se actualiza.
	 * </ul>
	 * @param valor
	 * @return Respuesta
	 */
	public int updateMoneda(Double valor, String tipo) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			MonedaDao monedaDao = DaoFactory.getInstance().getMonedaDao();
			Moneda moneda = monedaDao.findByValor(valor);
			if (moneda != null) {
				if (!moneda.isFijo()) {
					moneda.setTipo(tipo);
					monedaDao.makePersistent(moneda);
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
	 * @return ComboBoxModel de todas las monedas no fijas
	 */
	public ComboBoxModel getComboBoxModelMonedaNoFijo() {
		List<Moneda> list = new LinkedList<Moneda>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			MonedaDao monedaDao = DaoFactory.getInstance().getMonedaDao();
			list = monedaDao.findByNoFijo();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getValor());
		}
		return model;
	}

	/**
	 * Tipo de una moneda:<p>
	 * <ul>
	 * <li>Verifica que exista en la BD una moneda con el valor de entrada.
	 * <li>Si existe retornar el tipo
	 * <li>Si no existe, retornar string en blanco
	 * </ul>
	 * @param valor
	 * @return
	 */
	public String getTipo(Double valor) {
		String tipo;
		HibernateUtil.beginTransaction();
		try {
			MonedaDao monedaDao = DaoFactory.getInstance().getMonedaDao();
			Moneda moneda = monedaDao.findByValor(valor);
			HibernateUtil.commitTransaction();
			if (moneda!=null) {
				tipo = moneda.getTipo();
			}
			else {
				tipo = "";
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return tipo;
	}
	
}