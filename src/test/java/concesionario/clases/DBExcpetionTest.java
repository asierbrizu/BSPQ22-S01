package concesionario.clases;

import static org.junit.Assert.*;
import concesionario.server.bd.DBException;

import org.junit.Test;

public class DBExcpetionTest {

	@Test
	public void DBException() {
		DBException dbe = null;
		try {
			dbe = new DBException("Error");
		} catch (concesionario.server.bd.DBException e) {
			assertEquals(e, dbe);
		}
	}
	
	

}
