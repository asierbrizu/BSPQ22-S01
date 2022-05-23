package concesionario.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import concesionario.clases.Coche;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;


public class VentanaAdministrador extends JFrame {

	static JPanel panelPrincipal;
	
	public static JLabel lblDeustoAuto;
	private static JMenu menuCoches;
	private static JMenu menuEmpleados;
	private static JMenu menuCerrar;
	private JMenuBar menuPrincipal;
	private JMenuItem menuItemCerrarSesion;
	private JMenuItem menuItemDarPermisos;
	private JMenuItem menuItemVentanaEmpleado;

	
	private ArrayList<Coche> listaCoches = new ArrayList<>();
	private HashMap<String, ArrayList<Coche>> hashMarcas = new HashMap<String, ArrayList<Coche>>();
 

	public BD bd;
	
	public VentanaAdministrador() {
		
		bd = new BD();
		
		setLayout(new GridLayout(1,1));
	
		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		add(panelPrincipal);
		
		menuPrincipal = new JMenuBar();
		menuPrincipal.setBackground(Color.LIGHT_GRAY);
		menuCoches = new JMenu();
		menuCoches.setMnemonic('C');
		
		lblDeustoAuto = new JLabel("CONCESIONARIO ADAIA");
		lblDeustoAuto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblDeustoAuto.setForeground(new Color(255, 255, 0));

		
		
		ArrayList<String> marcas = new ArrayList<>();
		marcas.add("Audi");
		marcas.add("Mercedes");
		marcas.add("Alfa Romeo");
		marcas.add("Cupra");
		marcas.add("Dacia");
		marcas.add("Jaguar");
		marcas.add("Tesla");
		marcas.add("Mazda");
		marcas.add("Ferrari");
		marcas.add("Honda");
		marcas.add("BMW");
		
		for (String  marca : marcas) {

			Connection con =null;
			try {
				con = bd.initBD("bd_bspq");

				try {
					BD.crearTablas(con);
				} catch (DBException e3) {
					e3.printStackTrace();
				}
				
				try {
					ArrayList<Coche> temp = new ArrayList<>();
					temp = BD.listaCoches(con, marca);
					for (Coche c : temp) {
						listaCoches.add(c);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				}
				
			} catch (DBException e1) {
				e1.printStackTrace();
			}
			
			try {
				BD.closeBD(con);
			} catch (DBException e1) {
				e1.printStackTrace();	
			}
			
		}
		
		
		menuEmpleados = new JMenu();
		menuEmpleados.setMnemonic('U');// alt+u para abrir menu usuario

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1366, 815));
		setVisible(true);
		

		menuCoches.setText("Coches");

		
		
		for (Coche coche : listaCoches) {
			if(!hashMarcas.containsKey(coche.getMarca())){
				ArrayList<Coche> temp = new ArrayList<>();
				temp.add(coche);
				hashMarcas.put(coche.getMarca(), temp);
			} else {
				ArrayList<Coche> temp = new ArrayList<>();
				temp = hashMarcas.get(coche.getMarca());
				temp.add(coche);
				hashMarcas.put(coche.getMarca(), temp);
			}
		}
		
		for (String marca : marcas) {
			JMenuItem menuMarca = new JMenuItem();
			menuMarca.setText(marca);
			menuCoches.add(menuMarca);
			
			menuMarca.addActionListener(new ActionListener() {
				
				@Override
				public void actionPerformed(ActionEvent e) {
					panelPrincipal.removeAll();
					panelPrincipal.add(new VentanaPanelCoche(hashMarcas.get(marca)));
					repaint();
					validate();
					
					
				}
			});
		}

		menuPrincipal.add(menuCoches);

		
		
		
	
		menuEmpleados.setText("Empleados");

		menuPrincipal.add(menuEmpleados);

		menuCerrar = new JMenu("Cerrar");
		menuItemCerrarSesion = new JMenuItem();
		menuItemCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicio();
			}
		});
		menuItemCerrarSesion.setText("Cerrar sesion");
		menuCerrar.add(menuItemCerrarSesion);
		menuItemCerrarSesion.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicio();
				
			}
		});
		menuPrincipal.add(menuCerrar);

		menuItemDarPermisos = new JMenuItem();
		menuItemDarPermisos.setText("Dar permisos");
		menuEmpleados.add(menuItemDarPermisos);
		menuItemDarPermisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {

			}

		});
		
		menuItemVentanaEmpleado = new JMenuItem();
		menuItemVentanaEmpleado.setText("Ventana Empleado");
		menuEmpleados.add(menuItemVentanaEmpleado);
		menuItemVentanaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				panelPrincipal.add(new VentanaEmpleado(bd));

			
		}
		});

		setJMenuBar(menuPrincipal);
		setTitle("VENTANA ADMINISTRADOR");


		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);
	}

	/**
	 * deshabilita el menu
	 */
	public static void bloquearBotones() {

		menuCoches.setEnabled(false);
		menuEmpleados.setEnabled(false);

	}

	/**
	 * habilita el menu
	 */
	public static void desbloquearBotones() {

		menuCoches.setEnabled(true);
		menuEmpleados.setEnabled(true);

	}

}