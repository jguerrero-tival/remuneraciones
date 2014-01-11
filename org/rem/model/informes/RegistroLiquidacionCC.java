package org.rem.model.informes;
public class RegistroLiquidacionCC {

	private Long id;

	private Long centroCosto; //NEW
	
	private String rutTrabajador;

	private String paterno;

	private String materno;

	private String nombres;

	private Double dias;
	
	public RegistroLiquidacionCC() {}
	
	public RegistroLiquidacionCC(Long centroCosto, String rutTrabajador, String paterno,
			String materno, String nombres, Double dias) {
		super();
		this.centroCosto = centroCosto;
		this.rutTrabajador = rutTrabajador;
		this.paterno = paterno;
		this.materno = materno;
		this.nombres = nombres;
		this.dias = dias;
	}

	public Double getDias() {
		return dias;
	}

	public Long getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(Long centroCosto) {
		this.centroCosto = centroCosto;
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