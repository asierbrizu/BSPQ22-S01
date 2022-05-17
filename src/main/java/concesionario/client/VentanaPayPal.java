package concesionario.client;

import javax.swing.JFrame;
import java.awt.EventQueue;
import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;

import concesionario.clases.Coche;
import concesionario.util.CompraException;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class VentanaPayPal extends JFrame {

	private JTextField textField;
	private JPasswordField passwordField;


	public VentanaPayPal(Coche coche) {
		getContentPane().setBackground(Color.WHITE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PayPal");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 26));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 11, 318, 54);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Email: ");
		lblNewLabel_1.setBounds(20, 86, 48, 14);
		getContentPane().add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(10, 103, 318, 25);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password: ");
		lblNewLabel_1_1.setBounds(20, 139, 105, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(10, 153, 318, 25);
		getContentPane().add(passwordField);
		
		JButton btnNewButton_1 = new JButton("Pagar con PayPal");
		btnNewButton_1.setBackground(new Color(65, 105, 225));
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBounds(171, 203, 157, 24);
		getContentPane().add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					VentanaInicio.comprarCoche(coche);
					JOptionPane.showMessageDialog( null, "Coche comprado.  Revisa tu cuenta bancaria.", 
	                        "Compra realizada", JOptionPane.INFORMATION_MESSAGE);
					dispose();
				} catch (CompraException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnNewButton_1_1 = new JButton("Volver");
		btnNewButton_1_1.setForeground(Color.WHITE);
		btnNewButton_1_1.setBackground(new Color(0, 0, 0));
		btnNewButton_1_1.setBounds(10, 204, 157, 24);
		getContentPane().add(btnNewButton_1_1);
		setBounds(100, 100, 350, 281);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		btnNewButton_1_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaMetodoDePago(coche);
				dispose();
				
			}
		});
		
		setVisible(true);
		setLocationRelativeTo(null);
	}
}
