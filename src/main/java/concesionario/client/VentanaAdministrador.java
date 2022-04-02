package concesionario.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.GroupLayout.Alignment;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.awt.Font;


public class VentanaAdministrador extends JFrame {

	static JDesktopPane panelEscritorio;
	public static JLabel lblDeustoAuto;
	private static JMenu menuCoches;
	//private static JMenu menuTickets;
	//private static JMenu menuVuelo;
	private static JMenu menuEmpleados;
	private JMenuBar menuPrincipal;
	private JMenuItem menuItemAudi;
	private JMenuItem menuItemMercedes;
	private JMenuItem menuItemHyundai;
	private JMenuItem menuItemAlfaRomeo;
	private JMenuItem menuItemCupra;
	private JMenuItem menuItemDacia;
	private JMenuItem menuItemJaguar;
	private JMenuItem menuItemTesla;
	private JMenuItem menuItemMazda;
	private JMenuItem menuItemFerrari;
	private JMenuItem menuItemHonda;
	private JMenuItem menuItemBMW;
	//private JMenuItem menuItemReservarTicket;
	//private JMenuItem menuItemVerTickets;
	//private JMenuItem menuItemAnadirVuelo;
	private JMenuItem menuItemCerrarSesion;
	//private JMenuItem menuItemVerVuelos;
	private JMenuItem menuItemGestionarEmpleados;
	//private JMenuItem menuItemGestionarEquipajes;
	private JMenuItem menuItemDarPermisos;
	private JMenuItem menuItemVentanaEmpleado;

	private ImageIcon imagenAzafato;
	private ImageIcon imagenCerrarSesion;
	private ImageIcon imagenAniadir;
	private ImageIcon imagenLlave;
	private ImageIcon imagenMaleta;
	private ImageIcon imagenPasajero;
	private ImageIcon imagenTicket;
	private ImageIcon imagenAvion;
	private ImageIcon imagenActualizar;
	private ImageIcon imagenReservar;
	private ImageIcon imagenListar;
	private ImageIcon imagenUsuario;
	private ImageIcon imagenIrAzafato;
	public static JFrame ventanaActual;

