package concesionario.server;

import concesionario.clases.Compra;

public class CompraCollector {

    public void comprarCoche(Compra compra) {
        synchronized(this) {
            //Cosas para comprar coche
        }
    }

}