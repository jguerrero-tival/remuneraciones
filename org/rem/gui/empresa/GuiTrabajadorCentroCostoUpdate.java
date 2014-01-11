
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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import org.rem.control.empresa.ControlTrabajadorCentroCosto;
import org.rem.model.TrabajadorCentroCosto;
import org.rem.model.TrabajadorCuenta;
import org.rem.util.Fecha;
import org.rem.util.Formato;
import org.rem.util.Message;
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
public class GuiTrabajadorCentroCostoUpdate extends JDialog {

	private TrabajadorCuenta trabajadorCuenta;
	private TrabajadorCentroCosto trabajadorCentroCosto;
	private ControlTrabajadorCentroCosto control = new ControlTrabajadorCentroCosto();
	private JPanel jPanelEmpresa;
	private JPanel jPanelTrabajadorCentroCosto2;
	private JTextField jTextFieldAPaterno;
	private JTextField jTextFieldCentroCosto;
	private JTextField jTextFieldDiasTrabajados;
	private JTextField jTextFieldHorasExtraordinarias;
	private JLabel jLabelHorasExtraordinarias;
	private JLabel jLabelDiasTrabajados;
	private JTextField jTextFieldMonto;
	private JLabel jLabelMonto;
	private JTextField jTextFieldRutTrabajador;
	private JTextField jTextFieldSexo;
	private JLabel jLabelSexo;
	private JTextField jTextFieldAMaterno;
	private JLabel jLabelAMaterno;
	private JLabel jLabelAPaterno;
	private JTextField jTextFieldNombres;
	private JLabel jLabelNombres;
	private JLabel jLabelRutTrabajador;
	private JPanel jPanelTrabajador2;
	private JPanel jPanelTrabajador;
	private JPanel jPanelTrabajadorCentroCosto;
	private JLabel jLabelFecha;
	private JPanel jPanelFecha2;
	private JPanel jPanelFecha;
	private JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JTextField jTextFieldHoras;
	private JLabel jLabelHoras;
	private JPanel jPanelEmpresa2;

	private JLabel jLabelNumero;

	private JLabel jLabelRespuesta;

	private JPanel jContentPane = null;

	private JPanel jPanel;

	private JPanel jPanelButton;

	private JButton jButtonUpdate;

