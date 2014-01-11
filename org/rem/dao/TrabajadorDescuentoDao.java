package org.rem.dao;

import java.util.List;
import org.rem.model.Descuento;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorDescuento;

public interface TrabajadorDescuentoDao extends GenericDao<TrabajadorDescuento, Long> {

	public List<TrabajadorDescuento> findByTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta);
	
	public List<TrabajadorDescuento> findByLastTrabajadorCuenta(Trabajador trabajador);

	public TrabajadorDescuento findByTrabajadorCuentaDescuento(TrabajadorCuenta trabajadorCuenta, Descuento descuento);

}