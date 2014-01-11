package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Persona implements Serializable {

	private String rut;

	private String nombres;

	private String apellidoPaterno;

	private String apellidoMaterno;

	private String sexo;

	public Persona() {
	}

	public Persona(String rut, String nombres, String apellidoPaterno,
			String apellidoMaterno) {
		this.setRut(rut);
		this.setNombres(nombres);
		this.setApellidoPaterno(apellidoPaterno);
		this.setApellidoMaterno(apellidoMaterno);
		this.setSexo("");
	}

	public Persona(String rut, String nombres, String apellidoPaterno,
			String apellidoMaterno, String sexo) {
		this.setRut(rut);
		this.setNombres(nombres);
		this.setApellidoPaterno(apellidoPaterno);
		this.setApellidoMaterno(apellidoMaterno);
		this.setSexo(sexo);
	}

	public String getRut() {
		return rut;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getApellidoPaterno() {
		return apellidoPaterno;
	}

	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}

	public String getApellidoMaterno() {
		return apellidoMaterno;
	}

	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Persona))
			return false;
		Persona that = (Persona) obj;
		return EqualsUtil.areEqual(this.getRut(), that.getRut());
/*				&& EqualsUtil.areEqual(this.getNombres(), that.getNombres())
				&& EqualsUtil.areEqual(this.getApellidoPaterno(), that
						.getApellidoPaterno())
				&& EqualsUtil.areEqual(this.getApellidoMaterno(), that
						.getApellidoMaterno())
				&& EqualsUtil.areEqual(this.getSexo(), that.getSexo());*/
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getRut());
/*		hashResult = HashCodeUtil.hash(hashResult, this.getNombres());
		hashResult = HashCodeUtil.hash(hashResult, this.getApellidoPaterno());
		hashResult = HashCodeUtil.hash(hashResult, this.getApellidoMaterno());
		hashResult = HashCodeUtil.hash(hashResult, this.getSexo());*/
		return hashResult;
	}

}