package concesionario.client;

import java.io.File;
import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import concesionario.clases.Cliente;
import concesionario.clases.Coche;
import concesionario.clases.Compra;
import concesionario.server.bd.BD;
import concesionario.server.bd.DBException;
import concesionario.util.CompraException;
import static org.mockito.Mockito.*;

public class VentanaInicio extends JFrame {

	private JTextField textEmail;
	private JPasswordField textContrasenya;

	public static String database;
	public static String milisegundos;
	public static String columnas;
	public static String imagenes;

	private JProgressBar progressBarCerrar;
	private JProgressBar progressBarRegistarAdmin;

	private Client client;
	private static WebTarget webTarget;

	private static Connection con =null;
	private Thread thread;
	private final AtomicBoolean running = new AtomicBoolean(false);
	public static BD bd;

	public static Cliente clienteActual=null;

	public static void main(String[] args) {
		String hostname = "127.0.0.1";
		String port = "8080";
		
		new VentanaInicio();
	}

	public VentanaInicio() {
		bd = new BD();
		
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest", "127.0.0.1","8080"));

		
		try {
			con = bd.initBD("bd_bspq");

			try {
				bd.crearTablas();
			} catch (DBException e3) {
				e3.printStackTrace();
			}
			
		} catch (DBException e1) {
			e1.printStackTrace();
		}



//		try {
//			bd.closeBD();
//		} catch (DBException e1) {
//			e1.printStackTrace();	
//		}

		
		
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
		URL urlImagen=getClass().getResource("/img/iconoAdaia.png");
		lblNewLabel_1.setIcon(new ImageIcon(urlImagen));
		lblNewLabel_1.setBounds(118, 67, 100, 100);
		getContentPane().add(lblNewLabel_1);
		
		textEmail = new JTextField();
		textEmail.setBounds(114, 200, 209, 20);
		getContentPane().add(textEmail);
		textEmail.setColumns(10);
		
		textContrasenya = new JPasswordField();
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
				new VentanaRegistro();
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
						con = bd.initBD("bd_bspq");
					} catch (DBException e1) {
						e1.printStackTrace();
					}

