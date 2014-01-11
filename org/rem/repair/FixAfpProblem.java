package org.rem.repair;

import java.util.List;

import org.rem.control.institucion.ControlAfp;
import org.rem.dao.DaoFactory;
import org.rem.dao.EmpresaCuentaDao;
import org.rem.dao.TrabajadorCuentaDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Afp;
import org.rem.model.EmpresaCuenta;
import org.rem.model.TrabajadorCuenta;
import org.rem.util.Fecha;

/**
 * 
 * @author Coke This class if for repair inconsistences in database. The repair
 *         consist in update the Afp for each TrabajadorCuenta assign the Afp of
 *         the corresponding Mes of the EmpresaCuenta
 */
public class FixAfpProblem {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.err.println(	"\n******************************"+
							"\n*** ANTES DE REPARAR *********"+
							"\n******************************");
		new FixAfpProblem().printErrors();
/*
		new FixAfpProblem().repair();
		System.err.println(	"\n******************************"+
							"\n*** DESPUES DE REPARAR *******"+
							"\n******************************");
		new FixAfpProblem().printErrors();
*/
	}

	private void printErrors() {
		HibernateUtil.beginTransaction();
		try {
			EmpresaCuentaDao dao = DaoFactory.getInstance().getEmpresaCuentaDao();
			List<EmpresaCuenta> list = dao.findAll();
			for (int i = 0; i < list.size(); i++) {
				TrabajadorCuentaDao trabDao = DaoFactory.getInstance().getTrabajadorCuentaDao();
				List<TrabajadorCuenta> listTra = trabDao.findByEmpresaCuenta(list.get(i));
				for (int j=0; j<listTra.size(); j++) {
					Afp afp = listTra.get(j).getAfp();
					if(afp!=null){
						if (!list.get(i).getMes().equals(afp.getMes())) {
							System.err.println("Problema en: "+
									Fecha.fechaTexto(list.get(i).getMes().getFecha())+"  -  "+
									list.get(i).getEmpresa().getRutEmpresa()+"  -  "+
									listTra.get(j).getTrabajador().getDatosPersonales().getRut());
						}
					}

				}
			}
			// HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}		
	}

	private void repair() {
		HibernateUtil.beginTransaction();
		try {
			EmpresaCuentaDao dao = DaoFactory.getInstance()
					.getEmpresaCuentaDao();
			List<EmpresaCuenta> list = dao.findAll();
			for (int i = 0; i < list.size(); i++) {
				ControlAfp.reassignAfpToTrabajadorCuenta(list.get(i));
			}
			// HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

}