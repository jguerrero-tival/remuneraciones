package org.rem.control.empresa;

import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.ListModelEmpresa;
import org.rem.model.Empresa;

public class ControlListModelEmpresa {

	private ListModelEmpresa model = null;

	public ListModelEmpresa getListModelEmpresa() {
		this.model = new ListModelEmpresa();
		this.getEmpresas();
		return model;
	}

	private void getEmpresas() {
		HibernateUtil.beginTransaction();
		List list;
		try {
			EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
			list = empresaDao.findByNoBloqueado();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Empresa) list.get(i));
		}
	}

	private void addObject(Empresa object) {
		model.addObject(object);
	}

}