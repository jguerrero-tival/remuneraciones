package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class TrabajadorNoImponible implements Serializable {

	private Long idTrabajadorNoImponible;

	private Double monto;

	private TrabajadorCuenta trabajadorCuenta;

	private NoImponible noImponible;

	public TrabajadorNoImponible() {
	}

	public TrabajadorNoImponible(TrabajadorNoImponible trabajadorNoImponible) {
		this.setMonto(trabajadorNoImponible.getMonto());
		this.setNoImponible(trabajadorNoImponible.getNoImponible());
	}

	public TrabajadorNoImponible(Double monto, NoImponible noImponible) {
		this.setMonto(monto);
		this.setNoImponible(noImponible);
	}

	public Long getIdTrabajadorNoImponible() {
		return idTrabajadorNoImponible;
	}

	@SuppressWarnings("unused")
	private void setIdTrabajadorNoImponible(Long idTrabajadorNoImponible) {
		this.idTrabajadorNoImponible = idTrabajadorNoImponible;
	}

	public Double getMonto() {
		return monto;
	}

	public void setMonto(Double monto) {
		this.monto = monto;
	}

	public TrabajadorCuenta getTrabajadorCuenta() {
		return trabajadorCuenta;
	}

	public void setTrabajadorCuenta(TrabajadorCuenta trabajadorCuenta) {
		this.trabajadorCuenta = trabajadorCuenta;
	}

	public NoImponible getNoImponible() {
		return noImponible;
	}

	public void setNoImponible(NoImponible noImponible) {
		this.noImponible = noImponible;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof TrabajadorNoImponible))
			return false;
		TrabajadorNoImponible that = (TrabajadorNoImponible) obj;
		return EqualsUtil.areEqual(this.getTrabajadorCuenta(), that
				.getTrabajadorCuenta())
				&& EqualsUtil
						.areEqual(this.getNoImponible(), that.getNoImponible());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getTrabajadorCuenta());
		hashResult = HashCodeUtil.hash(hashResult, this.getNoImponible());
		return hashResult;
	}

}