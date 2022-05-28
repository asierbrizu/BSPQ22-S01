package concesionario.server.bd;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import junit.framework.JUnit4TestAdapter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;

import concesionario.clases.Cliente;

import org.junit.Rule;
import org.databene.contiperf.Required;
import org.databene.contiperf.PerfTest;
import org.databene.contiperf.junit.ContiPerfRule;
import org.databene.contiperf.report.EmptyReportModule;

@PerfTest(invocations = 1000, threads = 20)
@Required(max = 150, average = 60)
public class BDPerfTest {
	@Rule 
	public ContiPerfRule rule = new ContiPerfRule();

	Cliente clBD = new Cliente();
	Cliente adBD = new Cliente();
	Cliente clTest = new Cliente();
	Cliente adTest = new Cliente();
	Connection con = null;
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
		//when(bd.initBD("bd_bspq")).thenReturn(con);
		bd.initBD("bd_bspq");
	}
	@Test
	public void testCrearTablas() throws DBException, SQLException {
		
		assertNull(con.getSchema());
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
	public void existeDNITest() throws SQLException, DBException{
		assertEquals(clBD.getDni(), "12345678P");
	}
	
	@Test
	public void existeEmailTest() throws SQLException, DBException{
		assertEquals(clBD.getEmail(), "emiliano@gmail.com");
	}

}
