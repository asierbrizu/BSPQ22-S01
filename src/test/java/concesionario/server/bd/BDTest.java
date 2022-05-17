package concesionario.server.bd;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import org.junit.Test;

import concesionario.clases.Cliente;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

public class BDTest {

	Cliente clBD = new Cliente("Emiliano", "Sierra", "28/05/1978", "12345678P", "emiliano@gmail.com", null);
	Cliente adBD = new Cliente("Manu", "Ortega", "18/11/1998", "12345678D", "manu@gmail.com", null);
	Cliente clTest = new Cliente();
	Cliente adTest = new Cliente();
	Connection con = null;
	
	BD bd;

	@Test 
	public void testInitBD() throws DBException, SQLException {
		bd.initBD("pruebas.db");
	}
	
	public void testCrearTablas() throws DBException {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		bd.crearTablas(con);
	}
	
	@Test
	public void testInsertarUsuario() throws DBException, SQLException{
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		bd.insertarUsuario(con, clBD.getEmail(), "1234", clBD.getNombre(), clBD.getApellido(), clBD.getDni(), clBD.getFechaNacimiento(), null);
		
		
		clTest.setNombre(clBD.getNombre());
		assertEquals(clTest.getNombre(), clBD.getNombre());
		clTest.setApellido(clBD.getApellido());
		assertEquals(clTest.getApellido(), clBD.getApellido());
		clTest.setDni(clBD.getDni());
		assertEquals(clTest.getDni(), clBD.getDni());
		clTest.setFechaNacimiento(clBD.getFechaNacimiento());
		assertEquals(clTest.getFechaNacimiento(), clBD.getFechaNacimiento());
		clTest.setEmail(clBD.getEmail());
		assertEquals(clTest.getEmail(), clBD.getEmail());
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
	

	@Test
	public void existeDNITest() throws SQLException, DBException{
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.existeDni(con, "1111111A");
	}
	
	@Test
	public void existeEmailTest() throws SQLException, DBException{
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		bd.existeEmail(con, adBD.getEmail());
	}
	
	@Test
	public void testgetUltimaMatricula() throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		String matricula = bd.getUltimaMatricula(con);
	}
	
	@Test
	public void testObtenerUsuario() throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int numUsuario = bd.obtenerUsuario(con, "as", "1234");
	}
	
	@Test
	public void testObtenerAdministrador() throws DBException {
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		int numAdmin = bd.obtenerAdministrador(con, "as", "1234");
	}
	
	
	
	@Test
	public void testCloseBD() throws DBException {
		
		
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
	
}