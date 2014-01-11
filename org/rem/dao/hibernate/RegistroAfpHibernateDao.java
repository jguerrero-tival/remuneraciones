package org.rem.dao.hibernate;

import org.rem.dao.RegistroAfpDao;
import org.rem.model.informes.RegistroAfp;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroAfpHibernateDao extends GenericHibernateDao<RegistroAfp, Long, RegistroAfpDao>
		implements RegistroAfpDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroAfp> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}