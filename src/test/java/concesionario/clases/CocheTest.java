package concesionario.clases;
import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import concesionario.clases.Coche;
import concesionario.clases.Extra;

public class CocheTest {

	
	ArrayList<Extra> extras = new ArrayList<Extra>();
	
	ArrayList<Extra> extras2 = new ArrayList<Extra>();
	
	Coche c1=new Coche("1", "A","Rojo", "Renault","Scenic 12", 20199.99f,"imagen","combustible1","instrucciones1", extras);
	Coche c2=new Coche();

	@Test
	public void testGetIdCoche() {
		assertEquals("1", c1.getIdCoche());
	}
	
	@Test
	public void testGetMatricula() {
		assertEquals("A", c1.getMatricula());
	}
	
	@Test
	public void testGetColor() {
		assertEquals("Rojo", c1.getColor());
	}
	
	@Test
	public void testGetMarca() {
		assertEquals("Renault", c1.getMarca());
	}
	
	@Test
	public void testGetModelo() {
		assertEquals("Scenic 12", c1.getModelo());
	}
	
	@Test
	public void testGetPreciobase() {
		assertEquals(20199.99f, c1.getPrecioBase(), 0.00f);
	}
	
	@Test
	public void testGetImagen() {
		assertEquals("imagen", c1.getImagen());
	}

	@Test
	public void testGetExtras() {
		assertEquals(extras, c1.getExtras());
	}
	
	@Test
	public void testGetCombustible() {
		assertEquals("combustible1", c1.getCombustible());
	}
	
	@Test
	public void testGetInstrucciones() {
		assertEquals("instrucciones1", c1.getInstrucciones());
	}
	
	//setters
	@Test
	public void testSetMatricula() {
		c2.setMatricula("b");
		assertEquals("b", c2.getMatricula());
	}
	
	@Test
	public void testSetColor() {
		c2.setColor("Azul");
		assertEquals("Azul", c2.getColor());
	}
	
	@Test
	public void testSetMarca() {
		c2.setMarca("BMW");
		assertEquals("BMW", c2.getMarca());
	}
	
	@Test
	public void testSetModelo() {
		c2.setModelo("BM1");
		assertEquals("BM1", c2.getModelo());
	}
	
	@Test
	public void testSetPreciobase() {
		c2.setPrecioBase(999.99f);
		assertEquals(999.99f, c2.getPrecioBase(), 0.00f);
	}
	
	@Test
	public void testSetImagen() {
		c2.setImagen("i");
		assertEquals("i", c2.getImagen());
	}

	@Test
	public void testSetExtras() {
		c2.setExtras(extras2);
		assertEquals(extras2, c2.getExtras());
	}
	
	@Test
	public void testSetIdCoche() {
		c2.setIdCoche("id2");
		assertEquals("id2", c2.getIdCoche());
	}
	
	@Test
	public void testSetCombustible() {
		c2.setCombustible("combustible2");
		assertEquals("combustible2", c2.getCombustible());
	}
	
	@Test
	public void testSetInstrucciones() {
		c2.setInstrucciones("instrucciones2");
		assertEquals("instrucciones2", c2.getInstrucciones());
	}

	@Test
	public void testEquals() {
		
		assertTrue(c1.equals(c1));
		
		assertFalse(c1.equals(null));
		
		assertFalse(c1.equals("Alpargata"));
		
		c2.setMatricula("A");
		boolean cierto= c1.equals(c2);
		assertTrue(cierto);
		
		c2.setMatricula("Z");
		boolean falso=c1.equals(c2);
		assertFalse(falso);
	}
	
	




}
