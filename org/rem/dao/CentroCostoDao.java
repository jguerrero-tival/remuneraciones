package org.rem.dao;

import org.rem.model.CentroCosto;
import org.rem.model.EmpresaCuenta;
import java.util.*;

public interface CentroCostoDao extends GenericDao<CentroCosto, Long> {

	public List<CentroCosto> findByEmpresaCuenta(EmpresaCuenta empresaCuenta);
	
	public CentroCosto findByEmpresaCuentaNumero(EmpresaCuenta empresaCuenta, Long numero);

}