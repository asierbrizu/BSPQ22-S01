package concesionario.server.bd;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BD {
	
	/**
	 * Método que crea la conexion con la BBD
	 * @param String nombreBD El nombre de la BBDD
	 * @return El objeto Conexión con
	 * @throws DBException 
	 */
	public static Connection initBD(String nombreBD) throws DBException {
		Connection con = null;
		try {
			Class.forName("org.sqlite.JDBC");
			con = DriverManager.getConnection("jdbc:sqlite:"+nombreBD);
			
					
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return con;
	}
	/**
	 * Método que cierra la conexion con la BBDD
	 * @param con Objeto Connection
	 * @throws DBException 
	 */
	public static void closeBD(Connection con) throws DBException {
		if(con!=null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
				throw new DBException("No se pudo desconectar correctamente de la base de datos", e);
				
			}
		}
	}


	
	/**
	 * Método que recibe los datos de un Azafato y comprueba que est� registrado en la BBDD
	 * @param String usuario Nombre de usuario del azafato
	 * @param String contra contrasenia del azafato
	 * @return 0 si el nombre de usuario del azafato no esta registrado
	 * 		   1 si el nombre de usuario del azafato esta  registrado pero la contrasenia no es correcta
	 * 		   2 si el nombre de usuario del azafato esta  registrado y la contrasenia es correcta
	 * @throws DBException 
	 */
	public static int obtenerUsuario(Connection con, String usuario, String contra) throws DBException {
		String sentencia = "SELECT contrasenya FROM Usuario WHERE email = '"+usuario+"'";
		Statement st = null;
		int resul = 0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) {
				if(rs.getString("contrasenya").equals(contra)) {
					resul = 2;
				}else {
					resul = 1;
				}
			}
			rs.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("No se ha podido comprobar si existe el usuario");
			
		} finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resul;
	}
	
	
	/**
	 * Método que recibe los datos de un Administrador y comprueba que est� registrado en la BBDD
	 * @param String usuario Nombre de usuario del administrador
	 * @param String contra contrasenia del administrador
	 * @return 0 si el administrador no esta registrado
	 * 		   1 si el administrador esta registrado pero la contrasenia no es correcta
	 * 		   2 si el administrador esta  registrado y la contrasenia es correcta
	 * @throws DBException 
	 */
	public static int obtenerAdministrador(Connection con, String usuario, String contra) throws DBException {
		String sentencia = "SELECT contrasenya FROM Administrador WHERE usuario = '"+usuario+"'";
		Statement st = null;
		int resul = 0;
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			//Si la sentencia nos ha devuelto al menos un valor, rs estar� apuntando a una tupla
			if(rs.next()) {
				if(rs.getString("contrasenya").equals(contra)) {
					resul = 2;
				}else {
					resul = 1;
				}
			}
			rs.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("No se ha podido comprobar si existe el administrador");

		} finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return resul;
	}
	
	/**
	 * Método que crea las tablas en la BBDD si no existen
	 * @param Connection con
	 * @throws DBException
	 */
	public static void crearTablas(Connection con) throws DBException {
		String sentencia1 = "CREATE TABLE IF NOT EXISTS Usuario (email String, contrasenya String, nombre String, apellido String, dni String, fecha_ncto String)";
		String sentencia2 = "CREATE TABLE IF NOT EXISTS Administrador (usuario String, contrasenya String)";
		String sentencia3 = "CREATE TABLE IF NOT EXISTS Compra (ID String, usuario String, matricula String, fecha String)";
		String sentencia4 = "CREATE TABLE IF NOT EXISTS Coche(matricula String , marca String ,modelo String, color String, precio doubñe)";
		

		Statement st = null;
		try {
			st = con.createStatement();
			st.executeUpdate(sentencia1);
			st.executeUpdate(sentencia2);
			st.executeUpdate(sentencia3);
			st.executeUpdate(sentencia4);
			
			
		
			st.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("No se han podido crear las tablas", e);
			
	
		} finally {
			if(st!=null) {
				try {
					st.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	
	
	public static void insertarUsuario(Connection con, String email, String contra, String nombre, String apellido, String dni, String fecha_ncto ) throws DBException {
		
		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO Usuario (email, contrasenya , nombre , apellido , dni , fecha_ncto) VALUES (?,?,?,?,?,?)"); 
				Statement stmtForId = con.createStatement()) {
				
				stmt.setString(1, email);
				stmt.setString(2, contra);
				stmt.setString(3, nombre);
				stmt.setString(4, apellido);
				stmt.setString(5, dni);
				stmt.setString(6, fecha_ncto);

		
				stmt.executeUpdate();
				stmt.close();
				 
			} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("No se ha podido insertar el usuario");
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	

	
	/**
	 * Metodo que inserta los datos de un Administrador (si no esta  repetido) en la BBDD 
	 * @param Connection con Conexión con la BBDD
	 * @param String usuario Nombre de usuario del administrador
	 * @param String contra Contraseña del administrador
	 * @throws DBException 
	 */
	public static void insertarAdministrador(Connection con, String usuario, String contra) throws DBException {
	
		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO Administrador (usuario, contrasenya) VALUES (?,?)"); 
				Statement stmtForId = con.createStatement()) {
				
				stmt.setString(1, usuario);
				stmt.setString(2, contra);
				
			 stmt.executeUpdate();
			stmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
			throw new DBException("No se ha podido insertar el administrador en la BBDD");
			
			
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					
				}
			}
		}
	}
	

	
	
}