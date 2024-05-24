package tp1_Vendedoras_Premiadas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		/// lectura de archivo
		Scanner sc = new Scanner(new FileReader("entrada.in"));
		int cantidadVendedoras = sc.nextInt();
		int ventasDeVendedora;
		int mayorCantidadVentas = 0;
		int salida;
		
		Vendedora vendedoras[] = new Vendedora[cantidadVendedoras];
		
		for (int i = 0; i < cantidadVendedoras; i++) {
			ventasDeVendedora = sc.nextInt();
			ArrayList<Integer> importesVendedora = new ArrayList<>(ventasDeVendedora);
			for (int j = 0; j < ventasDeVendedora; j++) {
				importesVendedora.add(sc.nextInt());
			}
			vendedoras[i] = new Vendedora(ventasDeVendedora, importesVendedora);
			
			//busco mayor para caso c
			if(ventasDeVendedora > mayorCantidadVentas) {
				mayorCantidadVentas = ventasDeVendedora;
			}
		}
		int numeroVentasConsecutivas = sc.nextInt();
		sc.close();
		
		salida = Resolucion.calcularGanadora( vendedoras, numeroVentasConsecutivas, mayorCantidadVentas);
		
	}
	
	

}
