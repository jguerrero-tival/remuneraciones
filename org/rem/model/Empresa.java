package org.rem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Empresa implements Serializable {

	private Long idEmpresa;

	private Boolean bloqueado;

	private String rutEmpresa;

	private String razonSocial;

	private Boolean colegio;

	private String actividad;

	private String fono;

	private String email;

	private Direccion direccion;

	private Persona representante;

	private Set<EmpresaCuenta> cuentas = new HashSet<EmpresaCuenta>();

	private Set<Trabajador> trabajadores = new HashSet<Trabajador>();

	public Empresa() {
	}

	public Empresa(String rutEmpresa, String razonSocial, Boolean colegio,
			String actividad, String fono, String email, Direccion direccion,
			Persona representante) {
		this.setBloqueado(new Boolean(false));
		this.setRutEmpresa(rutEmpresa);
		this.setRazonSocial(razonSocial);
		this.setColegio(colegio);
		this.setActividad(actividad);
		this.setFono(fono);
		this.setEmail(email);
		this.setDireccion(direccion);
		this.setRepresentante(representante);
	}

	public Long getIdEmpresa() {
		return idEmpresa;
	}

	@SuppressWarnings("unused")
	private void setIdEmpresa(Long idEmpresa) {
		this.idEmpresa = idEmpresa;
	}

	public Boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public String getRutEmpresa() {
		return rutEmpresa;
	}

	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public Boolean isColegio() {
		return colegio;
	}

	public void setColegio(Boolean colegio) {
		this.colegio = colegio;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getFono() {
		return fono;
	}

	public void setFono(String fono) {
		this.fono = fono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Persona getRepresentante() {
		return representante;
	}

	public void setRepresentante(Persona representante) {
		this.representante = representante;
	}

	public Set<EmpresaCuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<EmpresaCuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void addCuenta(EmpresaCuenta cuenta) {
		this.cuentas.add(cuenta);
		cuenta.setEmpresa(this);
	}

	public void removeCuenta(EmpresaCuenta cuenta) {
		this.cuentas.remove(cuenta);
	}

	public Set<Trabajador> getTrabajadores() {
		return trabajadores;
	}

	public void setTrabajadores(Set<Trabajador> trabajadores) {
		this.trabajadores = trabajadores;
	}

	public void addTrabajador(Trabajador trabajador) {
		this.trabajadores.add(trabajador);
		trabajador.setEmpresa(this);
	}

	public void removeTrabajador(Trabajador trabajador) {
		this.trabajadores.remove(trabajador);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Empresa))
			return false;
		Empresa that = (Empresa) obj;
		return EqualsUtil.areEqual(this.getRutEmpresa(), that.getRutEmpresa());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getRutEmpresa());
		return hashResult;
	}

}