import static org.junit.Assert.*;

import org.junit.Test;

import concesionario.clases.Extra;

public class ExtraTest {

	Extra e1=new Extra("GPS","Geolocalizador integrado", 80.0f);
	Extra e2=new Extra();
	
	
	
	@Test
	public void testGetNombre() {
		assertEquals("GPS", e1.getNombre());
	}
	
	@Test
	public void testGetDescripcion() {
		assertEquals("Geolocalizador integrado", e1.getDescripcion());
	}
	
	@Test
	public void testGetPrecio() {
		assertEquals(80.0f, e1.getPrecio(),0.00f);
	}
	
	
	
	
	
	
	
	@Test
	public void testSetNombre() {
		e2.setNombre("a");
		assertEquals("a", e2.getNombre());
	}
	
	@Test
	public void testSetDescripcion() {
		e2.setDescripcion("Descripcion");
		assertEquals("Descripcion", e2.getDescripcion());
	}
	
	@Test
	public void testSetPrecio() {
		e2.setPrecio(1.5f);
		assertEquals(1.5f, e2.getPrecio(),0.00f);
	}

}
