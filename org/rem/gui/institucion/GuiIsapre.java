package org.rem.gui.institucion;

import info.clearthought.layout.TableLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JDialog;
import org.rem.control.institucion.ControlTableModelIsapre;
import org.rem.util.Pantalla;

/**
 * This code was edited or generated using CloudGarden's Jigloo SWT/Swing GUI
 * Builder, which is free for non-commercial use. If Jigloo is being used
 * commercially (ie, by a corporation, company or business for any purpose
 * whatever) then you should purchase a license for each developer using Jigloo.
 * Please visit www.cloudgarden.com for details. Use of Jigloo implies
 * acceptance of these licensing terms. A COMMERCIAL LICENSE HAS NOT BEEN
 * PURCHASED FOR THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED LEGALLY FOR
 * ANY CORPORATE OR COMMERCIAL PURPOSE.
 */
public class GuiIsapre extends JDialog {

	private ControlTableModelIsapre control = new ControlTableModelIsapre();

	private GuiIsapreAdd guiAdd = new GuiIsapreAdd(this);

	private GuiIsapreRemove guiRemove = new GuiIsapreRemove(this);

	private GuiIsapreUpdate guiUpdate = new GuiIsapreUpdate(this);

	private static final long serialVersionUID = 1L;

	private JPanel jPanel;

	private JPanel jPanelTable;

	private JScrollPane jScrollPaneTable;

	private JButton jButtonUpdate;

	private JButton jButtonRemove;

	private JButton jButtonAdd;

	private JPanel jPanelButton;

	private JTable jTable;

	private JPanel jContentPane = null;

	/**
	 * @param owner
	 */
	public GuiIsapre(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 300);
		this.setContentPane(getJContentPane());
		this.setLocation(Pantalla.centrar(this.getSize()));
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		this.actualizar();
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			CardLayout jContentPaneLayout = new CardLayout();
			jContentPane.setLayout(jContentPaneLayout);
			jContentPane.setEnabled(false);
			jContentPane.setBorder(BorderFactory
					.createTitledBorder("Isapre"));
			jContentPane.add(getJPanel(), "jPanel");
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ TableLayout.FILL },
					{ TableLayout.FILL, TableLayout.PREFERRED } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelTable(), "0,    0");
			jPanel.add(getJPanelButton(), "0,    1");
		}
		return jPanel;
	}

	private JPanel getJPanelTable() {
		if (jPanelTable == null) {
			jPanelTable = new JPanel();
			CardLayout jPanelTableLayout = new CardLayout();
			jPanelTable.setLayout(jPanelTableLayout);
			jPanelTable.add(getJScrollPaneTable(), "jScrollPaneTable");
		}
		return jPanelTable;
	}

	private JScrollPane getJScrollPaneTable() {
		if (jScrollPaneTable == null) {
			jScrollPaneTable = new JScrollPane();
			jScrollPaneTable.setViewportView(getJTable());
		}
		return jScrollPaneTable;
	}

	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jTable;
	}

	private JPanel getJPanelButton() {
		if (jPanelButton == null) {
			jPanelButton = new JPanel();
			jPanelButton.add(getJButtonAdd());
			jPanelButton.add(getJButtonRemove());
			jPanelButton.add(getJButtonUpdate());
		}
		return jPanelButton;
	}

	private JButton getJButtonAdd() {
		if (jButtonAdd == null) {
			jButtonAdd = new JButton();
			jButtonAdd.setText("Agregar");
			jButtonAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonAddActionPerformed(evt);
				}
			});
		}
		return jButtonAdd;
	}

	private JButton getJButtonRemove() {
		if (jButtonRemove == null) {
			jButtonRemove = new JButton();
			jButtonRemove.setText("Eliminar");
			jButtonRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonRemoveActionPerformed(evt);
				}
			});
		}
		return jButtonRemove;
	}

	private JButton getJButtonUpdate() {
		if (jButtonUpdate == null) {
			jButtonUpdate = new JButton();
			jButtonUpdate.setText("Modificar");
			jButtonUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonUpdateActionPerformed(evt);
				}
			});
		}
		return jButtonUpdate;
	}

	private void actualizar() {
		this.jTable.setModel(control.getTableModelIsapre());
	}

	private void jButtonAddActionPerformed(ActionEvent evt) {
		this.guiAdd.actualizar();
		this.guiAdd.setVisible(true);
		this.actualizar();
	}

	private void jButtonRemoveActionPerformed(ActionEvent evt) {
		this.guiRemove.actualizar();
		this.guiRemove.setVisible(true);
		this.actualizar();
	}

	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		this.guiUpdate.actualizar();
		this.guiUpdate.setVisible(true);
		this.actualizar();
	}
	
}