package org.rem.dao.hibernate;

import org.rem.dao.RegistroIsapreDao;
import org.rem.model.informes.RegistroIsapre;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroIsapreHibernateDao extends GenericHibernateDao<RegistroIsapre, Long, RegistroIsapreDao>
		implements RegistroIsapreDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroIsapre> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}