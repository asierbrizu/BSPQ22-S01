package concesionario.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JCheckBox;

public class VentanaPrueba {

	private JFrame frame;
	private JTextField textNombre;
	private JTextField textApellido;
	private JTextField textEmail;
	private JTextField textDNI;
	private JPasswordField textPassword;
	private JPasswordField passwordField;
	private JPasswordField textAutorizacion;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPrueba window = new VentanaPrueba();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VentanaPrueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.getContentPane().setLayout(null);
		
		textNombre = new JTextField();
		textNombre.setBounds(10, 104, 281, 20);
		frame.getContentPane().add(textNombre);
		textNombre.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Registro");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 281, 51);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre:");
		lblNewLabel_1.setBounds(10, 89, 77, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		textApellido = new JTextField();
		textApellido.setColumns(10);
		textApellido.setBounds(10, 150, 281, 20);
		frame.getContentPane().add(textApellido);
		
		JLabel lblNewLabel_1_1 = new JLabel("Apellido:");
		lblNewLabel_1_1.setBounds(10, 135, 77, 14);
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Email:");
		lblNewLabel_1_1_1.setBounds(10, 227, 77, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1);
		
		textEmail = new JTextField();
		textEmail.setColumns(10);
		textEmail.setBounds(10, 242, 281, 20);
		frame.getContentPane().add(textEmail);
		
		textDNI = new JTextField();
		textDNI.setColumns(10);
		textDNI.setBounds(10, 196, 281, 20);
		frame.getContentPane().add(textDNI);
		
		JLabel lblNewLabel_1_2 = new JLabel("DNI");
		lblNewLabel_1_2.setBounds(10, 181, 77, 14);
		frame.getContentPane().add(lblNewLabel_1_2);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(10, 288, 281, 20);
		frame.getContentPane().add(textPassword);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("Password:");
		lblNewLabel_1_1_1_1.setBounds(10, 273, 184, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("Fecha de Nacimiento: ");
		lblNewLabel_1_1_1_1_1.setBounds(10, 319, 199, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 334, 281, 20);
		frame.getContentPane().add(passwordField);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("Empleado: ");
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 365, 113, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_1_1);
		
		JCheckBox checkEmpleado = new JCheckBox("");
		checkEmpleado.setForeground(new Color(255, 140, 0));
		checkEmpleado.setBackground(Color.WHITE);
		checkEmpleado.setBounds(65, 361, 99, 23);
		frame.getContentPane().add(checkEmpleado);
		
		textAutorizacion = new JPasswordField();
		textAutorizacion.setEnabled(false);
		textAutorizacion.setBounds(10, 405, 281, 20);
		frame.getContentPane().add(textAutorizacion);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("Autorizacion: ");
		lblNewLabel_1_1_1_1_2.setEnabled(false);
		lblNewLabel_1_1_1_1_2.setBounds(10, 390, 184, 14);
		frame.getContentPane().add(lblNewLabel_1_1_1_1_2);
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.setBounds(10, 451, 135, 30);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnRegistrar = new JButton("Registrarse");
		btnRegistrar.setForeground(Color.WHITE);
		btnRegistrar.setBackground(new Color(255, 127, 80));
		btnRegistrar.setBounds(156, 451, 135, 30);
		frame.getContentPane().add(btnRegistrar);
		frame.setBounds(100, 100, 313, 528);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
