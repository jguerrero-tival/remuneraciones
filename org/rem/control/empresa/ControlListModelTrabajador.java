package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaDao;
import org.rem.dao.TrabajadorDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.ListModelTrabajador;
import org.rem.model.Empresa;
import org.rem.model.Trabajador;

public class ControlListModelTrabajador {

	private ListModelTrabajador model = null;

	public ListModelTrabajador getListModelTrabajador(Empresa empresa) {
		this.model = new ListModelTrabajador();
		this.getTrabajadores(empresa);
		return model;
	}

	private void getTrabajadores(Empresa empresa) {
		HibernateUtil.beginTransaction();
		List<Trabajador> list = new LinkedList<Trabajador>();
		try {
			EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
			empresa = empresaDao.findByRutEmpresa(empresa.getRutEmpresa());
			if(empresa!=null) {
				TrabajadorDao trabajadorDao = DaoFactory.getInstance().getTrabajadorDao();
				list = trabajadorDao.findByEmpresaNoBloqueado(empresa);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((Trabajador) list.get(i));
		}
	}

	private void addObject(Trabajador object) {
		model.addObject(object);
	}

}