package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import org.eclipse.jdt.core.compiler.IScanner;
import org.rem.control.institucion.ControlAfp;
import org.rem.dao.CajaDao;
import org.rem.dao.CentroCostoDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaCuentaDao;
import org.rem.dao.EmpresaDao;
import org.rem.dao.MutualDao;
import org.rem.dao.TrabajadorCentroCostoDao;
import org.rem.dao.TrabajadorDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Caja;
import org.rem.model.CentroCosto;
import org.rem.model.Empresa;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Mes;
import org.rem.model.Mutual;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCentroCosto;
import org.rem.model.TrabajadorCuenta;
import org.rem.model.TrabajadorDescuento;
import org.rem.model.TrabajadorImponible;
import org.rem.model.TrabajadorNoImponible;

public class ControlEmpresaCuenta {

	public int respExito = 0;
	
	public int respCerrada = 1;

	public int respExiste = 2;

	public int respNoExiste = 3;

	public int respNoExisteEmpresa = 4;
	
	public int respNoExisteMes = 5;
	
	public int respNoExisteCentroCosto = 6;
	
	public int respUsandoCentroCosto = 7;
	
	public int respCentroCostoReservado = 8;
	
	public int respNombreCentroCostoReservado = 9;

	public int addEmpresaCuenta(Empresa empresa, Mes mes, String gratificacion,
			Caja caja, Mutual mutual, Double mutualCotizacionAdicional) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (mes!= null) {
				EmpresaDao empresaDao = DaoFactory.getInstance().getEmpresaDao();
				empresa = empresaDao.findByRutEmpresa(empresa.getRutEmpresa());
				if (empresa != null) {
					if (caja!=null) {
						CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
						caja = cajaDao.findByNombre(caja.getNombre());
					}
					if (mutual!=null) {
						MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
						mutual = mutualDao.findByNombre(mutual.getNombre());
					}
					EmpresaCuentaDao cuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
					EmpresaCuenta lastCuenta = cuentaDao.findByEmpresaLast(empresa);
					EmpresaCuenta cuenta = new EmpresaCuenta(gratificacion, caja, mutual, mutualCotizacionAdicional, mes);
					empresa.addCuenta(cuenta);
					cuenta = cuentaDao.findByEmpresaMes(empresa, mes);
					empresaDao.makePersistent(empresa);
					
					if (lastCuenta!=null) {
						
						// copia los centros de costo de la última cuenta
						List<CentroCosto> listCC = new LinkedList<CentroCosto>(lastCuenta.getCentroCostos());
						System.out.println("TAMAÑO DE LISTA: "+listCC.size());
						for (int i=0; i<listCC.size(); i++) {
							cuenta.addCentroCosto(new CentroCosto(listCC.get(i)));
						}
						
						// copia cuentas de trabajadores de la última cuenta
						TrabajadorDao trabajadorDao = DaoFactory.getInstance().getTrabajadorDao();
						List<TrabajadorCuenta> listTrabCuenta = new LinkedList<TrabajadorCuenta>(lastCuenta.getTrabajadorCuentas());
						for (int i=0; i<listTrabCuenta.size(); i++) {

							Trabajador trabajador = trabajadorDao.findByEmpresaRutTrabajador(empresa, listTrabCuenta.get(i).getTrabajador().getDatosPersonales().getRut());
							TrabajadorCuenta trabCuenta = new TrabajadorCuenta(listTrabCuenta.get(i));
							
							// copia los centros de costo de los trabajadores de la ultima cuenta
							List<TrabajadorCentroCosto> listTrabCentroCosto = new LinkedList<TrabajadorCentroCosto>(listTrabCuenta.get(i).getTrabajadorCentroCostos());
							for (int j=0; j<listTrabCentroCosto.size(); j++) {
								CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
								CentroCosto centro = ccDao.findByEmpresaCuentaNumero(cuenta, listTrabCentroCosto.get(j).getCentroCosto().getNumero());
								if (centro!=null) {
									TrabajadorCentroCosto trabCC = new TrabajadorCentroCosto(listTrabCentroCosto.get(j));
									trabCC.setCentroCosto(centro);
									trabCuenta.addTrabajadorCentroCosto(trabCC);									
								}
							}
							List<TrabajadorDescuento> listTrabDescuento = new LinkedList<TrabajadorDescuento>(listTrabCuenta.get(i).getTrabajadorDescuentos());
							for (int j=0; j<listTrabDescuento.size(); j++) {
								TrabajadorDescuento trabDescuento = new TrabajadorDescuento(listTrabDescuento.get(j));
								trabCuenta.addTrabajadorDescuento(trabDescuento);
							}
							List<TrabajadorImponible> listTrabImponible = new LinkedList<TrabajadorImponible>(listTrabCuenta.get(i).getTrabajadorImponibles());
							for (int j=0; j<listTrabImponible.size(); j++) {
								TrabajadorImponible trabImponible = new TrabajadorImponible(listTrabImponible.get(j));
								trabCuenta.addTrabajadorImponible(trabImponible);
							}
							List<TrabajadorNoImponible> listTrabNoImponible = new LinkedList<TrabajadorNoImponible>(listTrabCuenta.get(i).getTrabajadorNoImponibles());
							for (int j=0; j<listTrabNoImponible.size(); j++) {
								TrabajadorNoImponible trabNoImponible = new TrabajadorNoImponible(listTrabNoImponible.get(j));
								trabCuenta.addTrabajadorNoImponible(trabNoImponible);
							}
							
							trabajador.addCuenta(trabCuenta);
							cuenta.addTrabajadorCuenta(trabCuenta);
							trabajadorDao.makePersistent(trabajador);														
						}
					}
					cuentaDao.makePersistent(cuenta);
					System.err.println("¿ES UN COLEGIO?: "+empresa.isColegio());
					if(empresa.isColegio()) {
						System.err.println("ES UN COLEGIO, AGREGAR CENTRO COSTO.");
						addCentroCosto(cuenta, new Long(100), "PROFESORES");
					}
					//TODO copiar las Cuentas de Trabajador
					respuesta = respExito;
					ControlAfp.reassignAfpToTrabajadorCuenta(cuenta);
				} else {
					respuesta = respNoExisteEmpresa;
				}
			} else {
				respuesta = respNoExisteMes;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	public int removeEmpresaCuenta(EmpresaCuenta empresaCuenta) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresaCuenta!= null) {
				if (!empresaCuenta.isCerrada()) {
					EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
					empresaCuentaDao.makeTransient(empresaCuenta);
					respuesta = respExito;
				} else {
					respuesta = respCerrada;
				}
			} else {
				respuesta = respNoExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	public int updateEmpresaCuenta(EmpresaCuenta empresaCuenta, String gratificacion,
			Caja caja, Mutual mutual, Double mutualCotizacionAdicional) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresaCuenta != null) {
				if(!empresaCuenta.isCerrada()) {
				EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
				empresaCuenta.setGratificacion(gratificacion);
				if (caja!=null) {
					CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
					caja = cajaDao.findByNombre(caja.getNombre());
				}
				if (mutual!=null) {
					MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
					mutual = mutualDao.findByNombre(mutual.getNombre());
				}
				empresaCuenta.setCaja(caja);
				empresaCuenta.setMutual(mutual);
				empresaCuenta.setMutualCotizacionAdicional(mutualCotizacionAdicional);
				empresaCuentaDao.makePersistent(empresaCuenta);
				respuesta = respExito;
				} else {
					respuesta = respCerrada;
				}
			} else {
				respuesta = respNoExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}

