package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Mutual implements Serializable {

	private Long idMutual;

	private Boolean bloqueado;

	private String nombre;

	public Mutual() {
	}

	public Mutual(String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setNombre(nombre);
	}

	public Long getIdMutual() {
		return idMutual;
	}

	@SuppressWarnings("unused")
	private void setIdMutual(Long idMutual) {
		this.idMutual = idMutual;
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
		if (!(obj instanceof Mutual))
			return false;
		Mutual that = (Mutual) obj;
		return EqualsUtil.areEqual(this.getNombre(), that.getNombre());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getNombre());
		return hashResult;
	}

}