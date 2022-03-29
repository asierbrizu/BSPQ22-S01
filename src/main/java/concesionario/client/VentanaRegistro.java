package concesionario.client;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
<<<<<<< HEAD
import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
=======
>>>>>>> c60cbc72d6ca611ff4ef5bf7f40d28c94ccf1b9c

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
import javax.swing.JScrollPane;
import javax.swing.LayoutStyle.ComponentPlacement;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;
import javax.swing.JPasswordField;


public class VentanaRegistro extends JFrame {

	private JPanel contentPane;
	private JLabel labelCerrar;
	public static String database;
	public static String milisegundos;
	public static String columnas;
	public static String imagenes;
	private JProgressBar progressBarCerrar;
	private JProgressBar progressBarRegistarUsuario;
	private JPanel panelIzquierda;
	private JLabel lblApellido;
	private JTextField textApellido;
	private JLabel lblEmail;
	private JLabel lblFecha;
	private JLabel lblDni;
	private JTextField textDni;
	private JLabel lblNombre;
	private JTextField textNombre;
	private JTextField textCorreo;
	JDateChooser txtFecha = new JDateChooser();
	private JPasswordField txtContrasenia;
	
	

	
	
	
	

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
		lblApellido.setBounds(26, 54, 65, 14);
		lblApellido.setText("Apellido");
		lblApellido.setForeground(Color.WHITE);
		lblApellido.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textApellido = new JTextField();
		textApellido.setBounds(170, 51, 102, 20);
		
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
		
		textDni = new JTextField();
		textDni.setBounds(170, 89, 99, 20);
		
		lblNombre = new JLabel();
		lblNombre.setBounds(26, 26, 65, 14);
		lblNombre.setText("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		textNombre = new JTextField();
		textNombre.setBounds(170, 23, 102, 20);
		
		textCorreo = new JTextField();
		textCorreo.setBounds(170, 202, 102, 20);
		
		JButton btnGuardar = new JButton();
		btnGuardar.setBounds(185, 345, 126, 38);
		btnGuardar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
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
		
		JDateChooser txtFecha = new JDateChooser();
		  // HACER QUE EL TEXTFIELD DONDE APARECE LA FECHA TRAS SELECCIONARLA CON JFILECHOOSER NO SE PUEDA EDITAR
        JTextFieldDateEditor editor = (JTextFieldDateEditor) txtFecha.getDateEditor();
        editor.setEditable(false);
        // solo se puede seleccionar una fecha como minimo de hace 18 años
        long milisegundosHace18anios= System.currentTimeMillis()-568036800000L;
        txtFecha.setMinSelectableDate(new Date(milisegundosHace18anios));
		txtFecha.setBounds(170, 137, 102, 20);
		panelIzquierda.add(txtFecha);
		
		JLabel lblContrasenia = new JLabel();
		lblContrasenia.setText("Correo");
		lblContrasenia.setForeground(Color.WHITE);
		lblContrasenia.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblContrasenia.setBounds(26, 262, 38, 14);
		panelIzquierda.add(lblContrasenia);
		
		txtContrasenia = new JPasswordField();
		txtContrasenia.setBounds(170, 259, 102, 20);
		panelIzquierda.add(txtContrasenia);
		labelCerrar = new JLabel("Cerrando ventana...");
		labelCerrar.setBounds(200, 300, 200, 10);
		labelCerrar.setVisible(false);

		progressBarCerrar = new JProgressBar(0, 100);
		progressBarCerrar.setBounds(415, 360, 146, 14);
		progressBarCerrar.setVisible(false);
		progressBarRegistarUsuario = new JProgressBar(0, 100);
		progressBarRegistarUsuario.setBounds(415, 360, 146, 14);
		progressBarRegistarUsuario.setVisible(false);
	

		

		
		

		setVisible(true);
		
	
	}
}
