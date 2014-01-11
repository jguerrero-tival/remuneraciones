package org.rem.dao.hibernate;

import org.rem.dao.AfpDao;
import org.rem.model.Afp;
import org.rem.model.Mes;

import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class AfpHibernateDao extends GenericHibernateDao<Afp, Long, AfpDao>
		implements AfpDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Afp> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("fecha"));
		crit.addOrder(Order.asc("nombre"));
		return crit.list();
	}

	public Afp findByMesNombre(Mes mes, String nombre) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("mes", mes));
		crit.add(Expression.like("nombre", nombre));
		return (Afp) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Afp> findByNoBloqueadoMes(Mes mes) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("mes", mes));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<Afp> findByMes(Mes mes) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("mes", mes));
		return crit.list();
	}

}