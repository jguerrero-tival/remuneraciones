package org.rem.dao.hibernate;

import org.rem.dao.RegistroCajaDao;
import org.rem.model.informes.RegistroCaja;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroCajaHibernateDao extends GenericHibernateDao<RegistroCaja, Long, RegistroCajaDao>
		implements RegistroCajaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroCaja> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}