package concesionario.server.bd;

/**
 * Representa un error en la base de datos
 *
 */
public class DBException extends Exception {
	
	private String mensaje;
	
	/**
	 * Construye la excepcion con le mensaje indicado
	 * @param message mensaje contenido en la excepci�n
	 */
	public DBException(String message) throws DBException{
		super(message);
		mensaje = message;
	}

	/**
	 * Construye la excepcion con el mensaje y la excepcion
	 * interna anidada.
	 * @param message mensaje de la excepcion
	 * @param t excepcion interna anidada
	 */
	public DBException(String message, Throwable t) throws DBException{
		super(message, t);
		mensaje = message;
	}
	
	public String toString(){
		return mensaje;
	}
}

