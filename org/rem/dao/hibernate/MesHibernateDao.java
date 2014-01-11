package org.rem.dao.hibernate;

import org.rem.dao.MesDao;
import org.rem.model.Mes;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class MesHibernateDao extends GenericHibernateDao<Mes, Long, MesDao>
		implements MesDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Mes> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("fecha"));
		return crit.list();
	}

	public Mes findByFecha(Date fecha) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("fecha", fecha));
		return (Mes) crit.uniqueResult();
	}

	public Mes findByLastMes() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("fecha"));
		crit.setMaxResults(1);
		return (Mes) crit.uniqueResult();
	}

}