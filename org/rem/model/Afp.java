package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Afp implements Serializable {

	private Long idAfp;

	private Boolean bloqueado;

	private String nombre;

	private String regimen;

	private Double cotizacion;
	
	private Mes mes;//NEW

	public Afp() {
	}

	public Afp(Afp afp) {
		this.setBloqueado(new Boolean(false));
		this.setNombre(afp.getNombre());
		this.setRegimen(afp.getRegimen());
		this.setCotizacion(afp.getCotizacion());
	}
	
	public Afp(String nombre, String regimen, Double cotizacion) {
		this.setBloqueado(new Boolean(false));
		this.setNombre(nombre);
		this.setRegimen(regimen);
		this.setCotizacion(cotizacion);
	}
	
	public Long getIdAfp() {
		return idAfp;
	}

	@SuppressWarnings("unused")
	private void setIdAfp(Long idAfp) {
		this.idAfp = idAfp;
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

	public String getRegimen() {
		return regimen;
	}

	public void setRegimen(String regimen) {
		this.regimen = regimen;
	}

	public Double getCotizacion() {
		return cotizacion;
	}

	public void setCotizacion(Double cotizacion) {
		this.cotizacion = cotizacion;
	}

	//NEW
	public Mes getMes() {
		return mes;
	}

	//NEW
	public void setMes(Mes mes) {
		this.mes = mes;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Afp))
			return false;
		Afp that = (Afp) obj;
		return EqualsUtil.areEqual(this.getNombre(), that.getNombre())
						&& EqualsUtil.areEqual(this.getMes(), that.getMes());//NEW
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getNombre());
		hashResult = HashCodeUtil.hash(hashResult, this.getMes());//NEW
		return hashResult;
	}

}