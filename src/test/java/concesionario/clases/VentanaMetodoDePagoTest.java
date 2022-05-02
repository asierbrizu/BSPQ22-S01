package concesionario.clases;

import static org.junit.Assert.*;

import org.junit.Test;

import concesionario.client.VentanaMetodoDePago;

public class VentanaMetodoDePagoTest {

	@Test
	public void test() {
		try {
			VentanaMetodoDePago pago = new VentanaMetodoDePago(new Coche("1", "A","Rojo", "Renault","Scenic 12", 20199.99f,"imagen","combustible1","instrucciones1", null));
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
