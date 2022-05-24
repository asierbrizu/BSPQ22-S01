package concesionario.client;

import java.awt.Color; 
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import concesionario.clases.Cliente;
import concesionario.clases.Coche;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

public class VentanaEmpleado extends JInternalFrame{
	static JPanel panelPrincipal;
	private JMenuBar menuPrincipal;
	public static JLabel lblDeustoAuto;
	private static JMenu cerrar;
	private static JMenu listaMecanicos;
	private static JMenu listarEmpleados;
	private JMenuItem menuItemCerrarVentana;
	private JMenuItem menuItemCerrarSesion;
	private JMenuItem menuItemListarMecanicos;
	private JMenuItem menuItemListarEmpleados;
	private JList listaEmpleados;

	public VentanaEmpleado(BD bd){

		setLayout(new GridLayout(1,1));
		setPreferredSize(new Dimension(1000, 700));
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		add(panelPrincipal);

		menuPrincipal = new JMenuBar();
		menuPrincipal.setBackground(Color.LIGHT_GRAY);
		listaMecanicos = new JMenu();
		listaMecanicos.setMnemonic('C');

		listarEmpleados = new JMenu();
		listarEmpleados.setMnemonic('U');

		cerrar = new JMenu();
		cerrar.setMnemonic('I');

		lblDeustoAuto = new JLabel("CONCESIONARIO ADAIA");
		lblDeustoAuto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblDeustoAuto.setForeground(new Color(255, 255, 0));

		listaMecanicos.setText("Mecanicos");
		menuPrincipal.add(listaMecanicos);

		menuItemListarMecanicos = new JMenuItem();
		menuItemListarMecanicos.setText("Lista de Mecanicos");
		listaMecanicos.add(menuItemListarMecanicos);
		menuItemListarMecanicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				panelPrincipal.setLayout(new GridLayout(1,1));
				panelPrincipal.removeAll();

				String data[][]={ 
						{"O01","Amit SuperCoches","Neumáticos", "JEEP", "606354806", "amit@yahoo.es"},    
						{"G02","Brizuela Motors","Motores", "Tesla", "645589769", "brizumotors@gmail.com"},    
						{"A03","MartinezBD","Carrocería", "BMW", "688685886", "asiermartinez@deusto.es"},
						{"J04","DeustoDavid Fixes","Chapa y Pintura", "Alfa Romeo", "676789567", "deustodavid@hotmail.es"},
						{"V05","Crotofroto autos","Frenos", "Citroen", "646578234", "crotofroto@yahoo.es"},
						{"K06","AlazneTickVerde","Recambios y repuestos", "Cupra", "655789670", "alazne@gmail.com"},
						{"K06","Morales Motors","Alumbrado", "Cupra", "654589709", "ikermorales@jojodeusto.es"}
						};    
				String column[]={"ID","Nombre","Especialidad","Marca","Telefono","Email"};         
				JTable jt=new JTable(data,column);    
//				panelPrincipal.add(jt);
				JScrollPane js = new JScrollPane(jt);
				js.setBackground(Color.white);
				panelPrincipal.add(js);

				repaint();
				validate();

			}

		});

		listarEmpleados.setText("Empleados");
		menuPrincipal.add(listarEmpleados);

		menuItemListarEmpleados = new JMenuItem();
		menuItemListarEmpleados.setText("Lista de Empleados");
		listarEmpleados.add(menuItemListarEmpleados);

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.black);

		menuItemListarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

				panelPrincipal.removeAll();

				HashMap<String, JPanel> hashEmpleados = setUpEmpleados(bd);
				panelPrincipal.setLayout(new GridLayout(2,1));


				String[] arrayParaLaJList = new String[hashEmpleados.keySet().size()];
				int i = 0;
				for (String string : hashEmpleados.keySet()) {
					arrayParaLaJList[i] = string;
					//System.out.println(string);
					i++;
				}

				listaEmpleados = new JList<>(arrayParaLaJList);
				JScrollPane scrollPane = new JScrollPane();
				scrollPane.setViewportView(listaEmpleados);
				panelPrincipal.add(scrollPane);
				listaEmpleados.setListData(arrayParaLaJList);


				panelInfo.setLayout(new GridLayout(1,1));
				panelPrincipal.add(panelInfo);

				listaEmpleados.addListSelectionListener(new ListSelectionListener() {

					@Override
					public void valueChanged(ListSelectionEvent e) {
						try {
							panelInfo.removeAll();

							if (!e.getValueIsAdjusting()) {
								panelInfo.add(hashEmpleados.get(listaEmpleados.getSelectedValue()));
							}

							repaint();
							validate();
						} catch (Exception e2) {

						}

					}
				});

				repaint();
				validate();


			}

		});


		cerrar.setText("Cerrar");
		menuPrincipal.add(cerrar);

		menuItemCerrarVentana = new JMenuItem();
		menuItemCerrarVentana.setText("Cerrar Ventana");
		cerrar.add(menuItemCerrarVentana);
		menuItemCerrarVentana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();

			}

		});

		setJMenuBar(menuPrincipal);
		setTitle("VENTANA EMPLEADO");
		setVisible(true);

	}

	public HashMap<String, JPanel> setUpEmpleados(BD bd) {
		HashMap<String, JPanel> resultado = new HashMap<>();

		ArrayList<Cliente> empleados = bd.getEmpleados();

		for (Cliente empleado : empleados) {

			JPanel panel = new JPanel();
			panel.setForeground(Color.WHITE);
			panel.setBackground(Color.BLACK);
			panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

			JLabel icono = new JLabel("");
			panel.add(icono);
			icono.setBackground(Color.BLACK);
			URL urlImagen=getClass().getResource("/img/empleado.png");
			icono.setIcon(new ImageIcon(urlImagen));
			icono.setHorizontalAlignment(SwingConstants.CENTER);
			icono.setForeground(Color.WHITE);

			JLabel labelNombreApellido = new JLabel(empleado.getNombre() + " " + empleado.getApellido());
			labelNombreApellido.setFont(new Font("Consolas", Font.PLAIN, 13));
			labelNombreApellido.setBackground(Color.BLACK);
			labelNombreApellido.setForeground(Color.WHITE);
			labelNombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(labelNombreApellido);

			JPanel panel_1 = new JPanel();
			panel_1.setBackground(Color.BLACK);
			panel.add(panel_1);
			panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 5));

			JLabel lblNewLabel = new JLabel("DNI");
			panel_1.add(lblNewLabel);
			lblNewLabel.setBackground(Color.BLACK);
			lblNewLabel.setForeground(Color.WHITE);

			JTextField textField = new JTextField();
			textField.setText(empleado.getDni());
			panel_1.add(textField);
			textField.setEditable(false);
			textField.setEnabled(true);
			textField.setColumns(10);

			JPanel panel_1_1 = new JPanel();
			panel_1_1.setBackground(Color.BLACK);
			panel.add(panel_1_1);
			panel_1_1.setLayout(new FlowLayout(FlowLayout.CENTER, 15, 5));

			JLabel lblNewLabel_1 = new JLabel("Email:");
			panel_1_1.add(lblNewLabel_1);
			lblNewLabel_1.setForeground(Color.WHITE);
			lblNewLabel_1.setBackground(Color.BLACK);

			JTextField textField_1 = new JTextField();
			textField_1.setText(empleado.getEmail());
			textField_1.setEnabled(true);
			textField_1.setEditable(false);
			textField_1.setPreferredSize(new Dimension(125,25));
			panel_1_1.add(textField_1);
			textField_1.setColumns(10);

			String nom = empleado.getNombre().toLowerCase();
			String ape = empleado.getApellido().toLowerCase();
			nom = nom.substring(0, 1).toUpperCase() + nom.substring(1);
			ape = ape.substring(0, 1).toUpperCase() + ape.substring(1);

			resultado.put(nom + " " + ape, panel);

		}

		return resultado;
	}
}
