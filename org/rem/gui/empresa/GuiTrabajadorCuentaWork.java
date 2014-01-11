
/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/

/**
* This code was edited or generated using CloudGarden's Jigloo
* SWT/Swing GUI Builder, which is free for non-commercial
* use. If Jigloo is being used commercially (ie, by a corporation,
* company or business for any purpose whatever) then you
* should purchase a license for each developer using Jigloo.
* Please visit www.cloudgarden.com for details.
* Use of Jigloo implies acceptance of these licensing terms.
* A COMMERCIAL LICENSE HAS NOT BEEN PURCHASED FOR
* THIS MACHINE, SO JIGLOO OR THIS CODE CANNOT BE USED
* LEGALLY FOR ANY CORPORATE OR COMMERCIAL PURPOSE.
*/
package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import org.rem.control.empresa.ControlTableModelTrabajadorCentroCosto;
import org.rem.control.empresa.ControlTableModelTrabajadorDescuento;
import org.rem.control.empresa.ControlTableModelTrabajadorImponible;
import org.rem.control.empresa.ControlTableModelTrabajadorNoImponible;
import org.rem.control.empresa.ControlTrabajadorCuenta;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Trabajador;
import org.rem.model.TrabajadorCuenta;
import org.rem.util.Fecha;
import org.rem.util.Formato;
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

@SuppressWarnings("serial")
public class GuiTrabajadorCuentaWork extends JDialog {

	private GuiTrabajadorCentroCostoAdd guiCentroCostoAdd = new GuiTrabajadorCentroCostoAdd(this);
	private GuiTrabajadorImponibleAdd guiImponibleAdd = new GuiTrabajadorImponibleAdd(this);
	private GuiTrabajadorNoImponibleAdd guiNoImponibleAdd = new GuiTrabajadorNoImponibleAdd(this);
	private GuiTrabajadorDescuentoAdd guiDescuentoAdd = new GuiTrabajadorDescuentoAdd(this);
	
	private GuiTrabajadorCentroCostoRemove guiCentroCostoRemove = new GuiTrabajadorCentroCostoRemove(this);
	private GuiTrabajadorDescuentoRemove guiDescuentoRemove = new GuiTrabajadorDescuentoRemove(this);
	private GuiTrabajadorImponibleRemove guiImponibleRemove = new GuiTrabajadorImponibleRemove(this);
	private GuiTrabajadorNoImponibleRemove guiNoImponibleRemove = new GuiTrabajadorNoImponibleRemove(this);
	
	private GuiTrabajadorCentroCostoUpdate guiCentroCostoUpdate = new GuiTrabajadorCentroCostoUpdate(this);
	private GuiTrabajadorDescuentoUpdate guiDescuentoUpdate = new GuiTrabajadorDescuentoUpdate(this);
	private GuiTrabajadorImponibleUpdate guiImponibleUpdate = new GuiTrabajadorImponibleUpdate(this);
	private GuiTrabajadorNoImponibleUpdate guiNoImponibleUpdate = new GuiTrabajadorNoImponibleUpdate(this);
	
	private TrabajadorCuenta trabajadorCuenta;
	private ControlTrabajadorCuenta controlTrabajadorCuenta = new ControlTrabajadorCuenta();
	private ControlTableModelTrabajadorCentroCosto controlModelCentroCosto = new ControlTableModelTrabajadorCentroCosto();
	private ControlTableModelTrabajadorDescuento controlModelDescuento= new ControlTableModelTrabajadorDescuento();
	private ControlTableModelTrabajadorImponible controlModelImponible = new ControlTableModelTrabajadorImponible();
	private ControlTableModelTrabajadorNoImponible controlModelNoImponible = new ControlTableModelTrabajadorNoImponible();
	
	private JButton jButtonNoImponibleRemove;
	private JTextField jTextFieldRutTrabajador;
	private JButton jButtonDescuentoUpdate;
	private JButton jButtonDescuentoRemove;
	private JButton jButtonDesceuntoAdd;
	private JButton jButtonNoImponibleUpdate;
	private JButton jButtonNoImponibleAdd;
	private JButton jButtonImponibleUpdate;
	private JButton jButtonImponibleRemove;
	private JButton jButtonImponibleAdd;
	private JButton jButtonCentroCostoUpdate;
	private JButton jButtonCentroCostoRemove;
	private JButton jButtonCentroCostoAdd;
	private JTextField jTextFieldSexo;
	private JTextField jTextFieldAPaterno;
	private JPanel jPanelButtonDescuento;
	private JPanel jPanelButtonNoImponible;
	private JPanel jPanelButtonImponible;
	private JPanel jPanelButtonCentroCosto;
	private JTable jTableCentroCosto;
	private JTable jTableImponible;
	private JTable jTableNoImponible;
	private JTable jTableDescuento;
	private JScrollPane jScrollPaneDescuento;
	private JScrollPane jScrollPaneNoImponible;
	private JScrollPane jScrollPaneImponible;
	private JScrollPane jScrollPaneCentroCosto;
	private JPanel jPanelDescuentos2;
	private JPanel jPanelNoImponibles2;
	private JPanel jPanelImponibles2;
	private JPanel jPanelCentroCosto2;
	private JPanel jPanelDescuentos;
	private JPanel jPanelNoImponibles;
	private JPanel jPanelImponibles;
	private JPanel jPanelCentroCosto;
	private JPanel jPanelTable;
	private JLabel jLabelSexo;
	private JTextField jTextFieldAMaterno;
	private JLabel jLabelAMaterno;
	private JLabel jLabelAPaterno;
	private JTextField jTextFieldNombres;
	private JLabel jLabelNombres;
	private JLabel jLabelRutTrabajador;
	private JPanel jPanelTrabajador2;
	private JPanel jPanelTrabajador;
	private JPanel jPanelEmpresa;
	private JLabel jLabelFecha;
	private JPanel jPanelFecha2;
	private JPanel jPanelFecha;
	private JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JPanel jPanelEmpresa2;
	private JPanel jContentPane = null;
	private JPanel jPanel;

