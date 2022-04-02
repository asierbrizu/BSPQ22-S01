package concesionario.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;

public class VentanaComprasServer extends JFrame {
	

	public VentanaComprasServer() {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 315, 425);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JList listaCompras = new JList();
		listaCompras.setBackground(SystemColor.inactiveCaption);
		listaCompras.setBounds(10, 76, 283, 114);
		getContentPane().add(listaCompras);
		
		JLabel titulo = new JLabel("Compras realizadas");
		titulo.setFont(new Font("Trebuchet MS", Font.PLAIN, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(10, 11, 283, 57);
		getContentPane().add(titulo);
		
		JPanel panelInformacion = new JPanel();
		panelInformacion.setBackground(new Color(255, 255, 255));
		panelInformacion.setBorder(new TitledBorder(null, "Informacion: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInformacion.setBounds(10, 201, 283, 178);
		getContentPane().add(panelInformacion);
	}
}


