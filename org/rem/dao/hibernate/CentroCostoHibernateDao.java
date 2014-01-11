package org.rem.dao.hibernate;

import org.rem.dao.CentroCostoDao;
import org.rem.model.CentroCosto;
import org.rem.model.EmpresaCuenta;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class CentroCostoHibernateDao extends GenericHibernateDao<CentroCosto, Long, CentroCostoDao> implements CentroCostoDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<CentroCosto> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("empresaCuenta"));
		crit.addOrder(Order.asc("numero"));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public List<CentroCosto> findByEmpresaCuenta(EmpresaCuenta empresaCuenta) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("numero"));
		crit.add(Expression.eq("empresaCuenta", empresaCuenta));
		return crit.list();
	}

	public CentroCosto findByEmpresaCuentaNumero(EmpresaCuenta empresaCuenta, Long numero) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.eq("empresaCuenta", empresaCuenta));
		crit.add(Expression.eq("numero", numero));
		return (CentroCosto) crit.uniqueResult();
	}
	
}