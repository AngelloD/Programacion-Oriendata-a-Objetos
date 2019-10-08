package objeto;

public class Adicion {
public static void suma(int a, int b) {
	System.out.println(a+b+" Suma enteros") ;
}

public static void suma (float a, float b) {
	System.out.println(a+b+ " Suma flotantes");
}

public static void main(String args[]) {
	int num1, num2;
	float num3, num4;
	num1=5;
	num2=10;
	num3=(float)5.5;
	num4=(float)5.6;
	
	suma(num1, num2);
	suma(num3, num4);
}
}
