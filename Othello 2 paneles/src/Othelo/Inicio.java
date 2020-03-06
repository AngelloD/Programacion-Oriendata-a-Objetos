package Othelo;

import javax.swing.*;


public class Inicio {

	public void iniciar( JButton array[][] ) {
		try {
			array[3][3].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
			array[3][3].setText("blancas");
			array[4][4].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
			array[4][4].setText("blancas");
			array[3][4].setIcon(new ImageIcon("src/Imagenes/negra.png"));
			array[3][4].setText("negras");
			array[4][3].setIcon(new ImageIcon("src/Imagenes/negra.png"));
			array[4][3].setText("negras");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, "Error desde el iniciar "+e.toString());
		}

	}


}
