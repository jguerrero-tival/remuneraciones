package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import org.rem.control.empresa.ControlTrabajador;
import org.rem.control.empresa.ControlTrabajadorCuenta;
import org.rem.control.institucion.ControlAfp;
import org.rem.control.institucion.ControlIsapre;
import org.rem.informes.CalculoInformes;
import org.rem.informes.CalculoInformesCC;
import org.rem.informes.CrearInformes;
import org.rem.informes.UtilInformes;
import org.rem.model.EmpresaCuenta;
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
public class GuiInforme extends JDialog {

	private EmpresaCuenta empresaCuenta;
	private JComboBox jComboBoxTipo;
	private JButton jButtonLibroRemuneracion;
	private JLabel jLabelLibroRemuneracion;
	private JPanel jPanelInforme2;
	private JPanel jPanelInforme;
	//private ControlEmpresaCuenta controlEmpresaCuenta = new ControlEmpresaCuenta();
	@SuppressWarnings("unused")
	private ControlTrabajadorCuenta control = new ControlTrabajadorCuenta();
	@SuppressWarnings("unused")
	private ControlTrabajador controlTrabajador = new ControlTrabajador();
	@SuppressWarnings("unused")
	private ControlIsapre controlIsapre = new ControlIsapre();
	@SuppressWarnings("unused")
	private ControlAfp controlAfp = new ControlAfp();

	private JTextField jTextFieldSexo;
	private JTextField jTextFieldAPaterno;
	private JLabel jLabelTipo;
	private JComboBox jComboBoxCentroCosto;
	private JLabel jLabelCentroCosto;
	private JComboBox jComboBoxAfp;
	private JComboBox jComboBoxIsapre;
	private JButton jButtonInp;
	private JButton jButtonCaja;
	private JButton jButtonMutual;
	private JButton jButtonAfp;
	private JButton jButtonIsapres;
	private JLabel jLabelInp;
	private JLabel jLabelCaja;
	private JLabel jLabelMutual;
	private JLabel jLabelAfp;
	private JLabel jLabelIsapre;
	private JButton jButtonLiquidacionSueldo;
	private JLabel jLabelLiquidacionSueldo;
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
	private JPanel jContentPane = null;
	private JPanel jPanel;

