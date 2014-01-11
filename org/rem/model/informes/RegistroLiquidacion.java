package org.rem.model.informes;
public class RegistroLiquidacion {

	private Long id;

	private String rutTrabajador;

	private String paterno;

	private String materno;

	private String nombres;

	private Double dias;
	
	public RegistroLiquidacion() {}
	
	public RegistroLiquidacion(String rutTrabajador, String paterno,
			String materno, String nombres, Double dias) {
		super();
		this.rutTrabajador = rutTrabajador;
		this.paterno = paterno;
		this.materno = materno;
		this.nombres = nombres;
		this.dias = dias;
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