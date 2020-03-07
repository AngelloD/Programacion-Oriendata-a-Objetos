package Othelo;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Interfaz extends JFrame implements ActionListener{

	//Atributos
	int puntaje1;
	int puntaje2;
	JPanel Panel;
	JButton array[][];
	ImageIcon negra;
	ImageIcon blanca;

	//Variables globales
	boolean a=true;//lleva los turnos
	int contador=0;//leva los turnos y el numero de jugadas

	//Objetos de otras clases
	Inicio logica3 = new Inicio();
	Validacion logica1 = new Validacion();



	public Interfaz() {//Metodo Constructor
		
		Panel = new JPanel();
		array = new JButton[8][8];
		Panel.setLayout(new GridLayout (8,8));
		try {

			for(int x=0;x<8;x++) {
				for(int y=0;y<8;y++) {
					array[x][y]=new JButton("boton "+ x +" , " + y);
					array[x][y].addActionListener(this);
					Panel.add(array[x][y]);
				}
			}
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error desde el constructor de la interfaz "+e.toString());
		}
		add(Panel);
		logica3.iniciar(array);

	}

	public void actionPerformed(ActionEvent c) {
		int h=0;
	int f=0;
		primerpanel p1= new primerpanel();
		try {
			for(int x=0;x<8;x++) {
				for(int y=0;y<8;y++) {

					if(contador<60) {
						if(c.getSource()==array[x][y]) {
							if(((x<8) && (y<8) && (c.getActionCommand().equals("boton "+ x +" , " + y)))){
								a=logica1.validar(a, x, y, contador, array);
								if(a==false) {
									contador=contador+1;
								}
								else if (a == true){
									JOptionPane.showMessageDialog(null, "No ingreso unas coordenadas correctas");
								}
								a=true;
								
							
							}
						}
					}
					else {
					
							
							for(int e=0;e<8;e++){
								for(int o=0;o<8;o++){

									if(array[e][o].getText().equals("negras")){
										h++;
										}
									else 
										if(array[e][o].getText().equals("blancas")){
										f++;
										}
									
								
							}
							
						}
						
						
							
							JOptionPane.showMessageDialog(null,"El puntaje de el jugador de las negras es "+h + " y  El puntaje de el jugador de las blancas es "+f );
							JOptionPane.showMessageDialog(null, "Fin del juego"); 
							System.exit(0);
					
					}
					
				}
			}
			
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error desde la toma de la jugada "+e.toString());
		}

	}

}