	/**
	 * This is the default constructor
	 */
	public GuiInforme(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600,450);
		this.setContentPane(getJContentPane());
		this.setLocation(Pantalla.centrar(this.getSize()));
		this.setResizable(false);
		this.setModal(false);
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
					.createTitledBorder("Informes"));
			jContentPane.setPreferredSize(new java.awt.Dimension(592, 440));
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
							TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.setPreferredSize(new java.awt.Dimension(582, 415));
			jPanel.add(getJPanelEmpresa(), "1, 1, 2, 1");
			jPanel.add(getJPanelFecha(), "1, 0, 2, 0");
			jPanel.add(getJPanelTrabajador(), "1, 3, 2, 3");
			jPanel.add(getJPanelInforme(), "1, 2, 2, 2");
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
		}
		return jComboBoxRut;
	}

	private JTextField getJTextFieldSexo() {
		if (jTextFieldSexo == null) {
			jTextFieldSexo = new JTextField();
			jTextFieldSexo.setEditable(false);
		}
		return jTextFieldSexo;
	}

	// AQUI SE ACTUALIZA LA EMPRESA

	private JPanel getJPanelInforme() {
		if (jPanelInforme == null) {
			jPanelInforme = new JPanel();
			CardLayout jPanelInformeLayout = new CardLayout();
			jPanelInforme.setLayout(jPanelInformeLayout);
			jPanelInforme.setBorder(BorderFactory.createTitledBorder("Informes"));
			jPanelInforme.add(getJPanelInforme2(), "jPanelInforme2");
		}
		return jPanelInforme;
	}
	
	private JPanel getJPanelInforme2() {
		if (jPanelInforme2 == null) {
			jPanelInforme2 = new JPanel();
			TableLayout jPanelInforme2Layout = new TableLayout(new double[][] {
					{ 10.0, TableLayout.PREFERRED, 71.0, 50.0, 43.0,
							TableLayout.PREFERRED, TableLayout.FILL },
					{ TableLayout.FILL, 15.0, TableLayout.FILL,
							TableLayout.FILL, TableLayout.FILL,
							TableLayout.FILL, TableLayout.FILL,
							TableLayout.FILL, TableLayout.FILL } });
			jPanelInforme2Layout.setHGap(5);
			jPanelInforme2Layout.setVGap(5);
			jPanelInforme2.setLayout(jPanelInforme2Layout);
			jPanelInforme2.add(getJLabelLibroRemuneracion(), "1, 2");
			jPanelInforme2.add(getJButtonLibroRemuneracion(), "2, 2");
			jPanelInforme2.add(getJLabelLiquidacionSueldo(), "1, 3");
			jPanelInforme2.add(getJButtonLiquidacionSueldo(), "2, 3");
			jPanelInforme2.add(getJLabelIsapre(), "1, 4");
			jPanelInforme2.add(getJLabelAfp(), "1, 5");
			jPanelInforme2.add(getJLabelMutual(), "1, 6");
			jPanelInforme2.add(getJLabelCaja(), "1, 7");
			jPanelInforme2.add(getJLabelInp(), "1, 8");
			jPanelInforme2.add(getJButtonIsapres(), "2, 4");
			jPanelInforme2.add(getJButtonAfp(), "2, 5");
			jPanelInforme2.add(getJButtonMutual(), "2, 6");
			jPanelInforme2.add(getJButtonCaja(), "2, 7");
			jPanelInforme2.add(getJButtonInp(), "2, 8");
			jPanelInforme2.add(getJComboBoxIsapre(), "3, 4, 4, 4");
			jPanelInforme2.add(getJComboBoxAfp(), "3, 5, 4, 5");
			jPanelInforme2.add(getJLabelCentroCosto(), "1, 0");
			jPanelInforme2.add(getJComboBoxCentroCosto(), "2, 0, 3, 0");
			jPanelInforme2.add(getJLabelTipo(), "5, 0");
			jPanelInforme2.add(getJComboBoxTipo(), "6, 0");
		}
		return jPanelInforme2;
	}
	
	private JLabel getJLabelLibroRemuneracion() {
		if (jLabelLibroRemuneracion == null) {
			jLabelLibroRemuneracion = new JLabel();
			jLabelLibroRemuneracion.setText("Libro de Remuneraciones : ");
		}
		return jLabelLibroRemuneracion;
	}
	
	private JButton getJButtonLibroRemuneracion() {
		if (jButtonLibroRemuneracion == null) {
			jButtonLibroRemuneracion = new JButton();
			jButtonLibroRemuneracion.setText("Crear");
			jButtonLibroRemuneracion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonLibroRemuneracionActionPerformed(evt);
				}
			});
		}
		return jButtonLibroRemuneracion;
	}
	
	private JLabel getJLabelLiquidacionSueldo() {
		if (jLabelLiquidacionSueldo == null) {
			jLabelLiquidacionSueldo = new JLabel();
			jLabelLiquidacionSueldo.setText("Liquidaciones de Sueldo : ");
		}
		return jLabelLiquidacionSueldo;
	}
	
	private JButton getJButtonLiquidacionSueldo() {
		if (jButtonLiquidacionSueldo == null) {
			jButtonLiquidacionSueldo = new JButton();
			jButtonLiquidacionSueldo.setText("Crear");
			jButtonLiquidacionSueldo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonLiquidacionSueldoActionPerformed(evt);
				}
			});
		}
		return jButtonLiquidacionSueldo;
	}

	private JLabel getJLabelIsapre() {
		if (jLabelIsapre == null) {
			jLabelIsapre = new JLabel();
			jLabelIsapre.setText("Isapres");
		}
		return jLabelIsapre;
	}
	
	private JLabel getJLabelAfp() {
		if (jLabelAfp == null) {
			jLabelAfp = new JLabel();
			jLabelAfp.setText("Afp");
		}
		return jLabelAfp;
	}
	
	private JLabel getJLabelMutual() {
		if (jLabelMutual == null) {
			jLabelMutual = new JLabel();
			jLabelMutual.setText("Mutual");
		}
		return jLabelMutual;
	}
	
	
	private JLabel getJLabelCaja() {
		if (jLabelCaja == null) {
			jLabelCaja = new JLabel();
			jLabelCaja.setText("Caja");
		}
		return jLabelCaja;
	}
	
	private JLabel getJLabelInp() {
		if (jLabelInp == null) {
			jLabelInp = new JLabel();
			jLabelInp.setText("INP");
		}
		return jLabelInp;
	}
	
	private JButton getJButtonIsapres() {
		if (jButtonIsapres == null) {
			jButtonIsapres = new JButton();
			jButtonIsapres.setText("Crear");
			jButtonIsapres.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonIsapresActionPerformed(evt);
				}
			});
		}
		return jButtonIsapres;
	}
	
	private JButton getJButtonAfp() {
		if (jButtonAfp == null) {
			jButtonAfp = new JButton();
			jButtonAfp.setText("Crear");
			jButtonAfp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonAfpActionPerformed(evt);
				}
			});
		}
		return jButtonAfp;
	}
	
	private JButton getJButtonMutual() {
		if (jButtonMutual == null) {
			jButtonMutual = new JButton();
			jButtonMutual.setText("Crear");
			jButtonMutual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonMutualActionPerformed(evt);
				}
			});
		}
		return jButtonMutual;
	}
	
	private JButton getJButtonCaja() {
		if (jButtonCaja == null) {
			jButtonCaja = new JButton();
			jButtonCaja.setText("Crear");
			jButtonCaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonCajaActionPerformed(evt);
				}
			});
		}
		return jButtonCaja;
	}
	
	private JButton getJButtonInp() {
		if (jButtonInp == null) {
			jButtonInp = new JButton();
			jButtonInp.setText("Crear");
			jButtonInp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonInpActionPerformed(evt);
				}
			});
		}
		return jButtonInp;
	}

	private void jButtonLibroRemuneracionActionPerformed(ActionEvent evt) {
		if (this.jComboBoxCentroCosto.getSelectedIndex() == 0) {
			if(!empresaCuenta.getEmpresa().isColegio()) {
				if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
					CrearInformes.crearLibroRemuneracion(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));	
				} else {
					CrearInformes.crearLibroRemuneracionFolio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));	
				}
			} else {
				if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
					CrearInformes.crearLibroRemuneracionColegio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));	
				} else {
					CrearInformes.crearLibroRemuneracionColegioFolio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));	
				}
			}
		} else {
			//SE REALIZARON MODIFICACIONES PARA QUE EL LIBRO POR CC PUEDA SER FOLIADO
			if(!empresaCuenta.getEmpresa().isColegio()) {
				if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
					CrearInformes.crearLibroRemuneracionCC(
						empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
						Fecha.fechaTexto(empresaCuenta.getMes().getFecha()),
						new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
						UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));		
				} else {
					CrearInformes.crearLibroRemuneracionCCFolio(
							empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
							Fecha.fechaTexto(empresaCuenta.getMes().getFecha()),
							new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
							UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));
				}
			} else {
				if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
					CrearInformes.crearLibroRemuneracionColegioCC(
						empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
						Fecha.fechaTexto(empresaCuenta.getMes().getFecha()),
						new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
						UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));		
				} else {
					CrearInformes.crearLibroRemuneracionColegioCCFolio(
							empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
							Fecha.fechaTexto(empresaCuenta.getMes().getFecha()),
							new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
							UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));
				}
			}
		}
	}
	
	private void jButtonLiquidacionSueldoActionPerformed(ActionEvent evt) {
		if (this.jComboBoxCentroCosto.getSelectedIndex() == 0) {
			if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
				CrearInformes.crearLiquidacionSueldo(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
			} else {
				CrearInformes.crearLiquidacionSueldoFolio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
			}
		} else {
			CrearInformes.crearLiquidacionSueldoCC(
					empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
					Fecha.fechaTexto(empresaCuenta.getMes().getFecha()),
					new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
					UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));
		}
	}
	
	private void jButtonIsapresActionPerformed(ActionEvent evt) {
		if (this.jComboBoxIsapre.getSelectedIndex()!=-1) {
			if (this.jComboBoxCentroCosto.getSelectedIndex() == 0) {
				if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
					CrearInformes.crearIsapre(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()), this.jComboBoxIsapre.getSelectedItem().toString());
				} else {
					//CrearInformes.crearIsapreFolio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()), this.jComboBoxIsapre.getSelectedItem().toString());
				}
			} else {
				CrearInformes.crearIsapreCC(
						empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
						Fecha.fechaTexto(empresaCuenta.getMes().getFecha()), 
						this.jComboBoxIsapre.getSelectedItem().toString(),
						new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
						UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));
			}	
		}	
	}
	
	private void jButtonAfpActionPerformed(ActionEvent evt) {
		if (this.jComboBoxAfp.getSelectedIndex()!=-1) {
			if (this.jComboBoxCentroCosto.getSelectedIndex() == 0) {
				if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
					CrearInformes.crearAfp(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()), this.jComboBoxAfp.getSelectedItem().toString());
				} else {
					//CrearInformes.crearAfpFolio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()), this.jComboBoxAfp.getSelectedItem().toString());
				}
			} else {
				CrearInformes.crearAfpCC(
						empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
						Fecha.fechaTexto(empresaCuenta.getMes().getFecha()), 
						this.jComboBoxAfp.getSelectedItem().toString(),
						new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
						UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));
			}
		}
	}
	
	private void jButtonMutualActionPerformed(ActionEvent evt) {
		if (this.jComboBoxCentroCosto.getSelectedIndex() == 0) {
			if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
				CrearInformes.crearMutual(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
			} else {
				//CrearInformes.crearMutualFolio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
			}
		} else {
			CrearInformes.crearMutualCC(
					empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
					Fecha.fechaTexto(empresaCuenta.getMes().getFecha()),
					new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
					UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));
		}
	}
	
	private void jButtonCajaActionPerformed(ActionEvent evt) {
		if (this.jComboBoxCentroCosto.getSelectedIndex() == 0) {
			if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
				CrearInformes.crearCaja(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));	
			} else {			
				//CrearInformes.crearCajaFolio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));	
			}
		} else {
			CrearInformes.crearCajaCC(
					empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
					Fecha.fechaTexto(empresaCuenta.getMes().getFecha()),
					new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
					UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));
		}
	}
	
	private void jButtonInpActionPerformed(ActionEvent evt) {
		if (this.jComboBoxCentroCosto.getSelectedIndex() == 0) {
			if(this.jComboBoxTipo.getSelectedItem().toString().equals("IMP. NORMAL")) {
				CrearInformes.crearInp(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
			} else {
				//CrearInformes.crearInpFolio(empresaCuenta.getEmpresa().getRutEmpresa()+" - "+Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
			}
		} else {
			CrearInformes.crearInpCC(
					empresaCuenta.getEmpresa().getRutEmpresa()+" - "+
					Fecha.fechaTexto(empresaCuenta.getMes().getFecha()),
					new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString())),
					UtilInformes.getCentroCostoNombre(this.empresaCuenta, new Long(Long.parseLong(this.jComboBoxCentroCosto.getSelectedItem().toString()))));
		}
	}
	
	private JComboBox getJComboBoxIsapre() {
		if (jComboBoxIsapre == null) {
			jComboBoxIsapre = new JComboBox();
		}
		return jComboBoxIsapre;
	}
	
	private JComboBox getJComboBoxAfp() {
		if (jComboBoxAfp == null) {
			jComboBoxAfp = new JComboBox();
		}
		return jComboBoxAfp;
	}
	
	private JLabel getJLabelCentroCosto() {
		if (jLabelCentroCosto == null) {
			jLabelCentroCosto = new JLabel();
			jLabelCentroCosto.setText("CENTRO DE COSTO :");
		}
		return jLabelCentroCosto;
	}
	
	private JComboBox getJComboBoxCentroCosto() {
		if (jComboBoxCentroCosto == null) {
			jComboBoxCentroCosto = new JComboBox();
			jComboBoxCentroCosto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxCentroCostoActionPerformed(evt);
				}
			});
		}
		return jComboBoxCentroCosto;
	}

	public void actualizar(EmpresaCuenta cuenta) {
		new CalculoInformes().calcular(cuenta);
		new CalculoInformesCC().calcular(cuenta);
		this.jComboBoxIsapre.setModel(UtilInformes.getComboBoxModelIsapre());
		if (this.jComboBoxIsapre.getItemCount() == 0) {
			this.jButtonIsapres.setEnabled(false);
			this.jComboBoxIsapre.setEnabled(false);
		} else {
			this.jButtonIsapres.setEnabled(true);
			this.jComboBoxIsapre.setEnabled(true);
		}
		this.jComboBoxAfp.setModel(UtilInformes.getComboBoxModelAfp());
		if (this.jComboBoxAfp.getItemCount() == 0) {
			this.jButtonAfp.setEnabled(false);
			this.jComboBoxAfp.setEnabled(false);
		} else {
			this.jButtonAfp.setEnabled(true);
			this.jComboBoxAfp.setEnabled(true);
		}
		this.empresaCuenta = cuenta;
		this.jComboBoxCentroCosto.setModel(UtilInformes.getComboBoxModelCentroCosto(this.empresaCuenta));
		this.jLabelFecha.setText(Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
		this.jFormattedTextFieldRutEmpresa.setText(empresaCuenta.getEmpresa().getRutEmpresa());
		this.jTextFieldRazonSocial.setText(empresaCuenta.getEmpresa().getRazonSocial());
	}
	
	private JLabel getJLabelTipo() {
		if (jLabelTipo == null) {
			jLabelTipo = new JLabel();
			jLabelTipo.setText("TIPO :   ");
		}
		return jLabelTipo;
	}
	
	private JComboBox getJComboBoxTipo() {
		if (jComboBoxTipo == null) {
			ComboBoxModel jComboBoxTipoModel = new DefaultComboBoxModel(
				new String[] { "IMP. NORMAL", "IMP. FOLIADA" });
			jComboBoxTipo = new JComboBox();
			jComboBoxTipo.setModel(jComboBoxTipoModel);
			jComboBoxTipo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxTipoActionPerformed(evt);
				}
			});
		}
		return jComboBoxTipo;
	}
	
	private void jComboBoxCentroCostoActionPerformed(ActionEvent evt) {
		//if(this.jComboBoxCentroCosto.getSelectedItem().toString().equals("TODOS")) {
			this.jComboBoxTipo.setVisible(true);
		//} else {
		//	this.jComboBoxTipo.setVisible(false);
		//}
	}
	
	private void jComboBoxTipoActionPerformed(ActionEvent evt) {
		if ( this.jComboBoxTipo.getSelectedItem().equals("IMP. NORMAL")) {
			this.jButtonAfp.setEnabled(true);
			this.jButtonCaja.setEnabled(true);
			this.jButtonInp.setEnabled(true);
			this.jButtonIsapres.setEnabled(true);
			this.jButtonLiquidacionSueldo.setEnabled(true);
			this.jButtonMutual.setEnabled(true);
			this.jComboBoxAfp.setEnabled(true);
			this.jComboBoxIsapre.setEnabled(true);
		} else {
			this.jButtonAfp.setEnabled(false);
			this.jButtonCaja.setEnabled(false);
			this.jButtonInp.setEnabled(false);
			this.jButtonIsapres.setEnabled(false);
			this.jButtonLiquidacionSueldo.setEnabled(false);
			this.jButtonMutual.setEnabled(false);
			this.jComboBoxAfp.setEnabled(false);
			this.jComboBoxIsapre.setEnabled(false);
			
		}
	}

}