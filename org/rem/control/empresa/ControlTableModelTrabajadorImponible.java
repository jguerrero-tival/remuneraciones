package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.TableModelTrabajadorImponible;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorImponible;

public class ControlTableModelTrabajadorImponible {

	private TableModelTrabajadorImponible model = null;

	public TableModelTrabajadorImponible getTableModelTrabajadorImponible(TrabajadorCuenta trabajadorCuenta) {
		this.model = new TableModelTrabajadorImponible();
		this.getTrabajadorImponibles(trabajadorCuenta);
		return model;
	}

	private void getTrabajadorImponibles(TrabajadorCuenta trabajadorCuenta) {
		HibernateUtil.beginTransaction();
		List<TrabajadorImponible> list = new LinkedList<TrabajadorImponible>();
		try {
			if(trabajadorCuenta!=null) {
				TrabajadorImponibleDao trabajadorImponibleDao = DaoFactory.getInstance().getTrabajadorImponibleDao();
				list = trabajadorImponibleDao.findByTrabajadorCuenta(trabajadorCuenta);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((TrabajadorImponible) list.get(i));
		}
	}

	private void addObject(TrabajadorImponible object) {
		model.addObject(object);
	}

}