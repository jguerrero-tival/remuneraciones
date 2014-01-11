package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;

import org.rem.control.empresa.ControlTrabajador;
import org.rem.model.Direccion;
import org.rem.model.Empresa;
import org.rem.model.Trabajador;
import org.rem.model.Persona;
import org.rem.util.Fecha;
import org.rem.util.Formato;
import org.rem.util.Message;
import org.rem.util.Palabra;
import org.rem.util.Pantalla;

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

@SuppressWarnings("serial")
public class GuiTrabajadorUpdate extends JDialog {

	private Empresa empresa;
	private Trabajador trabajador;
	private ControlTrabajador control = new ControlTrabajador();
	JFormattedTextField formatSpinner;
	
	private JLabel jLabelPoblacion;
	private JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JTextField jTextFieldRazonSocial;
	private JFormattedTextField jFormattedTextFieldRutTrabajador;
	private JTextField jTextFieldAPaterno;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JPanel jPanelEmpresa2;
	private JPanel jPanelEmpresa;
	private JSpinner jSpinnerAnno;
	private JComboBox jComboBoxDia;
	private JComboBox jComboBoxMes;
	private JLabel jLabelIngreso;
	private JPanel jPanelFecha2;
	private JPanel jPanelFecha;
	private JComboBox jComboBoxSexo;
	private JLabel jLabelSexo;
	private JTextField jTextFieldAMaterno;
	private JTextField jTextFieldNombres;
	private JLabel jLabelAMaterno;
	private JLabel jLabelAPaterno;
	private JLabel jLabelNombres;
	private JLabel jLabelRutTrabajador;
	private JTextField jTextFieldCerro;
	private JTextField jTextFieldPoblacion;
	private JTextField jTextFieldCiudad;
	private JTextField jTextFieldComuna;
	private JTextField jTextFieldNumero;
	private JTextField jTextFieldCalle;
	private JComboBox jComboBoxRegion;
	private JLabel jLabelRegion;
	private JLabel jLabelCerro;
	private JLabel jLabelCiudad;
	private JLabel jLabelComuna;
	private JLabel jLabelNumero;
	private JLabel jLabelCalle;
	private JPanel jPanelTrabajador2;
	private JPanel jPanelDireccion2;
	private JPanel jPanelTrabajador;
	private JPanel jPanelDireccion;
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonUpdate;

