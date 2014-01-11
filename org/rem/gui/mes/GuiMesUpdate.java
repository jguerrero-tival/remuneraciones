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
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JDialog;
import javax.swing.JLabel;
import org.rem.control.mes.ControlMes;
import org.rem.util.Fecha;
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
public class GuiMesUpdate extends JDialog {

	private Date fecha = null;
	private ControlMes control = new ControlMes();
	private JPanel jPanelPrevision2;
	private JLabel jLabelMutualCotizacionBasica;
	private JPanel jPanelMutual2;
	private JPanel jPanelMutual;
	private JTextField jTextFieldApvTope;
	private JTextField jTextFieldAfpTope;
	private JTextField jTextFieldSeguroInvalidez;
	private JLabel jLabelApvTope;
	private JLabel jLabelAfpTope;
	private JLabel jLabelSeguroInvalidez;
	private JTextField jTextFieldMutualCotizacionBasica;
	private JTextField jTextFieldSaludCotizacionBasica;
	private JTextField jTextFieldMes;
	private JTextField jTextFieldAnno;
	private JLabel jLabelGratificacionFactorAnual;
	private JLabel jLabelMes;
	private JLabel jLabelAnno;
	private JPanel jPanelFecha;
	private JTextField jTextFieldGratificacionFactorAnual;
	private JTextField jTextFieldGratificacionPorcentaje;
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
	private JLabel jLabelSaludTope;
	private JLabel jLabelSaludCotizacionBasica;
	private JPanel jPanelSalud2;
	private JPanel jPanelSalud;
	private JPanel jPanelPrevision;
	private JTextField jTextFieldUtm;
	private JTextField jTextFieldUf;
	private JTextField jTextFieldSueldoMinimo;
	private JPanel jPanelContentLeft;
	private JPanel jPanelContentRight;
	private JLabel jLabelUtm;
	private JLabel jLabelUf;
	private JLabel jLabelSueldoMinimo;
	private JPanel jPanelMensual2;
	private JPanel jPanelMensual;

	private JLabel jLabelRespuesta;

	private JPanel jContentPane = null;

	private JPanel jPanel;

	private JPanel jPanelButton;

	private JButton jButtonUpdate;

