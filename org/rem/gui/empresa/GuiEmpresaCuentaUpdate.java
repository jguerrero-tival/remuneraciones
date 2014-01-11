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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.CardLayout;
import javax.swing.JDialog;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import org.rem.control.empresa.ControlEmpresaCuenta;
import org.rem.control.institucion.ControlCaja;
import org.rem.control.institucion.ControlMutual;
import org.rem.gui.mes.TableModelMes;
import org.rem.model.Caja;
import org.rem.model.EmpresaCuenta;
import org.rem.model.Mutual;
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
public class GuiEmpresaCuentaUpdate extends JDialog {

	private EmpresaCuenta empresaCuenta;
	private ControlMutual controlMutual = new ControlMutual();
	private ControlCaja controlCaja = new ControlCaja();
	private ControlEmpresaCuenta control = new ControlEmpresaCuenta();
	//private ControlTableModelEmpresaCuentaMes controlModel = new ControlTableModelEmpresaCuentaMes();
	
	private JPanel jPanelEmpresaCuentaUpdate2;
	private JPanel jPanelVariablesContent;
	private JLabel jLabelRespuesta;
	private JTextField jTextFieldMutualCotizacionAdicional;
	private JComboBox jComboBoxMutual;
	private JComboBox jComboBoxCaja;
	private JLabel jLabelMutual;
	private JComboBox jComboBoxGratificacion;
	private JLabel jLabelMutualCotizacionAdicional;
	private JLabel jLabelCaja;
	private JLabel jLabelGratificacion;
	private JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JTextField jTextFieldRazonSocial;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JPanel jPanelEmpresa2;
	private JPanel jPanelEmpresa;
	private JButton jButtonUpdate;
	private JPanel jPanelVariablesButton;
	private JPanel jPanelVariables2;

	private static final long serialVersionUID = 1L;

	private JPanel jPanel;

	private JPanel jPanelTable;

	private JScrollPane jScrollPaneTable;
	private JPanel jPanelVariables;
	private JPanel jPanelEmpresaCuentaUpdate;

	private JTable jTable;

	private JPanel jContentPane = null;

	/**
	 * @param owner
	 */
	public GuiEmpresaCuentaUpdate(Frame owner) {
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
			jPanelTable.add(getJPanelEmpresaCuentaUpdate(), "0, 0");
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

	private JPanel getJPanelEmpresaCuentaUpdate() {
		if (jPanelEmpresaCuentaUpdate == null) {
			jPanelEmpresaCuentaUpdate = new JPanel();
			CardLayout jPanelEmpresaCuentaUpdateLayout = new CardLayout();
			jPanelEmpresaCuentaUpdate.setLayout(jPanelEmpresaCuentaUpdateLayout);
			jPanelEmpresaCuentaUpdate.setBorder(BorderFactory.createTitledBorder("Fecha"));
			jPanelEmpresaCuentaUpdate.add(getJPanelEmpresaCuentaUpdate2(), "jPanelEmpresaCuentaUpdate2");
		}
		return jPanelEmpresaCuentaUpdate;
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
	
	private JPanel getJPanelEmpresaCuentaUpdate2() {
		if (jPanelEmpresaCuentaUpdate2 == null) {
			jPanelEmpresaCuentaUpdate2 = new JPanel();
			TableLayout jPanelEmpresaCuentaUpdate2Layout = new TableLayout(new double[][] {
					{ TableLayout.FILL }, { TableLayout.FILL } });
			jPanelEmpresaCuentaUpdate2Layout.setHGap(5);
			jPanelEmpresaCuentaUpdate2Layout.setVGap(5);
			jPanelEmpresaCuentaUpdate2.setLayout(jPanelEmpresaCuentaUpdate2Layout);
			jPanelEmpresaCuentaUpdate2.add(getJScrollPaneTable(), "0, 0");
		}
		return jPanelEmpresaCuentaUpdate2;
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
			jPanelVariablesButton.add(getJButtonUpdate());
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
			jPanelVariablesContent.add(getJComboBoxGratificacion(), "1, 0");
			jPanelVariablesContent.add(getJComboBoxCaja(), "1, 1");
			jPanelVariablesContent.add(getJComboBoxMutual(), "1, 2");
			jPanelVariablesContent.add(getJTextFieldMutualCotizacionAdicional(), "1, 3");
		}
		return jPanelVariablesContent;
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
			jLabelRazonSocial.setText("Raz�n Social : ");
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
			jLabelGratificacion.setText("Gratificaci�n : ");
		}
		return jLabelGratificacion;
	}
	
	private JLabel getJLabelCaja() {
		if (jLabelCaja == null) {
			jLabelCaja = new JLabel();
			jLabelCaja.setText("Caja de Compensaci�n : ");
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
			jLabelMutualCotizacionAdicional.setText("Cotizaci�n Adicional Mutual (%) : ");
		}
		return jLabelMutualCotizacionAdicional;
	}
	
	private JComboBox getJComboBoxGratificacion() {
		if (jComboBoxGratificacion == null) {
			jComboBoxGratificacion = new JComboBox();
			jComboBoxGratificacion.setModel(Palabra.getComboBoxModelGratificaciones());
		}
		return jComboBoxGratificacion;
	}
	
	private JComboBox getJComboBoxCaja() {
		if (jComboBoxCaja == null) {
			jComboBoxCaja = new JComboBox();
		}
		return jComboBoxCaja;
	}
	
