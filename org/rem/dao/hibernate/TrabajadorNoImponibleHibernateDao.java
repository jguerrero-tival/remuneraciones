package org.rem.dao.hibernate;

import org.rem.dao.TrabajadorNoImponibleDao;
import org.rem.model.NoImponible;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorNoImponible;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class TrabajadorNoImponibleHibernateDao extends
		GenericHibernateDao<TrabajadorNoImponible, Long, TrabajadorNoImponibleDao> implements TrabajadorNoImponibleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajadorNoImponible> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("trabajadorCuenta"));
		crit.addOrder(Order.desc("noImponible"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrabajadorNoImponible> findByTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("noImponible"));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrabajadorNoImponible> findByLastTrabajadorCuenta(Trabajador trabajador) {
		Criteria crit = getSession().createCriteria(TrabajadorCuenta.class);
		crit.addOrder(Order.desc("trabajadorCuenta"));
		crit.add(Expression.like("trabajador", trabajador));
		crit.setMaxResults(1);
		TrabajadorCuenta trabajadorCuenta = (TrabajadorCuenta) crit.uniqueResult();
		crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("noImponible"));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public TrabajadorNoImponible findByTrabajadorCuentaNoImponible(TrabajadorCuenta trabajadorCuenta, NoImponible noImponible) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("noImponible", noImponible));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return (TrabajadorNoImponible) crit.uniqueResult();
	}
	
}