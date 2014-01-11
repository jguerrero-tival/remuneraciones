package org.rem.dao.hibernate;

import org.rem.dao.RegistroInpDao;
import org.rem.model.informes.RegistroInp;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroInpHibernateDao extends GenericHibernateDao<RegistroInp, Long, RegistroInpDao>
		implements RegistroInpDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroInp> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}