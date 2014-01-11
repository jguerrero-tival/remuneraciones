/** MODIFICACIONES DE LA LINEA 454 A LA 522
 * PARA EL ASUNTO DE LA ASIGNACION FAMILIAR 
 * DEL HOGAR ARTURO PRAT.
 */
package org.rem.informes;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import org.rem.dao.AsignacionDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaCuentaDao;
import org.rem.dao.EmpresaDao;
import org.rem.dao.ImpuestoDao;
import org.rem.dao.MesDao;
import org.rem.dao.RegistroAfpDao;
import org.rem.dao.RegistroCajaDao;
import org.rem.dao.RegistroEmpresaDao;
import org.rem.dao.RegistroInpDao;
import org.rem.dao.RegistroIsapreDao;
import org.rem.dao.RegistroLibroDao;
import org.rem.dao.RegistroLiquidacionDao;
import org.rem.dao.RegistroLiquidacionDescuentoLegalDao;
import org.rem.dao.RegistroLiquidacionDescuentoVarioDao;
import org.rem.dao.RegistroLiquidacionImponibleDao;
import org.rem.dao.RegistroLiquidacionNoImponibleDao;
import org.rem.dao.RegistroMutualDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Asignacion;
import org.rem.model.Empresa;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Impuesto;
import org.rem.model.Mes;
import org.rem.model.Persona;
import org.rem.model.TrabajadorCentroCosto;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorDescuento;
import org.rem.model.TrabajadorImponible;
import org.rem.model.TrabajadorNoImponible;
import org.rem.model.informes.RegistroAfp;
import org.rem.model.informes.RegistroCaja;
import org.rem.model.informes.RegistroEmpresa;
import org.rem.model.informes.RegistroInp;
import org.rem.model.informes.RegistroIsapre;
import org.rem.model.informes.RegistroLibro;
import org.rem.model.informes.RegistroLiquidacion;
import org.rem.model.informes.RegistroLiquidacionDescuentoLegal;
import org.rem.model.informes.RegistroLiquidacionDescuentoVario;
import org.rem.model.informes.RegistroLiquidacionImponible;
import org.rem.model.informes.RegistroLiquidacionNoImponible;
import org.rem.model.informes.RegistroMutual;
import org.rem.util.Fecha;
import org.rem.util.Palabra;

public class CalculoInformes {
	
	/* Constantes imponible colegios */
	
	Long ID_UMP = 16L;
	Long ID_BPP80 = 17L;
	Long ID_BCOMP80 = 27L;
	Long ID_LEY_19464 = 8L;
	Long ID_BONO_RESPONSABILIDAD = 43L;
	Long ID_LEY_SEP = 47L;
	Long ID_JEFATURA_CURSO = 15L;
	Long ID_BONO_RECONOCIMIENTO = 38L;
	
	// registros
	private RegistroEmpresa registroEmpresa;

	private LinkedList<RegistroLibro> registroLibro = new LinkedList<RegistroLibro>();

	private LinkedList<RegistroLiquidacion> registroLiquidacion = new LinkedList<RegistroLiquidacion>();

	private LinkedList<RegistroLiquidacionImponible> registroLiquidacionImponible = new LinkedList<RegistroLiquidacionImponible>();

	private LinkedList<RegistroLiquidacionNoImponible> registroLiquidacionNoImponible = new LinkedList<RegistroLiquidacionNoImponible>();

	private LinkedList<RegistroLiquidacionDescuentoLegal> registroLiquidacionDescuentoLegal = new LinkedList<RegistroLiquidacionDescuentoLegal>();

	private LinkedList<RegistroLiquidacionDescuentoVario> registroLiquidacionDescuentoVario = new LinkedList<RegistroLiquidacionDescuentoVario>();

	private LinkedList<RegistroMutual> registroMutual = new LinkedList<RegistroMutual>();

	private LinkedList<RegistroCaja> registroCaja = new LinkedList<RegistroCaja>();

	private LinkedList<RegistroInp> registroInp = new LinkedList<RegistroInp>();

	private LinkedList<RegistroAfp> registroAfp = new LinkedList<RegistroAfp>();

	private LinkedList<RegistroIsapre> registroIsapre = new LinkedList<RegistroIsapre>();

	// campos registroEmpresa
	Long id;

	Date fecha;

	String fechaTexto;

	String rutEmpresa;

	String razonSocial;

	String actividad;

	String calle;

	String numero;

	String comuna;

	String ciudad;

	String region;

	String telefono;

	String rutRepresentante;

	String nombreRepresentante;

	String nombreMutual;

	String nombreCaja;

	Double cotizacionAccidenteTrabajo;

