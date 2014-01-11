package org.rem.control.otro;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.MonedaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.otro.TableModelMoneda;
import org.rem.model.Moneda;

public class ControlTableModelMoneda {

	private TableModelMoneda model = null;

	public TableModelMoneda getTableModelMoneda() {
		this.model = new TableModelMoneda();
		this.getMonedas();
		return model;
	}

	private void getMonedas() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			MonedaDao monedaDao = DaoFactory.getInstance().getMonedaDao();
			list = monedaDao.findAll();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Moneda) list.get(i));
		}
	}

	private void addObject(Moneda object) {
		model.addObject(object);
	}

}