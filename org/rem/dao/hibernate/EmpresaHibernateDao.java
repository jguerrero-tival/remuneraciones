package org.rem.dao.hibernate;

import org.rem.dao.EmpresaDao;
import org.rem.model.Empresa;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class EmpresaHibernateDao extends
		GenericHibernateDao<Empresa, Long, EmpresaDao> implements EmpresaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Empresa> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutEmpresa"));
		return crit.list();
	}

	public Empresa findByRutEmpresa(String rutEmpresa) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("rutEmpresa", rutEmpresa));
		return (Empresa) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Empresa> findByNoBloqueado() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutEmpresa"));
		crit.add(Expression.like("bloqueado", new Boolean(false)));
		return crit.list();
	}

	public Boolean isBloqueado(String rutEmpresa) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("rutEmpresa", rutEmpresa));
		crit.setMaxResults(1);
		if (crit.list().size()==1) {
			if (((Empresa)crit.list().get(0)).isBloqueado().booleanValue()) {
				return new Boolean(true);
			}
		} 
		return new Boolean(false);
	}
}