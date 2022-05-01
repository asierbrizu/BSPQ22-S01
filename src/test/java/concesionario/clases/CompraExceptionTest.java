package concesionario.clases;

import static org.junit.Assert.*;

import org.junit.Test;

import concesionario.util.CompraException;

public class CompraExceptionTest {

	@Test
	public void compraExceptionTest() {
		CompraException cE = new CompraException("Error");
	}

}
