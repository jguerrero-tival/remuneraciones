package org.rem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Trabajador implements Serializable {

	private Long idTrabajador;

	private Boolean bloqueado;

	private Persona datosPersonales;

	private Direccion direccion;

	private Date fechaIngreso;

	private Date fechaEgreso;

	private Empresa empresa;

	private Set<TrabajadorCuenta> cuentas = new HashSet<TrabajadorCuenta>();

	public Trabajador() {
	}

	public Trabajador(Persona datosPersonales, Direccion direccion,
			Date fechaIngreso, Date fechaEgreso) {
		this.setBloqueado(new Boolean(false));
		this.setDatosPersonales(datosPersonales);
		this.setDireccion(direccion);
		this.setFechaIngreso(fechaIngreso);
		this.setFechaEgreso(fechaEgreso);
	}

	public Long getIdTrabajador() {
		return idTrabajador;
	}

	@SuppressWarnings("unused")
	private void setIdTrabajador(Long idTrabajador) {
		this.idTrabajador = idTrabajador;
	}

	public Boolean isBloqueado() {
		return bloqueado;
	}

	public void setBloqueado(Boolean bloqueado) {
		this.bloqueado = bloqueado;
	}

	public Persona getDatosPersonales() {
		return datosPersonales;
	}

	public void setDatosPersonales(Persona datosPersonales) {
		this.datosPersonales = datosPersonales;
	}

	public Direccion getDireccion() {
		return direccion;
	}

	public void setDireccion(Direccion direccion) {
		this.direccion = direccion;
	}

	public Date getFechaIngreso() {
		return fechaIngreso;
	}

	public void setFechaIngreso(Date fechaIngreso) {
		this.fechaIngreso = fechaIngreso;
	}

	public Date getFechaEgreso() {
		return fechaEgreso;
	}

	public void setFechaEgreso(Date fechaEgreso) {
		this.fechaEgreso = fechaEgreso;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Set<TrabajadorCuenta> getCuentas() {
		return cuentas;
	}

	public void setCuentas(Set<TrabajadorCuenta> cuentas) {
		this.cuentas = cuentas;
	}

	public void addCuenta(TrabajadorCuenta cuenta) {
		this.cuentas.add(cuenta);
		cuenta.setTrabajador(this);
	}

	public void removeCuenta(TrabajadorCuenta cuenta) {
		this.cuentas.remove(cuenta);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Trabajador))
			return false;
		Trabajador that = (Trabajador) obj;
		return EqualsUtil.areEqual(this.getDatosPersonales().getRut(), that
				.getDatosPersonales().getRut())
				&& EqualsUtil.areEqual(this.getEmpresa(), that.getEmpresa());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getDatosPersonales()
				.getRut());
		hashResult = HashCodeUtil.hash(hashResult, this.getEmpresa());
		return hashResult;
	}

}