	/**
	 * This is the default constructor
	 */
	public GuiMesUpdate(JDialog owner) {
		super(owner);
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 405);
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
					.createTitledBorder("Modificar Variables Mensuales"));
			jContentPane.add(getJPanel(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	private JPanel getJPanel() {
		if (jPanel == null) {
			jPanel = new JPanel();
			TableLayout jPanelLayout = new TableLayout(new double[][] {
					{ 10.0, TableLayout.FILL, TableLayout.FILL, 10.0 },
					{ TableLayout.PREFERRED, TableLayout.PREFERRED,
							TableLayout.PREFERRED, TableLayout.FILL } });
			jPanelLayout.setHGap(5);
			jPanelLayout.setVGap(5);
			jPanel.setLayout(jPanelLayout);
			jPanel.add(getJPanelButton(), "1, 3, 2, 3");
			jPanel.add(getJLabelRespuesta(), "1, 2, 2, 2");
			jPanel.add(getJPanelContentLeft(), "1, 1");
			jPanel.add(getJPanelContentRight(), "2, 1");
			jPanel.add(getJPanelFecha(), "1, 0, 2, 0");
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
	
	private JPanel getJPanelContentLeft() {
		if (jPanelContentLeft == null) {
			jPanelContentLeft = new JPanel();
			TableLayout jPanelContentLeftLayout = new TableLayout(
				new double[][] {
						{ TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.PREFERRED } });
			jPanelContentLeftLayout.setHGap(5);
			jPanelContentLeftLayout.setVGap(5);
			jPanelContentLeft.setLayout(jPanelContentLeftLayout);
			jPanelContentLeft.add(getJPanelMensual(), "0, 0");
			jPanelContentLeft.add(getJPanelPrevision(), "0, 1");
			jPanelContentLeft.add(getJPanelMutual(), "0, 2");
		}
		return jPanelContentLeft;
	}
	
	private JPanel getJPanelContentRight() {
		if (jPanelContentRight == null) {
			jPanelContentRight = new JPanel();
			TableLayout jPanelContentRightLayout = new TableLayout(
				new double[][] {
						{ TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.PREFERRED } });
			jPanelContentRightLayout.setHGap(5);
			jPanelContentRightLayout.setVGap(5);
			jPanelContentRight.setLayout(jPanelContentRightLayout);
			jPanelContentRight.add(getJPanelSalud(), "0, 0");
			jPanelContentRight.add(getJPanelSeguroCesantia(), "0, 1");
			jPanelContentRight.add(getJPanelGratificacion(), "0, 2");
		}
		return jPanelContentRight;
	}
	
	private JPanel getJPanelMensual() {
		if (jPanelMensual == null) {
			jPanelMensual = new JPanel();
			CardLayout jPanelMensualLayout = new CardLayout();
			jPanelMensual.setBorder(BorderFactory.createTitledBorder("Mes"));
			jPanelMensual.setLayout(jPanelMensualLayout);
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
			jPanelMensual2.add(getJLabelSueldoMinimo(), "0,   0");
			jPanelMensual2.add(getJLabelUf(), "0,   1");
			jPanelMensual2.add(getJLabelUtm(), "0,   2");
			jPanelMensual2.add(getJTextFieldSueldoMinimo(), "1,   0");
			jPanelMensual2.add(getJTextFieldUf(), "1,   1");
			jPanelMensual2.add(getJTextFieldUtm(), "1,   2");
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
			jTextFieldSueldoMinimo.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldSueldoMinimoKeyTyped(evt);
				}
			});
		}
		return jTextFieldSueldoMinimo;
	}
	
	private JTextField getJTextFieldUf() {
		if (jTextFieldUf == null) {
			jTextFieldUf = new JTextField();
			jTextFieldUf.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldUfKeyTyped(evt);
				}
			});
		}
		return jTextFieldUf;
	}
	
	private JTextField getJTextFieldUtm() {
		if (jTextFieldUtm == null) {
			jTextFieldUtm = new JTextField();
			jTextFieldUtm.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldUtmKeyTyped(evt);
				}
			});
		}
		return jTextFieldUtm;
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
//			TableLayout jPanelPrevision2Layout = new TableLayout(
//				new double[][] { { TableLayout.PREFERRED, TableLayout.FILL },
//						{ TableLayout.FILL, TableLayout.FILL } });
			jPanelPrevision2Layout.setHGap(5);
			jPanelPrevision2Layout.setVGap(5);
			jPanelPrevision2.setLayout(jPanelPrevision2Layout);
			jPanelPrevision2.add(getJLabelAfpTope(), "0,   0");
			jPanelPrevision2.add(getJLabelApvTope(), "0,   1");
			jPanelPrevision2.add(getJLabelSeguroInvalidez(), "0,    2");
			jPanelPrevision2.add(getJTextFieldAfpTope(), "1,   0");
			jPanelPrevision2.add(getJTextFieldApvTope(), "1,   1");
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
			jLabelSeguroInvalidez.setText("Seg. Invalidez (%): ");
		}
		return jLabelSeguroInvalidez;
	}
	
	private JTextField getJTextFieldAfpTope() {
		if (jTextFieldAfpTope == null) {
			jTextFieldAfpTope = new JTextField();
			jTextFieldAfpTope.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldAfpTopeKeyTyped(evt);
				}
			});
		}
		return jTextFieldAfpTope;
	}
	
	private JTextField getJTextFieldApvTope() {
		if (jTextFieldApvTope == null) {
			jTextFieldApvTope = new JTextField();
			jTextFieldApvTope.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldApvTopeKeyTyped(evt);
				}
			});
		}
		return jTextFieldApvTope;
	}
	
	private JTextField getJTextFieldSeguroInvalidez() {
		if (jTextFieldSeguroInvalidez == null) {
			jTextFieldSeguroInvalidez = new JTextField();
			jTextFieldSeguroInvalidez.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldSeguroInvalidezKeyTyped(evt);
				}
			});
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
			jPanelMutual2.add(getJLabelMutualCotizacionBasica(), "0,   0");
			jPanelMutual2.add(getJTextFieldMutualCotizacionBasica(), "1,   0");
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
			jTextFieldMutualCotizacionBasica.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldMutualCotizacionBasicaKeyTyped(evt);
				}
			});
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
			jPanelSalud2.add(getJLabelSaludCotizacionBasica(), "0,   0");
			jPanelSalud2.add(getJLabelSaludTope(), "0,   1");
			jPanelSalud2.add(getJTextFieldSaludCotizacionBasica(), "1,   0");
			jPanelSalud2.add(getJTextFieldSaludTope(), "1,   1");
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
			jTextFieldSaludCotizacionBasica.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldSaludCotizacionBasicaKeyTyped(evt);
				}
			});
		}
		return jTextFieldSaludCotizacionBasica;
	}
	
	private JTextField getJTextFieldSaludTope() {
		if (jTextFieldSaludTope == null) {
			jTextFieldSaludTope = new JTextField();
			jTextFieldSaludTope.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldSaludTopeKeyTyped(evt);
				}
			});
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
			jPanelSeguroCesantia2.add(getJLabelSeguroCesantiaPorcentaje(), "0,   0");
			jPanelSeguroCesantia2.add(getJLabelSeguroCesantiaTope(), "0,   1");
			jPanelSeguroCesantia2.add(getJTextFieldSeguroCesantiaPorcentaje(), "1,   0");
			jPanelSeguroCesantia2.add(getJTextFieldSeguroCesantiaTope(), "1,   1");
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
			jTextFieldSeguroCesantiaPorcentaje.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldSeguroCesantiaPorcentajeKeyTyped(evt);
				}
			});
		}
		return jTextFieldSeguroCesantiaPorcentaje;
	}
	
	private JTextField getJTextFieldSeguroCesantiaTope() {
		if (jTextFieldSeguroCesantiaTope == null) {
			jTextFieldSeguroCesantiaTope = new JTextField();
			jTextFieldSeguroCesantiaTope.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldSeguroCesantiaTopeKeyTyped(evt);
				}
			});
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
			jPanelGratificacion2.add(getJLabelGratificacionPorcentaje(), "0,   0");
			jPanelGratificacion2.add(getJLabelGratificacionFactorAnual(), "0,   1");
			jPanelGratificacion2.add(getJTextFieldGratificacionPorcentaje(), "1,   0");
			jPanelGratificacion2.add(getJTextFieldGratificacionFactorAnual(), "1,   1");
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
			jTextFieldGratificacionPorcentaje.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldGratificacionPorcentajeKeyTyped(evt);
				}
			});
		}
		return jTextFieldGratificacionPorcentaje;
	}
	
	private JTextField getJTextFieldGratificacionFactorAnual() {
		if (jTextFieldGratificacionFactorAnual == null) {
			jTextFieldGratificacionFactorAnual = new JTextField();
			jTextFieldGratificacionFactorAnual.addKeyListener(new KeyAdapter() {
				public void keyTyped(KeyEvent evt) {
					jTextFieldGratificacionFactorAnualKeyTyped(evt);
				}
			});
		}
		return jTextFieldGratificacionFactorAnual;
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
	
	private JLabel getJLabelMes() {
		if (jLabelMes == null) {
			jLabelMes = new JLabel();
			jLabelMes.setText("   Mes : ");
		}
		return jLabelMes;
	}

	private JTextField getJTextFieldAnno() {
		if (jTextFieldAnno == null) {
			jTextFieldAnno = new JTextField();
			jTextFieldAnno.setPreferredSize(new java.awt.Dimension(54, 20));
			jTextFieldAnno.setEditable(false);
		}
		return jTextFieldAnno;
	}
	
	private JTextField getJTextFieldMes() {
		if (jTextFieldMes == null) {
			jTextFieldMes = new JTextField();
			jTextFieldMes.setPreferredSize(new java.awt.Dimension(105, 20));
			jTextFieldMes.setEditable(false);
		}
		return jTextFieldMes;
	}
	
	private void jTextFieldSueldoMinimoKeyTyped(KeyEvent evt) {
		Formato.formatLong(evt);
	}
	
	private void jTextFieldUfKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldUf.getText());
	}
	
	private void jTextFieldUtmKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldUtm.getText());
	}
	
	private void jTextFieldAfpTopeKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldAfpTope.getText());
	}
	
	private void jTextFieldApvTopeKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldApvTope.getText());
	}

	private void jTextFieldSeguroInvalidezKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldSeguroInvalidez.getText());
	}

	private void jTextFieldMutualCotizacionBasicaKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldMutualCotizacionBasica.getText());
	}
	
	private void jTextFieldSaludCotizacionBasicaKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldSaludCotizacionBasica.getText());
	}
	
	private void jTextFieldSaludTopeKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldSaludTope.getText());
	}
	
	private void jTextFieldSeguroCesantiaPorcentajeKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldSeguroCesantiaPorcentaje.getText());
	}
	
	private void jTextFieldSeguroCesantiaTopeKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldSeguroCesantiaTope.getText());
	}
	
	private void jTextFieldGratificacionPorcentajeKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldGratificacionPorcentaje.getText());
	}
	
	private void jTextFieldGratificacionFactorAnualKeyTyped(KeyEvent evt) {
		Formato.formatDouble(evt, this.jTextFieldGratificacionFactorAnual.getText());
	}

	private void jButtonUpdateActionPerformed(ActionEvent evt) {
		if (this.jTextFieldSueldoMinimo.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Sueldo Mínimo\".");
		} else if (this.jTextFieldUf.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"U.F.\".");			
		} else if (this.jTextFieldUtm.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"U.T.M.\".");			
		} else if (this.jTextFieldAfpTope.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Tope de Afp\".");			
		} else if (this.jTextFieldApvTope.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Tope de Apv\".");			
		} else if (this.jTextFieldSeguroInvalidez.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Seguro de Invalidez\".");			
		} else if (this.jTextFieldMutualCotizacionBasica.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Cotización Básica (Mutual)\".");			
		} else if (this.jTextFieldSaludCotizacionBasica.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Cotización Básica (Salud)\".");			
		} else if (this.jTextFieldSaludTope.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Tope (Salud)\".");			
		} else if (this.jTextFieldSeguroCesantiaPorcentaje.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Porcentaje (Seguro Cesantía)\".");			
		} else if (this.jTextFieldSeguroCesantiaTope.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Tope (Seguro Cesantía)\".");			
		} else if (this.jTextFieldGratificacionPorcentaje.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Porcentaje (Gratificación)\".");
		} else if (this.jTextFieldGratificacionFactorAnual.getText().trim().length() == 0) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "Debe rellenar el campo \"Factor Anual (Gratificación)\".");
		} 
		else {
			this.respuesta(control.updateMes(
					this.fecha, 
					new Double(this.jTextFieldSueldoMinimo.getText().trim()), 
					new Double(this.jTextFieldUf.getText().trim()), 
					new Double(this.jTextFieldUtm.getText().trim()), 
					new Double(this.jTextFieldAfpTope.getText().trim()), 
					new Double(this.jTextFieldApvTope.getText().trim()), 
					new Double(this.jTextFieldSeguroInvalidez.getText().trim()), 
					new Double(this.jTextFieldMutualCotizacionBasica.getText().trim()), 
					new Double(this.jTextFieldSaludCotizacionBasica.getText().trim()), 
					new Double(this.jTextFieldSaludTope.getText().trim()), 
					new Double(this.jTextFieldSeguroCesantiaPorcentaje.getText().trim()), 
					new Double(this.jTextFieldSeguroCesantiaTope.getText().trim()), 
					new Double(this.jTextFieldGratificacionPorcentaje.getText().trim()), 
					new Double(this.jTextFieldGratificacionFactorAnual.getText().trim())
					));
		}
	}

	private void respuesta(int respuesta) {
		if (respuesta == control.respExito) {
			Message.timerLabel(this.jLabelRespuesta, Color.green, "El registro se modifico exitosamente.");
		} else if (respuesta == control.respExiste) {
			Message.timerLabel(this.jLabelRespuesta, Color.red, "No existe el registro en el sistema.");
		}
	}
	
	public void actualizar(Date date) {
		this.fecha = date;
		this.jTextFieldAnno.setText(Fecha.getYear(fecha).toString());
		this.jTextFieldMes.setText(Fecha.getMonthString(fecha));
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
	}

}