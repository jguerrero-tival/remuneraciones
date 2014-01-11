package org.rem.gui.otro;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import org.rem.control.otro.ControlMoneda;
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
public class GuiMonedaRemove extends JDialog {

	private ControlMoneda control = new ControlMoneda();  //  @jve:decl-index=0:
	private JComboBox jComboBoxMoneda = new JComboBox();
	private JLabel jLabelRespuesta;
	private JPanel jContentPane = null;
	private JPanel jPanel;
	private JPanel jPanelButton;
	private JButton jButtonRemove;
	private JLabel jLabelNombre;

	/**
	 * This is the default constructor
	 */
	public GuiMonedaRemove(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 160);
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
			jContentPane.setBorder(BorderFactory.createTitledBorder("Eliminar Moneda"));
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
							TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJLabelNombre(), "1, 1");
			jPanel.add(getJPanelButton(), "1, 3, 2, 3");
			jPanel.add(getJLabelRespuesta(), "1, 2, 2, 2");
			jPanel.add(jComboBoxMoneda, "2, 1");
		}
		return jPanel;
	}

	private JLabel getJLabelNombre() {
		if (jLabelNombre == null) {
			jLabelNombre = new JLabel();
			jLabelNombre.setText("Moneda : ");
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

	private void jButtonRemoveActionPerformed(ActionEvent evt) {
		if (jComboBoxMoneda.getSelectedIndex()==-1) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe seleccionar una \"Moneda\".");
		}
		else{
			this.respuesta(control.removeMoneda((Double)this.jComboBoxMoneda.getSelectedItem()));
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			this.actualizar();
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se eliminó exitosamente.");
		} else if (respuesta == control.respNoExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro no existe.");			
		} else if (respuesta == control.respFija) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "El registro seleccionado no se puede eliminar.");						
		}
	}
	
	public void actualizar() {
		jComboBoxMoneda.setModel(control.getComboBoxModelMonedaNoFijo());
	}

}