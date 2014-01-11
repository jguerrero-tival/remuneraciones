package org.rem.control.mes;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.MesDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.mes.TableModelMes;
import org.rem.model.Mes;

public class ControlTableModelMes {

	private TableModelMes model = null;

	public TableModelMes getTableModelMes() {
		this.model = new TableModelMes();
		this.getMeses();
		return model;
	}

	private void getMeses() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			list = mesDao.findAll();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Mes) list.get(i));
		}
	}

	private void addObject(Mes object) {
		model.addObject(object);
	}

}