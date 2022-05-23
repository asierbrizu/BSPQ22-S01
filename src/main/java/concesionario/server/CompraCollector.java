package concesionario.server;

import java.sql.Connection;
import java.util.ArrayList;

import concesionario.clases.Compra;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

public class CompraCollector {
	public BD bd;
	private ArrayList<Compra> compras=inicializarCompras();
	
	/**
	 * Metodo inicializa la compra
	 * @return Lista de compras 
	 */
	private ArrayList<Compra> inicializarCompras(){
		bd = new BD();
		Connection con = null;
		try {
			con = bd.initBD("bd_bspq");
			compras=bd.obtenerListaCompras(con);
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		
		return compras;
	}
	
	/**
	 * Metodo para obtener la compra
	 * @return La lista de compras 
	 */
	public ArrayList<Compra> getCompras() {
		synchronized(this) {
			return compras;
		}
	}
    
	/**
	 * Metodo para comprar un coche
	 * @param Compra compra
	 */
	public void comprarCoche(Compra compra) {
        synchronized(this) {
            //Cosas para comprar coche
        	Connection con = null;
    		try {
    			con = bd.initBD("bd_bspq");
    			bd.insertarCompra(con,compra);
            	compras.add(compra);
    		} catch (DBException e1) {
    			e1.printStackTrace();
    		}
        }
    }

}
   
    
    

   
