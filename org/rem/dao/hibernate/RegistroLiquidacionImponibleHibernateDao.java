package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionImponibleDao;
import org.rem.model.informes.RegistroLiquidacionImponible;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionImponibleHibernateDao extends GenericHibernateDao<RegistroLiquidacionImponible, Long, RegistroLiquidacionImponibleDao>
		implements RegistroLiquidacionImponibleDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionImponible> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}