	/**
	 * This is the default constructor
	 */
	public GuiTrabajadorCentroCostoUpdate(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 420);
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
					.createTitledBorder("Modificar Sueldo por Centro de Costo"));
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ 10.0, TableLayout.PREFERRED, TableLayout.FILL, 10.0 },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 5, 2, 5");
			jPanel.add(getJLabelRespuesta(), "1, 4, 2, 4");
			jPanel.add(getJPanelEmpresa(), "1, 1, 2, 1");
			jPanel.add(getJPanelFecha(), "1, 0, 2, 0");
			jPanel.add(getJPanelTrabajadorCentroCosto(), "1, 3, 2, 3");
			jPanel.add(getJPanelTrabajador(), "2, 2");
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

	private JLabel getJLabelNumero() {
		if (jLabelNumero == null) {
			jLabelNumero = new JLabel();
			jLabelNumero.setText("Centro de Costo : ");
		}
		return jLabelNumero;
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
			jLabelFecha.setText("la fecha ");
			jLabelFecha.setForeground(Color.RED);
			jLabelFecha.setFont(new java.awt.Font("Tahoma",1,12));
			jLabelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelFecha;
	}
	
	private JPanel getJPanelTrabajadorCentroCosto() {
		if (jPanelTrabajadorCentroCosto == null) {
			jPanelTrabajadorCentroCosto = new JPanel();
			CardLayout jPanelTrabajadorCentroCostoLayout = new CardLayout();
			jPanelTrabajadorCentroCosto.setLayout(jPanelTrabajadorCentroCostoLayout);
			jPanelTrabajadorCentroCosto.setBorder(BorderFactory.createTitledBorder("Sueldo por Centro de Costo"));
			jPanelTrabajadorCentroCosto.add(getJPanelTrabajadorCentroCosto2(), "jPanelTrabajadorCentroCosto2");
		}
		return jPanelTrabajadorCentroCosto;
	}
	
	private JPanel getJPanelTrabajadorCentroCosto2() {
		if (jPanelTrabajadorCentroCosto2 == null) {
			jPanelTrabajadorCentroCosto2 = new JPanel();
			TableLayout jPanelTrabajadorCentroCosto2Layout = new TableLayout(new double[][] {{TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL, TableLayout.FILL}, {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL}});
			jPanelTrabajadorCentroCosto2Layout.setHGap(5);
			jPanelTrabajadorCentroCosto2Layout.setVGap(5);
			jPanelTrabajadorCentroCosto2.setLayout(jPanelTrabajadorCentroCosto2Layout);
			jPanelTrabajadorCentroCosto2.add(getJLabelNumero(), "0, 0");
			jPanelTrabajadorCentroCosto2.add(getJLabelMonto(), "0, 1");
			jPanelTrabajadorCentroCosto2.add(getJTextFieldMonto(), "1, 1");
			jPanelTrabajadorCentroCosto2.add(getJLabelDiasTrabajados(), "0, 2");
			jPanelTrabajadorCentroCosto2.add(getJLabelHorasExtraordinarias(), "0, 3");
			jPanelTrabajadorCentroCosto2.add(getJTextFieldHorasExtraordinarias(), "1, 3, 3, 3");
			jPanelTrabajadorCentroCosto2.add(getJTextFieldDiasTrabajados(), "1, 2, 3, 2");
			jPanelTrabajadorCentroCosto2.add(getJTextFieldCentroCosto(), "1, 0, 3, 0");
			jPanelTrabajadorCentroCosto2.add(getJLabelHoras(), "2, 1");
			jPanelTrabajadorCentroCosto2.add(getJTextFieldHoras(), "3, 1");
		}
		return jPanelTrabajadorCentroCosto2;
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
			jPanelTrabajador2.add(getJLabelRutTrabajador(), "0,       0");
			jPanelTrabajador2.add(getJLabelNombres(), "2,       0");
			jPanelTrabajador2.add(getJTextFieldNombres(), "3,       0,       4,       0");
			jPanelTrabajador2.add(getJLabelAPaterno(), "0,       1");
			jPanelTrabajador2.add(getJTextFieldAPaterno(), "1,       1,       2,       1");
			jPanelTrabajador2.add(getJLabelAMaterno(), "3,       1");
			jPanelTrabajador2.add(getJTextFieldAMaterno(), "4,       1,       6,       1");
			jPanelTrabajador2.add(getJLabelSexo(), "5,       0");
			jPanelTrabajador2.add(getJTextFieldSexo(), "6,    0");
			jPanelTrabajador2.add(getJTextFieldRutTrabajador(), "1,    0");
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
	
	private JTextField getJTextFieldRutTrabajador() {
		if (jTextFieldRutTrabajador == null) {
			jTextFieldRutTrabajador = new JTextField();
			jTextFieldRutTrabajador.setEditable(false);
		}
		return jTextFieldRutTrabajador;
	}

	private JLabel getJLabelMonto() {
		if (jLabelMonto == null) {
			jLabelMonto = new JLabel();
			jLabelMonto.setText("Monto ($) : ");
		}
		return jLabelMonto;
	}
	
	private JTextField getJTextFieldMonto() {
		if (jTextFieldMonto == null) {
			jTextFieldMonto = new JTextField();
			jTextFieldMonto.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldMontoKeyTyped(evt);
				}
			});
		}
		return jTextFieldMonto;
	}
	
	private JLabel getJLabelDiasTrabajados() {
		if (jLabelDiasTrabajados == null) {
			jLabelDiasTrabajados = new JLabel();
			jLabelDiasTrabajados.setText("Días Trabajados : ");
		}
		return jLabelDiasTrabajados;
	}
	
	private JLabel getJLabelHorasExtraordinarias() {
		if (jLabelHorasExtraordinarias == null) {
			jLabelHorasExtraordinarias = new JLabel();
			jLabelHorasExtraordinarias.setText("Horas Extraordinarias : ");
		}
		return jLabelHorasExtraordinarias;
	}
	
	private JTextField getJTextFieldHorasExtraordinarias() {
		if (jTextFieldHorasExtraordinarias == null) {
			jTextFieldHorasExtraordinarias = new JTextField();
			jTextFieldHorasExtraordinarias.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldHorasExtraordinariasKeyTyped(evt);
				}
			});
		}
		return jTextFieldHorasExtraordinarias;
	}
	
	private JTextField getJTextFieldDiasTrabajados() {
		if (jTextFieldDiasTrabajados == null) {
			jTextFieldDiasTrabajados = new JTextField();
			jTextFieldDiasTrabajados.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldDiasTrabajadosKeyTyped(evt);
				}
			});
		}
		return jTextFieldDiasTrabajados;
	}

	
	private JTextField getJTextFieldCentroCosto() {
		if (jTextFieldCentroCosto == null) {
			jTextFieldCentroCosto = new JTextField();
			jTextFieldCentroCosto.setEditable(false);
		}
		return jTextFieldCentroCosto;
	}
	
	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (this.trabajadorCuenta!=null) {
			if (this.jTextFieldMonto.getText().trim().length() == 0) {
				Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Monto\".");
			} else if (this.jTextFieldHoras.isEditable() && this.jTextFieldHoras.getText().trim().length() == 0) {
				Message.timerLabel(this.jLabelHoras, Color.red, "Debe rellenar el campo \"Horas\".");
			} else if (this.jTextFieldDiasTrabajados.getText().trim().length() == 0) {
				Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Días Trabajados\".");
			} else if (this.jTextFieldHorasExtraordinarias.getText().trim().length() == 0) {
				Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Horas Extraordinarias\".");
			} else {
				 if(this.jTextFieldHoras.isEditable()) {
					 this.respuesta(
						control.updateTrabajadorCentroCosto(
								this.trabajadorCentroCosto,
								new Double(this.jTextFieldMonto.getText()), 
								new Long(this.jTextFieldHoras.getText()),
								new Double(this.jTextFieldDiasTrabajados.getText()), 
								new Long(this.jTextFieldHorasExtraordinarias.getText())
								));
				 } else {
					 this.respuesta(
								control.updateTrabajadorCentroCosto(
										this.trabajadorCentroCosto, 
										new Double(this.jTextFieldMonto.getText()), 
										null,
										new Double(this.jTextFieldDiasTrabajados.getText()), 
										new Long(this.jTextFieldHorasExtraordinarias.getText())
										));
				 }
			}
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se modificó exitosamente.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe en el sistema la cuenta.");
		}
	}
	
	public void actualizar(TrabajadorCuenta cuenta, TrabajadorCentroCosto trabajadorCentro) {
		this.trabajadorCuenta = cuenta;
		this.trabajadorCentroCosto = trabajadorCentro;
		this.jLabelFecha.setText(Fecha.fechaTexto(trabajadorCuenta.getEmpresaCuenta().getMes().getFecha()));
		this.jFormattedTextFieldRutEmpresa.setText(trabajadorCuenta.getEmpresaCuenta().getEmpresa().getRutEmpresa());
		this.jTextFieldRazonSocial.setText(trabajadorCuenta.getEmpresaCuenta().getEmpresa().getRazonSocial());
		this.jTextFieldRutTrabajador.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getRut());
		this.jTextFieldSexo.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getSexo());
		this.jTextFieldNombres.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getNombres());
		this.jTextFieldAPaterno.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getApellidoPaterno());
		this.jTextFieldAMaterno.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getApellidoMaterno());
		this.jTextFieldCentroCosto.setText(this.trabajadorCentroCosto.getCentroCosto().getNumero().toString());
		this.jTextFieldMonto.setText(this.trabajadorCentroCosto.getMonto().toString());
		if(this.trabajadorCentroCosto.getHoras()!=null) {
			this.jTextFieldHoras.setText(this.trabajadorCentroCosto.getHoras().toString());
			this.jTextFieldHoras.setEditable(true);
		} else {
			this.jTextFieldHoras.setEditable(false);
		}
		this.jTextFieldDiasTrabajados.setText(this.trabajadorCentroCosto.getDiasTrabajados().toString());
		this.jTextFieldHorasExtraordinarias.setText(this.trabajadorCentroCosto.getHorasExtraordinarias().toString());
	}
	
	private void jTextFieldMontoKeyTyped(KeyEvent evt) {
		Formato.formatLong(evt);
	}
	
	private void jTextFieldDiasTrabajadosKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldDiasTrabajados.getText());
	}
	
	private void jTextFieldHorasExtraordinariasKeyTyped(KeyEvent evt) {
		Formato.formatLong(evt);
	}
	
	private JLabel getJLabelHoras() {
		if(jLabelHoras == null) {
			jLabelHoras = new JLabel();
			jLabelHoras.setText("Horas: ");
		}
		return jLabelHoras;
	}
	
	private JTextField getJTextFieldHoras() {
		if(jTextFieldHoras == null) {
			jTextFieldHoras = new JTextField();
		}
		return jTextFieldHoras;
	}

}