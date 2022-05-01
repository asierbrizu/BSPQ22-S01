package concesionario.clases;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.junit.Test;

import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

public class BDTest {

	Cliente clBD = new Cliente("Emiliano", "Sierra", "28/05/1978", "12345678P", "emiliano@gmail.com");
	Cliente clTest = new Cliente();
	
	static BD bd;

	@Test 
	public void testInitBD() throws DBException, SQLException {
		bd.initBD("pruebas.db");
	}
	
	@Test
	public void testCloseBD() throws DBException {
		
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		bd.closeBD(con);
	}
	
	@Test
	public void testInsertarUsuario() throws DBException, SQLException{
		
		
		
	}
	
	@Test
	public void testEquals() {
		
		assertTrue(clBD.getNombre() == clBD.getNombre());
		assertTrue(clBD.getApellido() == clBD.getApellido());
		assertTrue(clBD.getEmail() == clBD.getEmail());
		assertTrue(clBD.getDni() == clBD.getDni());
		assertTrue(clBD.getFechaNacimiento() == clBD.getFechaNacimiento());
		
	}
	
	@Test
	public void BDTest() throws DBException, SQLException{
		BD b = new BD();
		
	}
}