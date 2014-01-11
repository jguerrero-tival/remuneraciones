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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import org.rem.control.empresa.ControlEmpresaCuenta;
import org.rem.model.CentroCosto;
import org.rem.model.EmpresaCuenta;
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
public class GuiCentroCostoUpdate extends JDialog {

	private EmpresaCuenta empresaCuenta;
	private JTextField jTextFieldCentroCosto;
	private JLabel jLabelCentroCosto;
	private JPanel jPanelModificar2;
	private JPanel jPanelModificar;
	private CentroCosto centroCosto;
	private JTextField jTextFieldNombre;
	private JLabel jLabelNombre;
	private JTextField jTextFieldNumero;
	private ControlEmpresaCuenta control = new ControlEmpresaCuenta();
	private JPanel jPanelEmpresa;
	private JPanel jPanelCentroCosto2;
	private JPanel jPanelCentroCosto;
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

	private JButton jButtonUpdate;

	/**
	 * This is the default constructor
	 */
	public GuiCentroCostoUpdate(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 340);
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
					.createTitledBorder("Modificar Centro de Costo"));
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
							TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 5, 2, 5");
			jPanel.add(getJLabelRespuesta(), "1, 4, 2, 4");
			jPanel.add(getJPanelEmpresa(), "1, 1, 2, 1");
			jPanel.add(getJPanelFecha(), "1, 0, 2, 0");
			jPanel.add(getJPanelCentroCosto(), "1, 2, 2, 2");
			jPanel.add(getJPanelModificar(), "1, 3, 2, 3");
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
			jLabelNumero.setText("Número : ");
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
			jLabelFecha.setForeground(Color.RED);
			jLabelFecha.setFont(new java.awt.Font("Tahoma",1,12));
			jLabelFecha.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelFecha;
	}
	
	private JPanel getJPanelCentroCosto() {
		if (jPanelCentroCosto == null) {
			jPanelCentroCosto = new JPanel();
			CardLayout jPanelCentroCostoLayout = new CardLayout();
			jPanelCentroCosto.setLayout(jPanelCentroCostoLayout);
			jPanelCentroCosto.setBorder(BorderFactory.createTitledBorder("Centro de Costo"));
			jPanelCentroCosto.add(getJPanelCentroCosto2(), "jPanelCentroCosto2");
		}
		return jPanelCentroCosto;
	}
	
	private JPanel getJPanelCentroCosto2() {
		if (jPanelCentroCosto2 == null) {
			jPanelCentroCosto2 = new JPanel();
			TableLayout jPanelCentroCosto2Layout = new TableLayout(
				new double[][] { { TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.PREFERRED } });
			jPanelCentroCosto2Layout.setHGap(5);
			jPanelCentroCosto2Layout.setVGap(5);
			jPanelCentroCosto2.setLayout(jPanelCentroCosto2Layout);
			jPanelCentroCosto2.add(getJLabelCentroCosto(), "0, 0");
			jPanelCentroCosto2.add(getJTextFieldCentroCosto(), "1, 0");
		}
		return jPanelCentroCosto2;
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
	
	private JLabel getJLabelNombre() {
		if (jLabelNombre == null) {
			jLabelNombre = new JLabel();
			jLabelNombre.setText("Nombre : ");
		}
		return jLabelNombre;
	}
	
	private JTextField getJTextFieldNombre() {
		if (jTextFieldNombre == null) {
			jTextFieldNombre = new JTextField();
			jTextFieldNombre.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldNombreKeyTyped(evt);
				}
			});
		}
		return jTextFieldNombre;
	}
	
	private JPanel getJPanelModificar() {
		if (jPanelModificar == null) {
			jPanelModificar = new JPanel();
			CardLayout jPanelModificarLayout = new CardLayout();
			jPanelModificar.setLayout(jPanelModificarLayout);
			jPanelModificar.setBorder(BorderFactory.createTitledBorder("Datos a Modificar"));
			jPanelModificar.add(getJPanelModificar2(), "jPanelModificar2");
		}
		return jPanelModificar;
	}
	
	private JPanel getJPanelModificar2() {
		if (jPanelModificar2 == null) {
			jPanelModificar2 = new JPanel();
			TableLayout jPanelModificar2Layout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.FILL } });
			jPanelModificar2Layout.setHGap(5);
			jPanelModificar2Layout.setVGap(5);
			jPanelModificar2.setLayout(jPanelModificar2Layout);
			jPanelModificar2.add(getJLabelNumero(), "0, 0");
			jPanelModificar2.add(getJTextFieldNumero(), "1, 0");
			jPanelModificar2.add(getJLabelNombre(), "0, 1");
			jPanelModificar2.add(getJTextFieldNombre(), "1, 1");
		}
		return jPanelModificar2;
	}
	
	private JLabel getJLabelCentroCosto() {
		if (jLabelCentroCosto == null) {
			jLabelCentroCosto = new JLabel();
			jLabelCentroCosto.setText("Centro de Costo : ");
		}
		return jLabelCentroCosto;
	}
	
	private JTextField getJTextFieldCentroCosto() {
		if (jTextFieldCentroCosto == null) {
			jTextFieldCentroCosto = new JTextField();
			jTextFieldCentroCosto.setEditable(false);
		}
		return jTextFieldCentroCosto;
	}
		
	private void jTextFieldNumeroKeyTyped(KeyEvent evt) {
		Formato.formatLong(evt);
	}
	
	private void jTextFieldNombreKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (this.centroCosto!=null && this.empresaCuenta!=null) {
			this.respuesta(control.updateCentroCosto(
					empresaCuenta,
					centroCosto,
					new Long(this.jTextFieldNumero.getText()),
					this.jTextFieldNombre.getText()));
		} else {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro ya fue modificado.");
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se modificó exitosamente.");
			this.actualizar();
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Ya existe un registro con el \"Número\" ingresado.");
		} else if (respuesta == control.respNoExisteCentroCosto) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe en el sistema el centro de costo.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe en el sistema la cuenta.");
		} else if (respuesta == control.respNombreCentroCostoReservado) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El \"Número\" ingresado está reservado para otra cuenta.");
		} else if (respuesta == control.respNombreCentroCostoReservado) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El \"Nombre\" ingresado está reservado para otra cuenta.");
		}
	}
	
	public void actualizar() {
		this.centroCosto = null;
		this.empresaCuenta = null;
		this.jTextFieldCentroCosto.setText("");
		this.jTextFieldNumero.setText("");
		this.jTextFieldNombre.setText("");
		this.jTextFieldNumero.setEditable(false);
		this.jTextFieldNombre.setEditable(false);
	}
	
	public void actualizar(EmpresaCuenta cuenta, CentroCosto cc) {
		this.empresaCuenta = cuenta;
		this.centroCosto = cc;
		this.jLabelFecha.setText(Fecha.fechaTexto(empresaCuenta.getMes().getFecha()));
		this.jFormattedTextFieldRutEmpresa.setText(empresaCuenta.getEmpresa().getRutEmpresa());
		this.jTextFieldRazonSocial.setText(empresaCuenta.getEmpresa().getRazonSocial());
		this.jTextFieldCentroCosto.setText(centroCosto.getNumero().toString());
		this.jTextFieldNumero.setText(centroCosto.getNumero().toString());
		this.jTextFieldNombre.setText(centroCosto.getNombre());
		this.jTextFieldNumero.setEditable(true);
		this.jTextFieldNombre.setEditable(true);
	}

}