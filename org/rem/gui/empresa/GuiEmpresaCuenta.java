package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.BevelBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
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
public class GuiEmpresaCuenta extends JPanel {

	private static final long serialVersionUID = 1L;

	private JScrollPane jScrollPaneTable;
	private JLabel jLabelGratificacion;
	private JPanel jPanelVariablesContent;
	public JButton jButtonInformes;
	public JTable jTableCentroCosto;
	public JButton jButtonUpdateCentroCosto;
	public JButton jButtonRemoveCentroCosto;
	private JLabel jLabelMutual;
	private JScrollPane jScrollPaneTableCentroCosto;
	public JButton jButtonAddCentroCosto;
	private JPanel jPanelButtonCentroCosto;
	private JPanel jPanelCentroCosto2;
	private JPanel jPanelCentroCosto;
	public JTextField jTextFieldMutual;
	public JTextField jTextFieldCaja;
	public JTextField jTextFieldGratificacion;
	public JTextField jTextFieldMutualCotizacionAdicional;
	private JLabel jLabelMutualCotizacionAdicional;
	private JLabel jLabelCaja;
	private JPanel jPanelVariables2;
	private JPanel jPanelVariables;
	public JButton jButtonLock;
	public JButton jButtonUpdate;
	public JButton jButtonRemove;
	public JButton jButtonAdd;
	public JTable jTable;
	private JPanel jPanelButton;
	private JPanel jPanelEmpresaCuenta;

