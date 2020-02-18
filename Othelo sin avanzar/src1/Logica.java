
import javax.swing.JOptionPane;

public class Logica {

	private char [][]tablero= new char[8][8];
	private int contador=0;
	private boolean respuesta;//holi

	public void iniciar() {
		tablero[3][3]= 'b';
		tablero[4][4]= 'b';
		tablero[3][4]= 'n';
		tablero[4][3]= 'n';

	}

	public void llenar1() {

		for(int i=0;i<8;i++){
			for(int j=0;j<8;j++){
				tablero[i][j]='-';
			}
		}
	}


	public void mostrar(){
		for(int i=0;i<tablero.length;i++){
			for(int j=0;j<tablero.length;j++){
				System.out.print(tablero[i][j]);
			}
			System.out.println(" ");
		}
		System.out.println(" ");
	}



	public  void captura(){
		respuesta = true;
		int x,y;
		if(contador<60) {
			x = Integer.parseInt(JOptionPane.showInputDialog("Ingresar x"));
			y = Integer.parseInt(JOptionPane.showInputDialog("Ingresar y"));
			if((x<8) && (y<8) && (tablero[x][y]=='-')){
				validar(x,y,contador);	
				Cambiafichas(x,y);

			}
			if (respuesta ==true){
				System.out.print("No ingreso unas coordenadas correctas");

			}
		}
		else {
			System.out.print("Fin del juego");
		}
	}



	public void validar(int x, int y, int contador){

		if((x!=0) && (y!=0) && (x!=7) && (y!=7)) {
			if ((contador%2)==0){
				int g=(x-1);
				int m=(y-1);
				for(int i=(x-1);i<(g+3);i++){//revisar el alrededor de la casilla 
					for(int j=(y-1);j<(m+3);j++){//del color diferente al que esta jugando
						if(tablero[i][j]=='b') {
							BuscaBlancas(i,j,x,y);
							respuesta=false;
						}
					}
				}

			}
			else {
				int g=(x-1);
				int m=(y-1);
				for(int i=(x-1);i<(g+3);i++){//revisar el alrededor de la casilla 
					for(int j=(y-1);j<(m+3);j++){//el color diferente al que esta jugando
						if(tablero[i][j]=='n') {
							BuscaNegras(i,j,x,y, tablero);
							respuesta=false;
						}
					}
				}
			}
		}
		else{
			if ((contador%2)==0) {
				if((x==0) && (y==0)){
					for(int i=x;i<2;i++){//revisar el alrededor de la casilla 
						for(int j=y;j<2;j++){//del color diferente al que esta jugando
							if(tablero[i][j]=='b') {
								BuscaBlancas(i,j,x,y);
								respuesta=false;
							}
						}
					}
				}
				else if(y!=0){
					int m=y;
					for(int i=(x);i<2;i++){//revisar el alrededor de la casilla 
						for(int j=(y-1);j<(m+3);j++){//del color diferente al que esta jugando
							if(tablero[i][j]=='b') {
								BuscaBlancas(i,j,x,y);
								respuesta=false;
							}
						}
					}
				}

				else{
					int g=x;
					for(int i=(x-1);i<1;i++){//revisar el alrededor de la casilla 
						for(int j=y;j<(g+3);j++){//del color diferente al que esta jugando
							if(tablero[i][j]=='b') {
								BuscaBlancas(i,j,x,y);
								respuesta=false;
							}
						}
					}
				}
			}

			else {
				if((x==0) && (y==0)){
					for(int i=x;i<2;i++){//revisar el alrededor de la casilla 
						for(int j=y;j<2;j++){//del color diferente al que esta jugando
							if(tablero[i][j]=='b') {
								BuscaBlancas(i,j,x,y);
								respuesta=false;
							}
						}
					}
				}
				else if(y!=0){
					int m=y;
					for(int i=x;i<2;i++){//revisar el alrededor de la casilla 
						for(int j=(y-1);j<(m+3);j++){//del color diferente al que esta jugando
							if(tablero[i][j]=='b') {
								BuscaBlancas(i,j,x,y);
								respuesta=false;
							}
						}
					}
				}

				else {
					int g=x;
					for(int i=(x-1);i<1;i++){//revisar el alrededor de la casilla 
						for(int j=y;j<(g+3);j++){//del color diferente al que esta jugando
							if(tablero[i][j]=='b') {
								BuscaBlancas(i,j,x,y);
								respuesta=false;
							}
						}
					}
				}
			}

		}
	}



	public void BuscaBlancas(int i, int j, int x, int y) {
		if(tablero[i][j]=='b') {
			int w=i;
			int z=j;
			while (tablero[w][z]=='b' && (w<8) && (z<8) && (w>0) && (z>0)) {
				w=w+(i-x);
				z=z+(j-y);
			}
			if (tablero[w][z]=='n') {
				contador=contador+1;
				tablero[x][y]='n';

			}
			else {
				System.out.print("No ingreso unas coordenadas con un lugar de juego");
			}


		}
	}
	public void BuscaNegras(int i, int j, int x, int y, char tablero[][]) {
		if(tablero[i][j]=='n') {
			int w=i;
			int z=j;
			while (tablero[w][z]=='n' && (w<8) && (z<8) && (w>0) && (z>0)) {
				w=w+(i-x);
				z=z+(j-y);
			}
			if (tablero[w][z]=='b') {
				contador=contador+1;
				tablero[x][y]='b';
			}
			else {
				System.out.print("No ingreso unas coordenadas con un lugar de juego");
			}

		}
	}




