package org.rem.dao.hibernate;

import org.rem.dao.TrabajadorDao;
import org.rem.model.Empresa;
import org.rem.model.Trabajador;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Order;

public class TrabajadorHibernateDao extends
		GenericHibernateDao<Trabajador, Long, TrabajadorDao> implements
		TrabajadorDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<Trabajador> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("empresa"));
		crit.addOrder(Order.asc("datosPersonales"));
		return crit.list();
	}

	public Trabajador findByEmpresaRutTrabajador(Empresa empresa, String rutTrabajador) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.eq("empresa", empresa));
		crit.add(Expression.eq("datosPersonales.rut", rutTrabajador));
		return (Trabajador) crit.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	public List<Trabajador> findByEmpresa(Empresa empresa) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("datosPersonales.rut"));
		crit.add(Expression.eq("empresa", empresa));
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	public List<Trabajador> findByEmpresaNoBloqueado(Empresa empresa) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("datosPersonales.rut"));
		crit.add(Expression.eq("empresa", empresa));
		crit.add(Expression.eq("bloqueado", new Boolean(false)));
		return crit.list();
	}
	
	public Boolean isBloqueado(Empresa empresa, String rutTrabajador) {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.add(Expression.like("empresa", empresa));
		crit.add(Expression.like("datosPersonales.rut", rutTrabajador));
		crit.setMaxResults(1);
		if (crit.list().size()==1) {
			if (((Trabajador)crit.list().get(0)).isBloqueado().booleanValue()) {
				return new Boolean(true);
			}
		} 
		return new Boolean(false);
	}

}