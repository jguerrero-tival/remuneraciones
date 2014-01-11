package org.rem.gui;

import info.clearthought.layout.TableLayout;
import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.DefaultListModel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import org.rem.control.empresa.ControlListModelEmpresa;
import org.rem.control.empresa.ControlListModelTrabajador;
import org.rem.control.empresa.ControlTableModelCentroCosto;
import org.rem.control.empresa.ControlTableModelEmpresaCuenta;
import org.rem.control.empresa.ControlTableModelTrabajador;
import org.rem.gui.empresa.GuiCentroCostoAdd;
import org.rem.gui.empresa.GuiCentroCostoRemove;
import org.rem.gui.empresa.GuiCentroCostoUpdate;
import org.rem.gui.empresa.GuiEmpresa;
import org.rem.gui.empresa.GuiEmpresaAdd;
import org.rem.gui.empresa.GuiEmpresaCuenta;
import org.rem.gui.empresa.GuiEmpresaCuentaAdd;
import org.rem.gui.empresa.GuiEmpresaCuentaLock;
import org.rem.gui.empresa.GuiEmpresaCuentaRemove;
import org.rem.gui.empresa.GuiEmpresaCuentaUpdate;
import org.rem.gui.empresa.GuiEmpresaRemove;
import org.rem.gui.empresa.GuiEmpresaUpdate;
import org.rem.gui.empresa.GuiInforme;
import org.rem.gui.empresa.GuiListModel;
import org.rem.gui.empresa.GuiTrabajadorAdd;
import org.rem.gui.empresa.GuiTrabajadorCuenta;
import org.rem.gui.empresa.GuiTrabajadorCuentaAdd;
import org.rem.gui.empresa.GuiTrabajadorCuentaRemove;
import org.rem.gui.empresa.GuiTrabajadorCuentaUpdate;
import org.rem.gui.empresa.GuiTrabajadorCuentaWork;
import org.rem.gui.empresa.GuiTrabajadorRemove;
import org.rem.gui.empresa.GuiTrabajadorUpdate;
import org.rem.gui.empresa.ListModelEmpresa;
import org.rem.gui.empresa.ListModelTrabajador;
import org.rem.gui.empresa.TableModelCentroCosto;
import org.rem.gui.empresa.TableModelEmpresaCuenta;
import org.rem.gui.empresa.TableModelTrabajador;
import org.rem.gui.haberDescuento.GuiDescuento;
import org.rem.gui.haberDescuento.GuiImponible;
import org.rem.gui.haberDescuento.GuiNoImponible;
import org.rem.gui.institucion.GuiAfp;
import org.rem.gui.institucion.GuiCaja;
import org.rem.gui.institucion.GuiIsapre;
import org.rem.gui.institucion.GuiMutual;
import org.rem.gui.mes.GuiAsignacion;
import org.rem.gui.mes.GuiImpuesto;
import org.rem.gui.mes.GuiMes;
import org.rem.gui.otro.GuiMoneda;
import org.rem.model.Empresa;
import org.rem.model.EmpresaCuenta;
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
public class Gui extends JFrame {
	
	/* Gui's del panel principal de trabajo INFORMACION */
	private GuiEmpresa guiEmpresa; //TIENE CONSTRUCTOR
	private GuiEmpresaCuenta guiEmpresaCuenta; //TIENE CONSTRUCTOR
	private ControlTableModelEmpresaCuenta controlModelEmpresaCuenta = new ControlTableModelEmpresaCuenta();
	private ControlTableModelCentroCosto controlModelCentroCosto = new ControlTableModelCentroCosto();
	private GuiEmpresaCuentaAdd guiEmpresaCuentaAdd = new GuiEmpresaCuentaAdd(this);
	private GuiEmpresaCuentaUpdate guiEmpresaCuentaUpdate = new GuiEmpresaCuentaUpdate(this);
	private GuiEmpresaCuentaRemove guiEmpresaCuentaRemove = new GuiEmpresaCuentaRemove(this);
	private GuiEmpresaCuentaLock guiEmpresaCuentaLock = new GuiEmpresaCuentaLock(this);
	private GuiInforme guiInforme = new GuiInforme(this);
	private GuiCentroCostoAdd guiCentroCostoAdd = new GuiCentroCostoAdd(this);
	private GuiCentroCostoRemove guiCentroCostoRemove = new GuiCentroCostoRemove(this);
	private GuiCentroCostoUpdate guiCentroCostoUpdate = new GuiCentroCostoUpdate(this);
	
	private GuiTrabajadorCuenta guiTrabajadorCuenta;
	private ControlTableModelTrabajador controlTableModelTrabajador = new ControlTableModelTrabajador();
	private GuiTrabajadorCuentaAdd guiTrabajadorCuentaAdd = new GuiTrabajadorCuentaAdd(this);
	private GuiTrabajadorCuentaRemove guiTrabajadorCuentaRemove = new GuiTrabajadorCuentaRemove(this);
	private GuiTrabajadorCuentaUpdate guiTrabajadorCuentaUpdate = new GuiTrabajadorCuentaUpdate(this);
	private GuiTrabajadorCuentaWork guiTrabajadorCuentaWork = new GuiTrabajadorCuentaWork(this);
	
	
	/* Gui's del panel principal de trabajo MENU */
	private ControlListModelEmpresa controlModelEmpresa = new ControlListModelEmpresa();
	private ControlListModelTrabajador controlModelTrabajador = new ControlListModelTrabajador();
	private GuiListModel guiListModel; //TIENE CONSTRUCTOR
	private GuiEmpresaAdd guiEmpresaAdd = new GuiEmpresaAdd(this);
	private GuiEmpresaUpdate guiEmpresaUpdate = new GuiEmpresaUpdate(this);
	private JPanel jPanelInformacion;
	private GuiEmpresaRemove guiEmpresaRemove = new GuiEmpresaRemove(this);
	private GuiTrabajadorAdd guiTrabajadorAdd = new GuiTrabajadorAdd(this);
	private GuiTrabajadorRemove guiTrabajadorRemove = new GuiTrabajadorRemove(this);
	private GuiTrabajadorUpdate guiTrabajadorUpdate = new GuiTrabajadorUpdate(this);
	
