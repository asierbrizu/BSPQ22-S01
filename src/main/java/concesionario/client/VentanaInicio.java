package concesionario.client;

import java.awt.BorderLayout; 
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import concesionario.clases.Cliente;
import concesionario.clases.Coche;
import concesionario.clases.Compra;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;
import concesionario.util.CompraException;

import java.awt.Color;
import java.awt.HeadlessException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

public class VentanaInicio extends JFrame {

	private JPanel contentPane;
	private JPanel panelCentral;
	private JPanel panelOpciones;
	private JLabel lblUsuario;
	private JLabel lblContrasenia;
	private JLabel labelCerrar;
	private JFrame ventanaActual;
	private JPasswordField textContrasenia;
	private JTextField textUsuario;

	public static String database;
	public static String milisegundos;
	public static String columnas;
	public static String imagenes;

	private JPanel panelSur;
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



		setTitle("VENTANA INICIO");
		ventanaActual = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 297);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		panelCentral = new JPanel();
		contentPane.add(panelCentral, BorderLayout.CENTER);
		panelCentral.setLayout(null);

		panelOpciones = new JPanel();
		panelOpciones.setBounds(10, 104, 478, 111);
		panelOpciones.setLayout(null);
		panelOpciones.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Opciones: ", TitledBorder.CENTER, TitledBorder.TOP, null, new Color(255, 255, 204)));
		panelOpciones.setBackground(new Color(0, 0, 128));
		panelCentral.add(panelOpciones);

		btnRegistrarUsuario = new JButton("REGISTRARSE");
		btnRegistrarUsuario.setForeground(new Color(255, 250, 205));
		btnRegistrarUsuario.setBackground(Color.BLACK);
		btnRegistrarUsuario.setBounds(233, 36, 235, 23);
		panelOpciones.add(btnRegistrarUsuario);

		btnIniciarSesionUsuario = new JButton("INICIAR SESION ");
		btnIniciarSesionUsuario.setForeground(new Color(255, 250, 205));
		btnIniciarSesionUsuario.setBackground(Color.BLACK);
		btnIniciarSesionUsuario.setBounds(10, 36, 213, 23);
		panelOpciones.add(btnIniciarSesionUsuario);

		btnCerrar = new JButton("Cerrar");
		btnCerrar.setBackground(new Color(0, 153, 0));
		btnCerrar.setBounds(160, 70, 119, 23);
		panelOpciones.add(btnCerrar);

		lblContrasenia = new JLabel(" Introduce la contrasenia:");
		lblContrasenia.setBounds(26, 68, 163, 14);
		panelCentral.add(lblContrasenia);
		lblContrasenia.setBackground(Color.DARK_GRAY);

		textContrasenia = new JPasswordField();
		textContrasenia.setBounds(281, 61, 157, 28);
		panelCentral.add(textContrasenia);
		textContrasenia.setColumns(10);

		lblUsuario = new JLabel(" Introduce tu correo:");
		lblUsuario.setBounds(26, 26, 227, 14);
		panelCentral.add(lblUsuario);
		lblUsuario.setHorizontalAlignment(SwingConstants.LEFT);
		lblUsuario.setBackground(Color.DARK_GRAY);

		textUsuario = new JTextField();
		textUsuario.setColumns(10);
		textUsuario.setBounds(281, 22, 157, 28);
		panelCentral.add(textUsuario);

		panelSur = new JPanel(null);
		contentPane.add(panelSur, BorderLayout.SOUTH);

		labelCerrar = new JLabel("Cerrando ventana...");
		labelCerrar.setBounds(200, 300, 200, 10);
		labelCerrar.setVisible(false);

		progressBarCerrar = new JProgressBar(0, 100);
		progressBarCerrar.setBounds(415, 360, 146, 14);
		progressBarCerrar.setVisible(false);
		progressBarRegistarAdmin = new JProgressBar(0, 100);
		progressBarRegistarAdmin.setBounds(415, 360, 146, 14);
		progressBarRegistarAdmin.setVisible(false);

		//Esta linea me da error, ni idea
		thread = new Thread();
		thread.start();

		btnRegistrarUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaRegistro(hostname, port);
			}
		});
		
		btnCerrar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		btnIniciarSesionUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {

				if (!textUsuario.getText().equals("") && !textContrasenia.getText().equals("")) {

					String n= textUsuario.getText();
					String c= textContrasenia.getText();
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
							ventanaActual.dispose();
							clienteActual=BD.obtenerInfoCliente(con, textUsuario.getText());
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
					textUsuario.setText("");
					textContrasenia.setText("");

				}
				else {
					JOptionPane.showMessageDialog(null, "Hay campos vacios", "Error", JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		setVisible(true);

	}
	
	public void comprarCoche(Coche coche) throws CompraException{
		WebTarget donationsWebTarget = webTarget.path("collector/compra");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		try {
			con = BD.initBD("concesionario.db");
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		String idCompra=String.valueOf(BD.getSiguienteIdCompra(con));
		String matricula;//ASIGNAR MATRICULA
		long milis = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
		Date fecha = new Date(milis);
		String fechaActual = sdf.format(fecha);
		Compra compra=new Compra(idCompra, clienteActual,matricula, fechaActual, coche.getIdCoche());
		Response response = invocationBuilder.post(Entity.entity(compra, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new CompraException("" + response.getStatus());
		}
	}

	public void run() {
		running.set(true);
		while(running.get()) {
			try { 
				Thread.sleep(2000);
				System.out.println("Obtaining data from server...");

				//Cosas
				//DonationInfo donationInfo = getDonationInfo();
				//this.total.setText(Integer.toString(donationInfo.getTotal()));

			} catch (InterruptedException e){ 
				Thread.currentThread().interrupt();
				System.out.println("Thread was interrupted, Failed to complete operation");
			}
		}
	}

	public void stop() {
		this.running.set(false);
	}

}
