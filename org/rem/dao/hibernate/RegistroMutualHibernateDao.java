package org.rem.dao.hibernate;

import org.rem.dao.RegistroMutualDao;
import org.rem.model.informes.RegistroMutual;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroMutualHibernateDao extends GenericHibernateDao<RegistroMutual, Long, RegistroMutualDao>
		implements RegistroMutualDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroMutual> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}