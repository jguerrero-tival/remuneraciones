package org.rem.dao.hibernate;

import org.rem.dao.ImpuestoDao;
import org.rem.model.Impuesto;
import org.rem.model.Mes;

import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class ImpuestoHibernateDao extends
		GenericHibernateDao<Impuesto, Long, ImpuestoDao> implements ImpuestoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Impuesto> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("fecha"));
		crit.addOrder(Order.asc("inicio"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Impuesto> findByMes(Mes mes) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("inicio"));
		crit.add(Expression.eq("mes", mes));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Impuesto> findByMesNoCasiFijo(Mes mes) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("inicio"));
		crit.add(Expression.eq("mes", mes));
		crit.add(Expression.eq("casiFijo", new Boolean(false)));
		return crit.list();
	}
	
	public Impuesto findByMesInicio(Mes mes, Double inicio) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.eq("mes", mes));
		crit.add(Expression.eq("inicio", inicio));
		return (Impuesto) crit.uniqueResult();
	}

}