package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import org.rem.dao.DaoFactory;
import org.rem.dao.TrabajadorDescuentoDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.gui.empresa.TableModelTrabajadorDescuento;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorDescuento;

public class ControlTableModelTrabajadorDescuento {

	private TableModelTrabajadorDescuento model = null;

	public TableModelTrabajadorDescuento getTableModelTrabajadorDescuento(TrabajadorCuenta trabajadorCuenta) {
		this.model = new TableModelTrabajadorDescuento();
		this.getTrabajadorDescuentos(trabajadorCuenta);
		return model;
	}

	private void getTrabajadorDescuentos(TrabajadorCuenta trabajadorCuenta) {
		HibernateUtil.beginTransaction();
		List<TrabajadorDescuento> list = new LinkedList<TrabajadorDescuento>();
		try {
			if(trabajadorCuenta!=null) {
				TrabajadorDescuentoDao trabajadorDescuentoDao = DaoFactory.getInstance().getTrabajadorDescuentoDao();
				list = trabajadorDescuentoDao.findByTrabajadorCuenta(trabajadorCuenta);
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			this.addObject((TrabajadorDescuento) list.get(i));
		}
	}

	private void addObject(TrabajadorDescuento object) {
		model.addObject(object);
	}

}