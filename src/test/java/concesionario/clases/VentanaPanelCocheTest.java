package concesionario.clases;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import concesionario.client.VentanaAdministrador;
import concesionario.client.VentanaPanelCoche;

public class VentanaPanelCocheTest {
	
	@Test
	public void VentanaPanelCocheTest() {
		try {
			Coche c1 = new Coche("1","3333MMM","Negro","Tesla","S",1999.3,"","Diesel","",null);
			Coche c2 = new Coche("2","222MMM","Negro","Tesla","S",1999.3,"","Diesel","",null);
			Coche c3 = new Coche("3","1111MMM","Negro","Tesla","S",1999.3,"","Diesel","",null);
			ArrayList<Coche> array = new ArrayList<>();
			array.add(c3);
			array.add(c2);
			array.add(c1);
			VentanaPanelCoche vPC = new VentanaPanelCoche(array);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	

}
