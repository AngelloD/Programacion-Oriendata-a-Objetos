
public class Main {

	public static void main(String[] args) {
		
		Logica objLogica = new Logica();
		
		objLogica.setTablero(objLogica.getTablero());
		objLogica.llenar1();
	  
        objLogica.iniciar();
		objLogica.mostrar();
		while(objLogica.getContador()<60) {
			
			objLogica.captura();
			objLogica.mostrar();
			
		}



	}

}
