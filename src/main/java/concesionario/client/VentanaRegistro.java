package concesionario.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;

import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JProgressBar;
import java.awt.Font;

public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JLabel labelCerrar;
	private JFrame ventanaActual;
	
	public static String database;
	public static String milisegundos;
	public static String columnas;
	public static String imagenes;
	private JProgressBar progressBarCerrar;
	private JProgressBar progressBarRegistarAdmin;
	private JPanel panelIzquierda;
	private JLabel lblApellido;
	private JTextField textApellido;
	private JLabel lblEmail;
	private JLabel lblFecha;
	private JLabel lblDni;
	private JTextField textDni;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JLabel lblMensajeDNI;
	private JLabel lblMensajeApellido;
	private JLabel lblMensajeNombre;
	private JTextField textCorreo;
	
	

	
	
	
	

	public VentanaRegistro() {
		
		Connection con =null;
		try {
			con = BD.initBD("concesionario.db");
			
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
			try {
				BD.crearTablas(con);
			} catch (DBException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
			
			
		try {
			BD.closeBD(con);
		} catch (DBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();	
		}
		
		

		setTitle("REGISTRO");
		ventanaActual = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 522, 486);
		contentPane = new JPanel();
		contentPane.setBackground(Color.BLACK);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		panelIzquierda = new JPanel();
		panelIzquierda.setBackground(Color.GRAY);
		contentPane.add(panelIzquierda, BorderLayout.CENTER);
		
		lblApellido = new JLabel();
		lblApellido.setBounds(26, 54, 45, 14);
		lblApellido.setText("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textApellido = new JTextField();
		textApellido.setBounds(117, 51, 102, 20);
		
		lblEmail = new JLabel();
		lblEmail.setBounds(26, 205, 38, 14);
		lblEmail.setText("Correo");
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblFecha = new JLabel();
		lblFecha.setBounds(26, 143, 65, 14);
		lblFecha.setText("Fecha_ncto");
		lblFecha.setForeground(Color.WHITE);
		lblFecha.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblDni = new JLabel();
		lblDni.setBounds(26, 92, 20, 14);
		lblDni.setText("DNI");
		lblDni.setForeground(Color.WHITE);
		lblDni.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textDni = new JTextField();
		textDni.setBounds(130, 89, 89, 20);
		
		lblNombre = new JLabel();
		lblNombre.setBounds(26, 26, 44, 14);
		lblNombre.setText("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textNombre = new JTextField();
		textNombre.setBounds(117, 23, 102, 20);
		
		lblMensajeDNI = new JLabel();
		lblMensajeDNI.setBounds(229, 92, 245, 14);
		lblMensajeDNI.setText("*");
		lblMensajeDNI.setForeground(Color.ORANGE);
		lblMensajeDNI.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblMensajeApellido = new JLabel();
		lblMensajeApellido.setBounds(229, 54, 245, 14);
		lblMensajeApellido.setText("*");
		lblMensajeApellido.setForeground(Color.ORANGE);
		lblMensajeApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		lblMensajeNombre = new JLabel();
		lblMensajeNombre.setBounds(229, 26, 257, 14);
		lblMensajeNombre.setText("*");
		lblMensajeNombre.setForeground(Color.ORANGE);
		lblMensajeNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textCorreo = new JTextField();
		textCorreo.setBounds(130, 202, 89, 20);
		
		JButton btnGuardar = new JButton();
		btnGuardar.setBounds(26, 277, 126, 38);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnGuardar.setText("Guardar");
		
		JButton btnCancelar = new JButton();
		btnCancelar.setBounds(170, 277, 134, 38);
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaInicio();
			}
		});
		btnCancelar.setText("Cancelar");
		panelIzquierda.setLayout(null);
		panelIzquierda.add(btnGuardar);
		panelIzquierda.add(btnCancelar);
		panelIzquierda.add(lblApellido);
		panelIzquierda.add(textApellido);
		panelIzquierda.add(lblEmail);
		panelIzquierda.add(lblFecha);
		panelIzquierda.add(lblDni);
		panelIzquierda.add(textCorreo);
		panelIzquierda.add(textDni);
		panelIzquierda.add(lblNombre);
		panelIzquierda.add(textNombre);
		panelIzquierda.add(lblMensajeDNI);
		panelIzquierda.add(lblMensajeApellido);
		panelIzquierda.add(lblMensajeNombre);
		ImageIcon im = new ImageIcon("img/avioncito.png");

		labelCerrar = new JLabel("Cerrando ventana...");
		labelCerrar.setBounds(200, 300, 200, 10);
		labelCerrar.setVisible(false);

		progressBarCerrar = new JProgressBar(0, 100);
		progressBarCerrar.setBounds(415, 360, 146, 14);
		progressBarCerrar.setVisible(false);
		progressBarRegistarAdmin = new JProgressBar(0, 100);
		progressBarRegistarAdmin.setBounds(415, 360, 146, 14);
		progressBarRegistarAdmin.setVisible(false);
	

		

		
		

		setVisible(true);
		
	
	}
}
