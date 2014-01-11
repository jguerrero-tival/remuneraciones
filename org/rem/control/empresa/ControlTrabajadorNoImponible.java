package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.NoImponibleDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorNoImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.NoImponible;
import org.rem.model.TrabajadorNoImponible;
import org.rem.model.TrabajadorCuenta;

public class ControlTrabajadorNoImponible {

	public int respExito = 0;
	
	public int respCerrada = 1;

	public int respExiste = 2;

	public int respNoExiste = 3;

	public int respNoExisteEmpresa = 4;
	
	public int respNoExisteMes = 5;
	
	public int respNoExisteNoImponible = 6;
	
	public int respUsandoNoImponible = 7;
	
	public int respNoExisteCuenta = 8;
	
	public int addTrabajadorNoImponible(TrabajadorCuenta cuenta, String nombreNoImponible, Double monto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (cuenta!= null) {
				NoImponibleDao noImponibleDao = DaoFactory.getInstance().getNoImponibleDao();
				NoImponible noImponible = noImponibleDao.findByNombre(nombreNoImponible);
				if (noImponible != null) {
					TrabajadorNoImponibleDao trabajadorNoImponibleDao = DaoFactory.getInstance().getTrabajadorNoImponibleDao();
					TrabajadorNoImponible trabajadorNoImponible = trabajadorNoImponibleDao.findByTrabajadorCuentaNoImponible(cuenta, noImponible);
					if (trabajadorNoImponible==null) {
						trabajadorNoImponible = new TrabajadorNoImponible(monto, noImponible);
						trabajadorNoImponible.setTrabajadorCuenta(cuenta);
						trabajadorNoImponible.setNoImponible(noImponible);
						trabajadorNoImponibleDao.makePersistent(trabajadorNoImponible);
						respuesta = respExito;
					} else {
						respuesta = respExiste;
					}
				} else {
					respuesta = respUsandoNoImponible;
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
	
	public int removeTrabajadorNoImponible(TrabajadorNoImponible trabajadorNoImponible) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorNoImponible!=null) {
				TrabajadorNoImponibleDao trabajadorNoImponibleDao = DaoFactory.getInstance().getTrabajadorNoImponibleDao();
				trabajadorNoImponibleDao.makeTransient(trabajadorNoImponible);
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
	
	public int updateTrabajadorNoImponible(TrabajadorNoImponible trabajadorNoImponible, 
			Double monto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorNoImponible!=null) {
				TrabajadorNoImponibleDao trabajadorNoImponibleDao = DaoFactory.getInstance().getTrabajadorNoImponibleDao();
				trabajadorNoImponible = trabajadorNoImponibleDao.findById(trabajadorNoImponible.getIdTrabajadorNoImponible(), false);
				trabajadorNoImponible.setMonto(monto);
				trabajadorNoImponibleDao.makePersistent(trabajadorNoImponible);
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
	
	public ComboBoxModel getComboBoxModelNoImponible(TrabajadorCuenta cuenta) {
		List<NoImponible> list = new LinkedList<NoImponible>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			TrabajadorNoImponibleDao trabajadorNoImponibleDao = DaoFactory.getInstance().getTrabajadorNoImponibleDao();
			NoImponibleDao noImponibleDao = DaoFactory.getInstance().getNoImponibleDao();
			list = noImponibleDao.findByNoBloqueado();
			for (int i = 0; i < list.size(); i++) {
				if (trabajadorNoImponibleDao.findByTrabajadorCuentaNoImponible(cuenta, list.get(i))==null) {
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