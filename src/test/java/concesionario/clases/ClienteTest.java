package concesionario.clases;
import static org.junit.Assert.*;

import org.junit.Test;

import concesionario.clases.Cliente;

public class ClienteTest {
	
	Cliente c1=new Cliente("Jon","Fernandez", "01-01-2000","1111111A","j@gmail.com");
	Cliente c2= new Cliente();

	@Test
	public void testGetNombre() {
		assertEquals("Jon", c1.getNombre());
	}
	
	@Test
	public void testGetApellido() {
		assertEquals("Fernandez", c1.getApellido());
	}
	
	@Test
	public void testGetFechaNacimiento() {
		assertEquals("01-01-2000", c1.getFechaNacimiento());
	}
	
	@Test
	public void testGetDni() {
		assertEquals("1111111A", c1.getDni());
	}
	
	@Test
	public void testGetEmail() {
		assertEquals("j@gmail.com", c1.getEmail());
	}
	
	@Test
	public void testSetNombre() {
		c2.setNombre("Ander");
		assertEquals("Ander", c2.getNombre());
	}
	
	@Test
	public void testSetApellido() {
		c2.setApellido("Garcia");
		assertEquals("Garcia", c2.getApellido());
	}
	
	@Test
	public void testSetFechaNacimiento() {
		c2.setFechaNacimiento("12-12-2012");
		assertEquals("12-12-2012", c2.getFechaNacimiento());
	}
	
	@Test
	public void testSetDni() {
		c2.setDni("2222222B");
		assertEquals("2222222B", c2.getDni());
	}
	
	@Test
	public void testSetEmail() {
		c2.setEmail("b@gmail.com");
		assertEquals("b@gmail.com", c2.getEmail());
	}
	
	@Test
	public void testEquals() {
		
		assertTrue(c1.equals(c1));
		
		assertFalse(c1.equals(null));
		
		assertFalse(c1.equals("Alpargata"));
		
		c2.setDni("1111111A");
		boolean cierto= c1.equals(c2);
		assertTrue(cierto);
		
		c2.setDni("9999999Z");
		boolean falso=c1.equals(c2);
		assertFalse(falso);
	}
	
	

}
