package org.rem.model.informes;
public class RegistroCajaCC {

	private Long id;

	private Long centroCosto;
	
	private String rutTrabajador;

	private String paterno;

	private String materno;

	private String nombres;

	private Long imponibleNoAfiliado;
	
	private Long cotizacionNoAfiliado;

	private Long imponibleAfiliado;

	private Double dias;

	private Long numeroCargaSimple;

	private Long numeroCargaInvalida;

	private Long numeroCargaMaternal;

	private Long asignacionFamiliar;
	
	private String tramoAsignacionFamiliar;

	public RegistroCajaCC() {}
	
	public RegistroCajaCC(Long centroCosto, String rutTrabajador, String paterno, String materno,
			String nombres, Long imponibleNoAfiliado, Long imponibleAfiliado,
			Double dias, Long numeroCargaSimple, Long numeroCargaInvalida,
			Long numeroCargaMaternal, Long asignacionFamiliar, Long cotizacionNoAfiliado, String tramoAsignacionFamiliar) {
		super();
		this.centroCosto = centroCosto;
		this.rutTrabajador = rutTrabajador;
		this.paterno = paterno;
		this.materno = materno;
		this.nombres = nombres;
		this.imponibleNoAfiliado = imponibleNoAfiliado;
		this.cotizacionNoAfiliado = cotizacionNoAfiliado;
		this.imponibleAfiliado = imponibleAfiliado;
		this.dias = dias;
		this.numeroCargaSimple = numeroCargaSimple;
		this.numeroCargaInvalida = numeroCargaInvalida;
		this.numeroCargaMaternal = numeroCargaMaternal;
		this.asignacionFamiliar = asignacionFamiliar;
		this.tramoAsignacionFamiliar = tramoAsignacionFamiliar;
	}

	public Long getAsignacionFamiliar() {
		return asignacionFamiliar;
	}

	public void setAsignacionFamiliar(Long asignacionFamiliar) {
		this.asignacionFamiliar = asignacionFamiliar;
	}
	
	public String getTramoAsignacionFamiliar() {
		return tramoAsignacionFamiliar;
	}

	public void setTramoAsignacionFamiliar(String tramoAsignacionFamiliar) {
		this.tramoAsignacionFamiliar = tramoAsignacionFamiliar;
	}

	public Double getDias() {
		return dias;
	}

	public void setDias(Double dias) {
		this.dias = dias;
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public Long getImponibleAfiliado() {
		return imponibleAfiliado;
	}

	public void setImponibleAfiliado(Long imponibleAfiliado) {
		this.imponibleAfiliado = imponibleAfiliado;
	}

	public Long getImponibleNoAfiliado() {
		return imponibleNoAfiliado;
	}

	public void setImponibleNoAfiliado(Long imponibleNoAfiliado) {
		this.imponibleNoAfiliado = imponibleNoAfiliado;
	}
	
	public Long getCotizacionNoAfiliado() {
		return cotizacionNoAfiliado;
	}

	public void setCotizacionNoAfiliado(Long cotizacionNoAfiliado) {
		this.cotizacionNoAfiliado = cotizacionNoAfiliado;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Long getNumeroCargaInvalida() {
		return numeroCargaInvalida;
	}

	public void setNumeroCargaInvalida(Long numeroCargaInvalida) {
		this.numeroCargaInvalida = numeroCargaInvalida;
	}

	public Long getNumeroCargaMaternal() {
		return numeroCargaMaternal;
	}

	public void setNumeroCargaMaternal(Long numeroCargaMaternal) {
		this.numeroCargaMaternal = numeroCargaMaternal;
	}

	public Long getNumeroCargaSimple() {
		return numeroCargaSimple;
	}

	public void setNumeroCargaSimple(Long numeroCargaSimple) {
		this.numeroCargaSimple = numeroCargaSimple;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public String getRutTrabajador() {
		return rutTrabajador;
	}

	public void setRutTrabajador(String rutTrabajador) {
		this.rutTrabajador = rutTrabajador;
	}

	public Long getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(Long centroCosto) {
		this.centroCosto = centroCosto;
	}

}
