package org.rem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class EmpresaCuenta implements Serializable {

	private Long idEmpresaCuenta;

	private Boolean cerrada;
	
	private String gratificacion;

	private Caja caja;

	private Mutual mutual;

	private Double mutualCotizacionAdicional;

	private Empresa empresa;

	private Mes mes;

	private Set<CentroCosto> centroCostos = new HashSet<CentroCosto>();

	private Set<TrabajadorCuenta> trabajadorCuentas = new HashSet<TrabajadorCuenta>();
	
	public EmpresaCuenta() {
	}

	public EmpresaCuenta(EmpresaCuenta cuenta, Mes mes) {
		this.setCerrada(new Boolean(false));
		this.setGratificacion(cuenta.getGratificacion());
		this.setCaja(cuenta.getCaja());
		this.setMutual(cuenta.getMutual());
		this.setMutualCotizacionAdicional(cuenta.getMutualCotizacionAdicional());
		this.setEmpresa(cuenta.getEmpresa());
		this.setMes(mes);
	}

	public EmpresaCuenta(String gratificacion, Caja caja, Mutual mutual,
			Double mutualCotizacionAdicional, Mes mes) {
		this.setCerrada(new Boolean(false));
		this.setGratificacion(gratificacion);
		this.setCaja(caja);
		this.setMutual(mutual);
		this.setMutualCotizacionAdicional(mutualCotizacionAdicional);
		this.setMes(mes);
	}

	public Long getIdEmpresaCuenta() {
		return idEmpresaCuenta;
	}

	@SuppressWarnings("unused")
	private void setIdEmpresaCuenta(Long idEmpresaCuenta) {
		this.idEmpresaCuenta = idEmpresaCuenta;
	}

	public Boolean isCerrada() {
		return cerrada;
	}

	public void setCerrada(Boolean cerrada) {
		this.cerrada = cerrada;
	}
	
	public String getGratificacion() {
		return gratificacion;
	}

	public void setGratificacion(String gratificacion) {
		this.gratificacion = gratificacion;
	}

	public Caja getCaja() {
		return caja;
	}

	public void setCaja(Caja caja) {
		this.caja = caja;
	}

	public Mutual getMutual() {
		return mutual;
	}

	public void setMutual(Mutual mutual) {
		this.mutual = mutual;
	}

	public Double getMutualCotizacionAdicional() {
		return mutualCotizacionAdicional;
	}

	public void setMutualCotizacionAdicional(Double mutualCotizacionAdicional) {
		this.mutualCotizacionAdicional = mutualCotizacionAdicional;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}

	public Mes getMes() {
		return mes;
	}

	public void setMes(Mes mes) {
		this.mes = mes;
	}

	public Set<CentroCosto> getCentroCostos() {
		return centroCostos;
	}

	public void setCentroCostos(Set<CentroCosto> centroCostos) {
		this.centroCostos = centroCostos;
	}

	public void addCentroCosto(CentroCosto centroCosto) {
		this.centroCostos.add(centroCosto);
		centroCosto.setEmpresaCuenta(this);
	}

	public void removeCentroCosto(CentroCosto centroCosto) {
		this.centroCostos.remove(centroCosto);
	}

	public Set<TrabajadorCuenta> getTrabajadorCuentas() {
		return trabajadorCuentas;
	}

	public void setTrabajadorCuentas(Set<TrabajadorCuenta> trabajadorCuentas) {
		this.trabajadorCuentas = trabajadorCuentas;
	}

	public void addTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		this.trabajadorCuentas.add(trabajadorCuenta);
		trabajadorCuenta.setEmpresaCuenta(this);
	}

	public void removeTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		this.trabajadorCuentas.remove(trabajadorCuenta);
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof EmpresaCuenta))
			return false;
		EmpresaCuenta that = (EmpresaCuenta) obj;
		return EqualsUtil.areEqual(this.getEmpresa(), that.getEmpresa())
				&& EqualsUtil.areEqual(this.getMes(), that.getMes());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getEmpresa());
		hashResult = HashCodeUtil.hash(hashResult, this.getMes());
		return hashResult;
	}

}