package org.rem.control.mes;

import java.util.Date;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.ImpuestoDao;
import org.rem.dao.MesDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.mes.TableModelImpuesto;
import org.rem.model.Impuesto;
import org.rem.model.Mes;

public class ControlTableModelImpuesto {

	private TableModelImpuesto model = null;

	public TableModelImpuesto getTableModelImpuesto(Date fecha) {
		this.model = new TableModelImpuesto();
		this.getImpuestos(fecha);
		return model;
	}

	private void getImpuestos(Date fecha) {
		HibernateUtil.beginTransaction();
		List<Impuesto> list;
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
			list = impuestoDao.findByMes(mes);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Impuesto) list.get(i));
		}
	}

	private void addObject(Impuesto object) {
		model.addObject(object);
	}

}