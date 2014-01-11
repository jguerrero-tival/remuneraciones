package org.rem.control.mes;

import java.util.Date;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.AsignacionDao;
import org.rem.dao.MesDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.mes.TableModelAsignacion;
import org.rem.model.Asignacion;
import org.rem.model.Mes;

public class ControlTableModelAsignacion {

	private TableModelAsignacion model = null;

	public TableModelAsignacion getTableModelAsignacion(Date fecha) {
		this.model = new TableModelAsignacion();
		this.getAsignacions(fecha);
		return model;
	}

	private void getAsignacions(Date fecha) {
		HibernateUtil.beginTransaction();
		List<Asignacion> list;
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(fecha);
			AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
			list = asignacionDao.findByMes(mes);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Asignacion) list.get(i));
		}
	}

	private void addObject(Asignacion object) {
		model.addObject(object);
	}

}