	public int lockEmpresaCuenta(EmpresaCuenta empresaCuenta) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresaCuenta != null) {
				EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
				empresaCuenta.setCerrada(new Boolean(true));
				//TODO FALTA CERRAR LAS CUENTAS DE LOS TRABAJADORES
				empresaCuentaDao.makePersistent(empresaCuenta);
				respuesta = respExito;
			} else {
				respuesta = respNoExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	public int addCentroCosto(EmpresaCuenta empresaCuenta, Long numero, String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresaCuenta != null) {
				CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
				//if(numero!=null && numero.equals(new Long(100))) {
				//	respuesta = respCentroCostoReservado;
				//} else if (nombre!=null && nombre.equalsIgnoreCase("PROFESORES")) {
				//	respuesta = respNombreCentroCostoReservado;
				//} else 
				if (ccDao.findByEmpresaCuentaNumero(empresaCuenta, numero)==null) {
					EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
					empresaCuenta = empresaCuentaDao.findByEmpresaMes(empresaCuenta.getEmpresa(), empresaCuenta.getMes());
					empresaCuenta.addCentroCosto(new CentroCosto(numero, nombre));
					empresaCuentaDao.makePersistent(empresaCuenta);
					respuesta = respExito;
				} else {
					respuesta = respExiste;
				}
			} else {
				respuesta = respNoExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	public int removeCentroCosto(EmpresaCuenta empresaCuenta, CentroCosto centroCosto) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresaCuenta != null) {
				if (centroCosto!=null && centroCosto.getNumero().equals(new Long(100))) {
					respuesta = respCentroCostoReservado;
				} else if (centroCosto!=null) {
					//TODO FALTA VERIFICAR QUE NO ESTE SIENDO UTILIZADO POR ALGUN TrabajadorCentroCosto
					TrabajadorCentroCostoDao trabajadorCentroCostoDao = DaoFactory.getInstance().getTrabajadorCentroCostoDao();
					if (!trabajadorCentroCostoDao.isUsed(centroCosto).booleanValue()) {
						CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
						//CentroCosto centroCosto = ccDao.findByEmpresaCuentaNumero(empresaCuenta, numero);
						ccDao.makeTransient(centroCosto);
						respuesta = respExito;						
					} else {
						respuesta = respUsandoCentroCosto;
					}
				} else {
					respuesta = respNoExisteCentroCosto;
				}
			} else {
				respuesta = respNoExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}	
	
	public int updateCentroCosto(EmpresaCuenta empresaCuenta, CentroCosto centroCosto, Long numero, String nombre) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresaCuenta != null) {
				if (centroCosto!=null) {
					CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
					centroCosto = ccDao.findByEmpresaCuentaNumero(empresaCuenta, centroCosto.getNumero());
					CentroCosto newCentroCosto = ccDao.findByEmpresaCuentaNumero(empresaCuenta, numero);
					if(numero!=null && numero.equals(new Long(100))) {
						respuesta = respCentroCostoReservado;
					} else if (nombre!=null && nombre.equalsIgnoreCase("PROFESORES")) {
						respuesta = respNombreCentroCostoReservado;
					} else if(newCentroCosto==null) {
						centroCosto.setNumero(numero);
						centroCosto.setNombre(nombre);
						ccDao.makePersistent(centroCosto);
						respuesta = respExito;
					} else {
						if (centroCosto.equals(newCentroCosto)) {
							centroCosto.setNombre(nombre);
							ccDao.makePersistent(centroCosto);
							respuesta = respExito;
						} else {
							respuesta = respExiste;
						}
					}
				} else {
					respuesta = respNoExisteCentroCosto;
				}
			} else {
				respuesta = respNoExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}	
	
	public EmpresaCuenta getLastEmpresaCuenta(Empresa empresa) {
		EmpresaCuenta empresaCuenta;
		HibernateUtil.beginTransaction();
		try {
			EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
			empresaCuenta = empresaCuentaDao.findByEmpresaLast(empresa);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return empresaCuenta;
	}
	
	public ComboBoxModel getComboBoxModelCentroCosto(EmpresaCuenta cuenta) {
		List<CentroCosto> list = new LinkedList<CentroCosto>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
			list = ccDao.findByEmpresaCuenta(cuenta);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		for (int i = 0; i < list.size(); i++) {
			model.addElement(list.get(i).getNumero());
		}
		return model;
	}
	
	/*
	public CentroCosto getCentroCosto(EmpresaCuenta cuenta, Long numero) {
		CentroCosto centroCosto;
		HibernateUtil.beginTransaction();
		try {
			CentroCostoDao ccDao = DaoFactory.getInstance().getCentroCostoDao();
			centroCosto = ccDao.findByEmpresaCuentaNumero(cuenta, numero);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return centroCosto;
	}
	*/
	
}