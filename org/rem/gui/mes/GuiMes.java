package org.rem.gui.mes;

import info.clearthought.layout.TableLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import java.awt.CardLayout;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.border.TitledBorder;

import org.rem.control.mes.ControlMes;
import org.rem.control.mes.ControlTableModelMes;
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
public class GuiMes extends JDialog {

	private ControlMes control = new ControlMes();
	private ControlTableModelMes controlModel = new ControlTableModelMes();
	private GuiMesAdd guiAdd = new GuiMesAdd(this);
	private GuiMesUpdate guiUpdate = new GuiMesUpdate(this);
	private JPanel jPanelMes2;
	private JPanel jPanelMesButton;
	private JTextField jTextFieldUtm;
	private JTextField jTextFieldUf;
	private JTextField jTextFieldSueldoMinimo;
	private JLabel jLabelUtm;
	private JLabel jLabelUf;
	private JLabel jLabelSueldoMinimo;
	private JPanel jPanelMensual2;
	private JPanel jPanelMensual;
	private JTextField jTextFieldGratificacionFactorAnual;
	private JTextField jTextFieldGratificacionPorcentaje;
	private JLabel jLabelGratificacionFactorAnual;
	private JLabel jLabelGratificacionPorcentaje;
	private JPanel jPanelGratificacion2;
	private JPanel jPanelGratificacion;
	private JTextField jTextFieldSeguroCesantiaTope;
	private JTextField jTextFieldSeguroCesantiaPorcentaje;
	private JLabel jLabelSeguroCesantiaTope;
	private JLabel jLabelSeguroCesantiaPorcentaje;
	private JPanel jPanelSeguroCesantia2;
	private JPanel jPanelSeguroCesantia;
	private JTextField jTextFieldSaludTope;
	private JTextField jTextFieldSaludCotizacionBasica;
	private JLabel jLabelSaludTope;
	private JLabel jLabelSaludCotizacionBasica;
	private JPanel jPanelSalud2;
	private JPanel jPanelSalud;
	private JTextField jTextFieldMutualCotizacionBasica;
	private JLabel jLabelMutualCotizacionBasica;
	private JPanel jPanelMutual2;
	private JPanel jPanelMutual;
	private JTextField jTextFieldApvTope;
	private JTextField jTextFieldAfpTope;
	private JTextField jTextFieldSeguroInvalidez;
	private JLabel jLabelApvTope;
	private JLabel jLabelAfpTope;
	private JLabel jLabelSeguroInvalidez;
	private JPanel jPanelPrevision2;
	private JPanel jPanelPrevision;
	private JPanel jPanelVariablesContent;
	private JButton jButtonUpdate;
	private JPanel jPanelVariablesButton;
	private JPanel jPanelVariables2;
	private JButton jButtonAdd;

	private static final long serialVersionUID = 1L;

	private JPanel jPanel;

	private JPanel jPanelTable;

	private JScrollPane jScrollPaneTable;
	private JPanel jPanelVariables;
	private JPanel jPanelMes;

	private JTable jTable;

	private JPanel jContentPane = null;

