package concesionario.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import concesionario.clases.Coche;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.awt.event.InputEvent;
import java.awt.Font;
import java.awt.GridLayout;


public class VentanaAdministrador extends JFrame {

	static JPanel panelPrincipal;
	
	public static JLabel lblDeustoAuto;
	private static JMenu menuCoches;
	private static JMenu menuEmpleados;
	private JMenuBar menuPrincipal;
	private JMenuItem menuItemAudi;
	private JMenuItem menuItemMercedes;
	private JMenuItem menuItemHyundai;
	private JMenuItem menuItemAlfaRomeo;
	private JMenuItem menuItemCupra;
	private JMenuItem menuItemDacia;
	private JMenuItem menuItemJaguar;
	private JMenuItem menuItemTesla;
	private JMenuItem menuItemMazda;
	private JMenuItem menuItemFerrari;
	private JMenuItem menuItemHonda;
	private JMenuItem menuItemBMW;
	private JMenuItem menuItemCerrarSesion;
	private JMenuItem menuItemGestionarEmpleados;
	private JMenuItem menuItemDarPermisos;
	private JMenuItem menuItemVentanaEmpleado;

	private ImageIcon imagenAzafato;
	private ImageIcon imagenCerrarSesion;
	private ImageIcon imagenAniadir;
	private ImageIcon imagenLlave;
	private ImageIcon imagenActualizar;
	private ImageIcon imagenUsuario;
	private ImageIcon imagenIrAzafato;
	
	private ArrayList<Coche> listaCoches = new ArrayList<>();
	private HashMap<String, ArrayList<Coche>> hashMarcas = new HashMap<String, ArrayList<Coche>>();
 

	public VentanaAdministrador(String hostname, String port) {
		
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
				con = BD.initBD("concesionario.db");

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
		
//		menuItemAudi.setText("Audi");
//		menuItemMercedes.setText("Mercedes");
//		menuItemHyundai.setText("Hyundai");
//		menuItemAlfaRomeo.setText("Alfa Romeo");
//		menuItemCupra.setText("Cupra");
//		menuItemDacia.setText("Dacia");
//		menuItemJaguar.setText("Jaguar");
//		menuItemTesla.setText("Tesla");
//		menuItemMazda.setText("Mazda");
//		menuItemFerrari.setText("Ferrari");
//		menuItemHonda.setText("Honda");
//		menuItemBMW.setText("BMW");
//
//		menuCoches.add(menuItemAudi);
//		menuCoches.add(menuItemMercedes);
//		menuCoches.add(menuItemHyundai);
//		menuCoches.add(menuItemAlfaRomeo);
//		menuCoches.add(menuItemCupra);
//		menuCoches.add(menuItemDacia);
//		menuCoches.add(menuItemJaguar);
//		menuCoches.add(menuItemTesla);
//		menuCoches.add(menuItemMazda);
//		menuCoches.add(menuItemFerrari);
//		menuCoches.add(menuItemHonda);

		menuPrincipal.add(menuCoches);

		
		
		
	
		menuEmpleados.setText("Empleados");
		menuEmpleados.setIcon(imagenUsuario);

		menuPrincipal.add(menuEmpleados);

		menuItemGestionarEmpleados = new JMenuItem();
		menuItemGestionarEmpleados.setIcon(imagenAzafato);
		menuItemGestionarEmpleados.setText("Gestionar empleados");
		menuEmpleados.add(menuItemGestionarEmpleados);
		menuItemGestionarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {


				

			}

		});

		menuItemCerrarSesion = new JMenuItem();
		menuItemCerrarSesion.setIcon(imagenCerrarSesion);
		menuItemCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicio(hostname, port);
			}
		});
		menuItemCerrarSesion.setText("Cerrar sesion");
		menuEmpleados.add(menuItemCerrarSesion);

		menuItemDarPermisos = new JMenuItem();
		menuItemDarPermisos.setText("Dar permisos");
		menuItemDarPermisos.setIcon(imagenLlave);
		menuEmpleados.add(menuItemDarPermisos);
		menuItemDarPermisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {


				

			}

		});
		
		menuItemVentanaEmpleado = new JMenuItem();
		menuItemVentanaEmpleado.setText("Ventana Empleado");
		menuItemVentanaEmpleado.setIcon(imagenIrAzafato);
		menuEmpleados.add(menuItemVentanaEmpleado);
		menuItemVentanaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();


			
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