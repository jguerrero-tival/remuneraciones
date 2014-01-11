package org.rem.dao;

import java.util.List;
import org.rem.model.Descuento;

public interface DescuentoDao extends GenericDao<Descuento, Long> {

	public Descuento findByNombre(String nombre);

	public List<Descuento> findByNoBloqueadoNoFijo();
	
	public List<Descuento> findByNoBloqueado();

}