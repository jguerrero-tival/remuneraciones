package org.rem.gui.institucion;

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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import org.rem.control.institucion.ControlAfp;
import org.rem.util.Fecha;
import org.rem.util.Formato;
import org.rem.util.Message;
import org.rem.util.Palabra;
import org.rem.util.Pantalla;

@SuppressWarnings("serial")
public class GuiAfpAdd extends JDialog {

	private Date fecha = null;
	private ControlAfp control = new ControlAfp();
	private JLabel jLabelAnno;
	private JTextField jTextFieldAnno;
	private JTextField jTextFieldMes;
	private JLabel jLabelMes;
	private JPanel jPanelFecha;
	private JTextField jTextFieldCotizacion;
	private JComboBox jComboBoxRegimen;
	private JTextField jTextFieldNombre;
	private JLabel jLabelCotizacion;
	private JLabel jLabelRegimen;
	private JLabel jLabelNombre;
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonAdd;

	/**
	 * This is the default constructor
	 */
	public GuiAfpAdd(JDialog owner) {
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Agregar Afp"));
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
							TableLayout.PREFERRED, TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 6, 2, 6");
			jPanel.add(getJLabelRespuesta(), "1, 5, 2, 5");
			jPanel.add(getJLabelNombre(), "1, 2");
			jPanel.add(getJLabelRegimen(), "1, 3");
			jPanel.add(getJLabelCotizacion(), "1, 4");
			jPanel.add(getJTextFieldNombre(), "2, 2");
			jPanel.add(getJTextFieldCotizacion(), "2, 4");
			jPanel.add(getJPanelFecha(), "1, 1, 2, 1");
			jPanel.add(getJComboBoxRegimen(), "2, 3");
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

	private JLabel getJLabelNombre() {
		if (jLabelNombre == null) {
			jLabelNombre = new JLabel();
			jLabelNombre.setText("Nombre : ");
		}
		return jLabelNombre;
	}
	
	private JLabel getJLabelRegimen() {
		if (jLabelRegimen == null) {
			jLabelRegimen = new JLabel();
			jLabelRegimen.setText("Régimen: ");
		}
		return jLabelRegimen;
	}

	private JLabel getJLabelCotizacion() {
		if (jLabelCotizacion == null) {
			jLabelCotizacion = new JLabel();
			jLabelCotizacion.setText("Cotización (%) : ");
		}
		return jLabelCotizacion;
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
	
	private JTextField getJTextFieldCotizacion() {
		if (jTextFieldCotizacion == null) {
			jTextFieldCotizacion = new JTextField();
			jTextFieldCotizacion.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldCotizacionKeyTyped(evt);
				}
			});
		}
		return jTextFieldCotizacion;
	}
	
	private void jTextFieldNombreKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jTextFieldCotizacionKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldCotizacion.getText());
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
		if (jTextFieldNombre.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Nombre\".");
		} else if (this.jComboBoxRegimen.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar un \"Régimen\".");
		} else if (jTextFieldCotizacion.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Cotización\".");
		} else {
			this.respuesta(control.addAfp(
					fecha,
					this.jTextFieldNombre.getText().trim(),
					this.jComboBoxRegimen.getSelectedItem().toString(),
					new Double(this.jTextFieldCotizacion.getText().trim())));
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se agregó exitosamente.");
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Ya existe el registro en el sistema.");
		} else if (respuesta == control.respNoExisteMes) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el mes en el sistema.");
		}
	}
	
	public void actualizar(Date date) {
		this.fecha = date;
		this.jTextFieldAnno.setText(Fecha.getYear(fecha).toString());
		this.jTextFieldMes.setText(Fecha.getMonthString(fecha));
	}
	
	private JComboBox getJComboBoxRegimen() {
		if (jComboBoxRegimen == null) {
			jComboBoxRegimen = new JComboBox();
			jComboBoxRegimen.setModel(Palabra.getComboBoxModelAfpRegimen());
		}
		return jComboBoxRegimen;
	}

}