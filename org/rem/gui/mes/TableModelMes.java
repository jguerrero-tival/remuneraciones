package org.rem.gui.mes;

import java.util.LinkedList;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import org.rem.model.Mes;
import org.rem.util.Fecha;

public class TableModelMes implements TableModel {

	private LinkedList<Mes> data = new LinkedList<Mes>();

	private LinkedList<TableModelListener> listeners = new LinkedList<TableModelListener>();

	private String[] columnNames = new String[] { "AÑO", "MES" };

	private Class[] columnClass = new Class[] { Long.class, String.class };

	public int getColumnCount() {
		return columnNames.length;
	}

	public int getRowCount() {
		return data.size();
	}

	public Object getValueAt(int rowIndex, int columnIndex) {
		Mes object = data.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return Fecha.getYear(object.getFecha());
		case 1:
			return Fecha.getMonthString(object.getFecha());
		default:
			return null;
		}
	}

	public Mes getObject(int rowIndex) {
		return data.get(rowIndex);
	}

	public void removeObject(int rowIndex) {
		data.remove(rowIndex);
		TableModelEvent event = new TableModelEvent(this, rowIndex, rowIndex,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.DELETE);
		avisaSuscriptores(event);
	}

	public void addObject(Mes object) {
		data.add(object);
		TableModelEvent event = new TableModelEvent(this,
				this.getRowCount() - 1, this.getRowCount() - 1,
				TableModelEvent.ALL_COLUMNS, TableModelEvent.INSERT);
		avisaSuscriptores(event);
	}

	public void addTableModelListener(TableModelListener l) {
		listeners.add(l);
	}

	@SuppressWarnings("unchecked")
	public Class getColumnClass(int columnIndex) {
		if (columnIndex < this.getColumnCount()) {
			return columnClass[columnIndex];
		}
		return Object.class;
	}

	public String getColumnName(int columnIndex) {
		if (columnIndex < this.getColumnCount()) {
			return columnNames[columnIndex];
		}
		return null;
	}

	public boolean isCellEditable(int rowIndex, int columnIndex) {
		return false;
	}

	public void removeTableModelListener(TableModelListener l) {
		listeners.remove(l);
	}

	public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
		switch (columnIndex) {
		case 0:
			break;
		case 1:
			break;
		default:
			break;
		}
		TableModelEvent evento = new TableModelEvent(this, rowIndex, rowIndex,
				columnIndex);
		avisaSuscriptores(evento);
	}

	private void avisaSuscriptores(TableModelEvent event) {
		for (int i = 0; i < listeners.size(); i++)
			((TableModelListener) listeners.get(i)).tableChanged(event);
	}

}