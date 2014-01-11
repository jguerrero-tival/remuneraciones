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
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import org.rem.control.empresa.ControlEmpresa;
import org.rem.model.Direccion;
import org.rem.model.Empresa;
import org.rem.model.Persona;
import org.rem.util.Formato;
import org.rem.util.Message;
import org.rem.util.Palabra;
import org.rem.util.Pantalla;
import org.rem.util.Rut;

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
public class GuiEmpresaUpdate extends JDialog {

	private Empresa empresa;
	private ControlEmpresa control = new ControlEmpresa();
	private JPanel jPanelEmpresa;
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabelPoblacion;
	private JFormattedTextField jFormattedTextFieldRutRepresentante;
	private JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JTextField jTextFieldAPaterno;
	private JTextField jTextFieldAMaterno;
	private JTextField jTextFieldNombres;
	private JLabel jLabelAMaterno;
	private JLabel jLabelAPaterno;
	private JLabel jLabelNombres;
	private JLabel jLabelRutRepresentante;
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
	private JComboBox jComboBoxColegio;
	private JLabel jLabelColegio;
	private JTextField jTextFieldActividadEconomica;
	private JTextField jTextFieldMail;
	private JTextField jTextFieldFono;
	private JLabel jLabelActividadEconomica;
	private JLabel jLabelMail;
	private JLabel jLabelFono;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JPanel jPanelRepresentante2;
	private JPanel jPanelDireccion2;
	private JPanel jPanelEmpresa2;
	private JPanel jPanelRepresentante;
	private JPanel jPanelDireccion;
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonUpdate;

