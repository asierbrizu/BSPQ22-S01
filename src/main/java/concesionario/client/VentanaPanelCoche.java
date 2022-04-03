package concesionario.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import concesionario.clases.Coche;

public class VentanaPanelCoche extends JPanel{
	
	public VentanaPanelCoche(Coche coche){

		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		add(panel_1, BorderLayout.SOUTH);
		
		JButton btnIzquierda = new JButton("<");
		btnIzquierda.setBackground(Color.BLACK);
		btnIzquierda.setForeground(Color.WHITE);
		btnIzquierda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(btnIzquierda);
		
		JButton btnComprar = new JButton("Comprar");
		btnComprar.setBackground(Color.BLACK);
		btnComprar.setForeground(Color.WHITE);
		panel_1.add(btnComprar);
		
		JButton btnDerecha = new JButton(">");
		btnDerecha.setBackground(Color.BLACK);
		btnDerecha.setForeground(Color.WHITE);
		panel_1.add(btnDerecha);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel(coche.getModelo());
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("img/"+ coche.getMarca() + "-" + coche.getModelo() +".png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1, BorderLayout.CENTER);
		
		setVisible(true);
		
	}
}
