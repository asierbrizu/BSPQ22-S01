package concesionario.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;


public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JLabel labelCerrar;
	public static String database;
	public static String milisegundos;
	public static String columnas;
	public static String imagenes;
	private JProgressBar progressBarCerrar;
	private JProgressBar progressBarRegistarUsuario;
	private JPanel panelIzquierda_1;
	private JLabel lblApellido;
	private JTextField txtApellido;
	private JLabel lblEmail;
	private JLabel lblFecha;
	private JLabel lblDni;
	private JTextField txtDni;
	private JLabel lblNombre;
	private JTextField txtNombre;
	private JTextField textCorreo;
	JDateChooser txtFecha = new JDateChooser();
	private JPasswordField txtContrasenia;
    private static String fechaStr;
	private static boolean correctoNombre ,correctoApellido ,  correctoDni  ;
	private static JLabel lblMensajeNombre_1, lblMensajeApellido_1,lblMensajeDNI_1;

	private static String dni;
	private static String nom;
	private static String apellido;
	private static String correo;
	private static Connection con;
	
	public VentanaRegistro() {
		
		panelIzquierda_1 = new JPanel();
		con=null;
		dni="";
		nom="";
		apellido="";
		
		lblMensajeNombre_1 = new JLabel();
		lblMensajeNombre_1.setText("*");
		lblMensajeNombre_1.setForeground(Color.ORANGE);
		lblMensajeNombre_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajeNombre_1.setBounds(277, 26, 257, 14);
		panelIzquierda_1.add(lblMensajeNombre_1);
		
		lblMensajeApellido_1 = new JLabel();
		lblMensajeApellido_1.setText("*");
		lblMensajeApellido_1.setForeground(Color.ORANGE);
		lblMensajeApellido_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajeApellido_1.setBounds(273, 54, 245, 14);
		panelIzquierda_1.add(lblMensajeApellido_1);
		
		lblMensajeDNI_1 = new JLabel();
		lblMensajeDNI_1.setText("*");
		lblMensajeDNI_1.setForeground(Color.ORANGE);
		lblMensajeDNI_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajeDNI_1.setBounds(273, 92, 245, 14);
		panelIzquierda_1.add(lblMensajeDNI_1);
		
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

		setTitle("REGISTRO");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 584, 486);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelIzquierda_1 = new JPanel();
		panelIzquierda_1.setBackground(Color.GRAY);
		contentPane.add(panelIzquierda_1, BorderLayout.CENTER);
		
		lblApellido = new JLabel();
		lblApellido.setBounds(26, 54, 65, 14);
		lblApellido.setText("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtApellido = new JTextField();
		txtApellido.setBounds(170, 51, 102, 20);
		
		lblEmail = new JLabel();
		lblEmail.setBounds(26, 205, 38, 14);
		lblEmail.setText("Correo");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblFecha = new JLabel();
		lblFecha.setBounds(26, 143, 102, 14);
		lblFecha.setText("Fecha_ncto");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblDni = new JLabel();
		lblDni.setBounds(26, 92, 78, 14);
		lblDni.setText("DNI");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtDni = new JTextField();
		txtDni.setBounds(170, 89, 99, 20);
		
		lblNombre = new JLabel();
		lblNombre.setBounds(26, 26, 65, 14);
		lblNombre.setText("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		txtNombre = new JTextField();
		txtNombre.setBounds(170, 23, 102, 20);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(170, 202, 102, 20);
		
		JDateChooser txtFecha = new JDateChooser();
		  // HACER QUE EL TEXTFIELD DONDE APARECE LA FECHA TRAS SELECCIONARLA CON JFILECHOOSER NO SE PUEDA EDITAR
        JTextFieldDateEditor editor = (JTextFieldDateEditor) txtFecha.getDateEditor();
        editor.setEditable(false);
        // solo se puede seleccionar una fecha como minimo de hace 18 a�os
        long milisegundosHace18anios= System.currentTimeMillis()-568036800000L;
        txtFecha.setMinSelectableDate(new Date(milisegundosHace18anios));
		txtFecha.setBounds(170, 137, 102, 20);
		panelIzquierda_1.add(txtFecha);
		
		JLabel lblContrasenia = new JLabel();
		lblContrasenia.setText("Contrasenia");
		lblContrasenia.setForeground(Color.WHITE);
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasenia.setBounds(26, 262, 102, 14);
		panelIzquierda_1.add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(170, 259, 102, 20);
		panelIzquierda_1.add(txtContrasenia);
		labelCerrar = new JLabel("Cerrando ventana...");
		labelCerrar.setBounds(200, 300, 200, 10);
		labelCerrar.setVisible(false);
		
		/*txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String erNombre = "^([A-Z]{1}[a-z]+[ ]?){1,2}$";//empieza por una letra mayuscula seguida de una minuscula como minimo. Se permite un espacio, por si tienes dos nombres
				String nombreIntroducido = txtNombre.getText();
				 correctoNombre = nombreIntroducido.matches(erNombre);
				if (correctoNombre) {
					lblMensajeNombre_1.setText("*");
					nom = txtNombre.getText();
				} else {
					lblMensajeNombre_1.setText("Empieza por mayuscula + minuscula");
				}
				
			}
		});
		txtDni.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String erdni = "^[0-9]{8}[A-Z]$";// 8 digitos seguidos de una letra mayuscula
				String dniIntroducido = txtDni.getText();
				 correctoDni = dniIntroducido.matches(erdni);
				if (correctoDni) {
					lblMensajeDNI_1.setText("*");
					 dni = txtDni.getText();
				
				} else {
					lblMensajeDNI_1.setText("8 digitos seguidos de letra mayuscula");
				}
			}
		}*/
		/*txtApellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String erApellido = "^([A-Z]{1}[a-z]+[ ]?){1,2}$";//empieza por una letra mayuscula seguida de una minuscula como minimo. Se permite un espacio, por si pones dos apellidos
				String apellidoIntroducido = txtApellido.getText();
				 correctoApellido = apellidoIntroducido.matches(erApellido);
				if (correctoApellido) {
					lblMensajeApellido_1.setText("*");
					 apellido = txtApellido.getText();
				}else {
					lblMensajeApellido_1.setText("Empieza por mayuscula + minuscula");
				}
				
			}
		});*/
		
		JButton btnGuardar = new JButton();
		btnGuardar.setBounds(185, 345, 126, 38);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				correo=textCorreo.getText();
				dni=txtDni.getText();
				boolean d= existeDni(dni);
				boolean m= existeEmail(correo);
				if( !d && !m ) {
				//if (correctoApellido  && correctoDni &&  correctoNombre) {
					

					java.util.Date fecha=txtFecha.getDate();
	        		if (!(fecha == null)) {
	        			
	        			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
	            		fechaStr = sdf.format(fecha);
	           
					}else {
						fechaStr="01-01-1970";
					}
					System.out.println("1");
					Connection con = null;
					try {
						System.out.println("2");
						con = BD.initBD("concesionario.db");
						
					} catch (DBException e1) {
						e1.printStackTrace();
					}
					System.out.println("3");
					try {
						System.out.println("4");
						BD.insertarUsuario(con, textCorreo.getText(), txtContrasenia.getText(), txtNombre.getText(), txtApellido.getText(), txtDni.getText(), fechaStr, null);
					} catch (DBException e1) {
						e1.printStackTrace();
					}
					System.out.println("5");
					try {
						System.out.println("6");
						BD.closeBD(con);
					} catch (DBException e1) {
						e1.printStackTrace();	
					}
					System.out.println("7");
					dispose();
					try {
						VentanaInicio.clienteActual=BD.obtenerInfoCliente(con, correo);
					} catch (DBException e1) {
						e1.printStackTrace();
					}
					new VentanaAdministrador();
				
			//}else {
				//JOptionPane.showMessageDialog(null, "Quedan campos vacios o incorrectos.", "Error", JOptionPane.WARNING_MESSAGE);
		//	}
				}else {
					JOptionPane.showMessageDialog(null, "Ya existe un usuario con esos datos", "Error", JOptionPane.WARNING_MESSAGE);

				}	
				

			}
		});
		btnGuardar.setText("Guardar");
		
		JButton btnCancelar = new JButton();
		btnCancelar.setBounds(26, 345, 134, 38);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				
				new VentanaInicio();
			}
		});
		btnCancelar.setText("Cancelar");
		
		
		
		panelIzquierda_1.setLayout(null);
		panelIzquierda_1.add(btnGuardar);
		panelIzquierda_1.add(btnCancelar);
		panelIzquierda_1.add(lblApellido);
		panelIzquierda_1.add(txtApellido);
		panelIzquierda_1.add(lblEmail);
		panelIzquierda_1.add(lblFecha);
		panelIzquierda_1.add(lblDni);
		panelIzquierda_1.add(textCorreo);
		panelIzquierda_1.add(txtDni);
		panelIzquierda_1.add(lblNombre);
		panelIzquierda_1.add(txtNombre);
		
		JLabel lblMensajeNombre_1 = new JLabel();
		lblMensajeNombre_1.setText("*");
		lblMensajeNombre_1.setForeground(Color.ORANGE);
		lblMensajeNombre_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajeNombre_1.setBounds(271, 26, 257, 14);
		panelIzquierda_1.add(lblMensajeNombre_1);
		
		JLabel lblMensajeApellido_1 = new JLabel();
		lblMensajeApellido_1.setText("*");
		lblMensajeApellido_1.setForeground(Color.ORANGE);
		lblMensajeApellido_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajeApellido_1.setBounds(271, 54, 245, 14);
		panelIzquierda_1.add(lblMensajeApellido_1);
		
		JLabel lblMensajeDNI_1 = new JLabel();
		lblMensajeDNI_1.setText("*");
		lblMensajeDNI_1.setForeground(Color.ORANGE);
		lblMensajeDNI_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblMensajeDNI_1.setBounds(271, 92, 245, 14);
		panelIzquierda_1.add(lblMensajeDNI_1);


		progressBarCerrar = new JProgressBar(0, 100);
		progressBarCerrar.setBounds(415, 360, 146, 14);
		progressBarCerrar.setVisible(false);
		progressBarRegistarUsuario = new JProgressBar(0, 100);
		progressBarRegistarUsuario.setBounds(415, 360, 146, 14);
		progressBarRegistarUsuario.setVisible(false);
	
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
