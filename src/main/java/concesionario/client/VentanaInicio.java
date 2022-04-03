package concesionario.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.border.TitledBorder;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;

import concesionario.clases.Cliente;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.util.concurrent.atomic.AtomicBoolean;
import java.awt.event.ActionEvent;

public class VentanaInicio extends JFrame {

	private JTextField textEmail;
	private JTextField textContrasenya;

	public static String database;
	public static String milisegundos;
	public static String columnas;
	public static String imagenes;

	private JProgressBar progressBarCerrar;
	private JProgressBar progressBarRegistarAdmin;

	private JButton btnRegistrarUsuario;
	private JButton btnIniciarSesionUsuario;
	private JButton btnCerrar;

	private Client client;
	private WebTarget webTarget;

	private static Connection con =null;
	private Thread thread;
	private final AtomicBoolean running = new AtomicBoolean(false);

	public static Cliente clienteActual=null;

	public static void main(String[] args) {
		String hostname = args[0];
		String port = args[1];

		new VentanaInicio(hostname, port);
	}

	public VentanaInicio(String hostname, String port) {
		
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));

		
		try {
			con = BD.initBD("concesionario.db");

			try {
				BD.crearTablas(con);
			} catch (DBException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}



		try {
			BD.closeBD(con);
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();	
		}

		
		
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 349, 366);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel titulo = new JLabel("ADAIA");
		titulo.setFont(new Font("Monospaced", Font.PLAIN, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(10, 11, 317, 66);
		getContentPane().add(titulo);
		
		JLabel lblNewLabel = new JLabel("Usuario: ");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 203, 124, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("iconoAdaia.png"));
		lblNewLabel_1.setBounds(118, 67, 100, 100);
		getContentPane().add(lblNewLabel_1);
		
		textEmail = new JTextField();
		textEmail.setBounds(114, 200, 209, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textContrasenya = new JTextField();
		textContrasenya.setColumns(10);
		textContrasenya.setBounds(114, 229, 209, 20);
		getContentPane().add(textContrasenya);
		
		JLabel lblContrasea = new JLabel("Contraseña: ");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBounds(10, 232, 124, 14);
		getContentPane().add(lblContrasea);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLACK);
		panel.setBounds(0, 186, 337, 150);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnRegistro = new JButton("Registrarse");
		btnRegistro.setBackground(SystemColor.inactiveCaption);
		btnRegistro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaRegistro(hostname, port);
			}
		});
		btnRegistro.setBounds(10, 90, 151, 39);
		panel.add(btnRegistro);
		
		JButton btnIniciarSesion = new JButton("Iniciar Sesion");
		btnIniciarSesion.setBackground(SystemColor.inactiveCaption);
		btnIniciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!textEmail.getText().equals("") && !textContrasenya.getText().equals("")) {

					String n= textEmail.getText();
					String c= textContrasenya.getText();
					Connection con = null;
					try {
						con = BD.initBD("concesionario.db");
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}

					try {
						switch (BD.obtenerUsuario(con,n,c)) {
						case 0:
							JOptionPane.showMessageDialog(null, "Ese usuario no se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case 1:
							JOptionPane.showMessageDialog(null, "Contrasenia incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case 2:
							dispose();
							clienteActual=BD.obtenerInfoCliente(con, textEmail.getText());
							new VentanaAdministrador(hostname, port);

							break;
						default:
							break;

						}
					} catch (HeadlessException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					} catch (DBException e2) {
						// TODO Auto-generated catch block
						e2.printStackTrace();
					}
					try {
						BD.closeBD(con);
					} catch (DBException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					textEmail.setText("");
					textContrasenya.setText("");

				}
				else {
					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnIniciarSesion.setBounds(171, 90, 156, 39);
		panel.add(btnIniciarSesion);
		
		setVisible(true);
	}
	
}

