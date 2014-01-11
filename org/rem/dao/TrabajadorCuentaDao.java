package org.rem.dao;

import java.util.List;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;

public interface TrabajadorCuentaDao extends GenericDao<TrabajadorCuenta, Long> {

	public TrabajadorCuenta findByTrabajadorEmpresaCuenta(Trabajador trabajador, EmpresaCuenta empresaCuenta);
	
	public List<TrabajadorCuenta> findByEmpresaCuenta(EmpresaCuenta empresaCuenta);

	/*
	public List<TrabajadorCuenta> findByEmpresaCuentaNoBloquado(EmpresaCuenta empresaCuenta);
	*/
	
	public Boolean existe(Trabajador trabajador, EmpresaCuenta empresaCuenta);
	
	public TrabajadorCuenta findByTrabajadorLast(Trabajador trabajador);

}