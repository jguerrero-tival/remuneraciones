package org.rem.informes;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

public class ViewerReport extends JasperViewer {

	private static final long serialVersionUID = 1L;

	public ViewerReport(JasperPrint print) {
		super(print, false);
		this.setExtendedState(JasperViewer.MAXIMIZED_BOTH);
		this.setDefaultCloseOperation(JasperViewer.DISPOSE_ON_CLOSE);
		this.setVisible(true);
		
	}
}
