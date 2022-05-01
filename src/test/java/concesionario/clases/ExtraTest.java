package concesionario.clases;

import static org.junit.Assert.*;

import org.junit.Test;

public class ExtraTest {

	
	Extra extra1 = new Extra("Faros led", "Faros con tecnología led.", 320.00);
	Extra extra2 = new Extra();
	//"Pintura mate", "Pintura con estilo calcáreo y polvoriento.", (float)1879.99
	@Test
	public void getNombre() {
		assertEquals(extra1.getNombre(), "Faros led");
		extra2.setNombre("Pintura mate");
		assertEquals(extra2.getNombre(), "Pintura mate");
	}
	
	@Test
	public void getDescripcion() {
		assertEquals(extra1.getDescripcion(), "Faros con tecnología led.");
		extra2.setDescripcion("Pintura con estilo calcareo y polvoriento.");
		assertEquals(extra2.getDescripcion(), "Pintura con estilo calcareo y polvoriento.");
	}
	
	@Test
	public void getPrecio() {
		assertEquals(extra1.getPrecio(), 320.00, 0);
		extra2.setPrecio(1879.99);
		assertEquals(extra2.getPrecio(), 1879.99, 0);
	}
	
	

}
