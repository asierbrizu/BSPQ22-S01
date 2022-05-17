package concesionario.client;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.TitledBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import concesionario.clases.Coche;
import concesionario.util.CompraException;

public class VentanaMetodoDePago extends JFrame{

	private JTextField textField;
	private JTextField textField_1;
	private JButton btnPagar;



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
		
		btnPagar = new JButton("Pagar");
		btnPagar.setBackground(Color.BLACK);
		btnPagar.setForeground(Color.WHITE);
		btnPagar.addActionListener(new ActionListener() {
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
		btnPagar.setBounds(144, 311, 112, 23);
		btnPagar.setEnabled(false);
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
		btnPayPal.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();
				new VentanaPayPal(coche);
				
			}
		});
		
		JButton btnBizum = new JButton("Bizum Pay");
		btnBizum.setForeground(Color.WHITE);
		btnBizum.setBackground(new Color(60, 179, 113));
		btnBizum.setBounds(144, 86, 125, 23);
		getContentPane().add(btnBizum);
		btnBizum.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		
		JButton btnApplePay = new JButton("Apple Pay");
		btnApplePay.setForeground(SystemColor.infoText);
		btnApplePay.setBackground(SystemColor.window);
		btnApplePay.setBounds(10, 120, 124, 23);
		getContentPane().add(btnApplePay);
		btnApplePay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				new VentanaApplePay(coche);
				dispose();
				
			}
		});
		
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
		
		textField.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkTarjeta();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkTarjeta();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				checkTarjeta();
				
			}
		});
		
		textField_1.getDocument().addDocumentListener(new DocumentListener() {
			
			@Override
			public void removeUpdate(DocumentEvent e) {
				checkTarjeta();
				
			}
			
			@Override
			public void insertUpdate(DocumentEvent e) {
				checkTarjeta();
				
			}
			
			@Override
			public void changedUpdate(DocumentEvent e) {
				checkTarjeta();
				
			}
		});
		
		setVisible(true);
	}
	
	
	
	
	public void checkTarjeta(){
		if(textField.getText().length() == 16 && textField_1.getText().length() == 3){
			btnPagar.setEnabled(true);
		} else {
			btnPagar.setEnabled(false);
		}
	}
	
}
