package org.rem.control.institucion;

import java.util.Date;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.AfpDao;
import org.rem.dao.MesDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.institucion.TableModelAfp;
import org.rem.model.Afp;
import org.rem.model.Mes;

public class ControlTableModelAfp {

	private TableModelAfp model = null;

	public TableModelAfp getTableModelAfp(Date fecha) {
		this.model = new TableModelAfp();
		this.getAfps(fecha);
		return model;
	}

	private void getAfps(Date fecha) {
		HibernateUtil.beginTransaction();
		List<Afp> list;
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
			list = afpDao.findByNoBloqueadoMes(mes);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Afp) list.get(i));
		}
	}

	private void addObject(Afp object) {
		model.addObject(object);
	}

}