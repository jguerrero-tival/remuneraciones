package org.rem.dao;

import java.util.List;
import org.rem.model.Isapre;

public interface IsapreDao extends GenericDao<Isapre, Long> {

	public Isapre findByNombre(String nombre);

	public List<Isapre> findByNoBloqueado();

}