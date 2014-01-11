package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Imponible implements Serializable {

	private Long idImponible;

	private Boolean bloqueado;

	private Boolean fijo;

	private Boolean colegio;
	
	private String nombre;

	public Imponible() {
	}

	public Imponible(String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setFijo(new Boolean(false));
		this.setColegio(new Boolean(false));
		this.setNombre(nombre);
	}

	public Imponible(Boolean fijo, String nombre) {
		this.setBloqueado(new Boolean(false));
		this.setFijo(fijo);
		this.setColegio(new Boolean(false));
		this.setNombre(nombre);
	}

	public Long getIdImponible() {
		return idImponible;
	}

	@SuppressWarnings("unused")
	private void setIdImponible(Long idImponible) {
		this.idImponible = idImponible;
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

	private void setFijo(Boolean fijo) {
		this.fijo = fijo;
	}

	public Boolean isColegio() {
		return colegio;
	}
	
	public void setColegio(Boolean colegio) {
		this.colegio = colegio;
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
		if (!(obj instanceof Imponible))
			return false;
		Imponible that = (Imponible) obj;
		return EqualsUtil.areEqual(this.getNombre(), that.getNombre());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getNombre());
		return hashResult;
	}

}