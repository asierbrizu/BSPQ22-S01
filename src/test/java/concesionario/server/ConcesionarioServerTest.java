package concesionario.server;

import static org.junit.Assert.*;

import javax.ws.rs.core.Response;

import org.junit.Test;

import concesionario.clases.Cliente;
import concesionario.clases.Compra;
import concesionario.server.ConcesionarioServer;

public class ConcesionarioServerTest {

	ConcesionarioServer c = new ConcesionarioServer();
	Compra c1 = new Compra("1", "12345678A", "5143LMV", "01-05-2022", "70");

//	@Test
//	public void comprarCocheTest() {
//		c.comprarCoche(c1);
//	}
//
//	@Test
//	public void getComprasTest() {
//		c.getCompras();
//	}

}