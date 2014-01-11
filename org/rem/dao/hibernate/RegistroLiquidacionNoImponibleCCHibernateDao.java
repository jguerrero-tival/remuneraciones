package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionNoImponibleCCDao;
import org.rem.model.informes.RegistroLiquidacionNoImponibleCC;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionNoImponibleCCHibernateDao extends GenericHibernateDao<RegistroLiquidacionNoImponibleCC, Long, RegistroLiquidacionNoImponibleCCDao>
		implements RegistroLiquidacionNoImponibleCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionNoImponibleCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}