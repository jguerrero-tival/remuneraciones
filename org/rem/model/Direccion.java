package org.rem.model;

import java.io.Serializable;

import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Direccion implements Serializable {

	private String calle;

	private String numero;

	private String ciudad;

	private String comuna;

	private String region;

	private String poblacion;

	private String cerro;

	public Direccion() {
	}

	public Direccion(String calle, String numero, String ciudad, String comuna,
			String region, String poblacion, String cerro) {
		this.setCalle(calle);
		this.setNumero(numero);
		this.setCiudad(ciudad);
		this.setComuna(comuna);
		this.setRegion(region);
		this.setPoblacion(poblacion);
		this.setCerro(cerro);
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getCerro() {
		return cerro;
	}

	public void setCerro(String cerro) {
		this.cerro = cerro;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Direccion))
			return false;
		Direccion that = (Direccion) obj;
		return EqualsUtil.areEqual(this.getCalle(), that.getCalle())
				&& EqualsUtil.areEqual(this.getNumero(), that.getNumero())
				&& EqualsUtil.areEqual(this.getCiudad(), that.getCiudad())
				&& EqualsUtil.areEqual(this.getComuna(), that.getComuna())
				&& EqualsUtil.areEqual(this.getRegion(), that.getRegion())
				&& EqualsUtil
						.areEqual(this.getPoblacion(), that.getPoblacion())
				&& EqualsUtil.areEqual(this.getCerro(), that.getCerro());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getCalle());
		hashResult = HashCodeUtil.hash(hashResult, this.getNumero());
		hashResult = HashCodeUtil.hash(hashResult, this.getCiudad());
		hashResult = HashCodeUtil.hash(hashResult, this.getComuna());
		hashResult = HashCodeUtil.hash(hashResult, this.getRegion());
		hashResult = HashCodeUtil.hash(hashResult, this.getPoblacion());
		hashResult = HashCodeUtil.hash(hashResult, this.getCerro());
		return hashResult;
	}

}