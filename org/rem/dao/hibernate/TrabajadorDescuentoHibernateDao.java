package org.rem.dao.hibernate;

import org.rem.dao.TrabajadorDescuentoDao;
import org.rem.model.Descuento;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorDescuento;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class TrabajadorDescuentoHibernateDao extends
		GenericHibernateDao<TrabajadorDescuento, Long, TrabajadorDescuentoDao> implements TrabajadorDescuentoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajadorDescuento> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("trabajadorCuenta"));
		crit.addOrder(Order.desc("descuento"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrabajadorDescuento> findByTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("descuento"));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrabajadorDescuento> findByLastTrabajadorCuenta(Trabajador trabajador) {
		Criteria crit = getSession().createCriteria(TrabajadorCuenta.class);
		crit.addOrder(Order.desc("trabajadorCuenta"));
		crit.add(Expression.like("trabajador", trabajador));
		crit.setMaxResults(1);
		TrabajadorCuenta trabajadorCuenta = (TrabajadorCuenta) crit.uniqueResult();
		crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("descuento"));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public TrabajadorDescuento findByTrabajadorCuentaDescuento(TrabajadorCuenta trabajadorCuenta, Descuento descuento) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("descuento", descuento));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return (TrabajadorDescuento) crit.uniqueResult();
	}

}