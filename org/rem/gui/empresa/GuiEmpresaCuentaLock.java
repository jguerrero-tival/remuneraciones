package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.CardLayout;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import org.rem.control.empresa.ControlEmpresaCuenta;
import org.rem.gui.mes.TableModelMes;
import org.rem.model.EmpresaCuenta;
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
public class GuiEmpresaCuentaLock extends JDialog {

	private EmpresaCuenta empresaCuenta;
	private ControlEmpresaCuenta control = new ControlEmpresaCuenta();
	//private ControlTableModelEmpresaCuentaMes controlModel = new ControlTableModelEmpresaCuentaMes();
	
	private JPanel jPanelEmpresaCuentaLock2;
	private JPanel jPanelVariablesContent;
	private JTextField jTextFieldMutual;
	private JTextField jTextFieldCaja;
	private JTextField jTextFieldGratificacion;
	private JLabel jLabelRespuesta;
	private JTextField jTextFieldMutualCotizacionAdicional;
	private JLabel jLabelMutual;
	private JLabel jLabelMutualCotizacionAdicional;
	private JLabel jLabelCaja;
	private JLabel jLabelGratificacion;
	private JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JPanel jPanelEmpresa2;
	private JPanel jPanelEmpresa;
	private JButton jButtonLock;
	private JPanel jPanelVariablesButton;
	private JPanel jPanelVariables2;

	private static final long serialVersionUID = 1L;

	private JPanel jPanel;

	private JPanel jPanelTable;

	private JScrollPane jScrollPaneTable;
	private JPanel jPanelVariables;
	private JPanel jPanelEmpresaCuentaLock;

	private JTable jTable;

	private JPanel jContentPane = null;

