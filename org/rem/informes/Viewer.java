package org.rem.informes;

import java.awt.CardLayout;
import java.awt.Dialog;
import javax.swing.JDialog;

import net.sf.jasperreports.view.JasperViewer;

public class Viewer extends JDialog {

	private static final long serialVersionUID = 174993633120990123L;

	public Viewer(Dialog owner, JasperViewer jv) {
		super(owner);
		this.setLayout(new CardLayout());
		this.add(jv);
	}
}
