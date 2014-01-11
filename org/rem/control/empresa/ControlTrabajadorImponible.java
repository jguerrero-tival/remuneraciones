package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.ImponibleDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Imponible;
import org.rem.model.TrabajadorImponible;
import org.rem.model.TrabajadorCuenta;

public class ControlTrabajadorImponible {

	public int respExito = 0;
	
	public int respCerrada = 1;

	public int respExiste = 2;

	public int respNoExiste = 3;

	public int respNoExisteEmpresa = 4;
	
	public int respNoExisteMes = 5;
	
	public int respNoExisteImponible = 6;
	
	public int respUsandoImponible = 7;
	
	public int respNoExisteCuenta = 8;
	
	public int addTrabajadorImponible(TrabajadorCuenta cuenta, String nombreImponible, Double monto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (cuenta!= null) {
				ImponibleDao imponibleDao = DaoFactory.getInstance().getImponibleDao();
				Imponible imponible = imponibleDao.findByNombre(nombreImponible);
				if (imponible != null) {
					TrabajadorImponibleDao trabajadorImponibleDao = DaoFactory.getInstance().getTrabajadorImponibleDao();
					TrabajadorImponible trabajadorImponible = trabajadorImponibleDao.findByTrabajadorCuentaImponible(cuenta, imponible);
					if (trabajadorImponible==null) {
						trabajadorImponible = new TrabajadorImponible(monto, imponible);
						trabajadorImponible.setTrabajadorCuenta(cuenta);
						trabajadorImponible.setImponible(imponible);
						trabajadorImponibleDao.makePersistent(trabajadorImponible);
						respuesta = respExito;
					} else {
						respuesta = respExiste;
					}
				} else {
					respuesta = respUsandoImponible;
				}
			} else {
				respuesta = respNoExisteCuenta;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	public int removeTrabajadorImponible(TrabajadorImponible trabajadorImponible) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorImponible!=null) {
				TrabajadorImponibleDao trabajadorImponibleDao = DaoFactory.getInstance().getTrabajadorImponibleDao();
				trabajadorImponibleDao.makeTransient(trabajadorImponible);
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
	
	public int updateTrabajadorImponible(TrabajadorImponible trabajadorImponible, 
			Double monto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorImponible!=null) {
				TrabajadorImponibleDao trabajadorImponibleDao = DaoFactory.getInstance().getTrabajadorImponibleDao();
				trabajadorImponible = trabajadorImponibleDao.findById(trabajadorImponible.getIdTrabajadorImponible(), false);
				trabajadorImponible.setMonto(monto);
				trabajadorImponibleDao.makePersistent(trabajadorImponible);
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
	
	public ComboBoxModel getComboBoxModelImponible(TrabajadorCuenta cuenta) {
		List<Imponible> list = new LinkedList<Imponible>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			ImponibleDao imponibleDao = DaoFactory.getInstance().getImponibleDao();
			list = imponibleDao.findByNoBloqueadoNoFijo();
			TrabajadorImponibleDao trabajadorImponibleDao = DaoFactory.getInstance().getTrabajadorImponibleDao();
			for (int i = 0; i < list.size(); i++) {
				if (trabajadorImponibleDao.findByTrabajadorCuentaImponible(cuenta, list.get(i))==null) {
					model.addElement(list.get(i).getNombre());
				}
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return model;
	}
	
}