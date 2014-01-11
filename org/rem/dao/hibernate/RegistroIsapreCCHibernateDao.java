package org.rem.dao.hibernate;

import org.rem.dao.RegistroIsapreCCDao;
import org.rem.model.informes.RegistroIsapreCC;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroIsapreCCHibernateDao extends GenericHibernateDao<RegistroIsapreCC, Long, RegistroIsapreCCDao>
		implements RegistroIsapreCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroIsapreCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}