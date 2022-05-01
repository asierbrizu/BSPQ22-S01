/*package concesionario.clases;

import static org.junit.Assert.*;

import org.junit.Test;

import concesionario.server.CompraCollector;
import concesionario.server.bd.BD;

public class CompraCollectorTest {

	CompraCollector cc = new CompraCollector();
	Compra c1 = new Compra("1", new Cliente("Asier", "Martinez", "31-12-2000", "12345678A", "pato@gmail.com"), "5143LMV", "01-05-2022", "70");

	
	@Test
	public void comprarCocheTest() {
		cc.comprarCoche(c1);
		assertEquals(cc.getCompras().get(cc.getCompras().size()-1), c1);
	}
	
	@Test
	public void getComprasTest() {
		cc.comprarCoche(c1);
		assertEquals(cc.getCompras().get(cc.getCompras().size()-1).getFecha(), "01-05-2022");
		assertEquals(cc.getCompras().get(cc.getCompras().size()-1).getId(), "1");
		assertEquals(cc.getCompras().get(cc.getCompras().size()-1).getMatricula(), "5143LMV");
		assertEquals(cc.getCompras().get(cc.getCompras().size()-1).getId_coche(), "70");
		

		
	}

}
*/