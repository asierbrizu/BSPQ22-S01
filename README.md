Para ejecutar el programa, los pasos son los siguientes:
1. mvn compile 
Este compila el programa usando maven.


1. mvn jetty:run 
No es necesario si no vas a ejecutar el cliente, pero es indispensable para ejecutar el servidor de Jersey.
2. mvn exec:java -Pmanager
Sirve para ejecutar el lado servidor, que muestra la ventana donde aparecen las ventas de coches.
3. mvn exec:java -Pclient
Sirve para ejecutar el lado cliente; las ventanas para iniciar sesión,registrarse como nuevo usuario, y comprar coches.