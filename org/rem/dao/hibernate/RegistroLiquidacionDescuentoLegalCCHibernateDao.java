package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionDescuentoLegalCCDao;
import org.rem.model.informes.RegistroLiquidacionDescuentoLegalCC;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionDescuentoLegalCCHibernateDao extends GenericHibernateDao<RegistroLiquidacionDescuentoLegalCC, Long, RegistroLiquidacionDescuentoLegalCCDao>
		implements RegistroLiquidacionDescuentoLegalCCDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionDescuentoLegalCC> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}