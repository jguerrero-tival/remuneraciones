package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionImponibleCCDao;
import org.rem.model.informes.RegistroLiquidacionImponibleCC;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionImponibleCCHibernateDao extends GenericHibernateDao<RegistroLiquidacionImponibleCC, Long, RegistroLiquidacionImponibleCCDao>
		implements RegistroLiquidacionImponibleCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionImponibleCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}