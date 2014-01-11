package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.DescuentoDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorDescuentoDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Descuento;
import org.rem.model.TrabajadorDescuento;
import org.rem.model.TrabajadorCuenta;

public class ControlTrabajadorDescuento {

	public int respExito = 0;
	
	public int respCerrada = 1;

	public int respExiste = 2;

	public int respNoExiste = 3;

	public int respNoExisteEmpresa = 4;
	
	public int respNoExisteMes = 5;
	
	public int respNoExisteDescuento = 6;
	
	public int respUsandoDescuento = 7;
	
	public int respNoExisteCuenta = 8;
	
	public int addTrabajadorDescuento(TrabajadorCuenta cuenta, String nombreDescuento, Double monto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (cuenta!= null) {
				DescuentoDao descuentoDao = DaoFactory.getInstance().getDescuentoDao();
				Descuento descuento = descuentoDao.findByNombre(nombreDescuento);
				if (descuento != null) {
					TrabajadorDescuentoDao trabajadorDescuentoDao = DaoFactory.getInstance().getTrabajadorDescuentoDao();
					TrabajadorDescuento trabajadorDescuento = trabajadorDescuentoDao.findByTrabajadorCuentaDescuento(cuenta, descuento);
					if (trabajadorDescuento==null) {
						trabajadorDescuento = new TrabajadorDescuento(monto, descuento);
						trabajadorDescuento.setTrabajadorCuenta(cuenta);
						trabajadorDescuento.setDescuento(descuento);
						trabajadorDescuentoDao.makePersistent(trabajadorDescuento);
						respuesta = respExito;
					} else {
						respuesta = respExiste;
					}
				} else {
					respuesta = respUsandoDescuento;
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
	
	public int removeTrabajadorDescuento(TrabajadorDescuento trabajadorDescuento) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorDescuento!=null) {
				TrabajadorDescuentoDao trabajadorDescuentoDao = DaoFactory.getInstance().getTrabajadorDescuentoDao();
				trabajadorDescuentoDao.makeTransient(trabajadorDescuento);
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
	
	public int updateTrabajadorDescuento(TrabajadorDescuento trabajadorDescuento, 
			Double monto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorDescuento!=null) {
				TrabajadorDescuentoDao trabajadorDescuentoDao = DaoFactory.getInstance().getTrabajadorDescuentoDao();
				trabajadorDescuento = trabajadorDescuentoDao.findById(trabajadorDescuento.getIdTrabajadorDescuento(), false);
				trabajadorDescuento.setMonto(monto);
				trabajadorDescuentoDao.makePersistent(trabajadorDescuento);
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
	
	public ComboBoxModel getComboBoxModelDescuento(TrabajadorCuenta cuenta) {
		List<Descuento> list = new LinkedList<Descuento>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			DescuentoDao descuentoDao = DaoFactory.getInstance().getDescuentoDao();
			list = descuentoDao.findByNoBloqueado();
			TrabajadorDescuentoDao trabajadorDescuentoDao = DaoFactory.getInstance().getTrabajadorDescuentoDao();
			for (int i = 0; i < list.size(); i++) {
				if (trabajadorDescuentoDao.findByTrabajadorCuentaDescuento(cuenta, list.get(i))==null) {
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