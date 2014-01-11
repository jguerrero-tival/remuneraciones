package org.rem.control.haberDescuento;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.NoImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.haberDescuento.TableModelNoImponible;
import org.rem.model.NoImponible;

public class ControlTableModelNoImponible {

	private TableModelNoImponible model = null;

	public TableModelNoImponible getTableModelNoImponible() {
		this.model = new TableModelNoImponible();
		this.getNoImponibles();
		return model;
	}

	private void getNoImponibles() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			NoImponibleDao noImponibleDao = DaoFactory.getInstance().getNoImponibleDao();
			list = noImponibleDao.findByNoBloqueadoNoFijo();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((NoImponible) list.get(i));
		}
	}

	private void addObject(NoImponible object) {
		model.addObject(object);
	}

}