package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Descuento implements Serializable {

	private Long idDescuento;

	private Boolean bloqueado;

	private Boolean fijo;

	private String nombre;

	public Descuento() {
	}

	public Descuento(String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setFijo(new Boolean(false));
		this.setNombre(nombre);
	}

	public Descuento(Boolean fijo, String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setFijo(fijo);
		this.setNombre(nombre);
	}

	public Long getIdDescuento() {
		return idDescuento;
	}

	@SuppressWarnings("unused")
	private void setIdDescuento(Long idDescuento) {
		this.idDescuento = idDescuento;
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
		if (!(obj instanceof Descuento))
			return false;
		Descuento that = (Descuento) obj;
		return EqualsUtil.areEqual(this.getNombre(), that.getNombre());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getNombre());
		return hashResult;
	}

}