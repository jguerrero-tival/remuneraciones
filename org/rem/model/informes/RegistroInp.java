package org.rem.model.informes;
public class RegistroInp {

	private Long id;

	private String rutTrabajador;

	private String paterno;

	private String materno;

	private String nombres;

	private Double dias;

	private Long imponible;

	private Long pension;

	private Long fonasa;

	private Long accidenteTrabajo;

	private String tramo;

	private Long numeroCargaSimple;

	private Long montoCargaSimple;

	private Long numeroCargaInvalida;

	private Long montoCargaInvalida;

	private Long numeroCargaMaternal;

	private Long montoCargaMaternal;

	public RegistroInp() {}
	
	public RegistroInp(String rutTrabajador, String paterno, String materno,
			String nombres, Double dias, Long imponible, Long pension,
			Long fonasa, Long accidenteTrabajo, String tramo,
			Long numeroCargaSimple, Long montoCargaSimple,
			Long numeroCargaInvalida, Long montoCargaInvalida,
			Long numeroCargaMaternal, Long montoCargaMaternal) {
		super();
		this.rutTrabajador = rutTrabajador;
		this.paterno = paterno;
		this.materno = materno;
		this.nombres = nombres;
		this.dias = dias;
		this.imponible = imponible;
		this.pension = pension;
		this.fonasa = fonasa;
		this.accidenteTrabajo = accidenteTrabajo;
		this.tramo = tramo;
		this.numeroCargaSimple = numeroCargaSimple;
		this.montoCargaSimple = montoCargaSimple;
		this.numeroCargaInvalida = numeroCargaInvalida;
		this.montoCargaInvalida = montoCargaInvalida;
		this.numeroCargaMaternal = numeroCargaMaternal;
		this.montoCargaMaternal = montoCargaMaternal;
	}

	public Long getAccidenteTrabajo() {
		return accidenteTrabajo;
	}

	public void setAccidenteTrabajo(Long accidenteTrabajo) {
		this.accidenteTrabajo = accidenteTrabajo;
	}

	public Double getDias() {
		return dias;
	}

	public void setDias(Double dias) {
		this.dias = dias;
	}

	public Long getFonasa() {
		return fonasa;
	}

	public void setFonasa(Long fonasa) {
		this.fonasa = fonasa;
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public Long getImponible() {
		return imponible;
	}

	public void setImponible(Long imponible) {
		this.imponible = imponible;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Long getMontoCargaInvalida() {
		return montoCargaInvalida;
	}

	public void setMontoCargaInvalida(Long montoCargaInvalida) {
		this.montoCargaInvalida = montoCargaInvalida;
	}

	public Long getMontoCargaMaternal() {
		return montoCargaMaternal;
	}

	public void setMontoCargaMaternal(Long montoCargaMaternal) {
		this.montoCargaMaternal = montoCargaMaternal;
	}

	public Long getMontoCargaSimple() {
		return montoCargaSimple;
	}

	public void setMontoCargaSimple(Long montoCargaSimple) {
		this.montoCargaSimple = montoCargaSimple;
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

	public Long getPension() {
		return pension;
	}

	public void setPension(Long pension) {
		this.pension = pension;
	}

	public String getRutTrabajador() {
		return rutTrabajador;
	}

	public void setRutTrabajador(String rutTrabajador) {
		this.rutTrabajador = rutTrabajador;
	}

	public String getTramo() {
		return tramo;
	}

	public void setTramo(String tramo) {
		this.tramo = tramo;
	}

}
