package org.rem.dao;

import java.util.List;
import org.rem.model.Moneda;

public interface MonedaDao extends GenericDao<Moneda, Long> {

	public Moneda findByValor(Double valor);

	public List<Moneda> findByNoFijo();

}