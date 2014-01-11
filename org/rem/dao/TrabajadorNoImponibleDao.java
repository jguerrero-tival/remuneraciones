package org.rem.dao;

import java.util.List;
import org.rem.model.NoImponible;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorNoImponible;

public interface TrabajadorNoImponibleDao extends GenericDao<TrabajadorNoImponible, Long> {

	public List<TrabajadorNoImponible> findByTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta);
	
	public List<TrabajadorNoImponible> findByLastTrabajadorCuenta(Trabajador trabajador);

	public TrabajadorNoImponible findByTrabajadorCuentaNoImponible(TrabajadorCuenta trabajadorCuenta, NoImponible noImponible);
	
}