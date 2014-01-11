package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Caja implements Serializable {

	private Long idCaja;

	private Boolean bloqueado;

	private String nombre;

	public Caja() {
	}

	public Caja(String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setNombre(nombre);
	}

	public Long getIdCaja() {
		return idCaja;
	}

	@SuppressWarnings("unused")
	private void setIdCaja(Long idCaja) {
		this.idCaja = idCaja;
	}

	public Boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Caja))
			return false;
		Caja that = (Caja) obj;
		return EqualsUtil.areEqual(this.getNombre(), that.getNombre());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getNombre());
		return hashResult;
	}

}