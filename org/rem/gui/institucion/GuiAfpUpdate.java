package org.rem.gui.institucion;

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
import org.rem.control.institucion.ControlAfp;
import org.rem.util.Fecha;
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
public class GuiAfpUpdate extends JDialog {

	private Date fecha = null;
	private ControlAfp control = new ControlAfp();
	private JPanel jPanelData;
	private JTextField jTextFieldAnno;
	private JTextField jTextFieldMes;
	private JLabel jLabelMes;
	private JLabel jLabelAnno;
	private JPanel jPanelFecha;
	private JTextField jTextFieldCotizacion;
	private JComboBox jComboBoxRegimen;
	private JTextField jTextFieldNombre;
	private JLabel jLabelNombre;
	private JLabel jLabelRegimen;
	private JLabel jLabelCotizacion;
	private JLabel jLabelAfp;
	private JPanel jPanelInformation;
	private JComboBox jComboBoxAfp;
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonUpdate;

	/**
	 * This is the default constructor
	 */
	public GuiAfpUpdate(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 295);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Modificar AFP"));
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}
	
	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {{10.0, TableLayout.PREFERRED, TableLayout.FILL, TableLayout.FILL, 10.0}, {10.0, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}});
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 5, 3, 5");
			jPanel.add(getJLabelRespuesta(), "1, 4, 3, 4");
			//jComboBoxAfp.setModel(control.getComboBoxModelAsignacionInicioAll());
			jPanel.add(getJComboBoxAfp(), "2, 2, 3, 2");
			jComboBoxAfp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxAfpActionPerformed(evt);
				}
			});
			jPanel.add(getJPanelInformation(), "1, 3, 3, 3");
			jPanel.add(getJLabelAfp(), "1, 2");
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
			TableLayout jPanelDataLayout = new TableLayout(new double[][] {{TableLayout.PREFERRED, TableLayout.FILL}, {TableLayout.PREFERRED, TableLayout.PREFERRED, TableLayout.PREFERRED}});
			jPanelDataLayout.setHGap(5);
			jPanelDataLayout.setVGap(5);
			jPanelData.setLayout(jPanelDataLayout);
			jPanelData.add(getJLabelCotizacion(), "0, 2");
			jPanelData.add(getJLabelRegimen(), "0, 1");
			jPanelData.add(getJTextFieldCotizacion(), "1, 2");
			jPanelData.add(getJLabelNombre(), "0, 0");
			jPanelData.add(getJTextFieldNombre(), "1, 0");
			jPanelData.add(getJComboBoxRegimen(), "1, 1");
		}
		return jPanelData;
	}

	private JComboBox getJComboBoxAfp() {
		if (jComboBoxAfp == null) {
			jComboBoxAfp = new JComboBox();
		}
		return jComboBoxAfp;
	}
	
	private JLabel getJLabelAfp() {
		if (jLabelAfp == null) {
			jLabelAfp = new JLabel();
			jLabelAfp.setText("Afp : ");
		}
		return jLabelAfp;
	}

	private JLabel getJLabelCotizacion() {
		if (jLabelCotizacion == null) {
			jLabelCotizacion = new JLabel();
			jLabelCotizacion.setText("Cotización (%) : ");
		}
		return jLabelCotizacion;
	}

	private JLabel getJLabelRegimen() {
		if (jLabelRegimen == null) {
			jLabelRegimen = new JLabel();
			jLabelRegimen.setText("Régimen : ");
		}
		return jLabelRegimen;
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
	
	private void jTextFieldCotizacionKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldCotizacion.getText());
	}


	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (jComboBoxAfp.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar una \"Afp\".");
		} else if (this.jTextFieldNombre.getText().trim().length()<=0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Nombre\".");
		} else if (jComboBoxRegimen.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar un \"Régimen\".");
		} else if (this.jTextFieldCotizacion.getText().trim().length()<=0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Cotización\".");
		} else{
			this.respuesta(control.updateAfp( 
					fecha,
					this.jComboBoxAfp.getSelectedItem().toString(), 
					this.jTextFieldNombre.getText().trim(),
					this.jComboBoxRegimen.getSelectedItem().toString(),
					new Double(this.jTextFieldCotizacion.getText().trim())));
			this.actualizarCombo();
		}
	}

	private void respuesta(int respuesta) {		
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se actualizó exitosamente.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro no existe en el sistema.");			
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro ya existe en el sistema.");			
		} else if (respuesta == control.respBloqueado) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro seleccionado no se puede actualizar.");						
		} else if (respuesta == control.respNoExisteMes) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el mes en el sistema.");
		}
	}
	
	private void jComboBoxAfpActionPerformed(ActionEvent evt) {
		this.actualizarDatos();
	}
	
	private void actualizarCombo() {
		this.jComboBoxAfp.setModel(control.getComboBoxModelAfpNoBloqueado(fecha));
		this.actualizarDatos();
	}
	
	private void actualizarDatos() {
		if (this.jComboBoxAfp.getSelectedIndex()!=-1) {
			this.jTextFieldNombre.setText(this.jComboBoxAfp.getSelectedItem().toString().trim());
			this.jTextFieldCotizacion.setText(control.getCotizacion(fecha, this.jComboBoxAfp.getSelectedItem().toString()).toString());
			this.jComboBoxRegimen.setSelectedItem(control.getRegimen(fecha, this.jComboBoxAfp.getSelectedItem().toString()));
		}
	}
	
	public void actualizar(Date date) {
		this.fecha = date;
		this.jTextFieldAnno.setText(Fecha.getYear(fecha).toString());
		this.jTextFieldMes.setText(Fecha.getMonthString(fecha));
		this.actualizarCombo();
	}
	
	private JLabel getJLabelNombre() {
		if(jLabelNombre == null) {
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
	
	private void jTextFieldNombreKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private JComboBox getJComboBoxRegimen() {
		if (jComboBoxRegimen == null) {
			jComboBoxRegimen = new JComboBox();
			jComboBoxRegimen.setModel(Palabra.getComboBoxModelAfpRegimen());
		}
		return jComboBoxRegimen;
	}

}