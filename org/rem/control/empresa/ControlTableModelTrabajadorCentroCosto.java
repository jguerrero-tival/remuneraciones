package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorCentroCostoDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.TableModelTrabajadorCentroCosto;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorCentroCosto;

public class ControlTableModelTrabajadorCentroCosto {

	private TableModelTrabajadorCentroCosto model = null;

	public TableModelTrabajadorCentroCosto getTableModelTrabajadorCentroCosto(TrabajadorCuenta trabajadorCuenta) {
		this.model = new TableModelTrabajadorCentroCosto();
		this.getTrabajadorCentroCostos(trabajadorCuenta);
		return model;
	}

	private void getTrabajadorCentroCostos(TrabajadorCuenta trabajadorCuenta) {
		HibernateUtil.beginTransaction();
		List<TrabajadorCentroCosto> list = new LinkedList<TrabajadorCentroCosto>();
		try {
			if(trabajadorCuenta!=null) {
				TrabajadorCentroCostoDao trabajadorCentroCostoDao = DaoFactory.getInstance().getTrabajadorCentroCostoDao();
				list = trabajadorCentroCostoDao.findByTrabajadorCuenta(trabajadorCuenta);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((TrabajadorCentroCosto) list.get(i));
		}
	}

	private void addObject(TrabajadorCentroCosto object) {
		model.addObject(object);
	}

}