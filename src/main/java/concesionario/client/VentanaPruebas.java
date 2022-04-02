package concesionario.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;

public class VentanaPruebas {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaPruebas window = new VentanaPruebas();
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
	public VentanaPruebas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(255, 255, 255));
		frame.setBounds(100, 100, 315, 425);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JList listaCompras = new JList();
		listaCompras.setBackground(SystemColor.inactiveCaption);
		listaCompras.setBounds(10, 88, 283, 102);
		frame.getContentPane().add(listaCompras);
		
		JLabel titulo = new JLabel("Ventas ADAIA");
		titulo.setFont(new Font("Monospaced", Font.PLAIN, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(10, 11, 283, 66);
		frame.getContentPane().add(titulo);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBackground(new Color(255, 255, 255));
		panelInformacion.setBorder(new TitledBorder(null, "Informacion: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInformacion.setBounds(10, 201, 283, 178);
		frame.getContentPane().add(panelInformacion);
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
	}
}
