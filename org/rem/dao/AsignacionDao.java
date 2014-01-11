package org.rem.dao;

import java.util.List;
import org.rem.model.Asignacion;
import org.rem.model.Mes;

public interface AsignacionDao extends GenericDao<Asignacion, Long> {

	public List<Asignacion> findByMes(Mes mes);

	public List<Asignacion> findByMesNoCasiFijo(Mes mes);
	
	public Asignacion findByMesInicio(Mes mes, Double inicio);

}