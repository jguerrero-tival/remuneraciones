package org.rem.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class Mes implements Serializable {

	private Long idMes;

	private Date fecha;

	/* mes */

	private Double sueldoMinimo;

	private Double uf;

	private Double utm;

	/* prevision */

	private Double previsionAfpTope;

	private Double previsionApvTope;
	
	private Double previsionSeguroInvalidez;

	/* mutual */

	private Double mutualCotizacionBasica;

	/* salud */

	private Double saludCotizacionBasica;

	private Double saludTope;

	/* seguro cesantia */

	private Double seguroCesantiaPorcentaje;

	private Double seguroCesantiaTope;

	/* gratificacion */

	private Double gratificacionPorcentaje;

	private Double gratificacionFactorAnual;

	/* colections */

	private Set<Impuesto> impuestos = new HashSet<Impuesto>();

	private Set<Asignacion> asignaciones = new HashSet<Asignacion>();
	
	//NEW
	private Set<Afp> afps = new HashSet<Afp>();

	public Mes() {
	}

	public Mes(Date fecha, Mes mes) {
		this.setFecha(fecha);
		this.setSueldoMinimo(mes.getSueldoMinimo());
		this.setUf(mes.getUf());
		this.setUtm(mes.getUtm());
		this.setPrevisionAfpTope(mes.getPrevisionAfpTope());
		this.setPrevisionApvTope(mes.getPrevisionApvTope());
		this.setPrevisionSeguroInvalidez(mes.getPrevisionSeguroInvalidez());
		this.setMutualCotizacionBasica(mes.getMutualCotizacionBasica());
		this.setSaludCotizacionBasica(mes.getSaludCotizacionBasica());
		this.setSaludTope(mes.getSaludTope());
		this.setSeguroCesantiaPorcentaje(mes.getSeguroCesantiaPorcentaje());
		this.setSeguroCesantiaTope(mes.getSeguroCesantiaTope());
		this.setGratificacionPorcentaje(mes.getGratificacionPorcentaje());
		this.setGratificacionFactorAnual(mes.getGratificacionFactorAnual());
	}

	public Mes(Date fecha, Double sueldoMinimo, Double uf, Double utm,
			Double previsionAfpTope, Double previsionApvTope, Double previsionSeguroInvalidez, 
			Double mutualCotizacionBasica, Double saludCotizacionBasica,
			Double saludTope, Double seguroCesantiaPorcentaje,
			Double seguroCesantiaTope, Double gratificacionPorcentaje,
			Double gratificacionFactorAnual) {
		this.setFecha(fecha);
		this.setSueldoMinimo(sueldoMinimo);
		this.setUf(uf);
		this.setUtm(utm);
		this.setPrevisionAfpTope(previsionAfpTope);
		this.setPrevisionApvTope(previsionApvTope);
		this.setPrevisionSeguroInvalidez(previsionSeguroInvalidez);
		this.setMutualCotizacionBasica(mutualCotizacionBasica);
		this.setSaludCotizacionBasica(saludCotizacionBasica);
		this.setSaludTope(saludTope);
		this.setSeguroCesantiaPorcentaje(seguroCesantiaPorcentaje);
		this.setSeguroCesantiaTope(seguroCesantiaTope);
		this.setGratificacionPorcentaje(gratificacionPorcentaje);
		this.setGratificacionFactorAnual(gratificacionFactorAnual);
	}

	public Long getIdMes() {
		return idMes;
	}

	@SuppressWarnings("unused")
	private void setIdMes(Long idMes) {
		this.idMes = idMes;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public Double getSueldoMinimo() {
		return sueldoMinimo;
	}

	public void setSueldoMinimo(Double sueldoMinimo) {
		this.sueldoMinimo = sueldoMinimo;
	}

	public Double getUf() {
		return uf;
	}

	public void setUf(Double uf) {
		this.uf = uf;
	}

	public Double getUtm() {
		return utm;
	}

	public void setUtm(Double utm) {
		this.utm = utm;
	}

	public Double getPrevisionAfpTope() {
		return previsionAfpTope;
	}

	public void setPrevisionAfpTope(Double previsionAfpTope) {
		this.previsionAfpTope = previsionAfpTope;
	}

	public Double getPrevisionApvTope() {
		return previsionApvTope;
	}

	public void setPrevisionApvTope(Double previsionApvTope) {
		this.previsionApvTope = previsionApvTope;
	}

	public Double getPrevisionSeguroInvalidez() {
		return previsionSeguroInvalidez;
	}

	public void setPrevisionSeguroInvalidez(Double previsionSeguroInvalidez) {
		this.previsionSeguroInvalidez = previsionSeguroInvalidez;
	}
	
	public Double getMutualCotizacionBasica() {
		return mutualCotizacionBasica;
	}

	public void setMutualCotizacionBasica(Double mutualCotizacionBasica) {
		this.mutualCotizacionBasica = mutualCotizacionBasica;
	}

	public Double getSaludCotizacionBasica() {
		return saludCotizacionBasica;
	}

	public void setSaludCotizacionBasica(Double saludCotizacionBasica) {
		this.saludCotizacionBasica = saludCotizacionBasica;
	}

	public Double getSaludTope() {
		return saludTope;
	}

	public void setSaludTope(Double saludTope) {
		this.saludTope = saludTope;
	}

	public Double getSeguroCesantiaPorcentaje() {
		return seguroCesantiaPorcentaje;
	}

	public void setSeguroCesantiaPorcentaje(Double seguroCesantiaPorcentaje) {
		this.seguroCesantiaPorcentaje = seguroCesantiaPorcentaje;
	}

	public Double getSeguroCesantiaTope() {
		return seguroCesantiaTope;
	}

	public void setSeguroCesantiaTope(Double seguroCesantiaTope) {
		this.seguroCesantiaTope = seguroCesantiaTope;
	}

	public Double getGratificacionPorcentaje() {
		return gratificacionPorcentaje;
	}

	public void setGratificacionPorcentaje(Double gratificacionPorcentaje) {
		this.gratificacionPorcentaje = gratificacionPorcentaje;
	}

	public Double getGratificacionFactorAnual() {
		return gratificacionFactorAnual;
	}

	public void setGratificacionFactorAnual(Double gratificacionFactorAnual) {
		this.gratificacionFactorAnual = gratificacionFactorAnual;
	}

	public Set<Impuesto> getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(Set<Impuesto> impuestos) {
		this.impuestos = impuestos;
	}

	public void addImpuesto(Impuesto impuesto) {
		this.impuestos.add(impuesto);
		impuesto.setMes(this);
	}

	public void removeImpuesto(Impuesto impuesto) {
		this.impuestos.remove(impuesto);
	}

	public Set<Asignacion> getAsignaciones() {
		return asignaciones;
	}

	public void setAsignaciones(Set<Asignacion> asignaciones) {
		this.asignaciones = asignaciones;
	}

	public void addAsignacion(Asignacion asignacion) {
		this.asignaciones.add(asignacion);
		asignacion.setMes(this);
	}

	public void removeAsignacion(Asignacion asignacion) {
		this.asignaciones.remove(asignacion);
	}
	
	public Set<Afp> getAfps() {
		return afps;
	}

	public void setAfps(Set<Afp> afps) {
		this.afps = afps;
	}

	public void addAfp(Afp afp) {
		this.afps.add(afp);
		afp.setMes(this);
	}

	public void removeAfp(Afp afp) {
		this.afps.remove(afp);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof Mes))
			return false;
		Mes that = (Mes) obj;
		return EqualsUtil.areEqual(this.getFecha(), that.getFecha());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getFecha());
		return hashResult;
	}

}