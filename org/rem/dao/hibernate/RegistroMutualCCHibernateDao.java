package org.rem.dao.hibernate;

import org.rem.dao.RegistroMutualCCDao;
import org.rem.model.informes.RegistroMutualCC;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroMutualCCHibernateDao extends GenericHibernateDao<RegistroMutualCC, Long, RegistroMutualCCDao>
		implements RegistroMutualCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroMutualCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}