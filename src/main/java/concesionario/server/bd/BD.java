package concesionario.server.bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import concesionario.clases.Cliente;
import concesionario.clases.Coche;
import concesionario.clases.Compra;
import concesionario.clases.Extra;

public class BD {

	private static Connection con;

	/**
	 * Metodo que crea la conexion con la BBD
	 * @param String nombreBD El nombre de la BBDD
	 * @return El objeto Conexión con
	 * @throws DBException 
	 */
	public Connection initBD(String nombreBD) throws DBException {
		con = null;
		try {

			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/"+nombreBD, "root", "root");


		} catch (ClassNotFoundException e) {

			e.printStackTrace();
			throw new DBException("No se pudo cargar el driver de la base de datos", e);
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return con;
	}

	/**
	 * Metodo que cierra la conexion con la BBDD
	 * @param con Objeto Connection
	 * @throws DBException 
	 */
	public static void closeBD() throws DBException {
		if(con!=null) {
			try {
				//				con.close();
			} catch (Exception e) {
				e.printStackTrace();
				throw new DBException("No se pudo desconectar correctamente de la base de datos", e);

			}
		}
	}

	/**
	 * Metodo que obtiene un usuario de la BD
	 * @param Connection con, String usuario, String contra (la conexion, el email del usuario y la contraseña)
	 * @return integer, 2 si coincide la contraseña, 1 si no coincide
	 * @throws DBException 
	 */
	public static int obtenerUsuario(String usuario, String contra) throws DBException {
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

	/**
	 * Metodo que obtiene la informacion del cliente
	 * @param Connection con, String tipo (la conexion y el tipo de cliente)
	 * @return El cliente
	 * @throws DBException 
	 */
	public static Cliente obtenerInfoCliente(String tipo) throws DBException {
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
	 * Metodo que crea las tablas de la BD
	 * @param Connection con (la conexion con la BD)
	 * @throws DBException 
	 */
	public static void crearTablas() throws DBException {
		String sentencia1 = "CREATE TABLE IF NOT EXISTS Usuario (email VARCHAR(100) PRIMARY KEY, contrasenya VARCHAR(100) DEFAULT NULL, nombre VARCHAR(100), apellido VARCHAR(100), dni VARCHAR(9), fecha_ncto VARCHAR(10), tipo VARCHAR(60));";
		String sentencia2 = "CREATE TABLE IF NOT EXISTS Compra (id int (11) AUTO_INCREMENT PRIMARY KEY, usuario VARCHAR(100), matricula VARCHAR(7), fecha VARCHAR(40), id_coche VARCHAR(10));";
		String sentencia3 = "CREATE TABLE IF NOT EXISTS Coche (id int (11) AUTO_INCREMENT PRIMARY KEY, marca VARCHAR(100), modelo VARCHAR(100), color VARCHAR(100), precio VARCHAR(100), imagen VARCHAR(100), Combustible VARCHAR(100), Instrucciones VARCHAR(100));";


		Statement st = null;
		try {
			st = con.createStatement();
			st.executeUpdate(sentencia1);
			st.executeUpdate(sentencia2);
			st.executeUpdate(sentencia3);			

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

	/**
	 * Metodo que inserta usuarios en la BD
	 * @param Connection con, String email, String contra, String nombre, String apellido, String dni, String fecha_ncto, String tipo (la conexion para la BD y los datos del usuario)
	 * @throws DBException 
	 */
	public static void insertarUsuario(String email, String contra, String nombre, String apellido, String dni, String fecha_ncto, String tipo) throws DBException {

		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO Usuario (email, contrasenya, nombre, apellido, dni, fecha_ncto, tipo) VALUES (?,?,?,?,?,?,?)"); 
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
					//					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Metodo que inserta un administrador a la BD
	 * @param Connection con, String usuario, String contra (la conexion, el usuario y la contraseña)
	 * @return El cliente
	 * @throws DBException 
	 */
	public static void insertarAdministrador(String usuario, String contra) throws DBException {

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
					//					con.close();
				} catch (Exception e) {
					e.printStackTrace();

				}
			}
		}
	}

	/**
	 * Metodo que compueba si existe una persona con el dni
	 * @param Connection con, String dni (la conexion y el dni)
	 * @return true si exite, false si no existe
	 * @throws SQLException 
	 */
	public boolean existeDni(String dni) throws SQLException {

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

	/**
	 * Metodo que obtiene la lista de coches
	 * @param Connection con, String marca (la conexion y la marca del coche)
	 * @return Un array con los coches
	 * @throws SQLException 
	 */
	public static ArrayList<Coche> listaCoches(String marca) throws SQLException {

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

	/**
	 * Metodo que comprueba si exite un email
	 * @param Connection con, String email (la conexion y el email)
	 * @return true si exite, false si no existe
	 * @throws SQLException 
	 */
	public boolean existeEmail(String email) throws SQLException {

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
	 * Metodo que obtiene la siguiente compra
	 * @param Connection con(la conexion)
	 * @return El id de la compra
	 */
	public static int getSiguienteIdCompra() {
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

	/**
	 * Metodo que obtiene la ultima matricula
	 * @param Connection con (la conexion)
	 * @return La matricula
	 */
	public String getUltimaMatricula() {
		int id = BD.getSiguienteIdCompra();
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

	/**
	 * Metodo que obtiene la lista de las compras
	 * @param Connection con (la conexion)
	 * @return Lista de compras
	 * @throws DBException 
	 */
	public static ArrayList<Compra> obtenerListaCompras() throws DBException {
		String sentencia = "SELECT * FROM compra";
		Statement st = null;
		ArrayList<Compra> compras=new ArrayList<Compra>();
		try {
			st = con.createStatement();
			ResultSet rs = st.executeQuery(sentencia);
			while(rs.next()) {
				Compra c = new Compra();
				c.setId(rs.getString("ID"));
				c.setCliente(rs.getString("usuario"));
				c.setFecha(rs.getString("fecha"));
				c.setMatricula(rs.getString("matricula"));
				c.setId_coche(rs.getString("id_coche"));
				compras.add(c);
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


	/**
	 * Metodo que inserta una compra
	 * @param Connection con, Compra compra (la conexion y la compra)
	 * @throws DBException 
	 */
	public static void insertarCompra(Compra compra) throws DBException {

		try (PreparedStatement stmt = con.prepareStatement("INSERT INTO Compra (usuario, matricula, fecha, id_coche) VALUES (?,?,?,?)"); 
				Statement stmtForId = con.createStatement()) {

			stmt.setString(1, compra.getCliente());
			stmt.setString(2, compra.getMatricula());
			stmt.setString(3, compra.getFecha());
			stmt.setString(4, compra.getId_coche());


			stmt.executeUpdate();
			stmt.close();

		} catch (SQLException e) {

			e.printStackTrace();
			throw new DBException("No se ha podido insertar la compra");
		} finally {
			if(con!=null) {
				try {
					//					con.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
	}

	/**
	 * Metodo que obtiene un cliente
	 * @param Connection con, String usuario, String contra (la conexion, el cliente y la contraseña)
	 * @return El cliente
	 */
	public static Cliente getCliente(String usuario, String contra) {
		Cliente resultado = null;
		String nombre;
		String apellido;
		String email;
		String contrasenya;
		String fecha;
		String dni;
		String tipo;

		try {
			if(obtenerUsuario(usuario, contra) == 2) {
				resultado = new Cliente();

				String sent = "select * from usuario where email = '" + usuario + "' AND contrasenya = '" + contra + "';";

				Statement st = null;
				try {
					st = con.createStatement();
					ResultSet rs=st.executeQuery(sent);
					if (rs.next()) {
						email = rs.getString(1);
						contrasenya = rs.getString(2);
						nombre = rs.getString(3);
						apellido = rs.getString(4);
						dni = rs.getString(5);
						fecha = rs.getString(6);
						tipo = rs.getString(7);

						resultado.setApellido(apellido);
						resultado.setDni(dni);
						resultado.setEmail(email);
						resultado.setFechaNacimiento(sent);
						resultado.setNombre(nombre);
						resultado.setTipo(tipo);

					}
				} catch (SQLException e) { 
					e.printStackTrace();
				}
			}
		} catch (DBException e) {

		}
		return resultado;
	}

	/**
	 * Metodo que obtiene los empleados
	 * @param Connection con (la conexion)
	 * @return Lista de empleados (de tipo Cliente)
	 */
	public static ArrayList<Cliente> getEmpleados(){
		ArrayList<Cliente> empleados = new ArrayList<>();

		String sent = "select * from usuario;";
		Statement st = null;
		try {
			st = con.createStatement();
			ResultSet rs=st.executeQuery(sent);
			while (rs.next()) {
//				JOptionPane.showMessageDialog(null, rs.getString(1));
				if(rs.getString(7).matches("empleado")) {

					Cliente temp = new Cliente();
					String nombre;
					String apellido;
					String email;
					String contrasenya;
					String fecha;
					String dni;
					String tipo;

					email = rs.getString(1);
					contrasenya = rs.getString(2);
					nombre = rs.getString(3);
					apellido = rs.getString(4);
					dni = rs.getString(5);
					fecha = rs.getString(6);
					tipo = rs.getString(7);

					temp.setApellido(apellido);
					temp.setDni(dni);
					temp.setEmail(email);
					temp.setFechaNacimiento(sent);
					temp.setNombre(nombre);
					temp.setTipo(tipo);
					
					empleados.add(temp);
				}
			}
		}catch (Exception e) {
			e.printStackTrace();
		}


		return empleados;
	}


}