	/**
	 * This is the default constructor
	 */
	public GuiEmpresaCuenta() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 330);
		this.setPreferredSize(new Dimension(500, 330));
		CardLayout thisLayout = new CardLayout();
		this.setLayout(thisLayout);
		this.setBorder(BorderFactory.createTitledBorder(null, "Cuentas de la Empresa",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		{
			jPanelEmpresaCuenta = new JPanel();
			TableLayout jPanelEmpresaCuentaLayout = new TableLayout(
				new double[][] {
						{ TableLayout.FILL, TableLayout.FILL, TableLayout.FILL,
								TableLayout.PREFERRED },
						{ TableLayout.MINIMUM, TableLayout.MINIMUM } });
			jPanelEmpresaCuentaLayout.setHGap(5);
			jPanelEmpresaCuentaLayout.setVGap(5);
			jPanelEmpresaCuenta.setLayout(jPanelEmpresaCuentaLayout);
			this.add(jPanelEmpresaCuenta, "jPanelEmpresaCuenta");
			{
				jPanelButton = new JPanel();
				TableLayout jPanelButtonLayout = new TableLayout(
					new double[][] {
							{ TableLayout.FILL },
							{ TableLayout.FILL, TableLayout.PREFERRED,
									TableLayout.PREFERRED,
									TableLayout.PREFERRED,
									TableLayout.PREFERRED,
									TableLayout.PREFERRED, TableLayout.FILL } });
				jPanelButtonLayout.setHGap(5);
				jPanelButtonLayout.setVGap(5);
				jPanelButton.setLayout(jPanelButtonLayout);
				jPanelEmpresaCuenta.add(jPanelButton, "3, 0");
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
					jButtonUpdate = new JButton();
					jPanelButton.add(jButtonUpdate, "0, 3");
					jButtonUpdate.setText("Modificar");
				}
				{
					jButtonLock = new JButton();
					jPanelButton.add(jButtonLock, "0, 4");
					jButtonLock.setText("Bloquear");
				}
				{
					jButtonInformes = new JButton();
					jPanelButton.add(jButtonInformes, "0, 5");
					jButtonInformes.setText("Informes");
				}
			}
			{
				jScrollPaneTable = new JScrollPane();
				jPanelEmpresaCuenta.add(jScrollPaneTable, "0, 0, 2, 0");
				{
					jTable = new JTable();
					jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
					jScrollPaneTable.setViewportView(jTable);
				}
			}
			{
				jPanelVariables = new JPanel();
				jPanelEmpresaCuenta.add(jPanelVariables, "0, 1, 1, 1");
				CardLayout jPanelVariablesLayout = new CardLayout();
				jPanelVariables.setBorder(BorderFactory
					.createTitledBorder("Variables"));
				jPanelVariables.setLayout(jPanelVariablesLayout);
				{
					jPanelVariables2 = new JPanel();
					CardLayout jPanelVariables2Layout = new CardLayout();
					jPanelVariables.add(jPanelVariables2, "jPanelVariables2");
					jPanelVariables2.setLayout(jPanelVariables2Layout);
					{
						jPanelVariablesContent = new JPanel();
						TableLayout jPanelVariablesContentLayout = new TableLayout(
							new double[][] {
									{ TableLayout.PREFERRED, TableLayout.FILL },
									{ TableLayout.PREFERRED,
											TableLayout.PREFERRED,
											TableLayout.PREFERRED,
											TableLayout.PREFERRED } });
						jPanelVariablesContentLayout.setHGap(5);
						jPanelVariablesContentLayout.setVGap(5);
						jPanelVariables2.add(jPanelVariablesContent, "0, 0");
						jPanelVariablesContent.setLayout(jPanelVariablesContentLayout);
						{
							jLabelGratificacion = new JLabel();
							jPanelVariablesContent.add(
								jLabelGratificacion,
								"0,    0");
							jLabelGratificacion.setText("Gratificación : ");
						}
						{
							jLabelCaja = new JLabel();
							jPanelVariablesContent.add(jLabelCaja, "0, 2");
							jLabelCaja.setText("Caja de Compensación : ");
						}
						{
							jLabelMutual = new JLabel();
							jPanelVariablesContent.add(jLabelMutual, "0, 1");
							jLabelMutual.setText("Mutual de Seguridad : ");
						}
						{
							jLabelMutualCotizacionAdicional = new JLabel();
							jPanelVariablesContent.add(jLabelMutualCotizacionAdicional, "0, 3");
							jLabelMutualCotizacionAdicional
								.setText("Cotización Adicional Mutual (%) : ");
						}
						{
							jTextFieldMutualCotizacionAdicional = new JTextField();
							jPanelVariablesContent.add(jTextFieldMutualCotizacionAdicional, "1, 3");
							jTextFieldMutualCotizacionAdicional.setEditable(false);
						}
						{
							jTextFieldGratificacion = new JTextField();
							jPanelVariablesContent.add(
								jTextFieldGratificacion,
								"1,    0");
							jTextFieldGratificacion.setEditable(false);
						}
						{
							jTextFieldCaja = new JTextField();
							jPanelVariablesContent.add(jTextFieldCaja, "1, 2");
							jTextFieldCaja.setEditable(false);
						}
						{
							jTextFieldMutual = new JTextField();
							jPanelVariablesContent.add(jTextFieldMutual, "1, 1");
							jTextFieldMutual.setEditable(false);
						}
					}
				}
			}
			{
				jPanelCentroCosto = new JPanel();
				CardLayout jPanelCentroCostoLayout = new CardLayout();
				jPanelCentroCosto.setLayout(jPanelCentroCostoLayout);
				jPanelEmpresaCuenta.add(jPanelCentroCosto, "2, 1, 3, 1");
				jPanelCentroCosto.setBorder(BorderFactory.createTitledBorder("Centros de Costo"));
				{
					jPanelCentroCosto2 = new JPanel();
					jPanelCentroCosto.add(jPanelCentroCosto2, "jPanelCentroCosto2");
					TableLayout jPanelCentroCosto2Layout = new TableLayout(
						new double[][] {
								{ TableLayout.FILL, TableLayout.PREFERRED },
								{ TableLayout.FILL } });
					jPanelCentroCosto2Layout.setHGap(5);
					jPanelCentroCosto2Layout.setVGap(5);
					jPanelCentroCosto2.setLayout(jPanelCentroCosto2Layout);
					{
						jScrollPaneTableCentroCosto = new JScrollPane();
						jPanelCentroCosto2.add(
							jScrollPaneTableCentroCosto,
							"0, 0");
						{
						jTableCentroCosto = new JTable();
							jScrollPaneTableCentroCosto.setViewportView(jTableCentroCosto);
							jTableCentroCosto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
						}
					}
					{
						jPanelButtonCentroCosto = new JPanel();
						TableLayout jPanelButtonCentroCostoLayout = new TableLayout(
							new double[][] {
									{ TableLayout.FILL },
									{ TableLayout.FILL, TableLayout.PREFERRED,
											TableLayout.PREFERRED,
											TableLayout.PREFERRED,
											TableLayout.FILL } });
						jPanelButtonCentroCostoLayout.setHGap(5);
						jPanelButtonCentroCostoLayout.setVGap(5);
						jPanelButtonCentroCosto.setLayout(jPanelButtonCentroCostoLayout);
						jPanelCentroCosto2.add(jPanelButtonCentroCosto, "1, 0");
						jPanelButtonCentroCosto.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
						{
							jButtonAddCentroCosto = new JButton();
							jPanelButtonCentroCosto.add(jButtonAddCentroCosto, "0, 1");
							jButtonAddCentroCosto.setText("Agregar");
						}
						{
							jButtonRemoveCentroCosto = new JButton();
							jPanelButtonCentroCosto.add(jButtonRemoveCentroCosto, "0, 2");
							jButtonRemoveCentroCosto.setText("Eliminar");
						}
						{
							jButtonUpdateCentroCosto = new JButton();
							jPanelButtonCentroCosto.add(jButtonUpdateCentroCosto, "0, 3");
							jButtonUpdateCentroCosto.setText("Modificar");
						}
					}
				}
			}
		}

	}

}