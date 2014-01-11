package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionDescuentoLegalDao;
import org.rem.model.informes.RegistroLiquidacionDescuentoLegal;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionDescuentoLegalHibernateDao extends GenericHibernateDao<RegistroLiquidacionDescuentoLegal, Long, RegistroLiquidacionDescuentoLegalDao>
		implements RegistroLiquidacionDescuentoLegalDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionDescuentoLegal> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}