package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
import org.rem.util.Formato;
import java.awt.Font;
import java.awt.Color;

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
public class GuiEmpresa extends JPanel {

	private static final long serialVersionUID = 1L;

	public JTextField jTextFieldColegio;
	public JFormattedTextField jFormattedTextFieldRutEmpresa;
	private JLabel jLabelColegio;
	public JTextField jTextFieldActividadEconomica;
	public JTextField jTextFieldMail;
	public JTextField jTextFieldFono;
	public JTextField jTextFieldRazonSocial;
	private JLabel jLabelActividadEconomica;
	private JLabel jLabelMail;
	private JLabel jLabelFono;
	private JLabel jLabelRazonSocial;
	private JLabel jLabelRutEmpresa;
	private JPanel jPanelEmpresa2;

	public JButton jButtonTrabajadorUpdate;

	public JButton jButtonTrabajadorAdd;

	public JList jListTrabajador;

	/**
	 * This is the default constructor
	 */
	public GuiEmpresa() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 100);
		CardLayout thisLayout = new CardLayout();
		this.setLayout(thisLayout);
		this.setBorder(BorderFactory.createTitledBorder(null, "Empresa",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		{
			jPanelEmpresa2 = new JPanel();
			this.add(jPanelEmpresa2, "jPanelEmpresa2");
			TableLayout jPanelEmpresa2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, 90.0, TableLayout.PREFERRED,
							TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED } });
			jPanelEmpresa2Layout.setHGap(5);
			jPanelEmpresa2Layout.setVGap(5);
			jPanelEmpresa2.setLayout(jPanelEmpresa2Layout);
			{
				jLabelRutEmpresa = new JLabel();
				jPanelEmpresa2.add(jLabelRutEmpresa, "0,    0");
				jLabelRutEmpresa.setText("R.U.T : ");
			}
			{
				jLabelRazonSocial = new JLabel();
				jPanelEmpresa2.add(jLabelRazonSocial, "2,    0");
				jLabelRazonSocial.setText("Razón Social : ");
			}
			{
				jLabelFono = new JLabel();
				jPanelEmpresa2.add(jLabelFono, "0,    2");
				jLabelFono.setText("Fono : ");
			}
			{
				jLabelMail = new JLabel();
				jPanelEmpresa2.add(jLabelMail, "2,    2");
				jLabelMail.setText("e-mail : ");
			}
			{
				jLabelActividadEconomica = new JLabel();
				jPanelEmpresa2.add(jLabelActividadEconomica, "2,    1");
				jLabelActividadEconomica.setText("Actividad Económica : ");
			}
			{
				jTextFieldRazonSocial = new JTextField();
				jPanelEmpresa2.add(jTextFieldRazonSocial, "3,    0");
				jTextFieldRazonSocial.setEditable(false);
			}
			{
				jTextFieldFono = new JTextField();
				jPanelEmpresa2.add(jTextFieldFono, "1,    2");
				jTextFieldFono.setEditable(false);
			}
			{
				jTextFieldMail = new JTextField();
				jPanelEmpresa2.add(jTextFieldMail, "3,    2");
				jTextFieldMail.setEditable(false);
			}
			{
				jTextFieldActividadEconomica = new JTextField();
				jPanelEmpresa2.add(jTextFieldActividadEconomica, "3,    1");
				jTextFieldActividadEconomica.setEditable(false);
			}
			{
				jLabelColegio = new JLabel();
				jPanelEmpresa2.add(jLabelColegio, "0,    1");
				jLabelColegio.setText("Colegio : ");
			}
			{
				jFormattedTextFieldRutEmpresa = new JFormattedTextField(Formato
					.getMaskRut());
				jPanelEmpresa2.add(jFormattedTextFieldRutEmpresa, "1,    0");
				jFormattedTextFieldRutEmpresa.setEditable(false);
			}
			{
				jTextFieldColegio = new JTextField();
				jPanelEmpresa2.add(jTextFieldColegio, "1, 1");
				jTextFieldColegio.setEditable(false);
			}
		}

	}

}