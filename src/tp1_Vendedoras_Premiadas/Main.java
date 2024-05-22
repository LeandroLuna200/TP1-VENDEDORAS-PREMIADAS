package tp1_Vendedoras_Premiadas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		/// lectura de archivo
		Scanner sc = new Scanner(new FileReader("entrada.in"));
		int cantidadVendedoras = sc.nextInt();
		int ventasDeVendedora;
		
		Vendedora vendedoras[] = new Vendedora[cantidadVendedoras];
		
		for (int i = 0; i < cantidadVendedoras; i++) {
			ventasDeVendedora = sc.nextInt();
			int[] importesVendedora = new int[ventasDeVendedora];
			for (int j = 0; j < ventasDeVendedora; j++) {
				importesVendedora[j] = sc.nextInt();
			}
			vendedoras[i] = new Vendedora(ventasDeVendedora, importesVendedora);
		}
		int numeroVentasConsecutivas = sc.nextInt();
		sc.close();
		
		Resolucion.calcularGanadora( vendedoras, numeroVentasConsecutivas );
		
		

	}
	
	

}
