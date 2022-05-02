package concesionario.server;

import static org.junit.Assert.*; 

import org.junit.Test;

import concesionario.client.VentanaAdministrador;
import concesionario.server.ConcesionarioManager;

public class ConcesionarioManagerTest {

	@Test
	public void test() {
		try {
			ConcesionarioManager cM = new ConcesionarioManager("127.0.0.1", "8080");
		} catch (Exception e) {
		}
	}

}