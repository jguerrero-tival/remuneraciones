package org.rem.gui.mes;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
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
public class GuiImpuestoAdd extends JDialog {

	private Date fecha = null;
	private ControlImpuesto control = new ControlImpuesto();
	private JLabel jLabelAnno;
	private JTextField jTextFieldAnno;
	private JTextField jTextFieldMes;
	private JLabel jLabelMes;
	private JPanel jPanelFecha;
	private JTextField jTextFieldRebaja;
	private JTextField jTextFieldFactor;
	private JTextField jTextFieldFin;
	private JTextField jTextFieldInicio;
	private JLabel jLabelRebaja;
	private JLabel jLabelFactor;
	private JLabel jLabelFin;
	private JLabel jLabelInicio;
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonAdd;

	/**
	 * This is the default constructor
	 */
	public GuiImpuestoAdd(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 265);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Agregar Tramo de Impuesto Único"));
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ 10.0, TableLayout.PREFERRED, TableLayout.FILL, 10.0 },
					{ 10.0, TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 7, 2, 7");
			jPanel.add(getJLabelRespuesta(), "1, 6, 2, 6");
			jPanel.add(getJLabelInicio(), "1, 2");
			jPanel.add(getJLabelFin(), "1, 3");
			jPanel.add(getJLabelFactor(), "1, 4");
			jPanel.add(getJLabelRebaja(), "1, 5");
			jPanel.add(getJTextFieldInicio(), "2, 2");
			jPanel.add(getJTextFieldFin(), "2, 3");
			jPanel.add(getJTextFieldFactor(), "2, 4");
			jPanel.add(getJTextFieldRebaja(), "2, 5");
			jPanel.add(getJPanelFecha(), "1, 1, 2, 1");
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
			jPanelButton.add(getJButtonAdd());
		}
		return jPanelButton;
	}
	
	private JButton getJButtonAdd() {
		if (jButtonAdd == null) {
			jButtonAdd = new JButton();
			jButtonAdd.setText("Agregar");
			jButtonAdd.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jButtonAddActionPerformed(evt);
				}
			});
		}
		return jButtonAdd;
	}

	private JLabel getJLabelInicio() {
		if (jLabelInicio == null) {
			jLabelInicio = new JLabel();
			jLabelInicio.setText("Inicio : ");
		}
		return jLabelInicio;
	}
	
	private JLabel getJLabelFin() {
		if (jLabelFin == null) {
			jLabelFin = new JLabel();
			jLabelFin.setText("Fin : ");
		}
		return jLabelFin;
	}
	
	private JLabel getJLabelFactor() {
		if (jLabelFactor == null) {
			jLabelFactor = new JLabel();
			jLabelFactor.setText("Factor : ");
		}
		return jLabelFactor;
	}
	
	private JLabel getJLabelRebaja() {
		if (jLabelRebaja == null) {
			jLabelRebaja = new JLabel();
			jLabelRebaja.setText("Rebaja : ");
		}
		return jLabelRebaja;
	}
	
	private JTextField getJTextFieldInicio() {
		if (jTextFieldInicio == null) {
			jTextFieldInicio = new JTextField();
			jTextFieldInicio.addCaretListener(new CaretListener() {
				public void caretUpdate(CaretEvent evt) {
					jTextFieldInicioCaretUpdate(evt);
				}
			});
			jTextFieldInicio.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldInicioKeyTyped(evt);
				}
			});
		}
		return jTextFieldInicio;
	}
	
	private JTextField getJTextFieldFin() {
		if (jTextFieldFin == null) {
			jTextFieldFin = new JTextField();
			jTextFieldFin.setEditable(false);
		}
		return jTextFieldFin;
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
	
	private void jTextFieldInicioKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldInicio.getText());
	}
	
	private void jTextFieldFactorKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldFactor.getText());
	}
	
	private void jTextFieldRebajaKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldRebaja.getText());
	}
	
	private void jTextFieldInicioCaretUpdate(CaretEvent evt) {
		if (this.jTextFieldInicio.getText().trim().length()>0) {
			this.jTextFieldFin.setText(control.getFin(fecha, new Double(jTextFieldInicio.getText())).toString());
		}
		else {
			this.jTextFieldFin.setText("");
		}
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
	
	private void jButtonAddActionPerformed(ActionEvent evt) {
		if (jTextFieldInicio.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Inicio\".");
		}
		else if (jTextFieldFactor.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Factor\".");
		}
		else if (jTextFieldRebaja.getText().trim().length()==0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Rebaja\".");
		}
		else{ 
			this.respuesta(control.addImpuesto(
					fecha,
					new Double(this.jTextFieldInicio.getText()),
					new Double(this.jTextFieldFactor.getText()),
					new Double(this.jTextFieldRebaja.getText())
					));
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se agregó exitosamente.");
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Ya existe un registro en el sistema con el \"inico\" ingresado.");
		} else if (respuesta == control.respNoExisteMes) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el mes en el sistema.");
		}
	}
	
	public void actualizar(Date date) {
		this.fecha = date;
		this.jTextFieldAnno.setText(Fecha.getYear(fecha).toString());
		this.jTextFieldMes.setText(Fecha.getMonthString(fecha));
	}

}