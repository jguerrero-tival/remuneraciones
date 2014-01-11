package org.rem.dao;

import java.util.Date;
import org.rem.model.Mes;

public interface MesDao extends GenericDao<Mes, Long> {

	public Mes findByFecha(Date fecha);

	public Mes findByLastMes();

}