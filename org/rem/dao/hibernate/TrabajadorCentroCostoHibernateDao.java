package org.rem.dao.hibernate;

import org.rem.dao.TrabajadorCentroCostoDao;
import org.rem.model.CentroCosto;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorCentroCosto;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class TrabajadorCentroCostoHibernateDao extends
		GenericHibernateDao<TrabajadorCentroCosto, Long, TrabajadorCentroCostoDao> implements TrabajadorCentroCostoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<TrabajadorCentroCosto> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("trabajadorCuenta"));
		crit.addOrder(Order.desc("centroCosto"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrabajadorCentroCosto> findByTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("centroCosto"));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<TrabajadorCentroCosto> findByLastTrabajadorCuenta(Trabajador trabajador) {
		Criteria crit = getSession().createCriteria(TrabajadorCuenta.class);
		crit.addOrder(Order.desc("trabajadorCuenta"));
		crit.add(Expression.like("trabajador", trabajador));
		crit.setMaxResults(1);
		TrabajadorCuenta trabajadorCuenta = (TrabajadorCuenta) crit.uniqueResult();
		crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("centroCosto"));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public TrabajadorCentroCosto findByTrabajadorCuentaCentroCosto(TrabajadorCuenta trabajadorCuenta, CentroCosto centroCosto) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("centroCosto", centroCosto));
		crit.add(Expression.like("trabajadorCuenta", trabajadorCuenta));
		return (TrabajadorCentroCosto) crit.uniqueResult();
	}
	
	public Boolean isUsed(CentroCosto centroCosto) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("centroCosto", centroCosto));
		crit.setMaxResults(1);
		if (crit.list().size()>0) {
			return new Boolean(true);
		} else {
			return new Boolean(false);
		}
	}

}