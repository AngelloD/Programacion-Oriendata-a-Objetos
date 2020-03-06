package Othelo;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class Interfaz extends JFrame implements ActionListener{

	//Atributos
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

