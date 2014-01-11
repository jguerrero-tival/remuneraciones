package org.rem.gui.mes;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import org.rem.control.mes.ControlImpuesto;
import org.rem.util.Fecha;
import org.rem.util.Formato;
import org.rem.util.Message;
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
public class GuiImpuestoUpdate extends JDialog {

	private Date fecha = null;
	private ControlImpuesto control = new ControlImpuesto();
	private JPanel jPanelData;
	private JTextField jTextFieldAnno;
	private JTextField jTextFieldMes;
	private JLabel jLabelMes;
	private JLabel jLabelAnno;
	private JPanel jPanelFecha;
	private JTextField jTextFieldRebaja;
	private JTextField jTextFieldFactor;
	private JTextField jTextFieldInicio;
	private JLabel jLabelInicio2;
	private JLabel jLabelFactor;
	private JLabel jLabelRebaja;
	private JTextField jTextFieldFin;
	private JLabel jLabelFin;
	private JLabel jLabelInicio;
	private JLabel jLabelTramo;
	private JPanel jPanelInformation;
	private JComboBox jComboBoxImpuesto;
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonUpdate;

	/**
	 * This is the default constructor
	 */
	public GuiImpuestoUpdate(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 320);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Modificar los tramos de Impuesto Único"));
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ 10.0, TableLayout.PREFERRED, TableLayout.FILL,
							TableLayout.FILL, 10.0 },
					{ 10.0, TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 6, 3, 6");
			jPanel.add(getJLabelRespuesta(), "1, 5, 3, 5");
			//jComboBoxImpuesto.setModel(control.getComboBoxModelImpuestoInicioAll());
			jPanel.add(getJComboBoxImpuesto(), "2, 3");
			jComboBoxImpuesto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxImpuestoActionPerformed(evt);
				}
			});
			jPanel.add(getJPanelInformation(), "1, 4, 3, 4");
			jPanel.add(getJLabelTramo(), "1, 3");
			jPanel.add(getJLabelInicio(), "2, 2");
			jPanel.add(getJLabelFin(), "3, 2");
			jPanel.add(getJTextFieldFin(), "3, 3");
			jPanel.add(getJPanelFecha(), "1, 1, 3, 1");
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

	private JPanel getJPanelInformation() {
		if (jPanelInformation == null) {
			jPanelInformation = new JPanel();
			CardLayout jPanelInformationLayout = new CardLayout();
			jPanelInformation.setLayout(jPanelInformationLayout);
			jPanelInformation.setBorder(BorderFactory.createTitledBorder(null, "Datos a Modificar", TitledBorder.LEADING, TitledBorder.TOP));
			jPanelInformation.add(getJPanelData(), "jPanelData");
		}
		return jPanelInformation;
	}
	
	private JPanel getJPanelData() {
		if (jPanelData == null) {
			jPanelData = new JPanel();
			TableLayout jPanelDataLayout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED } });
			jPanelDataLayout.setHGap(5);
			jPanelDataLayout.setVGap(5);
			jPanelData.setLayout(jPanelDataLayout);
			jPanelData.add(getJLabelRebaja(), "0, 2");
			jPanelData.add(getJLabelFactor(), "0, 1");
			jPanelData.add(getJLabelInicio2(), "0, 0");
			jPanelData.add(getJTextFieldInicio(), "1, 0");
			jPanelData.add(getJTextFieldFactor(), "1, 1");
			jPanelData.add(getJTextFieldRebaja(), "1, 2");
		}
		return jPanelData;
	}

	private JComboBox getJComboBoxImpuesto() {
		if (jComboBoxImpuesto == null) {
			jComboBoxImpuesto = new JComboBox();
		}
		return jComboBoxImpuesto;
	}
	
	private JLabel getJLabelTramo() {
		if (jLabelTramo == null) {
			jLabelTramo = new JLabel();
			jLabelTramo.setText("Tramo : ");
		}
		return jLabelTramo;
	}
	
	private JLabel getJLabelInicio() {
		if (jLabelInicio == null) {
			jLabelInicio = new JLabel();
			jLabelInicio.setText("Inicio");
			jLabelInicio.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelInicio;
	}
	
	private JLabel getJLabelFin() {
		if (jLabelFin == null) {
			jLabelFin = new JLabel();
			jLabelFin.setText("Fin");
			jLabelFin.setHorizontalAlignment(SwingConstants.CENTER);
		}
		return jLabelFin;
	}
	
	private JTextField getJTextFieldFin() {
		if (jTextFieldFin == null) {
			jTextFieldFin = new JTextField();
			jTextFieldFin.setEditable(false);
		}
		return jTextFieldFin;
	}
	
	private JLabel getJLabelRebaja() {
		if (jLabelRebaja == null) {
			jLabelRebaja = new JLabel();
			jLabelRebaja.setText("Rebaja : ");
		}
		return jLabelRebaja;
	}
	
	private JLabel getJLabelFactor() {
		if (jLabelFactor == null) {
			jLabelFactor = new JLabel();
			jLabelFactor.setText("Factor : ");
		}
		return jLabelFactor;
	}
	
	private JLabel getJLabelInicio2() {
		if (jLabelInicio2 == null) {
			jLabelInicio2 = new JLabel();
			jLabelInicio2.setText("Inicio : ");
		}
		return jLabelInicio2;
	}
	
	private JTextField getJTextFieldInicio() {
		if (jTextFieldInicio == null) {
			jTextFieldInicio = new JTextField();
			jTextFieldInicio.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldInicioKeyTyped(evt);
				}
			});
		}
		return jTextFieldInicio;
	}
	
	private JTextField getJTextFieldFactor() {
		if (jTextFieldFactor == null) {
			jTextFieldFactor = new JTextField();
			jTextFieldFactor.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldFactorKeyTyped(evt);
				}
			});
		}
		return jTextFieldFactor;
	}
	
	private JTextField getJTextFieldRebaja() {
		if (jTextFieldRebaja == null) {
			jTextFieldRebaja = new JTextField();
			jTextFieldRebaja.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldRebajaKeyTyped(evt);
				}
			});
		}
		return jTextFieldRebaja;
	}
	
	private JPanel getJPanelFecha() {
		if (jPanelFecha == null) {
			jPanelFecha = new JPanel();
			jPanelFecha.add(getJLabelAnno());
			jPanelFecha.add(getJTextFieldAnno());
			jPanelFecha.add(getJLabelMes());
			jPanelFecha.add(getJTextFieldMes());
		}
		return jPanelFecha;
	}
	
	private JLabel getJLabelAnno() {
		if (jLabelAnno == null) {
			jLabelAnno = new JLabel();
			jLabelAnno.setText("Año : ");
		}
		return jLabelAnno;
	}
	
	private JTextField getJTextFieldAnno() {
		if (jTextFieldAnno == null) {
			jTextFieldAnno = new JTextField();
			jTextFieldAnno.setEditable(false);
			jTextFieldAnno.setPreferredSize(new java.awt.Dimension(54, 20));
		}
		return jTextFieldAnno;
	}
	
	private JLabel getJLabelMes() {
		if (jLabelMes == null) {
			jLabelMes = new JLabel();
			jLabelMes.setText("   Mes : ");
		}
		return jLabelMes;
	}
	
	private JTextField getJTextFieldMes() {
		if (jTextFieldMes == null) {
			jTextFieldMes = new JTextField();
			jTextFieldMes.setEditable(false);
			jTextFieldMes.setPreferredSize(new java.awt.Dimension(105, 20));
		}
		return jTextFieldMes;
	}
	
	private void jTextFieldInicioKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldInicio.getText());
	}
	
	private void jTextFieldFactorKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldFactor.getText());
	}
	
	private void jTextFieldRebajaKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldRebaja.getText());
	}


	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (jComboBoxImpuesto.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar un \"Tramo\".");
		}
		else if (jTextFieldInicio.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Inicio\".");
		}
		else if (jTextFieldFactor.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Factor\".");
		}
		else if (jTextFieldRebaja.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Rebaja\".");
		}
		else{
			this.respuesta(control.updateImpuesto(
					fecha,
					new Double(this.jComboBoxImpuesto.getSelectedItem().toString()), 
					new Double(this.jTextFieldInicio.getText()),
					new Double(this.jTextFieldFactor.getText()),
					new Double(this.jTextFieldRebaja.getText())
					));
			this.actualizarCombo();
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se modificó exitosamente.");
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Ya existe otro registro en el sistema con el nuevo inicio.");
		} else if (respuesta == control.respNoExisteMes) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el mes en el sistema.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el registro en el sistema.");
		}
	}
	
	private void jComboBoxImpuestoActionPerformed(ActionEvent evt) {
		this.actualizarDatos();
	}
	
	private void actualizarCombo() {
		this.jComboBoxImpuesto.setModel(control.getComboBoxModelImpuestoInicio(fecha));
		this.actualizarDatos();
	}
	
	private void actualizarDatos() {
		if (this.jComboBoxImpuesto.getSelectedIndex()!=-1) {
			this.jTextFieldFin.setText(control.getFin(fecha, new Double(this.jComboBoxImpuesto.getSelectedItem().toString())).toString());
			this.jTextFieldInicio.setText(this.jComboBoxImpuesto.getSelectedItem().toString());
			this.jTextFieldFactor.setText(control.getFactor(fecha, new Double(this.jComboBoxImpuesto.getSelectedItem().toString())).toString());
			this.jTextFieldRebaja.setText(control.getRebaja(fecha, new Double(this.jComboBoxImpuesto.getSelectedItem().toString())).toString());
			if (this.jComboBoxImpuesto.getSelectedIndex()==0) {
				this.jTextFieldInicio.setEnabled(false);
			} else {
				this.jTextFieldInicio.setEnabled(true);
			}

		}
	}
	
	public void actualizar(Date date) {
		this.fecha = date;
		this.jTextFieldAnno.setText(Fecha.getYear(fecha).toString());
		this.jTextFieldMes.setText(Fecha.getMonthString(fecha));
		this.actualizarCombo();
	}

}