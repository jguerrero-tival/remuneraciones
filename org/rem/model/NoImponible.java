package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class NoImponible implements Serializable {

	private Long idNoImponible;

	private Boolean bloqueado;

	private Boolean fijo;

	private String nombre;

	public NoImponible() {
	}

	public NoImponible(String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setFijo(new Boolean(false));
		this.setNombre(nombre);
	}

	public NoImponible(Boolean fijo, String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setFijo(fijo);
		this.setNombre(nombre);
	}

	public Long getIdNoImponible() {
		return idNoImponible;
	}

	@SuppressWarnings("unused")
	private void setIdNoImponible(Long idNoImponible) {
		this.idNoImponible = idNoImponible;
	}

	public Boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Boolean isFijo() {
		return fijo;
	}

	@SuppressWarnings("unused")
	private void setFijo(Boolean fijo) {
		this.fijo = fijo;
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
		if (!(obj instanceof NoImponible))
			return false;
		NoImponible that = (NoImponible) obj;
		return EqualsUtil.areEqual(this.getNombre(), that.getNombre());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getNombre());
		return hashResult;
	}

}