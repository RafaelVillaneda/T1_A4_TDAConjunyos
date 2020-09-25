import java.util.Arrays;
import java.util.Scanner;

class TDAConjuntos{
	
	public String[] union(String conjuntoA[],String []conjuntoB) {
		byte conta=0;
		String cad="";
		String nuevoVector[]=null;
		for(int i=0;i<conjuntoA.length;i++) {
			cad=cad+conjuntoA[i]+",";
		}
		for(int i=0;i<conjuntoB.length;i++) {
			conta=0;
			for(int x=0;x<conjuntoA.length;x++) {
				if(conjuntoB[i].equalsIgnoreCase(conjuntoA[x])) {
				//	System.out.println(conjuntoB[i]);
					conta++;
				}
			}
			
			if(conta==0) {
				System.out.println("if");
				System.out.println(conjuntoB[i]);
				cad=cad+conjuntoB[i]+",";
			}conta=0;
		}
		System.out.println(cad);
	return cad.split(",");	
	}//Union
	public String[] interseccion(String conjuntoA[],String []conjuntoB) {
		byte conta=0;
		String cad="";
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
	public String[] diferencia(String conjuntoA[],String []conjuntoB,String op) {
		String cad="";
		byte conta=0;
		String diferencia[]=null;
		if(op.equalsIgnoreCase("A")) {
			for (int i=0;i<conjuntoA.length;i++) {
				for(int x=0;x<conjuntoB.length;x++) {
					if(conjuntoA[i].equalsIgnoreCase(conjuntoB[x])) {
						conta++;
					}
				}
				if(conta==0) {
					cad=cad+conjuntoA[i]+",";
				}
				conta=0;
			}
			diferencia=cad.split(",");
		}else {
			for (int i=0;i<conjuntoB.length;i++) {
				for(int x=0;x<conjuntoA.length;x++) {
					if(conjuntoB[i].equalsIgnoreCase(conjuntoA[x])) {
						conta++;
					}
				}
				if(conta==0) {
					cad=cad+conjuntoB[i]+",";
				}
				conta=0;
			}
			diferencia=cad.split(",");
		}
		return diferencia;
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
		for(int i=1;i<=350;i++) {
			if(350 % i == 0) {
				listaMultiplos=listaMultiplos+i+",";
			}
		}
		System.out.println(listaMultiplos);
		TDAConjuntos operaciones = new TDAConjuntos();
		String conjuntoB[]=listaMultiplos.split(",");
		String op="";
		do {
		System.out.println("Elige la opcion que desees:");
		System.out.println("A) Union");
		System.out.println("B) Interseccion");
		System.out.println("C) Diferencia ");
		System.out.println("D) Salir");
		op=entrada.nextLine().replace(" ","").toUpperCase();
		switch (op) {
		case "A":
			System.out.println("Resultado Union: "+Arrays.toString(operaciones.union(conjuntoA, conjuntoB)));
			break;
		case "B":
			System.out.println("Resultado de A interseccion B: "+Arrays.toString(operaciones.interseccion(conjuntoA, conjuntoB)));
			break;
		case "C":
			String op2="";
			boolean bandera=true;
			do {
			System.out.println("Como quieres calcular la diferencia?");
			System.out.println("A) A-B");
			System.out.println("B) B-A");
			System.out.println("C) Cancelar");
			op2=entrada.nextLine();
			if(op2.equalsIgnoreCase("A")) {
				System.out.println("Resultado de la diferencia A-B:"+Arrays.toString(operaciones.diferencia(conjuntoA, conjuntoB, op2)));
			}else if(op2.equalsIgnoreCase("B")){
				System.out.println("Resultado de la diferencia B-A:"+Arrays.toString(operaciones.diferencia(conjuntoA, conjuntoB, op2)));
			}else if(op2.equalsIgnoreCase("C")) {
				bandera=false;
			}else {
					System.out.println("Ingresa una opcion disponible");
				}
			}while(bandera==true);
			break;
		case "D":
			System.out.println("Saliendo....");
			break;
		default:
			System.out.println("Ingresa una opcion disponible");
			break;
			}
		}while (!op.equalsIgnoreCase("D"));
	}

}
