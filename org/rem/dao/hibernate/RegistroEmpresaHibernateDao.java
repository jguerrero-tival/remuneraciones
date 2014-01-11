package org.rem.dao.hibernate;

import org.rem.dao.RegistroEmpresaDao;
import org.rem.model.informes.RegistroEmpresa;
import java.util.*;
import org.hibernate.Criteria;

public class RegistroEmpresaHibernateDao extends GenericHibernateDao<RegistroEmpresa, Long, RegistroEmpresaDao>
		implements RegistroEmpresaDao {

	@SuppressWarnings("unchecked")
	@Override
	public List<RegistroEmpresa> findAll() {
		Criteria crit = getSession().createCriteria(getPersistentClass());
		return crit.list();
	}

}