package org.rem.dao.hibernate;

import org.rem.dao.MonedaDao;
import org.rem.model.Moneda;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class MonedaHibernateDao extends
		GenericHibernateDao<Moneda, Long, MonedaDao> implements MonedaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Moneda> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("valor"));
		return crit.list();
	}

	public Moneda findByValor(Double valor) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("valor", valor));
		return (Moneda) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Moneda> findByNoFijo() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("valor"));
		crit.add(Expression.like("fijo", new Boolean(false)));
		return crit.list();
	}

}