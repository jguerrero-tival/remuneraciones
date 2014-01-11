package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaCuentaDao;
import org.rem.dao.MesDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.mes.TableModelMes;
import org.rem.model.Empresa;
import org.rem.model.Mes;

public class ControlTableModelEmpresaCuentaMes {

	private TableModelMes model = null;

	public TableModelMes getTableModelEmpresaCuentaMes(Empresa empresa) {
		this.model = new TableModelMes();
		this.getMeses(empresa);
		return model;
	}

	private void getMeses(Empresa empresa) {
		HibernateUtil.beginTransaction();
		List<Mes> list = new LinkedList<Mes>();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			list = mesDao.findAll();
			EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
			for (int i=list.size()-1; i>=0; i--) {
				if (empresaCuentaDao.existe(empresa, list.get(i)).booleanValue() ) {
					list.remove(i);
				}
			}
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