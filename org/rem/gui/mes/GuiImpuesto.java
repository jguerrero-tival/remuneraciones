package org.rem.gui.mes;

import info.clearthought.layout.TableLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.util.Date;
import javax.swing.JDialog;
import org.rem.control.mes.ControlTableModelImpuesto;
import org.rem.control.mes.ControlTableModelMes;
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
public class GuiImpuesto extends JDialog {

	private ControlTableModelMes controlModelMes = new ControlTableModelMes();
	private ControlTableModelImpuesto controlModelImpuesto = new ControlTableModelImpuesto();
	private GuiImpuestoAdd guiAdd = new GuiImpuestoAdd(this);
	private GuiImpuestoUpdate guiUpdate = new GuiImpuestoUpdate(this);
	private GuiImpuestoRemove guiRemove = new GuiImpuestoRemove(this);
	private JPanel jPanelImpuesto2;
	private JPanel jPanelVariablesContent;
	private JButton jButtonRemove;
	private JButton jButtonAdd;
	private JTable jTableImpuesto;
	private JScrollPane jScrollPaneTableImpuesto;
	private JButton jButtonUpdate;
	private JPanel jPanelVariablesButton;
	private JPanel jPanelVariables2;

	private static final long serialVersionUID = 1L;

	private JPanel jPanel;

	private JPanel jPanelTable;

	private JScrollPane jScrollPaneTable;
	private JPanel jPanelVariables;
	private JPanel jPanelImpuesto;

	private JTable jTable;

	private JPanel jContentPane = null;

