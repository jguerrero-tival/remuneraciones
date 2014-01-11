package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

import org.rem.control.empresa.ControlTrabajador;
import org.rem.model.Empresa;
import org.rem.model.Trabajador;
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
public class GuiTrabajadorRemove extends JDialog {

	private Empresa empresa;
	private Trabajador trabajador;
	private ControlTrabajador control = new ControlTrabajador();
	private JPanel jPanelEmpresa;
	private JTextField jTextFieldAPaterno;
	private JComboBox jComboBoxSexo;
	private JLabel jLabelSexo;
	private JFormattedTextField jFormattedTextFieldRutTrabajador;
	private JTextField jTextFieldAMaterno;
	private JLabel jLabelAMaterno;
	private JLabel jLabelAPaterno;
	private JTextField jTextFieldNombres;
	private JLabel jLabelNombres;
	private JLabel jLabelRutTrabajador;
	private JPanel jPanelTrabajador2;
	private JPanel jPanelTrabajador;
	private JTextField jTextFieldRazonSocial;
	private JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JPanel jPanelEmpresa2;
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonRemove;

	/**
	 * This is the default constructor
	 */
	public GuiTrabajadorRemove(JFrame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(700, 250);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Eliminar Trabajador"));
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
			jPanel.add(getJPanelButton(), "1, 3");
			jPanel.add(getJLabelRespuesta(), "1, 2");
			jPanel.add(getJPanelEmpresa(), "1, 0");
			jPanel.add(getJPanelTrabajador(), "1, 1");
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
			jPanelButton.add(getJButtonRemove());
		}
		return jPanelButton;
	}
	
	private JButton getJButtonRemove() {
		if (jButtonRemove == null) {
			jButtonRemove = new JButton();
			jButtonRemove.setText("Eliminar");
			jButtonRemove.setToolTipText("- El proceso de eliminación de una \"Trabajador\" no implica la eliminación de las cuentas creadas.\n- El Trabajador será desabilitado del sistema, pero se tendrá acceso a la creación de informes de sus cuentas cerradas.\n- El trabajador puede volver a estar habilitado en el sistema agregándolo nuevamente.");
			jButtonRemove.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonRemoveActionPerformed(evt);
				}
			});
		}
		return jButtonRemove;
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

	private JPanel getJPanelEmpresa2() {
		if (jPanelEmpresa2 == null) {
			jPanelEmpresa2 = new JPanel();
			TableLayout jPanelEmpresa2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, 118.0, TableLayout.PREFERRED,
							TableLayout.FILL }, { TableLayout.PREFERRED } });
			jPanelEmpresa2Layout.setHGap(5);
			jPanelEmpresa2Layout.setVGap(5);
			jPanelEmpresa2.setLayout(jPanelEmpresa2Layout);
			jPanelEmpresa2.add(getJLabelRutEmpresa(), "0, 0");
			jPanelEmpresa2.add(getJLabelRazonSocial(), "2, 0");
			jPanelEmpresa2.add(getJTextFieldRazonSocial(), "3, 0");
			jPanelEmpresa2.add(getJFormattedTextFieldRutEmpresa(), "1, 0");
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
			jFormattedTextFieldRutEmpresa = new JFormattedTextField(Formato.getMaskRut());
			jFormattedTextFieldRutEmpresa.setEditable(false);
		}
		return jFormattedTextFieldRutEmpresa;
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
			jPanelTrabajador2.add(getJFormattedTextFieldRutTrabajador(), "1,    0");
			jPanelTrabajador2.add(getJLabelSexo(), "5,    0");
			jPanelTrabajador2.add(getJComboBoxSexo(), "6,    0");
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
	
	private JFormattedTextField getJFormattedTextFieldRutTrabajador() {
		if (jFormattedTextFieldRutTrabajador == null) {
			jFormattedTextFieldRutTrabajador = new JFormattedTextField(Formato
				.getMaskRut());
			jFormattedTextFieldRutTrabajador.setEditable(false);
		}
		return jFormattedTextFieldRutTrabajador;
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
			jComboBoxSexo.setEnabled(false);
			jComboBoxSexo.setModel(Palabra.getComboBoxModelSexo());
		}
		return jComboBoxSexo;
	}

	private void jButtonRemoveActionPerformed(ActionEvent evt) {
		this.respuesta(control.removeTrabajador(this.empresa, this.trabajador));
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se eliminó exitosamente.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el registro en el sistema.");
		} else if (respuesta == control.respNoExisteEmpresa) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe la empresa en el sistema.");
		}
	}
	
	public void actualizar(Empresa emp, Trabajador trab) {
		this.empresa = emp;
		this.trabajador = trab;
		this.jFormattedTextFieldRutEmpresa.setText(empresa.getRutEmpresa());
		this.jTextFieldRazonSocial.setText(empresa.getRazonSocial());
		this.jFormattedTextFieldRutTrabajador.setText(trabajador.getDatosPersonales().getRut());
		this.jTextFieldNombres.setText(trabajador.getDatosPersonales().getNombres());
		this.jTextFieldAPaterno.setText(trabajador.getDatosPersonales().getApellidoPaterno());
		this.jTextFieldAMaterno.setText(trabajador.getDatosPersonales().getApellidoMaterno());
		this.jComboBoxSexo.setSelectedItem(trabajador.getDatosPersonales().getSexo());
	}
	
}