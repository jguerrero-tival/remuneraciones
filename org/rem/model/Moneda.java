package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Moneda implements Serializable {

	private Long idMoneda;

	private Boolean fijo;

	private Double valor;

	private String tipo;

	public Moneda() {
	}

	public Moneda(Double valor, String tipo) {
		this.setFijo(new Boolean(false));
		this.setValor(valor);
		this.setTipo(tipo);
	}

	public Moneda(Boolean fijo, Double valor, String tipo) {
		this.setValor(valor);
		this.setTipo(tipo);
		this.setFijo(fijo);
	}

	public Long getIdMoneda() {
		return idMoneda;
	}

	@SuppressWarnings("unused")
	private void setIdMoneda(Long idMoneda) {
		this.idMoneda = idMoneda;
	}

	public Boolean isFijo() {
		return fijo;
	}

	public void setFijo(Boolean fijo) {
		this.fijo = fijo;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Moneda))
			return false;
		Moneda that = (Moneda) obj;
		return EqualsUtil.areEqual(this.getValor(), that.getValor());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getValor());
		return hashResult;
	}

}