	/**
	 * @param owner
	 */
	public GuiImpuesto(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 300);
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
					.createTitledBorder("Impuesto �nico"));
			jContentPane.add(getJPanel(), "jPanel");
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ TableLayout.FILL }, { TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelTable(), "0,    0");
		}
		return jPanel;
	}

	private JPanel getJPanelTable() {
		if (jPanelTable == null) {
			jPanelTable = new JPanel();
			TableLayout jPanelTableLayout = new TableLayout(new double[][] {
					{ 200.0, TableLayout.FILL }, { TableLayout.FILL } });
			jPanelTableLayout.setHGap(5);
			jPanelTableLayout.setVGap(5);
			jPanelTable.setLayout(jPanelTableLayout);
			jPanelTable.add(getJPanelImpuesto(), "0, 0");
			jPanelTable.add(getJPanelVariables(), "1, 0");
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
			jTable.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent evt) {
					jTableMouseReleased(evt);
				}
			});
		}
		return jTable;
	}

	private JPanel getJPanelImpuesto() {
		if (jPanelImpuesto == null) {
			jPanelImpuesto = new JPanel();
			CardLayout jPanelImpuestoLayout = new CardLayout();
			jPanelImpuesto.setLayout(jPanelImpuestoLayout);
			jPanelImpuesto.setBorder(BorderFactory.createTitledBorder("Fecha"));
			jPanelImpuesto.add(getJPanelImpuesto2(), "jPanelImpuesto2");
		}
		return jPanelImpuesto;
	}
	
	private JPanel getJPanelVariables() {
		if (jPanelVariables == null) {
			jPanelVariables = new JPanel();
			CardLayout jPanelVariablesLayout = new CardLayout();
			jPanelVariables.setLayout(jPanelVariablesLayout);
			jPanelVariables.setBorder(BorderFactory.createTitledBorder("Tramos de Impuesto �nico"));
			jPanelVariables.add(getJPanelVariables2(), "jPanelVariables2");
		}
		return jPanelVariables;
	}
	
	private JPanel getJPanelImpuesto2() {
		if (jPanelImpuesto2 == null) {
			jPanelImpuesto2 = new JPanel();
			TableLayout jPanelImpuesto2Layout = new TableLayout(new double[][] {
					{ TableLayout.FILL }, { TableLayout.FILL } });
			jPanelImpuesto2Layout.setHGap(5);
			jPanelImpuesto2Layout.setVGap(5);
			jPanelImpuesto2.setLayout(jPanelImpuesto2Layout);
			jPanelImpuesto2.add(getJScrollPaneTable(), "0, 0");
		}
		return jPanelImpuesto2;
	}

	private JPanel getJPanelVariables2() {
		if (jPanelVariables2 == null) {
			jPanelVariables2 = new JPanel();
			TableLayout jPanelVariables2Layout = new TableLayout(
				new double[][] { { TableLayout.FILL },
						{ TableLayout.FILL, TableLayout.PREFERRED } });
			jPanelVariables2Layout.setHGap(5);
			jPanelVariables2Layout.setVGap(5);
			jPanelVariables2.setLayout(jPanelVariables2Layout);
			jPanelVariables2.add(getJPanelVariablesButton(), "0, 1");
			jPanelVariables2.add(getJPanelVariablesContent(), "0, 0");
		}
		return jPanelVariables2;
	}
	
	private JPanel getJPanelVariablesButton() {
		if (jPanelVariablesButton == null) {
			jPanelVariablesButton = new JPanel();
			jPanelVariablesButton.add(getJButtonAdd());
			jPanelVariablesButton.add(getJButtonUpdate());
			jPanelVariablesButton.add(getJButtonRemove());
		}
		return jPanelVariablesButton;
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
	
	private JPanel getJPanelVariablesContent() {
		if (jPanelVariablesContent == null) {
			jPanelVariablesContent = new JPanel();
			TableLayout jPanelVariablesContentLayout = new TableLayout(
				new double[][] { { TableLayout.FILL }, { TableLayout.FILL } });
			jPanelVariablesContentLayout.setHGap(5);
			jPanelVariablesContentLayout.setVGap(5);
			jPanelVariablesContent.setLayout(jPanelVariablesContentLayout);
			jPanelVariablesContent.add(getJScrollPaneTableImpuesto(), "0, 0");
		}
		return jPanelVariablesContent;
	}
	
	private JScrollPane getJScrollPaneTableImpuesto() {
		if (jScrollPaneTableImpuesto == null) {
			jScrollPaneTableImpuesto = new JScrollPane();
			jScrollPaneTableImpuesto.setViewportView(getJTableImpuesto());
		}
		return jScrollPaneTableImpuesto;
	}
	
	private JTable getJTableImpuesto() {
		if (jTableImpuesto == null) {
			jTableImpuesto = new JTable();
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jTableImpuesto;
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

	private void jButtonAddActionPerformed(ActionEvent evt) {
		this.guiAdd.actualizar(((TableModelMes) jTable.getModel()).getObject(jTable.getSelectedRow()).getFecha());
		this.guiAdd.setVisible(true);
		this.actualizarDatos();
	}
	
	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		this.guiUpdate.actualizar(((TableModelMes) jTable.getModel()).getObject(jTable.getSelectedRow()).getFecha());
		this.guiUpdate.setVisible(true);
		this.actualizarDatos();
	}

	private void jButtonRemoveActionPerformed(ActionEvent evt) {
		this.guiRemove.actualizar(((TableModelMes) jTable.getModel()).getObject(jTable.getSelectedRow()).getFecha());
		this.guiRemove.setVisible(true);
		this.actualizarDatos();
	}

	
	private void jTableMouseReleased(MouseEvent evt) {
		this.actualizarDatos();
	}
	
	private void actualizarDatos() {
		if (jTable.getSelectedRow()!=-1) {
			Date fecha = ((TableModelMes) jTable.getModel()).getObject(jTable.getSelectedRow()).getFecha();
			this.jTableImpuesto.setModel(controlModelImpuesto.getTableModelImpuesto(fecha));
			this.jButtonAdd.setEnabled(true);
			this.jButtonUpdate.setEnabled(true);
			this.jButtonRemove.setEnabled(true);
		} else {
			this.jTableImpuesto.setModel(new TableModelImpuesto());
			this.jButtonAdd.setEnabled(false);
			this.jButtonUpdate.setEnabled(false);
			this.jButtonRemove.setEnabled(false);
		}
	}
	
	public void actualizar() {
		this.jTable.setModel(controlModelMes.getTableModelMes());
		this.actualizarDatos();
	}
	
}