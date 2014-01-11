package org.rem.gui.empresa;

import java.util.LinkedList;
import javax.swing.ListModel;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;

import org.rem.model.Empresa;

public class ListModelEmpresa implements ListModel {
	
	private LinkedList<Empresa> data = new LinkedList<Empresa>();

	private LinkedList<ListDataListener> listeners = new LinkedList<ListDataListener>();

	public String getElementAt(int index) {
		return data.get(index).getRutEmpresa();
	}
	
	public Empresa getEmpresaAt(int index) {
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
	
	public void addObject(Empresa object) {
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