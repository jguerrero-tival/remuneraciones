
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
import org.rem.control.empresa.ControlTrabajadorDescuento;
import org.rem.model.TrabajadorDescuento;
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
public class GuiTrabajadorDescuentoRemove extends JDialog {

	private TrabajadorCuenta trabajadorCuenta;
	private TrabajadorDescuento trabajadorDescuento;
	private ControlTrabajadorDescuento control = new ControlTrabajadorDescuento();
	private JPanel jPanelEmpresa;
	private JPanel jPanelTrabajadorDescuento2;
	private JTextField jTextFieldAPaterno;
	private JTextField jTextFieldDescuento;
	private JTextField jTextFieldHorasExtraordinarias;
	private JLabel jLabelHorasExtraordinarias;
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
	private JPanel jPanelTrabajadorDescuento;
	private JLabel jLabelFecha;
	private JPanel jPanelFecha2;
	private JPanel jPanelFecha;
	private JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JPanel jPanelEmpresa2;

	private JLabel jLabelNumero;

	private JLabel jLabelRespuesta;

	private JPanel jContentPane = null;

	private JPanel jPanel;

	private JPanel jPanelButton;

	private JButton jButtonRemove;

	/**
	 * This is the default constructor
	 */
	public GuiTrabajadorDescuentoRemove(JDialog owner) {
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
					.createTitledBorder("Agregar Descuento"));
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
			jPanel.add(getJPanelTrabajadorDescuento(), "1, 3, 2, 3");
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
			jPanelButton.add(getJButtonRemove());
		}
		return jPanelButton;
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

	private JLabel getJLabelNumero() {
		if (jLabelNumero == null) {
			jLabelNumero = new JLabel();
			jLabelNumero.setText("Descuento : ");
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
	
	private JPanel getJPanelTrabajadorDescuento() {
		if (jPanelTrabajadorDescuento == null) {
			jPanelTrabajadorDescuento = new JPanel();
			CardLayout jPanelTrabajadorDescuentoLayout = new CardLayout();
			jPanelTrabajadorDescuento.setLayout(jPanelTrabajadorDescuentoLayout);
			jPanelTrabajadorDescuento.setBorder(BorderFactory.createTitledBorder("Descuento"));
			jPanelTrabajadorDescuento.add(getJPanelTrabajadorDescuento2(), "jPanelTrabajadorDescuento2");
		}
		return jPanelTrabajadorDescuento;
	}
	
	private JPanel getJPanelTrabajadorDescuento2() {
		if (jPanelTrabajadorDescuento2 == null) {
			jPanelTrabajadorDescuento2 = new JPanel();
			TableLayout jPanelTrabajadorDescuento2Layout = new TableLayout(
				new double[][] { { TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelTrabajadorDescuento2Layout.setHGap(5);
			jPanelTrabajadorDescuento2Layout.setVGap(5);
			jPanelTrabajadorDescuento2.setLayout(jPanelTrabajadorDescuento2Layout);
			jPanelTrabajadorDescuento2.add(getJLabelNumero(), "0, 0");
			jPanelTrabajadorDescuento2.add(getJLabelMonto(), "0, 1");
			jPanelTrabajadorDescuento2.add(getJTextFieldMonto(), "1, 1");
			jPanelTrabajadorDescuento2.add(getJLabelHorasExtraordinarias(), "0, 2");
			jPanelTrabajadorDescuento2.add(getJTextFieldHorasExtraordinarias(), "1, 2");
			jPanelTrabajadorDescuento2.add(getJTextFieldDescuento(), "1, 0");
		}
		return jPanelTrabajadorDescuento2;
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
			jTextFieldMonto.setEditable(false);
		}
		return jTextFieldMonto;
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
			jTextFieldHorasExtraordinarias.setEditable(false);
		}
		return jTextFieldHorasExtraordinarias;
	}

	private JTextField getJTextFieldDescuento() {
		if (jTextFieldDescuento == null) {
			jTextFieldDescuento = new JTextField();
			jTextFieldDescuento.setEditable(false);
		}
		return jTextFieldDescuento;
	}
	
	private void jButtonRemoveActionPerformed(ActionEvent evt) {
		if (this.trabajadorCuenta!=null) {
			this.respuesta(
					control.removeTrabajadorDescuento(
							this.trabajadorDescuento
							));
		
		} else {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Ya se eliminó el \"Descuento\" ingresado.");
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se agregó exitosamente.");
			this.limpiar();
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el \"Descuento\".");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe en el sistema la cuenta.");
		}
	}
	
	public void actualizar(TrabajadorCuenta cuenta, TrabajadorDescuento trabajadorDesc) {
		this.trabajadorCuenta = cuenta;
		this.trabajadorDescuento = trabajadorDesc;
		this.jLabelFecha.setText(Fecha.fechaTexto(trabajadorCuenta.getEmpresaCuenta().getMes().getFecha()));
		this.jFormattedTextFieldRutEmpresa.setText(trabajadorCuenta.getEmpresaCuenta().getEmpresa().getRutEmpresa());
		this.jTextFieldRazonSocial.setText(trabajadorCuenta.getEmpresaCuenta().getEmpresa().getRazonSocial());
		this.jTextFieldRutTrabajador.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getRut());
		this.jTextFieldSexo.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getSexo());
		this.jTextFieldNombres.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getNombres());
		this.jTextFieldAPaterno.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getApellidoPaterno());
		this.jTextFieldAMaterno.setText(trabajadorCuenta.getTrabajador().getDatosPersonales().getApellidoMaterno());
		this.jTextFieldDescuento.setText(this.trabajadorDescuento.getDescuento().getNombre().toString());
		this.jTextFieldMonto.setText(this.trabajadorDescuento.getMonto().toString());
	}
	
	private void limpiar() {
		this.trabajadorDescuento = null;
		this.trabajadorCuenta = null;
		this.jTextFieldDescuento.setText("");
		this.jTextFieldMonto.setText("");
	}

}