package concesionario.client;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.ImageIcon;
import java.awt.Font;

public class Prueba {

	private JFrame frame;

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
		frame.getContentPane().setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel.add(panel_1, BorderLayout.SOUTH);
		
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
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblNewLabel = new JLabel("NOMBRECOCHE");
		lblNewLabel.setFont(new Font("Monospaced", Font.PLAIN, 25));
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel, BorderLayout.NORTH);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\ikermorales\\BSPQ22-S01\\img\\Tesla-S.png"));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_2.add(lblNewLabel_1, BorderLayout.CENTER);
		frame.setBounds(100, 100, 450, 428);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

}
