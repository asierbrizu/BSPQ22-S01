package concesionario.client;

import java.awt.BorderLayout;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import concesionario.clases.Coche;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

public class VentanaCoches extends JInternalFrame {
	static JDesktopPane panelEscritorio;
	public static JLabel lblDeustoAuto;
	public static JFrame ventanaActual;
	private JPanel panelCentral;
	private static Connection con;
	ArrayList<Coche> listaCoches;
	
	public VentanaCoches(String hostname, String port, String marca) {
		ventanaActual = new VentanaAdministrador(hostname, port).ventanaActual;
		ventanaActual.setTitle("VENTANA COCHES");
		
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
			//HACER PANEL BONITO AQUI
			for(int i = 0; i < listaCoches.size(); i++) {
				System.out.println(listaCoches.get(i).getModelo());
			}
		}else {
			System.out.println("NO HAY COCHES DE LA MARCA " + marca);
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