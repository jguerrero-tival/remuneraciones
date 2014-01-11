package org.rem.dao.hibernate;

import org.rem.dao.AsignacionDao;
import org.rem.model.Asignacion;
import org.rem.model.Mes;

import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class AsignacionHibernateDao extends
		GenericHibernateDao<Asignacion, Long, AsignacionDao> implements
		AsignacionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Asignacion> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("fecha"));
		crit.addOrder(Order.asc("inicio"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Asignacion> findByMes(Mes mes) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("inicio"));
		crit.add(Expression.eq("mes", mes));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Asignacion> findByMesNoCasiFijo(Mes mes) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("inicio"));
		crit.add(Expression.eq("mes", mes));
		crit.add(Expression.eq("casiFijo", new Boolean(false)));
		return crit.list();
	}

	public Asignacion findByMesInicio(Mes mes, Double inicio) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.eq("mes", mes));
		crit.add(Expression.eq("inicio", inicio));
		return (Asignacion) crit.uniqueResult();
	}

}