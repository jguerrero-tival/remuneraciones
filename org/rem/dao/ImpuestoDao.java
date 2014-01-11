package org.rem.dao;

import java.util.List;
import org.rem.model.Impuesto;
import org.rem.model.Mes;

public interface ImpuestoDao extends GenericDao<Impuesto, Long> {

	public List<Impuesto> findByMes(Mes mes);
	
	public List<Impuesto> findByMesNoCasiFijo(Mes mes);

	public Impuesto findByMesInicio(Mes mes, Double inicio);

}