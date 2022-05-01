package concesionario.clases;

import static org.junit.Assert.*; 

import org.junit.Test;

import concesionario.util.CompraException;

public class CompraExceptionTest {

	@Test
	public void compraExceptionTest() {
		CompraException cE = new CompraException("Error");
	}
	
	@Test
	public void toStringTest() {
		CompraException cE = new CompraException("Error");
		assertEquals("concesionario.util.CompraException: Error", cE.toString());
	}
	
	
	

}
