package org.rem.dao;

import java.util.List;
import org.rem.model.Afp;
import org.rem.model.Mes;

public interface AfpDao extends GenericDao<Afp, Long> {

	public List<Afp> findByMes(Mes mes);
	
	public Afp findByMesNombre(Mes mes, String nombre);

	public List<Afp> findByNoBloqueadoMes(Mes mes);

}