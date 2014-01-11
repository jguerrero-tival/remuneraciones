package org.rem.dao.hibernate;

import org.rem.dao.IsapreDao;
import org.rem.model.Isapre;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class IsapreHibernateDao extends GenericHibernateDao<Isapre, Long, IsapreDao>
		implements IsapreDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Isapre> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		return crit.list();
	}

	public Isapre findByNombre(String nombre) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("nombre", nombre));
		return (Isapre) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Isapre> findByNoBloqueado() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("nombre"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		return crit.list();
	}

}