	public VentanaAdministrador(String hostname, String port) {

		ventanaActual = this;

		imagenAzafato = new ImageIcon("img/azafato.png");
		imagenCerrarSesion = new ImageIcon("img/logout.png");
		imagenAniadir = new ImageIcon("img/plus.png");
		imagenMaleta = new ImageIcon("img/maleta.png");
		imagenPasajero = new ImageIcon("img/pasajero.png");
		imagenTicket = new ImageIcon("img/ticket.png");
		imagenAvion = new ImageIcon("img/avion.png");
		imagenActualizar = new ImageIcon("img/actualizar.png");
		imagenReservar = new ImageIcon("img/escribir.png");
		imagenListar = new ImageIcon("img/blocnotas.png");
		imagenUsuario = new ImageIcon("img/usuario.png");
		imagenLlave = new ImageIcon("img/llave.png");
		imagenIrAzafato = new ImageIcon("img/flecha.png");

		panelEscritorio = new JDesktopPane();
		panelEscritorio.setBackground(new Color(0, 0, 128));
		menuPrincipal = new JMenuBar();
		menuPrincipal.setBackground(Color.LIGHT_GRAY);
		menuCoches = new JMenu();
		menuCoches.setIcon(imagenPasajero);
		menuCoches.setMnemonic('P');
		
		lblDeustoAuto = new JLabel("CONCESIONARIO ADAIA");
		lblDeustoAuto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblDeustoAuto.setForeground(new Color(255, 255, 0));

		menuItemAudi = new JMenuItem();
		menuItemAudi.setIcon(imagenAniadir);
		menuItemAudi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.out.println("1");
				new VentanaCoche(hostname, port, "Audi");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemMercedes = new JMenuItem();
		menuItemMercedes.setIcon(imagenAniadir);
		menuItemMercedes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Mercedes");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemHyundai = new JMenuItem();
		menuItemHyundai.setIcon(imagenAniadir);
		menuItemHyundai.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Hyundai");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemAlfaRomeo = new JMenuItem();
		menuItemAlfaRomeo.setIcon(imagenAniadir);
		menuItemAlfaRomeo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Alfa Romeo");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemCupra = new JMenuItem();
		menuItemCupra.setIcon(imagenAniadir);
		menuItemCupra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Cupra");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemDacia = new JMenuItem();
		menuItemDacia.setIcon(imagenAniadir);
		menuItemDacia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Dacia");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemJaguar = new JMenuItem();
		menuItemJaguar.setIcon(imagenAniadir);
		menuItemJaguar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Jaguar");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemTesla = new JMenuItem();
		menuItemTesla.setIcon(imagenAniadir);
		menuItemTesla.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Tesla");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemMazda = new JMenuItem();
		menuItemMazda.setIcon(imagenAniadir);
		menuItemMazda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Mazda");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemFerrari = new JMenuItem();
		menuItemFerrari.setIcon(imagenAniadir);
		menuItemFerrari.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Ferrari");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemHonda = new JMenuItem();
		menuItemHonda.setIcon(imagenAniadir);
		menuItemHonda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
				new VentanaCoche(hostname, port, "Honda");
				System.out.println("2");
				dispose();
			}
		});
		
		menuItemBMW = new JMenuItem();
		menuItemBMW.setIcon(imagenActualizar);

		
		//menuTickets = new JMenu();
		//menuTickets.setIcon(imagenTicket);
		//menuTickets.setMnemonic('T');
		//menuItemReservarTicket = new JMenuItem();
		/*
		menuItemReservarTicket.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblDeustoAuto.setVisible(false);
				ReservarTicket r = new ReservarTicket();
				panelEscritorio.add(r);
				r.setVisible(true);
				bloquearBotones();
			}
		});
		*/
		//menuItemVerTickets = new JMenuItem();
		//menuVuelo = new JMenu();
		//menuVuelo.setMnemonic('V');
		menuEmpleados = new JMenu();
		menuEmpleados.setMnemonic('U');// alt+u para abrir menu usuario

		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1366, 768));
		setVisible(true);
		
		

		GroupLayout gl_panelEscritorio = new GroupLayout(panelEscritorio);
		gl_panelEscritorio.setHorizontalGroup(
			gl_panelEscritorio.createParallelGroup(Alignment.LEADING)
				.addGroup(Alignment.TRAILING, gl_panelEscritorio.createSequentialGroup()
					.addContainerGap(570, Short.MAX_VALUE)
					.addComponent(lblDeustoAuto, GroupLayout.PREFERRED_SIZE, 330, GroupLayout.PREFERRED_SIZE)
					.addGap(450))
		);
		gl_panelEscritorio.setVerticalGroup(
			gl_panelEscritorio.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panelEscritorio.createSequentialGroup()
					.addGap(221)
					.addComponent(lblDeustoAuto, GroupLayout.PREFERRED_SIZE, 172, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(314, Short.MAX_VALUE))
		);
		
		
		
		panelEscritorio.setLayout(gl_panelEscritorio);

		menuCoches.setText("Coches");
		
		menuItemAudi.setText("Audi");
		menuItemMercedes.setText("Mercedes");
		menuItemHyundai.setText("Hyundai");
		menuItemAlfaRomeo.setText("Alfa Romeo");
		menuItemCupra.setText("Cupra");
		menuItemDacia.setText("Dacia");
		menuItemJaguar.setText("Jaguar");
		menuItemTesla.setText("Tesla");
		menuItemMazda.setText("Mazda");
		menuItemFerrari.setText("Ferrari");
		menuItemHonda.setText("Honda");

		menuCoches.add(menuItemAudi);
		menuCoches.add(menuItemMercedes);
		menuCoches.add(menuItemHyundai);
		menuCoches.add(menuItemAlfaRomeo);
		menuCoches.add(menuItemCupra);
		menuCoches.add(menuItemDacia);
		menuCoches.add(menuItemJaguar);
		menuCoches.add(menuItemTesla);
		menuCoches.add(menuItemMazda);
		menuCoches.add(menuItemFerrari);
		menuCoches.add(menuItemHonda);

		menuItemBMW.setText("BMW");
		menuItemBMW.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
			/*	BuscarPasajero b = new BuscarPasajero();
				panelEscritorio.add(b);
				b.setVisible(true);
				bloquearBotones();*/

			}
		});
		menuCoches.add(menuItemBMW);

		menuPrincipal.add(menuCoches);

		//menuItemGestionarEquipajes = new JMenuItem();
		//menuItemGestionarEquipajes.setIcon(imagenMaleta);
		//menuItemGestionarEquipajes.setText("Gestionar equipajes");
		/*
		menuItemGestionarEquipajes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CreadorEquipajes b = new CreadorEquipajes();
				panelEscritorio.add(b);
				b.setVisible(true);
				bloquearBotones();

			}
		});
		*/
		//menuCoches.add(menuItemGestionarEquipajes);

		//menuTickets.setText("Tickets");

		//menuItemReservarTicket.setText("Reservar Ticket");
		//menuItemReservarTicket.setIcon(imagenReservar);

		//menuTickets.add(menuItemReservarTicket);

		//menuItemVerTickets.setText("Ver tickets");
		//menuItemVerTickets.setIcon(imagenListar);
		/*
		menuItemVerTickets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				VerTickets v = new VerTickets();
				panelEscritorio.add(v);
				v.setVisible(true);

				bloquearBotones();

			}

		});
		*/
		//menuTickets.add(menuItemVerTickets);

		//menuPrincipal.add(menuTickets);

		//menuVuelo.setText("Vuelo");
		//menuVuelo.setIcon(imagenAvion);

		//menuPrincipal.add(menuVuelo);

		//menuItemAnadirVuelo = new JMenuItem();
		//menuItemAnadirVuelo.setIcon(imagenAniadir);
		//menuItemAnadirVuelo.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D, InputEvent.CTRL_MASK));
		//menuItemAnadirVuelo.setText("Anadir vuelo");
		/*
		menuItemAnadirVuelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				CreadorVuelos f = new CreadorVuelos();
				panelEscritorio.add(f);
				f.setVisible(true);
				bloquearBotones();

			}
		});
		*/
		//menuVuelo.add(menuItemAnadirVuelo);

		//menuItemVerVuelos = new JMenuItem();
		//menuItemVerVuelos.setIcon(imagenListar);
		//menuItemVerVuelos.setText("Ver vuelos");
		//menuVuelo.add(menuItemVerVuelos);
		/*
		menuItemVerVuelos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				VerVuelos v = new VerVuelos();
				panelEscritorio.add(v);
				v.setVisible(true);
				bloquearBotones();
			}
		});
		*/
		menuEmpleados.setText("Empleados");
		menuEmpleados.setIcon(imagenUsuario);

		menuPrincipal.add(menuEmpleados);

		menuItemGestionarEmpleados = new JMenuItem();
		menuItemGestionarEmpleados.setIcon(imagenAzafato);
		menuItemGestionarEmpleados.setText("Gestionar empleados");
		menuEmpleados.add(menuItemGestionarEmpleados);
		menuItemGestionarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/*bloquearBotones();
				VisorAzafatos v = new VisorAzafatos();
				panelEscritorio.add(v);
				v.toFront();
				v.setVisible(true);*/

			}

		});

		menuItemCerrarSesion = new JMenuItem();
		menuItemCerrarSesion.setIcon(imagenCerrarSesion);
		menuItemCerrarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanaActual = null;
				dispose();
				new VentanaInicio(hostname, port);
			}
		});
		menuItemCerrarSesion.setText("Cerrar sesion");
		menuEmpleados.add(menuItemCerrarSesion);

		menuItemDarPermisos = new JMenuItem();
		menuItemDarPermisos.setText("Dar permisos");
		menuItemDarPermisos.setIcon(imagenLlave);
		menuEmpleados.add(menuItemDarPermisos);
		menuItemDarPermisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				/*VentanaPermisos v = new VentanaPermisos();
				panelEscritorio.add(v);
				v.setVisible(true);
				bloquearBotones();*/

			}

		});
		
		menuItemVentanaEmpleado = new JMenuItem();
		menuItemVentanaEmpleado.setText("Ventana Empleado");
		menuItemVentanaEmpleado.setIcon(imagenIrAzafato);
		menuEmpleados.add(menuItemVentanaEmpleado);
		menuItemVentanaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
				/*VentanaAzafato v = new VentanaAzafato();
				v.setVisible(true);
				bloquearBotones();*/
			
		}
		});

		setJMenuBar(menuPrincipal);
		setTitle("VENTANA ADMINISTRADOR");

		GroupLayout layout = new GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelEscritorio));
		layout.setVerticalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING).addComponent(panelEscritorio));

		pack();
	}

	/**
	 * deshabilita el menu
	 */
	public static void bloquearBotones() {

		menuCoches.setEnabled(false);
		//menuTickets.setEnabled(false);
		//menuVuelo.setEnabled(false);
		menuEmpleados.setEnabled(false);

	}

	/**
	 * habilita el menu
	 */
	public static void desbloquearBotones() {

		menuCoches.setEnabled(true);
		//menuTickets.setEnabled(true);
		//menuVuelo.setEnabled(true);
		menuEmpleados.setEnabled(true);

	}

	/**
	 * Metodo que sirve para saber si la ventana en uso es la de
	 * administrador o la de azafato
	 * 
	 * @return boolean true si la ventana es la VentanaAdministrador,false si es la ventana
	 *         VentanaAzafato
	 */
	public static boolean VentanaAdminEstaActiva() {
		if (ventanaActual == null) {
			return false;
		}

		else if (ventanaActual.isShowing() && ventanaActual != null) {
			return true;
		}
		return false;

	}
	public static JDesktopPane getPanelEscritorio() {
		return panelEscritorio;
	}
}