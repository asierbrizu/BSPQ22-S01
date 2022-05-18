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
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import concesionario.clases.Cliente;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

@RunWith(org.mockito.runners.MockitoJUnitRunner.class)
public class BDTest {
	@Mock
	Cliente clBD = new Cliente();
	@Mock
	Cliente adBD = new Cliente();
	@Mock
	Cliente clTest = new Cliente();
	@Mock
	Cliente adTest = new Cliente();
	@Mock
	Connection con = null;
	@Mock
	BD bd;
	
	@Before
	public void setUp() {
		clBD=new Cliente("Emiliano", "Sierra", "28/05/1978", "12345678P", "emiliano@gmail.com", null);
		adBD = new Cliente("Manu", "Ortega", "18/11/1998", "12345678D", "manu@gmail.com", null);
		bd = org.mockito.Mockito.mock(BD.class);
		con = org.mockito.Mockito.mock(Connection.class);
	}

	@Test 
	public void testInitBD() throws DBException, SQLException {
		when(bd.initBD("pruebas.db")).thenReturn(con);
	}
	
	public void testCrearTablas() throws DBException, SQLException {
		
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:pruebas.db");
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		BD.crearTablas(con);
		
		BD.insertarUsuario(con, "test", "1234", "test", "test", "11111111P", "01-01-2000", "cliente");
		
		when(BD.existeDni(con, "11111111P")).thenReturn(true);
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
		
		BD.insertarUsuario(con, clBD.getEmail(), "1234", clBD.getNombre(), clBD.getApellido(), clBD.getDni(), clBD.getFechaNacimiento(), clBD.getTipo());
		
		clTest.setNombre(clBD.getNombre());
		when(clTest.getNombre()).thenReturn(clBD.getNombre());
		//assertEquals(clTest.getNombre(), clBD.getNombre());
		clTest.setApellido(clBD.getApellido());
		when(clTest.getApellido()).thenReturn(clBD.getApellido());
		//assertEquals(clTest.getApellido(), clBD.getApellido());
		clTest.setDni(clBD.getDni());
		when(clTest.getDni()).thenReturn(clBD.getDni());
		//assertEquals(clTest.getDni(), clBD.getDni());
		clTest.setFechaNacimiento(clBD.getFechaNacimiento());
		when(clTest.getFechaNacimiento()).thenReturn(clBD.getFechaNacimiento());
		//assertEquals(clTest.getFechaNacimiento(), clBD.getFechaNacimiento());
		clTest.setEmail(clBD.getEmail());
		when(clTest.getEmail()).thenReturn(clBD.getEmail());
		//assertEquals(clTest.getEmail(), clBD.getEmail());
	}
	/*
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
	}*/
	
	/*NO HACER  @Test
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
	}*/
	
	
	/*
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
	*/
}