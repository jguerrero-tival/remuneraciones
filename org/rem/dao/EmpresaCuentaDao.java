package org.rem.dao;

import java.util.List;
import org.rem.model.Empresa;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Mes;

public interface EmpresaCuentaDao extends GenericDao<EmpresaCuenta, Long> {

	public List<EmpresaCuenta> findByEmpresa(Empresa empresa);
	
	public EmpresaCuenta findByEmpresaMes(Empresa empresa, Mes mes);
	
	public List<EmpresaCuenta> findByEmpresaCerrada(Empresa empresa);
	
	public List<EmpresaCuenta> findByEmpresaNoCerrada(Empresa empresa);
	
	public Boolean existe(Empresa empresa, Mes mes);
	
	public EmpresaCuenta findByEmpresaLast(Empresa empresa);
}