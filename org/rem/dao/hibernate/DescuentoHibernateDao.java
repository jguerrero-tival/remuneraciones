package org.rem.dao.hibernate;

import org.rem.dao.DescuentoDao;
import org.rem.model.Descuento;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class DescuentoHibernateDao extends
		GenericHibernateDao<Descuento, Long, DescuentoDao> implements
		DescuentoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Descuento> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		return crit.list();
	}

	public Descuento findByNombre(String nombre) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("nombre", nombre));
		return (Descuento) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Descuento> findByNoBloqueadoNoFijo() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		crit.add(Expression.like("fijo", new Boolean(false)));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Descuento> findByNoBloqueado() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		return crit.list();
	}

}