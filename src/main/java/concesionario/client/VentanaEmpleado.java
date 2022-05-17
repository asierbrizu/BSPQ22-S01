package concesionario.client;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;

public class VentanaEmpleado extends JFrame{
	static JPanel panelPrincipal;
	private JMenuBar menuPrincipal;
	public static JLabel lblDeustoAuto;
	private static JMenu volverInicio;
	private static JMenu listaMecanicos;
	private static JMenu listaEmpleados;

	public VentanaEmpleado(){
		setLayout(new GridLayout(1,1));

		panelPrincipal = new JPanel();
		panelPrincipal.setBackground(Color.WHITE);
		add(panelPrincipal);

		menuPrincipal = new JMenuBar();
		menuPrincipal.setBackground(Color.LIGHT_GRAY);
		listaMecanicos = new JMenu();
		listaMecanicos.setMnemonic('C');

		listaEmpleados = new JMenu();
		listaEmpleados.setMnemonic('U');

		volverInicio = new JMenu();
		volverInicio.setMnemonic('I');

		lblDeustoAuto = new JLabel("CONCESIONARIO ADAIA");
		lblDeustoAuto.setFont(new Font("Tw Cen MT Condensed Extra Bold", Font.PLAIN, 36));
		lblDeustoAuto.setForeground(new Color(255, 255, 0));

		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setPreferredSize(new Dimension(1366, 815));
		setVisible(true);

		listaMecanicos.setText("Lista Mecanicos");
		menuPrincipal.add(listaMecanicos);

		listaEmpleados.setText("Lista Empleados");
		menuPrincipal.add(listaEmpleados);

		volverInicio.setText("Volver Inicio");
		menuPrincipal.add(volverInicio);

		volverInicio.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt) {
				dispose();
				//new VentanaRRHH();

			}
		});

		setJMenuBar(menuPrincipal);
		setTitle("VENTANA RRHH");


		pack();
		setExtendedState(JFrame.MAXIMIZED_BOTH);

	}
}
