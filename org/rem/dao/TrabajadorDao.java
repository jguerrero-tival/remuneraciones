package org.rem.dao;

import java.util.List;
import org.rem.model.Empresa;
import org.rem.model.Trabajador;

public interface TrabajadorDao extends GenericDao<Trabajador, Long> {

	public Trabajador findByEmpresaRutTrabajador(Empresa empresa, String rutTrabajador);

	public List<Trabajador> findByEmpresa(Empresa empresa);

	public List<Trabajador> findByEmpresaNoBloqueado(Empresa empresa);
	
	public Boolean isBloqueado(Empresa empresa, String rutTrabajador);

}