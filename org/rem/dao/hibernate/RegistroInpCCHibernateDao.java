package org.rem.dao.hibernate;

import org.rem.dao.RegistroInpCCDao;
import org.rem.model.informes.RegistroInpCC;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroInpCCHibernateDao extends GenericHibernateDao<RegistroInpCC, Long, RegistroInpCCDao>
		implements RegistroInpCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroInpCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}