package concesionario.clases;

import static org.junit.Assert.*;
import concesionario.server.bd.DBException;

import org.junit.Test;

public class DBExcpetionTest {

	@Test
	public void DBExceptionTest() {
		DBException dbe = null;
		try {
			dbe = new DBException("Error");
		} catch (concesionario.server.bd.DBException e) {
			assertEquals(e, dbe);
		}
	}
	
	@Test
	public void DBThrowableExceptionTest() {
		DBException dbe = null;
		try {
			dbe = new DBException("Error", new Throwable());
		} catch (concesionario.server.bd.DBException e) {
			assertEquals(e, dbe);
		}
	}
	

	@Test
	public void DBToStringTest() {
		DBException dbe = null;
		try {
			dbe = new DBException("Error", new Throwable());
			assertEquals("Error", dbe.toString());
		} catch (concesionario.server.bd.DBException e) {
		}
		
	}
	
	

}
