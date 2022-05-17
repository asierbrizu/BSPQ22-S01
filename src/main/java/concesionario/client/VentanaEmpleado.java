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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import concesionario.clases.Coche;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

public class VentanaEmpleado extends JFrame{
	static JPanel panelPrincipal;
	private JMenuBar menuPrincipal;
	public static JLabel lblDeustoAuto;
	private static JMenu volverInicio;
	private static JMenu listaMecanicos;
	private static JMenu listaEmpleados;
	private JMenuItem menuItemVolverInicio;
	private JMenuItem menuItemCerrarSesion;
	

	public VentanaEmpleado(){
		setLayout(new GridLayout(1,1));

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		add(panelPrincipal);

		menuPrincipal = new JMenuBar();
		menuPrincipal.setBackground(Color.LIGHT_GRAY);
		listaMecanicos = new JMenu();
		listaMecanicos.setMnemonic('C');
		
		ArrayList<String> marcas = new ArrayList<>();
		
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
						//listaCoches.add(c);
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

		listaEmpleados = new JMenu();
		listaEmpleados.setMnemonic('U');

		volverInicio = new JMenu();
		volverInicio.setMnemonic('I');

		lblDeustoAuto = new JLabel("CONCESIONARIO ADAIA");
		lblDeustoAuto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblDeustoAuto.setForeground(new Color(255, 255, 0));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1366, 815));
		setVisible(true);

		listaMecanicos.setText("Lista Mecanicos");
		menuPrincipal.add(listaMecanicos);

		listaEmpleados.setText("Lista Empleados");
		menuPrincipal.add(listaEmpleados);
		
		

		volverInicio.setText("Volver");
		menuPrincipal.add(volverInicio);

		menuItemVolverInicio = new JMenuItem();
		menuItemVolverInicio.setText("Ventana Inicio");
		volverInicio.add(menuItemVolverInicio);
		menuItemVolverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
				new VentanaAdministrador();

			}

		});
		
		menuItemCerrarSesion = new JMenuItem();
		menuItemCerrarSesion.setText("Cerrar Sesion");
		volverInicio.add(menuItemCerrarSesion);
		menuItemCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
				new VentanaInicio();

			}

		});

		setJMenuBar(menuPrincipal);
		setTitle("VENTANA EMPLEADO");


		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
}
