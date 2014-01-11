package org.rem.gui.institucion;

import info.clearthought.layout.TableLayout;
import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JLabel;
import org.rem.control.institucion.ControlIsapre;
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
public class GuiIsapreAdd extends JDialog {

	private ControlIsapre control = new ControlIsapre();

	private JTextField jTextFieldNombre;

	private JLabel jLabelNombre;

	private JLabel jLabelRespuesta;

	private JPanel jContentPane = null;

	private JPanel jPanel;

	private JPanel jPanelButton;

	private JButton jButtonAdd;

	/**
	 * This is the default constructor
	 */
	public GuiIsapreAdd(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(400, 155);
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
					.createTitledBorder("Agregar Isapre"));
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
			jPanel.add(getJPanelButton(), "1, 3, 2, 3");
			jPanel.add(getJLabelRespuesta(), "1, 2, 2, 2");
			jPanel.add(getJLabelNombre(), "1, 1");
			jPanel.add(getJTextFieldNombre(), "2, 1");
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

	private void jButtonAddActionPerformed(ActionEvent evt) {
		if (jTextFieldNombre.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Nombre\".");
		} else {
			this.respuesta(control.addIsapre(this.jTextFieldNombre.getText().trim()));
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se agregó exitosamente.");
			this.actualizar();
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Ya existe el registro en el sistema.");

		}
	}

	public void actualizar() {
		this.jTextFieldNombre.setText("");		
	}
	
}