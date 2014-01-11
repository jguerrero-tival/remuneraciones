package org.rem.dao;

public abstract class DaoFactory {

	private static DaoFactory instance;

	private static final String daoFactoryClassName = "org.rem.dao.hibernate.HibernateDaoFactory";

	public static DaoFactory getInstance() {
		if (instance == null) {
			try {
				instance = (DaoFactory) Class.forName(daoFactoryClassName)
						.newInstance();
			} catch (Exception e) {
				throw new RuntimeException(
						"Could not instantiate DAO factory class ["
								+ daoFactoryClassName + "]", e);
			}
		}
		return instance;
	}

	public abstract MonedaDao getMonedaDao();
	
	public abstract DescuentoDao getDescuentoDao();
	public abstract ImponibleDao getImponibleDao();
	public abstract NoImponibleDao getNoImponibleDao();

	public abstract CajaDao getCajaDao();
	public abstract IsapreDao getIsapreDao();
	public abstract MutualDao getMutualDao();
	public abstract AfpDao getAfpDao();

	public abstract MesDao getMesDao();
	public abstract ImpuestoDao getImpuestoDao();
	public abstract AsignacionDao getAsignacionDao();

	public abstract EmpresaDao getEmpresaDao();
	public abstract TrabajadorDao getTrabajadorDao();
	public abstract EmpresaCuentaDao getEmpresaCuentaDao();
	public abstract CentroCostoDao getCentroCostoDao();
	public abstract TrabajadorCuentaDao getTrabajadorCuentaDao();

	public abstract TrabajadorCentroCostoDao getTrabajadorCentroCostoDao();
	public abstract TrabajadorDescuentoDao getTrabajadorDescuentoDao();
	public abstract TrabajadorImponibleDao getTrabajadorImponibleDao();
	public abstract TrabajadorNoImponibleDao getTrabajadorNoImponibleDao();
	
	public abstract RegistroEmpresaDao getRegistroEmpresaDao();
	public abstract RegistroLibroDao getRegistroLibroDao();
	public abstract RegistroLiquidacionDao getRegistroLiquidacionDao();
	public abstract RegistroLiquidacionImponibleDao getRegistroLiquidacionImponibleDao();
	public abstract RegistroLiquidacionNoImponibleDao getRegistroLiquidacionNoImponibleDao();
	public abstract RegistroLiquidacionDescuentoLegalDao getRegistroLiquidacionDescuentoLegalDao();
	public abstract RegistroLiquidacionDescuentoVarioDao getRegistroLiquidacionDescuentoVarioDao();
	public abstract RegistroIsapreDao getRegistroIsapreDao();
	public abstract RegistroAfpDao getRegistroAfpDao();
	public abstract RegistroMutualDao getRegistroMutualDao();
	public abstract RegistroCajaDao getRegistroCajaDao();
	public abstract RegistroInpDao getRegistroInpDao();
	
	public abstract RegistroLibroCCDao getRegistroLibroCCDao();
	public abstract RegistroLiquidacionCCDao getRegistroLiquidacionCCDao();
	public abstract RegistroLiquidacionImponibleCCDao getRegistroLiquidacionImponibleCCDao();
	public abstract RegistroLiquidacionNoImponibleCCDao getRegistroLiquidacionNoImponibleCCDao();
	public abstract RegistroLiquidacionDescuentoLegalCCDao getRegistroLiquidacionDescuentoLegalCCDao();
	public abstract RegistroLiquidacionDescuentoVarioCCDao getRegistroLiquidacionDescuentoVarioCCDao();
	public abstract RegistroIsapreCCDao getRegistroIsapreCCDao();
	public abstract RegistroAfpCCDao getRegistroAfpCCDao();
	public abstract RegistroMutualCCDao getRegistroMutualCCDao();
	public abstract RegistroCajaCCDao getRegistroCajaCCDao();
	public abstract RegistroInpCCDao getRegistroInpCCDao();
	
}