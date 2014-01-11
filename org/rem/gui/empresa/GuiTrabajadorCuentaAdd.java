package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.BorderFactory;
//import javax.swing.ComboBoxModel;
//import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import org.rem.control.empresa.ControlEmpresaCuenta;
import org.rem.control.empresa.ControlTrabajador;
import org.rem.control.empresa.ControlTrabajadorCuenta;
import org.rem.control.institucion.ControlAfp;
import org.rem.control.institucion.ControlIsapre;
import org.rem.model.Afp;
import org.rem.model.Isapre;
import org.rem.model.Persona;
import org.rem.model.EmpresaCuenta;
import org.rem.model.TrabajadorCuenta;
import org.rem.util.Fecha;
import org.rem.util.Formato;
import org.rem.util.Message;
import org.rem.util.Palabra;
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
public class GuiTrabajadorCuentaAdd extends JDialog {

	private Date fecha = null;
	private EmpresaCuenta empresaCuenta;
	private ControlTrabajadorCuenta control = new ControlTrabajadorCuenta();
	private ControlTrabajador controlTrabajador = new ControlTrabajador();
	private ControlIsapre controlIsapre = new ControlIsapre();
	private ControlAfp controlAfp = new ControlAfp();
	private ControlEmpresaCuenta controlEmpresaCuenta = new ControlEmpresaCuenta();
	private JTextField jTextFieldSueldoPromedio;
	private JLabel jLabelInstitucionPrevision2;
	private JComboBox jComboBoxInstitucionPrevision2;
	private JTextField jTextFieldSexo;
	private JTextField jTextFieldCargasNormales;
	private JTextField jTextFieldCargasInvalidas;
	private JComboBox jComboBoxCargas;
	private JLabel jLabelCargasInvalidas;
	private JLabel jLabelCargasNormales;
	private JLabel jLabelSueldoPromedio;
	private JLabel jLabelCargas;
	private JComboBox jComboBoxTipoPactoIsapre;
	private JTextField jTextFieldPactoIsapre;
	private JComboBox jComboBoxInstitucionSalud;
	private JLabel jLabelPactoIsapre;
	private JLabel jLabelInstitucionSalud;
	private JTextField jTextFieldAPaterno;
	private JComboBox jComboBoxInstitucionPrevision;
	private JComboBox jComboBoxTipoAhorroVoluntario;
	private JTextField jTextFieldAhorroVoluntario;
	private JLabel jLabelAhorroVoluntario;
	private JLabel jLabelInstitucionPrevision;
	private JComboBox jComboBoxTipoContrato;
	private JComboBox jComboBoxFormaPago;
	private JComboBox jComboBoxSeguroCesantia;
	private JComboBox jComboBoxTrato;
	private JLabel jLabelTipoContrato;
	private JLabel jLabelSeguroCesantia;
	private JLabel jLabelFormaPago;
	private JLabel jLabelTrato;
	private JPanel jPanelCargas2;
	private JPanel jPanelCargas;
	private JPanel jPanelSalud2;
	private JPanel jPanelPrevision2;
	private JPanel jPanelSalud;
	private JPanel jPanelPrevision;
	private JPanel jPanelContrato2;
	private JPanel jPanelContrato;
	private JComboBox jComboBoxRut;
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
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonAdd;

