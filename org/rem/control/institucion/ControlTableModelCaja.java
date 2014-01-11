package org.rem.control.institucion;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.CajaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.institucion.TableModelCaja;
import org.rem.model.Caja;

public class ControlTableModelCaja {

	private TableModelCaja model = null;

	public TableModelCaja getTableModelCaja() {
		this.model = new TableModelCaja();
		this.getCajas();
		return model;
	}

	private void getCajas() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
			list = cajaDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Caja) list.get(i));
		}
	}

	private void addObject(Caja object) {
		model.addObject(object);
	}

}