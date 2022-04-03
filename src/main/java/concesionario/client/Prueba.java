package concesionario.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import java.awt.SystemColor;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

public class Prueba {

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
					Prueba window = new Prueba();
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
	public Prueba() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 291, 394);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metodo de pago");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 258, 44);
		frame.getContentPane().add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(22, 311, 112, 23);
		frame.getContentPane().add(btnCancelar);
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.BLACK);
		btnPagar.setForeground(Color.WHITE);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPagar.setBounds(144, 311, 112, 23);
		frame.getContentPane().add(btnPagar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setForeground(Color.BLACK);
		horizontalStrut.setBounds(10, 61, 258, 6);
		frame.getContentPane().add(horizontalStrut);
		
		JButton btnPayPal = new JButton("PayPal");
		btnPayPal.setBackground(SystemColor.textHighlight);
		btnPayPal.setForeground(Color.WHITE);
		btnPayPal.setBounds(10, 86, 124, 23);
		frame.getContentPane().add(btnPayPal);
		
		JButton btnBizum = new JButton("Bizum Pay");
		btnBizum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBizum.setForeground(Color.WHITE);
		btnBizum.setBackground(new Color(60, 179, 113));
		btnBizum.setBounds(144, 86, 125, 23);
		frame.getContentPane().add(btnBizum);
		
		JButton btnApplePay = new JButton("Apple Pay");
		btnApplePay.setForeground(SystemColor.infoText);
		btnApplePay.setBackground(SystemColor.window);
		btnApplePay.setBounds(10, 120, 124, 23);
		frame.getContentPane().add(btnApplePay);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tarjeta de credito: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 169, 259, 178);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Nº de tarjeta");
		lblNewLabel_1.setBounds(10, 30, 239, 14);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setBackground(Color.WHITE);
		
		textField = new JTextField();
		textField.setBounds(10, 48, 239, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("CVV");
		lblNewLabel_2.setBounds(10, 79, 124, 14);
		panel.add(lblNewLabel_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(10, 93, 50, 20);
		panel.add(textField_1);
		textField_1.setColumns(10);
	}
}
