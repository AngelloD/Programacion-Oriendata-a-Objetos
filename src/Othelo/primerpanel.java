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
	PrintWriter escribir;
	boolean abrir =true;
	String nombre2;
	String nombre1;
	private JPanel contentPane;
	boolean jugar2;

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
						System.out.print(datos.getName()+ "Ha sido creado");
					}catch(IOException ex) {
						ex.printStackTrace();
					}
				}else {
				try {
					escribir = new PrintWriter(datos,"utf-8");
					
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
				nombre1= JOptionPane.showInputDialog(null,"Nombre del jugador 1 (Negras)");
escribir.println("El jugador de las fichas negras es "+ nombre1);

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
			nombre2= JOptionPane.showInputDialog(null,"Nombre del jugador 2 (Blancas)");
			escribir.println("El jugador de las fichas blancas es "+ nombre2);
escribir.close();
			}
		});
			contentPane.add(button, BorderLayout.EAST);
			
	}
	public boolean isjugar2(){return this.jugar2;}

	public void setjugar2(boolean active){this.jugar2 = active;}

}