	public char[][] getTablero() {
		return tablero;
	}
	public void setTablero(char[][] c) {
		this.tablero = c;
	}
	public int getContador() {
		return contador;
	}
	public void setContador(int contador) {
		this.contador = contador;
	}


	public void Cambiafichas(int x, int y) {

		if((tablero[x+1][y]=='b')&&(tablero[x+2][y]!='-')&&(tablero[x+2][y]!='b')) {
			tablero[x+1][y]='n';
			tablero[x+2][y]='n';
			if((tablero[x+1][y+1]=='b')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='b')) {
				tablero[x+1][y+1]='n';
				tablero[x+2][y+2]='n';
			}
			if((tablero[x+1][y-1]=='b')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='b')) {
				tablero[x+1][y-1]='n';
				tablero[x+2][y-2]='n';
			}
		}
		if((tablero[x-1][y]=='b')&&(tablero[x-2][y]!='-')&&(tablero[x-2][y]!='b')) {
			tablero[x-1][y]='n';
			tablero[x-2][y]='n';
			if((tablero[x+1][y+1]=='b')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='b')) {
				tablero[x+1][y+1]='n';
				tablero[x+2][y+2]='n';
			}
			if((tablero[x+1][y-1]=='b')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='b')) {
				tablero[x+1][y-1]='n';
				tablero[x+2][y-2]='n';
			}
		}
		if((tablero[x+1][y+1]=='b')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='b')) {
			tablero[x+1][y+1]='n';
			tablero[x+2][y+2]='n';
		}
		if((tablero[x+1][y-1]=='b')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='b')) {
			tablero[x+1][y-1]='n';
			tablero[x+2][y-2]='n';
		}
		if((tablero[x][y-1]=='b')&&(tablero[x][y-2]!='-')&&(tablero[x][y-2]!='b')) {
			tablero[x][y-1]='n';
			tablero[x][y-2]='n';
			if((tablero[x+1][y+1]=='b')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='b')) {
				tablero[x+1][y+1]='n';
				tablero[x+2][y+2]='n';
			}
			if((tablero[x+1][y-1]=='b')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='b')) {
				tablero[x+1][y-1]='n';
				tablero[x+2][y-2]='n';
			}
		}
		if((tablero[x][y+1]=='b')&&(tablero[x][y+2]!='-')&&(tablero[x][y+2]!='b')) {
			tablero[x][y+1]='n';
			tablero[x][y+2]='n';
			if((tablero[x+1][y+1]=='b')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='b')) {
				tablero[x+1][y+1]='n';
				tablero[x+2][y+2]='n';
			}
			if((tablero[x+1][y-1]=='b')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='b')) {
				tablero[x+1][y-1]='n';
				tablero[x+2][y-2]='n';
			}

		}		


		if((contador%2)==0) {
			if((tablero[x+1][y]=='n')&&(tablero[x+2][y]!='-')&&(tablero[x+2][y]!='n')) {
				tablero[x+1][y]='b';
				tablero[x+2][y]='b';
				if((tablero[x+1][y+1]=='n')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='n')) {
					tablero[x+1][y+1]='b';
					tablero[x+2][y+2]='b';
				}
				if((tablero[x+1][y-1]=='n')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='n')) {
					tablero[x+1][y-1]='b';
					tablero[x+2][y-2]='b';
				}
			}
			if((tablero[x-1][y]=='n')&&(tablero[x-2][y]!='-')&&(tablero[x-2][y]!='n')) {
				tablero[x-1][y]='b';
				tablero[x-2][y]='b';
				if((tablero[x+1][y+1]=='n')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='n')) {
					tablero[x+1][y+1]='b';
					tablero[x+2][y+2]='b';
				}
				if((tablero[x+1][y-1]=='n')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='n')) {
					tablero[x+1][y-1]='b';
					tablero[x+2][y-2]='b';
				}
			}
			if((tablero[x+1][y+1]=='n')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='n')) {
				tablero[x+1][y+1]='b';
				tablero[x+2][y+2]='b';
			}
			if((tablero[x+1][y-1]=='n')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='n')) {
				tablero[x+1][y-1]='b';
				tablero[x+2][y-2]='b';
			}
			if((tablero[x][y-1]=='n')&&(tablero[x][y-2]!='-')&&(tablero[x][y-2]!='n')) {
				tablero[x][y-1]='b';
				tablero[x][y-2]='b';
				if((tablero[x+1][y+1]=='n')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='n')) {
					tablero[x+1][y+1]='b';
					tablero[x+2][y+2]='b';
				}
				if((tablero[x+1][y-1]=='n')&&(tablero[x+2][y-2]!='-')&&(tablero[x+2][y-2]!='n')) {
					tablero[x+1][y-1]='b';
					tablero[x+2][y-2]='b';
				}
			}
			if((tablero[x][y+1]=='n')&&(tablero[x][y+2]!='-')&&(tablero[x][y+2]!='n')) {
				tablero[x][y+1]='b';
				tablero[x][y+2]='b';
				if((tablero[x+1][y+1]=='n')&&(tablero[x+2][y+2]!='-')&&(tablero[x+2][y+2]!='n')) {
					tablero[x+1][y+1]='b';
					tablero[x+2][y+2]='b';
				}
				if((tablero[x+1][y-1]=='n')&&(tablero[x+2][y-2]!='-')&&(tablero[x+32][y-2]!='n')) {
					tablero[x+1][y-1]='b';
					tablero[x+2][y-2]='b';
				}
			}

		}
	}
}


