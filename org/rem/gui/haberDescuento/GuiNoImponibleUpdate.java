package org.rem.gui.haberDescuento;

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
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import org.rem.control.haberDescuento.ControlNoImponible;
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
public class GuiNoImponibleUpdate extends JDialog {

	private ControlNoImponible control = new ControlNoImponible();  //  @jve:decl-index=0:
	private JPanel jPanelData;
	private JTextField jTextFieldNombre;
	private JLabel jLabel1;
	private JPanel jPanelInformation;
	private JComboBox jComboBoxNoImponible = new JComboBox();
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonUpdate;
	private JLabel jLabelNombre;
	/**
	 * This is the default constructor
	 */
	public GuiNoImponibleUpdate(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 210);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Modificar Haber NoImponible"));
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
							TableLayout.PREFERRED, TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJLabelNombre(), "1, 1");
			jPanel.add(getJPanelButton(), "1, 4, 2, 4");
			jPanel.add(getJLabelRespuesta(), "1, 3, 2, 3");
			jPanel.add(jComboBoxNoImponible, "2, 1");
			jComboBoxNoImponible.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxNoImponibleActionPerformed(evt);
				}
			});
			jPanel.add(getJPanelInformation(), "1, 2, 2, 2");
		}
		return jPanel;
	}

	private JLabel getJLabelNombre() {
		if (jLabelNombre == null) {
			jLabelNombre = new JLabel();
			jLabelNombre.setText("NoImponible : ");
		}
		return jLabelNombre;
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
					{ TableLayout.PREFERRED } });
			jPanelDataLayout.setHGap(5);
			jPanelDataLayout.setVGap(5);
			jPanelData.setLayout(jPanelDataLayout);
			jPanelData.add(getJLabel1(), "0, 0");
			jPanelData.add(getJTextFieldNombre(), "1, 0");
		}
		return jPanelData;
	}
	
	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Nombre : ");
		}
		return jLabel1;
	}

	private void jTextFieldNombreKeyTyped(KeyEvent evt) {
		Formato.cadenaUpperCase(evt);
	}
	
	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (jComboBoxNoImponible.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar un \"NoImponible\".");
		}
		else if (this.jTextFieldNombre.getText().trim().length()<=0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar un \"Nombre\".");
		}
		else{
			this.respuesta(control.updateNoImponible( 
					this.jComboBoxNoImponible.getSelectedItem().toString(), 
					this.jTextFieldNombre.getText().trim()));
			this.actualizarCampos();
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se actualizó exitosamente.");
			this.actualizar();
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro no existe.");			
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro ya existe en el sistema.");			
		} else if (respuesta == control.respFija) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro seleccionado no se puede actualizar.");						
		} else if (respuesta == control.respBloqueado) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro seleccionado no se puede actualizar.");						
		}
	}
	
	private void jComboBoxNoImponibleActionPerformed(ActionEvent evt) {
		this.actualizarCampos();
	}
	
	private void actualizarCampos() {
		if (this.jComboBoxNoImponible.getSelectedIndex()!=-1) {
			this.jTextFieldNombre.setText( this.jComboBoxNoImponible.getSelectedItem().toString()); 
		}
	}
	
	public void actualizar() {
		this.jComboBoxNoImponible.setModel(control.getComboBoxModelNoImponibleNoBloqueadoNoFijo());
		this.actualizarCampos();
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

}