	/**
	 * This is the default constructor
	 */
	public GuiEmpresaUpdate(JFrame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700, 405);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Modificar Empresa"));
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
							TableLayout.PREFERRED } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 4");
			jPanel.add(getJLabelRespuesta(), "1, 3");
			jPanel.add(getJPanelEmpresa(), "1, 0");
			jPanel.add(getJPanelDireccion(), "1, 1");
			jPanel.add(getJPanelRepresentante(), "1, 2");
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

	private JPanel getJPanelEmpresa() {
		if (jPanelEmpresa == null) {
			jPanelEmpresa = new JPanel();
			CardLayout jPanelEmpresaLayout = new CardLayout();
			jPanelEmpresa.setLayout(jPanelEmpresaLayout);
			jPanelEmpresa.setBorder(BorderFactory.createTitledBorder("Empresa"));
			jPanelEmpresa.add(getJPanelEmpresa2(), "jPanelEmpresa2");
		}
		return jPanelEmpresa;
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
	
	private JPanel getJPanelRepresentante() {
		if (jPanelRepresentante == null) {
			jPanelRepresentante = new JPanel();
			CardLayout jPanelRepresentanteLayout = new CardLayout();
			jPanelRepresentante.setLayout(jPanelRepresentanteLayout);
			jPanelRepresentante.setBorder(BorderFactory.createTitledBorder(null, "Representante", TitledBorder.LEADING, TitledBorder.TOP));
			jPanelRepresentante.add(getJPanelRepresentante2(), "jPanelRepresentante2");
		}
		return jPanelRepresentante;
	}

	private JPanel getJPanelEmpresa2() {
		if (jPanelEmpresa2 == null) {
			jPanelEmpresa2 = new JPanel();
			TableLayout jPanelEmpresa2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, 118.0, TableLayout.PREFERRED,
							TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED } });
			jPanelEmpresa2Layout.setHGap(5);
			jPanelEmpresa2Layout.setVGap(5);
			jPanelEmpresa2.setLayout(jPanelEmpresa2Layout);
			jPanelEmpresa2.add(getJLabelRutEmpresa(), "0, 0");
			jPanelEmpresa2.add(getJLabelRazonSocial(), "2, 0");
			jPanelEmpresa2.add(getJLabelFono(), "0, 2");
			jPanelEmpresa2.add(getJLabelMail(), "2, 2");
			jPanelEmpresa2.add(getJLabelActividadEconomica(), "2, 1");
			jPanelEmpresa2.add(getJTextFieldRazonSocial(), "3, 0");
			jPanelEmpresa2.add(getJTextFieldFono(), "1, 2");
			jPanelEmpresa2.add(getJTextFieldMail(), "3, 2");
			jPanelEmpresa2.add(getJTextFieldActividadEconomica(), "3, 1");
			jPanelEmpresa2.add(getJLabelColegio(), "0, 1");
			jPanelEmpresa2.add(getJComboBoxColegio(), "1, 1");
			jPanelEmpresa2.add(getJFormattedTextFieldRutEmpresa(), "1, 0");
		}
		return jPanelEmpresa2;
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
	
	private JPanel getJPanelRepresentante2() {
		if (jPanelRepresentante2 == null) {
			jPanelRepresentante2 = new JPanel();
			TableLayout jPanelRepresentante2Layout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED, 129.0, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelRepresentante2Layout.setHGap(5);
			jPanelRepresentante2Layout.setVGap(5);
			jPanelRepresentante2.setLayout(jPanelRepresentante2Layout);
			jPanelRepresentante2.add(getJLabelRutRepresentante(), "0, 0");
			jPanelRepresentante2.add(getJLabelNombres(), "2, 0");
			jPanelRepresentante2.add(getJTextFieldNombres(), "3, 0, 4, 0");
			jPanelRepresentante2.add(getJLabelAPaterno(), "0, 1");
			jPanelRepresentante2.add(getJTextFieldAPaterno(), "1, 1, 2, 1");
			jPanelRepresentante2.add(getJLabelAMaterno(), "3, 1");
			jPanelRepresentante2.add(getJTextFieldAMaterno(), "4, 1");
			jPanelRepresentante2.add(getJFormattedTextFieldRutRepresentante(), "1, 0");
		}
		return jPanelRepresentante2;
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
	
	private JLabel getJLabelFono() {
		if (jLabelFono == null) {
			jLabelFono = new JLabel();
			jLabelFono.setText("Fono : ");
		}
		return jLabelFono;
	}
	
	private JLabel getJLabelMail() {
		if (jLabelMail == null) {
			jLabelMail = new JLabel();
			jLabelMail.setText("e-mail : ");
		}
		return jLabelMail;
	}
	
	private JLabel getJLabelActividadEconomica() {
		if (jLabelActividadEconomica == null) {
			jLabelActividadEconomica = new JLabel();
			jLabelActividadEconomica.setText("Actividad Económica : ");
		}
		return jLabelActividadEconomica;
	}

	private JTextField getJTextFieldRazonSocial() {
		if (jTextFieldRazonSocial == null) {
			jTextFieldRazonSocial = new JTextField();
			jTextFieldRazonSocial.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldRazonSocialKeyTyped(evt);
				}
			});
		}
		return jTextFieldRazonSocial;
	}
	
	private JTextField getJTextFieldFono() {
		if (jTextFieldFono == null) {
			jTextFieldFono = new JTextField();
			jTextFieldFono.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldFonoKeyTyped(evt);
				}
			});
		}
		return jTextFieldFono;
	}
	
	private JTextField getJTextFieldMail() {
		if (jTextFieldMail == null) {
			jTextFieldMail = new JTextField();
			jTextFieldMail.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldMailKeyTyped(evt);
				}
			});
		}
		return jTextFieldMail;
	}
	
	private JTextField getJTextFieldActividadEconomica() {
		if (jTextFieldActividadEconomica == null) {
			jTextFieldActividadEconomica = new JTextField();
			jTextFieldActividadEconomica.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldActividadEconomicaKeyTyped(evt);
				}
			});
		}
		return jTextFieldActividadEconomica;
	}
	
	private JLabel getJLabelColegio() {
		if (jLabelColegio == null) {
			jLabelColegio = new JLabel();
			jLabelColegio.setText("Colegio");
		}
		return jLabelColegio;
	}
	
	private JComboBox getJComboBoxColegio() {
		if (jComboBoxColegio == null) {
			jComboBoxColegio = new JComboBox();
			jComboBoxColegio.setModel(Palabra.getComboBoxModelYesNo());
		}
		return jComboBoxColegio;
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
	
	private JLabel getJLabelRutRepresentante() {
		if (jLabelRutRepresentante == null) {
			jLabelRutRepresentante = new JLabel();
			jLabelRutRepresentante.setText("R.U.T. : ");
		}
		return jLabelRutRepresentante;
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

	private JFormattedTextField getJFormattedTextFieldRutEmpresa() {
		if (jFormattedTextFieldRutEmpresa == null) {
			jFormattedTextFieldRutEmpresa = new JFormattedTextField(Formato.getMaskRut());
			jFormattedTextFieldRutEmpresa.setEditable(false);
			jFormattedTextFieldRutEmpresa.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jFormattedTextFieldRutEmpresaKeyTyped(evt);
				}
			});
		}
		return jFormattedTextFieldRutEmpresa;
	}
	
	private JFormattedTextField getJFormattedTextFieldRutRepresentante() {
		if (jFormattedTextFieldRutRepresentante == null) {
			jFormattedTextFieldRutRepresentante = new JFormattedTextField(Formato.getMaskRut());
			jFormattedTextFieldRutRepresentante
				.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jFormattedTextFieldRutRepresentanteKeyTyped(evt);
				}
				});
		}
		return jFormattedTextFieldRutRepresentante;
	}

	private void jTextFieldRazonSocialKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldActividadEconomicaKeyTyped(KeyEvent evt) {
		Formato.formatLong(evt);
	}
	
	private void jTextFieldMailKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldFonoKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
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
	
	private void jFormattedTextFieldRutEmpresaKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jFormattedTextFieldRutRepresentanteKeyTyped(KeyEvent evt) {
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
		if(this.jTextFieldRazonSocial.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Razón Social\".");			
		}
		else if(this.jComboBoxColegio.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Colegio\".");			
		}
		else if(this.jTextFieldActividadEconomica.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Actividad Económica\".");			
		}
		else if (this.jFormattedTextFieldRutRepresentante.getText().equals("__.___.___-_")) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Rut (Representante)\".");
		} else if (!Rut.verificaRut(this.jFormattedTextFieldRutRepresentante.getText())) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El campo \"Rut (Representante)\" no es correcto.");
		}
		else if(this.jTextFieldNombres.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Nombres (Representante)\".");			
		}
		else if(this.jTextFieldAPaterno.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"A. Paterno (Representante)\".");			
		}
		else if(this.jTextFieldAMaterno.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"A. Materno (Representante)\".");			
		}
		else{
			Direccion direccion = new Direccion(
					this.jTextFieldCalle.getText(),
					this.jTextFieldNumero.getText(),
					this.jTextFieldCiudad.getText(),
					this.jTextFieldComuna.getText(),
					this.jComboBoxRegion.getSelectedItem().toString(),
					this.jTextFieldPoblacion.getText(),
					this.jTextFieldCerro.getText());
			Persona representante = new Persona(
					this.jFormattedTextFieldRutRepresentante.getText(),
					this.jTextFieldNombres.getText(),
					this.jTextFieldAPaterno.getText(),
					this.jTextFieldAMaterno.getText());
			this.respuesta(control.updateEmpresa(
					this.empresa,
					this.jTextFieldRazonSocial.getText(),
					Palabra.setBooleanString(this.jComboBoxColegio.getSelectedItem().toString()),
					this.jTextFieldActividadEconomica.getText(),
					this.jTextFieldFono.getText(),
					this.jTextFieldMail.getText(),
					direccion,
					representante));
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se modifico exitosamente.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el registro en el sistema.");
		} 
	}
	
	public void actualizar(Empresa emp) {
		this.empresa = emp;
		this.jFormattedTextFieldRutEmpresa.setText(empresa.getRutEmpresa());
		this.jTextFieldRazonSocial.setText(empresa.getRazonSocial());
		this.jComboBoxColegio.setSelectedItem(Palabra.getBooleanString(empresa.isColegio()));
		this.jTextFieldActividadEconomica.setText(empresa.getActividad());
		this.jTextFieldFono.setText(empresa.getFono());
		this.jTextFieldMail.setText(empresa.getEmail());
		this.jTextFieldCalle.setText(empresa.getDireccion().getCalle());
		this.jTextFieldNumero.setText(empresa.getDireccion().getNumero());
		this.jTextFieldCiudad.setText(empresa.getDireccion().getCiudad());
		this.jTextFieldComuna.setText(empresa.getDireccion().getComuna());
		this.jComboBoxRegion.setSelectedItem(empresa.getDireccion().getRegion());
		this.jTextFieldPoblacion.setText(empresa.getDireccion().getPoblacion());
		this.jTextFieldCerro.setText(empresa.getDireccion().getCerro());
		this.jFormattedTextFieldRutRepresentante.setText(empresa.getRepresentante().getRut());
		this.jTextFieldNombres.setText(empresa.getRepresentante().getNombres());
		this.jTextFieldAPaterno.setText(empresa.getRepresentante().getApellidoPaterno());
		this.jTextFieldAMaterno.setText(empresa.getRepresentante().getApellidoMaterno());
	}

}