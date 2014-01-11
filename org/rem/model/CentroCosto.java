package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class CentroCosto implements Serializable {

	private Long idCentroCosto;

	private Long numero;

	private String nombre;

	private EmpresaCuenta empresaCuenta;

	public CentroCosto() {
	}

	public CentroCosto(CentroCosto centroCosto) {
		this.setNumero(centroCosto.getNumero());
		this.setNombre(centroCosto.getNombre());
	}

	public CentroCosto(Long numero, String nombre) {
		this.setNumero(numero);
		this.setNombre(nombre);
	}

	public Long getIdCentroCosto() {
		return idCentroCosto;
	}

	@SuppressWarnings("unused")
	private void setIdCentroCosto(Long idCentroCosto) {
		this.idCentroCosto = idCentroCosto;
	}

	public Long getNumero() {
		return numero;
	}

	public void setNumero(Long numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public EmpresaCuenta getEmpresaCuenta() {
		return empresaCuenta;
	}

	public void setEmpresaCuenta(EmpresaCuenta empresaCuenta) {
		this.empresaCuenta = empresaCuenta;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof CentroCosto))
			return false;
		CentroCosto that = (CentroCosto) obj;
		return EqualsUtil.areEqual(this.getNumero(), that.getNumero())
				&& EqualsUtil.areEqual(this.getEmpresaCuenta(), that
						.getEmpresaCuenta());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getNumero());
		hashResult = HashCodeUtil.hash(hashResult, this.getEmpresaCuenta());
		return hashResult;
	}

}