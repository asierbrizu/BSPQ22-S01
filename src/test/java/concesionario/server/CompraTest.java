package concesionario.server;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.util.ArrayList;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import org.junit.Before;
import org.junit.Test;

import concesionario.clases.Cliente;
import concesionario.clases.Coche;
import concesionario.clases.Compra;
import concesionario.clases.Extra;
import concesionario.client.VentanaInicio;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;
import concesionario.util.CompraException;

public class CompraTest {

	BD bd;
	Client client;
	WebTarget webTarget;
	Coche coche;
	Connection con =null;
	VentanaInicio inicio;

	@Before
	public void setUp() {
		bd=new BD();
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest", "127.0.0.1", 8080));
		coche=new Coche("2", "111AAA", "Rojo", "Ferrari", "123", 1000.0, "ferrar-123.png", "Electrico", "instr-Ferrari-123.pdf", new ArrayList<Extra>());
		try {
			con = bd.initBD("bd_bspq");
		} catch (DBException e) {
			e.printStackTrace();
		}

	}
	/*
	@Test
	public void testRealizarCompra() {
		inicio=new VentanaInicio();
		VentanaInicio.clienteActual=new Cliente("Asier", "Brizuela", "01-01-2000", "12345678A", "asier@deusto.es", "");
		try {
			VentanaInicio.comprarCoche(coche);
		} catch (CompraException e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void testListaCompras() {
		ArrayList<Compra> compras=new ArrayList<>();
		try {
			compras = BD.obtenerListaCompras();
		} catch (DBException e) {
			e.printStackTrace();
		}
		assertNotEquals(compras.size(), 0);
	}
	*/

}
