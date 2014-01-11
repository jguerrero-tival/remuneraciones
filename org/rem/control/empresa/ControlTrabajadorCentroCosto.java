package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import org.rem.dao.CentroCostoDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorCentroCostoDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.CentroCosto;
import org.rem.model.TrabajadorCentroCosto;
import org.rem.model.TrabajadorCuenta;

public class ControlTrabajadorCentroCosto {

	public int respExito = 0;
	
	public int respCerrada = 1;

	public int respExiste = 2;

	public int respNoExiste = 3;

	public int respNoExisteEmpresa = 4;
	
	public int respNoExisteMes = 5;
	
	public int respNoExisteCentroCosto = 6;
	
	public int respUsandoCentroCosto = 7;
	
	public int respNoExisteCuenta = 8;
	
	public int addTrabajadorCentroCosto(TrabajadorCuenta cuenta, Long numeroCentroCosto, 
			Double monto, Long horas, Double dt, Long he) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (cuenta!= null) {
				CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
				CentroCosto centroCosto = ccDao.findByEmpresaCuentaNumero(cuenta.getEmpresaCuenta(), numeroCentroCosto);
				if (centroCosto != null) {
					TrabajadorCentroCostoDao trabajadorCentroCostoDao = DaoFactory.getInstance().getTrabajadorCentroCostoDao();
					TrabajadorCentroCosto trabajadorCentroCosto = trabajadorCentroCostoDao.findByTrabajadorCuentaCentroCosto(cuenta, centroCosto);
					if (trabajadorCentroCosto==null) {
						trabajadorCentroCosto = new TrabajadorCentroCosto(monto, horas, dt, he, centroCosto);
						trabajadorCentroCosto.setTrabajadorCuenta(cuenta);
						trabajadorCentroCosto.setCentroCosto(centroCosto);
						trabajadorCentroCostoDao.makePersistent(trabajadorCentroCosto);
						respuesta = respExito;
					} else {
						respuesta = respExiste;
					}
				} else {
					respuesta = respUsandoCentroCosto;
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
	
	public int removeTrabajadorCentroCosto(TrabajadorCentroCosto trabajadorCentroCosto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorCentroCosto!= null) {
				TrabajadorCentroCostoDao trabajadorCentroCostoDao = DaoFactory.getInstance().getTrabajadorCentroCostoDao();
				trabajadorCentroCostoDao.makeTransient(trabajadorCentroCosto);
				respuesta = respExito;
			} else {
				respuesta = respNoExisteCuenta;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	public int updateTrabajadorCentroCosto(TrabajadorCentroCosto trabajadorCentroCosto,
			Double monto, Long horas, Double diasTrabajados, Long horasExtraordinarias) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorCentroCosto!=null) {
				TrabajadorCentroCostoDao trabajadorCentroCostoDao = DaoFactory.getInstance().getTrabajadorCentroCostoDao();
				trabajadorCentroCosto = trabajadorCentroCostoDao.findById(trabajadorCentroCosto.getIdTrabajadorCentroCosto(), false);
				trabajadorCentroCosto.setMonto(monto);
				trabajadorCentroCosto.setHoras(horas);
				trabajadorCentroCosto.setDiasTrabajados(diasTrabajados);
				trabajadorCentroCosto.setHorasExtraordinarias(horasExtraordinarias);
				trabajadorCentroCostoDao.makePersistent(trabajadorCentroCosto);
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
	
	public ComboBoxModel getComboBoxModelCentroCosto(TrabajadorCuenta cuenta) {
		List<CentroCosto> list = new LinkedList<CentroCosto>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
			list = ccDao.findByEmpresaCuenta(cuenta.getEmpresaCuenta());
			TrabajadorCentroCostoDao trabajadorCentroCostoDao = DaoFactory.getInstance().getTrabajadorCentroCostoDao();
			for (int i = 0; i < list.size(); i++) {
				if (trabajadorCentroCostoDao.findByTrabajadorCuentaCentroCosto(cuenta, list.get(i))==null) {
					model.addElement(list.get(i).getNumero());
				}
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return model;
	}
	
}