	public void calcular(EmpresaCuenta empresaCuenta) {
		HibernateUtil.beginTransaction();
		try {

			// declara algunos DAO
			EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance()
					.getEmpresaCuentaDao();
			empresaCuenta = empresaCuentaDao.findByEmpresaMes(empresaCuenta
					.getEmpresa(), empresaCuenta.getMes());
			EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
			Empresa empresa = empresaDao.findByRutEmpresa(empresaCuenta
					.getEmpresa().getRutEmpresa());
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			Mes mes = mesDao.findByFecha(empresaCuenta.getMes().getFecha());

			// crea la info del RegistroEmpresa
			this.fecha = mes.getFecha();
			this.fechaTexto = Fecha.fechaTexto(this.fecha);
			this.rutEmpresa = empresa.getRutEmpresa();
			this.razonSocial = empresa.getRazonSocial();
			this.actividad = empresa.getActividad();
			this.calle = empresa.getDireccion().getCalle();
			this.numero = empresa.getDireccion().getNumero();
			this.comuna = empresa.getDireccion().getComuna();
			this.ciudad = empresa.getDireccion().getCiudad();
			this.region = empresa.getDireccion().getRegion();
			this.telefono = empresa.getFono();
			this.rutRepresentante = empresa.getRepresentante().getRut();
			this.nombreRepresentante = empresa.getRepresentante()
					.getApellidoPaterno()
					+ " "
					+ empresa.getRepresentante().getApellidoMaterno()
					+ ", " + empresa.getRepresentante().getNombres();
			if (empresaCuenta.getMutual() != null) {
				this.nombreMutual = empresaCuenta.getMutual().getNombre();

			} else {
				this.nombreMutual = null;
			}
			if (empresaCuenta.getCaja() != null) {
				this.nombreCaja = empresaCuenta.getCaja().getNombre();
			} else {
				this.nombreCaja = null;
			}
			this.cotizacionAccidenteTrabajo = new Double(mes
					.getMutualCotizacionBasica().doubleValue()
					+ empresaCuenta.getMutualCotizacionAdicional()
							.doubleValue());

			this.registroEmpresa = new RegistroEmpresa(this.fecha,
					this.fechaTexto, this.rutEmpresa, this.razonSocial,
					this.actividad, this.calle, this.numero, this.comuna,
					this.ciudad, this.region, this.telefono,
					this.rutRepresentante, this.nombreRepresentante,
					this.nombreMutual, this.nombreCaja,
					this.cotizacionAccidenteTrabajo);



			// CREA LOS DEMAS REGISTROS
			List<TrabajadorCuenta> listTrabajadorCuenta = new LinkedList<TrabajadorCuenta>(
					empresaCuenta.getTrabajadorCuentas());
			for (int i = 0; i < listTrabajadorCuenta.size(); i++) {

				String rutTrabajador;
				String paterno;
				String materno;
				String nombres;
				Double dias;
				Long horas;
				
				/* Nuevos registros colegio */
				
				Long ump = 0L;
				Long bpp80 = 0L;
				Long bcomp80 = 0L;
				Long ley19464 = 0L;
				Long bonoResponsabilidad = 0L;
				Long leySep = 0L;
				Long jefaturaCurso = 0L;
				Long bonoReconocimiento = 0L;
				
				
				Boolean isProfesor = Boolean.FALSE;
				Long valorHoraProfesor;
				Long horasProfesor;
				Long sueldoBase;
				Long pagoHoras;
				Long otrosImponibles;
				Long baseGratificacion;
				Long topeGratificacion;
				Long gratificacion;
				Long imponible;
				// imponibles considerando los topes segun funcion
				Long topeSalud;
				Long imponibleSalud;
				Long topePrevision;
				Long imponiblePrevision;
				Long topeAccidenteTrabajo;
				Long imponibleAccidenteTrabajo;
				Long accidenteTrabajo;
				Long topeSeguroCesantia;
				Long imponibleSeguroCesantia;

				Long sueldoPromedio;
				Long asignacionFamiliar;
				Long montoAsignacionFamiliar;
				String tramo;
				Long numeroCargaSimple;
				Long numeroCargaInvalida;
				Long numeroCargaMaternal;
				Long montoCargaSimple;
				Long montoCargaInvalida;
				Long montoCargaMaternal;

				Long movilizacion;
				Long colacion;
				
				/** ESTE ES NUEVO */
				Long cargaRetroactiva;
				
				Long otrosNoImponibles;
				Long totalHaberes;

				String institucionPrevision;
				String institucionPrevision2; /** NEW */
				String regimen;
				Double porcentajePrevision;
				Long prevision;
				@SuppressWarnings("unused")
				Long topeApv;
				Long apv;
				Long ahorroVoluntario;

				String institucionSalud;
				Double porcentajeSalud;
				Long salud;
				Long saludFonasa;
				@SuppressWarnings("unused")
				Long saludCaja;
				Long totalPrevision;
				@SuppressWarnings("unused")
				Boolean seguro; /** NEW */
				Long seguroCesantiaTrabajador;
				Long seguroCesantiaEmpleador;
				Long totalAfecto;

				Long impuesto;
				Double factorImpuesto;
				Double rebajaImpuesto;
				Long pactoIsapre;
				Long diferenciaIsapre;
				Long anticipo;
				Long otrosDescuentos;
				Long totalDescuentos;
				Long liquido;

				TrabajadorCuenta trabajadorCuenta = listTrabajadorCuenta.get(i);
				Persona persona = trabajadorCuenta.getTrabajador()
						.getDatosPersonales();

				// datos personales
				rutTrabajador = persona.getRut();
				paterno = persona.getApellidoPaterno();
				materno = persona.getApellidoMaterno();
				nombres = persona.getNombres();

				List<TrabajadorCentroCosto> listTrabajadorCentroCosto = new LinkedList<TrabajadorCentroCosto>(
						trabajadorCuenta.getTrabajadorCentroCostos());
				// dias trabajados
				dias = new Double(0);
				for (int j = 0; j < listTrabajadorCentroCosto.size(); j++) {
					if (dias.longValue() < listTrabajadorCentroCosto.get(j).getDiasTrabajados().doubleValue()) {
						dias = new Double(listTrabajadorCentroCosto.get(j).getDiasTrabajados().doubleValue());
					}
				}
				if (dias.doubleValue() > 30) {
					dias = new Double(30);
				}
				// horas extraordinarias
				horas = new Long(0);
				for (int j = 0; j < listTrabajadorCentroCosto.size(); j++) {
					horas = new Long(horas.longValue()
							+ listTrabajadorCentroCosto.get(j)
									.getHorasExtraordinarias().longValue());
				}
				// sueldo base
				sueldoBase = new Long(0);
				valorHoraProfesor = new Long(0);
				horasProfesor = new Long(0);
				for (int j = 0; j < listTrabajadorCentroCosto.size(); j++) {
					if(listTrabajadorCentroCosto.get(j).getCentroCosto().getNumero().equals(new Long(100))) {
						isProfesor = Boolean.TRUE;
						valorHoraProfesor = listTrabajadorCentroCosto.get(j).getMonto().longValue();
						horasProfesor = listTrabajadorCentroCosto.get(j).getHoras().longValue();
						sueldoBase = new Long(
								Math.round(
										sueldoBase.longValue() + 
								valorHoraProfesor * horasProfesor * listTrabajadorCentroCosto.get(j).getDiasTrabajados().doubleValue() / 30
								));
					} else {
						sueldoBase = new Long(
								Math.round(
										sueldoBase.longValue() + 
								listTrabajadorCentroCosto.get(j).getMonto().longValue() * listTrabajadorCentroCosto.get(j).getDiasTrabajados().doubleValue() / 30
								));
					}
				}
				this.registroLiquidacionImponible
						.add(new RegistroLiquidacionImponible(persona.getRut(),
								Palabra.imponibleSueldoBase, sueldoBase));
				// pago horas extraordinarias
				pagoHoras = new Long(0);
				for (int j = 0; j < listTrabajadorCentroCosto.size(); j++) {
					if(listTrabajadorCentroCosto.get(j).getCentroCosto().getNumero().equals(new Long(100))) {
						pagoHoras = new Long(pagoHoras.longValue()
								+ Math.round(valorHoraProfesor * horasProfesor
										* (0.007777777777)
										* listTrabajadorCentroCosto.get(j)
												.getHorasExtraordinarias()
												.longValue()));
					} else {
						pagoHoras = new Long(pagoHoras.longValue()
								+ Math.round(listTrabajadorCentroCosto.get(j)
										.getMonto().longValue()
										* (0.007777777777)
										* listTrabajadorCentroCosto.get(j)
												.getHorasExtraordinarias()
												.longValue()));
					}
				}
				this.registroLiquidacionImponible
						.add(new RegistroLiquidacionImponible(persona.getRut(),
								Palabra.imponibleHorasExtraordinarias,
								pagoHoras));

				List<TrabajadorImponible> listTrabajadorImponible = new LinkedList<TrabajadorImponible>(
						trabajadorCuenta.getTrabajadorImponibles());

				
				
				
				// otros imponibles
				otrosImponibles = new Long(0);
				for (int j = 0; j < listTrabajadorImponible.size(); j++) {
					TrabajadorImponible ti = listTrabajadorImponible.get(j);
					//otrosImponibles = new Long(otrosImponibles.longValue() + ti.getMonto().longValue());
					this.registroLiquidacionImponible .add(new RegistroLiquidacionImponible(
							persona .getRut(), ti.getImponible().getNombre(), new Long(ti.getMonto().longValue())));
					
					
					/* se registran los nuevos campos para libro de colegios */
					if(ID_UMP.equals(ti.getImponible().getIdImponible())) {
						ump = ti.getMonto().longValue();
					} else if(ID_BPP80.equals(ti.getImponible().getIdImponible())) {
						bpp80 = ti.getMonto().longValue();
					} else if(ID_BCOMP80.equals(ti.getImponible().getIdImponible())) {
						bcomp80 = ti.getMonto().longValue();
					} else if(ID_LEY_19464.equals(ti.getImponible().getIdImponible())) {
						ley19464 = ti.getMonto().longValue();
					} else if(ID_BONO_RESPONSABILIDAD.equals(ti.getImponible().getIdImponible())) {
						bonoResponsabilidad = ti.getMonto().longValue();
					} else if(ID_LEY_SEP.equals(ti.getImponible().getIdImponible())) {
						leySep = ti.getMonto().longValue();
					} else if(ID_JEFATURA_CURSO.equals(ti.getImponible().getIdImponible())) {
						jefaturaCurso = ti.getMonto().longValue();
					} else if(ID_BONO_RECONOCIMIENTO.equals(ti.getImponible().getIdImponible())) {
						bonoReconocimiento = ti.getMonto().longValue();
					} else {
						otrosImponibles = new Long(otrosImponibles.longValue() + ti.getMonto().longValue());
					}
					
					
					
				}
				
				
				
				// gratificación
				baseGratificacion = new Long(sueldoBase.longValue()
						+ pagoHoras.longValue() + otrosImponibles.longValue());
				topeGratificacion = new Long(Math.round((mes
						.getGratificacionFactorAnual().doubleValue() * mes
						.getSueldoMinimo().doubleValue()) / 12));
				gratificacion = new Long(0);
				if (empresaCuenta.getGratificacion().equals(
						Palabra.gratificacionSin)) {
					gratificacion = new Long(0);
				} else if (empresaCuenta.getGratificacion().equals(
						Palabra.gratificacionPorcentaje)) {
					gratificacion = new Long(Math.round(baseGratificacion
							.longValue()
							* mes.getGratificacionPorcentaje().doubleValue() / 100));
				} else if (empresaCuenta.getGratificacion().equals(
						Palabra.gratificacionPorcentajeTope)) {
					if (baseGratificacion.longValue()
							* mes.getGratificacionPorcentaje().doubleValue() / 100<= topeGratificacion
							.longValue()) {
						gratificacion = new Long(Math.round(baseGratificacion
								.longValue()
								* mes.getGratificacionPorcentaje()
										.doubleValue() / 100));
					} else {
						gratificacion = topeGratificacion;
					}
				}
				this.registroLiquidacionImponible
						.add(new RegistroLiquidacionImponible(persona.getRut(),
								Palabra.imponibleGratificacion, gratificacion));
				
				
				
				// imponible
				imponible = new Long(sueldoBase.longValue()
						+ pagoHoras.longValue() + otrosImponibles.longValue()
						+ gratificacion.longValue()
						
						+ ump + bpp80 + bcomp80 + ley19464 + 
						bonoResponsabilidad + leySep + jefaturaCurso + bonoReconocimiento
						
				);

				
				
				
				// imponible salud
				topeSalud = new Long(Math.round(mes.getSaludTope()
						.doubleValue()
						* mes.getUf().doubleValue()));
				imponibleSalud = new Long(0);
				if (imponible.longValue() <= topeSalud.longValue()) {
					imponibleSalud = imponible;
				} else {
					imponibleSalud = topeSalud;
				}
				// imponible prevision
				topePrevision = new Long(Math.round(mes.getPrevisionAfpTope()
						.doubleValue()
						* mes.getUf().doubleValue()));
				imponiblePrevision = new Long(0);
				System.out.println("IMPONIBLE: "+imponible.longValue());
				System.out.println("TOPE PREVISION: "+topePrevision.longValue());
				if (imponible.longValue() <= topePrevision.longValue()) {
					imponiblePrevision = imponible;
				} else {
					imponiblePrevision = topePrevision;
				}
				System.out.println("IMPONIBLE PREVISION: "+imponiblePrevision.longValue());
				// imponible accidente del trabajo
				// TODO imponible accidente del trabajo uso tope de prevision
				topeAccidenteTrabajo = new Long(Math.round(mes
						.getPrevisionAfpTope().doubleValue()
						* mes.getUf().doubleValue()));
				imponibleAccidenteTrabajo = new Long(0);
				if (imponible.longValue() <= topeAccidenteTrabajo.longValue()) {
					imponibleAccidenteTrabajo = imponible;
				} else {
					imponibleAccidenteTrabajo = topeAccidenteTrabajo;
				}
				// imponible seguro cesantia
				topeSeguroCesantia = new Long(Math.round(mes
						.getSeguroCesantiaTope().doubleValue()
						* mes.getUf().doubleValue()));
				imponibleSeguroCesantia = new Long(0);
				if (trabajadorCuenta.isSeguroCesantia().booleanValue()) {
					if (imponible.longValue() <= topeSeguroCesantia.longValue()) {
						imponibleSeguroCesantia = imponible;
					} else {
						imponibleSeguroCesantia = topeSeguroCesantia;
					}
				}

				AsignacionDao asignacionDao = DaoFactory.getInstance().getAsignacionDao();
				List<Asignacion> listAsignacion = new LinkedList<Asignacion>(asignacionDao.findByMes(mes));
				//BORRAR List<Asignacion> listAsignacion = new LinkedList<Asignacion>(mes.getAsignaciones());
				// asignacion familiar
				sueldoPromedio = new Long(trabajadorCuenta.getSueldoPromedio()
						.longValue());
				asignacionFamiliar = new Long(0);
				montoAsignacionFamiliar = new Long(0);
				tramo = "";
				for (int j = 0; j < listAsignacion.size(); j++) {
					if (listAsignacion.size() > j + 1) {
						if (j == 0) {
							if (0 <= sueldoPromedio
									&& (listAsignacion.get(j + 1).getInicio()
											.longValue()) >= sueldoPromedio) {
								montoAsignacionFamiliar = new Long(
										listAsignacion.get(j).getMonto()
												.longValue());
								tramo = new Long(j + 1).toString();
								break;
							}
						} else if (listAsignacion.get(j).getInicio()
								.longValue() < sueldoPromedio
								&& listAsignacion.get(j + 1).getInicio()
										.longValue() >= sueldoPromedio) {
							montoAsignacionFamiliar = new Long(listAsignacion
									.get(j).getMonto().longValue());
							tramo = new Long(j + 1).toString();
							break;
						}
					} else {
						montoAsignacionFamiliar = new Long(listAsignacion
								.get(j).getMonto().longValue());
						tramo = new Long(j + 1).toString();
						break;
					}
				}
				numeroCargaSimple = trabajadorCuenta.getNumeroCargasNormal();
				numeroCargaInvalida = trabajadorCuenta
						.getNumeroCargasInvalida();
				numeroCargaMaternal = new Long(0); // TODO no se ingresa por
				// pantalla las cargas
				// maternales, queda en cero
				montoCargaSimple = new Long(numeroCargaSimple.longValue()
						* montoAsignacionFamiliar.longValue());
				montoCargaInvalida = new Long(2
						* numeroCargaInvalida.longValue()
						* montoAsignacionFamiliar.longValue());
				montoCargaMaternal = new Long(numeroCargaMaternal.longValue()
						* montoAsignacionFamiliar.longValue());
				/**
				 * *******************************************************************************
				 * ***** AQUI MODIFICO LO DE ASIGNACION FAMILIAR PARA QUE NO QUE EL MONTO NO *****
				 * ***** SEA PROPORCIONAL A LA CANTIDAD DE DIAS TRABAJADOS.                  *****
				 * ***** TAMBIEN PARA EL INGRESO DE CARGAS RETROACTIVAS                      *****
				 * *******************************************************************************
				 */
				if (dias < 25) {
					montoCargaSimple = new Long(Math.round(montoCargaSimple.longValue()
							* dias.doubleValue() / 30));
					montoCargaInvalida = new Long(Math.round(montoCargaInvalida
							.longValue()
							* dias.doubleValue() / 30));
					montoCargaMaternal = new Long(Math.round(montoCargaMaternal
							.longValue()
							* dias.doubleValue() / 30));
				}
				/**
				 * ACA ASIGNO LA CARGA RETROACTIVA AL MONTO DE LA CARGA SIMPLE
				 * PARA QUE SE VEA REFLEJADO EN EL INFORME DEL INP, SIN AFECTAR A LOS
				 * DEMAS INFORMES
				 * LO TUVE QUE MOVER MAS ABAJO DESPUES DE ASIGNAR LA CARGA RETROACTIVA!!!
				 */
				//montoCargaSimple +=cargaRetroactiva;
				asignacionFamiliar = montoCargaSimple + montoCargaInvalida + montoCargaMaternal;
				
				this.registroLiquidacionNoImponible.add(new RegistroLiquidacionNoImponible(persona
						.getRut(),
						Palabra.noImponibleAsignacionFamiliar,
						asignacionFamiliar));
				/*//ESTO LO PUSE MAS ABAJO
				this.registroLiquidacionNoImponible
						.add(new RegistroLiquidacionNoImponible(persona
								.getRut(),
								Palabra.noImponibleAsignacionFamiliar,
								asignacionFamiliar));
				*/
				List<TrabajadorNoImponible> listTrabajadorNoImponible = new LinkedList<TrabajadorNoImponible>(
						trabajadorCuenta.getTrabajadorNoImponibles());
				// movilización
				movilizacion = new Long(0);
				for (int j = 0; j < listTrabajadorNoImponible.size(); j++) {
					if (listTrabajadorNoImponible.get(j).getNoImponible()
							.getNombre()
							.equals(Palabra.noImponibleMovilizacion)) {
						movilizacion = new Long(listTrabajadorNoImponible
								.get(j).getMonto().longValue());
						break;
					}
				}
				// colación
				colacion = new Long(0);
				for (int j = 0; j < listTrabajadorNoImponible.size(); j++) {
					if (listTrabajadorNoImponible.get(j).getNoImponible()
							.getNombre().equals(Palabra.noImponibleColacion)) {
						colacion = new Long(listTrabajadorNoImponible.get(j)
								.getMonto().longValue());
						break;
					}
				}
				/** ESTO ES NUEVO */
				// carga retroactiva
				cargaRetroactiva = new Long(0);
				for (int j = 0; j < listTrabajadorNoImponible.size(); j++) {
					if (listTrabajadorNoImponible.get(j).getNoImponible()
							.getNombre().equals(Palabra.noImponibleCargaRetroactiva)) {
						cargaRetroactiva = new Long(listTrabajadorNoImponible.get(j)
								.getMonto().longValue());
						break;
					}
				}
				
				// otros no imponibles
				otrosNoImponibles = new Long(0);
				for (int j = 0; j < listTrabajadorNoImponible.size(); j++) {
					TrabajadorNoImponible tni = listTrabajadorNoImponible.get(j);
					if (!tni.getNoImponible().getNombre().equals(Palabra.noImponibleColacion)
							&& !tni.getNoImponible().getNombre().equals(Palabra.noImponibleMovilizacion)
							&& !tni.getNoImponible().getNombre().equals(Palabra.noImponibleCargaRetroactiva)) {
						otrosNoImponibles = new Long(otrosNoImponibles.longValue()
								+ tni.getMonto().longValue());
					}
					this.registroLiquidacionNoImponible
							.add(new RegistroLiquidacionNoImponible(persona
									.getRut(),
									tni.getNoImponible().getNombre(), new Long(
											tni.getMonto().longValue())));
				}
				
				/** ESTO LO MOVI DE ARRIBA, 
				 * EN VEZ DE SUMAR LA CARGA RETROACTIVA A LA ASIGNACION FAMILIAR, 
				 * LO VOY A SUMAR AL MONTO CARGA SIMPLE, PARA AGREGARLO AL INFORME INP,
				 * LOS DEMAS INFORMES NO DEBERIAN VERSE AFECTADOS */
				montoCargaSimple +=cargaRetroactiva;
				//asignacionFamiliar = montoCargaSimple + montoCargaInvalida + montoCargaMaternal;
				asignacionFamiliar+=cargaRetroactiva;
				/************************************************************************
				 ************************************************************************
				 * HAST A ACA HAY MODIFICACIONES
				 ************************************************************************
				 ************************************************************************
				 */
				
				// total haberes
				totalHaberes = new Long(imponible.longValue()
						+ asignacionFamiliar.longValue()
						+ movilizacion.longValue() + colacion.longValue()
						+ otrosNoImponibles.longValue());

				// nombre afp - regimen
				institucionPrevision = null;
				regimen = null;
				if (trabajadorCuenta.getAfp() != null) {
					institucionPrevision = trabajadorCuenta.getAfp()
							.getNombre();
					regimen = trabajadorCuenta.getAfp().getRegimen();
				}
				// afp - prevision
				porcentajePrevision = new Double(0);
				prevision = new Long(0);
				if (institucionPrevision != null) {
					porcentajePrevision = new Double(trabajadorCuenta.getAfp()
							.getCotizacion().doubleValue());
					prevision = new Long(Math.round(imponiblePrevision
							.longValue()
							* porcentajePrevision.doubleValue() / 100));
					this.registroLiquidacionDescuentoLegal
							.add(new RegistroLiquidacionDescuentoLegal(persona
									.getRut(), institucionPrevision + " ("
									+ porcentajePrevision.toString() + ")",
									prevision));
				}
				// ahorro voluntario
				ahorroVoluntario = new Long(0);
				if (trabajadorCuenta.getValorAhorroVoluntario().longValue() > 0) {
					ahorroVoluntario = new Long(trabajadorCuenta
							.getValorAhorroVoluntario().longValue());
				}
				if (ahorroVoluntario.longValue() != 0) {
					this.registroLiquidacionDescuentoLegal
							.add(new RegistroLiquidacionDescuentoLegal(
									persona.getRut(),
									Palabra.descuentoAhorroVoluntario, ahorroVoluntario));
				}
				// apv
				// TODO calculo apv
				topeApv = Math.round(mes.getPrevisionApvTope().doubleValue()
						* mes.getUf().doubleValue());
				apv = new Long(0);
				if (apv.longValue() != 0) {
					this.registroLiquidacionDescuentoLegal
							.add(new RegistroLiquidacionDescuentoLegal(persona
									.getRut(),
									Palabra.descuentoApv,
									apv));
				}
				/*
				if (institucionPrevision != null) {
					if (regimen.equals(Palabra.regimenNuevo)) {
						if (trabajadorCuenta.getValorAhorroVoluntario()
								.longValue() <= topeApv.longValue()) {
							apv = new Long(trabajadorCuenta
									.getValorAhorroVoluntario().longValue());
						} else {
							apv = topeApv;
						}
						if (apv.longValue() != 0) {
							this.registroLiquidacionDescuentoLegal
									.add(new RegistroLiquidacionDescuentoLegal(
											persona.getRut(),
											Palabra.descuentoApv, apv));
						}
					}
				}
				*/

				// nombre salud
				if (trabajadorCuenta.getTipoSalud().equals(
						Palabra.tipoSaludIsapre)) {
					institucionSalud = trabajadorCuenta.getIsapre().getNombre();
				} else {
					institucionSalud = Palabra.institucionFonasa;
				}
				// salud
				porcentajeSalud = new Double(mes.getSaludCotizacionBasica()
						.doubleValue());
				salud = new Long(Math.round(imponibleSalud.longValue()
						* porcentajeSalud.doubleValue() / 100));
				this.registroLiquidacionDescuentoLegal
						.add(new RegistroLiquidacionDescuentoLegal(persona
								.getRut(), institucionSalud + " ("
								+ porcentajeSalud.toString() + ")", salud));
				// salud a fonasa y salud a caja
				saludFonasa = new Long(0);
				saludCaja = new Long(0);
//FLAG
				if (institucionSalud.equals(Palabra.institucionFonasa)) {
					if (nombreCaja == null) {
						saludFonasa = salud;
					} else {
						saludFonasa = new Long(Math.round(imponibleSalud
								.longValue() * 6.4 / 100)); // TODO 6.4 se
						// deberia ingresar
						// por pantalla
						saludCaja = new Long(Math.round(imponibleSalud
								.longValue() * 0.6 / 100)); // TODO 0.6 se
						// deberia ingresar
						// por pantalla
					}
				}
				// total prevision
				totalPrevision = new Long(prevision.longValue()
						+ apv.longValue() + ahorroVoluntario.longValue()
						+ salud.longValue());

				// seguro cesantia
				seguroCesantiaTrabajador = new Long(0);
				seguroCesantiaEmpleador = new Long(0);
				/** NEW - MODIFICADO */
				/* Actualmente solo calculo el seguro de cesantía, pero no estoy considerando
				 * si se selcciono SEGURO_CESANTIA=SI/NO
				 * Ahora lo agrego
				 */
				if ( trabajadorCuenta.isSeguroCesantia().booleanValue()) {
				if (trabajadorCuenta.getTipoContrato().equals(
						Palabra.tipoContratoIndefinido)) {
					seguroCesantiaTrabajador = new Long(Math
							.round(imponibleSeguroCesantia.longValue()
									* mes.getSeguroCesantiaPorcentaje()
											.doubleValue() / 100));
					seguroCesantiaEmpleador = new Long(
							Math
									.round(imponibleSeguroCesantia.longValue() * 2.4 / 100)); // TODO
					// 2.4
					// se
					// deberia
					// ingresar
					// por
					// pantalla
					this.registroLiquidacionDescuentoLegal
							.add(new RegistroLiquidacionDescuentoLegal(persona
									.getRut(), Palabra.descuentoSeguroCesantia
									+ " ("
									+ mes.getSeguroCesantiaPorcentaje()
											.toString() + ")",
									seguroCesantiaTrabajador));
				} else {
					seguroCesantiaEmpleador = new Long(
							Math
									.round(imponibleSeguroCesantia.longValue() * 3.0 / 100)); // TODO
					// 3.0
					// se
					// deberia
					// ingresar
					// por
					// pantalla
					this.registroLiquidacionDescuentoLegal
							.add(new RegistroLiquidacionDescuentoLegal(persona
									.getRut(), Palabra.descuentoSeguroCesantia,
									seguroCesantiaTrabajador));
				}
				}
				// total afecto
				totalAfecto = new Long(imponible.longValue()
						- totalPrevision.longValue()
						- seguroCesantiaTrabajador.longValue());
				if (totalAfecto.longValue() < 0) {
					totalAfecto = new Long(0);
				}

				ImpuestoDao impuestoDao = DaoFactory.getInstance().getImpuestoDao();
				List<Impuesto> listImpuesto = new LinkedList<Impuesto>(impuestoDao.findByMes(mes));
				//BORRAR List<Impuesto> listImpuesto = new LinkedList<Impuesto>(mes.getImpuestos());
				// impuesto unico
				impuesto = new Long(0);
				factorImpuesto = new Double(0);
				rebajaImpuesto = new Double(0);
				
				System.out.println(rutTrabajador);
				if (0 <= totalAfecto.longValue()) {
					search:
					for (int j = 0; j < listImpuesto.size(); j++) {
						if (listImpuesto.size() > j + 1) {
							if (j == 0) {
								System.out.println("0<="+totalAfecto.longValue() + " Y " + Math.round(listImpuesto.get(j + 1).getInicio().longValue()* mes.getUtm().doubleValue())+">="+totalAfecto.longValue());
								if (0 <= totalAfecto.longValue()
										&& Math.round(listImpuesto.get(j + 1)
												.getInicio().doubleValue()
												* mes.getUtm().doubleValue()) >= totalAfecto.longValue()) {
									factorImpuesto = new Double(listImpuesto.get(j)
											.getFactor().doubleValue());
									rebajaImpuesto = new Double(listImpuesto.get(j)
											.getRebaja().doubleValue()
											* mes.getUtm().doubleValue());
									System.out.println("TRAMO 1");
									break search;
								}
							} else if (Math.round(listImpuesto.get(j).getInicio()
									.doubleValue()
									* mes.getUtm().doubleValue()) < totalAfecto
									&& Math.round(listImpuesto.get(j + 1)
											.getInicio().doubleValue()
											* mes.getUtm().doubleValue()) >= totalAfecto) {
								factorImpuesto = new Double(listImpuesto.get(j)
										.getFactor().doubleValue());
								rebajaImpuesto = new Double(listImpuesto.get(j)
										.getRebaja().doubleValue()
										* mes.getUtm().doubleValue());
								System.out.println("TRAMO "+(j+1));
								break search;
							}
						} else {
							factorImpuesto = new Double(listImpuesto.get(j)
									.getFactor().doubleValue());
							rebajaImpuesto = new Double(listImpuesto.get(j)
									.getRebaja().doubleValue()
									* mes.getUtm().doubleValue());
							System.out.println("TRAMO 8");
							break search;
						}
					}
				impuesto = new Long(Math
						.round((totalAfecto.longValue() * factorImpuesto
								.doubleValue())
								- rebajaImpuesto.doubleValue()));

				}

				this.registroLiquidacionDescuentoLegal
					.add(new RegistroLiquidacionDescuentoLegal(persona
							.getRut(), Palabra.descuentoImpuestoUnico,
							impuesto));
				// diferencia isapre
				diferenciaIsapre = new Long(0);
				pactoIsapre = new Long(0);
				if (!institucionSalud.equals(Palabra.institucionFonasa)) {
					if (Palabra.tipoPactoUf.equals(trabajadorCuenta
							.getTipoPactoIsapre())) {
						pactoIsapre = new Long(Math.round(trabajadorCuenta
								.getValorPactoIsapre().doubleValue()
								* mes.getUf().doubleValue()));
					} else {
						pactoIsapre = new Long(trabajadorCuenta
								.getValorPactoIsapre().longValue());
					}
					if ((pactoIsapre.longValue() - salud.longValue()) > 0) {
						diferenciaIsapre = new Long(pactoIsapre.longValue()
								- salud.longValue());
					} else {
						diferenciaIsapre = new Long(0);
					}
					if (diferenciaIsapre.longValue() != 0) {
						this.registroLiquidacionDescuentoLegal
								.add(new RegistroLiquidacionDescuentoLegal(
										persona.getRut(),
										Palabra.descuentoAdicionalIsapre,
										diferenciaIsapre));
					}
				}

				List<TrabajadorDescuento> listTrabajadorDescuento = new LinkedList<TrabajadorDescuento>(
						trabajadorCuenta.getTrabajadorDescuentos());

				// anticipo
				anticipo = new Long(0);
				for (int j = 0; j < listTrabajadorDescuento.size(); j++) {
					if (listTrabajadorDescuento.get(j).getDescuento()
							.getNombre().equals(Palabra.descuentoAnticipo)) {
						anticipo = new Long(listTrabajadorDescuento.get(j)
								.getMonto().longValue());
						break;
					}
				}
				// otros descuentos
				otrosDescuentos = new Long(0);
				for (int j = 0; j < listTrabajadorDescuento.size(); j++) {
					TrabajadorDescuento td = listTrabajadorDescuento.get(j);
					if (!td.getDescuento().getNombre().equals(
							Palabra.descuentoAnticipo)) {
						otrosDescuentos = new Long(otrosDescuentos.longValue()
								+ td.getMonto().longValue());
					}
					this.registroLiquidacionDescuentoVario
							.add(new RegistroLiquidacionDescuentoVario(persona
									.getRut(), td.getDescuento().getNombre(),
									new Long(td.getMonto().longValue())));
				}
				// total descuentos
				totalDescuentos = new Long(totalPrevision.longValue()
						+ seguroCesantiaTrabajador.longValue()
						+ impuesto.longValue() + diferenciaIsapre.longValue()
						+ anticipo.longValue() + otrosDescuentos.longValue());
				// liquido
				liquido = new Long(totalHaberes.longValue()
						- totalDescuentos.longValue());

				// accidente del trabajo
				accidenteTrabajo = new Long(
						Math
								.round(imponibleAccidenteTrabajo.longValue()
										* this.cotizacionAccidenteTrabajo
												.doubleValue() / 100));

				// crear registros
				System.err.println("¿ES PROFE?: "+isProfesor);
				if(isProfesor) {
					System.err.println("ES PROFE");
					registroLibro.add(new RegistroLibro(rutTrabajador, paterno,
						materno, nombres, dias, horas, sueldoBase, pagoHoras,
						otrosImponibles, gratificacion, imponible,
						asignacionFamiliar, movilizacion, colacion,
						otrosNoImponibles, totalHaberes, institucionPrevision,
						prevision, apv, ahorroVoluntario, institucionSalud,
						salud, totalPrevision, seguroCesantiaTrabajador,
						totalAfecto, impuesto, diferenciaIsapre, anticipo,
						otrosDescuentos, totalDescuentos, liquido, valorHoraProfesor, horasProfesor,
						ump, bpp80, bcomp80, ley19464, bonoResponsabilidad, leySep,  jefaturaCurso, bonoReconocimiento));
				} else {
					System.err.println("NO ES PROFE");
					registroLibro.add(new RegistroLibro(rutTrabajador, paterno,
							materno, nombres, dias, horas, sueldoBase, pagoHoras,
							otrosImponibles, gratificacion, imponible,
							asignacionFamiliar, movilizacion, colacion,
							otrosNoImponibles, totalHaberes, institucionPrevision,
							prevision, apv, ahorroVoluntario, institucionSalud,
							salud, totalPrevision, seguroCesantiaTrabajador,
							totalAfecto, impuesto, diferenciaIsapre, anticipo,
							otrosDescuentos, totalDescuentos, liquido, null, null,
							ump, bpp80, bcomp80, ley19464, bonoResponsabilidad, leySep,  jefaturaCurso, bonoReconocimiento));
				}
				
				registroLiquidacion.add(new RegistroLiquidacion(rutTrabajador,
						paterno, materno, nombres, dias));
				
				if (!institucionSalud.equals(Palabra.institucionFonasa)) {
					registroIsapre.add(new RegistroIsapre(institucionSalud,
							rutTrabajador, paterno, materno, nombres,
							imponibleSalud, salud, diferenciaIsapre, new Long(
									salud.longValue()
											+ diferenciaIsapre.longValue()),
							pactoIsapre));
				}

				if (institucionPrevision != null
						&& regimen.equals(Palabra.regimenNuevo)) {
					registroAfp.add(new RegistroAfp(institucionPrevision,
							rutTrabajador, paterno, materno, nombres,
							imponiblePrevision, prevision, ahorroVoluntario,
							trabajadorCuenta.isSeguroCesantia(), imponibleSeguroCesantia, 
							seguroCesantiaTrabajador, seguroCesantiaEmpleador,
							
							Math.round(mes.getPrevisionSeguroInvalidez()*imponiblePrevision/100)
							
					));
				}
				/** NEW */
				else if (institucionPrevision != null
						&& regimen.equals(Palabra.regimenAntiguo)
						&& trabajadorCuenta.isSeguroCesantia().booleanValue() ) {
					institucionPrevision2 = trabajadorCuenta.getAfp2().getNombre();
					registroAfp.add(new RegistroAfp(institucionPrevision2,
							rutTrabajador, paterno, materno, nombres,
							/* imponiblePrevision, */
							new Long(0), 
							/*prevision,*/ 
							new Long(0),
							ahorroVoluntario,
							trabajadorCuenta.isSeguroCesantia(), imponibleSeguroCesantia, 
							seguroCesantiaTrabajador, seguroCesantiaEmpleador,
							
							Math.round(mes.getPrevisionSeguroInvalidez()*imponiblePrevision/100)
							
					
					));
				}
//FLAG 
				if (this.nombreCaja != null) {
					if (institucionSalud.equals(Palabra.institucionFonasa)) {
						registroCaja.add(new RegistroCaja(rutTrabajador,
								paterno, materno, nombres, imponiblePrevision,
								new Long(0), dias, numeroCargaSimple,
								numeroCargaInvalida, numeroCargaMaternal,
								asignacionFamiliar, saludCaja, tramo));
					} else {
						registroCaja.add(new RegistroCaja(rutTrabajador,
								paterno, materno, nombres, new Long(0),
								imponiblePrevision, dias, numeroCargaSimple,
								numeroCargaInvalida, numeroCargaMaternal,
								asignacionFamiliar, new Long(0), tramo));
					}
				}

				if (this.nombreMutual != null) {
					registroMutual.add(new RegistroMutual(rutTrabajador,
							paterno, materno, nombres,
							imponibleAccidenteTrabajo, accidenteTrabajo));
				}
				
				//inp
				Long inpPension = new Long(0);
				Long inpFonasa = new Long(0);
				Long inpAccidenteTrabajo = new Long(0);
				if (regimen!=null) {
					if (regimen.equals(Palabra.regimenAntiguo)) {
						inpPension = prevision;
					}					
				}
				if (institucionSalud.equals(Palabra.institucionFonasa)) {
					if (nombreCaja==null) {
						inpFonasa = salud;
					} else {
						inpFonasa = saludFonasa;
					}
				}
				if (nombreMutual==null) {
					inpAccidenteTrabajo = accidenteTrabajo;
				}
				if (nombreCaja==null) {
					registroInp.add(new RegistroInp(
							rutTrabajador, paterno, materno,
							nombres, dias, imponiblePrevision, inpPension,
							inpFonasa, inpAccidenteTrabajo, tramo,
							numeroCargaSimple, montoCargaSimple,
							numeroCargaInvalida, montoCargaInvalida,
							numeroCargaMaternal, montoCargaMaternal));
				} else {
					registroInp.add(new RegistroInp(
							rutTrabajador, paterno, materno,
							nombres, dias, imponiblePrevision, inpPension,
							inpFonasa, inpAccidenteTrabajo, tramo,
							new Long(0), new Long(0),
							new Long(0), new Long(0),
							new Long(0), new Long(0)));
				}
				
				

			}
			
			// AGREGA REGISTROS A LA BD
			
			//REGISTRO EMPRESA
			// borra registros antiguos
			RegistroEmpresaDao registroEmpresaDao = DaoFactory.getInstance()
					.getRegistroEmpresaDao();
			List<RegistroEmpresa> listOldRegistroEmpresa = registroEmpresaDao
					.findAll();
			for (int i = 0; i < listOldRegistroEmpresa.size(); i++) {
				registroEmpresaDao.makeTransient(listOldRegistroEmpresa.get(i));
			}
			// agrega registros a bd
			registroEmpresaDao.makePersistent(registroEmpresa);
			
			//REGISTRO LIBRO
			// borra registros antiguos
			RegistroLibroDao registroLibroDao = DaoFactory.getInstance()
					.getRegistroLibroDao();
			List<RegistroLibro> listOldRegistroLibro = registroLibroDao.findAll();
			for (int i = 0; i < listOldRegistroLibro.size(); i++) {
				registroLibroDao.makeTransient(listOldRegistroLibro.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroLibro.size(); i++) {
				registroLibroDao.makePersistent(registroLibro.get(i));				
			}
			
			//REGISTRO LIQUIDACION
			// borra registros antiguos
			RegistroLiquidacionDao registroLiquidacionDao = DaoFactory.getInstance()
					.getRegistroLiquidacionDao();
			List<RegistroLiquidacion> listOldRegistroLiquidacion = registroLiquidacionDao.findAll();
			for (int i = 0; i < listOldRegistroLiquidacion.size(); i++) {
				registroLiquidacionDao.makeTransient(listOldRegistroLiquidacion.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroLiquidacion.size(); i++) {
				registroLiquidacionDao.makePersistent(registroLiquidacion.get(i));				
			}

			//REGISTRO LIQUIDACION IMPONIBLE
			// borra registros antiguos
			RegistroLiquidacionImponibleDao registroLiquidacionImponibleDao = DaoFactory.getInstance()
					.getRegistroLiquidacionImponibleDao();
			List<RegistroLiquidacionImponible> listOldRegistroLiquidacionImponible = registroLiquidacionImponibleDao.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionImponible.size(); i++) {
				registroLiquidacionImponibleDao.makeTransient(listOldRegistroLiquidacionImponible.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroLiquidacionImponible.size(); i++) {
				registroLiquidacionImponibleDao.makePersistent(registroLiquidacionImponible.get(i));				
			}

			//REGISTRO LIQUIDACION NO IMPONIBLE
			// borra registros antiguos
			RegistroLiquidacionNoImponibleDao registroLiquidacionNoImponibleDao = DaoFactory.getInstance()
					.getRegistroLiquidacionNoImponibleDao();
			List<RegistroLiquidacionNoImponible> listOldRegistroLiquidacionNoImponible = registroLiquidacionNoImponibleDao.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionNoImponible.size(); i++) {
				registroLiquidacionNoImponibleDao.makeTransient(listOldRegistroLiquidacionNoImponible.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroLiquidacionNoImponible.size(); i++) {
				registroLiquidacionNoImponibleDao.makePersistent(registroLiquidacionNoImponible.get(i));				
			}
			
			//REGISTRO LIQUIDACION DESCUENTO LEGAL
			// borra registros antiguos
			RegistroLiquidacionDescuentoLegalDao registroLiquidacionDescuentoLegalDao = DaoFactory.getInstance()
					.getRegistroLiquidacionDescuentoLegalDao();
			List<RegistroLiquidacionDescuentoLegal> listOldRegistroLiquidacionDescuentoLegal = registroLiquidacionDescuentoLegalDao.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionDescuentoLegal.size(); i++) {
				registroLiquidacionDescuentoLegalDao.makeTransient(listOldRegistroLiquidacionDescuentoLegal.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroLiquidacionDescuentoLegal.size(); i++) {
				registroLiquidacionDescuentoLegalDao.makePersistent(registroLiquidacionDescuentoLegal.get(i));				
			}
			
			//REGISTRO LIQUIDACION DESCUENTO VARIO
			// borra registros antiguos
			RegistroLiquidacionDescuentoVarioDao registroLiquidacionDescuentoVarioDao = DaoFactory.getInstance()
					.getRegistroLiquidacionDescuentoVarioDao();
			List<RegistroLiquidacionDescuentoVario> listOldRegistroLiquidacionDescuentoVario = registroLiquidacionDescuentoVarioDao.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionDescuentoVario.size(); i++) {
				registroLiquidacionDescuentoVarioDao.makeTransient(listOldRegistroLiquidacionDescuentoVario.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroLiquidacionDescuentoVario.size(); i++) {
				registroLiquidacionDescuentoVarioDao.makePersistent(registroLiquidacionDescuentoVario.get(i));				
			}
			
			//REGISTRO ISAPRE
			// borra registros antiguos 
			RegistroIsapreDao registroIsapreDao = DaoFactory.getInstance()
					.getRegistroIsapreDao();
			List<RegistroIsapre> listOldRegistroIsapre = registroIsapreDao.findAll();
			for (int i = 0; i < listOldRegistroIsapre.size(); i++) {
				registroIsapreDao.makeTransient(listOldRegistroIsapre.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroIsapre.size(); i++) {
				registroIsapreDao.makePersistent(registroIsapre.get(i));				
			}

			//REGISTRO AFP
			// borra registros antiguos 
			RegistroAfpDao registroAfpDao = DaoFactory.getInstance()
					.getRegistroAfpDao();
			List<RegistroAfp> listOldRegistroAfp = registroAfpDao.findAll();
			for (int i = 0; i < listOldRegistroAfp.size(); i++) {
				registroAfpDao.makeTransient(listOldRegistroAfp.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroAfp.size(); i++) {
				registroAfpDao.makePersistent(registroAfp.get(i));				
			}
			
			//REGISTRO MUTUAL
			// borra registros antiguos 
			RegistroMutualDao registroMutualDao = DaoFactory.getInstance()
					.getRegistroMutualDao();
			List<RegistroMutual> listOldRegistroMutual = registroMutualDao.findAll();
			for (int i = 0; i < listOldRegistroMutual.size(); i++) {
				registroMutualDao.makeTransient(listOldRegistroMutual.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroMutual.size(); i++) {
				registroMutualDao.makePersistent(registroMutual.get(i));				
			}
			
			//REGISTRO CAJA
			// borra registros antiguos 
			RegistroCajaDao registroCajaDao = DaoFactory.getInstance()
					.getRegistroCajaDao();
			List<RegistroCaja> listOldRegistroCaja = registroCajaDao.findAll();
			for (int i = 0; i < listOldRegistroCaja.size(); i++) {
				registroCajaDao.makeTransient(listOldRegistroCaja.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroCaja.size(); i++) {
				registroCajaDao.makePersistent(registroCaja.get(i));				
			}
			
			//REGISTRO INP
			// borra registros antiguos 
			RegistroInpDao registroInpDao = DaoFactory.getInstance()
					.getRegistroInpDao();
			List<RegistroInp> listOldRegistroInp = registroInpDao.findAll();
			for (int i = 0; i < listOldRegistroInp.size(); i++) {
				registroInpDao.makeTransient(listOldRegistroInp.get(i));
			}
			// agrega registros a bd
			for (int i = 0; i < registroInp.size(); i++) {
				registroInpDao.makePersistent(registroInp.get(i));				
			}
			
			
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
