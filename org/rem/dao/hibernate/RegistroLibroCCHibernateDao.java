package org.rem.dao.hibernate;

import org.rem.dao.RegistroLibroCCDao;
import org.rem.model.informes.RegistroLibroCC;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroLibroCCHibernateDao extends GenericHibernateDao<RegistroLibroCC, Long, RegistroLibroCCDao>
		implements RegistroLibroCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLibroCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}