package concesionario.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;
import java.awt.Font;
import javax.swing.JTextField;

public class VentanaPrueba {

	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;

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
		frame.getContentPane().setForeground(Color.BLACK);
		frame.setBounds(100, 100, 563, 443);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(Color.WHITE);
		panel.setBackground(Color.BLACK);
		panel.setBounds(65, 58, 197, 281);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel icono = new JLabel("");
		icono.setBackground(Color.BLACK);
		icono.setIcon(new ImageIcon("C:\\Users\\ikermorales\\BSPQ22-S01\\resources\\img\\empleado.png"));
		icono.setHorizontalAlignment(SwingConstants.CENTER);
		icono.setForeground(Color.WHITE);
		icono.setBounds(10, 11, 177, 107);
		panel.add(icono);
		
		JLabel labelNombreApellido = new JLabel("Nombre Apellido");
		labelNombreApellido.setFont(new Font("Consolas", Font.PLAIN, 13));
		labelNombreApellido.setBackground(Color.BLACK);
		labelNombreApellido.setForeground(Color.WHITE);
		labelNombreApellido.setHorizontalAlignment(SwingConstants.CENTER);
		labelNombreApellido.setBounds(20, 129, 167, 14);
		panel.add(labelNombreApellido);
		
		textField = new JTextField();
		textField.setBounds(10, 196, 177, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(10, 246, 177, 20);
		panel.add(textField_1);
		
		JLabel lblNewLabel = new JLabel("DNI");
		lblNewLabel.setBackground(Color.BLACK);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBounds(10, 177, 177, 14);
		panel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email:");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Color.BLACK);
		lblNewLabel_1.setBounds(10, 227, 177, 14);
		panel.add(lblNewLabel_1);
	}
}
