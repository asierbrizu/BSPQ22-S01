package concesionario.server;

import java.sql.Connection;
import java.util.ArrayList;

import concesionario.clases.Compra;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

	

public class CompraCollector {
	
	private ArrayList<Compra> compras=inicializarCompras();
	
	private ArrayList<Compra> inicializarCompras(){
		Connection con = null;
		try {
			con = BD.initBD("concesionario.db");
			compras=BD.obtenerListaCompras(con);
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		
		return compras;
	}
	
	public ArrayList<Compra> getCompras() {
		synchronized(this) {
			return compras;
		}
	}
    
	public void comprarCoche(Compra compra) {
        synchronized(this) {
            //Cosas para comprar coche
        	Connection con = null;
    		try {
    			con = BD.initBD("concesionario.db");
    			BD.insertarCompra(con,compra);
            	compras.add(compra);
    		} catch (DBException e1) {
    			e1.printStackTrace();
    		}
        }
    }

}
   
    
    

   