	/**
	 * This is the default constructor
	 */
	public GuiTrabajadorCuentaAdd(Frame owner) {
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
					{ 10.0, 23.0, TableLayout.FILL, 10.0 },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 8, 2, 8");
			jPanel.add(getJLabelRespuesta(), "1, 7, 2, 7");
			jPanel.add(getJPanelEmpresa(), "1, 1, 2, 1");
			jPanel.add(getJPanelFecha(), "1, 0, 2, 0");
			jPanel.add(getJPanelTrabajador(), "1, 2, 2, 2");
			jPanel.add(getJPanelContrato(), "1, 3, 2, 3");
			jPanel.add(getJPanelPrevision(), "1, 4, 2, 4");
			jPanel.add(getJPanelSalud(), "1, 5, 2, 5");
			jPanel.add(getJPanelCargas(), "1, 6, 2, 6");
		}
		return jPanel;
	}

	private JLabel getJLabelRespuesta() {
		if (jLabelRespuesta == null) {
			jLabelRespuesta = new JLabel();
			jLabelRespuesta.setText("...");
			jLabelRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelRespuesta.setBorder(BorderFactory
					.createBevelBorder(BevelBorder.LOWERED));
		}
		return jLabelRespuesta;
	}

	private JPanel getJPanelButton() {
		if (jPanelButton == null) {
			jPanelButton = new JPanel();
			jPanelButton.add(getJButtonAdd());
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
					{ TableLayout.PREFERRED, 93.0, TableLayout.PREFERRED,
							TableLayout.FILL }, { TableLayout.PREFERRED } });
			jPanelEmpresa2Layout.setHGap(5);
			jPanelEmpresa2Layout.setVGap(5);
			jPanelEmpresa2.setLayout(jPanelEmpresa2Layout);
			jPanelEmpresa2.add(getJLabelRutEmpresa(), "0,          0");
			jPanelEmpresa2.add(getJLabelRazonSocial(), "2,          0");
			jPanelEmpresa2.add(getJTextFieldRazonSocial(), "3,          0");
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
						{ TableLayout.PREFERRED, 129.0, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.FILL,
								TableLayout.PREFERRED, 50.0 },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelTrabajador2Layout.setHGap(5);
			jPanelTrabajador2Layout.setVGap(5);
			jPanelTrabajador2.setLayout(jPanelTrabajador2Layout);
			jPanelTrabajador2.add(getJLabelRutTrabajador(), "0,    0");
			jPanelTrabajador2.add(getJLabelNombres(), "2,    0");
			jPanelTrabajador2.add(getJTextFieldNombres(), "3,    0,    4,    0");
			jPanelTrabajador2.add(getJLabelAPaterno(), "0,    1");
			jPanelTrabajador2.add(getJTextFieldAPaterno(), "1,    1,    2,    1");
			jPanelTrabajador2.add(getJLabelAMaterno(), "3,    1");
			jPanelTrabajador2.add(getJTextFieldAMaterno(), "4,    1,    6,    1");
			jPanelTrabajador2.add(getJLabelSexo(), "5,    0");
			jPanelTrabajador2.add(getJComboBoxRut(), "1, 0");
			jPanelTrabajador2.add(getJTextFieldSexo(), "6, 0");
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

	private JComboBox getJComboBoxRut() {
		if (jComboBoxRut == null) {
			jComboBoxRut = new JComboBox();
			jComboBoxRut.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxRutActionPerformed(evt);
				}
			});
		}
		return jComboBoxRut;
	}
	
	private JPanel getJPanelContrato() {
		if (jPanelContrato == null) {
			jPanelContrato = new JPanel();
			CardLayout jPanelContratoLayout = new CardLayout();
			jPanelContrato.setLayout(jPanelContratoLayout);
			jPanelContrato.setBorder(BorderFactory.createTitledBorder("Contrato"));
			jPanelContrato.add(getJPanelContrato2(), "jPanelContrato2");
		}
		return jPanelContrato;
	}
	
	private JPanel getJPanelContrato2() {
		if (jPanelContrato2 == null) {
			jPanelContrato2 = new JPanel();
			TableLayout jPanelContrato2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, 65.0, TableLayout.PREFERRED,
							TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelContrato2Layout.setHGap(5);
			jPanelContrato2Layout.setVGap(5);
			jPanelContrato2.setLayout(jPanelContrato2Layout);
			jPanelContrato2.add(getJLabelTrato(), "0, 0");
			jPanelContrato2.add(getJLabelFormaPago(), "2, 0");
			jPanelContrato2.add(getJLabelSeguroCesantia(), "0, 1");
			jPanelContrato2.add(getJLabelTipoContrato(), "2, 1");
			jPanelContrato2.add(getJComboBoxTrato(), "1, 0");
			jPanelContrato2.add(getJComboBoxSeguroCesantia(), "1, 1");
			jPanelContrato2.add(getJComboBoxFormaPago(), "3, 0");
			jPanelContrato2.add(getJComboBoxTipoContrato(), "3, 1");
		}
		return jPanelContrato2;
	}
	
	private JPanel getJPanelPrevision() {
		if (jPanelPrevision == null) {
			jPanelPrevision = new JPanel();
			CardLayout jPanelPrevisionLayout = new CardLayout();
			jPanelPrevision.setLayout(jPanelPrevisionLayout);
			jPanelPrevision.setEnabled(false);
			jPanelPrevision.setBorder(BorderFactory.createTitledBorder("Previsión"));
			jPanelPrevision.add(getJPanelPrevision2(), "jPanelPrevision2");
		}
		return jPanelPrevision;
	}
	
	private JPanel getJPanelSalud() {
		if (jPanelSalud == null) {
			jPanelSalud = new JPanel();
			CardLayout jPanelSaludLayout = new CardLayout();
			jPanelSalud.setLayout(jPanelSaludLayout);
			jPanelSalud.setBorder(BorderFactory.createTitledBorder("Salud"));
			jPanelSalud.add(getJPanelSalud2(), "jPanelSalud2");
		}
		return jPanelSalud;
	}
	
	private JPanel getJPanelPrevision2() {
		if (jPanelPrevision2 == null) {
			jPanelPrevision2 = new JPanel();
			TableLayout jPanelPrevision2Layout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED, TableLayout.FILL,
								TableLayout.PREFERRED, TableLayout.FILL,
								TableLayout.PREFERRED, 60.0, 60.0 },
						{ TableLayout.PREFERRED } });
			jPanelPrevision2Layout.setHGap(5);
			jPanelPrevision2Layout.setVGap(5);
			jPanelPrevision2.setLayout(jPanelPrevision2Layout);
			jPanelPrevision2.add(getJLabelInstitucionPrevision(), "0, 0");
			jPanelPrevision2.add(getJLabelAhorroVoluntario(), "4, 0");
			jPanelPrevision2.add(getJTextFieldAhorroVoluntario(), "5, 0");
			jPanelPrevision2.add(getJComboBoxTipoAhorroVoluntario(), "6, 0");
			jPanelPrevision2.add(getJComboBoxInstitucionPrevision(), "1, 0");
			jPanelPrevision2.add(getJComboBoxInstitucionPrevision2(), "3, 0");
			jPanelPrevision2.add(getJLabelInstitucionPrevision2(), "2, 0");
		}
		return jPanelPrevision2;
	}
	
	private JPanel getJPanelSalud2() {
		if (jPanelSalud2 == null) {
			jPanelSalud2 = new JPanel();
			TableLayout jPanelSalud2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL,
							TableLayout.PREFERRED, 100.0, 60.0 },
					{ TableLayout.PREFERRED } });
			jPanelSalud2Layout.setHGap(5);
			jPanelSalud2Layout.setVGap(5);
			jPanelSalud2.setLayout(jPanelSalud2Layout);
			jPanelSalud2.add(getJLabelInstitucionSalud(), "0, 0");
			jPanelSalud2.add(getJLabelPactoIsapre(), "2, 0");
			jPanelSalud2.add(getJComboBoxInstitucionSalud(), "1, 0");
			jPanelSalud2.add(getJTextFieldPactoIsapre(), "3, 0");
			jPanelSalud2.add(getJComboBoxTipoPactoIsapre(), "4, 0");
		}
		return jPanelSalud2;
	}
	
	private JPanel getJPanelCargas() {
		if (jPanelCargas == null) {
			jPanelCargas = new JPanel();
			CardLayout jPanelCargasLayout = new CardLayout();
			jPanelCargas.setLayout(jPanelCargasLayout);
			jPanelCargas.setBorder(BorderFactory.createTitledBorder("Cargas Familiares"));
			jPanelCargas.add(getJPanelCargas2(), "jPanelCargas2");
		}
		return jPanelCargas;
	}
	
	private JPanel getJPanelCargas2() {
		if (jPanelCargas2 == null) {
			jPanelCargas2 = new JPanel();
			TableLayout jPanelCargas2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL,
							TableLayout.PREFERRED, TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelCargas2Layout.setHGap(5);
			jPanelCargas2Layout.setVGap(5);
			jPanelCargas2.setLayout(jPanelCargas2Layout);
			jPanelCargas2.add(getJLabelCargas(), "0, 0");
			jPanelCargas2.add(getJLabelSueldoPromedio(), "0, 1");
			jPanelCargas2.add(getJLabelCargasNormales(), "2, 0");
			jPanelCargas2.add(getJLabelCargasInvalidas(), "2, 1");
			jPanelCargas2.add(getJComboBoxCargas(), "1, 0");
			jPanelCargas2.add(getJTextFieldSueldoPromedio(), "1, 1");
			jPanelCargas2.add(getJTextFieldCargasInvalidas(), "3, 1");
			jPanelCargas2.add(getJTextFieldCargasNormales(), "3, 0");
		}
		return jPanelCargas2;
	}
	
	private JLabel getJLabelTrato() {
		if (jLabelTrato == null) {
			jLabelTrato = new JLabel();
			jLabelTrato.setText("Trato : ");
		}
		return jLabelTrato;
	}
	
	private JLabel getJLabelFormaPago() {
		if (jLabelFormaPago == null) {
			jLabelFormaPago = new JLabel();
			jLabelFormaPago.setText("Forma Pago : ");
		}
		return jLabelFormaPago;
	}
	
	private JLabel getJLabelSeguroCesantia() {
		if (jLabelSeguroCesantia == null) {
			jLabelSeguroCesantia = new JLabel();
			jLabelSeguroCesantia.setText("Seguro de Cesantía : ");
		}
		return jLabelSeguroCesantia;
	}
	
	private JLabel getJLabelTipoContrato() {
		if (jLabelTipoContrato == null) {
			jLabelTipoContrato = new JLabel();
			jLabelTipoContrato.setText("Tipo de Contrato : ");
		}
		return jLabelTipoContrato;
	}
	
	private JComboBox getJComboBoxTrato() {
		if (jComboBoxTrato == null) {
			jComboBoxTrato = new JComboBox();
			jComboBoxTrato.setModel(Palabra.getComboBoxModelTrato());
		}
		return jComboBoxTrato;
	}
	
	private JComboBox getJComboBoxSeguroCesantia() {
		if (jComboBoxSeguroCesantia == null) {
			jComboBoxSeguroCesantia = new JComboBox();
			jComboBoxSeguroCesantia.setModel(Palabra.getComboBoxModelYesNo());
			jComboBoxSeguroCesantia.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxSeguroCesantiaActionPerformed(evt);
				}
			});
		}
		return jComboBoxSeguroCesantia;
	}
	
	private JComboBox getJComboBoxFormaPago() {
		if (jComboBoxFormaPago == null) {
			jComboBoxFormaPago = new JComboBox();
			jComboBoxFormaPago.setModel(Palabra.getComboBoxModelFormaPago());
		}
		return jComboBoxFormaPago;
	}
	
	private JComboBox getJComboBoxTipoContrato() {
		if (jComboBoxTipoContrato == null) {
			jComboBoxTipoContrato = new JComboBox();
			jComboBoxTipoContrato.setModel(Palabra.getComboBoxModelTipoContrato());
		}
		return jComboBoxTipoContrato;
	}
	
	private JLabel getJLabelInstitucionPrevision() {
		if (jLabelInstitucionPrevision == null) {
			jLabelInstitucionPrevision = new JLabel();
			jLabelInstitucionPrevision.setText("Institución : ");
		}
		return jLabelInstitucionPrevision;
	}
	
	private JLabel getJLabelAhorroVoluntario() {
		if (jLabelAhorroVoluntario == null) {
			jLabelAhorroVoluntario = new JLabel();
			jLabelAhorroVoluntario.setText("A. Voluntario : ");
		}
		return jLabelAhorroVoluntario;
	}
	
	private JTextField getJTextFieldAhorroVoluntario() {
		if (jTextFieldAhorroVoluntario == null) {
			jTextFieldAhorroVoluntario = new JTextField();
			jTextFieldAhorroVoluntario.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldAhorroVoluntarioKeyTyped(evt);
				}
			});
		}
		return jTextFieldAhorroVoluntario;
	}
	
	private JComboBox getJComboBoxTipoAhorroVoluntario() {
		if (jComboBoxTipoAhorroVoluntario == null) {
			jComboBoxTipoAhorroVoluntario = new JComboBox();
			jComboBoxTipoAhorroVoluntario.setModel(Palabra.getComboBoxModelTipoPacto());
		}
		return jComboBoxTipoAhorroVoluntario;
	}
	
	private JComboBox getJComboBoxInstitucionPrevision() {
		if (jComboBoxInstitucionPrevision == null) {
			jComboBoxInstitucionPrevision = new JComboBox();
			jComboBoxInstitucionPrevision
				.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxInstitucionPrevisionActionPerformed(evt);
				}
				});
		}
		return jComboBoxInstitucionPrevision;
	}
	
	private JLabel getJLabelInstitucionSalud() {
		if (jLabelInstitucionSalud == null) {
			jLabelInstitucionSalud = new JLabel();
			jLabelInstitucionSalud.setText("Institución : ");
		}
		return jLabelInstitucionSalud;
	}
	
	private JLabel getJLabelPactoIsapre() {
		if (jLabelPactoIsapre == null) {
			jLabelPactoIsapre = new JLabel();
			jLabelPactoIsapre.setText("Pacto Isapre : ");
		}
		return jLabelPactoIsapre;
	}
	
	private JComboBox getJComboBoxInstitucionSalud() {
		if (jComboBoxInstitucionSalud == null) {
			jComboBoxInstitucionSalud = new JComboBox();
			jComboBoxInstitucionSalud.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxInstitucionSaludActionPerformed(evt);
				}
			});
		}
		return jComboBoxInstitucionSalud;
	}
	
	private JTextField getJTextFieldPactoIsapre() {
		if (jTextFieldPactoIsapre == null) {
			jTextFieldPactoIsapre = new JTextField();
			jTextFieldPactoIsapre.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldPactoIsapreKeyTyped(evt);
				}
			});
		}
		return jTextFieldPactoIsapre;
	}
	
	private JComboBox getJComboBoxTipoPactoIsapre() {
		if (jComboBoxTipoPactoIsapre == null) {
			jComboBoxTipoPactoIsapre = new JComboBox();
			jComboBoxTipoPactoIsapre.setModel(Palabra.getComboBoxModelTipoPacto());
		}
		return jComboBoxTipoPactoIsapre;
	}
	
	private JLabel getJLabelCargas() {
		if (jLabelCargas == null) {
			jLabelCargas = new JLabel();
			jLabelCargas.setText("¿Cargas? : ");
		}
		return jLabelCargas;
	}
	
	private JLabel getJLabelSueldoPromedio() {
		if (jLabelSueldoPromedio == null) {
			jLabelSueldoPromedio = new JLabel();
			jLabelSueldoPromedio.setText("Sueldo Promedio : ");
		}
		return jLabelSueldoPromedio;
	}
	
	private JLabel getJLabelCargasNormales() {
		if (jLabelCargasNormales == null) {
			jLabelCargasNormales = new JLabel();
			jLabelCargasNormales.setText("Nº Cargas Normales : ");
		}
		return jLabelCargasNormales;
	}
	
	private JLabel getJLabelCargasInvalidas() {
		if (jLabelCargasInvalidas == null) {
			jLabelCargasInvalidas = new JLabel();
			jLabelCargasInvalidas.setText("Nº Cargar Inválidas : ");
		}
		return jLabelCargasInvalidas;
	}
	
	private JComboBox getJComboBoxCargas() {
		if (jComboBoxCargas == null) {
			jComboBoxCargas = new JComboBox();
			jComboBoxCargas.setModel(Palabra.getComboBoxModelYesNo());
			jComboBoxCargas.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxCargasActionPerformed(evt);
				}
			});
		}
		return jComboBoxCargas;
	}
	
	private JTextField getJTextFieldSueldoPromedio() {
		if (jTextFieldSueldoPromedio == null) {
			jTextFieldSueldoPromedio = new JTextField();
			jTextFieldSueldoPromedio.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldSueldoPromedioKeyTyped(evt);
				}
			});
		}
		return jTextFieldSueldoPromedio;
	}

	private JTextField getJTextFieldCargasInvalidas() {
		if (jTextFieldCargasInvalidas == null) {
			jTextFieldCargasInvalidas = new JTextField();
			jTextFieldCargasInvalidas.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldCargasInvalidasKeyTyped(evt);
				}
			});
		}
		return jTextFieldCargasInvalidas;
	}
	
	private JTextField getJTextFieldCargasNormales() {
		if (jTextFieldCargasNormales == null) {
			jTextFieldCargasNormales = new JTextField();
			jTextFieldCargasNormales.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldCargasNormalesKeyTyped(evt);
				}
			});
		}
		return jTextFieldCargasNormales;
	}
	
	private JTextField getJTextFieldSexo() {
		if (jTextFieldSexo == null) {
			jTextFieldSexo = new JTextField();
			jTextFieldSexo.setEditable(false);
		}
		return jTextFieldSexo;
	}


	private void jComboBoxRutActionPerformed(ActionEvent evt) {
		this.actualizarDatos();
	}
	
	private void jComboBoxInstitucionPrevisionActionPerformed(ActionEvent evt) {
		//TODO COMENTE CODIGO PARA QUE SIEMPRE SE PUEDA INGRESAR AHORRO VOLUNTARIO
		//if (controlAfp.getRegimen(this.jComboBoxInstitucionPrevision.getSelectedItem().toString()).equals(Palabra.regimenNuevo)) {
			this.jTextFieldAhorroVoluntario.setEnabled(true);
			this.jComboBoxTipoAhorroVoluntario.setEnabled(true);
			if (this.jComboBoxSeguroCesantia.getSelectedItem().equals(Palabra.booleanTrue) 
					&& controlAfp.getRegimen(fecha, this.jComboBoxInstitucionPrevision.getSelectedItem().toString())
					.equals(Palabra.regimenAntiguo)) {
				this.jComboBoxInstitucionPrevision2.setEnabled(true);
			} else {
				this.jComboBoxInstitucionPrevision2.setEnabled(false);
			}
		//} else {
		//	this.jTextFieldAhorroVoluntario.setEnabled(false);
		//	this.jComboBoxTipoAhorroVoluntario.setEnabled(false);			
		//}
	}
	
	private void jComboBoxInstitucionSaludActionPerformed(ActionEvent evt) {
		if (this.jComboBoxInstitucionSalud.getSelectedItem().toString().equals(Palabra.institucionFonasa)) {
			this.jTextFieldPactoIsapre.setEnabled(false);
			this.jComboBoxTipoPactoIsapre.setEnabled(false);
		} else {
			this.jTextFieldPactoIsapre.setEnabled(true);
			this.jComboBoxTipoPactoIsapre.setEnabled(true);			
		}
	}
	
	private void jComboBoxCargasActionPerformed(ActionEvent evt) {
		if (this.jComboBoxCargas.getSelectedItem().toString().equals(Palabra.booleanTrue)) {
			this.jTextFieldSueldoPromedio.setEnabled(true);
			this.jTextFieldCargasNormales.setEnabled(true);
			this.jTextFieldCargasInvalidas.setEnabled(true);
		} else {
			this.jTextFieldSueldoPromedio.setEnabled(false);
			this.jTextFieldCargasNormales.setEnabled(false);
			this.jTextFieldCargasInvalidas.setEnabled(false);
		}
	}
	
	private void jTextFieldAhorroVoluntarioKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldAhorroVoluntario.getText());
	}
	
	private void jTextFieldPactoIsapreKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldPactoIsapre.getText());
	}
	
	private void jTextFieldSueldoPromedioKeyTyped(KeyEvent evt) {
		Formato.formatLong(evt);
	}
	
	private void jTextFieldCargasNormalesKeyTyped(KeyEvent evt) {
		Formato.formatLong(evt);
	}
	
	private void jTextFieldCargasInvalidasKeyTyped(KeyEvent evt) {
		Formato.formatLong(evt);
	}
	
	private void jButtonAddActionPerformed(ActionEvent evt) {
		if (this.jComboBoxRut.getSelectedIndex()==-1 && this.empresaCuenta!=null) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar un \"Trabajador\".");
		} else if (!this.jComboBoxInstitucionPrevision.getSelectedItem().toString().equals(Palabra.institucionSin) && this.jTextFieldAhorroVoluntario.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"A. Voluntario\".");
		} else if (!this.jComboBoxInstitucionSalud.getSelectedItem().toString().equals(Palabra.institucionFonasa) && this.jTextFieldPactoIsapre.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Pacto Isapre\".");
		} else if (this.jComboBoxCargas.getSelectedItem().toString().equals(Palabra.booleanTrue) &&
				(this.jTextFieldSueldoPromedio.getText().trim().length()==0 || 
				 this.jTextFieldCargasNormales.getText().trim().length()==0 ||
				 this.jTextFieldCargasInvalidas.getText().trim().length()==0)) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar los campos en \"Cargas\".");
		} else if (this.jComboBoxSeguroCesantia.getSelectedItem().equals(Palabra.booleanTrue) 
				&& controlAfp.getRegimen(fecha, this.jComboBoxInstitucionPrevision.getSelectedItem().toString())
				.equals(Palabra.regimenAntiguo) &&
				this.jComboBoxInstitucionPrevision2.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Inst. S. Cesantía\".");
		}
		
		else {
			
			Afp afp;
			Double valorAhorroVoluntario;
			if (!this.jComboBoxInstitucionPrevision.getSelectedItem().toString().equals(Palabra.institucionSin)) {
				afp = this.controlAfp.getAfp(fecha, this.jComboBoxInstitucionPrevision.getSelectedItem().toString());
				valorAhorroVoluntario = new Double(this.jTextFieldAhorroVoluntario.getText());
			} else {
				afp = null;
				valorAhorroVoluntario = new Double(0);
			}
			
			Afp afp2;
			if (this.jComboBoxSeguroCesantia.getSelectedItem().equals(Palabra.booleanTrue) 
					&& controlAfp.getRegimen(fecha, this.jComboBoxInstitucionPrevision.getSelectedItem().toString())
					.equals(Palabra.regimenAntiguo)) {
				afp2 = this.controlAfp.getAfp(fecha, this.jComboBoxInstitucionPrevision2.getSelectedItem().toString());
			} else {
				afp2 = null;
			}
			
			Isapre isapre;
			String tipoSalud;
			Double valorPactoIsapre;
		
			if (this.jComboBoxInstitucionSalud.getSelectedItem().toString().equals(Palabra.institucionFonasa)) {
				tipoSalud = Palabra.tipoSaludFonasa;
				isapre = null;
				valorPactoIsapre = new Double(0);
			} else {
				tipoSalud = Palabra.tipoSaludIsapre;
				isapre = this.controlIsapre.getIsapre(this.jComboBoxInstitucionSalud.getSelectedItem().toString());
				valorPactoIsapre = new Double(this.jTextFieldPactoIsapre.getText());
			}
			
			Boolean cargas;
			Double sueldoPromedio;
			Long numeroCargasNormal; 
			Long numeroCargasInvalida;
			
			if (this.jComboBoxCargas.getSelectedItem().toString().equals(Palabra.booleanTrue)) {
				cargas = new Boolean(true);
				sueldoPromedio = new Double(this.jTextFieldSueldoPromedio.getText());
				numeroCargasNormal = new Long(this.jTextFieldCargasNormales.getText()); 
				numeroCargasInvalida = new Long(this.jTextFieldCargasInvalidas.getText());				
			} else {
				cargas = new Boolean(false);
				sueldoPromedio = new Double(0);
				numeroCargasNormal = new Long(0); 
				numeroCargasInvalida = new Long(0);				
			}
			
			this.respuesta(control.addTrabajadorCuenta(
					empresaCuenta, 
					this.controlTrabajador.getTrabajador(empresaCuenta, this.jComboBoxRut.getSelectedItem().toString()), 
					this.jComboBoxTrato.getSelectedItem().toString(), 
					this.jComboBoxFormaPago.getSelectedItem().toString(),
					this.jComboBoxTipoContrato.getSelectedItem().toString(), 
					Palabra.setBooleanString(this.jComboBoxSeguroCesantia.getSelectedItem().toString()), 
					afp, 
					afp2,
					this.jComboBoxTipoAhorroVoluntario.getSelectedItem().toString(), 
					valorAhorroVoluntario, 
					tipoSalud, 
					isapre, 
					this.jComboBoxTipoPactoIsapre.getSelectedItem().toString(),
					valorPactoIsapre,
					cargas, 
					sueldoPromedio, 
					numeroCargasNormal, 
					numeroCargasInvalida));
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se agregó exitosamente.");
			this.actualizarModelo();
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Ya existe la cuenta.");			
		} else if (respuesta == control.respCuentaEmpresaCerrada) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "La cuenta de la empresa está cerrada.");
		} else if (respuesta == control.respNoExisteTrabajador) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el trabajador.");
		}
	}
	
	private void actualizarDatos() {
		if (this.jComboBoxRut.getSelectedIndex()!=-1) {
			Persona dp = this.controlTrabajador.getDatosPersonales(this.empresaCuenta, this.jComboBoxRut.getSelectedItem().toString());
			if (dp!=null) {
				this.jTextFieldNombres.setText(dp.getNombres());
				this.jTextFieldSexo.setText(dp.getSexo());
				this.jTextFieldAPaterno.setText(dp.getApellidoPaterno());
				this.jTextFieldAMaterno.setText(dp.getApellidoMaterno());
			} else {
				this.jTextFieldNombres.setText("");
				this.jTextFieldSexo.setText("");
				this.jTextFieldAPaterno.setText("");
				this.jTextFieldAMaterno.setText("");
			}
			TrabajadorCuenta lastCuenta = this.control.getLastTrabajadorCuenta(this.empresaCuenta, this.jComboBoxRut.getSelectedItem().toString());
			if (lastCuenta!=null) {
				this.jComboBoxTrato.setSelectedItem(lastCuenta.getTrato());
				this.jComboBoxFormaPago.setSelectedItem(lastCuenta.getFormaPago());
				this.jComboBoxSeguroCesantia.setSelectedItem(Palabra.getBooleanString(lastCuenta.isSeguroCesantia()));
				this.jComboBoxTipoContrato.setSelectedItem(lastCuenta.getTipoContrato());
				/** OJO: en vez de AFP decía ISAPRE */
				if (lastCuenta.getAfp()!=null) {
					this.jComboBoxInstitucionPrevision.setSelectedItem(lastCuenta.getAfp().getNombre());
					this.jTextFieldAhorroVoluntario.setText(lastCuenta.getValorAhorroVoluntario().toString());
					this.jComboBoxTipoAhorroVoluntario.setSelectedItem(lastCuenta.getTipoAhorroVoluntario());
					if (this.jComboBoxSeguroCesantia.getSelectedItem().equals(Palabra.booleanTrue) 
							&& lastCuenta.getAfp().getRegimen().equals(Palabra.regimenAntiguo)) {
						this.jComboBoxInstitucionPrevision2.setEnabled(true);
						this.jComboBoxInstitucionPrevision2.setSelectedItem(lastCuenta.getAfp2().getNombre());
					} else {
						this.jComboBoxInstitucionPrevision2.setEnabled(false);
					}
				} else {
					this.jComboBoxInstitucionPrevision.setSelectedIndex(0);
					this.jTextFieldAhorroVoluntario.setText("");
					this.jComboBoxTipoAhorroVoluntario.setSelectedIndex(0);
					this.jComboBoxInstitucionPrevision2.setEnabled(false);
				}
				if (lastCuenta.getTipoSalud().equals(Palabra.institucionFonasa)) {
					this.jComboBoxInstitucionSalud.setSelectedItem(Palabra.institucionFonasa);
					this.jTextFieldPactoIsapre.setText("");
					this.jComboBoxTipoPactoIsapre.setSelectedIndex(0);
				} else {
					this.jComboBoxInstitucionSalud.setSelectedItem(lastCuenta.getIsapre().getNombre());
					this.jTextFieldPactoIsapre.setText(lastCuenta.getValorPactoIsapre().toString());
					this.jComboBoxTipoPactoIsapre.setSelectedItem(lastCuenta.getTipoPactoIsapre());
				}
				this.jComboBoxCargas.setSelectedItem(Palabra.getBooleanString(lastCuenta.isCargas()));
				this.jTextFieldSueldoPromedio.setText(lastCuenta.getSueldoPromedio().toString());
				this.jTextFieldCargasNormales.setText(lastCuenta.getNumeroCargasNormal().toString());
				this.jTextFieldCargasInvalidas.setText(lastCuenta.getNumeroCargasInvalida().toString());
			} else {
				this.jComboBoxTrato.setSelectedIndex(0);
				this.jComboBoxFormaPago.setSelectedIndex(0);
				this.jComboBoxSeguroCesantia.setSelectedIndex(0);
				this.jComboBoxTipoContrato.setSelectedIndex(0);
				this.jComboBoxInstitucionPrevision.setSelectedIndex(0);
				this.jComboBoxInstitucionPrevision2.setSelectedIndex(0);
				this.jComboBoxInstitucionPrevision2.setEnabled(false);
				this.jTextFieldAhorroVoluntario.setText("");
				this.jComboBoxTipoAhorroVoluntario.setSelectedIndex(0);
				this.jComboBoxInstitucionSalud.setSelectedIndex(0);
				this.jTextFieldPactoIsapre.setText("");
				this.jComboBoxTipoPactoIsapre.setSelectedIndex(0);
				this.jComboBoxCargas.setSelectedIndex(0);
				this.jTextFieldSueldoPromedio.setText("");
				this.jTextFieldCargasNormales.setText("");
				this.jTextFieldCargasInvalidas.setText("");
			}
		}
	}
	
	public void actualizar(EmpresaCuenta cuenta) {
		//fecha = controlEmpresaCuenta.getFecha(empresaCuenta);
		this.empresaCuenta = cuenta;
		this.jLabelFecha.setText(Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
		fecha = empresaCuenta.getMes().getFecha();
		System.out.println(this.jLabelFecha.getText());
		this.jFormattedTextFieldRutEmpresa.setText(empresaCuenta.getEmpresa().getRutEmpresa());
		this.jTextFieldRazonSocial.setText(empresaCuenta.getEmpresa().getRazonSocial());
		this.jComboBoxInstitucionPrevision.setModel(controlAfp.getComboBoxModelAfpNoBloqueadoSin(fecha));
		this.jComboBoxInstitucionPrevision2.setModel(controlAfp.getComboBoxModelAfpNuevoNoBloqueado(fecha));
		this.jComboBoxInstitucionSalud.setModel(controlIsapre.getComboBoxModelIsapreNoBloqueadoFonasa());
		this.actualizarModelo();
	}

	private void actualizarModelo() {
		this.jComboBoxRut.setModel(control.getComboBoxModelTrabajdorSinCuenta(empresaCuenta));
		this.actualizarDatos();
	}
	
	private JComboBox getJComboBoxInstitucionPrevision2() {
		if (jComboBoxInstitucionPrevision2 == null) {
			jComboBoxInstitucionPrevision2 = new JComboBox();
		}
		return jComboBoxInstitucionPrevision2;
	}
	
	private JLabel getJLabelInstitucionPrevision2() {
		if (jLabelInstitucionPrevision2 == null) {
			jLabelInstitucionPrevision2 = new JLabel();
			jLabelInstitucionPrevision2.setText("Inst. S. Cesantía :");
		}
		return jLabelInstitucionPrevision2;
	}
		
	private void jComboBoxSeguroCesantiaActionPerformed(ActionEvent evt) {
		if (this.jComboBoxSeguroCesantia.getSelectedItem().equals(Palabra.booleanTrue) 
				&& controlAfp.getRegimen(fecha, this.jComboBoxInstitucionPrevision.getSelectedItem().toString())
				.equals(Palabra.regimenAntiguo)) {
			this.jComboBoxInstitucionPrevision2.setEnabled(true);
		} else {
			this.jComboBoxInstitucionPrevision2.setEnabled(false);
		}
	}

}