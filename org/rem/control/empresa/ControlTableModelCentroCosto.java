package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.CentroCostoDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.TableModelCentroCosto;
import org.rem.model.CentroCosto;
import org.rem.model.EmpresaCuenta;

public class ControlTableModelCentroCosto {

	private TableModelCentroCosto model = null;

	public TableModelCentroCosto getTableModelCentroCosto(EmpresaCuenta empresaCuenta) {
		this.model = new TableModelCentroCosto();
		this.getCentroCostos(empresaCuenta);
		return model;
	}

	private void getCentroCostos(EmpresaCuenta empresaCuenta) {
		HibernateUtil.beginTransaction();
		List<CentroCosto> list = new LinkedList<CentroCosto>();
		try {
			CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
			list = ccDao.findByEmpresaCuenta(empresaCuenta);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((CentroCosto) list.get(i));
		}
	}

	private void addObject(CentroCosto object) {
		model.addObject(object);
	}

}