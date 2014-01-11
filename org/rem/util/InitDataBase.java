package org.rem.util;

import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.rem.dao.AfpDao;
import org.rem.dao.CajaDao;
import org.rem.dao.DaoFactory;
import org.rem.dao.DescuentoDao;
import org.rem.dao.ImponibleDao;
import org.rem.dao.IsapreDao;
import org.rem.dao.MesDao;
import org.rem.dao.MonedaDao;
import org.rem.dao.MutualDao;
import org.rem.dao.NoImponibleDao;
import org.rem.dao.hibernate.HibernateUtil;
import org.rem.model.Afp;
import org.rem.model.Asignacion;
import org.rem.model.Caja;
import org.rem.model.Descuento;
import org.rem.model.Imponible;
import org.rem.model.Impuesto;
import org.rem.model.Isapre;
import org.rem.model.Mes;
import org.rem.model.Moneda;
import org.rem.model.Mutual;
import org.rem.model.NoImponible;

public class InitDataBase {

	public static void initDataBase() {
		HibernateUtil.beginTransaction();
		Mes mes;
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			mes = mesDao.findByLastMes();
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
		if(mes==null) {
			Date fecha = Fecha.createDate(2006, 8, 1);
		
			initMoneda();/* Moneda */

			initDescuento();/* Descuento */
			initImponible();/* Imponible */
			initNoImponible();/* NoImponible */
		
			initCaja();/* Caja */
			initIsapre();/* Isapre */
			initMutual();/* Mutual */

			initMes(fecha);/* Mes */
			initImpuesto(fecha);/* Impuesto */
			initAsignacion(fecha);/* Asignacion */
			initAfp(fecha);/* Afp */
		}
	}

