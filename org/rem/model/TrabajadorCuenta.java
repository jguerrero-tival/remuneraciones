package org.rem.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.rem.model.Afp;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class TrabajadorCuenta implements Serializable {

	private Long idTrabajadorCuenta;

	private Boolean cerrada;

	/* contrato */

	private String trato;

	private String formaPago;

	private String tipoContrato;

	private Boolean seguroCesantia;

	/* prevision */

	private Afp afp;
	
	private Afp afp2;//SE utiliza en el caso de que el trabajador de regimen antiguo tenga seguro de cesantia

	// no se aplica a regimen antiguo

	private String tipoAhorroVoluntario;

	private Double valorAhorroVoluntario;

	/* salud */

	private String tipoSalud;

	// no se aplica a fonasa

	private Isapre isapre;

	private String tipoPactoIsapre;

	private Double valorPactoIsapre;

	/* cargas */

	private Boolean cargas;

	private Double sueldoPromedio;

	private Long numeroCargasNormal;

	private Long numeroCargasInvalida;

	/* otros */

	private Trabajador trabajador;

	private EmpresaCuenta empresaCuenta;

	private Set<TrabajadorCentroCosto> trabajadorCentroCostos = new HashSet<TrabajadorCentroCosto>();

	private Set<TrabajadorDescuento> trabajadorDescuentos = new HashSet<TrabajadorDescuento>();

	private Set<TrabajadorImponible> trabajadorImponibles = new HashSet<TrabajadorImponible>();

	private Set<TrabajadorNoImponible> trabajadorNoImponibles = new HashSet<TrabajadorNoImponible>();

	public TrabajadorCuenta() {
	}

	public TrabajadorCuenta(TrabajadorCuenta cuenta) {
		this.setCerrada(new Boolean(false));
		this.setTrato(cuenta.getTrato());
		this.setFormaPago(cuenta.getFormaPago());
		this.setTipoContrato(cuenta.getTipoContrato());
		this.setSeguroCesantia(cuenta.isSeguroCesantia());
		this.setAfp(cuenta.getAfp());
		this.setAfp2(cuenta.getAfp2());		
		this.setTipoAhorroVoluntario(cuenta.getTipoAhorroVoluntario());
		this.setValorAhorroVoluntario(cuenta.getValorAhorroVoluntario());
		this.setTipoSalud(cuenta.getTipoSalud());
		this.setIsapre(cuenta.getIsapre());
		this.setTipoPactoIsapre(cuenta.getTipoPactoIsapre());
		this.setValorPactoIsapre(cuenta.getValorPactoIsapre());
		this.setCargas(cuenta.isCargas());
		this.setSueldoPromedio(cuenta.getSueldoPromedio());
		this.setNumeroCargasNormal(cuenta.getNumeroCargasNormal());
		this.setNumeroCargasInvalida(cuenta.getNumeroCargasInvalida());
	}

	public TrabajadorCuenta(String trato, String formaPago,
			String tipoContrato, Boolean seguroCesantia, Afp afp,
			String tipoAhorroVoluntario, Double valorAhorroVoluntario,
			String tipoSalud, Isapre isapre, String tipoPactoIsapre,
			Double valorPactoIsapre, Boolean cargas, Double sueldoPromedio,
			Long numeroCargasNormal, Long numeroCargasInvalida) {
		this.setCerrada(new Boolean(false));
		this.setTrato(trato);
		this.setFormaPago(formaPago);
		this.setTipoContrato(tipoContrato);
		this.setSeguroCesantia(seguroCesantia);
		this.setAfp(afp);
		this.setAfp2(null);
		this.setTipoAhorroVoluntario(tipoAhorroVoluntario);
		this.setValorAhorroVoluntario(valorAhorroVoluntario);
		this.setTipoSalud(tipoSalud);
		this.setIsapre(isapre);
		this.setTipoPactoIsapre(tipoPactoIsapre);
		this.setValorPactoIsapre(valorPactoIsapre);
		this.setCargas(cargas);
		this.setSueldoPromedio(sueldoPromedio);
		this.setNumeroCargasNormal(numeroCargasNormal);
		this.setNumeroCargasInvalida(numeroCargasInvalida);
	}
	
	public TrabajadorCuenta(String trato, String formaPago,
			String tipoContrato, Boolean seguroCesantia, Afp afp, Afp afp2,
			String tipoAhorroVoluntario, Double valorAhorroVoluntario,
			String tipoSalud, Isapre isapre, String tipoPactoIsapre,
			Double valorPactoIsapre, Boolean cargas, Double sueldoPromedio,
			Long numeroCargasNormal, Long numeroCargasInvalida) {
		this.setCerrada(new Boolean(false));
		this.setTrato(trato);
		this.setFormaPago(formaPago);
		this.setTipoContrato(tipoContrato);
		this.setSeguroCesantia(seguroCesantia);
		this.setAfp(afp);
		this.setAfp2(afp2);
		this.setTipoAhorroVoluntario(tipoAhorroVoluntario);
		this.setValorAhorroVoluntario(valorAhorroVoluntario);
		this.setTipoSalud(tipoSalud);
		this.setIsapre(isapre);
		this.setTipoPactoIsapre(tipoPactoIsapre);
		this.setValorPactoIsapre(valorPactoIsapre);
		this.setCargas(cargas);
		this.setSueldoPromedio(sueldoPromedio);
		this.setNumeroCargasNormal(numeroCargasNormal);
		this.setNumeroCargasInvalida(numeroCargasInvalida);
	}

	public Long getIdTrabajadorCuenta() {
		return idTrabajadorCuenta;
	}

	@SuppressWarnings("unused")
	private void setIdTrabajadorCuenta(Long idTrabajadorCuenta) {
		this.idTrabajadorCuenta = idTrabajadorCuenta;
	}

	public Boolean isCerrada() {
		return cerrada;
	}

	public void setCerrada(Boolean cerrada) {
		this.cerrada = cerrada;
	}

	public String getTrato() {
		return trato;
	}

	public void setTrato(String trato) {
		this.trato = trato;
	}

	public String getFormaPago() {
		return formaPago;
	}

	public void setFormaPago(String formaPago) {
		this.formaPago = formaPago;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Boolean isSeguroCesantia() {
		return seguroCesantia;
	}

	public void setSeguroCesantia(Boolean seguroCesantia) {
		this.seguroCesantia = seguroCesantia;
	}

	public Afp getAfp() {
		return afp;
	}

	public void setAfp(Afp afp) {
		this.afp = afp;
	}

	public Afp getAfp2() {
		return afp2;
	}

	public void setAfp2(Afp afp2) {
		this.afp2 = afp2;
	}

	public String getTipoAhorroVoluntario() {
		return tipoAhorroVoluntario;
	}

	public void setTipoAhorroVoluntario(String tipoAhorroVoluntario) {
		this.tipoAhorroVoluntario = tipoAhorroVoluntario;
	}

	public Double getValorAhorroVoluntario() {
		return valorAhorroVoluntario;
	}

	public void setValorAhorroVoluntario(Double valorAhorroVoluntario) {
		this.valorAhorroVoluntario = valorAhorroVoluntario;
	}

	public String getTipoSalud() {
		return tipoSalud;
	}

	public void setTipoSalud(String tipoSalud) {
		this.tipoSalud = tipoSalud;
	}

	public Isapre getIsapre() {
		return isapre;
	}

	public void setIsapre(Isapre isapre) {
		this.isapre = isapre;
	}

	public String getTipoPactoIsapre() {
		return tipoPactoIsapre;
	}

	public void setTipoPactoIsapre(String tipoPactoIsapre) {
		this.tipoPactoIsapre = tipoPactoIsapre;
	}

	public Double getValorPactoIsapre() {
		return valorPactoIsapre;
	}

	public void setValorPactoIsapre(Double valorPactoIsapre) {
		this.valorPactoIsapre = valorPactoIsapre;
	}

	public Boolean isCargas() {
		return cargas;
	}

	public void setCargas(Boolean cargas) {
		this.cargas = cargas;
	}

	public Double getSueldoPromedio() {
		return sueldoPromedio;
	}

	public void setSueldoPromedio(Double sueldoPromedio) {
		this.sueldoPromedio = sueldoPromedio;
	}

	public Long getNumeroCargasNormal() {
		return numeroCargasNormal;
	}

	public void setNumeroCargasNormal(Long numeroCargasNormal) {
		this.numeroCargasNormal = numeroCargasNormal;
	}

	public Long getNumeroCargasInvalida() {
		return numeroCargasInvalida;
	}

	public void setNumeroCargasInvalida(Long numeroCargasInvalida) {
		this.numeroCargasInvalida = numeroCargasInvalida;
	}

	public Trabajador getTrabajador() {
		return trabajador;
	}

	public void setTrabajador(Trabajador trabajador) {
		this.trabajador = trabajador;
	}
	
	public EmpresaCuenta getEmpresaCuenta() {
		return empresaCuenta;
	}

	public void setEmpresaCuenta(EmpresaCuenta empresaCuenta) {
		this.empresaCuenta = empresaCuenta;
	}

	public Set<TrabajadorCentroCosto> getTrabajadorCentroCostos() {
		return trabajadorCentroCostos;
	}

	public void setTrabajadorCentroCostos(
			Set<TrabajadorCentroCosto> trabajadorCentroCostos) {
		this.trabajadorCentroCostos = trabajadorCentroCostos;
	}

	public void addTrabajadorCentroCosto(TrabajadorCentroCosto obj) {
		this.trabajadorCentroCostos.add(obj);
		obj.setTrabajadorCuenta(this);
	}

	public void removeTrabajadorCentroCosto(TrabajadorCentroCosto obj) {
		this.trabajadorCentroCostos.remove(obj);
	}

	public Set<TrabajadorDescuento> getTrabajadorDescuentos() {
		return trabajadorDescuentos;
	}

	public void setTrabajadorDescuentos(
			Set<TrabajadorDescuento> trabajadorDescuentos) {
		this.trabajadorDescuentos = trabajadorDescuentos;
	}

	public void addTrabajadorDescuento(TrabajadorDescuento obj) {
		this.trabajadorDescuentos.add(obj);
		obj.setTrabajadorCuenta(this);
	}

	public void removeTrabajadorDescuento(TrabajadorDescuento obj) {
		this.trabajadorDescuentos.remove(obj);
	}

	public Set<TrabajadorImponible> getTrabajadorImponibles() {
		return trabajadorImponibles;
	}

	public void setTrabajadorImponibles(
			Set<TrabajadorImponible> trabajadorImponibles) {
		this.trabajadorImponibles = trabajadorImponibles;
	}

	public void addTrabajadorImponible(TrabajadorImponible obj) {
		this.trabajadorImponibles.add(obj);
		obj.setTrabajadorCuenta(this);
	}

	public void removeTrabajadorImponible(TrabajadorImponible obj) {
		this.trabajadorImponibles.remove(obj);
	}

	public Set<TrabajadorNoImponible> getTrabajadorNoImponibles() {
		return trabajadorNoImponibles;
	}

	public void setTrabajadorNoImponibles(
			Set<TrabajadorNoImponible> trabajadorNoImponibles) {
		this.trabajadorNoImponibles = trabajadorNoImponibles;
	}

	public void addTrabajadorNoImponible(TrabajadorNoImponible obj) {
		this.trabajadorNoImponibles.add(obj);
		obj.setTrabajadorCuenta(this);
	}

	public void removeTrabajadorNoImponible(TrabajadorNoImponible obj) {
		this.trabajadorNoImponibles.remove(obj);
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof TrabajadorCuenta))
			return false;
		TrabajadorCuenta that = (TrabajadorCuenta) obj;
		return EqualsUtil.areEqual(this.getTrabajador(), that.getTrabajador())
				&& EqualsUtil.areEqual(this.getEmpresaCuenta(), that.getEmpresaCuenta());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getTrabajador());
		hashResult = HashCodeUtil.hash(hashResult, this.getEmpresaCuenta());
		return hashResult;
	}

}