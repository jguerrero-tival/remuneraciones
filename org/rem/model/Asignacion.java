package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Asignacion implements Serializable {

	private Long idAsignacion;

	private Boolean casiFijo;

	private Double inicio;

	private Double monto;

	private Mes mes;

	public Asignacion() {
	}

	public Asignacion(Asignacion asignacion) {
		this.setCasiFijo(asignacion.isCasiFijo());
		this.setInicio(asignacion.getInicio());
		this.setMonto(asignacion.getMonto());
	}

	public Asignacion(Double inicio, Double monto) {
		this.setCasiFijo(new Boolean(false));
		this.setInicio(inicio);
		this.setMonto(monto);
	}

	public Asignacion(Boolean casiFijo, Double inicio, Double monto) {
		this.setCasiFijo(casiFijo);
		this.setInicio(inicio);
		this.setMonto(monto);
	}

	public Long getIdAsignacion() {
		return idAsignacion;
	}

	@SuppressWarnings("unused")
	private void setIdAsignacion(Long idAsignacion) {
		this.idAsignacion = idAsignacion;
	}

	public Boolean isCasiFijo() {
		return casiFijo;
	}

	public void setCasiFijo(Boolean casiFijo) {
		this.casiFijo = casiFijo;
	}

	public Double getInicio() {
		return inicio;
	}

	public void setInicio(Double inicio) {
		this.inicio = inicio;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Asignacion))
			return false;
		Asignacion that = (Asignacion) obj;
		return EqualsUtil.areEqual(this.getInicio(), that.getInicio())
				&& EqualsUtil.areEqual(this.getMes(), that.getMes());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getInicio());
		hashResult = HashCodeUtil.hash(hashResult, this.getMes());
		return hashResult;
	}

}