	private JComboBox getJComboBoxMutual() {
		if (jComboBoxMutual == null) {
			jComboBoxMutual = new JComboBox();
			jComboBoxMutual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					//COMENTADO PARA QUE NO SE BLOQUE EL CAMPO COTIZACION ADICIONAL DE MUTUAL
					//EN CASO DE QUE NO POSEA INSTITUCION		
					//jComboBoxMutualActionPerformed(evt);
				}
			});
		}
		return jComboBoxMutual;
	}
	
	private JTextField getJTextFieldMutualCotizacionAdicional() {
		if (jTextFieldMutualCotizacionAdicional == null) {
			jTextFieldMutualCotizacionAdicional = new JTextField();
			jTextFieldMutualCotizacionAdicional
				.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldMutualCotizacionAdicionalKeyTyped(evt);
				}
				});
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

	private void jTextFieldMutualCotizacionAdicionalKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldMutualCotizacionAdicional.getText());
	}

	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (this.jComboBoxGratificacion.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar una \"Gratificaci�n\".");
		} else if (this.jComboBoxCaja.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar una \"Caja de Compensaci�n\".");			
		} else if (this.jComboBoxMutual.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar una \"Mutual de Seguridad\".");
		} else if (this.jTextFieldMutualCotizacionAdicional.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Cotizaci�n Adicional Mutual\".");
		} 
		//NUEVO
		else if (this.jTextFieldMutualCotizacionAdicional.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Cotizaci�n Adicional Mutual\".");
		} else {
			
			Caja caja;
			if (!this.jComboBoxCaja.getSelectedItem().toString().equals(Palabra.institucionSin)) {
				caja = this.controlCaja.getCaja(this.jComboBoxCaja.getSelectedItem().toString());
			} else {
				caja = null;
			}
			
			Mutual mutual;
			Double cotizacionAdicionalMutual;
			if (!this.jComboBoxMutual.getSelectedItem().toString().equals(Palabra.institucionSin)) {
				mutual = this.controlMutual.getMutual(this.jComboBoxMutual.getSelectedItem().toString());
				//cotizacionAdicionalMutual = new Double(this.jTextFieldMutualCotizacionAdicional.getText());
			} else {
				mutual = null;
				//cotizacionAdicionalMutual = new Double(0);
				//this.jTextFieldMutualCotizacionAdicional.setText("0");
			}
			//NEW
			cotizacionAdicionalMutual = new Double(this.jTextFieldMutualCotizacionAdicional.getText());
			//if (this.jTextFieldMutualCotizacionAdicional.getText().trim().length()==0) {
			//	this.jLabelRespuesta.setBackground(Color.red);
			//	this.jLabelRespuesta.setText("Debe rellenar el campo \"Cotizaci�n Adicional Mutual\".");
			//} else {
				this.respuesta(
				this.control.updateEmpresaCuenta(
						this.empresaCuenta, 
						this.jComboBoxGratificacion.getSelectedItem().toString(), 
						caja, 
						mutual,
						cotizacionAdicionalMutual));
			//}
		}
	} 
	
	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se modific� exitosamente.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe la cuenta en el sistema.");
		} else if (respuesta == control.respCerrada) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No se puede modificar una cuenta cerrada.");
		}
	}
	
	private void actualizarDatos() {
		if (empresaCuenta!=null) {
			this.jComboBoxGratificacion.setSelectedItem(empresaCuenta.getGratificacion());
			if (empresaCuenta.getCaja()!=null) {
				this.jComboBoxCaja.setSelectedItem(empresaCuenta.getCaja().getNombre());				
			} else {
				this.jComboBoxCaja.setSelectedIndex(0);
			}
			if (empresaCuenta.getMutual()!=null) {
				this.jComboBoxMutual.setSelectedItem(empresaCuenta.getMutual().getNombre());
				//this.jTextFieldMutualCotizacionAdicional.setText(empresaCuenta.getMutualCotizacionAdicional().toString());				
			} else {
				this.jComboBoxMutual.setSelectedIndex(0);
				//this.jTextFieldMutualCotizacionAdicional.setText("0");				
			}
			//AGREGADO Y COMENTADAS LAS 2 LINEAS ANTERIORES
			this.jTextFieldMutualCotizacionAdicional.setText(empresaCuenta.getMutualCotizacionAdicional().toString());
			//COMENTADO PARA QUE NO SE BLOQUE EL CAMPO COTIZACION ADICIONAL DE MUTUAL
			//EN CASO DE QUE NO POSEA INSTITUCION		
			/*
			if (this.jComboBoxMutual.getSelectedItem().toString().equals(Palabra.institucionSin)) {
				this.jTextFieldMutualCotizacionAdicional.setEnabled(false);
			} else {
				this.jTextFieldMutualCotizacionAdicional.setEnabled(true);
			}
			*/
		}
	}
	
	public void actualizar(EmpresaCuenta empCuenta) {
		this.empresaCuenta = empCuenta;
		this.jFormattedTextFieldRutEmpresa.setText(empresaCuenta.getEmpresa().getRutEmpresa());
		this.jTextFieldRazonSocial.setText(empresaCuenta.getEmpresa().getRazonSocial());
		TableModelMes model = new TableModelMes();
		model.addObject(empresaCuenta.getMes());
		this.jTable.setModel(model);
		this.jComboBoxCaja.setModel(controlCaja.getComboBoxModelCajaNoBloqueadoSin());
		this.jComboBoxMutual.setModel(controlMutual.getComboBoxModelMutualNoBloqueadoSin());
		this.actualizarDatos();//LOS DE LA CUENTA
	}
	
	/*
	private void jComboBoxMutualActionPerformed(ActionEvent evt) {
		if (this.jComboBoxMutual.getSelectedItem().toString().equals(Palabra.institucionSin)) {
			this.jTextFieldMutualCotizacionAdicional.setEnabled(false);
		} else {
			this.jTextFieldMutualCotizacionAdicional.setEnabled(true);
		}
	}
	*/

}