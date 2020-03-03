package interfazz;

import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class Interfaz extends JFrame implements ActionListener{
int columnas;
int filas;
int cambio;
int movimiento;
int desplazar;
	ImageIcon negra;
	ImageIcon blanca;
	JButton array[][];
	JPanel Panel;
	int n=10;
	int contador=0;
	boolean respuesta;

	public Interfaz() {
		Panel = new JPanel();
		array = new JButton[8][8];
		Panel.setLayout(new GridLayout (8,8));

		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				array[x][y]=new JButton("boton "+ x +" , " + y);
				array[x][y].addActionListener(this);
				Panel.add(array[x][y]);
			}
		}
		add(Panel);
		iniciar();

	}

	
	public void iniciar() {
		array[3][3].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
		array[3][3].setText("blancas");
		array[4][4].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
		array[4][4].setText("blancas");
		array[3][4].setIcon(new ImageIcon("src/Imagenes/negra.png"));
		array[3][4].setText("negras");
		array[4][3].setIcon(new ImageIcon("src/Imagenes/negra.png"));
		array[4][3].setText("negras");

	}


	public void actionPerformed(ActionEvent c) {
		respuesta = true;
		for(int x=0;x<8;x++) {
			for(int y=0;y<8;y++) {
				if(contador<60) {
					if(c.getSource()==array[x][y]) {

						if(((x<8) && (y<8) && (c.getActionCommand().equals("boton "+ x +" , " + y)))){
							validar(x,y,contador);
							Cambiar(x,y);
						}
						if (respuesta == true){
							JOptionPane.showMessageDialog(null, "No ingreso unas coordenadas correctas");
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


	public void validar(int x, int y, int contador){

		if((x!=0) && (y!=0) && (x!=7) && (y!=7)) {
			int g=(x-1);
			int m=(y-1);
			for(int i=(x-1);i<(g+3);i++){//revisar el alrededor de la casilla 
				for(int j=(y-1);j<(m+3);j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
		else if((x==0) && (y==0)){
			for(int i=x;i<2;i++){//revisar el alrededor de la casilla 
				for(int j=y;j<2;j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
		else if((x==0) && (y!=0)){
			int m=y;
			for(int i=(x);i<2;i++){//revisar el alrededor de la casilla 
				for(int j=(y-1);j<(m+2);j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
		else if((x!=0) && (y==0)){
			for(int i=(x-1);i<(x+2);i++){//revisar el alrededor de la casilla 
				for(int j=y;j<2;j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
		else if((x==7) && (y==7)){
			for(int i=(x-1);i<(x+1);i++){//revisar el alrededor de la casilla 
				for(int j=(y-1);j<(y+1);j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
		else if((x==7) && (y==0)){
			for(int i=6;i<8;i++){//revisar el alrededor de la casilla 
				for(int j=0;j<2;j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
		else if((x==0) && (y==7)){
			for(int i=0;i<2;i++){//revisar el alrededor de la casilla 
				for(int j=6;j<8;j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
		else if((x!=0) && (y==7)){
			for(int i=(x-1);i<(x+2);i++){//revisar el alrededor de la casilla 
				for(int j=(y-1);j<(y+1);j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
		else if((x==7) && (y!=0)){
			for(int i=(x-1);i<(x+1);i++){//revisar el alrededor de la casilla 
				for(int j=(y-1);j<(y+2);j++){//del color diferente al que esta jugando
					if((contador%2)==0) {
						if(array[i][j].getText().equals("blancas")) {
							BuscaBlancas(i,j,x,y,respuesta);
							respuesta=false;}
					}else {
						if(array[i][j].getText().equals("negras")) {
							BuscaNegras(i,j,x,y,array,respuesta);
							respuesta=false;
						}
					}
				}
			}
		}
	}


	public void BuscaBlancas(int i, int j, int x, int y, boolean respuesta) {
		if(array[i][j].getText().equals("blancas")) {
			int w=i;
			int z=j;
			while (array[w][z].getText().equals("blancas") && (w<8) && (z<8) && (w>0) && (z>0)) {
				w=w+(i-x);
				z=z+(j-y);
			}
			if (array[w][z].getText().equals("negras")) {
				contador=contador+1;
				array[x][y].setText("negras");
				array[x][y].setIcon(new ImageIcon("src/Imagenes/negra.png"));

			}
			else {
				JOptionPane.showMessageDialog(null, "No ingreso unas coordenadas correctas de juego");
			}
		}
	}


	public void BuscaNegras(int i, int j, int x, int y, JButton array[][], boolean respuesta) {
		if(array[i][j].getText().equals("negras")) {
			int w=i;
			int z=j;
			while (array[w][z].getText().equals("negras") && (w<8) && (z<8) && (w>0) && (z>0)) {
				w=w+(i-x);
				z=z+(j-y);
			}
			if (array[w][z].getText().equals("blancas")) {
				contador=contador+1;
				array[x][y].setText("blancas");
				array[x][y].setIcon(new ImageIcon("src/Imagenes/blanca.png"));

			}
			else {
				JOptionPane.showMessageDialog(null, "No ingreso unas coordenadas correctas de juego");
			}

		}
	}


	public void Cambiar(int x, int y) {

		if(array[x][y].getText().equals("negras")) {

			if(array[x][y+1].getText().equals("blancas")) {
				columnas=y+1;

				do {
					if(array[x][columnas].getText().equals("negras")) {
						cambio=1;
						movimiento=1;
					}

					if(array[x][columnas].getText().equals("blancas")) {
						columnas++;
						desplazar++;
					}
					if((array[x][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y+1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[x][columnas].setIcon(new ImageIcon("src/Imagenes/negra.png"));
						columnas++;
					}
				}
			}

			movimiento=0;
			desplazar=0;

			if(array[x][y-1].getText().equals("blancas")) {
				columnas=y-1;

				do {
					if(array[x][columnas].getText().equals("negras")) {
						cambio=1;
						movimiento=1;
					}

					if(array[x][columnas].getText().equals("blancas")) {
						columnas++;
						desplazar++;
					}
					if((array[x][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y-1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[x][columnas].setIcon(new ImageIcon("src/Imagenes/negra.png"));
						columnas++;
					}
				}
			}
			movimiento=0;
			desplazar=0;
			if(array[x+1][y+1].getText().equals("blancas")) {
				columnas=y+1;
				filas=x+1;
				do {
					if(array[filas][columnas].getText().equals("negras")) {
						cambio=1;
						movimiento=1;
					}

					if(array[filas][columnas].getText().equals("blancas")) {
						columnas++;
						filas++;
						desplazar++;
					}
					if((array[filas][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y+1;
				filas=x+1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[filas][columnas].setIcon(new ImageIcon("src/Imagenes/negra.png"));
						columnas++;
						filas++;
					}
				}
			}
			movimiento=0;
			desplazar=0;
			if(array[x-1][y+1].getText().equals("blancas")) {
				columnas=y+1;
				filas=x-1;
				do {
					if(array[filas][columnas].getText().equals("negras")) {
						cambio=1;
						movimiento=1;
					}

					if(array[filas][columnas].getText().equals("blancas")) {
						columnas++;
						filas++;
						desplazar++;
					}
					if((array[filas][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y+1;
				filas=x-1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[filas][columnas].setIcon(new ImageIcon("src/Imagenes/negra.png"));
						columnas++;
						filas++;
					}
				}
			}
			movimiento=0;
			desplazar=0;
			if(array[x-1][y-1].getText().equals("blancas")) {
				columnas=y-1;
				filas=x-1;
				do {
					if(array[filas][columnas].getText().equals("negras")) {
						cambio=1;
						movimiento=1;
					}

					if(array[filas][columnas].getText().equals("blancas")) {
						columnas++;
						filas++;
						desplazar++;
					}
					if((array[filas][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y-1;
				filas=x-1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[filas][columnas].setIcon(new ImageIcon("src/Imagenes/negra.png"));
						columnas++;
						filas++;
					}
				}
			}
			movimiento=0;
			desplazar=0;
			if(array[x+1][y-1].getText().equals("blancas")) {
				columnas=y-1;
				filas=x+1;
				do {
					if(array[filas][columnas].getText().equals("negras")) {
						cambio=1;
						movimiento=1;
					}

					if(array[filas][columnas].getText().equals("blancas")) {
						columnas++;
						filas++;
						desplazar++;
					}
					if((array[filas][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y-1;
				filas=x+1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[filas][columnas].setIcon(new ImageIcon("src/Imagenes/negra.png"));
						columnas++;
						filas++;
					}
				}
			}
		}
		
//////////////////////////////////////////////////////////////////////////////////////
		
		if(array[x][y].getText().equals("blancas")) {

			if(array[x][y+1].getText().equals("negras")) {
				columnas=y+1;

				do {
					if(array[x][columnas].getText().equals("blancas")) {
						cambio=1;
						movimiento=1;
					}

					if(array[x][columnas].getText().equals("negras")) {
						columnas++;
						desplazar++;
					}
					if((array[x][columnas].getText().equals("negras")==false)&&(array[x][columnas].getText().equals("blancas")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y+1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[x][columnas].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
						columnas++;
					}
				}
			}

			movimiento=0;
			desplazar=0;

			if(array[x][y-1].getText().equals("negras")) {
				columnas=y-1;

				do {
					if(array[x][columnas].getText().equals("blancas")) {
						cambio=1;
						movimiento=1;
					}

					if(array[x][columnas].getText().equals("negras")) {
						columnas++;
						desplazar++;
					}
					if((array[x][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y-1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[x][columnas].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
						columnas++;
					}
				}
			}
			movimiento=0;
			desplazar=0;
			if(array[x+1][y+1].getText().equals("negras")) {
				columnas=y+1;
				filas=x+1;
				do {
					if(array[filas][columnas].getText().equals("blancas")) {
						cambio=1;
						movimiento=1;
					}

					if(array[filas][columnas].getText().equals("negras")) {
						columnas++;
						filas++;
						desplazar++;
					}
					if((array[filas][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y+1;
				filas=x+1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[filas][columnas].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
						columnas++;
						filas++;
					}
				}
			}
			movimiento=0;
			desplazar=0;
			if(array[x-1][y+1].getText().equals("negras")) {
				columnas=y+1;
				filas=x-1;
				do {
					if(array[filas][columnas].getText().equals("blancas")) {
						cambio=1;
						movimiento=1;
					}

					if(array[filas][columnas].getText().equals("negras")) {
						columnas++;
						filas++;
						desplazar++;
					}
					if((array[filas][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y+1;
				filas=x-1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[filas][columnas].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
						columnas++;
						filas++;
					}
				}
			}
			movimiento=0;
			desplazar=0;
			if(array[x-1][y-1].getText().equals("negras")) {
				columnas=y-1;
				filas=x-1;
				do {
					if(array[filas][columnas].getText().equals("blancas")) {
						cambio=1;
						movimiento=1;
					}

					if(array[filas][columnas].getText().equals("negras")) {
						columnas++;
						filas++;
						desplazar++;
					}
					if((array[filas][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y-1;
				filas=x-1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[filas][columnas].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
						columnas++;
						filas++;
					}
				}
			}
			movimiento=0;
			desplazar=0;
			if(array[x+1][y-1].getText().equals("negras")) {
				columnas=y-1;
				filas=x+1;
				do {
					if(array[filas][columnas].getText().equals("blancas")) {
						cambio=1;
						movimiento=1;
					}

					if(array[filas][columnas].getText().equals("negras")) {
						columnas++;
						filas++;
						desplazar++;
					}
					if((array[filas][columnas].getText().equals("blancas")==false)&&(array[x][columnas].getText().equals("negras")==false))/*Aqui esta el problema de que no se iguala a los espacios vacios	*/	 {
						movimiento=2;
					}


				}while(movimiento==0);

				columnas=y-1;
				filas=x+1;
				if(cambio==1) {
					for(int i=0; i<desplazar; i++) {
						array[filas][columnas].setIcon(new ImageIcon("src/Imagenes/blanca.png"));
						columnas++;
						filas++;
					}
				}
			}
		}
		
		
	}


	
	
	public JButton[][] getArray() {
		return array;
	}


	public void setArray(JButton[][] array) {
		this.array = array;
	}

}

