package org.rem.dao.hibernate;

import org.rem.dao.EmpresaCuentaDao;
import org.rem.model.Empresa;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Mes;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class EmpresaCuentaHibernateDao extends
		GenericHibernateDao<EmpresaCuenta, Long, EmpresaCuentaDao> implements EmpresaCuentaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<EmpresaCuenta> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("empresa"));
		crit.addOrder(Order.desc("mes"));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<EmpresaCuenta> findByEmpresa(Empresa empresa) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("mes"));
		crit.add(Expression.like("empresa", empresa));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public EmpresaCuenta findByEmpresaMes(Empresa empresa, Mes mes) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("empresa", empresa));
		crit.add(Expression.like("mes", mes));
		return (EmpresaCuenta) crit.uniqueResult();
	}
	
	@SuppressWarnings("unchecked")
	public List<EmpresaCuenta> findByEmpresaCerrada(Empresa empresa) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("mes"));
		crit.add(Expression.like("empresa", empresa));
		crit.add(Expression.like("cerrada", new Boolean(true)));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<EmpresaCuenta> findByEmpresaNoCerrada(Empresa empresa) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("mes"));
		crit.add(Expression.like("empresa", empresa));
		crit.add(Expression.like("cerrada", new Boolean(false)));
		return crit.list();
	}
	
	@SuppressWarnings("unchecked")
	public Boolean existe(Empresa empresa, Mes mes) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("empresa", empresa));
		crit.add(Expression.like("mes", mes));
		crit.setMaxResults(1);
		List<EmpresaCuenta> list = crit.list();
		if (list.size()==1) {
			return new Boolean(true);
		} else {
			return new Boolean(false);
		}
	}
	
	@SuppressWarnings("unchecked")
	public EmpresaCuenta findByEmpresaLast(Empresa empresa) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.desc("mes"));
		crit.add(Expression.like("empresa", empresa));
		crit.setMaxResults(1);
		return (EmpresaCuenta) crit.uniqueResult();
	}

}