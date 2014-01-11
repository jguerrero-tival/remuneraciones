package org.rem.dao.hibernate;

import org.rem.dao.MutualDao;
import org.rem.model.Mutual;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class MutualHibernateDao extends GenericHibernateDao<Mutual, Long, MutualDao>
		implements MutualDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Mutual> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		return crit.list();
	}

	public Mutual findByNombre(String nombre) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("nombre", nombre));
		return (Mutual) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Mutual> findByNoBloqueado() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		return crit.list();
	}

}