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
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

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
	private static JMenu listaEmpleados;
	private JMenuItem menuItemCerrarVentana;
	private JMenuItem menuItemCerrarSesion;
	private JMenuItem menuItemListarMecanicos;
	private JMenuItem menuItemListarEmpleados;
	
	public VentanaEmpleado(BD bd){

		
		setLayout(new GridLayout(1,1));
		setSize(new Dimension(600,450));

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		add(panelPrincipal);

		menuPrincipal = new JMenuBar();
		menuPrincipal.setBackground(Color.LIGHT_GRAY);
		listaMecanicos = new JMenu();
		listaMecanicos.setMnemonic('C');
		
		listaEmpleados = new JMenu();
		listaEmpleados.setMnemonic('U');

		cerrar = new JMenu();
		cerrar.setMnemonic('I');

		lblDeustoAuto = new JLabel("CONCESIONARIO ADAIA");
		lblDeustoAuto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblDeustoAuto.setForeground(new Color(255, 255, 0));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1366, 815));
		setVisible(true);

		listaMecanicos.setText("Mecanicos");
		menuPrincipal.add(listaMecanicos);
		
		menuItemListarMecanicos = new JMenuItem();
		menuItemListarMecanicos.setText("Lista de Mecanicos");
		listaMecanicos.add(menuItemListarMecanicos);
		menuItemListarMecanicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				

			}

		});

		listaEmpleados.setText("Empleados");
		menuPrincipal.add(listaEmpleados);
		
		menuItemListarEmpleados = new JMenuItem();
		menuItemListarEmpleados.setText("Lista de Empleados");
		listaEmpleados.add(menuItemListarEmpleados);
		menuItemListarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				

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

	}
}