	/* De otras Gui, llamadas desde el menuBar */
	private GuiMoneda guiMoneda = new GuiMoneda(this);
	private GuiDescuento guiDescuento = new GuiDescuento(this);
	private GuiImponible guiImponible = new GuiImponible(this);
	private GuiNoImponible guiNoImponible = new GuiNoImponible(this);
	private GuiCaja guiCaja = new GuiCaja(this);
	private GuiIsapre guiIsapre = new GuiIsapre(this);
	private GuiMutual guiMutual = new GuiMutual(this);
	private GuiAfp guiAfp = new GuiAfp(this);
	private GuiMes guiMes = new GuiMes(this);
	private GuiImpuesto guiImpuesto = new GuiImpuesto(this);
	private GuiAsignacion guiAsignacion = new GuiAsignacion(this);
	
	/* Propio del Gui */
	private static final long serialVersionUID = 1L;
	private JMenu jMenuVariable;
	private JMenu jMenuInstitucion;
	private JScrollPane jScrollPaneContent;
	private JMenuItem jMenuItemAfp;
	private JMenuItem jMenuItemMutual;
	private JMenuItem jMenuItemCerrar;
	private JSplitPane jSplitPane;
	private JMenuItem jMenuItemNoImponible;
	private JMenuItem jMenuItemImponible;
	private JMenuItem jMenuItemDescuento;
	private JMenu jMenuHaberDescuento;
	private JMenuItem jMenuItemMoneda;
	private JMenuItem jMenuItemIsapre;
	private JMenuItem jMenuItemCaja;
	private JMenuItem jMenuItemAsignacion;
	private JMenuItem jMenuItemImpuesto;
	private JMenuItem jMenuItemMes;
	private JMenu jMenuOtro;
	private JMenu jMenuMenu;
	private JMenuBar jMenuBar1;
	private JPanel jContentPane = null;

