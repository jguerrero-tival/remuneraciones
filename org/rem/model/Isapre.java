package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Isapre implements Serializable {

	private Long idIsapre;

	private Boolean bloqueado;

	private String nombre;

	public Isapre() {
	}

	public Isapre(String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setNombre(nombre);
	}

	public Long getIdIsapre() {
		return idIsapre;
	}

	@SuppressWarnings("unused")
	private void setIdIsapre(Long idIsapre) {
		this.idIsapre = idIsapre;
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
		if (!(obj instanceof Isapre))
			return false;
		Isapre that = (Isapre) obj;
		return EqualsUtil.areEqual(this.getNombre(), that.getNombre());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getNombre());
		return hashResult;
	}

}