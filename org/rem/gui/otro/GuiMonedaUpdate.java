package org.rem.gui.otro;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import org.rem.control.otro.ControlMoneda;
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
public class GuiMonedaUpdate extends JDialog {

	private ControlMoneda control = new ControlMoneda();  //  @jve:decl-index=0:
	private JPanel jPanelData;
	private JLabel jLabel1;
	private JPanel jPanelInformation;
	private JComboBox jComboBoxMoneda = new JComboBox();
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonUpdate;
	private JLabel jLabelTipo;
	private JComboBox jComboBoxTipo;

	/**
	 * This is the default constructor
	 */
	public GuiMonedaUpdate(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 215);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Modificar Moneda"));
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
			jPanel.add(getJLabelTipo(), "1, 1");
			jPanel.add(getJPanelButton(), "1, 4, 2, 4");
			jPanel.add(getJLabelRespuesta(), "1, 3, 2, 3");
			jPanel.add(jComboBoxMoneda, "2, 1");
			jComboBoxMoneda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jComboBoxMonedaActionPerformed(evt);
				}
			});
			jPanel.add(getJPanelInformation(), "1, 2, 2, 2");
		}
		return jPanel;
	}

	private JLabel getJLabelTipo() {
		if (jLabelTipo == null) {
			jLabelTipo = new JLabel();
			jLabelTipo.setText("Moneda : ");
		}
		return jLabelTipo;
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
			jPanelData.add(getJComboBoxTipo(), "1, 0");
		}
		return jPanelData;
	}
	
	private JLabel getJLabel1() {
		if (jLabel1 == null) {
			jLabel1 = new JLabel();
			jLabel1.setText("Tipo : ");
		}
		return jLabel1;
	}

	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (jComboBoxMoneda.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar una \"Moneda\".");
		}
		else if (jComboBoxTipo.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar un \"Tipo\".");
		}
		else{
			this.respuesta(control.updateMoneda( 
					(Double) this.jComboBoxMoneda.getSelectedItem(), 
					this.jComboBoxTipo.getSelectedItem().toString()));
			this.actualizarCampos();
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			jComboBoxMoneda.setModel(control.getComboBoxModelMonedaNoFijo());
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se actualizó exitosamente.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro no existe.");			
		} else if (respuesta == control.respFija) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro seleccionado no se puede actualizar.");						
		}
	}
	
	private void jComboBoxMonedaActionPerformed(ActionEvent evt) {
		this.actualizarCampos();
	}
	
	private void actualizarCampos() {
		if (this.jComboBoxMoneda.getSelectedIndex()!=-1) {
			this.jComboBoxTipo.setSelectedItem( control.getTipo(new Double(this.jComboBoxMoneda.getSelectedItem().toString()))); 
		}
	}
	
	public void actualizar() {
		this.jComboBoxMoneda.setModel(control.getComboBoxModelMonedaNoFijo());
		this.actualizarCampos();
	}
	
	private JComboBox getJComboBoxTipo() {
		if (jComboBoxTipo == null) {
			jComboBoxTipo = new JComboBox();
			jComboBoxTipo.setModel(Palabra.getComboBoxModelMonedaTipo());
		}
		return jComboBoxTipo;
	}
	
}