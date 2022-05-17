package concesionario.clases;
import static org.junit.Assert.*;

import org.junit.Test;

public class CompraTest {
/*
 * 
 * private String id;
	private Cliente cliente;
	private String matricula;
	private String fecha;
	private String id_coche;
 * 
 * 
 * */
	
	Compra c1 = new Compra();
	Compra c2 = new Compra("1", new Cliente("Asier", "Brizuela", "01-01-1999", "12345678A", "asierbrizu@opendeusto.es", null), "123AAA", "27-04-2022", "70");
	
	@Test
	public void testGetId() {
		assertEquals("1", c2.getId());
	}
	@Test
	public void testSetId() {
		c1.setId("45");
		assertEquals("45", c1.getId());
	}
	@Test
	public void testGetCliente() {
		assertEquals("12345678A", c2.getCliente().getDni());
	}
	@Test
	public void testSetCliente() {
		c1.setCliente(new Cliente("David", "Herrero", "02-02-2000", "23423423B", "davidherrero@opendeusto.es", null));
		assertEquals("23423423B", c1.getCliente().getDni());
	}
	@Test
	public void testGetMatricula() {
		assertEquals("123AAA", c2.getMatricula());
	}
	@Test
	public void testSetMatricula() {
		c1.setMatricula("567JJJ");
		assertEquals("567JJJ", c1.getMatricula());
	}
	@Test
	public void testGetFecha() {
		assertEquals("27-04-2022", c2.getFecha());
	}
	@Test
	public void testSetFecha() {
		c1.setFecha("20-04-2022");
		assertEquals("20-04-2022", c1.getFecha());
	}
	@Test
	public void testGetIdCoche() {
		assertEquals("70", c2.getId_coche());
	}
	@Test
	public void testSetIdCoche() {
		c1.setId_coche("50");
		assertEquals("50", c1.getId_coche());
	}
	
	@Test
	public void testEquals() {
		
		assertTrue(c1.equals(c1));
		
		assertFalse(c1.equals(null));
		
		assertFalse(c1.equals("Alpargata"));
		
		
		c1.setId("1");
		boolean cierto= c1.equals(c2);
		assertTrue(cierto);
		
		c1.setId("9");
		boolean falso=c1.equals(c2);
		assertFalse(falso);
	}

}
