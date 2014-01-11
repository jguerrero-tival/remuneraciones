package org.rem.control.empresa;

import java.util.LinkedList;
import java.util.List;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;

import org.rem.dao.AfpDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaCuentaDao;
import org.rem.dao.TrabajadorCuentaDao;
import org.rem.dao.TrabajadorDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Afp;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Isapre;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;

public class ControlTrabajadorCuenta {

	public int respExito = 0;

	public int respCerrada = 1;

	public int respExiste = 2;

	public int respNoExiste = 3;

	public int respNoExisteTrabajador = 4;

	public int respCuentaEmpresaCerrada = 5;

	public int respNoExisteEmpresaCuenta = 6;

	public int respUsandoCentroCosto = 7;

	public int addTrabajadorCuenta(EmpresaCuenta empresaCuenta,
			Trabajador trabajador, String trato, String formaPago,
			String tipoContrato, Boolean seguroCesantia, Afp afp, Afp afp2,
			String tipoAhorroVoluntario, Double valorAhorroVoluntario,
			String tipoSalud, Isapre isapre, String tipoPactoIsapre,
			Double valorPactoIsapre, Boolean cargas, Double sueldoPromedio,
			Long numeroCargasNormal, Long numeroCargasInvalida) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresaCuenta != null) {
				// empresa cuenta existe
				if (trabajador != null) {
					// trabajador existe
					EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
					empresaCuenta = empresaCuentaDao.findByEmpresaMes(empresaCuenta.getEmpresa(), empresaCuenta.getMes());
					if (!empresaCuenta.isCerrada()) {
						// si la cuenta de la empresa no está cerrada
						TrabajadorDao trabajadorDao = DaoFactory.getInstance().getTrabajadorDao();
						trabajador = trabajadorDao.findByEmpresaRutTrabajador(trabajador.getEmpresa(), trabajador.getDatosPersonales().getRut());
						TrabajadorCuentaDao trabajadorCuentaDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
						if (!trabajadorCuentaDao.existe(trabajador, empresaCuenta).booleanValue()) {
							// si la cuenta del trabajador no existe
							
							//START NEW
							AfpDao afpDao = DaoFactory.getInstance().getAfpDao();
							if (afp!=null) {
								afp = afpDao.findByMesNombre(empresaCuenta.getMes(), afp.getNombre());
							} 
							if (afp2!=null) {
								afp2 = afpDao.findByMesNombre(empresaCuenta.getMes(), afp2.getNombre());
							}
							//END NEW

							TrabajadorCuenta trabajadorCuenta = new TrabajadorCuenta(
									trato, formaPago, tipoContrato, seguroCesantia, afp, afp2,
									tipoAhorroVoluntario, valorAhorroVoluntario, tipoSalud, 
									isapre, tipoPactoIsapre, valorPactoIsapre, cargas, 
									sueldoPromedio,	numeroCargasNormal, numeroCargasInvalida);
							//trabajadorCuenta.setEmpresaCuenta(empresaCuenta);
							//trabajadorCuenta.setTrabajador(trabajador);
							//trabajadorCuentaDao.makePersistent(trabajadorCuenta);
							trabajador.addCuenta(trabajadorCuenta);
							empresaCuenta.addTrabajadorCuenta(trabajadorCuenta);
							empresaCuentaDao.makePersistent(empresaCuenta);
							trabajadorDao.makePersistent(trabajador);
							
							respuesta = respExito;
						} else {
							// si la cuenta de la empresa existe
							respuesta = respExiste;
						}
					} else {
						// si la cuenta de la empresa está cerrada
						respuesta = respCuentaEmpresaCerrada;
					}
				} else {
					// trabajador no existe
					respuesta = respNoExisteTrabajador;
				}
			} else {
				// empresa cuenta no existe
				respuesta = respNoExisteEmpresaCuenta;
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	public int removeTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (trabajadorCuenta!= null) {
				// trabajdor cuenta existe
				TrabajadorCuentaDao trabajadorCuentaDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
				TrabajadorCuenta cuenta = trabajadorCuentaDao.findByTrabajadorEmpresaCuenta(trabajadorCuenta.getTrabajador(), trabajadorCuenta.getEmpresaCuenta());
				if (cuenta!=null) {
					// si la cuenta del trabajador existe
					trabajadorCuentaDao.makeTransient(cuenta);
					respuesta = respExito;
				} else {
					// si la cuenta de la empresa no existe
					respuesta = respNoExiste;
				}
			} else {
				// trabajador cuenta no existe
				respuesta = respNoExiste;
			}
			HibernateUtil.commitTransaction();
		} finally {
		HibernateUtil.closeSession();
		}
		return respuesta;
	}

	public int updateTrabajadorCuenta(EmpresaCuenta empresaCuenta, 
			Trabajador trabajador, String trato, String formaPago,
			String tipoContrato, Boolean seguroCesantia, Afp afp, Afp afp2,
			String tipoAhorroVoluntario, Double valorAhorroVoluntario,
			String tipoSalud, Isapre isapre, String tipoPactoIsapre,
			Double valorPactoIsapre, Boolean cargas, Double sueldoPromedio,
			Long numeroCargasNormal, Long numeroCargasInvalida) {
		int respuesta;
		HibernateUtil.beginTransaction();
		try {
			if (empresaCuenta != null) {
				// empresa cuenta existe
				if (trabajador != null) {
					// trabajador existe
					EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
					empresaCuenta = empresaCuentaDao.findByEmpresaMes(empresaCuenta.getEmpresa(), empresaCuenta.getMes());
					if (!empresaCuenta.isCerrada()) {
						// si la cuenta de la empresa no está cerrada
						TrabajadorDao trabajadorDao = DaoFactory.getInstance().getTrabajadorDao();
						trabajador = trabajadorDao.findByEmpresaRutTrabajador(trabajador.getEmpresa(), trabajador.getDatosPersonales().getRut());
						TrabajadorCuentaDao trabajadorCuentaDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
						if (trabajadorCuentaDao.existe(trabajador, empresaCuenta).booleanValue()) {
							// si la cuenta de la empresa existe
							TrabajadorCuenta trabajadorCuenta = trabajadorCuentaDao.findByTrabajadorEmpresaCuenta(trabajador, empresaCuenta);
							trabajadorCuenta.setTrato(trato);
							trabajadorCuenta.setFormaPago(formaPago);
							trabajadorCuenta.setTipoContrato(tipoContrato);
							trabajadorCuenta.setSeguroCesantia(seguroCesantia);
							trabajadorCuenta.setAfp(afp);
							trabajadorCuenta.setAfp2(afp2);							
							trabajadorCuenta.setTipoAhorroVoluntario(tipoAhorroVoluntario);
							trabajadorCuenta.setValorAhorroVoluntario(valorAhorroVoluntario);
							trabajadorCuenta.setTipoSalud(tipoSalud);
							trabajadorCuenta.setIsapre(isapre);
							trabajadorCuenta.setTipoPactoIsapre(tipoPactoIsapre);
							trabajadorCuenta.setValorPactoIsapre(valorPactoIsapre);
							trabajadorCuenta.setCargas(cargas);
							trabajadorCuenta.setSueldoPromedio(sueldoPromedio);
							trabajadorCuenta.setNumeroCargasNormal(numeroCargasNormal);
							trabajadorCuenta.setNumeroCargasInvalida(numeroCargasInvalida);
							trabajadorCuentaDao.makePersistent(trabajadorCuenta);
							respuesta = respExito;
						} else {
							// si la cuenta de la empresa no existe
							respuesta = respNoExiste;
						}
					} else {
						// si la cuenta de la empresa está cerrada
						respuesta = respCuentaEmpresaCerrada;
					}
				} else {
					// trabajador no existe
					respuesta = respNoExisteTrabajador;
				}
			} else {
				// empresa cuenta no existe
				respuesta = respNoExisteEmpresaCuenta;
			}
			HibernateUtil.commitTransaction();
		} finally {
		HibernateUtil.closeSession();
		}
		return respuesta;
	}
	
	public ComboBoxModel getComboBoxModelTrabajdorSinCuenta(EmpresaCuenta empresaCuenta) {
		List<Trabajador> list = new LinkedList<Trabajador>();
		//List<TrabajadorCuenta> listCuenta = new LinkedList<TrabajadorCuenta>();
		DefaultComboBoxModel model = new DefaultComboBoxModel();
		HibernateUtil.beginTransaction();
		try {
			TrabajadorDao trabajadorDao = DaoFactory.getInstance().getTrabajadorDao();
			TrabajadorCuentaDao trabajadorCuentaDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
			EmpresaCuentaDao empresaCuentaDao = DaoFactory.getInstance().getEmpresaCuentaDao();
			if (empresaCuenta!=null) {
				empresaCuenta = empresaCuentaDao.findByEmpresaMes(empresaCuenta.getEmpresa(), empresaCuenta.getMes());
				list = trabajadorDao.findByEmpresaNoBloqueado(empresaCuenta.getEmpresa());
				for (int i = 0; i < list.size(); i++) {
					if(trabajadorCuentaDao.findByTrabajadorEmpresaCuenta(list.get(i), empresaCuenta)==null) {
						model.addElement(list.get(i).getDatosPersonales().getRut());
					}
				}
				HibernateUtil.commitTransaction();
			}
		} finally {
			HibernateUtil.closeSession();
		}
		return model;
	}

	public TrabajadorCuenta getLastTrabajadorCuenta(EmpresaCuenta empresaCuenta, String rutTrabajador) {
		TrabajadorCuenta lastCuenta = null;
		HibernateUtil.beginTransaction();
		try {
			HibernateUtil.commitTransaction();
			TrabajadorDao trabajadorDao = DaoFactory.getInstance().getTrabajadorDao();
			Trabajador trabajador = trabajadorDao.findByEmpresaRutTrabajador(empresaCuenta.getEmpresa(), rutTrabajador);
			TrabajadorCuentaDao cuentaDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
			lastCuenta = cuentaDao.findByTrabajadorLast(trabajador);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return lastCuenta;
	}
	
	public TrabajadorCuenta getTrabajadorCuenta(EmpresaCuenta empresaCuenta, Trabajador trabajador) {
		TrabajadorCuenta trabajadorCuenta = null;
		HibernateUtil.beginTransaction();
		try {
			HibernateUtil.commitTransaction();
			TrabajadorCuentaDao cuentaDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
			trabajadorCuenta = cuentaDao.findByTrabajadorEmpresaCuenta(trabajador, empresaCuenta);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		return trabajadorCuenta;
	}
	
}