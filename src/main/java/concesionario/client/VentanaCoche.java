package concesionario.client;

import java.awt.EventQueue;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.EmptyBorder;
import javax.swing.text.AttributeSet.ColorAttribute;

import concesionario.clases.Coche;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class VentanaCoche extends JInternalFrame {

	public static JLabel lblCocheMarca;
	public static JLabel lblCocheModelo;
	public static JLabel lblCocheColor;
	public static JLabel lblCocheMatricula;
	public static JLabel lblCochePrecio;
	public static JLabel lblNoCoche;
	public static JFrame ventanaActual;
	private static Connection con;
	ArrayList<Coche> listaCoches;
	/**
	 * @wbp.nonvisual location=423,184
	 */
	private final JPanel panelCentral = new JPanel();

	public VentanaCoche(String hostname, String port, String marca) {
		
		VentanaAdministrador ventanaAdministrador = new VentanaAdministrador(hostname, port);
		
		ventanaActual = ventanaAdministrador.ventanaActual;
		
		panelCentral.setBackground(Color.RED);
		panelCentral.setForeground(Color.WHITE);
		panelCentral.setBounds(50,50,25,25);
		panelCentral.setVisible(true);
		
		ventanaActual.setTitle("VENTANA COCHES");
		ventanaActual.setContentPane(panelCentral);
		
		Connection con =null;
		try {
			con = BD.initBD("concesionario.db");

			try {
				BD.crearTablas(con);
			} catch (DBException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			try {
				listaCoches = BD.listaCoches(con, marca);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			BD.closeBD(con);
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();	
		}
		
		if(listaCoches.size() != 0) {
			for(int i = 0; i < listaCoches.size(); i++) {
				lblCocheMarca = new JLabel(listaCoches.get(i).getMarca());
				lblCocheMarca.setBounds(26, 26, 227, 14);
				lblCocheMarca.setForeground(Color.WHITE);
				panelCentral.add(lblCocheMarca);
				lblCocheMarca.setHorizontalAlignment(SwingConstants.CENTER);
				lblCocheMarca.setBackground(Color.LIGHT_GRAY);
				lblCocheMarca.setVisible(true);
				
				lblCocheModelo = new JLabel(listaCoches.get(i).getModelo());
				lblCocheModelo.setBounds(26, 26, 227, 14);
				panelCentral.add(lblCocheModelo);
				lblCocheModelo.setHorizontalAlignment(SwingConstants.CENTER);
				lblCocheModelo.setBackground(Color.LIGHT_GRAY);
				lblCocheModelo.setVisible(true);
				
				lblCocheColor = new JLabel(listaCoches.get(i).getColor());
				lblCocheColor.setBounds(26, 26, 227, 14);
				panelCentral.add(lblCocheColor);
				lblCocheColor.setHorizontalAlignment(SwingConstants.CENTER);
				lblCocheColor.setBackground(Color.LIGHT_GRAY);
				lblCocheColor.setVisible(true);
				
				lblCochePrecio = new JLabel(listaCoches.get(i).getPrecioBase() + "");
				lblCochePrecio.setBounds(26, 26, 227, 14);
				panelCentral.add(lblCochePrecio);
				lblCochePrecio.setHorizontalAlignment(SwingConstants.CENTER);
				lblCochePrecio.setBackground(Color.LIGHT_GRAY);
				lblCochePrecio.setVisible(true);
				
				lblCocheMatricula = new JLabel(listaCoches.get(i).getMatricula());
				lblCocheMatricula.setBounds(26, 26, 227, 14);
				panelCentral.add(lblCocheMatricula);
				lblCocheMatricula.setHorizontalAlignment(SwingConstants.CENTER);
				lblCocheMatricula.setBackground(Color.LIGHT_GRAY);
				lblCocheMatricula.setVisible(true);
				
			}
		}else {
			lblNoCoche.setBounds(26, 26, 227, 14);
			lblNoCoche.setText("NO TENEMOS COCHES DISPONIBLES. SENTIMOS LAS MOLESTIAS");
			panelCentral.add(lblNoCoche);
			lblNoCoche.setHorizontalAlignment(SwingConstants.LEFT);
			lblNoCoche.setBackground(new Color(255, 255, 0));
		}
		
	}

	public static ArrayList<Coche> listaCoches(String marca) {
		try {
			con = BD.initBD("concesionario.db");
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Coche> listaCoche = null;
		try {
			listaCoche = BD.listaCoches(con, marca);
		} catch (SQLException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		try {
			BD.closeBD(con);
		} catch (DBException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
		return listaCoche;

	}
}
