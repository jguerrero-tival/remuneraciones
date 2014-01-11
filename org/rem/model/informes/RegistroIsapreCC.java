package org.rem.model.informes;
public class RegistroIsapreCC {

	private Long id;

	private Long centroCosto;
	
	private String nombreIsapre;

	private String rutTrabajador;

	private String paterno;

	private String materno;

	private String nombres;

	private Long imponible;

	private Long cotizacionLegal;

	private Long cotizacionAdicional;

	private Long cotizacionPagar;

	private Long cotizacionPactada;

	public RegistroIsapreCC() {}
	
	public RegistroIsapreCC(Long centroCosto, String nombreIsapre, String rutTrabajador,
			String paterno, String materno, String nombres, Long imponible,
			Long cotizacionLegal, Long cotizacionAdicional,
			Long cotizacionPagar, Long cotizacionPactada) {
		super();
		this.centroCosto = centroCosto;
		this.nombreIsapre = nombreIsapre;
		this.rutTrabajador = rutTrabajador;
		this.paterno = paterno;
		this.materno = materno;
		this.nombres = nombres;
		this.imponible = imponible;
		this.cotizacionLegal = cotizacionLegal;
		this.cotizacionAdicional = cotizacionAdicional;
		this.cotizacionPagar = cotizacionPagar;
		this.cotizacionPactada = cotizacionPactada;
	}

	public Long getCotizacionAdicional() {
		return cotizacionAdicional;
	}

	public void setCotizacionAdicional(Long cotizacionAdicional) {
		this.cotizacionAdicional = cotizacionAdicional;
	}

	public Long getCotizacionLegal() {
		return cotizacionLegal;
	}

	public void setCotizacionLegal(Long cotizacionLegal) {
		this.cotizacionLegal = cotizacionLegal;
	}

	public Long getCotizacionPactada() {
		return cotizacionPactada;
	}

	public void setCotizacionPactada(Long cotizacionPactada) {
		this.cotizacionPactada = cotizacionPactada;
	}

	public Long getCotizacionPagar() {
		return cotizacionPagar;
	}

	public void setCotizacionPagar(Long cotizacionPagar) {
		this.cotizacionPagar = cotizacionPagar;
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

	public String getNombreIsapre() {
		return nombreIsapre;
	}

	public void setNombreIsapre(String nombreIsapre) {
		this.nombreIsapre = nombreIsapre;
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

	public Long getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(Long centroCosto) {
		this.centroCosto = centroCosto;
	}

}
