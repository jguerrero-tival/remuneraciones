package org.rem.dao;

import java.util.List;
import org.rem.model.NoImponible;

public interface NoImponibleDao extends GenericDao<NoImponible, Long> {

	public NoImponible findByNombre(String nombre);

	public List<NoImponible> findByNoBloqueadoNoFijo();
	
	public List<NoImponible> findByNoBloqueado();

}