	/**
	 * @param owner
	 */
	public GuiEmpresaCuentaLock(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(600, 310);
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
			CardLayout jContentPaneLayout = new CardLayout();
			jContentPane.setLayout(jContentPaneLayout);
			jContentPane.setEnabled(false);
			jContentPane.setBorder(BorderFactory
					.createTitledBorder("Agregar una Cuenta a la Empresa"));
			jContentPane.add(getJPanel(), "jPanel");
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.FILL,
							TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelTable(), "0, 1");
			jPanel.add(getJPanelVariablesButton(), "0, 3");
			jPanel.add(getJPanelEmpresa(), "0, 0");
			jPanel.add(getJLabelRespuesta(), "0, 2");
		}
		return jPanel;
	}

	private JPanel getJPanelTable() {
		if (jPanelTable == null) {
			jPanelTable = new JPanel();
			TableLayout jPanelTableLayout = new TableLayout(new double[][] {
					{ 200.0, TableLayout.FILL }, { TableLayout.FILL } });
			jPanelTableLayout.setHGap(5);
			jPanelTableLayout.setVGap(5);
			jPanelTable.setLayout(jPanelTableLayout);
			jPanelTable.add(getJPanelEmpresaCuentaLock(), "0, 0");
			jPanelTable.add(getJPanelVariables(), "1, 0");
		}
		return jPanelTable;
	}

	private JScrollPane getJScrollPaneTable() {
		if (jScrollPaneTable == null) {
			jScrollPaneTable = new JScrollPane();
			jScrollPaneTable.setViewportView(getJTable());
		}
		return jScrollPaneTable;
	}

	private JTable getJTable() {
		if (jTable == null) {
			jTable = new JTable();
			jTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		}
		return jTable;
	}

	private JPanel getJPanelEmpresaCuentaLock() {
		if (jPanelEmpresaCuentaLock == null) {
			jPanelEmpresaCuentaLock = new JPanel();
			CardLayout jPanelEmpresaCuentaLockLayout = new CardLayout();
			jPanelEmpresaCuentaLock.setLayout(jPanelEmpresaCuentaLockLayout);
			jPanelEmpresaCuentaLock.setBorder(BorderFactory.createTitledBorder("Fecha"));
			jPanelEmpresaCuentaLock.add(getJPanelEmpresaCuentaLock2(), "jPanelEmpresaCuentaLock2");
		}
		return jPanelEmpresaCuentaLock;
	}
	
	private JPanel getJPanelVariables() {
		if (jPanelVariables == null) {
			jPanelVariables = new JPanel();
			CardLayout jPanelVariablesLayout = new CardLayout();
			jPanelVariables.setLayout(jPanelVariablesLayout);
			jPanelVariables.setBorder(BorderFactory.createTitledBorder("Variables"));
			jPanelVariables.add(getJPanelVariables2(), "jPanelVariables2");
		}
		return jPanelVariables;
	}
	
	private JPanel getJPanelEmpresaCuentaLock2() {
		if (jPanelEmpresaCuentaLock2 == null) {
			jPanelEmpresaCuentaLock2 = new JPanel();
			TableLayout jPanelEmpresaCuentaLock2Layout = new TableLayout(new double[][] {
					{ TableLayout.FILL }, { TableLayout.FILL } });
			jPanelEmpresaCuentaLock2Layout.setHGap(5);
			jPanelEmpresaCuentaLock2Layout.setVGap(5);
			jPanelEmpresaCuentaLock2.setLayout(jPanelEmpresaCuentaLock2Layout);
			jPanelEmpresaCuentaLock2.add(getJScrollPaneTable(), "0, 0");
		}
		return jPanelEmpresaCuentaLock2;
	}

	private JPanel getJPanelVariables2() {
		if (jPanelVariables2 == null) {
			jPanelVariables2 = new JPanel();
			CardLayout jPanelVariables2Layout = new CardLayout();
			jPanelVariables2.setLayout(jPanelVariables2Layout);
			jPanelVariables2.add(getJPanelVariablesContent(), "0, 0");
		}
		return jPanelVariables2;
	}
	
	private JPanel getJPanelVariablesButton() {
		if (jPanelVariablesButton == null) {
			jPanelVariablesButton = new JPanel();
			jPanelVariablesButton.add(getJButtonLock());
		}
		return jPanelVariablesButton;
	}

	private JPanel getJPanelVariablesContent() {
		if (jPanelVariablesContent == null) {
			jPanelVariablesContent = new JPanel();
			TableLayout jPanelVariablesContentLayout = new TableLayout(
				new double[][] {
						{ TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelVariablesContentLayout.setHGap(5);
			jPanelVariablesContentLayout.setVGap(5);
			jPanelVariablesContent.setLayout(jPanelVariablesContentLayout);
			jPanelVariablesContent.add(getJLabelGratificacion(), "0, 0");
			jPanelVariablesContent.add(getJLabelCaja(), "0, 1");
			jPanelVariablesContent.add(getJLabelMutual(), "0, 2");
			jPanelVariablesContent.add(getJLabelMutualCotizacionAdicional(), "0, 3");
			jPanelVariablesContent.add(getJTextFieldMutualCotizacionAdicional(), "1, 3");
			jPanelVariablesContent.add(getJTextFieldGratificacion(), "1, 0");
			jPanelVariablesContent.add(getJTextFieldCaja(), "1, 1");
			jPanelVariablesContent.add(getJTextFieldMutual(), "1, 2");
		}
		return jPanelVariablesContent;
	}

	private JButton getJButtonLock() {
		if (jButtonLock == null) {
			jButtonLock = new JButton();
			jButtonLock.setText("Bloquear");
			jButtonLock.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonLockActionPerformed(evt);
				}
			});
		}
		return jButtonLock;
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
			jPanelEmpresa2.add(getJLabelRutEmpresa(), "0,       0");
			jPanelEmpresa2.add(getJLabelRazonSocial(), "2,       0");
			jPanelEmpresa2.add(getJTextFieldRazonSocial(), "3,       0");
			jPanelEmpresa2.add(getJFormattedTextFieldRutEmpresa(), "1,       0");
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
	
	private JLabel getJLabelGratificacion() {
		if (jLabelGratificacion == null) {
			jLabelGratificacion = new JLabel();
			jLabelGratificacion.setText("Gratificación : ");
		}
		return jLabelGratificacion;
	}
	
	private JLabel getJLabelCaja() {
		if (jLabelCaja == null) {
			jLabelCaja = new JLabel();
			jLabelCaja.setText("Caja de Compensación : ");
		}
		return jLabelCaja;
	}
	
	private JLabel getJLabelMutual() {
		if (jLabelMutual == null) {
			jLabelMutual = new JLabel();
			jLabelMutual.setText("Mutual de Seguridad : ");
		}
		return jLabelMutual;
	}
	
	private JLabel getJLabelMutualCotizacionAdicional() {
		if (jLabelMutualCotizacionAdicional == null) {
			jLabelMutualCotizacionAdicional = new JLabel();
			jLabelMutualCotizacionAdicional.setText("Cotización Adicional Mutual (%) : ");
		}
		return jLabelMutualCotizacionAdicional;
	}

	private JTextField getJTextFieldMutualCotizacionAdicional() {
		if (jTextFieldMutualCotizacionAdicional == null) {
			jTextFieldMutualCotizacionAdicional = new JTextField();
		}
		return jTextFieldMutualCotizacionAdicional;
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
	
	
	private JTextField getJTextFieldGratificacion() {
		if (jTextFieldGratificacion == null) {
			jTextFieldGratificacion = new JTextField();
		}
		return jTextFieldGratificacion;
	}
	
	private JTextField getJTextFieldCaja() {
		if (jTextFieldCaja == null) {
			jTextFieldCaja = new JTextField();
		}
		return jTextFieldCaja;
	}
	
	private JTextField getJTextFieldMutual() {
		if (jTextFieldMutual == null) {
			jTextFieldMutual = new JTextField();
		}
		return jTextFieldMutual;
	}

	private void jButtonLockActionPerformed(ActionEvent evt) {
		if( empresaCuenta!=null) {
		this.respuesta(
			this.control.lockEmpresaCuenta(empresaCuenta));
			this.boorarInfo();
		} else {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro ya fue bloqueado.");
		}
	} 
	
	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se bloqueï¿½ exitosamente.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe la cuenta en el sistema.");
		}
	}
	
	private void actualizarDatos() {
		if (empresaCuenta!=null) {
			this.jTextFieldGratificacion.setText(empresaCuenta.getGratificacion());
			if(empresaCuenta.getCaja()!=null) {
				this.jTextFieldCaja.setText(empresaCuenta.getCaja().getNombre());
			}
			if(empresaCuenta.getMutual()!=null) {
				this.jTextFieldMutual.setText(empresaCuenta.getMutual().getNombre());
			}
			this.jTextFieldMutualCotizacionAdicional.setText(empresaCuenta.getMutualCotizacionAdicional().toString());
		}
	}
	
	public void actualizar(EmpresaCuenta empCuenta) {
		this.empresaCuenta = empCuenta;
		this.jFormattedTextFieldRutEmpresa.setText(empresaCuenta.getEmpresa().getRutEmpresa());
		this.jTextFieldRazonSocial.setText(empresaCuenta.getEmpresa().getRazonSocial());
		TableModelMes model = new TableModelMes();
		model.addObject(empresaCuenta.getMes());
		this.jTable.setModel(model);
		this.jTextFieldGratificacion.setEditable(false);
		this.jTextFieldCaja.setEditable(false);
		this.jTextFieldMutual.setEditable(false);
		this.jTextFieldMutualCotizacionAdicional.setEditable(false);
		this.actualizarDatos();//LOS DE LA CUENTA
	}
	
	public void boorarInfo() {
		empresaCuenta = null;
		this.jTable.setModel(new TableModelMes());
		this.jTextFieldGratificacion.setText("");
		this.jTextFieldCaja.setText("");
		this.jTextFieldMutual.setText("");
		this.jTextFieldMutualCotizacionAdicional.setText("");
	}


}