	/**
	 * This is the default constructor
	 */
	public Gui() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(500, 400);
		this.setContentPane(getJContentPane());
		this.setTitle("JFrame");
		this.setJMenuBar(getJMenuBar1());
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setExtendedState(JFrame.MAXIMIZED_BOTH);
		this.setLocation(Pantalla.centrar(this.getSize()));
		this.setTitle("Remuneraciones");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent evt) {
				rootWindowClosing(evt);
			}
		});
		this.actualizarListEmpresa();
		this.actualizarPanelEmpresa();
		this.actualizarPanelEmpresaCuenta();
		this.actualizarPanelTrabajadorCuenta();
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
			jContentPane.add(getJSplitPane(), "jSplitPane");
		}
		return jContentPane;
	}
	private JMenuBar getJMenuBar1() {
		if (jMenuBar1 == null) {
			jMenuBar1 = new JMenuBar();
			jMenuBar1.add(getJMenuMenu());
			jMenuBar1.add(getJMenuVariable());
			jMenuBar1.add(getJMenuInstitucion());
			jMenuBar1.add(getJMenuHaberDescuento());
			jMenuBar1.add(getJMenuOtro());
		}
		return jMenuBar1;
	}
	private JMenu getJMenuMenu() {
		if (jMenuMenu == null) {
			jMenuMenu = new JMenu();
			jMenuMenu.setText("Menu");
			jMenuMenu.add(getJMenuItemCerrar());
		}
		return jMenuMenu;
	}
	private JMenu getJMenuVariable() {
		if (jMenuVariable == null) {
			jMenuVariable = new JMenu();
			jMenuVariable.setText("Variables");
			jMenuVariable.add(getJMenuItemMes());
			jMenuVariable.add(getJMenuItemImpuesto());
			jMenuVariable.add(getJMenuItemAsignacion());
		}
		return jMenuVariable;
	}
	private JMenu getJMenuInstitucion() {
		if (jMenuInstitucion == null) {
			jMenuInstitucion = new JMenu();
			jMenuInstitucion.setText("Institución");
			jMenuInstitucion.add(getJMenuItemCaja());
			jMenuInstitucion.add(getJMenuItemIsapre());
			jMenuInstitucion.add(getJMenuItemMutual());
			jMenuInstitucion.add(getJMenuItemAfp());
		}
		return jMenuInstitucion;
	}
	private JMenu getJMenuOtro() {
		if (jMenuOtro == null) {
			jMenuOtro = new JMenu();
			jMenuOtro.setText("Otras Opciones");
			jMenuOtro.add(getJMenuItemMoneda());
		}
		return jMenuOtro;
	}
	private JMenuItem getJMenuItemCerrar() {
		if (jMenuItemCerrar == null) {
			jMenuItemCerrar = new JMenuItem();
			jMenuItemCerrar.setText("Cerrar");
			jMenuItemCerrar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemCerrarActionPerformed(evt);
				}
			});
		}
		return jMenuItemCerrar;
	}
	private JMenuItem getJMenuItemMes() {
		if (jMenuItemMes == null) {
			jMenuItemMes = new JMenuItem();
			jMenuItemMes.setText("Variables Mensuales");
			jMenuItemMes.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemMesActionPerformed(evt);
				}
			});
		}
		return jMenuItemMes;
	}
	private JMenuItem getJMenuItemImpuesto() {
		if (jMenuItemImpuesto == null) {
			jMenuItemImpuesto = new JMenuItem();
			jMenuItemImpuesto.setText("Impuesto Único");
			jMenuItemImpuesto.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemImpuestoActionPerformed(evt);
				}
			});
		}
		return jMenuItemImpuesto;
	}
	private JMenuItem getJMenuItemAsignacion() {
		if (jMenuItemAsignacion == null) {
			jMenuItemAsignacion = new JMenuItem();
			jMenuItemAsignacion.setText("AsignacionFamiliar");
			jMenuItemAsignacion.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemAsignacionActionPerformed(evt);
				}
			});
		}
		return jMenuItemAsignacion;
	}
	private JMenuItem getJMenuItemCaja() {
		if (jMenuItemCaja == null) {
			jMenuItemCaja = new JMenuItem();
			jMenuItemCaja.setText("Caja de Compensación");
			jMenuItemCaja.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemCajaActionPerformed(evt);
				}
			});
		}
		return jMenuItemCaja;
	}
	private JMenuItem getJMenuItemIsapre() {
		if (jMenuItemIsapre == null) {
			jMenuItemIsapre = new JMenuItem();
			jMenuItemIsapre.setText("Isapre");
			jMenuItemIsapre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemIsapreActionPerformed(evt);
				}
			});
		}
		return jMenuItemIsapre;
	}
	private JMenuItem getJMenuItemMutual() {
		if (jMenuItemMutual == null) {
			jMenuItemMutual = new JMenuItem();
			jMenuItemMutual.setText("Mutual de Seguridad");
			jMenuItemMutual.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemMutualActionPerformed(evt);
				}
			});
		}
		return jMenuItemMutual;
	}
	private JMenuItem getJMenuItemAfp() {
		if (jMenuItemAfp == null) {
			jMenuItemAfp = new JMenuItem();
			jMenuItemAfp.setText("Afp");
			jMenuItemAfp.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemAfpActionPerformed(evt);
				}
			});
		}
		return jMenuItemAfp;
	}
	private JMenu getJMenuHaberDescuento() {
		if (jMenuHaberDescuento == null) {
			jMenuHaberDescuento = new JMenu();
			jMenuHaberDescuento.setText("Haberes y Descuentos");
			jMenuHaberDescuento.add(getJMenuItemDescuento());
			jMenuHaberDescuento.add(getJMenuItemImponible());
			jMenuHaberDescuento.add(getJMenuItemNoImponible());
		}
		return jMenuHaberDescuento;
	}
	private JMenuItem getJMenuItemDescuento() {
		if (jMenuItemDescuento == null) {
			jMenuItemDescuento = new JMenuItem();
			jMenuItemDescuento.setText("Descuentos");
			jMenuItemDescuento.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemDescuentoActionPerformed(evt);
				}
			});
		}
		return jMenuItemDescuento;
	}
	private JMenuItem getJMenuItemImponible() {
		if (jMenuItemImponible == null) {
			jMenuItemImponible = new JMenuItem();
			jMenuItemImponible.setText("Haberes Imponibles");
			jMenuItemImponible.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemImponibleActionPerformed(evt);
				}
			});
		}
		return jMenuItemImponible;
	}
	private JMenuItem getJMenuItemNoImponible() {
		if (jMenuItemNoImponible == null) {
			jMenuItemNoImponible = new JMenuItem();
			jMenuItemNoImponible.setText("Haberes No Imponibles");
			jMenuItemNoImponible.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemNoImponibleActionPerformed(evt);
				}
			});
		}
		return jMenuItemNoImponible;
	}
	private JMenuItem getJMenuItemMoneda() {
		if (jMenuItemMoneda == null) {
			jMenuItemMoneda = new JMenuItem();
			jMenuItemMoneda.setText("Detalle de Efectivo");
			jMenuItemMoneda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent evt) {
					jMenuItemMonedaActionPerformed(evt);
				}
			});
		}
		return jMenuItemMoneda;
	}

	private void jMenuItemMonedaActionPerformed(ActionEvent evt) {
		this.guiMoneda.setVisible(true);
	}
	private void jMenuItemDescuentoActionPerformed(ActionEvent evt) {
		this.guiDescuento.setVisible(true);
	}
	private void jMenuItemImponibleActionPerformed(ActionEvent evt) {
		this.guiImponible.setVisible(true);
	}
	private void jMenuItemNoImponibleActionPerformed(ActionEvent evt) {
		this.guiNoImponible.setVisible(true);
	}
	private void jMenuItemCajaActionPerformed(ActionEvent evt) {
		this.guiCaja.setVisible(true);
	}
	private void jMenuItemIsapreActionPerformed(ActionEvent evt) {
		this.guiIsapre.setVisible(true);
	}
	private void jMenuItemMutualActionPerformed(ActionEvent evt) {
		this.guiMutual.setVisible(true);
	}
	private void jMenuItemAfpActionPerformed(ActionEvent evt) {
		this.guiAfp.actualizar();
		this.guiAfp.setVisible(true);
	}
	private void jMenuItemMesActionPerformed(ActionEvent evt) {
		this.guiMes.setVisible(true);
	}
	private void jMenuItemImpuestoActionPerformed(ActionEvent evt) {
		this.guiImpuesto.actualizar();
		this.guiImpuesto.setVisible(true);
	}
	private void jMenuItemAsignacionActionPerformed(ActionEvent evt) {
		this.guiAsignacion.actualizar();
		this.guiAsignacion.setVisible(true);
	}
	private JSplitPane getJSplitPane() {
		if (jSplitPane == null) {
			jSplitPane = new JSplitPane();
			jSplitPane.add(getGuiListModel(), JSplitPane.LEFT);
			jSplitPane.add(getJScrollPaneContent(), JSplitPane.RIGHT);
		}
		return jSplitPane;
	}
	private JScrollPane getJScrollPaneContent() {
		if (jScrollPaneContent == null) {
			jScrollPaneContent = new JScrollPane();
			jScrollPaneContent.setViewportView(getJPanelInformacion());
		}
		return jScrollPaneContent;
	}
	private JPanel getJPanelInformacion() {
		if (jPanelInformacion == null) {
			jPanelInformacion = new JPanel();
			TableLayout jPanelInformacionLayout = new TableLayout(
				new double[][] {
						{ TableLayout.FILL },
						{ TableLayout.PREFERRED, TableLayout.PREFERRED,
								TableLayout.FILL, TableLayout.FILL,
								TableLayout.FILL } });
			jPanelInformacionLayout.setHGap(5);
			jPanelInformacionLayout.setVGap(5);
			jPanelInformacion.setLayout(jPanelInformacionLayout);
			jPanelInformacion.add(this.getGuiEmpresa(), "0, 0");
			jPanelInformacion.add(this.getGuiEmpresaCuenta(), "0, 1");
			jPanelInformacion.add(this.getGuiTrabajadorCuenta(), "0, 2");
		}
		return jPanelInformacion;
	}
	
	// PANEL LIST //
	private GuiListModel getGuiListModel() {
		if (this.guiListModel == null) {
			this.guiListModel = new GuiListModel();
			this.guiListModel.setPreferredSize(new Dimension(120, 600));
			this.guiListModel.setMinimumSize(new Dimension(120, 600));
			this.guiListModel.jButtonEmpresaAdd.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaAddActionPerformed(evt);}});
			this.guiListModel.jButtonEmpresaRemove.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaRemoveActionPerformed(evt);}});
			this.guiListModel.jButtonEmpresaUpdate.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaUpdateActionPerformed(evt);}});
			this.guiListModel.jButtonTrabajadorAdd.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonTrabajadorAddActionPerformed(evt);}});
			this.guiListModel.jButtonTrabajadorRemove.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonTrabajadorRemoveActionPerformed(evt);}});
			this.guiListModel.jButtonTrabajadorUpdate.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonTrabajadorUpdateActionPerformed(evt);}});
			this.guiListModel.jListEmpresa.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jListEmpresaValueChanged(evt);}});
			this.guiListModel.jListTrabajador.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jListTrabajadorValueChanged(evt);}});
		}
		return this.guiListModel;
	}
	private void actualizarListEmpresa() {
		this.guiListModel.jListEmpresa.setModel(controlModelEmpresa.getListModelEmpresa());
		this.actualizarListEmpresaBotones();
		this.actualizarListTrabajador();
	}
	private void actualizarListEmpresaBotones() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			this.guiListModel.jButtonTrabajadorAdd.setEnabled(true);
			this.guiListModel.jButtonEmpresaUpdate.setEnabled(true);
			this.guiListModel.jButtonEmpresaRemove.setEnabled(true);
		} else {
			this.guiListModel.jButtonTrabajadorAdd.setEnabled(false);			
			this.guiListModel.jButtonEmpresaUpdate.setEnabled(false);
			this.guiListModel.jButtonEmpresaRemove.setEnabled(false);
		}
		this.actualizarListTrabajador();
	}
	private void actualizarListTrabajador() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			int index = this.guiListModel.jListEmpresa.getSelectedIndex();
			this.guiListModel.jListTrabajador.setModel(
					controlModelTrabajador.getListModelTrabajador(
							((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(index)));
		} else {
			this.guiListModel.jListTrabajador.setModel(new DefaultListModel());
		}
		this.actualizarListTrabajadorBotones();
	}
	private void actualizarListTrabajadorBotones() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			this.guiListModel.jButtonTrabajadorAdd.setEnabled(true);
			if (!this.guiListModel.jListTrabajador.isSelectionEmpty()) {
				this.guiListModel.jButtonTrabajadorRemove.setEnabled(true);
				this.guiListModel.jButtonTrabajadorUpdate.setEnabled(true);
			} else {
				this.guiListModel.jButtonTrabajadorRemove.setEnabled(false);
				this.guiListModel.jButtonTrabajadorUpdate.setEnabled(false);
			}
		} else {
			this.guiListModel.jButtonTrabajadorAdd.setEnabled(false);
			this.guiListModel.jButtonTrabajadorRemove.setEnabled(false);
			this.guiListModel.jButtonTrabajadorUpdate.setEnabled(false);
		}
	}
	private void jListEmpresaValueChanged(ListSelectionEvent evt) {
		this.actualizarListEmpresaBotones();
		this.actualizarPanelEmpresa();
		this.actualizarPanelEmpresaCuenta();
	}
	private void jListTrabajadorValueChanged(ListSelectionEvent evt) {
		this.actualizarListTrabajadorBotones();
	}
	private void jButtonEmpresaAddActionPerformed(ActionEvent evt) {
		this.guiEmpresaAdd.actualizar();
		this.guiEmpresaAdd.setVisible(true);
		this.actualizarListEmpresa();
	}
	private void jButtonEmpresaRemoveActionPerformed(ActionEvent evt) {
		int index = this.guiListModel.jListEmpresa.getSelectedIndex();
		this.guiEmpresaRemove.actualizar(((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(index));
		this.guiEmpresaRemove.setVisible(true);
		this.actualizarListEmpresa();
	}
	private void jButtonEmpresaUpdateActionPerformed(ActionEvent evt) {
		int index = this.guiListModel.jListEmpresa.getSelectedIndex();
		this.guiEmpresaUpdate.actualizar(((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(index));
		this.guiEmpresaUpdate.setVisible(true);
		this.actualizarListEmpresa();
		this.actualizarPanelTrabajadorCuenta();
	}
	private void jButtonTrabajadorAddActionPerformed(ActionEvent evt) {
		int index = this.guiListModel.jListEmpresa.getSelectedIndex();
		if (index!=-1) {
			this.guiTrabajadorAdd.actualizar(((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(index));
			this.guiTrabajadorAdd.setVisible(true);
			this.actualizarListTrabajador();
		}
	}
	private void jButtonTrabajadorRemoveActionPerformed(ActionEvent evt) {
		int indexEmpresa = this.guiListModel.jListEmpresa.getSelectedIndex();
		int indexTrabajador = this.guiListModel.jListTrabajador.getSelectedIndex();
		if (indexEmpresa!=-1 && indexTrabajador!=-1) {
			this.guiTrabajadorRemove.actualizar(
					((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(indexEmpresa),
					((ListModelTrabajador)this.guiListModel.jListTrabajador.getModel()).getTrabajadorAt(indexTrabajador));
			this.guiTrabajadorRemove.setVisible(true);
			this.actualizarListTrabajador();
		}
	}
	private void jButtonTrabajadorUpdateActionPerformed(ActionEvent evt) {
		int indexEmpresa = this.guiListModel.jListEmpresa.getSelectedIndex();
		int indexTrabajador = this.guiListModel.jListTrabajador.getSelectedIndex();
		if (indexEmpresa!=-1 && indexTrabajador!=-1) {
			this.guiTrabajadorUpdate.actualizar(
					((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(indexEmpresa),
					((ListModelTrabajador)this.guiListModel.jListTrabajador.getModel()).getTrabajadorAt(indexTrabajador));
			this.guiTrabajadorUpdate.setVisible(true);
			this.actualizarListTrabajador();
		}
	}
	
	// PANEL EMPRESA //
	private GuiEmpresa getGuiEmpresa() {
		if (this.guiEmpresa == null) {
			this.guiEmpresa = new GuiEmpresa();
		}
		return this.guiEmpresa;
	}
	private void actualizarPanelEmpresa() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			// si hay una empresa seleccionada
			int index = this.guiListModel.jListEmpresa.getSelectedIndex();
			Empresa empresa = ((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(index);
			this.guiEmpresa.jFormattedTextFieldRutEmpresa.setText(empresa.getRutEmpresa());
			this.guiEmpresa.jTextFieldRazonSocial.setText(empresa.getRazonSocial());
			this.guiEmpresa.jTextFieldColegio.setText(Palabra.getBooleanString(empresa.isColegio()));
			this.guiEmpresa.jTextFieldActividadEconomica.setText(empresa.getActividad());
			this.guiEmpresa.jTextFieldFono.setText(empresa.getFono());
			this.guiEmpresa.jTextFieldMail.setText(empresa.getEmail());
		} else {
			// si no hay una empresa seleccionada
			this.guiEmpresa.jFormattedTextFieldRutEmpresa.setText("");
			this.guiEmpresa.jTextFieldRazonSocial.setText("");
			this.guiEmpresa.jTextFieldColegio.setText("");
			this.guiEmpresa.jTextFieldActividadEconomica.setText("");
			this.guiEmpresa.jTextFieldFono.setText("");
			this.guiEmpresa.jTextFieldMail.setText("");	
		}
	}
	
	// PANEL EMPRESA CUENTA //
	private GuiEmpresaCuenta getGuiEmpresaCuenta() {
		if (this.guiEmpresaCuenta == null) {
			this.guiEmpresaCuenta = new GuiEmpresaCuenta();
			this.guiEmpresaCuenta.jButtonAdd.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaCuentaAddActionPerformed(evt);}});
			this.guiEmpresaCuenta.jButtonRemove.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaCuentaRemoveActionPerformed(evt);}});
			this.guiEmpresaCuenta.jButtonUpdate.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaCuentaUpdateActionPerformed(evt);}});
			this.guiEmpresaCuenta.jButtonLock.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaCuentaLockActionPerformed(evt);}});
			this.guiEmpresaCuenta.jButtonInformes.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaCuentaInformesActionPerformed(evt);}});
			this.guiEmpresaCuenta.jButtonAddCentroCosto.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaCuentaAddCentroCostoActionPerformed(evt);}});
			this.guiEmpresaCuenta.jButtonRemoveCentroCosto.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaCuentaRemoveCentroCostoActionPerformed(evt);}});
			this.guiEmpresaCuenta.jButtonUpdateCentroCosto.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonEmpresaCuentaUpdateCentroCostoActionPerformed(evt);}});
			ListSelectionModel rowSM = this.guiEmpresaCuenta.jTable.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jTableEmpresaCuentaValueChanged(evt);}});	
			ListSelectionModel rowSMCC = this.guiEmpresaCuenta.jTableCentroCosto.getSelectionModel();
			rowSMCC.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jTableCentroCostoValueChanged(evt);}});	
		}
		return this.guiEmpresaCuenta;
	}
	private void actualizarPanelEmpresaCuenta() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			// si hay una empresa seleccionada
			int index = this.guiListModel.jListEmpresa.getSelectedIndex();
			this.guiEmpresaCuenta.jTable.setModel(
					this.controlModelEmpresaCuenta.getTableModelEmpresaCuenta(
							((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(index)));
		} else {
			// si no hay una empresa seleccionada
			this.guiEmpresaCuenta.jTable.setModel(new TableModelEmpresaCuenta());
		}
		this.actualizarPanelEmpresaCuentaBotones();
		this.actualizarPanelEmpresaCuentaVariable();
	}
	private void actualizarPanelEmpresaCuentaBotones() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()==-1) {
				// si no hay una cuenta de empresa seleccionada
				this.guiEmpresaCuenta.jButtonAdd.setEnabled(true);
				this.guiEmpresaCuenta.jButtonRemove.setEnabled(false);
				this.guiEmpresaCuenta.jButtonUpdate.setEnabled(false);
				this.guiEmpresaCuenta.jButtonLock.setEnabled(false);
				this.guiEmpresaCuenta.jButtonInformes.setEnabled(false);
			} else {
				// si hay una cuenta de empresa seleccionada
				int rowIndex =  this.guiEmpresaCuenta.jTable.getSelectedRow();
				if ( ((TableModelEmpresaCuenta) this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex).isCerrada() ) {
					// si la cuenta de empresa seleccionada está cerrada
					this.guiEmpresaCuenta.jButtonRemove.setEnabled(false);
					this.guiEmpresaCuenta.jButtonUpdate.setEnabled(false);
					this.guiEmpresaCuenta.jButtonLock.setEnabled(false);
				} else {
					// si la cuenta de empresa seleccionada no está cerrada
					this.guiEmpresaCuenta.jButtonRemove.setEnabled(true);
					this.guiEmpresaCuenta.jButtonUpdate.setEnabled(true);
					this.guiEmpresaCuenta.jButtonLock.setEnabled(true);
				}
				this.guiEmpresaCuenta.jButtonInformes.setEnabled(true);
			}
		} else {
			this.guiEmpresaCuenta.jButtonInformes.setEnabled(false);
			this.guiEmpresaCuenta.jButtonAdd.setEnabled(false);
			this.guiEmpresaCuenta.jButtonRemove.setEnabled(false);
			this.guiEmpresaCuenta.jButtonUpdate.setEnabled(false);
			this.guiEmpresaCuenta.jButtonLock.setEnabled(false);
		}
	}
	private void actualizarPanelEmpresaCuentaVariable() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()==-1) {
				// si no hay una cuenta de empresa seleccionada
				this.guiEmpresaCuenta.jTextFieldGratificacion.setText("");
				this.guiEmpresaCuenta.jTextFieldCaja.setText("");
				this.guiEmpresaCuenta.jTextFieldMutual.setText("");
				this.guiEmpresaCuenta.jTextFieldMutualCotizacionAdicional.setText("");
				this.guiEmpresaCuenta.jTableCentroCosto.setModel(new TableModelCentroCosto());
			} else {
				// si hay una cuenta de empresa seleccionada
				int rowIndex =  this.guiEmpresaCuenta.jTable.getSelectedRow();
				EmpresaCuenta cuenta = ((TableModelEmpresaCuenta) this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex);
				this.guiEmpresaCuenta.jTextFieldGratificacion.setText(cuenta.getGratificacion());
				if (cuenta.getCaja()!=null) {
					this.guiEmpresaCuenta.jTextFieldCaja.setText(cuenta.getCaja().getNombre());					
				} else {
					this.guiEmpresaCuenta.jTextFieldCaja.setText(Palabra.institucionSin);
				}
				if (cuenta.getMutual()!=null) {
					this.guiEmpresaCuenta.jTextFieldMutual.setText(cuenta.getMutual().getNombre());
					//this.guiEmpresaCuenta.jTextFieldMutualCotizacionAdicional.setText(cuenta.getMutualCotizacionAdicional().toString());
				} else {
					this.guiEmpresaCuenta.jTextFieldMutual.setText(Palabra.institucionSin);
					//this.guiEmpresaCuenta.jTextFieldMutualCotizacionAdicional.setText("");					
				}
				this.guiEmpresaCuenta.jTextFieldMutualCotizacionAdicional.setText(cuenta.getMutualCotizacionAdicional().toString());
				this.guiEmpresaCuenta.jTableCentroCosto.setModel(controlModelCentroCosto.getTableModelCentroCosto(cuenta));
			}
		} else {
			this.guiEmpresaCuenta.jTextFieldGratificacion.setText("");
			this.guiEmpresaCuenta.jTextFieldCaja.setText("");
			this.guiEmpresaCuenta.jTextFieldMutual.setText("");
			this.guiEmpresaCuenta.jTextFieldMutualCotizacionAdicional.setText("");
			this.guiEmpresaCuenta.jTableCentroCosto.setModel(new TableModelCentroCosto());
		}
		this.actualizarPanelEmpresaCuentaVariableBotones();
	}
	private void actualizarPanelEmpresaCuentaVariableBotones() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()==-1) {
				// si no hay una cuenta de empresa seleccionada
				this.guiEmpresaCuenta.jButtonAddCentroCosto.setEnabled(false);
				this.guiEmpresaCuenta.jButtonRemoveCentroCosto.setEnabled(false);
				this.guiEmpresaCuenta.jButtonUpdateCentroCosto.setEnabled(false);
			} else {
				// si hay una cuenta de empresa seleccionada
				int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
				EmpresaCuenta cuenta = ((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex);
				if (!cuenta.isCerrada()) {
					// si la cuenta no esta cerrada
					this.guiEmpresaCuenta.jButtonAddCentroCosto.setEnabled(true);
					if (this.guiEmpresaCuenta.jTableCentroCosto.getSelectedRow()==-1) {
						// si la cuenta de empresa seleccionada está cerrada
						this.guiEmpresaCuenta.jButtonRemoveCentroCosto.setEnabled(false);
						this.guiEmpresaCuenta.jButtonUpdateCentroCosto.setEnabled(false);
					} else {
						// si la cuenta de empresa seleccionada no está cerrada
						this.guiEmpresaCuenta.jButtonRemoveCentroCosto.setEnabled(true);
						this.guiEmpresaCuenta.jButtonUpdateCentroCosto.setEnabled(true);
					}
				} else {
					// si la cuenta esta cerrada
					this.guiEmpresaCuenta.jButtonAddCentroCosto.setEnabled(false);
					this.guiEmpresaCuenta.jButtonRemoveCentroCosto.setEnabled(false);
					this.guiEmpresaCuenta.jButtonUpdateCentroCosto.setEnabled(false);
				}
			}
		} else {
			this.guiEmpresaCuenta.jButtonAddCentroCosto.setEnabled(false);
			this.guiEmpresaCuenta.jButtonRemoveCentroCosto.setEnabled(false);
			this.guiEmpresaCuenta.jButtonUpdateCentroCosto.setEnabled(false);
		}
	}
	private void jTableEmpresaCuentaValueChanged(ListSelectionEvent evt) {
		System.out.println("DETECTA CAMBIOS EN LA TABLA DE EMPRESA CUENTA");
		this.actualizarPanelEmpresaCuentaBotones();
		this.actualizarPanelEmpresaCuentaVariable();
		this.actualizarPanelTrabajadorCuenta();
	}
	private void jTableCentroCostoValueChanged(ListSelectionEvent evt) {
		System.out.println("DETECTA CAMBIOS EN LA TABLA DE CENTRO COSTO");
		this.actualizarPanelEmpresaCuentaVariableBotones();
	}
	private void jButtonEmpresaCuentaAddActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			// si hay una empresa seleccionada
			int index = this.guiListModel.jListEmpresa.getSelectedIndex();
			this.guiEmpresaCuentaAdd.actualizar(
					((ListModelEmpresa)this.guiListModel.jListEmpresa.getModel()).getEmpresaAt(index));
			this.guiEmpresaCuentaAdd.setVisible(true);
			this.actualizarPanelEmpresaCuenta();
		}
	}
	private void jButtonEmpresaCuentaRemoveActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			// si hay una empresa seleccionada
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				// si hay una cuenta de empresa seleccionada
				int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
				this.guiEmpresaCuentaRemove.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex));
				this.guiEmpresaCuentaRemove.setVisible(true);
				this.actualizarPanelEmpresaCuenta();
			}
		}
	}
	private void jButtonEmpresaCuentaUpdateActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			// si hay una empresa seleccionada
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				// si hay una cuenta de empresa seleccionada
				int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
				this.guiEmpresaCuentaUpdate.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex));
				this.guiEmpresaCuentaUpdate.setVisible(true);
				this.actualizarPanelEmpresaCuenta();
			}
		}
	}
	private void jButtonEmpresaCuentaLockActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			// si hay una empresa seleccionada
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				// si hay una cuenta de empresa seleccionada
				int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
				this.guiEmpresaCuentaLock.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex));
				this.guiEmpresaCuentaLock.setVisible(true);
				this.actualizarPanelEmpresaCuenta();
			}
		}
	}
	private void jButtonEmpresaCuentaInformesActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			// si hay una empresa seleccionada
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				// si hay una cuenta de empresa seleccionada
				int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
				this.guiInforme.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex));
				this.guiInforme.setVisible(true);
				this.actualizarPanelEmpresaCuenta();
			}
		}
	}
	private void jButtonEmpresaCuentaAddCentroCostoActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				// si hay una empresa seleccionada
				int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
				this.guiCentroCostoAdd.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex));
				this.guiCentroCostoAdd.setVisible(true);
				this.actualizarPanelEmpresaCuentaVariable();
			}
		}
		this.actualizarPanelEmpresaCuentaVariableBotones();
	}
	private void jButtonEmpresaCuentaRemoveCentroCostoActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				if (this.guiEmpresaCuenta.jTableCentroCosto.getSelectedRow()!=-1) {
					int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
					int rowIndexCentroCosto = this.guiEmpresaCuenta.jTableCentroCosto.getSelectedRow();
					this.guiCentroCostoRemove.actualizar(
							((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex),
							((TableModelCentroCosto)this.guiEmpresaCuenta.jTableCentroCosto.getModel()).getObject(rowIndexCentroCosto));
					this.guiCentroCostoRemove.setVisible(true);
					this.actualizarPanelEmpresaCuentaVariable();
				}
			}
		}
		this.actualizarPanelEmpresaCuentaVariableBotones();
	}
	private void jButtonEmpresaCuentaUpdateCentroCostoActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				if (this.guiEmpresaCuenta.jTableCentroCosto.getSelectedRow()!=-1) {
					int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
					int rowIndexCentroCosto = this.guiEmpresaCuenta.jTableCentroCosto.getSelectedRow();
					this.guiCentroCostoUpdate.actualizar(
							((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex),
							((TableModelCentroCosto)this.guiEmpresaCuenta.jTableCentroCosto.getModel()).getObject(rowIndexCentroCosto));
					this.guiCentroCostoUpdate.setVisible(true);
					this.actualizarPanelEmpresaCuentaVariable();
				}
			}
		}
		this.actualizarPanelEmpresaCuentaVariableBotones();
	}

	// PANEL TRABAJADOR CUENTA //
	private GuiTrabajadorCuenta getGuiTrabajadorCuenta() {
		if (this.guiTrabajadorCuenta == null) {
			this.guiTrabajadorCuenta = new GuiTrabajadorCuenta();
			this.guiTrabajadorCuenta.jButtonAdd.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonTrabajadorCuentaAddActionPerformed(evt);}});
			this.guiTrabajadorCuenta.jButtonRemove.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonTrabajadorCuentaRemoveActionPerformed(evt);}});
			this.guiTrabajadorCuenta.jButtonUpdate.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonTrabajadorCuentaUpdateActionPerformed(evt);}});
			this.guiTrabajadorCuenta.jButtonWork.addActionListener(new ActionListener() {public void actionPerformed(ActionEvent evt) {jButtonTrabajadorCuentaWorkActionPerformed(evt);}});
			ListSelectionModel rowSM = this.guiTrabajadorCuenta.jTable.getSelectionModel();
			rowSM.addListSelectionListener(new ListSelectionListener() {public void valueChanged(ListSelectionEvent evt) {jTableTrabajadorCuentaValueChanged(evt);}});	
		}
		return this.guiTrabajadorCuenta;
	}
	private void actualizarPanelTrabajadorCuenta() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			// si hay una empresa seleccionada
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				// si hay una empresa cuenta seleccionada
				int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
				this.guiTrabajadorCuenta.jTable.setModel(
						this.controlTableModelTrabajador.getTableModelTrabajador(
								((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex)));
			} else {
				// si no hay una empresa cuenta seleccionada
				this.guiTrabajadorCuenta.jTable.setModel(new TableModelTrabajador());
			}
		} else {
			// si no hay una empresa seleccionada
			this.guiTrabajadorCuenta.jTable.setModel(new TableModelTrabajador());
		}
		this.actualizarPanelTrabajadorCuentaBotones();
	}
	private void actualizarPanelTrabajadorCuentaBotones() {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()==-1) {
				// si no hay una cuenta de empresa seleccionada
				this.guiTrabajadorCuenta.jButtonAdd.setEnabled(false);
				this.guiTrabajadorCuenta.jButtonRemove.setEnabled(false);
				this.guiTrabajadorCuenta.jButtonUpdate.setEnabled(false);
				this.guiTrabajadorCuenta.jButtonWork.setEnabled(false);
			} else {
				// si hay una cuenta de empresa seleccionada
				int rowIndex =  this.guiEmpresaCuenta.jTable.getSelectedRow();
				if ( ((TableModelEmpresaCuenta) this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex).isCerrada() ) {
					// si la cuenta de empresa seleccionada está cerrada
					this.guiTrabajadorCuenta.jButtonAdd.setEnabled(false);
					this.guiTrabajadorCuenta.jButtonRemove.setEnabled(false);
					this.guiTrabajadorCuenta.jButtonUpdate.setEnabled(false);
					this.guiTrabajadorCuenta.jButtonWork.setEnabled(false);
				} else {
					// si la cuenta de empresa seleccionada no está cerrada
					this.guiTrabajadorCuenta.jButtonAdd.setEnabled(true);
					if (this.guiTrabajadorCuenta.jTable.getSelectedRow()==-1) {
						// si no hay una cuenta de trabajador seleccionada
						this.guiTrabajadorCuenta.jButtonRemove.setEnabled(false);
						this.guiTrabajadorCuenta.jButtonUpdate.setEnabled(false);
						this.guiTrabajadorCuenta.jButtonWork.setEnabled(false);
					} else {
						// si hay una cuenta de trabajador seleccionada
						this.guiTrabajadorCuenta.jButtonRemove.setEnabled(true);
						this.guiTrabajadorCuenta.jButtonUpdate.setEnabled(true);
						this.guiTrabajadorCuenta.jButtonWork.setEnabled(true);
					}
				}
			}
		} else {
			this.guiTrabajadorCuenta.jButtonAdd.setEnabled(false);
			this.guiTrabajadorCuenta.jButtonRemove.setEnabled(false);
			this.guiTrabajadorCuenta.jButtonUpdate.setEnabled(false);
			this.guiTrabajadorCuenta.jButtonWork.setEnabled(false);
		}
	}
	private void jButtonTrabajadorCuentaAddActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				// si hay una empresa seleccionada
				int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
				this.guiTrabajadorCuentaAdd.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex));
				this.guiTrabajadorCuentaAdd.setVisible(true);
				this.actualizarPanelTrabajadorCuenta();
			}
		}
		this.actualizarPanelEmpresaCuentaVariableBotones();
	}
	private void jButtonTrabajadorCuentaRemoveActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				if (this.guiTrabajadorCuenta.jTable.getSelectedRow()!=-1) {
					int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
					int rowIndexTrabajador = this.guiTrabajadorCuenta.jTable.getSelectedRow();
					this.guiTrabajadorCuentaRemove.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex),
						((TableModelTrabajador)this.guiTrabajadorCuenta.jTable.getModel()).getObject(rowIndexTrabajador));
					this.guiTrabajadorCuentaRemove.setVisible(true);
					this.actualizarPanelTrabajadorCuenta();
				}
			}
		}
		this.actualizarPanelTrabajadorCuenta();
	}
	private void jButtonTrabajadorCuentaUpdateActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				if (this.guiTrabajadorCuenta.jTable.getSelectedRow()!=-1) {
					int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
					int rowIndexTrabajador = this.guiTrabajadorCuenta.jTable.getSelectedRow();
					this.guiTrabajadorCuentaUpdate.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex),
						((TableModelTrabajador)this.guiTrabajadorCuenta.jTable.getModel()).getObject(rowIndexTrabajador));
					this.guiTrabajadorCuentaUpdate.setVisible(true);
					this.actualizarPanelTrabajadorCuenta();
				}
			}
		}
	}
	private void jButtonTrabajadorCuentaWorkActionPerformed(ActionEvent evt) {
		if (!this.guiListModel.jListEmpresa.isSelectionEmpty()) {
			if (this.guiEmpresaCuenta.jTable.getSelectedRow()!=-1) {
				if (this.guiTrabajadorCuenta.jTable.getSelectedRow()!=-1) {
					int rowIndex = this.guiEmpresaCuenta.jTable.getSelectedRow();
					int rowIndexTrabajador = this.guiTrabajadorCuenta.jTable.getSelectedRow();
					this.guiTrabajadorCuentaWork.actualizar(
						((TableModelEmpresaCuenta)this.guiEmpresaCuenta.jTable.getModel()).getObject(rowIndex),
						((TableModelTrabajador)this.guiTrabajadorCuenta.jTable.getModel()).getObject(rowIndexTrabajador));
					this.guiTrabajadorCuentaWork.setVisible(true);
					this.actualizarPanelTrabajadorCuenta();
				}
			}
		}
	}
	private void jTableTrabajadorCuentaValueChanged(ListSelectionEvent evt) {
		System.out.println("DETECTA CAMBIOS EN LA TABLA DE Trabajador CUENTA");
		this.actualizarPanelTrabajadorCuentaBotones();
	}
	
	private void rootWindowClosing(WindowEvent evt) {
		System.out.println("TA CERRANDO!!!");
		org.hsqldb.DatabaseManager.closeDatabases(0);
	}
	
	/* acciones del menu */
	private void jMenuItemCerrarActionPerformed(ActionEvent evt) {
		System.out.println("TA CERRANDO!!!");
		org.hsqldb.DatabaseManager.closeDatabases(0);
		this.dispose();
	}

}