package org.rem.dao;

import java.util.List;
import org.rem.model.Caja;

public interface CajaDao extends GenericDao<Caja, Long> {

	public Caja findByNombre(String nombre);

	public List<Caja> findByNoBloqueado();

}