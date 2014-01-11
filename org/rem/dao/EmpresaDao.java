package org.rem.dao;

import java.util.List;
import org.rem.model.Empresa;

public interface EmpresaDao extends GenericDao<Empresa, Long> {

	public Empresa findByRutEmpresa(String rutEmpresa);
		
	public List<Empresa> findByNoBloqueado();
	
	public Boolean isBloqueado(String rutEmpresa);
}