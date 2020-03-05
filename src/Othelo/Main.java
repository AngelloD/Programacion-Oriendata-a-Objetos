package Othelo;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class Main {
	public static void main (String arg[]) {
		primerpanel p1= new primerpanel();
		primerpanel.main(String[].class);

		try {
		
			Interfaz tablero = new Interfaz();
			tablero.setBounds(200,0,1000,1000);
			tablero.setVisible(true);
			
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null, "Error desde el main "+e.toString());

		}
		
	
		
		
	}

}