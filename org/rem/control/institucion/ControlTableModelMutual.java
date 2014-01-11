package org.rem.control.institucion;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.MutualDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.institucion.TableModelMutual;
import org.rem.model.Mutual;

public class ControlTableModelMutual {

	private TableModelMutual model = null;

	public TableModelMutual getTableModelMutual() {
		this.model = new TableModelMutual();
		this.getMutuals();
		return model;
	}

	private void getMutuals() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
			list = mutualDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Mutual) list.get(i));
		}
	}

	private void addObject(Mutual object) {
		model.addObject(object);
	}

}