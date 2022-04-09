package concesionario.server;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicBoolean;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import concesionario.clases.Compra;
import concesionario.util.CompraException;

public class ConcesionarioManager extends JFrame implements ActionListener, Runnable {
	
	private JList listaCompras;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	
	private ArrayList<Compra> compras = new ArrayList<>();
	String[] arrayParaLaJList;
	private HashMap<String, Compra> hashCompras;
	
	private Client client;
	private WebTarget webTarget;

	private Thread thread;
	private final AtomicBoolean running = new AtomicBoolean(false);

	public ConcesionarioManager(String hostname, String port) {
		client = ClientBuilder.newClient();
		webTarget = client.target(String.format("http://%s:%s/rest", hostname, port));

		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 315, 468);	
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		

		arrayParaLaJList = new String[compras.size()];
		hashCompras = new HashMap<>();
		int i = 0;
		for (Compra compra : compras) {
			arrayParaLaJList[i] = compra.getId();
			hashCompras.put(compra.getId(), compra);
			i++;
		}
		
		
		listaCompras = new JList(arrayParaLaJList);
		listaCompras.setBackground(SystemColor.inactiveCaption);
		listaCompras.setBounds(10, 88, 283, 102);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 283, 102);
		scrollPane.setViewportView(listaCompras);
		getContentPane().add(scrollPane);
		
		listaCompras.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
						textField.setText(hashCompras.get(listaCompras.getSelectedValue()).getId());
						textField_1.setText(hashCompras.get(listaCompras.getSelectedValue()).getMatricula());
						textField_2.setText(hashCompras.get(listaCompras.getSelectedValue()).getCliente().getNombre() + " " + hashCompras.get(listaCompras.getSelectedValue()).getCliente().getApellido());
						textField_3.setText(hashCompras.get(listaCompras.getSelectedValue()).getFecha());
						textField_4.setText(hashCompras.get(listaCompras.getSelectedValue()).getId_coche());
						repaint();
						validate();
	                }
			}
		});
		
		JLabel titulo = new JLabel("Ventas ADAIA");
		titulo.setFont(new Font("Monospaced", Font.PLAIN, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(10, 11, 283, 66);
		getContentPane().add(titulo);
		
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBackground(new Color(255, 255, 255));
		panelInformacion.setBorder(new TitledBorder(null, "Informacion: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInformacion.setBounds(10, 201, 283, 221);
		getContentPane().add(panelInformacion);
		panelInformacion.setLayout(null);
		
		JLabel idlbl = new JLabel("ID: ");
		idlbl.setBounds(10, 32, 48, 14);
		panelInformacion.add(idlbl);
		
		JLabel matriculalbl = new JLabel("Matricula: ");
		matriculalbl.setBounds(10, 69, 66, 14);
		panelInformacion.add(matriculalbl);
		
		JLabel clientelbl = new JLabel("Cliente: ");
		clientelbl.setBounds(10, 110, 48, 14);
		panelInformacion.add(clientelbl);
		
		JLabel fechalbl = new JLabel("Fecha: ");
		fechalbl.setBounds(10, 153, 48, 14);
		panelInformacion.add(fechalbl);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(83, 29, 190, 20);
		panelInformacion.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(83, 66, 190, 20);
		panelInformacion.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(83, 107, 190, 20);
		panelInformacion.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(83, 147, 190, 20);
		panelInformacion.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(83, 190, 190, 20);
		panelInformacion.add(textField_4);
		
		JLabel cochelbl = new JLabel("Coche id:");
		cochelbl.setBounds(10, 193, 66, 14);
		panelInformacion.add(cochelbl);
		
		setVisible(true);
		
		thread = new Thread(this);
		thread.start();
	}

	public ArrayList<Compra> getCompras() throws CompraException {
		WebTarget donationsWebTarget = webTarget.path("collector/compra");
		Invocation.Builder invocationBuilder = donationsWebTarget.request(MediaType.APPLICATION_JSON);
		Response response = invocationBuilder.get();
		if (response.getStatus() == Status.OK.getStatusCode()) {
			ArrayList<Compra> compras = response.readEntity(ArrayList.class);
			return compras;
		} else {
			throw new CompraException("" + response.getStatus());
		}
	}
	
	public void run() {
		running.set(true);
		while(running.get()) {
			try { 
				Thread.sleep(2000);
				System.out.println("Obtaining data from server...");
					//Cosas que hace el server
				
					try {
						compras=getCompras();
						
						arrayParaLaJList = new String[compras.size()];
						hashCompras = new HashMap<>();
						int i = 0;
						for (Compra compra : compras) {
							arrayParaLaJList[i] = compra.getId();
							hashCompras.put(compra.getId(), compra);
							i++;
						}
						
						repaint();
						validate();
						
					} catch (Exception e) {
					}
				
            } catch (InterruptedException e){ 
                Thread.currentThread().interrupt();
                System.out.println("Thread was interrupted, Failed to complete operation");
            }
		}
	}

	public void stop() {
		this.running.set(false);
	}

	public static void main(String[] args) {
		String hostname = args[0];
		String port = args[1];

		new ConcesionarioManager(hostname, port);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		//Acciones de los botones
	}
}