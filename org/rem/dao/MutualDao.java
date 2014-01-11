package org.rem.dao;

import java.util.List;
import org.rem.model.Mutual;

public interface MutualDao extends GenericDao<Mutual, Long> {

	public Mutual findByNombre(String nombre);

	public List<Mutual> findByNoBloqueado();

}