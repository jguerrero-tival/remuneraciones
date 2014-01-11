package org.rem.dao.hibernate;

import org.rem.dao.RegistroAfpCCDao;
import org.rem.model.informes.RegistroAfpCC;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroAfpCCHibernateDao extends GenericHibernateDao<RegistroAfpCC, Long, RegistroAfpCCDao>
		implements RegistroAfpCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroAfpCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}