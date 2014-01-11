package org.rem.dao.hibernate;

import org.rem.dao.CajaDao;
import org.rem.model.Caja;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class CajaHibernateDao extends GenericHibernateDao<Caja, Long, CajaDao>
		implements CajaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Caja> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		return crit.list();
	}

	public Caja findByNombre(String nombre) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("nombre", nombre));
		return (Caja) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Caja> findByNoBloqueado() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		return crit.list();
	}

}