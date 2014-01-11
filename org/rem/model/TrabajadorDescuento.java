package org.rem.model;

import java.io.Serializable;
import org.rem.model.util.EqualsUtil;
import org.rem.model.util.HashCodeUtil;

@SuppressWarnings("serial")
public class TrabajadorDescuento implements Serializable {

	private Long idTrabajadorDescuento;

	private Double monto;

	private TrabajadorCuenta trabajadorCuenta;

	private Descuento descuento;

	public TrabajadorDescuento() {
	}

	public TrabajadorDescuento(TrabajadorDescuento trabajadorDescuento) {
		this.setMonto(trabajadorDescuento.getMonto());
		this.setDescuento(trabajadorDescuento.getDescuento());
	}

	public TrabajadorDescuento(Double monto, Descuento descuento) {
		this.setMonto(monto);
		this.setDescuento(descuento);
	}

	public Long getIdTrabajadorDescuento() {
		return idTrabajadorDescuento;
	}

	@SuppressWarnings("unused")
	private void setIdTrabajadorDescuento(Long idTrabajadorDescuento) {
		this.idTrabajadorDescuento = idTrabajadorDescuento;
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

	public Descuento getDescuento() {
		return descuento;
	}

	public void setDescuento(Descuento descuento) {
		this.descuento = descuento;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (!(obj instanceof TrabajadorDescuento))
			return false;
		TrabajadorDescuento that = (TrabajadorDescuento) obj;
		return EqualsUtil.areEqual(this.getTrabajadorCuenta(), that
				.getTrabajadorCuenta())
				&& EqualsUtil
						.areEqual(this.getDescuento(), that.getDescuento());
	}

	@Override
	public int hashCode() {
		int hashResult = HashCodeUtil.SEED;
		hashResult = HashCodeUtil.hash(hashResult, this.getTrabajadorCuenta());
		hashResult = HashCodeUtil.hash(hashResult, this.getDescuento());
		return hashResult;
	}

}