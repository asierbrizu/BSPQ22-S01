package concesionario.clases;

import static org.junit.Assert.*;

import org.junit.Test;

import concesionario.client.VentanaCoche;
import concesionario.client.VentanaInicio;

public class VentanaCocheTest {

	@Test
	public void test() {
		try {
			VentanaCoche VC = new VentanaCoche("Telsa");
		} catch (Exception e) {
		}
	}

}