package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Impuesto implements Serializable {

	private Long idImpuesto;

	private Boolean casiFijo;

	private Double inicio;

	private Double factor;

	private Double rebaja;

	private Mes mes;

	public Impuesto() {
	}

	public Impuesto(Impuesto impuesto) {
		this.setCasiFijo(impuesto.isCasiFijo());
		this.setInicio(impuesto.getInicio());
		this.setFactor(impuesto.getFactor());
		this.setRebaja(impuesto.getRebaja());
	}

	public Impuesto(Double inicio, Double factor, Double rebaja) {
		this.setCasiFijo(new Boolean(false));
		this.setInicio(inicio);
		this.setFactor(factor);
		this.setRebaja(rebaja);
		this.setMes(mes);
	}

	public Impuesto(Boolean casiFijo, Double inicio, Double factor,
			Double rebaja) {
		this.setCasiFijo(casiFijo);
		this.setInicio(inicio);
		this.setFactor(factor);
		this.setRebaja(rebaja);
	}

	public Long getIdImpuesto() {
		return idImpuesto;
	}

	@SuppressWarnings("unused")
	private void setIdImpuesto(Long idImpuesto) {
		this.idImpuesto = idImpuesto;
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

	public Double getFactor() {
		return factor;
	}

	public void setFactor(Double factor) {
		this.factor = factor;
	}

	public Double getRebaja() {
		return rebaja;
	}

	public void setRebaja(Double rebaja) {
		this.rebaja = rebaja;
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
		if (!(obj instanceof Impuesto))
			return false;
		Impuesto that = (Impuesto) obj;
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