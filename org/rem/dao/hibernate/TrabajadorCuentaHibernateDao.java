package org.rem.dao.hibernate;

import org.rem.dao.TrabajadorCuentaDao;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class TrabajadorCuentaHibernateDao extends
		GenericHibernateDao<TrabajadorCuenta, Long, TrabajadorCuentaDao> implements TrabajadorCuentaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajadorCuenta> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("trabajador"));
		crit.addOrder(Order.asc("empresaCuenta"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public TrabajadorCuenta findByTrabajadorEmpresaCuenta(Trabajador trabajador, EmpresaCuenta empresaCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("trabajador", trabajador));
		crit.add(Expression.like("empresaCuenta", empresaCuenta));
		return (TrabajadorCuenta) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<TrabajadorCuenta> findByEmpresaCuenta(EmpresaCuenta empresaCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("trabajador"));
		crit.add(Expression.like("empresaCuenta", empresaCuenta));
		return crit.list();
	}

	/*
	@SuppressWarnings("unchecked")
	public List<TrabajadorCuenta> findByEmpresaCuentaNoBloquado(EmpresaCuenta empresaCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("trabajador"));
		crit.add(Expression.like("empresaCuenta", empresaCuenta));
		crit.add(Expression.like("bloquado", Boolean.FALSE));
		return crit.list();
	}
	*/
	
	@SuppressWarnings("unchecked")
	public Boolean existe(Trabajador trabajador, EmpresaCuenta empresaCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("trabajador", trabajador));
		crit.add(Expression.like("empresaCuenta", empresaCuenta));
		crit.setMaxResults(1);
		List<TrabajadorCuenta> list = crit.list();
		if (list.size()==1) {
			return new Boolean(true);
		} else {
			return new Boolean(false);
		}
	}
	
	@SuppressWarnings("unchecked")
	public TrabajadorCuenta findByTrabajadorLast(Trabajador trabajador) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("empresaCuenta"));
		crit.add(Expression.like("trabajador", trabajador));
		crit.setMaxResults(1);
		return (TrabajadorCuenta) crit.uniqueResult();
	}

}