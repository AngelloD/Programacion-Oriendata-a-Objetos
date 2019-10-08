
package objeto;
import java.applet.*;
import java.util.ArrayList;

import javax.swing.JOptionPane;
public class objeto {
	
	public static void main(String args[]) {

	/*	
		Object[]arregloObjetos=new Object[10];
		arregloObjetos[0]=new JOptionPane();
		arregloObjetos[1]= new Applet();
		arregloObjetos[2]=2;
		arregloObjetos[3]=new Integer(2);
		
		((JOptionPane)arregloObjetos[0]).showMessageDialog(null, arregloObjetos[2]);
		*/
		ArrayList lista=new ArrayList();
		
		lista.add(new JOptionPane());
		JOptionPane ventana= new JOptionPane();
		lista.add(ventana);
	    lista.add(new Applet());
	    lista.add(2);
	    
	    ((JOptionPane)lista.get(0)).showMessageDialog(null, lista.get(3));
}
}