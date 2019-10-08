package objeto;

public class Polimorfismo {
public static void muevete(Mamifero m) {
	m.mover();
}
public static void main(String args[]) {
	Gato gatito=new Gato();
	Perro perrito=new Perro();
	
	muevete(gatito);
	muevete(perrito);
}
}
