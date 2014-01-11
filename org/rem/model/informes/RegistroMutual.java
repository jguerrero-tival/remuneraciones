package org.rem.model.informes;
public class RegistroMutual {

	private Long id;

	private String rutTrabajador;

	private String paterno;

	private String materno;

	private String nombres;

	private Long imponible;

	private Long accidenteTrabajo;

	public RegistroMutual() {}
	
	public RegistroMutual(String rutTrabajador, String paterno, String materno,
			String nombres, Long imponible, Long accidenteTrabajo) {
		super();
		this.rutTrabajador = rutTrabajador;
		this.paterno = paterno;
		this.materno = materno;
		this.nombres = nombres;
		this.imponible = imponible;
		this.accidenteTrabajo = accidenteTrabajo;
	}

	public Long getAccidenteTrabajo() {
		return accidenteTrabajo;
	}

	public void setAccidenteTrabajo(Long accidenteTrabajo) {
		this.accidenteTrabajo = accidenteTrabajo;
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

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
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
}
