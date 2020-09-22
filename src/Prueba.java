import java.util.Arrays;
import java.util.Scanner;

class TDAConjuntos{
	
	public String[] union(String conjuntoA[],String []conjuntoB) {
		byte conta=0;
		String cad="";
		String nuevoVector[]=null;
		for (int i=0;i<conjuntoA.length;i++) {
			for(int x=0;x<conjuntoB.length;x++) {
				if(conjuntoA[i].equalsIgnoreCase(conjuntoB[x])) {
					conta++;
				}
			}
			cad=cad+conjuntoA[i]+",";
		}
	return null;	
	}
	public String[] interseccion(String conjuntoA[],String []conjuntoB) {
		byte conta=0;
		String cad="";
		String nuevoVector[]=null;
		for (int i=0;i<conjuntoA.length;i++) {
			for(int x=0;x<conjuntoB.length;x++) {
				if(conjuntoA[i].equalsIgnoreCase(conjuntoB[x])) {
					conta++;
				}
			}
			if(conta>0) {
				cad=cad+conjuntoA[i]+",";
			}
			conta=0;
		}
		
		return cad.split(",");
	}
}
public class Prueba {

	public static void main(String[] args) {
		Scanner entrada=new Scanner (System.in);
		String conjuntoA[]= {"2","3","5","7","11","13","17","19"
				,"23","29","31","37","41","43",""
				+ "47","53",
				"59","61","67","71",
				"73","79","83","89","97"};
		String listaMultiplos = "";
		for(int i=1;i<=365;i++) {
			if(365 % i == 0) {
				listaMultiplos=listaMultiplos+i+",";
			}
		}
		System.out.println(listaMultiplos);
		TDAConjuntos operaciones = new TDAConjuntos();
		String conjuntoB[]=listaMultiplos.split(",");
		System.out.println("Elige la opcion que desees:");
		System.out.println("A) Union");
		System.out.println("B) Interseccion");
		System.out.println("C) Diferencia");
		System.out.println("D) Salir");
		String op=entrada.nextLine().replace(" ","").toUpperCase();
		switch (op) {
		case "A":
			System.out.println(Arrays.toString(operaciones.union(conjuntoA, conjuntoB)));
			break;
		case "B":
			System.out.println("Resultado de A interseccion B: "+Arrays.toString(operaciones.interseccion(conjuntoA, conjuntoB)));
			break;
		default:
			break;
		}
	}

}
