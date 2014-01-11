package org.rem.model.informes;

public class RegistroLiquidacionDescuentoLegalCC {

	private Long id;
	
	private Long centroCosto;

	private String rutTrabajador;

	private String nombre;

	private long valor;

	public RegistroLiquidacionDescuentoLegalCC() {}
	
	public RegistroLiquidacionDescuentoLegalCC(Long centroCosto, String rutTrabajador,
			String nombre, long valor) {
		super();
		this.centroCosto = centroCosto;
		this.rutTrabajador = rutTrabajador;
		this.nombre = nombre;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	@SuppressWarnings("unused")
	private void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRutTrabajador() {
		return rutTrabajador;
	}

	public void setRutTrabajador(String rutTrabajador) {
		this.rutTrabajador = rutTrabajador;
	}

	public long getValor() {
		return valor;
	}

	public void setValor(long valor) {
		this.valor = valor;
	}

	public Long getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(Long centroCosto) {
		this.centroCosto = centroCosto;
	}

}
