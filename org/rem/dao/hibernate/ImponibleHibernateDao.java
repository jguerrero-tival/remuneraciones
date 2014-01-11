package org.rem.dao.hibernate;

import org.rem.dao.ImponibleDao;
import org.rem.model.Imponible;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class ImponibleHibernateDao extends
		GenericHibernateDao<Imponible, Long, ImponibleDao> implements
		ImponibleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Imponible> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		return crit.list();
	}

	public Imponible findByNombre(String nombre) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("nombre", nombre));
		return (Imponible) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Imponible> findByNoBloqueadoNoFijo() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		crit.add(Expression.like("fijo", new Boolean(false)));
		crit.add(Expression.like("colegio", new Boolean(false)));
		return crit.list();
	}

}