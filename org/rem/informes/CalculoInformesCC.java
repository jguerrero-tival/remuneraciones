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
import org.rem.dao.RegistroAfpCCDao;
import org.rem.dao.RegistroCajaCCDao;
//import org.rem.dao.RegistroEmpresaDao;
import org.rem.dao.RegistroInpCCDao;
import org.rem.dao.RegistroIsapreCCDao;
import org.rem.dao.RegistroLibroCCDao;
import org.rem.dao.RegistroLiquidacionCCDao;
import org.rem.dao.RegistroLiquidacionDescuentoLegalCCDao;
import org.rem.dao.RegistroLiquidacionDescuentoVarioCCDao;
import org.rem.dao.RegistroLiquidacionImponibleCCDao;
import org.rem.dao.RegistroLiquidacionNoImponibleCCDao;
import org.rem.dao.RegistroMutualCCDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Asignacion;
import org.rem.model.CentroCosto;
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
//import org.rem.model.informes.RegistroAfp;
import org.rem.model.informes.RegistroAfpCC;
import org.rem.model.informes.RegistroCajaCC;
import org.rem.model.informes.RegistroEmpresa;
import org.rem.model.informes.RegistroInpCC;
import org.rem.model.informes.RegistroIsapreCC;
import org.rem.model.informes.RegistroLibroCC;
import org.rem.model.informes.RegistroLiquidacionCC;
import org.rem.model.informes.RegistroLiquidacionDescuentoLegalCC;
import org.rem.model.informes.RegistroLiquidacionDescuentoVarioCC;
import org.rem.model.informes.RegistroLiquidacionImponibleCC;
import org.rem.model.informes.RegistroLiquidacionNoImponibleCC;
import org.rem.model.informes.RegistroMutualCC;
import org.rem.util.Fecha;
import org.rem.util.Palabra;

public class CalculoInformesCC {
	
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
	@SuppressWarnings("unused")
	private RegistroEmpresa registroEmpresa;

	private LinkedList<RegistroLibroCC> registroLibroCC = new LinkedList<RegistroLibroCC>();

	private LinkedList<RegistroLiquidacionCC> registroLiquidacionCC = new LinkedList<RegistroLiquidacionCC>();

	private LinkedList<RegistroLiquidacionImponibleCC> registroLiquidacionImponibleCC = new LinkedList<RegistroLiquidacionImponibleCC>();

	private LinkedList<RegistroLiquidacionNoImponibleCC> registroLiquidacionNoImponibleCC = new LinkedList<RegistroLiquidacionNoImponibleCC>();

	private LinkedList<RegistroLiquidacionDescuentoLegalCC> registroLiquidacionDescuentoLegalCC = new LinkedList<RegistroLiquidacionDescuentoLegalCC>();

	private LinkedList<RegistroLiquidacionDescuentoVarioCC> registroLiquidacionDescuentoVarioCC = new LinkedList<RegistroLiquidacionDescuentoVarioCC>();

	private LinkedList<RegistroMutualCC> registroMutualCC = new LinkedList<RegistroMutualCC>();

	private LinkedList<RegistroCajaCC> registroCajaCC = new LinkedList<RegistroCajaCC>();

	private LinkedList<RegistroInpCC> registroInpCC = new LinkedList<RegistroInpCC>();

	private LinkedList<RegistroAfpCC> registroAfpCC = new LinkedList<RegistroAfpCC>();

	private LinkedList<RegistroIsapreCC> registroIsapreCC = new LinkedList<RegistroIsapreCC>();

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


			/** 
			 * ELIMINA REGISTROS ANTIGUOS
			 */
			
			
			
