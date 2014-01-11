package org.rem.control.haberDescuento;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.DescuentoDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.haberDescuento.TableModelDescuento;
import org.rem.model.Descuento;

public class ControlTableModelDescuento {

	private TableModelDescuento model = null;

	public TableModelDescuento getTableModelDescuento() {
		this.model = new TableModelDescuento();
		this.getDescuentos();
		return model;
	}

	private void getDescuentos() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			DescuentoDao descuentoDao = DaoFactory.getInstance().getDescuentoDao();
			list = descuentoDao.findByNoBloqueadoNoFijo();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Descuento) list.get(i));
		}
	}

	private void addObject(Descuento object) {
		model.addObject(object);
	}

}