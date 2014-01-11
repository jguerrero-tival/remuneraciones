package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionCCDao;
import org.rem.model.informes.RegistroLiquidacionCC;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionCCHibernateDao extends GenericHibernateDao<RegistroLiquidacionCC, Long, RegistroLiquidacionCCDao>
		implements RegistroLiquidacionCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}