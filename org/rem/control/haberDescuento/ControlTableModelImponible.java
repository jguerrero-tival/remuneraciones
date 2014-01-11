package org.rem.control.haberDescuento;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.ImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.haberDescuento.TableModelImponible;
import org.rem.model.Imponible;

public class ControlTableModelImponible {

	private TableModelImponible model = null;

	public TableModelImponible getTableModelImponible() {
		this.model = new TableModelImponible();
		this.getImponibles();
		return model;
	}

	private void getImponibles() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			ImponibleDao imponibleDao = DaoFactory.getInstance().getImponibleDao();
			list = imponibleDao.findByNoBloqueadoNoFijo();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Imponible) list.get(i));
		}
	}

	private void addObject(Imponible object) {
		model.addObject(object);
	}

}