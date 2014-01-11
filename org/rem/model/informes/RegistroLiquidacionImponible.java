package org.rem.model.informes;

public class RegistroLiquidacionImponible {

	private Long id;

	private String rutTrabajador;

	private String nombre;

	private Long valor;

	public RegistroLiquidacionImponible() {}
	
	public RegistroLiquidacionImponible(String rutTrabajador,
			String nombre, Long valor) {
		super();
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

	public Long getValor() {
		return valor;
	}

	public void setValor(Long valor) {
		this.valor = valor;
	}

}