	private static void initMoneda() {
		List<Moneda> list = new LinkedList<Moneda>();
		/* monedas fijas */
		Boolean fijo = new Boolean(true);
		list.add(new Moneda(fijo, new Double(1.0), Palabra.monedaMoneda));
		/* monedas no fijas */
		list.add(new Moneda(new Double(5.0), Palabra.monedaMoneda));
		list.add(new Moneda(new Double(10.0), Palabra.monedaMoneda));
		list.add(new Moneda(new Double(50.0), Palabra.monedaMoneda));
		list.add(new Moneda(new Double(100.0), Palabra.monedaMoneda));
		list.add(new Moneda(new Double(500.0), Palabra.monedaMoneda));
		list.add(new Moneda(new Double(1000.0), Palabra.monedaBillete));
		list.add(new Moneda(new Double(2000.0), Palabra.monedaBillete));
		list.add(new Moneda(new Double(5000.0), Palabra.monedaBillete));
		list.add(new Moneda(new Double(10000.0), Palabra.monedaBillete));
		list.add(new Moneda(new Double(20000.0), Palabra.monedaBillete));

		HibernateUtil.beginTransaction();
		try {
			MonedaDao monedaDao = DaoFactory.getInstance().getMonedaDao();
			for (int i = 0; i < list.size(); i++) {
				monedaDao.makePersistent(list.get(i));
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	private static void initDescuento() {
		List<Descuento> list = new LinkedList<Descuento>();
		/* descuentos fijos */
		Boolean fijo = new Boolean(true);
		list.add(new Descuento(fijo, Palabra.descuentoAnticipo));
		/* descuentos no fijos */
		list.add(new Descuento("BIENESTAR"));
		list.add(new Descuento("CONVENIO DENTAL"));
		list.add(new Descuento("PRESTAMOS CAJA DE COMPENSACION"));
		list.add(new Descuento("PRESTAMOS FONASA"));
		list.add(new Descuento("INASISTENCIA"));
		list.add(new Descuento("RETENCION JUDICIAL"));
		list.add(new Descuento("CUOTA SINDICAL"));
		list.add(new Descuento("ANTICIPOS COLECTIVOS"));
		list.add(new Descuento("INASISTENCIA CONSEJO"));

		HibernateUtil.beginTransaction();
		try {
			DescuentoDao descDao = DaoFactory.getInstance().getDescuentoDao();
			for (int i = 0; i < list.size(); i++) {
				descDao.makePersistent(list.get(i));
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	private static void initImponible() {
		List<Imponible> list = new LinkedList<Imponible>();
		/* imponibles fijos */
		Boolean fijo = new Boolean(true);
		list.add(new Imponible(fijo, Palabra.imponibleSueldoBase));
		list.add(new Imponible(fijo, Palabra.imponibleHorasExtraordinarias));
		/* imponibles no fijos */
		list.add(new Imponible("BONOS"));
		list.add(new Imponible("TRATOS"));
		list.add(new Imponible("UMP"));
		list.add(new Imponible("TALLER"));
		list.add(new Imponible("DECRETO 683"));
		list.add(new Imponible("LEY 19464"));
		list.add(new Imponible("ETEA"));
		list.add(new Imponible("EXCELENCIA DOCENTE"));
		list.add(new Imponible("DECRETO 131"));
		list.add(new Imponible("UMP ADULTO"));
		list.add(new Imponible("BONIFICACION PROPORCIONAL ADULTO"));
		list.add(new Imponible("LEY 19504 ADULTO"));
		list.add(new Imponible("JEFATURA DE CURSO"));

		HibernateUtil.beginTransaction();
		try {
			ImponibleDao impDao = DaoFactory.getInstance().getImponibleDao();
			for (int i = 0; i < list.size(); i++) {
				impDao.makePersistent(list.get(i));
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	private static void initNoImponible() {
		List<NoImponible> list = new LinkedList<NoImponible>();
		/* no imponibles fijos */
		Boolean fijo = new Boolean(true);
		list.add(new NoImponible(fijo, Palabra.noImponibleColacion));
		list.add(new NoImponible(fijo, Palabra.noImponibleMovilizacion));
		list.add(new NoImponible(fijo, Palabra.noImponibleCargaRetroactiva));
		/* no imponibles no fijos */
		list.add(new NoImponible("VIATICO"));
		list.add(new NoImponible("DESGASTE DE HERRAMIENTAS"));
		list.add(new NoImponible("ASIGNACION DE CAJA"));

		HibernateUtil.beginTransaction();
		try {
			NoImponibleDao noImpDao = DaoFactory.getInstance()
					.getNoImponibleDao();
			for (int i = 0; i < list.size(); i++) {
				noImpDao.makePersistent(list.get(i));
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	private static void initCaja() {
		List<Caja> list = new LinkedList<Caja>();
		list.add(new Caja("LA ARAUCANA"));
		list.add(new Caja("GABRIELA MISTRAL"));
		list.add(new Caja("LOS ANDES"));
		list.add(new Caja("LOS HEROES"));
		list.add(new Caja("JAVIERA CARRERA"));
		list.add(new Caja("18 DE SEPTIEMBRE"));
		
		HibernateUtil.beginTransaction();
		try {
			CajaDao cajaDao = DaoFactory.getInstance().getCajaDao();
			for (int i=0; i<list.size(); i++) {
				cajaDao.makePersistent(list.get(i));	
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	private static void initIsapre() {
		List<Isapre> list = new LinkedList<Isapre>();
		list.add(new Isapre("BANMEDICA"));
		list.add(new Isapre("ING SALUD"));
		list.add(new Isapre("VIDAPLENA"));
		list.add(new Isapre("VIDATRES"));
		list.add(new Isapre("COLMENA GOLDEN CROS"));
		list.add(new Isapre("INP EMPART"));
		list.add(new Isapre("INP SEGURO SOCIAL"));

		HibernateUtil.beginTransaction();
		try {
			IsapreDao isapreDao = DaoFactory.getInstance().getIsapreDao();
			for (int i=0; i<list.size(); i++) {
				isapreDao.makePersistent(list.get(i));	
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

	private static void initMutual() {
		List<Mutual> list = new LinkedList<Mutual>();
		list.add(new Mutual("MUTUAL1"));
		list.add(new Mutual("MUTUAL2"));

		HibernateUtil.beginTransaction();
		try {
			MutualDao mutualDao = DaoFactory.getInstance().getMutualDao();
			for (int i=0; i<list.size(); i++) {
				mutualDao.makePersistent(list.get(i));	
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	private static void initMes(Date fecha) {
		Mes mes = new Mes(
				fecha, 
				new Double(135500), new Double(18336.04), new Double(32046.00),
				new Double(60.00), new Double(50.00), new Double(0.0),
				new Double(0.95),
				new Double(7.00), new Double(60.00),
				new Double(0.60), new Double(90.00),
				new Double(25.00), new Double(4.75));

		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			mesDao.makePersistent(mes);
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	private static void initImpuesto(Date fecha) {
		Mes mes = null;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				/* impuestos casi fijos */
				Boolean casiFijo = new Boolean(true);
				mes.addImpuesto(new Impuesto(casiFijo, new Double(0.00), new Double(0.00), new Double(0.00)));
				/* impuestos no casi fijos */
				mes.addImpuesto(new Impuesto(new Double( 13.50), new Double(0.05), new Double( 0.675)));
				mes.addImpuesto(new Impuesto(new Double( 30.00), new Double(0.10), new Double( 2.175)));
				mes.addImpuesto(new Impuesto(new Double( 50.00), new Double(0.15), new Double( 4.675)));
				mes.addImpuesto(new Impuesto(new Double( 70.00), new Double(0.25), new Double(11.675)));
				mes.addImpuesto(new Impuesto(new Double( 90.00), new Double(0.32), new Double(17.975)));
				mes.addImpuesto(new Impuesto(new Double(120.00), new Double(0.37), new Double(23.975)));
				mes.addImpuesto(new Impuesto(new Double(150.00), new Double(0.40), new Double(28.475)));		
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	private static void initAsignacion(Date fecha) {
		Mes mes = null;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				/* asignaciones casi fijas */
				Boolean casiFijo = new Boolean(true);
				mes.addAsignacion(new Asignacion(casiFijo, new Double(0), new Double(4126)));
				/* asignaciones no casi fijas */
				mes.addAsignacion(new Asignacion(new Double(128445), new Double(4014)));
				mes.addAsignacion(new Asignacion(new Double(251585), new Double(1307)));
				mes.addAsignacion(new Asignacion(new Double(392387), new Double(   0)));
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}
	
	private static void initAfp(Date fecha) {
		Mes mes = null;
		HibernateUtil.beginTransaction();
		try {
			MesDao mesDao = DaoFactory.getInstance().getMesDao();
			mes = mesDao.findByFecha(fecha);
			if (mes!=null) {
				mes.addAfp(new Afp("S:S:S:",		Palabra.regimenAntiguo, new Double(25.84)));
				mes.addAfp(new Afp("EMPART", 		Palabra.regimenAntiguo, new Double(28.84)));
				mes.addAfp(new Afp("BANSANDER", 	Palabra.regimenNuevo, new Double(12.42)));
				mes.addAfp(new Afp("CUPRUM", 		Palabra.regimenNuevo, new Double(12.48)));
				mes.addAfp(new Afp("HABITAT", 		Palabra.regimenNuevo, new Double(12.23)));
				mes.addAfp(new Afp("PLANVITAL", 	Palabra.regimenNuevo, new Double(12.55)));
				mes.addAfp(new Afp("PROVIDA", 		Palabra.regimenNuevo, new Double(12.25)));
				mes.addAfp(new Afp("SANTA MARIA",	Palabra.regimenNuevo, new Double(12.29)));
			}
			HibernateUtil.commitTransaction();
		} finally {
			HibernateUtil.closeSession();
		}
	}

}