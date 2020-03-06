package Othelo;
import java.io.*;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Archivos  {
	
	PrintWriter escribir;
	public void Archivos() {
		
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
	
	}
	
}
