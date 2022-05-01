package concesionario.clases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import concesionario.client.VentanaCoche;

public class VentanaCocheTest {

	VentanaCoche v1 = new VentanaCoche("", "", "Tesla");
	
	@Test
	public void getListaCoches() {
		ArrayList<Coche> coches = v1.listaCoches("Tesla");
		assertEquals(22, coches.get(0).getIdCoche());
		assertEquals(23, coches.get(1).getIdCoche());
		assertEquals(24, coches.get(2).getIdCoche());
	}
	

}
