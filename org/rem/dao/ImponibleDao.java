package org.rem.dao;

import java.util.List;
import org.rem.model.Imponible;

public interface ImponibleDao extends GenericDao<Imponible, Long> {

	public Imponible findByNombre(String nombre);

	public List<Imponible> findByNoBloqueadoNoFijo();
	
	//public List<Imponible> findByNoBloqueado();

}