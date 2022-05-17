package concesionario.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class VentanaRegistro extends JFrame{

	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textDNI;
	private JPasswordField textPassword;
	private JPasswordField passwordField;
	private JPasswordField textAutorizacion;
	private JDateChooser dateChooser;
	
	public static String database;
	public static String milisegundos;
	public static String columnas;
	public static String imagenes;
	
    private static String fechaStr;
	private static boolean correctoNombre ,correctoApellido ,  correctoDni  ;
	private static String dni;
	private static String nom;
	private static String apellido;
	private static String correo;
	private static Connection con;


	public VentanaRegistro() {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		correctoNombre=false;
		correctoApellido=false;
		correctoDni=false;
		
		Connection con = null;
		try {
			con = BD.initBD("concesionario.db");
			
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		
			try {
				BD.crearTablas(con);
			} catch (DBException e3) {
				e3.printStackTrace();
			}
			
			
		try {
			BD.closeBD(con);
		} catch (DBException e1) {
			e1.printStackTrace();	
		}

		textNombre = new JTextField();
		textNombre.setBounds(10, 104, 281, 20);
		getContentPane().add(textNombre);
		textNombre.setColumns(10);

		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 281, 51);
		getContentPane().add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 89, 77, 14);
		getContentPane().add(lblNewLabel_1);

		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(10, 150, 281, 20);
		getContentPane().add(textApellido);

		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1.setBounds(10, 135, 77, 14);
		getContentPane().add(lblNewLabel_1_1);

		JLabel lblNewLabel_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1.setBounds(10, 227, 77, 14);
		getContentPane().add(lblNewLabel_1_1_1);

		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(10, 242, 281, 20);
		getContentPane().add(textEmail);

		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(10, 196, 281, 20);
		getContentPane().add(textDNI);

		JLabel lblNewLabel_1_2 = new JLabel("DNI");
		lblNewLabel_1_2.setBounds(10, 181, 77, 14);
		getContentPane().add(lblNewLabel_1_2);

		textPassword = new JPasswordField();
		textPassword.setBounds(10, 288, 281, 20);
		getContentPane().add(textPassword);

		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1_1.setBounds(10, 273, 184, 14);
		getContentPane().add(lblNewLabel_1_1_1_1);

		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Fecha de Nacimiento: ");
		lblNewLabel_1_1_1_1_1.setBounds(10, 319, 199, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_1);

		dateChooser = new JDateChooser();
		// HACER QUE EL TEXTFIELD DONDE APARECE LA FECHA TRAS SELECCIONARLA CON JFILECHOOSER NO SE PUEDA EDITAR
		JTextFieldDateEditor editor = (JTextFieldDateEditor) dateChooser.getDateEditor();
		editor.setEditable(false);
		// solo se puede seleccionar una fecha como minimo de hace 18 anyos
		long milisegundosHace18anios= System.currentTimeMillis()-568036800000L;
		dateChooser.setMinSelectableDate(new Date(milisegundosHace18anios));
		dateChooser.setBounds(10, 334, 281, 20);
		getContentPane().add(dateChooser);

		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Empleado: ");
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 365, 113, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_1_1);

		JCheckBox checkEmpleado = new JCheckBox("");
		checkEmpleado.setForeground(new Color(255, 140, 0));
		checkEmpleado.setBackground(Color.WHITE);
		checkEmpleado.setBounds(78, 361, 99, 23);
		getContentPane().add(checkEmpleado);

		textAutorizacion = new JPasswordField();
		textAutorizacion.setEnabled(false);
		textAutorizacion.setBounds(10, 405, 281, 20);
		getContentPane().add(textAutorizacion);

		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Autorizacion: ");
		lblNewLabel_1_1_1_1_2.setEnabled(false);
		lblNewLabel_1_1_1_1_2.setBounds(10, 390, 184, 14);
		getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		checkEmpleado.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(checkEmpleado.isSelected()) {
					textAutorizacion.setEnabled(true);
					lblNewLabel_1_1_1_1_2.setEnabled(true);
					
				} else {
					textAutorizacion.setEnabled(false);
					lblNewLabel_1_1_1_1_2.setEnabled(false);
				}
				
			}
		});

		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(10, 451, 135, 30);
		getContentPane().add(btnCancelar);

		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(new Color(255, 127, 80));
		btnRegistrar.setBounds(156, 451, 135, 30);
		getContentPane().add(btnRegistrar);
		setBounds(100, 100, 313, 528);
		btnRegistrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correo=textEmail.getText();
				dni=textDNI.getText();
				boolean d= existeDni(dni);
				boolean m= existeEmail(correo);
				if( !d && !m ) {
					java.util.Date fecha=dateChooser.getDate();
	        		if (!(fecha == null)) {
	        			
	        			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	            		fechaStr = sdf.format(fecha);
	           
					}else {
						fechaStr="01-01-1970";
					}
					Connection con = null;
					try {
						con = BD.initBD("concesionario.db");
						
					} catch (DBException e1) {
						e1.printStackTrace();
					}
					try {
						if(checkEmpleado.isSelected() && textAutorizacion.getText().matches("adaiaADMIN_2022")) {
						BD.insertarUsuario(con, textEmail.getText(), textPassword.getText(), textNombre.getText(), textApellido.getText(), textDNI.getText(), fechaStr, "empleado");
						System.out.println("e");
						} else if(!checkEmpleado.isSelected()){
						BD.insertarUsuario(con, textEmail.getText(), textPassword.getText(), textNombre.getText(), textApellido.getText(), textDNI.getText(), fechaStr, "cliente");
						System.out.println("u");
						}
					} catch (DBException e1) {
						e1.printStackTrace();
					}
					try {
						System.out.println("6");
						BD.closeBD(con);
					} catch (DBException e1) {
						e1.printStackTrace();	
					}
					dispose();
					try {
						VentanaInicio.clienteActual=BD.obtenerInfoCliente(con, correo);
					} catch (DBException e1) {
						e1.printStackTrace();
					}
					new VentanaAdministrador();

				}else {
					JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos", "Error", JOptionPane.WARNING_MESSAGE);

				}	
				

			}
		});
		
		
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
	}


	public static boolean existeEmail(String correo) {
		try {
			con = BD.initBD("concesionario.db");
		} catch (DBException e1) {
			e1.printStackTrace();
		}

		boolean existeEmail1 = false;
		try {
			existeEmail1 = BD.existeEmail(con, correo);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			BD.closeBD(con);
		} catch (DBException e2) {
			e2.printStackTrace();
		}
		return existeEmail1;
	}

	public static boolean existeDni(String dni) {
		try {
			con = BD.initBD("concesionario.db");
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		boolean existeDni1 = false;
		try {
			existeDni1 = BD.existeDni(con, dni);
		} catch (SQLException e2) {
			e2.printStackTrace();
		}
		try {
			BD.closeBD(con);
		} catch (DBException e2) {
			e2.printStackTrace();
		}
		return existeDni1;

	}
}


