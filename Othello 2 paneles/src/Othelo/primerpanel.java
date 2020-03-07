package Othelo;
import java.io.*;
import java.awt.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Button;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;import java.awt.Font;
import java.awt.Frame;

public class primerpanel extends JFrame {
	PrintWriter imprimir;
	boolean abrir =true;
	String nombre2;
	String nombre1;
	private JPanel contentPane;
	boolean jugar2;
	FileWriter escribir;
	/**
	 * Launch the application.
	 */
	public static void main(Class<String[]> class1) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					primerpanel frame = new primerpanel();
					frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public primerpanel() {



		File datos=new File("Puntuaciones_nombres.txt");
		if(!datos.exists()){
			try {
				datos.createNewFile();

			}catch(IOException ex) {
				ex.printStackTrace();
			}
		}else {
			try {

			} catch (Exception e) {
				e.printStackTrace();
			} 


		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);

		Button button_2 = new Button("\u00A1Jugar!");
		button_2.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent c){
				abrir=false;

				addMouseListener(this);
				setVisible(false);

			}

			public boolean iniciar() {
				jugar2=abrir;
				return jugar2;
			}
		});
		contentPane.add(button_2, BorderLayout.SOUTH);

		Button button_1 = new Button("Jugador 1");
		button_1.addActionListener(new ActionListener() { 


			public void actionPerformed(ActionEvent c) {


				try {
					nombre1= JOptionPane.showInputDialog(null,"Nombre del jugador 1 (Negras)");
					escribir= new FileWriter(datos, true);
					imprimir= new PrintWriter(escribir);
					imprimir.println("El jugador de las fichas negras es "+nombre1);
					imprimir.close();
					escribir.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});
		button_1.addMouseListener(new MouseAdapter() {

			public void mouseClicked(MouseEvent arg0) {
			}
		});
		contentPane.add(button_1, BorderLayout.WEST);

		Button button = new Button("Jugador 2");
		button.setActionCommand("Jugador 2");
		button.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent c) {
				try {
					nombre2= JOptionPane.showInputDialog(null,"Nombre del jugador 1 (Blancas)");
					escribir= new FileWriter(datos, true);
					imprimir= new PrintWriter(escribir);
					imprimir.println("El jugador de las fichas blancas es "+nombre2);
					imprimir.close();
					escribir.close();
				} catch (IOException e) {
					e.printStackTrace();
				}


			}
		});
		contentPane.add(button, BorderLayout.EAST);

	}

	public String getNombre2() {
		return nombre2;
	}

	public void setNombre2(String nombre2) {
		this.nombre2 = nombre2;
	}

	public String getNombre1() {
		return nombre1;
	}

	public void setNombre1(String nombre1) {
		this.nombre1 = nombre1;
	}


}
