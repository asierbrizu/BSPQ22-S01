package concesionario.client;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.*;

import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

public class VentanaCoches extends JInternalFrame {
	static JDesktopPane panelEscritorio;
	public static JLabel lblDeustoAuto;
	public static JFrame ventanaActual;
	private static Connection con;
	ArrayList<String> listaCoches;
	
	public VentanaCoches(String hostname, String port, String marca) {
		ventanaActual = new VentanaAdministrador(hostname, port).ventanaActual;
		setTitle("VENTANA COCHES");
		
		Connection con =null;
		try {
			con = BD.initBD("concesionario.db");

			try {
				BD.crearTablas(con);
			} catch (DBException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
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
		
		boolean m = existeCoche(marca);
		if(m) {
			Connection conn = null;
			try {
				conn = BD.initBD("concesionario.db");
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			try {
				listaCoches =  BD.listaCoches(conn, marca);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				BD.closeBD(conn);
			} catch (DBException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();	
			}
		}

		for(int i = 0; i < listaCoches.size(); i++) {
			System.out.println(i);
		}

	}
	
	public static boolean existeCoche(String marca) {
		try {
			con = BD.initBD("concesionario.db");
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		boolean existeCoche = false;
		try {
			existeCoche = BD.existeCoche(con, marca);
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
		return existeCoche;

	}
	
	public static ArrayList<String> listaCoches(String marca) {
		try {
			con = BD.initBD("concesionario.db");
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<String> listaCoche = null;
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