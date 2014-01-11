package org.rem.dao;

import java.util.List;
import org.rem.model.Imponible;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorImponible;

public interface TrabajadorImponibleDao extends GenericDao<TrabajadorImponible, Long> {

	public List<TrabajadorImponible> findByTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta);
	
	public List<TrabajadorImponible> findByLastTrabajadorCuenta(Trabajador trabajador);
	
	public TrabajadorImponible findByTrabajadorCuentaImponible(TrabajadorCuenta trabajadorCuenta, Imponible imponible);
	
}