package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionNoImponibleDao;
import org.rem.model.informes.RegistroLiquidacionNoImponible;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionNoImponibleHibernateDao extends GenericHibernateDao<RegistroLiquidacionNoImponible, Long, RegistroLiquidacionNoImponibleDao>
		implements RegistroLiquidacionNoImponibleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionNoImponible> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}