					try {
						switch (bd.obtenerUsuario(n,c)) {
						case 0:
							JOptionPane.showMessageDialog(null, "Ese usuario no se encuentra registrado", "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case 1:
							JOptionPane.showMessageDialog(null, "Contrasenia incorrecta", "Error", JOptionPane.ERROR_MESSAGE);
							break;
						case 2:
							clienteActual = BD.getCliente(n, c);
							new VentanaAdministrador(clienteActual, bd);
							dispose();

							break;
						default:
							break;

						}
					} catch (HeadlessException e2) {
						e2.printStackTrace();
					} catch (DBException e2) {
						e2.printStackTrace();
					}
//					try {
//						BD.closeBD();
//					} catch (DBException e1) {
//						e1.printStackTrace();
//					}
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
	

	public static void comprarCoche(Coche coche) throws CompraException{
		WebTarget donationsWebTarget = webTarget.path("collector/compra");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		try {
			con = bd.initBD("bd_bspq");
		} catch (DBException e1) {
			e1.printStackTrace();
		}
		String idCompra=String.valueOf(BD.getSiguienteIdCompra());
		String matricula = bd.getUltimaMatricula();
		String new_matricula = "";
		
		char[] charMatricula = matricula.toCharArray();
		
		if(charMatricula.length <= 0){
			new_matricula = "0000AAA"; //Primera matricula

		} else {	
			int intUltima = charMatricula[charMatricula.length-1];
			int intAnteUltima = charMatricula[charMatricula.length-2];
			int intTercera = charMatricula[charMatricula.length-3];
			
			int n = (int) (Math.random()*9000)+1000;
			new_matricula = ""+n;
			
			if (intUltima < 90) {
				int asciiUltima = intUltima+1;	
				char nuevaUltima = (char) asciiUltima;
				char anteUltima = (char) intAnteUltima;
				char tercera = (char) intTercera;
				new_matricula = new_matricula + ""+ tercera + ""+ anteUltima + "" + nuevaUltima;
				
			}else if(intUltima == 90) {
				int asciiUltima = 65;
				char nuevaUltima = (char) asciiUltima;
				
				if (intAnteUltima < 90) {
					int asciiAnteUltima = intAnteUltima+1;
					char nuevaAnteUltima = (char) asciiAnteUltima;
					char tercera = (char) intTercera;
					
					new_matricula = new_matricula + "" + tercera + "" + nuevaAnteUltima + "" + nuevaUltima;
					
				} else if (intAnteUltima == 90) {
					int asciiAnteUltima = 65;
					char nuevaAnteUltima = (char) asciiAnteUltima;

					if(intTercera < 90) {
						int asciiTercera = intTercera+1;
						char nuevaTercera = (char) asciiTercera;
						
						new_matricula = new_matricula + "" + nuevaTercera + "" + nuevaAnteUltima + "" + nuevaUltima;
					}
				}
				
			}
			
		}
		
		
		
		long milis = System.currentTimeMillis();
		SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss:SSS");
		Date fecha = new Date(milis);
		String fechaActual = sdf.format(fecha);
		Compra compra=new Compra(idCompra, clienteActual.getDni(), new_matricula, fechaActual, coche.getIdCoche());
		generarPDF(coche);
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
//		JOptionPane.showMessageDialog(null, compra);
		
		Response response = invocationBuilder.post(Entity.entity(compra, MediaType.APPLICATION_JSON));
		if (response.getStatus() != Status.OK.getStatusCode()) {
			throw new CompraException("" + response.getStatus());
		}
		
	}
	
	public static void generarPDF(Coche coche){
		
		String color=coche.getColor();
		String combustible=coche.getCombustible();
		String marca=coche.getMarca();
		String modelo=coche.getModelo();
		Double precio=coche.getPrecioBase();
		
	
		
		//generar PDF
		
		try {
			long milis=System.currentTimeMillis();
			SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH_mm_ss");
			Date fecha = new Date(milis);
			String f = sdf.format(fecha);
			
			Path path=Paths.get(System.getProperty("user.dir") +"\\factura\\");
            if (!Files.exists(path)) {
                try {
                    Files.createDirectory(path);
                } catch (IOException e) {
                   
                    e.printStackTrace();
                }
            }
			String pw = System.getProperty("user.dir") +"\\factura\\" +f + ".pdf";
			Document documento = new Document();
			PdfWriter writer = null;
			try {
				writer = PdfWriter.getInstance(documento, new FileOutputStream(pw));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			documento.open();
			
			Paragraph marcaDeAgua=new Paragraph();
			marcaDeAgua.setAlignment(marcaDeAgua.ALIGN_TOP);
			marcaDeAgua.setFont(FontFactory.getFont("Sans", 30, Font.ITALIC, BaseColor.ORANGE));
			marcaDeAgua.add("Concesionario ADAIA");
			Paragraph parrafo=new Paragraph();
			parrafo.setAlignment(Paragraph.ALIGN_CENTER);
			parrafo.setFont(FontFactory.getFont("Sans", 20, Font.BOLD, BaseColor.BLUE));
			parrafo.add("COLOR: "+color+"\n"+"COMBUSTIBLE: "+combustible+"\n"+"MARCA: "+marca+"\n"+"MODELO: "+modelo+"\n"+"PRECIO BASE: "+precio.toString());
			try {
				documento.add(marcaDeAgua);
				documento.add(parrafo);
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			documento.close();
			writer.close();
		
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
		
	}

	public void run() {
		running.set(true);
		while(running.get()) {
			try { 
				Thread.sleep(2000);
				System.out.println("Obtaining data from server...");
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

