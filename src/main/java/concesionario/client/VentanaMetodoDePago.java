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

import concesionario.clases.Coche;

public class VentanaMetodoDePago extends JFrame{

	private JTextField textField;
	private JTextField textField_1;



	public VentanaMetodoDePago(Coche coche) {
		getContentPane().setBackground(Color.WHITE);
		setBounds(100, 100, 291, 394);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Metodo de pago");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 22));
		lblNewLabel.setBounds(10, 11, 258, 44);
		getContentPane().add(lblNewLabel);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setBackground(Color.BLACK);
		btnCancelar.setForeground(Color.WHITE);
		btnCancelar.setBounds(22, 311, 112, 23);
		getContentPane().add(btnCancelar);
		btnCancelar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				
			}
		});
		
		JButton btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.BLACK);
		btnPagar.setForeground(Color.WHITE);
		btnPagar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnPagar.setBounds(144, 311, 112, 23);
		getContentPane().add(btnPagar);
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		horizontalStrut.setForeground(Color.BLACK);
		horizontalStrut.setBounds(10, 61, 258, 6);
		getContentPane().add(horizontalStrut);
		
		JButton btnPayPal = new JButton("PayPal");
		btnPayPal.setBackground(SystemColor.textHighlight);
		btnPayPal.setForeground(Color.WHITE);
		btnPayPal.setBounds(10, 86, 124, 23);
		getContentPane().add(btnPayPal);
		
		JButton btnBizum = new JButton("Bizum Pay");
		btnBizum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBizum.setForeground(Color.WHITE);
		btnBizum.setBackground(new Color(60, 179, 113));
		btnBizum.setBounds(144, 86, 125, 23);
		getContentPane().add(btnBizum);
		
		JButton btnApplePay = new JButton("Apple Pay");
		btnApplePay.setForeground(SystemColor.infoText);
		btnApplePay.setBackground(SystemColor.window);
		btnApplePay.setBounds(10, 120, 124, 23);
		getContentPane().add(btnApplePay);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Tarjeta de credito: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 169, 259, 178);
		getContentPane().add(panel);
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
		
		setVisible(true);
	}
	
}
