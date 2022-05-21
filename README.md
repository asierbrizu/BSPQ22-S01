**Concesionario ADAIA**
=======================

![java ci workflow](https://github.com/asierbrizu/BSPQ22-S01/actions/workflows/java-ci.yml/badge.svg)
 [![codecov](https://codecov.io/gh/ikermorales/BSPQ22-S01/branch/main/graph/badge.svg)](https://codecov.io/gh/ikermorales/BSPQ22-S01)

Compilar el proyecto
--------------------

Esto compila el programa usando maven.

	mvn compile 
	
Crear BD
--------------------	
	
Ejecutar estas sentencias para crear BD y tablas en caso de no haberlas	
	CREATE DATABASE IF NOT EXISTS bd_bspq;
	USE bd_bspq;
	CREATE TABLE IF NOT EXISTS Usuario (email VARCHAR(100) PRIMARY KEY, contrasenya VARCHAR(100) DEFAULT NULL, nombre VARCHAR(100), apellido VARCHAR(100), dni VARCHAR(9), fecha_ncto VARCHAR(10), tipo VARCHAR(60));
	CREATE TABLE IF NOT EXISTS Compra (id int (11) AUTO_INCREMENT PRIMARY KEY, usuario VARCHAR(100), matricula VARCHAR(7), fecha VARCHAR(40), id_coche VARCHAR(10));
	CREATE TABLE IF NOT EXISTS Coche (id int (11) AUTO_INCREMENT PRIMARY KEY, marca VARCHAR(100), modelo VARCHAR(100), color VARCHAR(100), precio VARCHAR(100), imagen VARCHAR(100), Combustible VARCHAR(100), Instrucciones VARCHAR(100));

Ejecutar la aplicación
----------------------

No es necesario si no vas a ejecutar el cliente, pero es indispensable para ejecutar el servidor de Jersey.
	
	mvn jetty:run 

Sirve para ejecutar el lado servidor, que muestra la ventana donde aparecen las ventas de coches.

	mvn exec:java -Pmanager

Sirve para ejecutar el lado cliente; las ventanas para iniciar sesión,registrarse como nuevo usuario, y comprar coches.	

	mvn exec:java -Pclient
