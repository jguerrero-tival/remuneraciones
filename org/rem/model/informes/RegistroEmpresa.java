package org.rem.model.informes;
import java.util.Date;

public class RegistroEmpresa {

	private Long id;

	private Date fecha;

	private String fechaTexto;

	private String rutEmpresa;

	private String razonSocial;

	private String actividad;

	private String calle;

	private String numero;

	private String comuna;

	private String ciudad;

	private String region;

	private String telefono;

	private String rutRepresentante;

	private String nombreRepresentante;

	private String nombreMutual;

	private String nombreCaja;

	private Double cotizacionAccidenteTrabajo;

	public RegistroEmpresa() {}
	
	public RegistroEmpresa(Date fecha, String fechaTexto, String rutEmpresa,
			String razonSocial, String actividad, String calle, String numero,
			String comuna, String ciudad, String region, String telefono,
			String rutRepresentante, String nombreRepresentante,
			String nombreMutual, String nombreCaja,
			Double cotizacionAccidenteTrabajo) {
		super();
		this.fecha = fecha;
		this.fechaTexto = fechaTexto;
		this.rutEmpresa = rutEmpresa;
		this.razonSocial = razonSocial;
		this.actividad = actividad;
		this.calle = calle;
		this.numero = numero;
		this.comuna = comuna;
		this.ciudad = ciudad;
		this.region = region;
		this.telefono = telefono;
		this.rutRepresentante = rutRepresentante;
		this.nombreRepresentante = nombreRepresentante;
		this.nombreMutual = nombreMutual;
		this.nombreCaja = nombreCaja;
		this.cotizacionAccidenteTrabajo = cotizacionAccidenteTrabajo;
	}

	public String getActividad() {
		return actividad;
	}

	public void setActividad(String actividad) {
		this.actividad = actividad;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getComuna() {
		return comuna;
	}

	public void setComuna(String comuna) {
		this.comuna = comuna;
	}

	public Double getCotizacionAccidenteTrabajo() {
		return cotizacionAccidenteTrabajo;
	}

	public void setCotizacionAccidenteTrabajo(Double cotizacionAccidenteTrabajo) {
		this.cotizacionAccidenteTrabajo = cotizacionAccidenteTrabajo;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getFechaTexto() {
		return fechaTexto;
	}

	public void setFechaTexto(String fechaTexto) {
		this.fechaTexto = fechaTexto;
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public String getNombreCaja() {
		return nombreCaja;
	}

	public void setNombreCaja(String nombreCaja) {
		this.nombreCaja = nombreCaja;
	}

	public String getNombreMutual() {
		return nombreMutual;
	}

	public void setNombreMutual(String nombreMutual) {
		this.nombreMutual = nombreMutual;
	}

	public String getNombreRepresentante() {
		return nombreRepresentante;
	}

	public void setNombreRepresentante(String nombreRepresentante) {
		this.nombreRepresentante = nombreRepresentante;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getRazonSocial() {
		return razonSocial;
	}

	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
	}

	public String getRutEmpresa() {
		return rutEmpresa;
	}

	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	public String getRutRepresentante() {
		return rutRepresentante;
	}

	public void setRutRepresentante(String rutRepresentante) {
		this.rutRepresentante = rutRepresentante;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

}
