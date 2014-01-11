package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Color;

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
public class GuiTrabajadorCuenta extends JPanel {

	private static final long serialVersionUID = 1L;

	private JScrollPane jScrollPaneTable;
	public JButton jButtonUpdate;
	public JButton jButtonWork;
	public JButton jButtonRemove;
	public JButton jButtonAdd;
	public JTable jTable;
	private JPanel jPanelButton;
	private JPanel jPanelTrabajadorCuenta;

	/**
	 * This is the default constructor
	 */
	public GuiTrabajadorCuenta() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 200);
		this.setPreferredSize(new Dimension(500, 200));
		CardLayout thisLayout = new CardLayout();
		this.setLayout(thisLayout);
		this.setBorder(BorderFactory.createTitledBorder(null, "Cuentas de los Trabajadores",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		{
			jPanelTrabajadorCuenta = new JPanel();
			TableLayout jPanelTrabajadorCuentaLayout = new TableLayout(
				new double[][] {
						{ TableLayout.FILL, TableLayout.FILL, TableLayout.FILL,
								TableLayout.PREFERRED }, { TableLayout.FILL } });
			jPanelTrabajadorCuentaLayout.setHGap(5);
			jPanelTrabajadorCuentaLayout.setVGap(5);
			jPanelTrabajadorCuenta.setLayout(jPanelTrabajadorCuentaLayout);
			this.add(jPanelTrabajadorCuenta, "jPanelTrabajadorCuenta");
			{
				jPanelButton = new JPanel();
				TableLayout jPanelButtonLayout = new TableLayout(
					new double[][] {
							{ TableLayout.FILL },
							{ TableLayout.FILL, TableLayout.PREFERRED,
									TableLayout.PREFERRED,
									TableLayout.PREFERRED,
									TableLayout.PREFERRED, TableLayout.FILL } });
				jPanelButtonLayout.setHGap(5);
				jPanelButtonLayout.setVGap(5);
				jPanelButton.setLayout(jPanelButtonLayout);
				jPanelTrabajadorCuenta.add(jPanelButton, "3, 0");
				jPanelButton.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
				{
					jButtonAdd = new JButton();
					jPanelButton.add(jButtonAdd, "0, 1");
					jButtonAdd.setText("Agregar");
				}
				{
					jButtonRemove = new JButton();
					jPanelButton.add(jButtonRemove, "0, 2");
					jButtonRemove.setText("Eliminar");
				}
				{
					jButtonWork = new JButton();
					jPanelButton.add(jButtonWork, "0, 4");
					jButtonWork.setText("Trabajar");
				}
				{
					jButtonUpdate = new JButton();
					jPanelButton.add(jButtonUpdate, "0, 3");
					jButtonUpdate.setText("Modificar");
				}
			}
			{
				jScrollPaneTable = new JScrollPane();
				jPanelTrabajadorCuenta.add(jScrollPaneTable, "0, 0, 2, 0");
				{
					jTable = new JTable();
					jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					jScrollPaneTable.setViewportView(jTable);
				}
			}
		}

	}

}