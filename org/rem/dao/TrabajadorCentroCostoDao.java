package org.rem.dao;

import java.util.List;

import org.rem.model.CentroCosto;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorCentroCosto;

public interface TrabajadorCentroCostoDao extends GenericDao<TrabajadorCentroCosto, Long> {

	public List<TrabajadorCentroCosto> findByTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta);
	
	public List<TrabajadorCentroCosto> findByLastTrabajadorCuenta(Trabajador trabajador);
	
	public TrabajadorCentroCosto findByTrabajadorCuentaCentroCosto(TrabajadorCuenta trabajadorCuenta, CentroCosto centroCosto);
	
	public Boolean isUsed(CentroCosto centroCosto);
	
}