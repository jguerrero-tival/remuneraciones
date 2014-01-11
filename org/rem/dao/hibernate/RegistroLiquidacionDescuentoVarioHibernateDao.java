package org.rem.dao.hibernate;

import org.rem.dao.RegistroLiquidacionDescuentoVarioDao;
import org.rem.model.informes.RegistroLiquidacionDescuentoVario;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroLiquidacionDescuentoVarioHibernateDao extends GenericHibernateDao<RegistroLiquidacionDescuentoVario, Long, RegistroLiquidacionDescuentoVarioDao>
		implements RegistroLiquidacionDescuentoVarioDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroLiquidacionDescuentoVario> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}