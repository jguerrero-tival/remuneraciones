package org.rem.dao.hibernate;

import org.rem.dao.RegistroCajaCCDao;
import org.rem.model.informes.RegistroCajaCC;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroCajaCCHibernateDao extends GenericHibernateDao<RegistroCajaCC, Long, RegistroCajaCCDao>
		implements RegistroCajaCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroCajaCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}