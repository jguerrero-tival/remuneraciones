package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaCuentaDao;
import org.rem.dao.EmpresaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.TableModelEmpresaCuenta;
import org.rem.model.Empresa;
import org.rem.model.EmpresaCuenta;

public class ControlTableModelEmpresaCuenta {

	private TableModelEmpresaCuenta model = null;

	public TableModelEmpresaCuenta getTableModelEmpresaCuenta(Empresa empresa) {
		this.model = new TableModelEmpresaCuenta();
		this.getEmpresaCuentas(empresa);
		return model;
	}

	private void getEmpresaCuentas(Empresa empresa) {
		HibernateUtil.beginTransaction();
		List<EmpresaCuenta> list = new LinkedList<EmpresaCuenta>();
		try {
			EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
			empresa = empresaDao.findByRutEmpresa(empresa.getRutEmpresa());
			if(empresa!=null) {
				EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
				list = empresaCuentaDao.findByEmpresa(empresa);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((EmpresaCuenta) list.get(i));
		}
	}

	private void addObject(EmpresaCuenta object) {
		model.addObject(object);
	}

}