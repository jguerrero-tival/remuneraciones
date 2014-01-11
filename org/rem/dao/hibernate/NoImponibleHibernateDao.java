package org.rem.dao.hibernate;

import org.rem.dao.NoImponibleDao;
import org.rem.model.NoImponible;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class NoImponibleHibernateDao extends
		GenericHibernateDao<NoImponible, Long, NoImponibleDao> implements
		NoImponibleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<NoImponible> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		return crit.list();
	}

	public NoImponible findByNombre(String nombre) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("nombre", nombre));
		return (NoImponible) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<NoImponible> findByNoBloqueadoNoFijo() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		crit.add(Expression.like("fijo", new Boolean(false)));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<NoImponible> findByNoBloqueado() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		return crit.list();
	}

}