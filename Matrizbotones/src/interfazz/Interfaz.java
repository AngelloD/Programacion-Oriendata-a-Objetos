package interfazz;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class Interfaz extends JFrame implements ActionListener{
 
	JButton array[][];
	JButton boton1;
	JPanel Panel;
	JButton boton2;
	JButton boton3;
	JButton boton4;
	
	public Interfaz() {
	
		Panel = new JPanel();
		
		array = new JButton[4][4];
		Panel.setLayout(new GridLayout (4,4));
		for(int i=0;i<4;i++) {
			for(int j=0; j<4; j++ ) {
			array[i][j]=new JButton("boton"+ i+ ", "+j);
			array[i][j].addActionListener(this);
			Panel.add(array[i][j]);
		}
		}
		add(Panel);
}
		

		
	

	
	public void actionPerformed(ActionEvent c) {
		for(int i=0; i<4; i++ ) {
			for(int j=0; j<4; j++) {
				if(c.getSource()==array[i][j]) {
					JOptionPane.showConfirmDialog(array[i][j], "¡Pulso el boton "+i+", "+j);
					if(c.getSource()==array[i][j]) {
						array[i][j].setIcon(new ImageIcon(("src/Imagenes/boton1.png")));
					}
				}
			}
			
		}
		
		
	}

	
	
	
	
	
	
	
}
