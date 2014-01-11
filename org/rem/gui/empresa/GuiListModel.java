package org.rem.gui.empresa;

import info.clearthought.layout.TableLayout;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.border.TitledBorder;
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
public class GuiListModel extends JPanel {

	private static final long serialVersionUID = 1L;

	private JPanel jPanelMenuEmpresaButton;

	public JButton jButtonEmpresaAdd;

	public JButton jButtonEmpresaUpdate;

	public JButton jButtonTrabajadorRemove;

	public JButton jButtonTrabajadorUpdate;

	public JButton jButtonTrabajadorAdd;

	private JPanel jPanelMenuTrabajadorButton;

	private JPanel jPanelMenuTrabajador;

	public JList jListTrabajador;

	private JScrollPane jScrollPaneMenuTrabajador;

	private JPanel jPanelMenuTrabajador2;

	public JButton jButtonEmpresaRemove;

	public JList jListEmpresa;

	private JScrollPane jScrollPaneMenuEmpresa;

	private JPanel jPanelMenuEmpresa2;

	private JPanel jPanelMenuEmpresa;

	/**
	 * This is the default constructor
	 */
	public GuiListModel() {
		super();
		initialize();
	}

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		this.setSize(120, 400);
		TableLayout thisLayout = new TableLayout(new double[][] {
				{ TableLayout.FILL }, { TableLayout.FILL, TableLayout.FILL } });
		thisLayout.setHGap(5);
		thisLayout.setVGap(5);
		this.setLayout(thisLayout);
		this.setBorder(BorderFactory.createTitledBorder(null, "Menú",
				TitledBorder.DEFAULT_JUSTIFICATION,
				TitledBorder.DEFAULT_POSITION,
				new Font("Dialog", Font.BOLD, 12), new Color(51, 51, 51)));
		{
			jPanelMenuEmpresa = new JPanel();
			this.add(jPanelMenuEmpresa, "0, 0");
			CardLayout jPanelMenuEmpresaLayout = new CardLayout();
			jPanelMenuEmpresa.setBorder(BorderFactory
					.createTitledBorder("Empresa"));
			jPanelMenuEmpresa.setLayout(jPanelMenuEmpresaLayout);
			{
				jPanelMenuEmpresa2 = new JPanel();
				TableLayout jPanelMenuEmpresa2Layout = new TableLayout(
						new double[][] { { TableLayout.FILL },
								{ TableLayout.FILL, TableLayout.PREFERRED } });
				jPanelMenuEmpresa2Layout.setHGap(5);
				jPanelMenuEmpresa2Layout.setVGap(5);
				jPanelMenuEmpresa.add(jPanelMenuEmpresa2, "jPanelMenuEmpresa2");
				jPanelMenuEmpresa2.setLayout(jPanelMenuEmpresa2Layout);
				{
					jScrollPaneMenuEmpresa = new JScrollPane();
					jPanelMenuEmpresa2.add(jScrollPaneMenuEmpresa, "0,    0");
					{
						jListEmpresa = new JList();
						jScrollPaneMenuEmpresa.setViewportView(jListEmpresa);
					}
				}
				{
					jPanelMenuEmpresaButton = new JPanel();
					TableLayout jPanelMenuEmpresaButtonLayout = new TableLayout(
							new double[][] {
									{ TableLayout.FILL },
									{ TableLayout.FILL, TableLayout.FILL,
											TableLayout.FILL } });
					jPanelMenuEmpresaButtonLayout.setHGap(5);
					jPanelMenuEmpresaButtonLayout.setVGap(5);
					jPanelMenuEmpresa2.add(jPanelMenuEmpresaButton, "0,    1");
					jPanelMenuEmpresaButton
							.setLayout(jPanelMenuEmpresaButtonLayout);
					{
						jButtonEmpresaAdd = new JButton();
						jPanelMenuEmpresaButton.add(jButtonEmpresaAdd,
								"0,     0");
						jButtonEmpresaAdd.setText("Agregar");
						{
							jButtonEmpresaUpdate = new JButton();
							jPanelMenuEmpresaButton.add(jButtonEmpresaUpdate,
									"0,    1");
							jButtonEmpresaUpdate.setText("Modificar");
						}
						{
							jButtonEmpresaRemove = new JButton();
							jPanelMenuEmpresaButton.add(jButtonEmpresaRemove,
									"0,    2");
							jButtonEmpresaRemove.setText("Eliminar");
						}
					}
				}
			}
			{
				jPanelMenuTrabajador = new JPanel();
				this.add(jPanelMenuTrabajador, "0, 1");
				CardLayout jPanelMenuTrabajadorLayout = new CardLayout();
				jPanelMenuTrabajador.setBorder(BorderFactory
						.createTitledBorder("Trabajador"));
				jPanelMenuTrabajador.setLayout(jPanelMenuTrabajadorLayout);
				{
					jPanelMenuTrabajador2 = new JPanel();
					TableLayout jPanelMenuTrabajador2Layout = new TableLayout(
							new double[][] { { TableLayout.FILL },
									{ TableLayout.FILL, TableLayout.PREFERRED } });
					jPanelMenuTrabajador2Layout.setHGap(5);
					jPanelMenuTrabajador2Layout.setVGap(5);
					jPanelMenuTrabajador.add(jPanelMenuTrabajador2,
							"jPanelMenuTrabajador2");
					jPanelMenuTrabajador2
							.setLayout(jPanelMenuTrabajador2Layout);
					{
						jScrollPaneMenuTrabajador = new JScrollPane();
						jPanelMenuTrabajador2.add(jScrollPaneMenuTrabajador,
								"0,    0");
						{
							jListTrabajador = new JList();
							jScrollPaneMenuTrabajador
									.setViewportView(jListTrabajador);
						}
					}
					{
						jPanelMenuTrabajadorButton = new JPanel();
						TableLayout jPanelMenuTrabajadorButtonLayout = new TableLayout(
								new double[][] {
										{ TableLayout.FILL },
										{ TableLayout.FILL, TableLayout.FILL,
												TableLayout.FILL } });
						jPanelMenuTrabajadorButtonLayout.setHGap(5);
						jPanelMenuTrabajadorButtonLayout.setVGap(5);
						jPanelMenuTrabajador2.add(jPanelMenuTrabajadorButton,
								"0,    1");
						jPanelMenuTrabajadorButton
								.setLayout(jPanelMenuTrabajadorButtonLayout);
						{
							jButtonTrabajadorAdd = new JButton();
							jPanelMenuTrabajadorButton.add(
									jButtonTrabajadorAdd, "0,    0");
							jButtonTrabajadorAdd.setText("Agregar");
						}
						{
							jButtonTrabajadorUpdate = new JButton();
							jPanelMenuTrabajadorButton.add(
									jButtonTrabajadorUpdate, "0,    1");
							jButtonTrabajadorUpdate.setText("Modificar");
						}
						{
							jButtonTrabajadorRemove = new JButton();
							jPanelMenuTrabajadorButton.add(
									jButtonTrabajadorRemove, "0,    2");
							jButtonTrabajadorRemove.setText("Eliminar");
						}
					}
				}
			}
		}

	}

}