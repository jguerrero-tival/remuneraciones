package org.rem.dao.hibernate;

import org.rem.dao.TrabajadorImponibleDao;
import org.rem.model.Imponible;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorImponible;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class TrabajadorImponibleHibernateDao extends
		GenericHibernateDao<TrabajadorImponible, Long, TrabajadorImponibleDao> implements TrabajadorImponibleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajadorImponible> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("trabajadorCuenta"));
		crit.addOrder(Order.desc("imponible"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrabajadorImponible> findByTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("imponible"));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrabajadorImponible> findByLastTrabajadorCuenta(Trabajador trabajador) {
		Criteria crit = getSession().createCriteria(TrabajadorCuenta.class);
		crit.addOrder(Order.desc("trabajadorCuenta"));
		crit.add(Expression.like("trabajador", trabajador));
		crit.setMaxResults(1);
		TrabajadorCuenta trabajadorCuenta = (TrabajadorCuenta) crit.uniqueResult();
		crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("imponible"));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public TrabajadorImponible findByTrabajadorCuentaImponible(TrabajadorCuenta trabajadorCuenta, Imponible imponible) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("imponible", imponible));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return (TrabajadorImponible) crit.uniqueResult();
	}
	
}