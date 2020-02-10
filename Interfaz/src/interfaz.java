import javax.swing.*;
import java.awt.event.*;
public class interfaz extends JFrame implements ActionListener {
JButton boton1;

public interfaz() {
	
	setLayout(null);
	boton1= new JButton("Aceptar");
	boton1.setBounds(300, 250, 100, 30);
	add(boton1);
	boton1.addActionListener(this);
}

public JButton getBoton1() {
	return boton1;
}

public void setBoton1(JButton boton1) {
	this.boton1 = boton1;
}
public void actionPerformed(ActionEvent c) {
	
	if(c.getSource()==boton1) {
		
		System.exit(0);
		

}








}
}
