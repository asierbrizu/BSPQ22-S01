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

		menuItemAudi = new JMenuItem();
		menuItemAudi.setIcon(imagenAniadir);
		menuItemAudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("1");
				new VentanaCoche(hostname, port, "Audi");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemMercedes = new JMenuItem();
		menuItemMercedes.setIcon(imagenAniadir);
		menuItemMercedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Mercedes");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemHyundai = new JMenuItem();
		menuItemHyundai.setIcon(imagenAniadir);
		menuItemHyundai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Hyundai");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemAlfaRomeo = new JMenuItem();
		menuItemAlfaRomeo.setIcon(imagenAniadir);
		menuItemAlfaRomeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Alfa Romeo");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemCupra = new JMenuItem();
		menuItemCupra.setIcon(imagenAniadir);
		menuItemCupra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Cupra");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemDacia = new JMenuItem();
		menuItemDacia.setIcon(imagenAniadir);
		menuItemDacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Dacia");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemJaguar = new JMenuItem();
		menuItemJaguar.setIcon(imagenAniadir);
		menuItemJaguar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Jaguar");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemTesla = new JMenuItem();
		menuItemTesla.setIcon(imagenAniadir);
		menuItemTesla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Tesla");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemMazda = new JMenuItem();
		menuItemMazda.setIcon(imagenAniadir);
		menuItemMazda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Mazda");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemFerrari = new JMenuItem();
		menuItemFerrari.setIcon(imagenAniadir);
		menuItemFerrari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Ferrari");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemHonda = new JMenuItem();
		menuItemHonda.setIcon(imagenAniadir);
		menuItemHonda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Honda");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemBMW = new JMenuItem();
		menuItemBMW.setIcon(imagenActualizar);

		menuItemBMW.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelPrincipal.removeAll();
				
				panelPrincipal.add(new VentanaPanelCoche());
				repaint();
				validate();
				
			}
		});
		
		
		ArrayList<String> marcas = new ArrayList<>();
		marcas.add("Audi");
		marcas.add("Mercedes");
		marcas.add("ALfa Romero");
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
		
		menuItemAudi.setText("Audi");
		menuItemMercedes.setText("Mercedes");
		menuItemHyundai.setText("Hyundai");
		menuItemAlfaRomeo.setText("Alfa Romeo");
		menuItemCupra.setText("Cupra");
		menuItemDacia.setText("Dacia");
		menuItemJaguar.setText("Jaguar");
		menuItemTesla.setText("Tesla");
		menuItemMazda.setText("Mazda");
		menuItemFerrari.setText("Ferrari");
		menuItemHonda.setText("Honda");
		menuItemBMW.setText("BMW");

		menuCoches.add(menuItemAudi);
		menuCoches.add(menuItemMercedes);
		menuCoches.add(menuItemHyundai);
		menuCoches.add(menuItemAlfaRomeo);
		menuCoches.add(menuItemCupra);
		menuCoches.add(menuItemDacia);
		menuCoches.add(menuItemJaguar);
		menuCoches.add(menuItemTesla);
		menuCoches.add(menuItemMazda);
		menuCoches.add(menuItemFerrari);
		menuCoches.add(menuItemHonda);

		
		menuItemBMW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			/*	BuscarPasajero b = new BuscarPasajero();
				panelEscritorio.add(b);
				b.setVisible(true);
				bloquearBotones();*/

			}
		});
		menuCoches.add(menuItemBMW);

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