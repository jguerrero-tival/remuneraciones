package org.rem.informes;

import java.util.LinkedList;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import org.rem.dao.CentroCostoDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.RegistroAfpDao;
import org.rem.dao.RegistroIsapreDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.CentroCosto;
import org.rem.model.EmpresaCuenta;
import org.rem.model.informes.RegistroAfp;
import org.rem.model.informes.RegistroIsapre;

public class UtilInformes {
	
	public static DefaultComboBoxModel getComboBoxModelIsapre() {
		List<RegistroIsapre> list = new LinkedList<RegistroIsapre>();
		DefaultComboBoxModel combo = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			RegistroIsapreDao dao = DaoFactory.getInstance().getRegistroIsapreDao();
			list = dao.findAll();
			for (int i=0; i<list.size(); i++) {
				RegistroIsapre r = list.get(i);
				boolean flag = true;
				for (int j=0; j<combo.getSize(); j++) {
					if (combo.getElementAt(j).equals(r.getNombreIsapre())) {
						flag = false;
						break;
					}
				}
				if (flag) {
					combo.addElement(r.getNombreIsapre());
				}
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return combo;		
	}
	
	public static DefaultComboBoxModel getComboBoxModelAfp() {
		List<RegistroAfp> list = new LinkedList<RegistroAfp>();
		DefaultComboBoxModel combo = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			RegistroAfpDao dao = DaoFactory.getInstance().getRegistroAfpDao();
			list = dao.findAll();
			for (int i=0; i<list.size(); i++) {
				RegistroAfp r = list.get(i);
				boolean flag = true;
				for (int j=0; j<combo.getSize(); j++) {
					if (combo.getElementAt(j).equals(r.getNombreAfp())) {
						flag = false;
						break;
					}
				}
				if (flag) {
					combo.addElement(r.getNombreAfp());
				}
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return combo;		
	}
	
	public static ComboBoxModel getComboBoxModelCentroCosto(EmpresaCuenta cuenta) {
		List<CentroCosto> list = new LinkedList<CentroCosto>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
			list = ccDao.findByEmpresaCuenta(cuenta);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		model.addElement("TODOS");
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNumero().toString());
		}
		return model;
	}
	
	public static String getCentroCostoNombre(EmpresaCuenta cuenta, Long cc) {
		String nombreCC = "";
		HibernateUtil.beginTransaction();
		try {
			CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
			nombreCC = ccDao.findByEmpresaCuentaNumero(cuenta, cc).getNombre();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return nombreCC;
	}

}
