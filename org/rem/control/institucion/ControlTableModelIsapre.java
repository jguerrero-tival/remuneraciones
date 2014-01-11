package org.rem.control.institucion;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.IsapreDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.institucion.TableModelIsapre;
import org.rem.model.Isapre;

public class ControlTableModelIsapre {

	private TableModelIsapre model = null;

	public TableModelIsapre getTableModelIsapre() {
		this.model = new TableModelIsapre();
		this.getIsapres();
		return model;
	}

	private void getIsapres() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			IsapreDao isapreDao = DaoFactory.getInstance().getIsapreDao();
			list = isapreDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Isapre) list.get(i));
		}
	}

	private void addObject(Isapre object) {
		model.addObject(object);
	}

}