			// REGISTRO EMPRESA
			// borra registros antiguos
			/**
			RegistroEmpresaDao registroEmpresaDao = DaoFactory.getInstance().getRegistroEmpresaDao();
			List<RegistroEmpresa> listOldRegistroEmpresa = registroEmpresaDao.findAll();
			for (int i = 0; i < listOldRegistroEmpresa.size(); i++) {
				registroEmpresaDao.makeTransient(listOldRegistroEmpresa.get(i));
			}
			*/
			// REGISTRO LIBRO
			// borra registros antiguos
			RegistroLibroCCDao registroLibroCCDao = DaoFactory.getInstance()
					.getRegistroLibroCCDao();
			List<RegistroLibroCC> listOldRegistroLibroCC = registroLibroCCDao
					.findAll();
			for (int i = 0; i < listOldRegistroLibroCC.size(); i++) {
				registroLibroCCDao.makeTransient(listOldRegistroLibroCC.get(i));
			}
			// REGISTRO LIQUIDACION
			// borra registros antiguos
			RegistroLiquidacionCCDao registroLiquidacionCCDao = DaoFactory
					.getInstance().getRegistroLiquidacionCCDao();
			List<RegistroLiquidacionCC> listOldRegistroLiquidacionCC = registroLiquidacionCCDao
					.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionCC.size(); i++) {
				registroLiquidacionCCDao.makeTransient(listOldRegistroLiquidacionCC
						.get(i));
			}
			// REGISTRO LIQUIDACION IMPONIBLE
			// borra registros antiguos
			RegistroLiquidacionImponibleCCDao registroLiquidacionImponibleCCDao = DaoFactory
					.getInstance().getRegistroLiquidacionImponibleCCDao();
			List<RegistroLiquidacionImponibleCC> listOldRegistroLiquidacionImponibleCC = registroLiquidacionImponibleCCDao
					.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionImponibleCC.size(); i++) {
				registroLiquidacionImponibleCCDao
						.makeTransient(listOldRegistroLiquidacionImponibleCC
								.get(i));
			}
			// REGISTRO LIQUIDACION NO IMPONIBLE
			// borra registros antiguos
			RegistroLiquidacionNoImponibleCCDao registroLiquidacionNoImponibleCCDao = DaoFactory
					.getInstance().getRegistroLiquidacionNoImponibleCCDao();
			List<RegistroLiquidacionNoImponibleCC> listOldRegistroLiquidacionNoImponibleCC = registroLiquidacionNoImponibleCCDao
					.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionNoImponibleCC.size(); i++) {
				registroLiquidacionNoImponibleCCDao
						.makeTransient(listOldRegistroLiquidacionNoImponibleCC
								.get(i));
			}
			// REGISTRO LIQUIDACION DESCUENTO LEGAL
			// borra registros antiguos
			RegistroLiquidacionDescuentoLegalCCDao registroLiquidacionDescuentoLegalCCDao = DaoFactory
					.getInstance().getRegistroLiquidacionDescuentoLegalCCDao();
			List<RegistroLiquidacionDescuentoLegalCC> listOldRegistroLiquidacionDescuentoLegalCC = registroLiquidacionDescuentoLegalCCDao
					.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionDescuentoLegalCC.size(); i++) {
				registroLiquidacionDescuentoLegalCCDao
						.makeTransient(listOldRegistroLiquidacionDescuentoLegalCC
								.get(i));
			}
			// REGISTRO LIQUIDACION DESCUENTO VARIO
			// borra registros antiguos
			RegistroLiquidacionDescuentoVarioCCDao registroLiquidacionDescuentoVarioCCDao = DaoFactory
					.getInstance().getRegistroLiquidacionDescuentoVarioCCDao();
			List<RegistroLiquidacionDescuentoVarioCC> listOldRegistroLiquidacionDescuentoVarioCC = registroLiquidacionDescuentoVarioCCDao
					.findAll();
			for (int i = 0; i < listOldRegistroLiquidacionDescuentoVarioCC.size(); i++) {
				registroLiquidacionDescuentoVarioCCDao
						.makeTransient(listOldRegistroLiquidacionDescuentoVarioCC
								.get(i));
			}
			// REGISTRO ISAPRE
			// borra registros antiguos
			RegistroIsapreCCDao registroIsapreCCDao = DaoFactory.getInstance()
					.getRegistroIsapreCCDao();
			List<RegistroIsapreCC> listOldRegistroIsapreCC = registroIsapreCCDao
					.findAll();
			for (int i = 0; i < listOldRegistroIsapreCC.size(); i++) {
				registroIsapreCCDao.makeTransient(listOldRegistroIsapreCC.get(i));
			}
			// REGISTRO AFP
			// borra registros antiguos
			RegistroAfpCCDao registroAfpCCDao = DaoFactory.getInstance()
					.getRegistroAfpCCDao();
			List<RegistroAfpCC> listOldRegistroAfpCC = registroAfpCCDao.findAll();
			for (int i = 0; i < listOldRegistroAfpCC.size(); i++) {
				registroAfpCCDao.makeTransient(listOldRegistroAfpCC.get(i));
			}
			// REGISTRO MUTUAL
			// borra registros antiguos
			RegistroMutualCCDao registroMutualCCDao = DaoFactory.getInstance()
					.getRegistroMutualCCDao();
			List<RegistroMutualCC> listOldRegistroMutualCC = registroMutualCCDao
					.findAll();
			for (int i = 0; i < listOldRegistroMutualCC.size(); i++) {
				registroMutualCCDao.makeTransient(listOldRegistroMutualCC.get(i));
			}
			// REGISTRO CAJA
			// borra registros antiguos
			RegistroCajaCCDao registroCajaCCDao = DaoFactory.getInstance()
					.getRegistroCajaCCDao();
			List<RegistroCajaCC> listOldRegistroCajaCC = registroCajaCCDao.findAll();
			for (int i = 0; i < listOldRegistroCajaCC.size(); i++) {
				registroCajaCCDao.makeTransient(listOldRegistroCajaCC.get(i));
			}
			// REGISTRO INP
			// borra registros antiguos
			RegistroInpCCDao registroInpCCDao = DaoFactory.getInstance()
					.getRegistroInpCCDao();
			List<RegistroInpCC> listOldRegistroInpCC = registroInpCCDao.findAll();
			for (int i = 0; i < listOldRegistroInpCC.size(); i++) {
				registroInpCCDao.makeTransient(listOldRegistroInpCC.get(i));
			}
			
			
			
			
			
			
			
			// PARA CADA CENTRO DE COSTO

			List<CentroCosto> listCentroCosto = new LinkedList<CentroCosto>(
					empresaCuenta.getCentroCostos());
			for (int w = 0; w < listCentroCosto.size(); w++) {

				CentroCosto centroCosto = listCentroCosto.get(w);

				// CREA LOS DEMAS REGISTROS
				List<TrabajadorCuenta> listTrabajadorCuenta = new LinkedList<TrabajadorCuenta>(
						empresaCuenta.getTrabajadorCuentas());
				for (int i = 0; i < listTrabajadorCuenta.size(); i++) {

					TrabajadorCuenta trabajadorCuenta = listTrabajadorCuenta.get(i);

					List<TrabajadorCentroCosto> listTrabajadorCentroCosto = new LinkedList<TrabajadorCentroCosto>(
							trabajadorCuenta.getTrabajadorCentroCostos());

					for (int p = 0; p < listTrabajadorCentroCosto.size(); p++) {

						TrabajadorCentroCosto trabajadorCentroCosto = listTrabajadorCentroCosto.get(p);

						//CentroCosto centroCosto = listTrabajadorCentroCosto.get(p).getCentroCosto();

						if (centroCosto.equals(listTrabajadorCentroCosto.get(p).getCentroCosto())) {


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

							Persona persona = trabajadorCuenta.getTrabajador()
									.getDatosPersonales();

							// datos personales
							rutTrabajador = persona.getRut();
							paterno = persona.getApellidoPaterno();
							materno = persona.getApellidoMaterno();
							nombres = persona.getNombres();

							// List<TrabajadorCentroCosto>
							// listTrabajadorCentroCosto
							// =
							// new LinkedList<TrabajadorCentroCosto>(
							// trabajadorCuenta.getTrabajadorCentroCostos());

							// dias trabajados
							dias = new Double(trabajadorCentroCosto.getDiasTrabajados().doubleValue());
							if (dias.doubleValue() > 30) {
								dias = new Double(30);
							}
							// horas extraordinarias
							horas = new Long(trabajadorCentroCosto.getHorasExtraordinarias().longValue());
							// sueldo base
							sueldoBase = new Long(0);
							valorHoraProfesor = new Long(0);
							horasProfesor = new Long(0);
							if(trabajadorCentroCosto.getCentroCosto().getNumero().equals(new Long(100))) {
								isProfesor = Boolean.TRUE;
								valorHoraProfesor = trabajadorCentroCosto.getMonto().longValue();
								horasProfesor = trabajadorCentroCosto.getHoras().longValue();
								sueldoBase = new Long(Math.round(valorHoraProfesor * horasProfesor
										*trabajadorCentroCosto.getDiasTrabajados().doubleValue() / 30));
							} else {
								sueldoBase = new Long(Math.round(trabajadorCentroCosto.getMonto().longValue()
												*trabajadorCentroCosto.getDiasTrabajados().doubleValue() / 30));
							}
							this.registroLiquidacionImponibleCC
									.add(new RegistroLiquidacionImponibleCC(
											centroCosto.getNumero(),
											persona.getRut(),
											Palabra.imponibleSueldoBase,
											sueldoBase));
							// pago horas extraordinarias
							if(trabajadorCentroCosto.getCentroCosto().getNumero().equals(new Long(100))) {
								pagoHoras = new Long(Math.round(valorHoraProfesor * horasProfesor
										* (0.007777777777)* trabajadorCentroCosto.getHorasExtraordinarias().longValue()));
							} else {
								pagoHoras = new Long(Math.round(trabajadorCentroCosto.getMonto().longValue()
									* (0.007777777777)* trabajadorCentroCosto.getHorasExtraordinarias().longValue()));
							}
							this.registroLiquidacionImponibleCC
									.add(new RegistroLiquidacionImponibleCC(
											centroCosto.getNumero(),
											persona.getRut(),
											Palabra.imponibleHorasExtraordinarias,
											pagoHoras));

							/**************************************************************
							 * ACA VOY
							 **************************************************************/
								
							List<TrabajadorImponible> listTrabajadorImponible = new LinkedList<TrabajadorImponible>(
									trabajadorCuenta.getTrabajadorImponibles());
							// otros imponibles
							otrosImponibles = new Long(0);
							for (int j = 0; j < listTrabajadorImponible.size(); j++) {
								TrabajadorImponible ti = listTrabajadorImponible.get(j);
								//otrosImponibles = new Long(otrosImponibles.longValue()+ ti.getMonto().longValue());
								this.registroLiquidacionImponibleCC.add(new RegistroLiquidacionImponibleCC(
										centroCosto.getNumero(), persona.getRut(), ti.getImponible().getNombre(), new Long(ti.getMonto().longValue())));

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
									otrosImponibles = new Long(otrosImponibles.longValue()+ ti.getMonto().longValue());
								}
							
							}
							// gratificación
							baseGratificacion = new Long(sueldoBase.longValue()
									+ pagoHoras.longValue()
									+ otrosImponibles.longValue());
							topeGratificacion = new Long(Math.round((mes
									.getGratificacionFactorAnual()
									.doubleValue() * mes.getSueldoMinimo()
									.doubleValue()) / 12));
							gratificacion = new Long(0);
							if (empresaCuenta.getGratificacion().equals(
									Palabra.gratificacionSin)) {
								gratificacion = new Long(0);
							} else if (empresaCuenta.getGratificacion().equals(
									Palabra.gratificacionPorcentaje)) {
								gratificacion = new Long(
										Math.round(baseGratificacion.longValue() * mes
												.getGratificacionPorcentaje().doubleValue()/ 100));
							} else if (empresaCuenta.getGratificacion().equals(
									Palabra.gratificacionPorcentajeTope)) {
								if (baseGratificacion.longValue() * mes.getGratificacionPorcentaje()
										.doubleValue() / 100 <= topeGratificacion.longValue()) { 
									gratificacion = new Long(Math.round(baseGratificacion
											.longValue() * mes.getGratificacionPorcentaje().doubleValue() / 100));
								} else {
									gratificacion = topeGratificacion;
								}
							}
							this.registroLiquidacionImponibleCC
									.add(new RegistroLiquidacionImponibleCC(
											centroCosto.getNumero(),
											persona.getRut(),
											Palabra.imponibleGratificacion,
											gratificacion));
							// imponible
							imponible = new Long(sueldoBase.longValue()
									+ pagoHoras.longValue()
									+ otrosImponibles.longValue()
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
							topePrevision = new Long(Math.round(mes
									.getPrevisionAfpTope().doubleValue()
									* mes.getUf().doubleValue()));
							imponiblePrevision = new Long(0);
							System.out.println("IMPONIBLE: "
									+ imponible.longValue());
							System.out.println("TOPE PREVISION: "
									+ topePrevision.longValue());
							if (imponible.longValue() <= topePrevision
									.longValue()) {
								imponiblePrevision = imponible;
							} else {
								imponiblePrevision = topePrevision;
							}
							System.out.println("IMPONIBLE PREVISION: "
									+ imponiblePrevision.longValue());
							// imponible accidente del trabajo
							// TODO imponible accidente del trabajo uso tope de
							// prevision
							topeAccidenteTrabajo = new Long(Math.round(mes
									.getPrevisionAfpTope().doubleValue()
									* mes.getUf().doubleValue()));
							imponibleAccidenteTrabajo = new Long(0);
							if (imponible.longValue() <= topeAccidenteTrabajo
									.longValue()) {
								imponibleAccidenteTrabajo = imponible;
							} else {
								imponibleAccidenteTrabajo = topeAccidenteTrabajo;
							}
							// imponible seguro cesantia
							topeSeguroCesantia = new Long(Math.round(mes
									.getSeguroCesantiaTope().doubleValue()
									* mes.getUf().doubleValue()));
							imponibleSeguroCesantia = new Long(0);
							if (trabajadorCuenta.isSeguroCesantia()
									.booleanValue()) {
								if (imponible.longValue() <= topeSeguroCesantia
										.longValue()) {
									imponibleSeguroCesantia = imponible;
								} else {
									imponibleSeguroCesantia = topeSeguroCesantia;
								}
							}

							AsignacionDao asignacionDao = DaoFactory
									.getInstance().getAsignacionDao();
							List<Asignacion> listAsignacion = new LinkedList<Asignacion>(
									asignacionDao.findByMes(mes));
							// BORRAR List<Asignacion> listAsignacion = new
							// LinkedList<Asignacion>(mes.getAsignaciones());
							// asignacion familiar
							sueldoPromedio = new Long(trabajadorCuenta
									.getSueldoPromedio().longValue());
							asignacionFamiliar = new Long(0);
							montoAsignacionFamiliar = new Long(0);
							tramo = "";
							for (int j = 0; j < listAsignacion.size(); j++) {
								if (listAsignacion.size() > j + 1) {
									if (j == 0) {
										if (0 <= sueldoPromedio
												&& (listAsignacion.get(j + 1)
														.getInicio()
														.longValue()) >= sueldoPromedio) {
											montoAsignacionFamiliar = new Long(
													listAsignacion.get(j)
															.getMonto()
															.longValue());
											tramo = new Long(j + 1).toString();
											break;
										}
									} else if (listAsignacion.get(j)
											.getInicio().longValue() < sueldoPromedio
											&& listAsignacion.get(j + 1)
													.getInicio().longValue() >= sueldoPromedio) {
										montoAsignacionFamiliar = new Long(
												listAsignacion.get(j)
														.getMonto().longValue());
										tramo = new Long(j + 1).toString();
										break;
									}
								} else {
									montoAsignacionFamiliar = new Long(
											listAsignacion.get(j).getMonto()
													.longValue());
									tramo = new Long(j + 1).toString();
									break;
								}
							}
							numeroCargaSimple = trabajadorCuenta
									.getNumeroCargasNormal();
							numeroCargaInvalida = trabajadorCuenta
									.getNumeroCargasInvalida();
							numeroCargaMaternal = new Long(0); // TODO no se
							// ingresa
							// por
							// pantalla las cargas
							// maternales, queda en cero
							montoCargaSimple = new Long(numeroCargaSimple
									.longValue()
									* montoAsignacionFamiliar.longValue());
							montoCargaInvalida = new Long(2
									* numeroCargaInvalida.longValue()
									* montoAsignacionFamiliar.longValue());
							montoCargaMaternal = new Long(numeroCargaMaternal
									.longValue()
									* montoAsignacionFamiliar.longValue());
							/**
							 * *******************************************************************************
							 * ***** AQUI MODIFICO LO DE ASIGNACION FAMILIAR PARA QUE NO QUE EL MONTO NO *****
							 * ***** SEA PROPORCIONAL A LA CANTIDAD DE DIAS TRABAJADOS.                  *****
							 * *******************************************************************************
							 */
							if (dias < 25) {
								montoCargaSimple = new Long(Math
										.round(montoCargaSimple.longValue()
												* dias.doubleValue() / 30));
								montoCargaInvalida = new Long(Math
										.round(montoCargaInvalida.longValue()
												* dias.doubleValue() / 30));
								montoCargaMaternal = new Long(Math
										.round(montoCargaMaternal.longValue()
												* dias.doubleValue() / 30));
							}
							asignacionFamiliar = montoCargaSimple
									+ montoCargaInvalida + montoCargaMaternal;
							this.registroLiquidacionNoImponibleCC
									.add(new RegistroLiquidacionNoImponibleCC(
											centroCosto.getNumero(),
											persona.getRut(),
											Palabra.noImponibleAsignacionFamiliar,
											asignacionFamiliar));

							List<TrabajadorNoImponible> listTrabajadorNoImponible = 
								new LinkedList<TrabajadorNoImponible>(
									trabajadorCuenta.getTrabajadorNoImponibles());
							// movilización
							movilizacion = new Long(0);
							for (int j = 0; j < listTrabajadorNoImponible
									.size(); j++) {
								if (listTrabajadorNoImponible.get(j)
										.getNoImponible().getNombre()
										.equals(Palabra.noImponibleMovilizacion)) {
									movilizacion = new Long(
										listTrabajadorNoImponible.get(j).getMonto().longValue());
									break;
								}
							}
							// colación
							colacion = new Long(0);
							for (int j = 0; j < listTrabajadorNoImponible.size(); j++) {
								if (listTrabajadorNoImponible.get(j)
									.getNoImponible().getNombre().equals(Palabra.noImponibleColacion)) {
									colacion = new Long(
											listTrabajadorNoImponible.get(j)
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
								this.registroLiquidacionNoImponibleCC
										.add(new RegistroLiquidacionNoImponibleCC(
												centroCosto.getNumero(),
												persona.getRut(), tni
														.getNoImponible()
														.getNombre(), new Long(
														tni.getMonto()
																.longValue())));
							}
							
							/** ESTO LO MOVI DE ARRIBA */
							montoCargaSimple+=cargaRetroactiva;
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
									+ movilizacion.longValue()
									+ colacion.longValue()
									+ otrosNoImponibles.longValue());

							// nombre afp - regimen
							institucionPrevision = null;
							regimen = null;
							if (trabajadorCuenta.getAfp() != null) {
								institucionPrevision = trabajadorCuenta
										.getAfp().getNombre();
								regimen = trabajadorCuenta.getAfp()
										.getRegimen();
							}
							// afp - prevision
							porcentajePrevision = new Double(0);
							prevision = new Long(0);
							if (institucionPrevision != null) {
								porcentajePrevision = new Double(
										trabajadorCuenta.getAfp()
												.getCotizacion().doubleValue());
								prevision = new Long(Math
										.round(imponiblePrevision.longValue()
												* porcentajePrevision
														.doubleValue() / 100));
								this.registroLiquidacionDescuentoLegalCC
										.add(new RegistroLiquidacionDescuentoLegalCC(
												centroCosto.getNumero(),
												persona.getRut(),
												institucionPrevision
														+ " ("
														+ porcentajePrevision
																.toString()
														+ ")", prevision));
							}
							// ahorro voluntario
							ahorroVoluntario = new Long(0);
							if (trabajadorCuenta.getValorAhorroVoluntario()
									.longValue() > 0) {
								ahorroVoluntario = new Long(trabajadorCuenta
										.getValorAhorroVoluntario().longValue());
							}
							if (ahorroVoluntario.longValue() != 0) {
								this.registroLiquidacionDescuentoLegalCC
										.add(new RegistroLiquidacionDescuentoLegalCC(
												centroCosto.getNumero(),
												persona.getRut(),
												Palabra.descuentoAhorroVoluntario,
												ahorroVoluntario));
							}
							// apv
							// TODO calculo apv
							topeApv = Math.round(mes.getPrevisionApvTope()
									.doubleValue()
									* mes.getUf().doubleValue());
							apv = new Long(0);
							if (apv.longValue() != 0) {
								this.registroLiquidacionDescuentoLegalCC
										.add(new RegistroLiquidacionDescuentoLegalCC(
												centroCosto.getNumero(),
												persona.getRut(),
												Palabra.descuentoApv, apv));
							}
							/*
							 * if (institucionPrevision != null) { if
							 * (regimen.equals(Palabra.regimenNuevo)) { if
							 * (trabajadorCuenta.getValorAhorroVoluntario()
							 * .longValue() <= topeApv.longValue()) { apv = new
							 * Long(trabajadorCuenta
							 * .getValorAhorroVoluntario().longValue()); } else {
							 * apv = topeApv; } if (apv.longValue() != 0) {
							 * this.registroLiquidacionDescuentoLegal .add(new
							 * RegistroLiquidacionDescuentoLegal(
							 * persona.getRut(), Palabra.descuentoApv, apv)); } } }
							 */

							// nombre salud
							if (trabajadorCuenta.getTipoSalud().equals(
									Palabra.tipoSaludIsapre)) {
								institucionSalud = trabajadorCuenta.getIsapre()
										.getNombre();
							} else {
								institucionSalud = Palabra.institucionFonasa;
							}
							// salud
							porcentajeSalud = new Double(mes
									.getSaludCotizacionBasica().doubleValue());
							salud = new Long(Math.round(imponibleSalud
									.longValue()
									* porcentajeSalud.doubleValue() / 100));
							this.registroLiquidacionDescuentoLegalCC
									.add(new RegistroLiquidacionDescuentoLegalCC(
											centroCosto.getNumero(),
											persona.getRut(), institucionSalud
													+ " ("
													+ porcentajeSalud
															.toString() + ")",
											salud));
							// salud a fonasa y salud a caja
							saludFonasa = new Long(0);
							saludCaja = new Long(0);
							if (institucionSalud
									.equals(Palabra.institucionFonasa)) {
								if (nombreCaja == null) {
									saludFonasa = salud;
								} else {
									saludFonasa = new Long(
											Math.round(imponibleSalud
													.longValue() * 6.4 / 100)); // TODO
									// 6.4
									// se
									// deberia ingresar
									// por pantalla
									saludCaja = new Long(
											Math.round(imponibleSalud
													.longValue() * 0.6 / 100)); // TODO
																				// 0.6
									// se
									// deberia ingresar
									// por pantalla
								}
							}
							// total prevision
							totalPrevision = new Long(prevision.longValue()
									+ apv.longValue()
									+ ahorroVoluntario.longValue()
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
								seguroCesantiaTrabajador = new Long(
										Math
												.round(imponibleSeguroCesantia
														.longValue()
														* mes
																.getSeguroCesantiaPorcentaje()
																.doubleValue()
														/ 100));
								seguroCesantiaEmpleador = new Long(Math
										.round(imponibleSeguroCesantia
												.longValue() * 2.4 / 100)); // TODO
								// 2.4
								// se
								// deberia
								// ingresar
								// por
								// pantalla
								this.registroLiquidacionDescuentoLegalCC
										.add(new RegistroLiquidacionDescuentoLegalCC(
												centroCosto.getNumero(),
												persona.getRut(),
												Palabra.descuentoSeguroCesantia
														+ " ("
														+ mes
																.getSeguroCesantiaPorcentaje()
																.toString()
														+ ")",
												seguroCesantiaTrabajador));
							} else {
								seguroCesantiaEmpleador = new Long(Math
										.round(imponibleSeguroCesantia
												.longValue() * 3.0 / 100)); // TODO
								// 3.0
								// se
								// deberia
								// ingresar
								// por
								// pantalla
								this.registroLiquidacionDescuentoLegalCC
										.add(new RegistroLiquidacionDescuentoLegalCC(
												centroCosto.getNumero(),
												persona.getRut(),
												Palabra.descuentoSeguroCesantia,
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

							ImpuestoDao impuestoDao = DaoFactory.getInstance()
									.getImpuestoDao();
							List<Impuesto> listImpuesto = new LinkedList<Impuesto>(
									impuestoDao.findByMes(mes));
							// BORRAR List<Impuesto> listImpuesto = new
							// LinkedList<Impuesto>(mes.getImpuestos());
							// impuesto unico
							impuesto = new Long(0);
							factorImpuesto = new Double(0);
							rebajaImpuesto = new Double(0);
							if (0 <= totalAfecto.longValue()) {
								search:
								for (int j = 0; j < listImpuesto.size(); j++) {
									if (listImpuesto.size() > j + 1) {
										if (j == 0) {
											if (0 <= totalAfecto.longValue()
													&& Math
															.round(listImpuesto
																	.get(j + 1)
																	.getInicio()
																	.doubleValue()
																	* mes
																			.getUtm()
																			.doubleValue()) >= totalAfecto) {
												factorImpuesto = new Double(
														listImpuesto.get(j)
																.getFactor()
																.doubleValue());
												rebajaImpuesto = new Double(
														listImpuesto.get(j)
																.getRebaja()
																.doubleValue()
																* mes
																		.getUtm()
																		.doubleValue());
												break search;
											}
										} else if (Math.round(listImpuesto.get(
												j).getInicio().doubleValue()
												* mes.getUtm().doubleValue()) < totalAfecto
												&& Math.round(listImpuesto.get(
														j + 1).getInicio()
														.doubleValue()
														* mes.getUtm()
																.doubleValue()) >= totalAfecto) {
											factorImpuesto = new Double(
													listImpuesto.get(j)
															.getFactor()
															.doubleValue());
											rebajaImpuesto = new Double(
													listImpuesto.get(j)
															.getRebaja()
															.doubleValue()
															* mes
																	.getUtm()
																	.doubleValue());
											break search;
										}
									} else {
										factorImpuesto = new Double(
												listImpuesto.get(j).getFactor()
														.doubleValue());
										rebajaImpuesto = new Double(
												listImpuesto.get(j).getRebaja()
														.doubleValue()
														* mes.getUtm()
																.doubleValue());
										break search;
									}
								}
							impuesto = new Long(
									Math
											.round((totalAfecto.longValue() * factorImpuesto
													.doubleValue())
													- rebajaImpuesto
															.doubleValue()));

							}
							this.registroLiquidacionDescuentoLegalCC
									.add(new RegistroLiquidacionDescuentoLegalCC(
											centroCosto.getNumero(),
											persona.getRut(),
											Palabra.descuentoImpuestoUnico,
											impuesto));
							// diferencia isapre
							diferenciaIsapre = new Long(0);
							pactoIsapre = new Long(0);
							if (!institucionSalud
									.equals(Palabra.institucionFonasa)) {
								if (Palabra.tipoPactoUf.equals(trabajadorCuenta
										.getTipoPactoIsapre())) {
									pactoIsapre = new Long(
											Math
													.round(trabajadorCuenta
															.getValorPactoIsapre()
															.doubleValue()
															* mes
																	.getUf()
																	.doubleValue()));
								} else {
									pactoIsapre = new Long(trabajadorCuenta
											.getValorPactoIsapre().longValue());
								}
								if ((pactoIsapre.longValue() - salud
										.longValue()) > 0) {
									diferenciaIsapre = new Long(pactoIsapre
											.longValue()
											- salud.longValue());
								} else {
									diferenciaIsapre = new Long(0);
								}
								if (diferenciaIsapre.longValue() != 0) {
									this.registroLiquidacionDescuentoLegalCC
											.add(new RegistroLiquidacionDescuentoLegalCC(
													centroCosto.getNumero(),
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
								if (listTrabajadorDescuento.get(j)
										.getDescuento().getNombre().equals(
												Palabra.descuentoAnticipo)) {
									anticipo = new Long(listTrabajadorDescuento
											.get(j).getMonto().longValue());
									break;
								}
							}
							// otros descuentos
							otrosDescuentos = new Long(0);
							for (int j = 0; j < listTrabajadorDescuento.size(); j++) {
								TrabajadorDescuento td = listTrabajadorDescuento
										.get(j);
								if (!td.getDescuento().getNombre().equals(
										Palabra.descuentoAnticipo)) {
									otrosDescuentos = new Long(otrosDescuentos
											.longValue()
											+ td.getMonto().longValue());
								}
								this.registroLiquidacionDescuentoVarioCC
										.add(new RegistroLiquidacionDescuentoVarioCC(
												centroCosto.getNumero(),
												persona.getRut(), td
														.getDescuento()
														.getNombre(), new Long(
														td.getMonto()
																.longValue())));
							}
							// total descuentos
							totalDescuentos = new Long(totalPrevision
									.longValue()
									+ seguroCesantiaTrabajador.longValue()
									+ impuesto.longValue()
									+ diferenciaIsapre.longValue()
									+ anticipo.longValue()
									+ otrosDescuentos.longValue());
							// liquido
							liquido = new Long(totalHaberes.longValue()
									- totalDescuentos.longValue());

							// accidente del trabajo
							accidenteTrabajo = new Long(Math
									.round(imponibleAccidenteTrabajo
											.longValue()
											* this.cotizacionAccidenteTrabajo
													.doubleValue() / 100));

							// crear registros
							if(isProfesor) {
								registroLibroCC.add(new RegistroLibroCC(
									centroCosto.getNumero(), rutTrabajador,
									paterno, materno, nombres, dias, horas,
									sueldoBase, pagoHoras, otrosImponibles,
									gratificacion, imponible,
									asignacionFamiliar, movilizacion, colacion,
									otrosNoImponibles, totalHaberes,
									institucionPrevision, prevision, apv,
									ahorroVoluntario, institucionSalud, salud,
									totalPrevision, seguroCesantiaTrabajador,
									totalAfecto, impuesto, diferenciaIsapre,
									anticipo, otrosDescuentos, totalDescuentos,
									liquido, valorHoraProfesor, horasProfesor,
									ump, bpp80, bcomp80, ley19464, bonoResponsabilidad, leySep,  jefaturaCurso, bonoReconocimiento));
							} else {
								registroLibroCC.add(new RegistroLibroCC(
										centroCosto.getNumero(), rutTrabajador,
										paterno, materno, nombres, dias, horas,
										sueldoBase, pagoHoras, otrosImponibles,
										gratificacion, imponible,
										asignacionFamiliar, movilizacion, colacion,
										otrosNoImponibles, totalHaberes,
										institucionPrevision, prevision, apv,
										ahorroVoluntario, institucionSalud, salud,
										totalPrevision, seguroCesantiaTrabajador,
										totalAfecto, impuesto, diferenciaIsapre,
										anticipo, otrosDescuentos, totalDescuentos,
										liquido, null, null,
										ump, bpp80, bcomp80, ley19464, bonoResponsabilidad, leySep,  jefaturaCurso, bonoReconocimiento));
							}
						
							registroLiquidacionCC.add(new RegistroLiquidacionCC(
									centroCosto.getNumero(),
									rutTrabajador, paterno, materno, nombres,
									dias));
							
							if (!institucionSalud
									.equals(Palabra.institucionFonasa)) {
								registroIsapreCC
										.add(new RegistroIsapreCC(
												centroCosto.getNumero(),
												institucionSalud,
												rutTrabajador, paterno,
												materno, nombres,
												imponibleSalud, salud,
												diferenciaIsapre,
												new Long(salud.longValue()
														+ diferenciaIsapre
																.longValue()),
												pactoIsapre));
							}

							if (institucionPrevision != null
									&& regimen.equals(Palabra.regimenNuevo)) {
								registroAfpCC.add(new RegistroAfpCC(
										centroCosto.getNumero(),
										institucionPrevision, rutTrabajador,
										paterno, materno, nombres,
										imponiblePrevision, prevision,
										ahorroVoluntario, trabajadorCuenta
												.isSeguroCesantia(),
										imponibleSeguroCesantia,
										seguroCesantiaTrabajador,
										seguroCesantiaEmpleador,
										
										Math.round(mes.getPrevisionSeguroInvalidez()*imponiblePrevision/100)
										
								));
							}
							/** NEW */
							else if (institucionPrevision != null
									&& regimen.equals(Palabra.regimenAntiguo)
									&& trabajadorCuenta.isSeguroCesantia().booleanValue() ) {
								institucionPrevision2 = trabajadorCuenta.getAfp2().getNombre();
								registroAfpCC.add(new RegistroAfpCC(centroCosto.getNumero(),
										institucionPrevision2,
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

							if (this.nombreCaja != null) {
								if (institucionSalud.equals(Palabra.institucionFonasa)) {
									registroCajaCC.add(new RegistroCajaCC(
											centroCosto.getNumero(),
											rutTrabajador, paterno, materno,
											nombres, imponiblePrevision,
											new Long(0), dias,
											numeroCargaSimple,
											numeroCargaInvalida,
											numeroCargaMaternal,
											asignacionFamiliar, 
											saludCaja, 
											tramo));
								} else {
									registroCajaCC.add(new RegistroCajaCC(
											centroCosto.getNumero(),
											rutTrabajador, paterno, materno,
											nombres, new Long(0),
											imponiblePrevision, dias,
											numeroCargaSimple,
											numeroCargaInvalida,
											numeroCargaMaternal,
											asignacionFamiliar,
											new Long(0),
											tramo));
								}
							}

							if (this.nombreMutual != null) {
								registroMutualCC.add(new RegistroMutualCC(
										centroCosto.getNumero(),
										rutTrabajador, paterno, materno,
										nombres, imponibleAccidenteTrabajo,
										accidenteTrabajo));
							}

							// inp
							Long inpPension = new Long(0);
							Long inpFonasa = new Long(0);
							Long inpAccidenteTrabajo = new Long(0);
							if (regimen != null) {
								if (regimen.equals(Palabra.regimenAntiguo)) {
									inpPension = prevision;
								}
							}
							if (institucionSalud
									.equals(Palabra.institucionFonasa)) {
								if (nombreCaja == null) {
									inpFonasa = salud;
								} else {
									inpFonasa = saludFonasa;
								}
							}
							if (nombreMutual == null) {
								inpAccidenteTrabajo = accidenteTrabajo;
							}
							if (nombreCaja == null) {
								registroInpCC
										.add(new RegistroInpCC(
												centroCosto.getNumero(), rutTrabajador,
												paterno, materno, nombres,
												dias, imponiblePrevision,
												inpPension, inpFonasa,
												inpAccidenteTrabajo, tramo,
												numeroCargaSimple,
												montoCargaSimple,
												numeroCargaInvalida,
												montoCargaInvalida,
												numeroCargaMaternal,
												montoCargaMaternal));
							} else {
								registroInpCC.add(new RegistroInpCC(
										centroCosto.getNumero(), rutTrabajador,
										paterno, materno, nombres, dias,
										imponiblePrevision, inpPension,
										inpFonasa, inpAccidenteTrabajo, tramo,
										new Long(0), new Long(0), new Long(0),
										new Long(0), new Long(0), new Long(0)));
							}

						}
					}
				}
			}
				// AGREGA REGISTROS A LA BD

				// REGISTRO EMPRESA
				// agrega registros a bd
				/** registroEmpresaDao.makePersistent(registroEmpresa); */

				// REGISTRO LIBRO
				// agrega registros a bd
				for (int i = 0; i < registroLibroCC.size(); i++) {
					registroLibroCCDao.makePersistent(registroLibroCC.get(i));
				}

				// REGISTRO LIQUIDACION
				// agrega registros a bd
				for (int i = 0; i < registroLiquidacionCC.size(); i++) {
					registroLiquidacionCCDao.makePersistent(registroLiquidacionCC.get(i));
				}

				// REGISTRO LIQUIDACION IMPONIBLE
				// agrega registros a bd
				for (int i = 0; i < registroLiquidacionImponibleCC.size(); i++) {
					registroLiquidacionImponibleCCDao
							.makePersistent(registroLiquidacionImponibleCC.get(i));
				}

				// REGISTRO LIQUIDACION NO IMPONIBLE
				// agrega registros a bd
				for (int i = 0; i < registroLiquidacionNoImponibleCC.size(); i++) {
					registroLiquidacionNoImponibleCCDao
							.makePersistent(registroLiquidacionNoImponibleCC.get(i));
				}

				// REGISTRO LIQUIDACION DESCUENTO LEGAL
				// agrega registros a bd
				for (int i = 0; i < registroLiquidacionDescuentoLegalCC.size(); i++) {
					registroLiquidacionDescuentoLegalCCDao
							.makePersistent(registroLiquidacionDescuentoLegalCC
									.get(i));
				}

				// REGISTRO LIQUIDACION DESCUENTO VARIO
				// agrega registros a bd
				for (int i = 0; i < registroLiquidacionDescuentoVarioCC.size(); i++) {
					registroLiquidacionDescuentoVarioCCDao
							.makePersistent(registroLiquidacionDescuentoVarioCC
									.get(i));
				}
			
				// REGISTRO ISAPRE
				// agrega registros a bd
				for (int i = 0; i < registroIsapreCC.size(); i++) {
					registroIsapreCCDao.makePersistent(registroIsapreCC.get(i));
				}

				// REGISTRO AFP
				// agrega registros a bd
				for (int i = 0; i < registroAfpCC.size(); i++) {
					registroAfpCCDao.makePersistent(registroAfpCC.get(i));
				}

				// REGISTRO MUTUAL
				// agrega registros a bd
				for (int i = 0; i < registroMutualCC.size(); i++) {
					registroMutualCCDao.makePersistent(registroMutualCC.get(i));
				}

				// REGISTRO CAJA
				// agrega registros a bd
				for (int i = 0; i < registroCajaCC.size(); i++) {
					registroCajaCCDao.makePersistent(registroCajaCC.get(i));
				}
				
				// REGISTRO INP
				// agrega registros a bd
				for (int i = 0; i < registroInpCC.size(); i++) {
					registroInpCCDao.makePersistent(registroInpCC.get(i));
				}
				
			
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

}
