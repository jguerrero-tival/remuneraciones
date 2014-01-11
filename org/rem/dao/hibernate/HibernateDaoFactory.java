package org.rem.dao.hibernate;

import org.hibernate.Session;
import org.rem.dao.*;

public class HibernateDaoFactory extends DaoFactory {

	@Override
	public MonedaDao getMonedaDao() {
		return new MonedaHibernateDao().setSession(getCurrentSession());
	}
	@Override
	public DescuentoDao getDescuentoDao() {
		return new DescuentoHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public ImponibleDao getImponibleDao() {
		return new ImponibleHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public NoImponibleDao getNoImponibleDao() {
		return new NoImponibleHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public CajaDao getCajaDao() {
		return new CajaHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public IsapreDao getIsapreDao() {
		return new IsapreHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public MutualDao getMutualDao() {
		return new MutualHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public AfpDao getAfpDao() {
		return new AfpHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public MesDao getMesDao() {
		return new MesHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public ImpuestoDao getImpuestoDao() {
		return new ImpuestoHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public AsignacionDao getAsignacionDao() {
		return new AsignacionHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public EmpresaDao getEmpresaDao() {
		return new EmpresaHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public TrabajadorDao getTrabajadorDao() {
		return new TrabajadorHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public EmpresaCuentaDao getEmpresaCuentaDao() {
		return new EmpresaCuentaHibernateDao().setSession(getCurrentSession());
	}
	
	@Override
	public CentroCostoDao getCentroCostoDao() {
		return new CentroCostoHibernateDao().setSession(getCurrentSession());
	}

	@Override
	public TrabajadorCuentaDao getTrabajadorCuentaDao() {
		return new TrabajadorCuentaHibernateDao()
				.setSession(getCurrentSession());
	}

	@Override
	public TrabajadorCentroCostoDao getTrabajadorCentroCostoDao() {
		return new TrabajadorCentroCostoHibernateDao()
				.setSession(getCurrentSession());
	}

	@Override
	public TrabajadorDescuentoDao getTrabajadorDescuentoDao() {
		return new TrabajadorDescuentoHibernateDao()
				.setSession(getCurrentSession());
	}

	@Override
	public TrabajadorImponibleDao getTrabajadorImponibleDao() {
		return new TrabajadorImponibleHibernateDao()
				.setSession(getCurrentSession());
	}

	@Override
	public TrabajadorNoImponibleDao getTrabajadorNoImponibleDao() {
		return new TrabajadorNoImponibleHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroEmpresaDao getRegistroEmpresaDao() {
		return new RegistroEmpresaHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLibroDao getRegistroLibroDao() {
		return new RegistroLibroHibernateDao()
				.setSession(getCurrentSession());
	}	
	
	@Override
	public RegistroLiquidacionDao getRegistroLiquidacionDao() {
		return new RegistroLiquidacionHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLiquidacionImponibleDao getRegistroLiquidacionImponibleDao() {
		return new RegistroLiquidacionImponibleHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLiquidacionNoImponibleDao getRegistroLiquidacionNoImponibleDao() {
		return new RegistroLiquidacionNoImponibleHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLiquidacionDescuentoLegalDao getRegistroLiquidacionDescuentoLegalDao() {
		return new RegistroLiquidacionDescuentoLegalHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLiquidacionDescuentoVarioDao getRegistroLiquidacionDescuentoVarioDao() {
		return new RegistroLiquidacionDescuentoVarioHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroIsapreDao getRegistroIsapreDao() {
		return new RegistroIsapreHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroAfpDao getRegistroAfpDao() {
		return new RegistroAfpHibernateDao()
				.setSession(getCurrentSession());
	}

	@Override
	public RegistroMutualDao getRegistroMutualDao() {
		return new RegistroMutualHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroCajaDao getRegistroCajaDao() {
		return new RegistroCajaHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroInpDao getRegistroInpDao() {
		return new RegistroInpHibernateDao()
				.setSession(getCurrentSession());
	}
	
	
	
	@Override
	public RegistroLibroCCDao getRegistroLibroCCDao() {
		return new RegistroLibroCCHibernateDao()
				.setSession(getCurrentSession());
	}	
	
	@Override
	public RegistroLiquidacionCCDao getRegistroLiquidacionCCDao() {
		return new RegistroLiquidacionCCHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLiquidacionImponibleCCDao getRegistroLiquidacionImponibleCCDao() {
		return new RegistroLiquidacionImponibleCCHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLiquidacionNoImponibleCCDao getRegistroLiquidacionNoImponibleCCDao() {
		return new RegistroLiquidacionNoImponibleCCHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLiquidacionDescuentoLegalCCDao getRegistroLiquidacionDescuentoLegalCCDao() {
		return new RegistroLiquidacionDescuentoLegalCCHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroLiquidacionDescuentoVarioCCDao getRegistroLiquidacionDescuentoVarioCCDao() {
		return new RegistroLiquidacionDescuentoVarioCCHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroIsapreCCDao getRegistroIsapreCCDao() {
		return new RegistroIsapreCCHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroAfpCCDao getRegistroAfpCCDao() {
		return new RegistroAfpCCHibernateDao()
				.setSession(getCurrentSession());
	}

	@Override
	public RegistroMutualCCDao getRegistroMutualCCDao() {
		return new RegistroMutualCCHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroCajaCCDao getRegistroCajaCCDao() {
		return new RegistroCajaCCHibernateDao()
				.setSession(getCurrentSession());
	}
	
	@Override
	public RegistroInpCCDao getRegistroInpCCDao() {
		return new RegistroInpCCHibernateDao()
				.setSession(getCurrentSession());
	}
	

	public Session getCurrentSession() {
		return HibernateUtil.currentSession();
	}

}