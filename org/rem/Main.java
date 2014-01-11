package org.rem;

import javax.swing.SwingUtilities;
import org.rem.gui.Gui;
import org.rem.util.InitDataBase;

public class Main {

	public static void main(String[] args) {
		InitDataBase.initDataBase();
		System.out.println("OK");
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Gui application = new Gui();
				application.setVisible(true);
			}
		});
	}

}
