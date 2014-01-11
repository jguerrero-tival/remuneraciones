package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class TrabajadorCentroCosto implements Serializable {

	private Long idTrabajadorCentroCosto;

	private Double monto;
	
	private Long horas;

	private Double diasTrabajados;

	private Long horasExtraordinarias;

	private TrabajadorCuenta trabajadorCuenta;

	private CentroCosto centroCosto;

	public TrabajadorCentroCosto() {
	}

	public TrabajadorCentroCosto(TrabajadorCentroCosto trabajadorCentroCosto) {
		this.setMonto(trabajadorCentroCosto.getMonto());
		this.setHoras(trabajadorCentroCosto.getHoras());
		this.setDiasTrabajados(trabajadorCentroCosto.getDiasTrabajados());
		this.setHorasExtraordinarias(trabajadorCentroCosto.getHorasExtraordinarias());
		this.setCentroCosto(trabajadorCentroCosto.getCentroCosto());
	}

	public TrabajadorCentroCosto(Double monto, Long horas, Double diasTrabajados,
			Long horasExtraordinarias, CentroCosto centroCosto) {
		this.setMonto(monto);
		this.setHoras(horas);
		this.setDiasTrabajados(diasTrabajados);
		this.setHorasExtraordinarias(horasExtraordinarias);
		this.setCentroCosto(centroCosto);
	}

	public Long getIdTrabajadorCentroCosto() {
		return idTrabajadorCentroCosto;
	}

	@SuppressWarnings("unused")
	private void setIdTrabajadorCentroCosto(Long idTrabajadorCentroCosto) {
		this.idTrabajadorCentroCosto = idTrabajadorCentroCosto;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}
	
	public Long getHoras() {
		return horas;
	}

	public void setHoras(Long horas) {
		this.horas = horas;
	}

	public Double getDiasTrabajados() {
		return diasTrabajados;
	}

	public void setDiasTrabajados(Double diasTrabajados) {
		this.diasTrabajados = diasTrabajados;
	}

	public Long getHorasExtraordinarias() {
		return horasExtraordinarias;
	}

	public void setHorasExtraordinarias(Long horasExtraordinarias) {
		this.horasExtraordinarias = horasExtraordinarias;
	}

	public TrabajadorCuenta getTrabajadorCuenta() {
		return trabajadorCuenta;
	}

	public void setTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		this.trabajadorCuenta = trabajadorCuenta;
	}

	public CentroCosto getCentroCosto() {
		return centroCosto;
	}

	public void setCentroCosto(CentroCosto centroCosto) {
		this.centroCosto = centroCosto;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof TrabajadorCentroCosto))
			return false;
		TrabajadorCentroCosto that = (TrabajadorCentroCosto) obj;
		return EqualsUtil.areEqual(this.getTrabajadorCuenta(), that
				.getTrabajadorCuenta())
				&& EqualsUtil.areEqual(this.getCentroCosto(), that
						.getCentroCosto());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getTrabajadorCuenta());
		hashResult = HashCodeUtil.hash(hashResult, this.getCentroCosto());
		return hashResult;
	}

}