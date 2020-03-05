package Othelo;

import javax.swing.*;

public class Validacion {

	Cambios logica2 = new Cambios();

	public boolean validar(boolean a, int x, int y, int contador, JButton array[][]){

		try {
			if((x!=0) && (y!=0) && (x!=7) && (y!=7)) {
				int g=(x-1);
				int m=(y-1);
				for(int i=(x-1);i<(g+3);i++){//revisar el alrededor de la casilla 
					for(int j=(y-1);j<(m+3);j++){//del color diferente al que esta jugando
						if((contador%2)==0) {
							if(array[i][j].getText().equals("blancas")) {
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);
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
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);

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
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);

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
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);

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
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);

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
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);

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
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);

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
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);

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
								a=logica2.BuscaBlancas(i,j,x,y,array,a);
							}
						}else {
							if(array[i][j].getText().equals("negras")) {
								a=logica2.BuscaNegras(i,j,x,y,array,a);

							}
						}
					}
				}
			}

		}
		catch(Exception e) {
			//JOptionPane.showMessageDialog(null, "Error desde el validar "+e.toString());
		}
		return a;
	}

}
