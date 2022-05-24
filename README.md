**Concesionario ADAIA**
=======================

![java ci workflow](https://github.com/asierbrizu/BSPQ22-S01/actions/workflows/java-ci.yml/badge.svg)
 [![codecov](https://codecov.io/gh/ikermorales/BSPQ22-S01/branch/main/graph/badge.svg)](https://codecov.io/gh/ikermorales/BSPQ22-S01)

Compilar el proyecto
--------------------

Esto compila el programa usando maven.

	mvn compile 

Ejecutar la aplicación
----------------------

No es necesario si no vas a ejecutar el cliente, pero es indispensable para ejecutar el servidor de Jersey.
	
	mvn jetty:run 

Sirve para ejecutar el lado servidor, que muestra la ventana donde aparecen las ventas de coches.

	mvn exec:java -Pmanager

Sirve para ejecutar el lado cliente; las ventanas para iniciar sesión,registrarse como nuevo usuario, y comprar coches.	

	mvn exec:java -Pclient
