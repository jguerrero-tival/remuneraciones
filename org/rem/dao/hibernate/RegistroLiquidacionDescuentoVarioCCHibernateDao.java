package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionDescuentoVarioCCDao;
import org.rem.model.informes.RegistroLiquidacionDescuentoVarioCC;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionDescuentoVarioCCHibernateDao extends GenericHibernateDao<RegistroLiquidacionDescuentoVarioCC, Long, RegistroLiquidacionDescuentoVarioCCDao>
		implements RegistroLiquidacionDescuentoVarioCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionDescuentoVarioCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}