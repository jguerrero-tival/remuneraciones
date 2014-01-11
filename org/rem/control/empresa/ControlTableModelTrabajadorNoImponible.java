package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorNoImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.TableModelTrabajadorNoImponible;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorNoImponible;

public class ControlTableModelTrabajadorNoImponible {

	private TableModelTrabajadorNoImponible model = null;

	public TableModelTrabajadorNoImponible getTableModelTrabajadorNoImponible(TrabajadorCuenta trabajadorCuenta) {
		this.model = new TableModelTrabajadorNoImponible();
		this.getTrabajadorNoImponibles(trabajadorCuenta);
		return model;
	}

	private void getTrabajadorNoImponibles(TrabajadorCuenta trabajadorCuenta) {
		HibernateUtil.beginTransaction();
		List<TrabajadorNoImponible> list = new LinkedList<TrabajadorNoImponible>();
		try {
			if(trabajadorCuenta!=null) {
				TrabajadorNoImponibleDao trabajadorNoImponibleDao = DaoFactory.getInstance().getTrabajadorNoImponibleDao();
				list = trabajadorNoImponibleDao.findByTrabajadorCuenta(trabajadorCuenta);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((TrabajadorNoImponible) list.get(i));
		}
	}

	private void addObject(TrabajadorNoImponible object) {
		model.addObject(object);
	}

}