	/**
	 * @param owner
	 */
	public GuiMes(Frame owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 600);
		this.setContentPane(getJContentPane());
		this.setLocation(Pantalla.centrar(this.getSize()));
		this.setResizable(false);
		this.setModal(true);
		this.setDefaultCloseOperation(JDialog.HIDE_ON_CLOSE);
		this.actualizar();
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
					.createTitledBorder("Variables Mensuales"));
			jContentPane.add(getJPanel(), "jPanel");
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ TableLayout.FILL }, { TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelTable(), "0,    0");
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
			jPanelTable.add(getJPanelMes(), "0, 0");
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
			jTable.addMouseListener(new MouseAdapter() {
				public void mouseReleased(MouseEvent evt) {
					jTableMouseReleased(evt);
				}
			});
		}
		return jTable;
	}

	private JPanel getJPanelMes() {
		if (jPanelMes == null) {
			jPanelMes = new JPanel();
			CardLayout jPanelMesLayout = new CardLayout();
			jPanelMes.setLayout(jPanelMesLayout);
			jPanelMes.setBorder(BorderFactory.createTitledBorder("Mes"));
			jPanelMes.add(getJPanelMes2(), "jPanelMes2");
		}
		return jPanelMes;
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
	
	private JPanel getJPanelMes2() {
		if (jPanelMes2 == null) {
			jPanelMes2 = new JPanel();
			TableLayout jPanelMes2Layout = new TableLayout(new double[][] {
					{ TableLayout.FILL },
					{ TableLayout.FILL, TableLayout.PREFERRED } });
			jPanelMes2Layout.setHGap(5);
			jPanelMes2Layout.setVGap(5);
			jPanelMes2.setLayout(jPanelMes2Layout);
			jPanelMes2.add(getJScrollPaneTable(), "0, 0");
			jPanelMes2.add(getJPanelMesButton(), "0, 1");
		}
		return jPanelMes2;
	}
	
	private JPanel getJPanelMesButton() {
		if (jPanelMesButton == null) {
			jPanelMesButton = new JPanel();
			jPanelMesButton.add(getJButtonAdd());
		}
		return jPanelMesButton;
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
	
	private JPanel getJPanelVariables2() {
		if (jPanelVariables2 == null) {
			jPanelVariables2 = new JPanel();
			TableLayout jPanelVariables2Layout = new TableLayout(
				new double[][] { { TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.FILL } });
			jPanelVariables2Layout.setHGap(5);
			jPanelVariables2Layout.setVGap(5);
			jPanelVariables2.setLayout(jPanelVariables2Layout);
			jPanelVariables2.add(getJPanelVariablesButton(), "0, 1");
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
	
	private JPanel getJPanelVariablesContent() {
		if (jPanelVariablesContent == null) {
			jPanelVariablesContent = new JPanel();
			TableLayout jPanelVariablesContentLayout = new TableLayout(
				new double[][] {
						{ TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.PREFERRED, TableLayout.PREFERRED } });
			jPanelVariablesContentLayout.setHGap(5);
			jPanelVariablesContentLayout.setVGap(5);
			jPanelVariablesContent.setLayout(jPanelVariablesContentLayout);
			jPanelVariablesContent.add(getJPanelMensual(), "0,  0");
			jPanelVariablesContent.add(getJPanelPrevision(), "0, 1");
			jPanelVariablesContent.add(getJPanelMutual(), "0, 2");
			jPanelVariablesContent.add(getJPanelSalud(), "0, 3");
			jPanelVariablesContent.add(getJPanelSeguroCesantia(), "0, 4");
			jPanelVariablesContent.add(getJPanelGratificacion(), "0, 5");
		}
		return jPanelVariablesContent;
	}
	
	private JPanel getJPanelPrevision() {
		if (jPanelPrevision == null) {
			jPanelPrevision = new JPanel();
			CardLayout jPanelPrevisionLayout = new CardLayout();
			jPanelPrevision.setBorder(BorderFactory.createTitledBorder(
				null,
				"Previsión",
				TitledBorder.LEADING,
				TitledBorder.TOP));
			jPanelPrevision.setLayout(jPanelPrevisionLayout);
			jPanelPrevision.add(getJPanelPrevision2(), "jPanelPrevision2");
		}
		return jPanelPrevision;
	}
	
	private JPanel getJPanelPrevision2() {
		if (jPanelPrevision2 == null) {
			jPanelPrevision2 = new JPanel();
			TableLayout jPanelPrevision2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED } });
			jPanelPrevision2Layout.setHGap(5);
			jPanelPrevision2Layout.setVGap(5);
			jPanelPrevision2.setLayout(jPanelPrevision2Layout);
			jPanelPrevision2.add(getJLabelAfpTope(), "0,    0");
			jPanelPrevision2.add(getJLabelApvTope(), "0,    1");
			jPanelPrevision2.add(getJLabelSeguroInvalidez(), "0,    2");
			jPanelPrevision2.add(getJTextFieldAfpTope(), "1,    0");
			jPanelPrevision2.add(getJTextFieldApvTope(), "1,    1");
			jPanelPrevision2.add(getJTextFieldSeguroInvalidez(), "1,    2");
		}
		return jPanelPrevision2;
	}
	
	private JLabel getJLabelAfpTope() {
		if (jLabelAfpTope == null) {
			jLabelAfpTope = new JLabel();
			jLabelAfpTope.setText("Tope de Afp (UF): ");
		}
		return jLabelAfpTope;
	}
	
	private JLabel getJLabelApvTope() {
		if (jLabelApvTope == null) {
			jLabelApvTope = new JLabel();
			jLabelApvTope.setText("Tope de Apv (UF): ");
		}
		return jLabelApvTope;
	}
	
	private JLabel getJLabelSeguroInvalidez() {
		if (jLabelSeguroInvalidez == null) {
			jLabelSeguroInvalidez = new JLabel();
			jLabelSeguroInvalidez.setText("Seguro Invalidez (%): ");
		}
		return jLabelSeguroInvalidez;
	}
	
	private JTextField getJTextFieldAfpTope() {
		if (jTextFieldAfpTope == null) {
			jTextFieldAfpTope = new JTextField();
			jTextFieldAfpTope.setEditable(false);
		}
		return jTextFieldAfpTope;
	}
	
	private JTextField getJTextFieldApvTope() {
		if (jTextFieldApvTope == null) {
			jTextFieldApvTope = new JTextField();
			jTextFieldApvTope.setEditable(false);
		}
		return jTextFieldApvTope;
	}

	private JTextField getJTextFieldSeguroInvalidez() {
		if (jTextFieldSeguroInvalidez == null) {
			jTextFieldSeguroInvalidez = new JTextField();
			jTextFieldSeguroInvalidez.setEditable(false);
		}
		return jTextFieldSeguroInvalidez;
	}
	
	private JPanel getJPanelMutual() {
		if (jPanelMutual == null) {
			jPanelMutual = new JPanel();
			CardLayout jPanelMutualLayout = new CardLayout();
			jPanelMutual.setBorder(BorderFactory
				.createTitledBorder("Mutual de Seguridad"));
			jPanelMutual.setLayout(jPanelMutualLayout);
			jPanelMutual.add(getJPanelMutual2(), "jPanelMutual2");
		}
		return jPanelMutual;
	}
	
	private JPanel getJPanelMutual2() {
		if (jPanelMutual2 == null) {
			jPanelMutual2 = new JPanel();
			TableLayout jPanelMutual2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL },
					{ TableLayout.FILL } });
			jPanelMutual2Layout.setHGap(5);
			jPanelMutual2Layout.setVGap(5);
			jPanelMutual2.setLayout(jPanelMutual2Layout);
			jPanelMutual2.add(getJLabelMutualCotizacionBasica(), "0,    0");
			jPanelMutual2.add(getJTextFieldMutualCotizacionBasica(), "1,    0");
		}
		return jPanelMutual2;
	}
	
	private JLabel getJLabelMutualCotizacionBasica() {
		if (jLabelMutualCotizacionBasica == null) {
			jLabelMutualCotizacionBasica = new JLabel();
			jLabelMutualCotizacionBasica.setText("Cotización Básica (%): ");
		}
		return jLabelMutualCotizacionBasica;
	}
	
	private JTextField getJTextFieldMutualCotizacionBasica() {
		if (jTextFieldMutualCotizacionBasica == null) {
			jTextFieldMutualCotizacionBasica = new JTextField();
			jTextFieldMutualCotizacionBasica.setEditable(false);
		}
		return jTextFieldMutualCotizacionBasica;
	}
	
	private JPanel getJPanelSalud() {
		if (jPanelSalud == null) {
			jPanelSalud = new JPanel();
			CardLayout jPanelSaludLayout = new CardLayout();
			jPanelSalud.setBorder(BorderFactory.createTitledBorder("Salud"));
			jPanelSalud.setLayout(jPanelSaludLayout);
			jPanelSalud.add(getJPanelSalud2(), "jPanelSalud2");
		}
		return jPanelSalud;
	}
	
	private JPanel getJPanelSalud2() {
		if (jPanelSalud2 == null) {
			jPanelSalud2 = new JPanel();
			TableLayout jPanelSalud2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL },
					{ TableLayout.FILL, TableLayout.FILL } });
			jPanelSalud2Layout.setHGap(5);
			jPanelSalud2Layout.setVGap(5);
			jPanelSalud2.setLayout(jPanelSalud2Layout);
			jPanelSalud2.add(getJLabelSaludCotizacionBasica(), "0,    0");
			jPanelSalud2.add(getJLabelSaludTope(), "0,    1");
			jPanelSalud2.add(getJTextFieldSaludCotizacionBasica(), "1,    0");
			jPanelSalud2.add(getJTextFieldSaludTope(), "1,    1");
		}
		return jPanelSalud2;
	}
	
	private JLabel getJLabelSaludCotizacionBasica() {
		if (jLabelSaludCotizacionBasica == null) {
			jLabelSaludCotizacionBasica = new JLabel();
			jLabelSaludCotizacionBasica.setText("Cotización Básica (%): ");
		}
		return jLabelSaludCotizacionBasica;
	}
	
	private JLabel getJLabelSaludTope() {
		if (jLabelSaludTope == null) {
			jLabelSaludTope = new JLabel();
			jLabelSaludTope.setText("Tope (UF): ");
		}
		return jLabelSaludTope;
	}
	
	private JTextField getJTextFieldSaludCotizacionBasica() {
		if (jTextFieldSaludCotizacionBasica == null) {
			jTextFieldSaludCotizacionBasica = new JTextField();
			jTextFieldSaludCotizacionBasica.setEditable(false);
		}
		return jTextFieldSaludCotizacionBasica;
	}
	
	private JTextField getJTextFieldSaludTope() {
		if (jTextFieldSaludTope == null) {
			jTextFieldSaludTope = new JTextField();
			jTextFieldSaludTope.setEditable(false);
		}
		return jTextFieldSaludTope;
	}
	
	private JPanel getJPanelSeguroCesantia() {
		if (jPanelSeguroCesantia == null) {
			jPanelSeguroCesantia = new JPanel();
			CardLayout jPanelSeguroCesantiaLayout = new CardLayout();
			jPanelSeguroCesantia.setBorder(BorderFactory
				.createTitledBorder("Seguro de Cesantía"));
			jPanelSeguroCesantia.setLayout(jPanelSeguroCesantiaLayout);
			jPanelSeguroCesantia.add(getJPanelSeguroCesantia2(), "jPanelSeguroCesantia2");
		}
		return jPanelSeguroCesantia;
	}
	
	private JPanel getJPanelSeguroCesantia2() {
		if (jPanelSeguroCesantia2 == null) {
			jPanelSeguroCesantia2 = new JPanel();
			TableLayout jPanelSeguroCesantia2Layout = new TableLayout(
				new double[][] { { TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.FILL, TableLayout.FILL } });
			jPanelSeguroCesantia2Layout.setHGap(5);
			jPanelSeguroCesantia2Layout.setVGap(5);
			jPanelSeguroCesantia2.setLayout(jPanelSeguroCesantia2Layout);
			jPanelSeguroCesantia2.add(getJLabelSeguroCesantiaPorcentaje(), "0,    0");
			jPanelSeguroCesantia2.add(getJLabelSeguroCesantiaTope(), "0,    1");
			jPanelSeguroCesantia2.add(getJTextFieldSeguroCesantiaPorcentaje(), "1,    0");
			jPanelSeguroCesantia2.add(getJTextFieldSeguroCesantiaTope(), "1,    1");
		}
		return jPanelSeguroCesantia2;
	}
	
	private JLabel getJLabelSeguroCesantiaPorcentaje() {
		if (jLabelSeguroCesantiaPorcentaje == null) {
			jLabelSeguroCesantiaPorcentaje = new JLabel();
			jLabelSeguroCesantiaPorcentaje.setText("Porcentaje (%): ");
		}
		return jLabelSeguroCesantiaPorcentaje;
	}
	
	private JLabel getJLabelSeguroCesantiaTope() {
		if (jLabelSeguroCesantiaTope == null) {
			jLabelSeguroCesantiaTope = new JLabel();
			jLabelSeguroCesantiaTope.setText("Tope (UF): ");
		}
		return jLabelSeguroCesantiaTope;
	}
	
	private JTextField getJTextFieldSeguroCesantiaPorcentaje() {
		if (jTextFieldSeguroCesantiaPorcentaje == null) {
			jTextFieldSeguroCesantiaPorcentaje = new JTextField();
			jTextFieldSeguroCesantiaPorcentaje.setEditable(false);
		}
		return jTextFieldSeguroCesantiaPorcentaje;
	}
	
	private JTextField getJTextFieldSeguroCesantiaTope() {
		if (jTextFieldSeguroCesantiaTope == null) {
			jTextFieldSeguroCesantiaTope = new JTextField();
			jTextFieldSeguroCesantiaTope.setEditable(false);
		}
		return jTextFieldSeguroCesantiaTope;
	}
	
	private JPanel getJPanelGratificacion() {
		if (jPanelGratificacion == null) {
			jPanelGratificacion = new JPanel();
			CardLayout jPanelGratificacionLayout = new CardLayout();
			jPanelGratificacion.setBorder(BorderFactory
				.createTitledBorder("Gratificación"));
			jPanelGratificacion.setLayout(jPanelGratificacionLayout);
			jPanelGratificacion.add(getJPanelGratificacion2(), "jPanelGratificacion2");
		}
		return jPanelGratificacion;
	}
	
	private JPanel getJPanelGratificacion2() {
		if (jPanelGratificacion2 == null) {
			jPanelGratificacion2 = new JPanel();
			TableLayout jPanelGratificacion2Layout = new TableLayout(
				new double[][] { { TableLayout.PREFERRED, TableLayout.FILL },
						{ TableLayout.FILL, TableLayout.FILL } });
			jPanelGratificacion2Layout.setHGap(5);
			jPanelGratificacion2Layout.setVGap(5);
			jPanelGratificacion2.setLayout(jPanelGratificacion2Layout);
			jPanelGratificacion2.add(getJLabelGratificacionPorcentaje(), "0,    0");
			jPanelGratificacion2.add(getJLabelGratificacionFactorAnual(), "0,    1");
			jPanelGratificacion2.add(getJTextFieldGratificacionPorcentaje(), "1,    0");
			jPanelGratificacion2.add(getJTextFieldGratificacionFactorAnual(), "1,    1");
		}
		return jPanelGratificacion2;
	}
	
	private JLabel getJLabelGratificacionPorcentaje() {
		if (jLabelGratificacionPorcentaje == null) {
			jLabelGratificacionPorcentaje = new JLabel();
			jLabelGratificacionPorcentaje.setText("Porcentaje (%): ");
		}
		return jLabelGratificacionPorcentaje;
	}
	
	private JLabel getJLabelGratificacionFactorAnual() {
		if (jLabelGratificacionFactorAnual == null) {
			jLabelGratificacionFactorAnual = new JLabel();
			jLabelGratificacionFactorAnual.setText("Factor Anual : ");
		}
		return jLabelGratificacionFactorAnual;
	}
	
	private JTextField getJTextFieldGratificacionPorcentaje() {
		if (jTextFieldGratificacionPorcentaje == null) {
			jTextFieldGratificacionPorcentaje = new JTextField();
			jTextFieldGratificacionPorcentaje.setEditable(false);
		}
		return jTextFieldGratificacionPorcentaje;
	}
	
	private JTextField getJTextFieldGratificacionFactorAnual() {
		if (jTextFieldGratificacionFactorAnual == null) {
			jTextFieldGratificacionFactorAnual = new JTextField();
			jTextFieldGratificacionFactorAnual.setEditable(false);
		}
		return jTextFieldGratificacionFactorAnual;
	}
	
	private JPanel getJPanelMensual() {
		if (jPanelMensual == null) {
			jPanelMensual = new JPanel();
			CardLayout jPanelMensualLayout = new CardLayout();
			jPanelMensual.setLayout(jPanelMensualLayout);
			jPanelMensual.setBorder(BorderFactory.createTitledBorder("Mes"));
			jPanelMensual.add(getJPanelMensual2(), "jPanelMensual2");
		}
		return jPanelMensual;
	}
	
	private JPanel getJPanelMensual2() {
		if (jPanelMensual2 == null) {
			jPanelMensual2 = new JPanel();
			TableLayout jPanelMensual2Layout = new TableLayout(new double[][] {
					{ TableLayout.PREFERRED, TableLayout.FILL },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED } });
			jPanelMensual2Layout.setHGap(5);
			jPanelMensual2Layout.setVGap(5);
			jPanelMensual2.setLayout(jPanelMensual2Layout);
			jPanelMensual2.add(getJLabelSueldoMinimo(), "0, 0");
			jPanelMensual2.add(getJLabelUf(), "0, 1");
			jPanelMensual2.add(getJLabelUtm(), "0, 2");
			jPanelMensual2.add(getJTextFieldSueldoMinimo(), "1, 0");
			jPanelMensual2.add(getJTextFieldUf(), "1, 1");
			jPanelMensual2.add(getJTextFieldUtm(), "1, 2");
		}
		return jPanelMensual2;
	}
	
	private JLabel getJLabelSueldoMinimo() {
		if (jLabelSueldoMinimo == null) {
			jLabelSueldoMinimo = new JLabel();
			jLabelSueldoMinimo.setText("Sueldo Mínimo ($) : ");
		}
		return jLabelSueldoMinimo;
	}
	
	private JLabel getJLabelUf() {
		if (jLabelUf == null) {
			jLabelUf = new JLabel();
			jLabelUf.setText("U.F. ($) : ");
		}
		return jLabelUf;
	}
	
	private JLabel getJLabelUtm() {
		if (jLabelUtm == null) {
			jLabelUtm = new JLabel();
			jLabelUtm.setText("U.T.M. ($) : ");
		}
		return jLabelUtm;
	}
	
	private JTextField getJTextFieldSueldoMinimo() {
		if (jTextFieldSueldoMinimo == null) {
			jTextFieldSueldoMinimo = new JTextField();
			jTextFieldSueldoMinimo.setEditable(false);
		}
		return jTextFieldSueldoMinimo;
	}
	
	private JTextField getJTextFieldUf() {
		if (jTextFieldUf == null) {
			jTextFieldUf = new JTextField();
			jTextFieldUf.setEditable(false);
		}
		return jTextFieldUf;
	}
	
	private JTextField getJTextFieldUtm() {
		if (jTextFieldUtm == null) {
			jTextFieldUtm = new JTextField();
			jTextFieldUtm.setEditable(false);
		}
		return jTextFieldUtm;
	}
	
	private void jButtonAddActionPerformed(ActionEvent evt) {
		this.guiAdd.actualizar();
		this.guiAdd.setVisible(true);
		this.actualizar();
	}
	
	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		this.guiUpdate.actualizar(((TableModelMes) jTable.getModel()).getObject(jTable.getSelectedRow()).getFecha());
		this.guiUpdate.setVisible(true);
		this.actualizarDatos();
	}

	private void jTableMouseReleased(MouseEvent evt) {
		this.actualizarDatos();
	}
	
	private void actualizarDatos() {
		if (jTable.getSelectedRow()!=-1) {
			Date fecha = ((TableModelMes) jTable.getModel()).getObject(jTable.getSelectedRow()).getFecha();
			this.jTextFieldSueldoMinimo.setText(control.getSueldoMinimo(fecha).toString());
			this.jTextFieldUf.setText(control.getUf(fecha).toString());
			this.jTextFieldUtm.setText(control.getUtm(fecha).toString());
			this.jTextFieldAfpTope.setText(control.getPrevisionAfpTope(fecha).toString());
			this.jTextFieldApvTope.setText(control.getPrevisionApvTope(fecha).toString());
			this.jTextFieldSeguroInvalidez.setText(control.getPrevisionSeguroInvalidez(fecha).toString());
			this.jTextFieldMutualCotizacionBasica.setText(control.getMutualCotizacionBasica(fecha).toString());
			this.jTextFieldSaludCotizacionBasica.setText(control.getSaludCotizacionBasica(fecha).toString());
			this.jTextFieldSaludTope.setText(control.getSaludTope(fecha).toString());
			this.jTextFieldSeguroCesantiaPorcentaje.setText(control.getSeguroCesantiaPorcentaje(fecha).toString());
			this.jTextFieldSeguroCesantiaTope.setText(control.getSeguroCesantiaTope(fecha).toString());
			this.jTextFieldGratificacionPorcentaje.setText(control.getGratificacionPorcentaje(fecha).toString());
			this.jTextFieldGratificacionFactorAnual.setText(control.getGratificacionFactorAnual(fecha).toString());
			this.jButtonUpdate.setEnabled(true);
		} else {
			this.jTextFieldSueldoMinimo.setText("");
			this.jTextFieldUf.setText("");
			this.jTextFieldUtm.setText("");
			this.jTextFieldAfpTope.setText("");
			this.jTextFieldApvTope.setText("");
			this.jTextFieldSeguroInvalidez.setText("");
			this.jTextFieldMutualCotizacionBasica.setText("");
			this.jTextFieldSaludCotizacionBasica.setText("");
			this.jTextFieldSaludTope.setText("");
			this.jTextFieldSeguroCesantiaPorcentaje.setText("");
			this.jTextFieldSeguroCesantiaTope.setText("");
			this.jTextFieldGratificacionPorcentaje.setText("");
			this.jTextFieldGratificacionFactorAnual.setText("");
			this.jButtonUpdate.setEnabled(false);
		}
	}
	
	private void actualizar() {
		this.jTable.setModel(controlModel.getTableModelMes());
		this.actualizarDatos();
	}

}