	/**
	 * This is the default constructor
	 */
	public GuiTrabajadorUpdate(JFrame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700, 410);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Modificar Trabajador"));
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ 10.0, TableLayout.FILL, 10.0 },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 5");
			jPanel.add(getJLabelRespuesta(), "1, 4");
			jPanel.add(getJPanelDireccion(), "1, 2");
			jPanel.add(getJPanelTrabajador(), "1, 1");
			jPanel.add(getJPanelFecha(), "1, 3");
			jPanel.add(getJPanelEmpresa(), "1, 0");
		}
		return jPanel;
	}

	private JLabel getJLabelRespuesta() {
		if (jLabelRespuesta == null) {
			jLabelRespuesta = new JLabel();
			jLabelRespuesta.setText("...");
			jLabelRespuesta.setHorizontalAlignment(SwingConstants.CENTER);
			jLabelRespuesta.setBorder(BorderFactory.createBevelBorder(BevelBorder.LOWERED));
		}
		return jLabelRespuesta;
	}
	
	private JPanel getJPanelButton() {
		if (jPanelButton == null) {
			jPanelButton = new JPanel();
			jPanelButton.add(getJButtonUpdate());
		}
		return jPanelButton;
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

	private JPanel getJPanelDireccion() {
		if (jPanelDireccion == null) {
			jPanelDireccion = new JPanel();
			CardLayout jPanelDireccionLayout = new CardLayout();
			jPanelDireccion.setLayout(jPanelDireccionLayout);
			jPanelDireccion.setBorder(BorderFactory.createTitledBorder("Dirección"));
			jPanelDireccion.add(getJPanelDireccion2(), "jPanelDireccion2");
		}
		return jPanelDireccion;
	}
	
	private JPanel getJPanelTrabajador() {
		if (jPanelTrabajador == null) {
			jPanelTrabajador = new JPanel();
			CardLayout jPanelTrabajadorLayout = new CardLayout();
			jPanelTrabajador.setLayout(jPanelTrabajadorLayout);
			jPanelTrabajador.setBorder(BorderFactory.createTitledBorder(null, "Trabajador", TitledBorder.LEADING, TitledBorder.TOP));
			jPanelTrabajador.add(getJPanelTrabajador2(), "jPanelTrabajador2");
		}
		return jPanelTrabajador;
	}

	private JPanel getJPanelDireccion2() {
		if (jPanelDireccion2 == null) {
			jPanelDireccion2 = new JPanel();
			TableLayout jPanelDireccion2Layout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED, 160.0, TableLayout.PREFERRED,
								139.0, TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.PREFERRED } });
			jPanelDireccion2Layout.setHGap(5);
			jPanelDireccion2Layout.setVGap(5);
			jPanelDireccion2.setLayout(jPanelDireccion2Layout);
			jPanelDireccion2.add(getJLabelCalle(), "0, 0");
			jPanelDireccion2.add(getJLabelNumero(), "4, 0");
			jPanelDireccion2.add(getJLabelComuna(), "2, 1");
			jPanelDireccion2.add(getJLabelCiudad(), "0, 1");
			jPanelDireccion2.add(getJLabelPoblacion(), "0, 2");
			jPanelDireccion2.add(getJLabelCerro(), "2, 2");
			jPanelDireccion2.add(getJLabelRegion(), "4, 1");
			jPanelDireccion2.add(getJComboBoxRegion(), "5, 1");
			jPanelDireccion2.add(getJTextFieldCalle(), "1, 0, 3, 0");
			jPanelDireccion2.add(getJTextFieldNumero(), "5, 0");
			jPanelDireccion2.add(getJTextFieldComuna(), "3, 1");
			jPanelDireccion2.add(getJTextFieldCiudad(), "1, 1");
			jPanelDireccion2.add(getJTextFieldPoblacion(), "1, 2");
			jPanelDireccion2.add(getJTextFieldCerro(), "3, 2");
		}
		return jPanelDireccion2;
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
			jPanelTrabajador2.add(getJLabelRutTrabajador(), "0, 0");
			jPanelTrabajador2.add(getJLabelNombres(), "2, 0");
			jPanelTrabajador2.add(getJTextFieldNombres(), "3, 0, 4, 0");
			jPanelTrabajador2.add(getJLabelAPaterno(), "0, 1");
			jPanelTrabajador2.add(getJTextFieldAPaterno(), "1, 1, 2, 1");
			jPanelTrabajador2.add(getJLabelAMaterno(), "3, 1");
			jPanelTrabajador2.add(getJTextFieldAMaterno(), "4, 1, 6, 1");
			jPanelTrabajador2.add(getJFormattedTextFieldRutTrabajador(), "1, 0");
			jPanelTrabajador2.add(getJLabelSexo(), "5, 0");
			jPanelTrabajador2.add(getJComboBoxSexo(), "6, 0");
		}
		return jPanelTrabajador2;
	}

	private JLabel getJLabelCalle() {
		if (jLabelCalle == null) {
			jLabelCalle = new JLabel();
			jLabelCalle.setText("Calle : ");
		}
		return jLabelCalle;
	}
	
	private JLabel getJLabelNumero() {
		if (jLabelNumero == null) {
			jLabelNumero = new JLabel();
			jLabelNumero.setText("Nº : ");
		}
		return jLabelNumero;
	}
	
	private JLabel getJLabelComuna() {
		if (jLabelComuna == null) {
			jLabelComuna = new JLabel();
			jLabelComuna.setText("Comuna : ");
		}
		return jLabelComuna;
	}
	
	private JLabel getJLabelCiudad() {
		if (jLabelCiudad == null) {
			jLabelCiudad = new JLabel();
			jLabelCiudad.setText("Ciudad :");
		}
		return jLabelCiudad;
	}
	
	private JLabel getJLabelPoblacion() {
		if (jLabelPoblacion == null) {
			jLabelPoblacion = new JLabel();
			jLabelPoblacion.setText("Poblacion : ");
		}
		return jLabelPoblacion;
	}
	
	private JLabel getJLabelCerro() {
		if (jLabelCerro == null) {
			jLabelCerro = new JLabel();
			jLabelCerro.setText("Cerro : ");
		}
		return jLabelCerro;
	}
	
	private JLabel getJLabelRegion() {
		if (jLabelRegion == null) {
			jLabelRegion = new JLabel();
			jLabelRegion.setText("Región : ");
		}
		return jLabelRegion;
	}
	
	private JComboBox getJComboBoxRegion() {
		if (jComboBoxRegion == null) {
			jComboBoxRegion = new JComboBox();
			jComboBoxRegion.setModel(Palabra.getComboBoxModelRegiones());
		}
		return jComboBoxRegion;
	}
	
	private JTextField getJTextFieldCalle() {
		if (jTextFieldCalle == null) {
			jTextFieldCalle = new JTextField();
			jTextFieldCalle.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldCalleKeyTyped(evt);
				}
			});
		}
		return jTextFieldCalle;
	}
	
	private JTextField getJTextFieldNumero() {
		if (jTextFieldNumero == null) {
			jTextFieldNumero = new JTextField();
			jTextFieldNumero.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldNumeroKeyTyped(evt);
				}
			});
		}
		return jTextFieldNumero;
	}
	
	private JTextField getJTextFieldComuna() {
		if (jTextFieldComuna == null) {
			jTextFieldComuna = new JTextField();
			jTextFieldComuna.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldComunaKeyTyped(evt);
				}
			});
		}
		return jTextFieldComuna;
	}
	
	private JTextField getJTextFieldCiudad() {
		if (jTextFieldCiudad == null) {
			jTextFieldCiudad = new JTextField();
			jTextFieldCiudad.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldCiudadKeyTyped(evt);
				}
			});
		}
		return jTextFieldCiudad;
	}
	
	private JTextField getJTextFieldPoblacion() {
		if (jTextFieldPoblacion == null) {
			jTextFieldPoblacion = new JTextField();
			jTextFieldPoblacion.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldPoblacionKeyTyped(evt);
				}
			});
		}
		return jTextFieldPoblacion;
	}
	
	private JTextField getJTextFieldCerro() {
		if (jTextFieldCerro == null) {
			jTextFieldCerro = new JTextField();
			jTextFieldCerro.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldCerroKeyTyped(evt);
				}
			});
		}
		return jTextFieldCerro;
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
	
	private JLabel getJLabelAPaterno() {
		if (jLabelAPaterno == null) {
			jLabelAPaterno = new JLabel();
			jLabelAPaterno.setText("A. Paterno : ");
		}
		return jLabelAPaterno;
	}
	
	private JLabel getJLabelAMaterno() {
		if (jLabelAMaterno == null) {
			jLabelAMaterno = new JLabel();
			jLabelAMaterno.setText("A. Materno : ");
		}
		return jLabelAMaterno;
	}

	private JTextField getJTextFieldAPaterno() {
		if (jTextFieldAPaterno == null) {
			jTextFieldAPaterno = new JTextField();
			jTextFieldAPaterno.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldAPaternoKeyTyped(evt);
				}
			});
		}
		return jTextFieldAPaterno;
	}
	
	private JTextField getJTextFieldNombres() {
		if (jTextFieldNombres == null) {
			jTextFieldNombres = new JTextField();
			jTextFieldNombres.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldNombresKeyTyped(evt);
				}
			});
		}
		return jTextFieldNombres;
	}
	
	private JTextField getJTextFieldAMaterno() {
		if (jTextFieldAMaterno == null) {
			jTextFieldAMaterno = new JTextField();
			jTextFieldAMaterno.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldAMaternoKeyTyped(evt);
				}
			});
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
	
	private JComboBox getJComboBoxSexo() {
		if (jComboBoxSexo == null) {
			jComboBoxSexo = new JComboBox();
			jComboBoxSexo.setModel(Palabra.getComboBoxModelSexo());
		}
		return jComboBoxSexo;
	}
	
	private JPanel getJPanelFecha() {
		if (jPanelFecha == null) {
			jPanelFecha = new JPanel();
			CardLayout jPanelFechaLayout = new CardLayout();
			jPanelFecha.setLayout(jPanelFechaLayout);
			jPanelFecha.setBorder(BorderFactory.createTitledBorder("Fechas"));
			jPanelFecha.add(getJPanelFecha2(), "jPanelFecha2");
		}
		return jPanelFecha;
	}
	
	private JPanel getJPanelFecha2() {
		if (jPanelFecha2 == null) {
			jPanelFecha2 = new JPanel();
			TableLayout jPanelFecha2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, 50.0, 136.0, 56.0,
							TableLayout.FILL }, { TableLayout.FILL } });
			jPanelFecha2Layout.setHGap(5);
			jPanelFecha2Layout.setVGap(5);
			jPanelFecha2.setLayout(jPanelFecha2Layout);
			jPanelFecha2.add(getJLabelIngreso(), "0, 0");
			jPanelFecha2.add(getJComboBoxMes(), "2, 0");
			jPanelFecha2.add(getJComboBoxDia(), "3, 0");
			jPanelFecha2.add(getJSpinnerAnno(), "1,  0");
		}
		return jPanelFecha2;
	}
	
	private JLabel getJLabelIngreso() {
		if (jLabelIngreso == null) {
			jLabelIngreso = new JLabel();
			jLabelIngreso.setText("Ingreso : ");
		}
		return jLabelIngreso;
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
					{ TableLayout.PREFERRED, 118.0, TableLayout.PREFERRED,
							TableLayout.FILL }, { TableLayout.PREFERRED } });
			jPanelEmpresa2Layout.setHGap(5);
			jPanelEmpresa2Layout.setVGap(5);
			jPanelEmpresa2.setLayout(jPanelEmpresa2Layout);
			jPanelEmpresa2.add(getJLabelRutEmpresa(), "0,    0");
			jPanelEmpresa2.add(getJLabelRazonSocial(), "2,    0");
			jPanelEmpresa2.add(getJTextFieldRazonSocial(), "3,    0");
			jPanelEmpresa2.add(getJFormattedTextFieldRutEmpresa(), "1,    0");
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
	
	private JComboBox getJComboBoxMes() {
		if (jComboBoxMes == null) {
			jComboBoxMes = new JComboBox();
			jComboBoxMes.setModel(Palabra.getComboBoxModelMeses());
			jComboBoxMes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxMesActionPerformed(evt);
				}
			});
		}
		return jComboBoxMes;
	}
	
	private JComboBox getJComboBoxDia() {
		if (jComboBoxDia == null) {
			jComboBoxDia = new JComboBox();
		}
		return jComboBoxDia;
	}
	
	private JSpinner getJSpinnerAnno() {
		if (jSpinnerAnno == null) {
			jSpinnerAnno = new JSpinner();
			jSpinnerAnno.setModel(new SpinnerNumberModel(new Long(2006), null, null, new Long(1)));
			jSpinnerAnno.setPreferredSize(new java.awt.Dimension(75, 20));
			jSpinnerAnno.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent evt) {
					jSpinnerAnnoStateChanged(evt);
				}
			});
			 formatSpinner = ((JSpinner.DefaultEditor)jSpinnerAnno.getEditor()).getTextField();
			 formatSpinner.setEditable(false);
		}
		return jSpinnerAnno;
	}
	
	private JFormattedTextField getJFormattedTextFieldRutTrabajador() {
		if (jFormattedTextFieldRutTrabajador == null) {
			jFormattedTextFieldRutTrabajador = new JFormattedTextField(Formato.getMaskRut());
			jFormattedTextFieldRutTrabajador.setEditable(false);
		}
		return jFormattedTextFieldRutTrabajador;
	}

	private void jTextFieldCalleKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldNumeroKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldCiudadKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldComunaKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldPoblacionKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldAMaternoKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldCerroKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldNombresKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldAPaternoKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}

	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (this.jFormattedTextFieldRutTrabajador.getText().equals("__.___.___-_")) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Rut\".");
		} else if(this.jTextFieldNombres.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Nombres\".");
		} else if (this.jComboBoxSexo.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar un \"Sexo\".");			
		} else if(this.jTextFieldAPaterno.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"A. Paterno\".");			
		} else if(this.jTextFieldAMaterno.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"A. Materno\".");			
		} else{
			Direccion direccion = new Direccion(
					this.jTextFieldCalle.getText(),
					this.jTextFieldNumero.getText(),
					this.jTextFieldCiudad.getText(),
					this.jTextFieldComuna.getText(),
					this.jComboBoxRegion.getSelectedItem().toString(),
					this.jTextFieldPoblacion.getText(),
					this.jTextFieldCerro.getText());
			Persona datosPersonales = new Persona(
					this.jFormattedTextFieldRutTrabajador.getText(),
					this.jTextFieldNombres.getText(),
					this.jTextFieldAPaterno.getText(),
					this.jTextFieldAMaterno.getText(),
					this.jComboBoxSexo.getSelectedItem().toString());
			this.respuesta(control.updateTrabajador(
					this.empresa,
					this.trabajador,
					datosPersonales,
					direccion,
					Fecha.createDate(
							(Long) this.jSpinnerAnno.getValue(), 
							this.jComboBoxMes.getSelectedItem().toString(), 
							new Long(this.jComboBoxDia.getSelectedItem().toString())),
					null));
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se agregó exitosamente.");
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Ya existe el registro en el sistema.");
		} else if (respuesta == control.respExitoBloqueado) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro estaba eliminado, se recupero exitosamente.");
		} else if (respuesta == control.respNoExisteEmpresa) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe la empresa.");
		}
	}
	
	public void actualizar(Empresa emp, Trabajador trab) {
		this.empresa = emp;
		this.trabajador = trab;
		this.jFormattedTextFieldRutEmpresa.setText(empresa.getRutEmpresa());
		this.jFormattedTextFieldRutTrabajador.setText(trabajador.getDatosPersonales().getRut());
		this.jTextFieldRazonSocial.setText(empresa.getRazonSocial());
		this.jTextFieldNombres.setText(trabajador.getDatosPersonales().getNombres());
		this.jTextFieldAPaterno.setText(trabajador.getDatosPersonales().getApellidoPaterno());
		this.jTextFieldAMaterno.setText(trabajador.getDatosPersonales().getApellidoMaterno());
		this.jComboBoxSexo.setSelectedItem(trabajador.getDatosPersonales().getSexo());
		this.jTextFieldCalle.setText(trabajador.getDireccion().getCalle());
		this.jTextFieldNumero.setText(trabajador.getDireccion().getNumero());
		this.jTextFieldCiudad.setText(trabajador.getDireccion().getCiudad());
		this.jTextFieldComuna.setText(trabajador.getDireccion().getComuna());
		this.jComboBoxRegion.setSelectedItem(trabajador.getDireccion().getRegion());
		this.jTextFieldPoblacion.setText(trabajador.getDireccion().getPoblacion());
		this.jTextFieldCerro.setText(trabajador.getDireccion().getCerro());
		((JSpinner.DefaultEditor)jSpinnerAnno.getEditor()).getTextField().setText(Fecha.getYear(trabajador.getFechaIngreso()).toString());
		this.jComboBoxMes.setSelectedItem(Fecha.getMonthString(trabajador.getFechaIngreso()));
		this.jComboBoxDia.setSelectedItem(Fecha.getDay(trabajador.getFechaIngreso()).toString());
	}
				
	private void jComboBoxMesActionPerformed(ActionEvent evt) {
		this.actualizarDia();
	}

	private void actualizarDia() {
		if (this.jComboBoxMes.getSelectedIndex()!=-1) {
			this.jComboBoxDia.setModel(
					Palabra.getComboBoxModelDias(
							(Long) this.jSpinnerAnno.getValue(), 
							this.jComboBoxMes.getSelectedItem().toString()));
		}
	}
	
	private void jSpinnerAnnoStateChanged(ChangeEvent evt) {
		this.actualizarDia();
	}

}