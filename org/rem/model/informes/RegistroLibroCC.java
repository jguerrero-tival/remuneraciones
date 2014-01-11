package org.rem.model.informes;

public class RegistroLibroCC {

	private Long id;

	private Long centroCosto; //NEW
	
	private String rutTrabajador;

	private String paterno;

	private String materno;

	private String nombres;

	private Double dias;

	private Long horas;

	private Long sueldoBase;

	private Long pagoHoras;

	private Long otrosImponibles;

	private Long gratificacion;

	private Long imponible;

	private Long asignacionFamiliar;

	private Long movilizacion;

	private Long colacion;

	private Long otrosNoImponibles;

	private Long totalHaberes;

	private String institucionPrevision;

	private Long prevision;

	private Long apv;

	private Long ahorroVoluntario;

	private String institucionSalud;

	private Long salud;

	private Long totalPrevision;

	private Long seguroCesantia;

	private Long totalAfecto;

	private Long impuesto;

	private Long diferenciaIsapre;

	private Long anticipo;

	private Long otrosDescuentos;

	private Long totalDescuentos;

	private Long liquido;
	
	private Long valorHoraProfesor;

	private Long horasProfesor;

	/* Nuevos registros colegio */
	
	private Long ump;
	private Long bpp80;
	private Long bcomp80;
	private Long ley19464;
	private Long bonoResponsabilidad;
	private Long leySep;
	private Long jefaturaCurso;
	private Long bonoReconocimiento;
	
	public RegistroLibroCC() {}
	
	public RegistroLibroCC(Long centroCosto, String rutTrabajador, String paterno, String materno,
			String nombres, Double dias, Long horas, Long sueldoBase,
			Long pagoHoras, Long otrosImponibles, Long gratificacion,
			Long imponible, Long asignacionFamiliar, Long movilizacion,
			Long colacion, Long otrosNoImponibles, Long totalHaberes,
			String institucionPrevision, Long prevision, Long apv,
			Long ahorroVoluntario, String institucionSalud, Long salud,
			Long totalPrevision, Long seguroCesantia, Long totalAfecto,
			Long impuesto, Long diferenciaIsapre, Long anticipo,
			Long otrosDescuentos, Long totalDescuentos, Long liquido, Long valorHoraProfesor, Long horasProfesor,
			Long ump, Long bpp80, Long bcomp80, Long ley19464, Long bonoResponsabilidad, 
			Long leySep, Long jefaturaCurso, Long bonoReconocimiento) {
		super();
		this.centroCosto = centroCosto;
		this.rutTrabajador = rutTrabajador;
		this.paterno = paterno;
		this.materno = materno;
		this.nombres = nombres;
		this.dias = dias;
		this.horas = horas;
		this.sueldoBase = sueldoBase;
		this.pagoHoras = pagoHoras;
		this.otrosImponibles = otrosImponibles;
		this.gratificacion = gratificacion;
		this.imponible = imponible;
		this.asignacionFamiliar = asignacionFamiliar;
		this.movilizacion = movilizacion;
		this.colacion = colacion;
		this.otrosNoImponibles = otrosNoImponibles;
		this.totalHaberes = totalHaberes;
		this.institucionPrevision = institucionPrevision;
		this.prevision = prevision;
		this.apv = apv;
		this.ahorroVoluntario = ahorroVoluntario;
		this.institucionSalud = institucionSalud;
		this.salud = salud;
		this.totalPrevision = totalPrevision;
		this.seguroCesantia = seguroCesantia;
		this.totalAfecto = totalAfecto;
		this.impuesto = impuesto;
		this.diferenciaIsapre = diferenciaIsapre;
		this.anticipo = anticipo;
		this.otrosDescuentos = otrosDescuentos;
		this.totalDescuentos = totalDescuentos;
		this.liquido = liquido;
		this.valorHoraProfesor = valorHoraProfesor;
		this.horasProfesor = horasProfesor;
		this.ump=ump;
		this.bpp80=bpp80;
		this.bcomp80=bcomp80;
		this.ley19464=ley19464;
		this.bonoResponsabilidad=bonoResponsabilidad;
		this.leySep=leySep;
		this.jefaturaCurso=jefaturaCurso;
		this.bonoReconocimiento=bonoReconocimiento;
	}

	public Long getValorHoraProfesor() {
		return valorHoraProfesor;
	}

	public void setValorHoraProfesor(Long valorHoraProfesor) {
		this.valorHoraProfesor = valorHoraProfesor;
	}

	public Long getHorasProfesor() {
		return horasProfesor;
	}

	public void setHorasProfesor(Long horasProfesor) {
		this.horasProfesor = horasProfesor;
	}

	public Long getAhorroVoluntario() {
		return ahorroVoluntario;
	}

	public void setAhorroVoluntario(Long ahorroVoluntario) {
		this.ahorroVoluntario = ahorroVoluntario;
	}

	public Long getAnticipo() {
		return anticipo;
	}

	public void setAnticipo(Long anticipo) {
		this.anticipo = anticipo;
	}

	public Long getApv() {
		return apv;
	}

	public void setApv(Long apv) {
		this.apv = apv;
	}

	public Long getAsignacionFamiliar() {
		return asignacionFamiliar;
	}

	public void setAsignacionFamiliar(Long asignacionFamiliar) {
		this.asignacionFamiliar = asignacionFamiliar;
	}

	public Long getColacion() {
		return colacion;
	}

	public void setColacion(Long colacion) {
		this.colacion = colacion;
	}

	public Double getDias() {
		return dias;
	}

