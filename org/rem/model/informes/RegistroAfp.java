package org.rem.model.informes;

public class RegistroAfp {

	private Long id;

	private String nombreAfp;

	private String rutTrabajador;

	private String paterno;

	private String materno;

	private String nombres;

	private Long imponibleFondoPension;

	private Long cotizacionObligatoria;

	private Long ahorroVoluntario;

	private Boolean seguroCesantia;
	
	private Long imponibleFondoCesantia;

	private Long cotizacionAfiliado;

	private Long cotizacionEmpleador;
	
	private Long seguroInvalidez;

	public RegistroAfp() {
	}

	public RegistroAfp(String nombreAfp, String rutTrabajador, String paterno,
			String materno, String nombres, Long imponibleFondoPension,
			Long cotizacionObligatoria, Long ahorroVoluntario,
			Boolean seguroCesantia, Long imponibleFondoCesantia, 
			Long cotizacionAfiliado, Long cotizacionEmpleador, Long seguroInvalidez) {
		super();
		this.nombreAfp = nombreAfp;
		this.rutTrabajador = rutTrabajador;
		this.paterno = paterno;
		this.materno = materno;
		this.nombres = nombres;
		this.imponibleFondoPension = imponibleFondoPension;
		this.cotizacionObligatoria = cotizacionObligatoria;
		this.ahorroVoluntario = ahorroVoluntario;
		this.seguroCesantia = seguroCesantia;
		this.imponibleFondoCesantia = imponibleFondoCesantia;
		this.cotizacionAfiliado = cotizacionAfiliado;
		this.cotizacionEmpleador = cotizacionEmpleador;
		this.seguroInvalidez = seguroInvalidez;
	}

	public Long getAhorroVoluntario() {
		return ahorroVoluntario;
	}

	public void setAhorroVoluntario(Long ahorroVoluntario) {
		this.ahorroVoluntario = ahorroVoluntario;
	}

	public Long getCotizacionAfiliado() {
		return cotizacionAfiliado;
	}

	public void setCotizacionAfiliado(Long cotizacionAfiliado) {
		this.cotizacionAfiliado = cotizacionAfiliado;
	}

	public Long getCotizacionEmpleador() {
		return cotizacionEmpleador;
	}

	public void setCotizacionEmpleador(Long cotizacionEmpleador) {
		this.cotizacionEmpleador = cotizacionEmpleador;
	}

	public Long getCotizacionObligatoria() {
		return cotizacionObligatoria;
	}

	public void setCotizacionObligatoria(Long cotizacionObligatoria) {
		this.cotizacionObligatoria = cotizacionObligatoria;
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public Long getImponibleFondoCesantia() {
		return imponibleFondoCesantia;
	}

	public void setImponibleFondoCesantia(Long imponibleFondoCesantia) {
		this.imponibleFondoCesantia = imponibleFondoCesantia;
	}

	public Long getImponibleFondoPension() {
		return imponibleFondoPension;
	}

	public void setImponibleFondoPension(Long imponibleFondoPension) {
		this.imponibleFondoPension = imponibleFondoPension;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public String getNombreAfp() {
		return nombreAfp;
	}

	public void setNombreAfp(String nombreAfp) {
		this.nombreAfp = nombreAfp;
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

	public Boolean getSeguroCesantia() {
		return seguroCesantia;
	}

	public void setSeguroCesantia(Boolean seguroCesantia) {
		this.seguroCesantia = seguroCesantia;
	}

	public Long getSeguroInvalidez() {
		return seguroInvalidez;
	}

	public void setSeguroInvalidez(Long seguroInvalidez) {
		this.seguroInvalidez = seguroInvalidez;
	}
	
}
