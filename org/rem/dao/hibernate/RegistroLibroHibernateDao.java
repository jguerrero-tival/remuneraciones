package org.rem.dao.hibernate;

import org.rem.dao.RegistroLibroDao;
import org.rem.model.informes.RegistroLibro;
import java.util.*;
import org.hibernate.Criteria;
import org.hibernate.criterion.Order;

public class RegistroLibroHibernateDao extends GenericHibernateDao<RegistroLibro, Long, RegistroLibroDao>
		implements RegistroLibroDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLibro> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		crit.addOrder(Order.asc("rutTrabajador"));
		return crit.list();
	}

}