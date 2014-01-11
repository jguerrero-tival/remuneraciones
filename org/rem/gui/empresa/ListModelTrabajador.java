package org.rem.gui.empresa;

import java.util.LinkedList;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import org.rem.model.Trabajador;

public class ListModelTrabajador implements ListModel {
	
	private LinkedList<Trabajador> data = new LinkedList<Trabajador>();

	private LinkedList<ListDataListener> listeners = new LinkedList<ListDataListener>();

	public String getElementAt(int index) {
		return data.get(index).getDatosPersonales().getRut();
	}
	
	public Trabajador getTrabajadorAt(int index) {
		return data.get(index);
	}
	
	public int getSize() {
		return data.size();
	}
	
	public void addListDataListener(ListDataListener l) {
		listeners.add(l);
	}
	
	public void removeListDataListener(ListDataListener l) {
		listeners.remove(l);
	}
	
	private void warnListeners(ListDataEvent event) {
		for (int i = 0; i < listeners.size(); i++)
			((ListDataListener) listeners.get(i)).contentsChanged(event);
	}
	
	public void addObject(Trabajador object) {
		data.add(object);
		ListDataEvent event = new ListDataEvent(this, ListDataEvent.INTERVAL_ADDED, this.getSize()-1, this.getSize()-1);
		this.warnListeners(event);
	}
	
	public void removeObject(int index) {
		data.remove(index);
		ListDataEvent event = new ListDataEvent(this, ListDataEvent.INTERVAL_REMOVED, index, index);
		this.warnListeners(event);
	}
	
}