	public void setDias(Double dias) {
		this.dias = dias;
	}

	public Long getDiferenciaIsapre() {
		return diferenciaIsapre;
	}

	public void setDiferenciaIsapre(Long diferenciaIsapre) {
		this.diferenciaIsapre = diferenciaIsapre;
	}

	public Long getGratificacion() {
		return gratificacion;
	}

	public void setGratificacion(Long gratificacion) {
		this.gratificacion = gratificacion;
	}

	public Long getHoras() {
		return horas;
	}

	public void setHoras(Long horas) {
		this.horas = horas;
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

	public Long getImpuesto() {
		return impuesto;
	}

	public void setImpuesto(Long impuesto) {
		this.impuesto = impuesto;
	}

	public String getInstitucionPrevision() {
		return institucionPrevision;
	}

	public void setInstitucionPrevision(String institucionPrevision) {
		this.institucionPrevision = institucionPrevision;
	}

	public String getInstitucionSalud() {
		return institucionSalud;
	}

	public void setInstitucionSalud(String institucionSalud) {
		this.institucionSalud = institucionSalud;
	}

	public Long getLiquido() {
		return liquido;
	}

	public void setLiquido(Long liquido) {
		this.liquido = liquido;
	}

	public String getMaterno() {
		return materno;
	}

	public void setMaterno(String materno) {
		this.materno = materno;
	}

	public Long getMovilizacion() {
		return movilizacion;
	}

	public void setMovilizacion(Long movilizacion) {
		this.movilizacion = movilizacion;
	}

	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public Long getOtrosDescuentos() {
		return otrosDescuentos;
	}

	public void setOtrosDescuentos(Long otrosDescuentos) {
		this.otrosDescuentos = otrosDescuentos;
	}

	public Long getOtrosImponibles() {
		return otrosImponibles;
	}

	public void setOtrosImponibles(Long otrosImponibles) {
		this.otrosImponibles = otrosImponibles;
	}

	public Long getOtrosNoImponibles() {
		return otrosNoImponibles;
	}

	public void setOtrosNoImponibles(Long otrosNoImponibles) {
		this.otrosNoImponibles = otrosNoImponibles;
	}

	public Long getPagoHoras() {
		return pagoHoras;
	}

	public void setPagoHoras(Long pagoHoras) {
		this.pagoHoras = pagoHoras;
	}

	public String getPaterno() {
		return paterno;
	}

	public void setPaterno(String paterno) {
		this.paterno = paterno;
	}

	public Long getPrevision() {
		return prevision;
	}

	public void setPrevision(Long prevision) {
		this.prevision = prevision;
	}

	public String getRutTrabajador() {
		return rutTrabajador;
	}

	public void setRutTrabajador(String rutTrabajador) {
		this.rutTrabajador = rutTrabajador;
	}

	public Long getSalud() {
		return salud;
	}

	public void setSalud(Long salud) {
		this.salud = salud;
	}

	public Long getSeguroCesantia() {
		return seguroCesantia;
	}

	public void setSeguroCesantia(Long seguroCesantia) {
		this.seguroCesantia = seguroCesantia;
	}

	public Long getSueldoBase() {
		return sueldoBase;
	}

	public void setSueldoBase(Long sueldoBase) {
		this.sueldoBase = sueldoBase;
	}

	public Long getTotalAfecto() {
		return totalAfecto;
	}

	public void setTotalAfecto(Long totalAfecto) {
		this.totalAfecto = totalAfecto;
	}

	public Long getTotalDescuentos() {
		return totalDescuentos;
	}

	public void setTotalDescuentos(Long totalDescuentos) {
		this.totalDescuentos = totalDescuentos;
	}

	public Long getTotalHaberes() {
		return totalHaberes;
	}

	public void setTotalHaberes(Long totalHaberes) {
		this.totalHaberes = totalHaberes;
	}

	public Long getTotalPrevision() {
		return totalPrevision;
	}

	public void setTotalPrevision(Long totalPrevision) {
		this.totalPrevision = totalPrevision;
	}

	public Long getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(Long centroCosto) {
		this.centroCosto = centroCosto;
	}


	/* Nuevos getters and setters colegio */
	
	
	public Long getUmp() {
		return ump;
	}

	public void setUmp(Long ump) {
		this.ump = ump;
	}

	public Long getBpp80() {
		return bpp80;
	}

	public void setBpp80(Long bpp80) {
		this.bpp80 = bpp80;
	}

	public Long getBcomp80() {
		return bcomp80;
	}

	public void setBcomp80(Long bcomp80) {
		this.bcomp80 = bcomp80;
	}

	public Long getLey19464() {
		return ley19464;
	}

	public void setLey19464(Long ley19464) {
		this.ley19464 = ley19464;
	}

	public Long getBonoResponsabilidad() {
		return bonoResponsabilidad;
	}

	public void setBonoResponsabilidad(Long bonoResponsabilidad) {
		this.bonoResponsabilidad = bonoResponsabilidad;
	}

	public Long getLeySep() {
		return leySep;
	}

	public void setLeySep(Long leySep) {
		this.leySep = leySep;
	}

	public Long getJefaturaCurso() {
		return jefaturaCurso;
	}

	public void setJefaturaCurso(Long jefaturaCurso) {
		this.jefaturaCurso = jefaturaCurso;
	}

	public Long getBonoReconocimiento() {
		return bonoReconocimiento;
	}

	public void setBonoReconocimiento(Long bonoReconocimiento) {
		this.bonoReconocimiento = bonoReconocimiento;
	}
	
}
