package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionDao;
import org.rem.model.informes.RegistroLiquidacion;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionHibernateDao extends GenericHibernateDao<RegistroLiquidacion, Long, RegistroLiquidacionDao>
		implements RegistroLiquidacionDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacion> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}