	/**
	 * This is the default constructor
	 */
	public GuiTrabajadorCuentaWork(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700,560);
		this.setContentPane(getJContentPane());
		this.setLocation(Pantalla.centrar(this.getSize()));
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.setBorder(BorderFactory
					.createTitledBorder("Agregar Cuenta de Trabajador"));
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ 10.0, 23.0, 200.0, TableLayout.FILL, 10.0 },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelEmpresa(), "1, 1, 2, 1");
			jPanel.add(getJPanelFecha(), "1, 0, 2, 0");
			jPanel.add(getJPanelTrabajador(), "1, 2, 2, 2");
			jPanel.add(getJPanelTable(), "3, 0, 3, 3");
		}
		return jPanel;
	}

	private JPanel getJPanelEmpresa() {
		if (jPanelEmpresa == null) {
			jPanelEmpresa = new JPanel();
			CardLayout jPanelEmpresaLayout = new CardLayout();
			jPanelEmpresa
				.setBorder(BorderFactory.createTitledBorder("Empresa"));
			jPanelEmpresa.setLayout(jPanelEmpresaLayout);
			jPanelEmpresa.add(getJPanelEmpresa2(), "jPanelEmpresa2");
		}
		return jPanelEmpresa;
	}
	
	private JPanel getJPanelEmpresa2() {
		if (jPanelEmpresa2 == null) {
			jPanelEmpresa2 = new JPanel();
			TableLayout jPanelEmpresa2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL,
							TableLayout.PREFERRED },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelEmpresa2Layout.setHGap(5);
			jPanelEmpresa2Layout.setVGap(5);
			jPanelEmpresa2.setLayout(jPanelEmpresa2Layout);
			jPanelEmpresa2.add(getJLabelRutEmpresa(), "0,          0");
			jPanelEmpresa2.add(getJLabelRazonSocial(), "0, 1");
			jPanelEmpresa2.add(getJTextFieldRazonSocial(), "1, 1");
			jPanelEmpresa2.add(getJFormattedTextFieldRutEmpresa(), "1,          0");
		}
		return jPanelEmpresa2;
	}
	
	private JLabel getJLabelRutEmpresa() {
		if (jLabelRutEmpresa == null) {
			jLabelRutEmpresa = new JLabel();
			jLabelRutEmpresa.setText("R.U.T : ");
		}
		return jLabelRutEmpresa;
	}
	
	private JLabel getJLabelRazonSocial() {
		if (jLabelRazonSocial == null) {
			jLabelRazonSocial = new JLabel();
			jLabelRazonSocial.setText("Razón Social : ");
		}
		return jLabelRazonSocial;
	}
	
	private JTextField getJTextFieldRazonSocial() {
		if (jTextFieldRazonSocial == null) {
			jTextFieldRazonSocial = new JTextField();
			jTextFieldRazonSocial.setEditable(false);
		}
		return jTextFieldRazonSocial;
	}
	
	private JFormattedTextField getJFormattedTextFieldRutEmpresa() {
		if (jFormattedTextFieldRutEmpresa == null) {
			jFormattedTextFieldRutEmpresa = new JFormattedTextField(Formato
				.getMaskRut());
			jFormattedTextFieldRutEmpresa.setEditable(false);
		}
		return jFormattedTextFieldRutEmpresa;
	}
	
	private JPanel getJPanelFecha() {
		if (jPanelFecha == null) {
			jPanelFecha = new JPanel();
			CardLayout jPanelFechaLayout = new CardLayout();
			jPanelFecha.setLayout(jPanelFechaLayout);
			jPanelFecha.setBorder(BorderFactory.createTitledBorder("Fecha"));
			jPanelFecha.add(getJPanelFecha2(), "jPanelFecha2");
		}
		return jPanelFecha;
	}
	
	private JPanel getJPanelFecha2() {
		if (jPanelFecha2 == null) {
			jPanelFecha2 = new JPanel();
			CardLayout jPanelFecha2Layout = new CardLayout();
			jPanelFecha2.setLayout(jPanelFecha2Layout);
			jPanelFecha2.add(getJLabelFecha(), "jLabelFecha");
		}
		return jPanelFecha2;
	}
	
	private JLabel getJLabelFecha() {
		if (jLabelFecha == null) {
			jLabelFecha = new JLabel();
			jLabelFecha.setForeground(Color.RED);
			jLabelFecha.setFont(new java.awt.Font("Tahoma",1,12));
			jLabelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelFecha;
	}
	
	
	private JPanel getJPanelTrabajador() {
		if (jPanelTrabajador == null) {
			jPanelTrabajador = new JPanel();
			CardLayout jPanelTrabajadorLayout = new CardLayout();
			jPanelTrabajador.setBorder(BorderFactory.createTitledBorder(
				null,
				"Trabajador",
				TitledBorder.LEADING,
				TitledBorder.TOP));
			jPanelTrabajador.setLayout(jPanelTrabajadorLayout);
			jPanelTrabajador.add(getJPanelTrabajador2(), "jPanelTrabajador2");
		}
		return jPanelTrabajador;
	}
	
	private JPanel getJPanelTrabajador2() {
		if (jPanelTrabajador2 == null) {
			jPanelTrabajador2 = new JPanel();
			TableLayout jPanelTrabajador2Layout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.PREFERRED } });
			jPanelTrabajador2Layout.setHGap(5);
			jPanelTrabajador2Layout.setVGap(5);
			jPanelTrabajador2.setLayout(jPanelTrabajador2Layout);
			jPanelTrabajador2.add(getJLabelRutTrabajador(), "0,    0");
			jPanelTrabajador2.add(getJLabelNombres(), "0, 2");
			jPanelTrabajador2.add(getJTextFieldNombres(), "1, 2");
			jPanelTrabajador2.add(getJLabelAPaterno(), "0, 3");
			jPanelTrabajador2.add(getJTextFieldAPaterno(), "1, 3");
			jPanelTrabajador2.add(getJLabelAMaterno(), "0, 4");
			jPanelTrabajador2.add(getJTextFieldAMaterno(), "1, 4");
			jPanelTrabajador2.add(getJLabelSexo(), "0, 1");
			jPanelTrabajador2.add(getJTextFieldSexo(), "1, 1");
			jPanelTrabajador2.add(getJTextFieldRutTrabajador(), "1, 0");
		}
		return jPanelTrabajador2;
	}
	
	private JLabel getJLabelRutTrabajador() {
		if (jLabelRutTrabajador == null) {
			jLabelRutTrabajador = new JLabel();
			jLabelRutTrabajador.setText("R.U.T. : ");
		}
		return jLabelRutTrabajador;
	}
	
	private JLabel getJLabelNombres() {
		if (jLabelNombres == null) {
			jLabelNombres = new JLabel();
			jLabelNombres.setText("Nombres : ");
		}
		return jLabelNombres;
	}
	
	private JTextField getJTextFieldNombres() {
		if (jTextFieldNombres == null) {
			jTextFieldNombres = new JTextField();
			jTextFieldNombres.setEditable(false);
		}
		return jTextFieldNombres;
	}
	
	private JLabel getJLabelAPaterno() {
		if (jLabelAPaterno == null) {
			jLabelAPaterno = new JLabel();
			jLabelAPaterno.setText("A. Paterno : ");
		}
		return jLabelAPaterno;
	}
	
	private JTextField getJTextFieldAPaterno() {
		if (jTextFieldAPaterno == null) {
			jTextFieldAPaterno = new JTextField();
			jTextFieldAPaterno.setEditable(false);
		}
		return jTextFieldAPaterno;
	}
	
	private JLabel getJLabelAMaterno() {
		if (jLabelAMaterno == null) {
			jLabelAMaterno = new JLabel();
			jLabelAMaterno.setText("A. Materno : ");
		}
		return jLabelAMaterno;
	}
	
	private JTextField getJTextFieldAMaterno() {
		if (jTextFieldAMaterno == null) {
			jTextFieldAMaterno = new JTextField();
			jTextFieldAMaterno.setEditable(false);
		}
		return jTextFieldAMaterno;
	}

	private JLabel getJLabelSexo() {
		if (jLabelSexo == null) {
			jLabelSexo = new JLabel();
			jLabelSexo.setText("Sexo : ");
		}
		return jLabelSexo;
	}

	private JTextField getJTextFieldSexo() {
		if (jTextFieldSexo == null) {
			jTextFieldSexo = new JTextField();
			jTextFieldSexo.setEditable(false);
		}
		return jTextFieldSexo;
	}

	private JPanel getJPanelTable() {
		if (jPanelTable == null) {
			jPanelTable = new JPanel();
			TableLayout jPanelTableLayout = new TableLayout(new double[][] {
					{ TableLayout.FILL },
					{ TableLayout.FILL, TableLayout.FILL, TableLayout.FILL,
							TableLayout.FILL } });
			jPanelTableLayout.setHGap(5);
			jPanelTableLayout.setVGap(5);
			jPanelTable.setLayout(jPanelTableLayout);
			jPanelTable.add(getJPanelCentroCosto(), "0, 0");
			jPanelTable.add(getJPanelImponibles(), "0, 1");
			jPanelTable.add(getJPanelNoImponibles(), "0, 2");
			jPanelTable.add(getJPanelDescuentos(), "0, 3");
		}
		return jPanelTable;
	}
	
	private JPanel getJPanelCentroCosto() {
		if (jPanelCentroCosto == null) {
			jPanelCentroCosto = new JPanel();
			CardLayout jPanelCentroCostoLayout = new CardLayout();
			jPanelCentroCosto.setLayout(jPanelCentroCostoLayout);
			jPanelCentroCosto.setBorder(BorderFactory.createTitledBorder("Sueldo por Centro de Costo"));
			jPanelCentroCosto.add(getJPanelCentroCosto2(), "jPanelCentroCosto2");
		}
		return jPanelCentroCosto;
	}
	
	private JPanel getJPanelImponibles() {
		if (jPanelImponibles == null) {
			jPanelImponibles = new JPanel();
			CardLayout jPanelImponiblesLayout = new CardLayout();
			jPanelImponibles.setLayout(jPanelImponiblesLayout);
			jPanelImponibles.setBorder(BorderFactory.createTitledBorder("Otros Imponibles"));
			jPanelImponibles.add(getJPanelImponibles2(), "jPanelImponibles2");
		}
		return jPanelImponibles;
	}
	
	private JPanel getJPanelNoImponibles() {
		if (jPanelNoImponibles == null) {
			jPanelNoImponibles = new JPanel();
			CardLayout jPanelNoImponiblesLayout = new CardLayout();
			jPanelNoImponibles.setLayout(jPanelNoImponiblesLayout);
			jPanelNoImponibles.setBorder(BorderFactory.createTitledBorder("Otros No Imponibles"));
			jPanelNoImponibles.add(getJPanelNoImponibles2(), "jPanelNoImponibles2");
		}
		return jPanelNoImponibles;
	}
	
	private JPanel getJPanelDescuentos() {
		if (jPanelDescuentos == null) {
			jPanelDescuentos = new JPanel();
			CardLayout jPanelDescuentosLayout = new CardLayout();
			jPanelDescuentos.setLayout(jPanelDescuentosLayout);
			jPanelDescuentos.setBorder(BorderFactory.createTitledBorder("Descuentos"));
			jPanelDescuentos.add(getJPanelDescuentos2(), "jPanelDescuentos2");
		}
		return jPanelDescuentos;
	}
	
	private JPanel getJPanelCentroCosto2() {
		if (jPanelCentroCosto2 == null) {
			jPanelCentroCosto2 = new JPanel();
			TableLayout jPanelCentroCosto2Layout = new TableLayout(
				new double[][] { { TableLayout.FILL, TableLayout.PREFERRED },
						{ TableLayout.FILL } });
			jPanelCentroCosto2Layout.setHGap(5);
			jPanelCentroCosto2Layout.setVGap(5);
			jPanelCentroCosto2.setLayout(jPanelCentroCosto2Layout);
			jPanelCentroCosto2.add(getJScrollPaneCentroCosto(), "0, 0");
			jPanelCentroCosto2.add(getJPanelButtonCentroCosto(), "1, 0");
		}
		return jPanelCentroCosto2;
	}
	
	private JPanel getJPanelImponibles2() {
		if (jPanelImponibles2 == null) {
			jPanelImponibles2 = new JPanel();
			TableLayout jPanelImponibles2Layout = new TableLayout(
				new double[][] { { TableLayout.FILL, TableLayout.PREFERRED },
						{ TableLayout.FILL } });
			jPanelImponibles2Layout.setHGap(5);
			jPanelImponibles2Layout.setVGap(5);
			jPanelImponibles2.setLayout(jPanelImponibles2Layout);
			jPanelImponibles2.add(getJScrollPaneImponible(), "0, 0");
			jPanelImponibles2.add(getJPanelButtonImponible(), "1, 0");
		}
		return jPanelImponibles2;
	}
	
	private JPanel getJPanelNoImponibles2() {
		if (jPanelNoImponibles2 == null) {
			jPanelNoImponibles2 = new JPanel();
			TableLayout jPanelNoImponibles2Layout = new TableLayout(
				new double[][] { { TableLayout.FILL, TableLayout.PREFERRED },
						{ TableLayout.FILL } });
			jPanelNoImponibles2Layout.setHGap(5);
			jPanelNoImponibles2Layout.setVGap(5);
			jPanelNoImponibles2.setLayout(jPanelNoImponibles2Layout);
			jPanelNoImponibles2.add(getJScrollPaneNoImponible(), "0, 0");
			jPanelNoImponibles2.add(getJPanelButtonNoImponible(), "1, 0");
		}
		return jPanelNoImponibles2;
	}
	
	private JPanel getJPanelDescuentos2() {
		if (jPanelDescuentos2 == null) {
			jPanelDescuentos2 = new JPanel();
			TableLayout jPanelDescuentos2Layout = new TableLayout(
				new double[][] { { TableLayout.FILL, TableLayout.PREFERRED },
						{ TableLayout.FILL } });
			jPanelDescuentos2Layout.setHGap(5);
			jPanelDescuentos2Layout.setVGap(5);
			jPanelDescuentos2.setLayout(jPanelDescuentos2Layout);
			jPanelDescuentos2.add(getJScrollPaneDescuento(), "0, 0");
			jPanelDescuentos2.add(getJPanelButtonDescuento(), "1, 0");
		}
		return jPanelDescuentos2;
	}
	
	private JScrollPane getJScrollPaneCentroCosto() {
		if (jScrollPaneCentroCosto == null) {
			jScrollPaneCentroCosto = new JScrollPane();
			jScrollPaneCentroCosto.setViewportView(getJTableCentroCosto());
		}
		return jScrollPaneCentroCosto;
	}
	
	private JScrollPane getJScrollPaneImponible() {
		if (jScrollPaneImponible == null) {
			jScrollPaneImponible = new JScrollPane();
			jScrollPaneImponible.setViewportView(getJTableImponible());
		}
		return jScrollPaneImponible;
	}
	
	private JScrollPane getJScrollPaneNoImponible() {
		if (jScrollPaneNoImponible == null) {
			jScrollPaneNoImponible = new JScrollPane();
			jScrollPaneNoImponible.setViewportView(getJTableNoImponible());
		}
		return jScrollPaneNoImponible;
	}
	
	private JScrollPane getJScrollPaneDescuento() {
		if (jScrollPaneDescuento == null) {
			jScrollPaneDescuento = new JScrollPane();
			jScrollPaneDescuento.setViewportView(getJTableDescuento());
		}
		return jScrollPaneDescuento;
	}
	
	private JTable getJTableDescuento() {
		if (jTableDescuento == null) {
			jTableDescuento = new JTable();
			jTableDescuento.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ListSelectionModel rowSM = jTableDescuento.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jTableDescuentoValueChanged(evt);}});
		}
		return jTableDescuento;
	}
	
	private JTable getJTableNoImponible() {
		if (jTableNoImponible == null) {
			jTableNoImponible = new JTable();
			jTableNoImponible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ListSelectionModel rowSM = jTableNoImponible.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jTableNoImponibleValueChanged(evt);}});
		}
		return jTableNoImponible;
	}
	
	private JTable getJTableImponible() {
		if (jTableImponible == null) {
			jTableImponible = new JTable();
			jTableImponible.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ListSelectionModel rowSM = jTableImponible.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jTableImponibleValueChanged(evt);}});
		}
		return jTableImponible;
	}
	
	private JTable getJTableCentroCosto() {
		if (jTableCentroCosto == null) {
			jTableCentroCosto = new JTable();
			jTableCentroCosto.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			ListSelectionModel rowSM = jTableCentroCosto.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jTableCentroCostoValueChanged(evt);}});
		}
		return jTableCentroCosto;
	}
	
	private JPanel getJPanelButtonCentroCosto() {
		if (jPanelButtonCentroCosto == null) {
			jPanelButtonCentroCosto = new JPanel();
			TableLayout jPanelButtonCentroCostoLayout = new TableLayout(
				new double[][] {
						{ TableLayout.FILL },
						{ TableLayout.FILL, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.FILL } });
			jPanelButtonCentroCostoLayout.setHGap(5);
			jPanelButtonCentroCostoLayout.setVGap(5);
			jPanelButtonCentroCosto.setLayout(jPanelButtonCentroCostoLayout);
			jPanelButtonCentroCosto.add(getJButtonCentroCostoAdd(), "0, 1");
			jPanelButtonCentroCosto.add(getJButtonCentroCostoRemove(), "0, 2");
			jPanelButtonCentroCosto.add(getJButtonUpdate(), "0, 3");
		}
		return jPanelButtonCentroCosto;
	}
	
	private JPanel getJPanelButtonImponible() {
		if (jPanelButtonImponible == null) {
			jPanelButtonImponible = new JPanel();
			TableLayout jPanelButtonImponibleLayout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED },
						{ TableLayout.FILL, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.FILL } });
			jPanelButtonImponibleLayout.setHGap(5);
			jPanelButtonImponibleLayout.setVGap(5);
			jPanelButtonImponible.setLayout(jPanelButtonImponibleLayout);
			jPanelButtonImponible.add(getJButtonImponibleAdd(), "0, 1");
			jPanelButtonImponible.add(getJButtonRemove(), "0, 2");
			jPanelButtonImponible.add(getJButton1(), "0, 3");
		}
		return jPanelButtonImponible;
	}
	
	private JPanel getJPanelButtonNoImponible() {
		if (jPanelButtonNoImponible == null) {
			jPanelButtonNoImponible = new JPanel();
			TableLayout jPanelButtonNoImponibleLayout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED },
						{ TableLayout.FILL, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.FILL } });
			jPanelButtonNoImponibleLayout.setHGap(5);
			jPanelButtonNoImponibleLayout.setVGap(5);
			jPanelButtonNoImponible.setLayout(jPanelButtonNoImponibleLayout);
			jPanelButtonNoImponible.add(getJButtonNoImponibleAdd(), "0, 1");
			jPanelButtonNoImponible.add(getJButton2(), "0, 2");
			jPanelButtonNoImponible.add(getJButton3(), "0, 3");
		}
		return jPanelButtonNoImponible;
	}
	
	private JPanel getJPanelButtonDescuento() {
		if (jPanelButtonDescuento == null) {
			jPanelButtonDescuento = new JPanel();
			TableLayout jPanelButtonDescuentoLayout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED },
						{ TableLayout.FILL, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.FILL } });
			jPanelButtonDescuentoLayout.setHGap(5);
			jPanelButtonDescuentoLayout.setVGap(5);
			jPanelButtonDescuento.setLayout(jPanelButtonDescuentoLayout);
			jPanelButtonDescuento.add(getJButtonDesceuntoAdd(), "0, 1");
			jPanelButtonDescuento.add(getJButtonDescuentoRemove(), "0, 2");
			jPanelButtonDescuento.add(getJButtonDescuentoUpdate(), "0, 3");
		}
		return jPanelButtonDescuento;
	}
	
	private JButton getJButtonCentroCostoAdd() {
		if (jButtonCentroCostoAdd == null) {
			jButtonCentroCostoAdd = new JButton();
			jButtonCentroCostoAdd.setText("Agregar");
			jButtonCentroCostoAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonCentroCostoAddActionPerformed(evt);
				}
			});
		}
		return jButtonCentroCostoAdd;
	}
	
	private JButton getJButtonCentroCostoRemove() {
		if (jButtonCentroCostoRemove == null) {
			jButtonCentroCostoRemove = new JButton();
			jButtonCentroCostoRemove.setText("Eliminar");
			jButtonCentroCostoRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonCentroCostoRemoveActionPerformed(evt);
				}
			});
		}
		return jButtonCentroCostoRemove;
	}
	
	private JButton getJButtonUpdate() {
		if (jButtonCentroCostoUpdate == null) {
			jButtonCentroCostoUpdate = new JButton();
			jButtonCentroCostoUpdate.setText("Modificar");
			jButtonCentroCostoUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonCentroCostoUpdateActionPerformed(evt);
				}
			});
		}
		return jButtonCentroCostoUpdate;
	}
	
	private JButton getJButtonImponibleAdd() {
		if (jButtonImponibleAdd == null) {
			jButtonImponibleAdd = new JButton();
			jButtonImponibleAdd.setText("Agregar");
			jButtonImponibleAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonImponibleAddActionPerformed(evt);
				}
			});
		}
		return jButtonImponibleAdd;
	}
	
	private JButton getJButtonRemove() {
		if (jButtonImponibleRemove == null) {
			jButtonImponibleRemove = new JButton();
			jButtonImponibleRemove.setText("Eliminar");
			jButtonImponibleRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonImponibleRemoveActionPerformed(evt);
				}
			});
		}
		return jButtonImponibleRemove;
	}
	
	private JButton getJButton1() {
		if (jButtonImponibleUpdate == null) {
			jButtonImponibleUpdate = new JButton();
			jButtonImponibleUpdate.setText("Modificar");
			jButtonImponibleUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonImponibleUpdateActionPerformed(evt);
				}
			});
		}
		return jButtonImponibleUpdate;
	}
	
	private JButton getJButtonNoImponibleAdd() {
		if (jButtonNoImponibleAdd == null) {
			jButtonNoImponibleAdd = new JButton();
			jButtonNoImponibleAdd.setText("Agregar");
			jButtonNoImponibleAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonNoImponibleAddActionPerformed(evt);
				}
			});
		}
		return jButtonNoImponibleAdd;
	}
	
	private JButton getJButton2() {
		if (jButtonNoImponibleRemove == null) {
			jButtonNoImponibleRemove = new JButton();
			jButtonNoImponibleRemove.setText("Eliminar");
			jButtonNoImponibleRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonNoImponibleRemoveActionPerformed(evt);
				}
			});
		}
		return jButtonNoImponibleRemove;
	}
	
	private JButton getJButton3() {
		if (jButtonNoImponibleUpdate == null) {
			jButtonNoImponibleUpdate = new JButton();
			jButtonNoImponibleUpdate.setText("Modificar");
			jButtonNoImponibleUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonNoImponibleUpdateActionPerformed(evt);
				}
			});
		}
		return jButtonNoImponibleUpdate;
	}
	
	private JButton getJButtonDesceuntoAdd() {
		if (jButtonDesceuntoAdd == null) {
			jButtonDesceuntoAdd = new JButton();
			jButtonDesceuntoAdd.setText("Agregar");
			jButtonDesceuntoAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonDesceuntoAddActionPerformed(evt);
				}
			});
		}
		return jButtonDesceuntoAdd;
	}
	
	private JButton getJButtonDescuentoRemove() {
		if (jButtonDescuentoRemove == null) {
			jButtonDescuentoRemove = new JButton();
			jButtonDescuentoRemove.setText("Eliminar");
			jButtonDescuentoRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonDescuentoRemoveActionPerformed(evt);
				}
			});
		}
		return jButtonDescuentoRemove;
	}
	
	private JButton getJButtonDescuentoUpdate() {
		if (jButtonDescuentoUpdate == null) {
			jButtonDescuentoUpdate = new JButton();
			jButtonDescuentoUpdate.setText("Modificar");
			jButtonDescuentoUpdate.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonDescuentoUpdateActionPerformed(evt);
				}
			});
		}
		return jButtonDescuentoUpdate;
	}
	
	private JTextField getJTextFieldRutTrabajador() {
		if (jTextFieldRutTrabajador == null) {
			jTextFieldRutTrabajador = new JTextField();
			jTextFieldRutTrabajador.setEditable(false);
		}
		return jTextFieldRutTrabajador;
	}
	
	
	private void jButtonCentroCostoAddActionPerformed(ActionEvent evt) {
		this.guiCentroCostoAdd.actualizar(trabajadorCuenta);
		this.guiCentroCostoAdd.setVisible(true);
		this.actualizarModelo();
	}
	
	private void jButtonCentroCostoRemoveActionPerformed(ActionEvent evt) {
		int rowIndex = this.jTableCentroCosto.getSelectedRow();
		if (rowIndex!=-1) {
			this.guiCentroCostoRemove.actualizar(trabajadorCuenta,
				((TableModelTrabajadorCentroCosto)this.jTableCentroCosto.getModel()).getObject(rowIndex));
			this.guiCentroCostoRemove.setVisible(true);
			this.actualizarModelo();
		}
	}
	
	private void jButtonCentroCostoUpdateActionPerformed(ActionEvent evt) {
		int rowIndex = this.jTableCentroCosto.getSelectedRow();
		if (rowIndex!=-1) {
			this.guiCentroCostoUpdate.actualizar(trabajadorCuenta,
				((TableModelTrabajadorCentroCosto)this.jTableCentroCosto.getModel()).getObject(rowIndex));
			this.guiCentroCostoUpdate.setVisible(true);
			this.actualizarModelo();
		}
	}
	
	private void jButtonImponibleAddActionPerformed(ActionEvent evt) {
		this.guiImponibleAdd.actualizar(trabajadorCuenta);
		this.guiImponibleAdd.setVisible(true);
		this.actualizarModelo();
	}
	
	private void jButtonImponibleRemoveActionPerformed(ActionEvent evt) {
		int rowIndex = this.jTableImponible.getSelectedRow();
		if (rowIndex!=-1) {
			this.guiImponibleRemove.actualizar(trabajadorCuenta,
				((TableModelTrabajadorImponible)this.jTableImponible.getModel()).getObject(rowIndex));
			this.guiImponibleRemove.setVisible(true);
			this.actualizarModelo();
		}
	}
	
	private void jButtonImponibleUpdateActionPerformed(ActionEvent evt) {
		int rowIndex = this.jTableImponible.getSelectedRow();
		if (rowIndex!=-1) {
			this.guiImponibleUpdate.actualizar(trabajadorCuenta,
				((TableModelTrabajadorImponible)this.jTableImponible.getModel()).getObject(rowIndex));
			this.guiImponibleUpdate.setVisible(true);
			this.actualizarModelo();
		}
	}
	
	private void jButtonNoImponibleAddActionPerformed(ActionEvent evt) {
		this.guiNoImponibleAdd.actualizar(trabajadorCuenta);
		this.guiNoImponibleAdd.setVisible(true);
		this.actualizarModelo();
	}
	
	private void jButtonNoImponibleRemoveActionPerformed(ActionEvent evt) {
		int rowIndex = this.jTableNoImponible.getSelectedRow();
		if (rowIndex!=-1) {
			this.guiNoImponibleRemove.actualizar(trabajadorCuenta,
				((TableModelTrabajadorNoImponible)this.jTableNoImponible.getModel()).getObject(rowIndex));
			this.guiNoImponibleRemove.setVisible(true);
			this.actualizarModelo();
		}	
	}
	
	private void jButtonNoImponibleUpdateActionPerformed(ActionEvent evt) {
		int rowIndex = this.jTableNoImponible.getSelectedRow();
		if (rowIndex!=-1) {
			this.guiNoImponibleUpdate.actualizar(trabajadorCuenta,
				((TableModelTrabajadorNoImponible)this.jTableNoImponible.getModel()).getObject(rowIndex));
			this.guiNoImponibleUpdate.setVisible(true);
			this.actualizarModelo();
		}
	}
	
	private void jButtonDesceuntoAddActionPerformed(ActionEvent evt) {
		this.guiDescuentoAdd.actualizar(trabajadorCuenta);
		this.guiDescuentoAdd.setVisible(true);
		this.actualizarModelo();
	}
	
	private void jButtonDescuentoRemoveActionPerformed(ActionEvent evt) {
		int rowIndex = this.jTableDescuento.getSelectedRow();
		if (rowIndex!=-1) {
			this.guiDescuentoRemove.actualizar(trabajadorCuenta,
				((TableModelTrabajadorDescuento)this.jTableDescuento.getModel()).getObject(rowIndex));
			this.guiDescuentoRemove.setVisible(true);
			this.actualizarModelo();
		}
	}
	
	private void jButtonDescuentoUpdateActionPerformed(ActionEvent evt) {
		int rowIndex = this.jTableDescuento.getSelectedRow();
		if (rowIndex!=-1) {
			this.guiDescuentoUpdate.actualizar(trabajadorCuenta,
				((TableModelTrabajadorDescuento)this.jTableDescuento.getModel()).getObject(rowIndex));
			this.guiDescuentoUpdate.setVisible(true);
			this.actualizarModelo();
		}
	}
	
	private void jTableCentroCostoValueChanged(ListSelectionEvent evt) {
		this.actualizarBotones();
	}
	private void jTableDescuentoValueChanged(ListSelectionEvent evt) {
		this.actualizarBotones();
	}
	private void jTableImponibleValueChanged(ListSelectionEvent evt) {
		this.actualizarBotones();
	}
	private void jTableNoImponibleValueChanged(ListSelectionEvent evt) {
		this.actualizarBotones();
	}
	
	public void actualizar(EmpresaCuenta empresaCuenta, Trabajador trabajador) {
		this.trabajadorCuenta = controlTrabajadorCuenta.getTrabajadorCuenta(empresaCuenta, trabajador);
		this.jLabelFecha.setText(Fecha.fechaTexto(trabajadorCuenta.getEmpresaCuenta().getMes().getFecha()));
		this.jFormattedTextFieldRutEmpresa.setText(trabajadorCuenta.getEmpresaCuenta().getEmpresa().getRutEmpresa());
		this.jTextFieldRazonSocial.setText(trabajadorCuenta.getEmpresaCuenta().getEmpresa().getRazonSocial());
		this.jTextFieldRutTrabajador.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getRut());
		this.jTextFieldSexo.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getSexo());
		this.jTextFieldNombres.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getNombres());
		this.jTextFieldAPaterno.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getApellidoPaterno());
		this.jTextFieldAMaterno.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getApellidoMaterno());
		this.actualizarModelo();
		this.actualizarBotones();
	}

	private void actualizarModelo() {
		this.jTableCentroCosto.setModel(this.controlModelCentroCosto.getTableModelTrabajadorCentroCosto(trabajadorCuenta));
		this.jTableImponible.setModel(this.controlModelImponible.getTableModelTrabajadorImponible(trabajadorCuenta));
		this.jTableNoImponible.setModel(this.controlModelNoImponible.getTableModelTrabajadorNoImponible(trabajadorCuenta));
		this.jTableDescuento.setModel(this.controlModelDescuento.getTableModelTrabajadorDescuento(trabajadorCuenta));
	}

	private void actualizarBotones() {
		this.jButtonCentroCostoAdd.setEnabled(true);
		this.jButtonDesceuntoAdd.setEnabled(true);
		this.jButtonImponibleAdd.setEnabled(true);
		this.jButtonNoImponibleAdd.setEnabled(true);
		if (this.jTableCentroCosto.getSelectedRow()==-1) {
			this.jButtonCentroCostoRemove.setEnabled(false);
			this.jButtonCentroCostoUpdate.setEnabled(false);
		} else {
			this.jButtonCentroCostoRemove.setEnabled(true);
			this.jButtonCentroCostoUpdate.setEnabled(true);
		}
		if (this.jTableDescuento.getSelectedRow()==-1) {
			this.jButtonDescuentoRemove.setEnabled(false);
			this.jButtonDescuentoUpdate.setEnabled(false);
		} else {
			this.jButtonDescuentoRemove.setEnabled(true);
			this.jButtonDescuentoUpdate.setEnabled(true);
		}
		if (this.jTableImponible.getSelectedRow()==-1) {
			this.jButtonImponibleRemove.setEnabled(false);
			this.jButtonImponibleUpdate.setEnabled(false);
		} else {
			this.jButtonImponibleRemove.setEnabled(true);
			this.jButtonImponibleUpdate.setEnabled(true);
		}
		if (this.jTableNoImponible.getSelectedRow()==-1) {
			this.jButtonNoImponibleRemove.setEnabled(false);
			this.jButtonNoImponibleUpdate.setEnabled(false);
		} else {
			this.jButtonNoImponibleRemove.setEnabled(true);
			this.jButtonNoImponibleUpdate.setEnabled(true);
		}
	}
	
}