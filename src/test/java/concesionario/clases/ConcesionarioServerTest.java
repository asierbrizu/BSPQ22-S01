package concesionario.clases;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import concesionario.server.ConcesionarioServer;
import concesionario.server.CompraCollector;
import concesionario.server.bd.BD;

import org.junit.Test;

public class ConcesionarioServerTest {

	private CompraCollector compraCollector;
	ConcesionarioServer c = new ConcesionarioServer();
	Compra c1 = new Compra("1", new Cliente("Asier", "Martinez", "31-12-2000", "12345678A", "pato@gmail.com"), "5143LMV", "01-05-2022", "70");
	
	@Test
	public void concesionarioServerTest() {
	}
	
	@Test
	public void comprarCocheTest() {
		c.comprarCoche(c1);
	}
	
	@Test
	public void getComprasTest() {
		c.getCompras();
	}

}
