package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class TrabajadorImponible implements Serializable {
	
	private Long idTrabajadorImponible;

	private Double monto;

	private TrabajadorCuenta trabajadorCuenta;

	private Imponible imponible;

	public TrabajadorImponible() {
	}

	public TrabajadorImponible(TrabajadorImponible trabajadorImponible) {
		this.setMonto(trabajadorImponible.getMonto());
		this.setImponible(trabajadorImponible.getImponible());
	}

	public TrabajadorImponible(Double monto, Imponible imponible) {
		this.setMonto(monto);
		this.setImponible(imponible);
	}

	public Long getIdTrabajadorImponible() {
		return idTrabajadorImponible;
	}

	@SuppressWarnings("unused")
	private void setIdTrabajadorImponible(Long idTrabajadorImponible) {
		this.idTrabajadorImponible = idTrabajadorImponible;
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

	public Imponible getImponible() {
		return imponible;
	}

	public void setImponible(Imponible imponible) {
		this.imponible = imponible;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof TrabajadorImponible))
			return false;
		TrabajadorImponible that = (TrabajadorImponible) obj;
		return EqualsUtil.areEqual(this.getTrabajadorCuenta(), that
				.getTrabajadorCuenta())
				&& EqualsUtil
						.areEqual(this.getImponible(), that.getImponible());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getTrabajadorCuenta());
		hashResult = HashCodeUtil.hash(hashResult, this.getImponible());
		return hashResult;
	}

}