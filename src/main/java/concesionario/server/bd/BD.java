package concesionario.server.bd;



import java.sql.Connection; 
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import concesionario.clases.Cliente;
import concesionario.clases.Coche;
import concesionario.clases.Compra;
import concesionario.clases.Extra;


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
					e.printStackTrace();
				}
			}
		}
		return resul;
	}
	public static Cliente obtenerInfoCliente(Connection con, String tipo) throws DBException {
		String sentencia = "SELECT nombre,apellido,dni,email,fecha_ncto FROM Usuario WHERE tipo = '"+tipo+"'";
		Statement st = null;
		Cliente cliente= new Cliente();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			if(rs.next()) {
				cliente=new Cliente(rs.getString("nombre"), rs.getString("apellido"), rs.getString("fecha_ncto"), rs.getString("dni"), rs.getString("email"), null);
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
					e.printStackTrace();
				}
			}
		}
		return cliente;
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
		String sentencia = "SELECT contrasenya FROM usuario WHERE usuario = '"+usuario+"' AND tipo = 'administrador'";
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
		String sentencia1 = "CREATE TABLE IF NOT EXISTS Usuario (email String, contrasenya String, nombre String, apellido String, dni String, fecha_ncto String, tipo String)";
		String sentencia2 = "CREATE TABLE IF NOT EXISTS Administrador (usuario String, contrasenya String)";
		String sentencia3 = "CREATE TABLE IF NOT EXISTS Compra (ID String, usuario String, matricula String, fecha String)";
		String sentencia4 = "CREATE TABLE IF NOT EXISTS Coche(matricula String , marca String ,modelo String, color String, precio double)";
		

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
					e.printStackTrace();
				}
			}
		}
		
	}
	
	public static void insertarUsuario(Connection con, String email, String contra, String nombre, String apellido, String dni, String fecha_ncto, String tipo) throws DBException {
		
		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO usuario (email, contrasenya , nombre , apellido , dni , fecha_ncto, tipo) VALUES (?,?,?,?,?,?,?)"); 
				Statement stmtForId = con.createStatement()) {
				
				stmt.setString(1, email);
				stmt.setString(2, contra);
				stmt.setString(3, nombre);
				stmt.setString(4, apellido);
				stmt.setString(5, dni);
				stmt.setString(6, fecha_ncto);
				stmt.setString(7, tipo);
		
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
	
		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO usuario (usuario, contrasenya) VALUES (?,?)"); 
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
					e.printStackTrace();
					
				}
			}
		}
	}
	public static boolean existeDni(Connection con, String dni) throws SQLException {
			
			String sent = "select * from Usuario where dni='"+dni+"'";
			Statement st = null;
			st = con.createStatement();
	
			ResultSet rs = st.executeQuery(sent);
			boolean existe = false;
			if(rs.next())
				existe = true;
			rs.close();
			return existe;
		}

	public static ArrayList<Coche> listaCoches(Connection con, String marca) throws SQLException {
		
		String sent = "select * from coche where marca='"+ marca +"'";
		Statement st = null;
		st = con.createStatement();
		
		ArrayList<Coche> listaCoches = new ArrayList<Coche>();
		Coche coche = null;
		ResultSet rs = st.executeQuery(sent);
		
		while(rs.next()) {
			coche = new Coche(rs.getString(1), "", rs.getString(4), rs.getString(2), rs.getString(3),rs.getDouble(5), rs.getString(6),rs.getString(7),rs.getString(8), new ArrayList<Extra>());
			listaCoches.add(coche);
		}
		rs.close();
		return listaCoches;
	}
	
	public static boolean existeEmail(Connection con, String email) throws SQLException {
		
		String sent = "select * from Usuario where email='"+email+"'";
		Statement st = null;
		st = con.createStatement();
	
		ResultSet rs = st.executeQuery(sent);
		boolean existe = false;
		if(rs.next())
			existe = true;
		rs.close();
		return existe;
	}
	
	/**
     * Obtiene el numero de ticket mas alto que haya en la BBDD.Se usa para calcular en otro metodo el numero siguiente, y autoincrementarlo de forma manual
     * @param Connection con
     * @return int ultimoTicketNum 
     */
    public static int getSiguienteIdCompra(Connection con) {
        String sent = "select MAX(ID) from Compra";
        Statement st = null;
        int ultimoIDCompra=0;
        try {
            st = con.createStatement();
            ResultSet rs=st.executeQuery(sent);

            if (rs.next()) {
            	ultimoIDCompra=rs.getInt(1);
            	ultimoIDCompra++;
            }
        } catch (SQLException e) { 
            e.printStackTrace();
        }
        return ultimoIDCompra;


    }
    
    public static String getUltimaMatricula(Connection con) {
    	int id = BD.getSiguienteIdCompra(con);
    	int id_old = id -1; 
    	String matricula = "";
    	String sent = "select matricula from Compra where id = " + id_old;
    	Statement st = null;
    	 try {
             st = con.createStatement();
             ResultSet rs=st.executeQuery(sent);
             if (rs.next()) {
            	 matricula = rs.getString(1);
             }
    	 } catch (SQLException e) { 
             e.printStackTrace();
         }

         return matricula;
    }

    public static ArrayList<Compra> obtenerListaCompras(Connection con) throws DBException {
		String sentencia = "SELECT * FROM compra";
		Statement st = null;
		ArrayList<Compra> compras=new ArrayList<Compra>();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			while(rs.next()) {
				compras.add(new Compra(rs.getString("ID"),obtenerInfoCliente(con, rs.getString("usuario")),rs.getString("matricula"),rs.getString("fecha"),rs.getString("id_coche")));
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
					e.printStackTrace();
				}
			}
		}
		return compras;
	}
	
public static void insertarCompra(Connection con, Compra compra) throws DBException {
		
		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO Compra (ID, usuario, matricula, fecha, id_coche) VALUES (?,?,?,?,?)"); 
				Statement stmtForId = con.createStatement()) {
				
				stmt.setString(1, compra.getId());
				stmt.setString(2, compra.getCliente().getEmail());
				stmt.setString(3, compra.getMatricula());
				stmt.setString(4, compra.getFecha());
				stmt.setString(5, compra.getId_coche());
		
		
				stmt.executeUpdate();
				stmt.close();
				 
			} catch (SQLException e) {
			
			e.printStackTrace();
			throw new DBException("No se ha podido insertar la compra");
		} finally {
			if(con!=null) {
				try {
					con.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}
    
}