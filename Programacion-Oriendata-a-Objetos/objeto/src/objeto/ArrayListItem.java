package objeto;
import java.util.*;

public class ArrayListItem {

	public static void main(String[] args) {
		ArrayList lista=new ArrayList();
		
		lista.add(new Itemlistening("Universidad"));
		lista.add(new Itemlistening("Distrital"));
		lista.add(new Itemlistening("FJC"));
		
		Iterator iterador=lista.iterator();
		
		while(iterador.hasNext()) {
			System.out.println(iterador.next());
		}
		Object objeto=new Object();
		objeto.toString();
	}

}
