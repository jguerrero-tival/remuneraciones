package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorCuentaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.TableModelTrabajador;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;

public class ControlTableModelTrabajador {

	private TableModelTrabajador model = null;

	public TableModelTrabajador getTableModelTrabajador(EmpresaCuenta empresaCuenta) {
		this.model = new TableModelTrabajador();
		this.getTrabajadores(empresaCuenta);
		return model;
	}

	private void getTrabajadores(EmpresaCuenta empresaCuenta) {
		HibernateUtil.beginTransaction();
		List<Trabajador> list = new LinkedList<Trabajador>();
		List<TrabajadorCuenta> listCuenta = new LinkedList<TrabajadorCuenta>();
		try {
			if (empresaCuenta!=null) {
				TrabajadorCuentaDao trabajadorCuentaDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
				listCuenta = trabajadorCuentaDao.findByEmpresaCuenta(empresaCuenta);
				for (int i = 0; i < listCuenta.size(); i++) {
					list.add(listCuenta.get(i).getTrabajador());
				}		
				HibernateUtil.commitTransaction();
			}
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Trabajador) list.get(i));
		}
	}

	private void addObject(Trabajador object) {
		model.addObject(object);
	}

}