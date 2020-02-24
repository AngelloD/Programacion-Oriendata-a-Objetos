package interfazz;
import java.awt.*;
import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class Interfaz extends JFrame implements ActionListener{
 
	String botones[][];
	JButton estados[][];
	JPanel Panel;
	
	
	public Interfaz() {
	
		Panel = new JPanel();
		botones = new String[4][4];
		estados = new JButton[4][4];
		Panel.setLayout(new GridLayout (4,4));
		for(int i=0;i<4;i++) {
			for(int j=0; j<4; j++ ) {
			estados[i][j]=new JButton("boton"+ i+ ", "+j);
			estados[i][j].addActionListener(this);
			Panel.add(estados[i][j]);
		}
		}
		add(Panel);
}
		

		

	
	public void actionPerformed(ActionEvent c) {
		for(int i=0; i<4; i++ ) {
			for(int j=0; j<4; j++) {
				if(c.getSource()==estados[i][j]) {
					JOptionPane.showConfirmDialog(estados[i][j], "¡Pulso el boton "+i+", "+j);
					if(c.getSource()==estados[i][j]) {
						botones[i][j]="b";
					}
					
				}
				if(botones[i][j].equals("n")) {
					estados[i][j].setIcon(new ImageIcon(("src/Imagenes/botonnegro.png")));
				}
				else {
					estados[i][j].setIcon(new ImageIcon(("src/Imagenes/botonblanco.png")));
				}
				
				
				
				
			}
			
		}
		
		
	}

	
	
	
	
	
	
	
}
