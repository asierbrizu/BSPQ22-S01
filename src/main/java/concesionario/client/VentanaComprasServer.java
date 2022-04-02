package concesionario.client;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.util.ArrayList;
import java.util.HashMap;
import java.awt.*;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import concesionario.clases.Cliente;
import concesionario.clases.Compra;

public class VentanaComprasServer extends JFrame {
	
	private JPanel panelInformacion;
	private JList listaCompras;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private HashMap<String, Compra> hashCompras;
	

	public VentanaComprasServer(ArrayList<Compra> compras) {
		getContentPane().setBackground(new Color(255, 255, 255));
		setBounds(100, 100, 315, 425);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
//		String[] compras = new String[7];
//		compras[0] ="patata";
//		compras[1]= "maiz";
//		compras[2]= "repollo";
//		compras[3]= "audi";
//		compras[4]= "bmw";
//		compras[5]= "alfa romero";
//		compras[6]= "bmw";
		
		String[] arrayParaLaJList = new String[compras.size()];
		hashCompras = new HashMap<>();
		int i = 0;
		for (Compra compra : compras) {
			arrayParaLaJList[i] = compra.getId();
			hashCompras.put(compra.getId(), compra);
			i++;
		}
		
		
		listaCompras = new JList(arrayParaLaJList);
		listaCompras.setBackground(SystemColor.inactiveCaption);
		listaCompras.setBounds(10, 88, 283, 102);
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 88, 283, 102);
		scrollPane.setViewportView(listaCompras);
		getContentPane().add(scrollPane);
		
		listaCompras.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()) {
//						panelInformacion.add(new JLabel(listaCompras.getSelectedValue().toString()));
						textField.setText(hashCompras.get(listaCompras.getSelectedValue()).getId());
						textField_1.setText(hashCompras.get(listaCompras.getSelectedValue()).getMatricula());
						textField_2.setText(hashCompras.get(listaCompras.getSelectedValue()).getCliente().getNombre() + " " + hashCompras.get(listaCompras.getSelectedValue()).getCliente().getApellido());
						textField_3.setText(hashCompras.get(listaCompras.getSelectedValue()).getFecha());
						repaint();
						validate();
	                }
			}
		});
		
		JLabel titulo = new JLabel("Ventas ADAIA");
		titulo.setFont(new Font("Monospaced", Font.PLAIN, 24));
		titulo.setHorizontalAlignment(SwingConstants.CENTER);
		titulo.setBounds(10, 11, 283, 66);
		getContentPane().add(titulo);
		
		
		panelInformacion = new JPanel();
		panelInformacion.setBackground(new Color(255, 255, 255));
		panelInformacion.setBorder(new TitledBorder(null, "Informacion: ", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelInformacion.setBounds(10, 201, 283, 178);
		getContentPane().add(panelInformacion);
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
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		ArrayList<Compra> compras = new ArrayList<>();
		compras.add(new Compra("12343", new Cliente(), "5143LMV", "28/10/2021"));
		compras.add(new Compra("23355", new Cliente(), "5143LMV", "29/10/2021"));
		compras.add(new Compra("65454", new Cliente(), "5143LMV", "27/10/2021"));
		compras.add(new Compra("23456", new Cliente(), "5143LMV", "26/10/2021"));
		compras.add(new Compra("65432", new Cliente(), "5143LMV", "25/10/2021"));
		compras.add(new Compra("65432", new Cliente(), "5143LMV", "24/10/2021"));
		compras.add(new Compra("76543", new Cliente(), "5143LMV", "23/10/2021"));
		new VentanaComprasServer(compras);
	}
	
}


