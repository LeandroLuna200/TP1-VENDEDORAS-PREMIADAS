package tp1_Vendedoras_Premiadas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {
		
		/// lectura de archivo
		Scanner sc = new Scanner(new FileReader("entrada.in"));
		int cantidadVendedoras = sc.nextInt();
		int ventasDeVendedora;
		int mayorCantidadVentas = 0;
		
		ArrayList<Vendedora> vendedoras = new ArrayList<Vendedora>(cantidadVendedoras);
		
		for (int i = 0; i < cantidadVendedoras; i++) {
			ventasDeVendedora = sc.nextInt();
			ArrayList<Integer> importesVendedora = new ArrayList<>(ventasDeVendedora);
			for (int j = 0; j < ventasDeVendedora; j++) {
				importesVendedora.add(sc.nextInt());
			}
			vendedoras.add(new Vendedora(ventasDeVendedora, importesVendedora));
			
			//busco mayor para caso c
			if(ventasDeVendedora > mayorCantidadVentas) {
				mayorCantidadVentas = ventasDeVendedora;
			}
		}
		int numeroVentasConsecutivas = sc.nextInt();
		sc.close();
		
		HashMap<Integer, Integer> salida = Resolucion.calcularGanadora( vendedoras, numeroVentasConsecutivas, mayorCantidadVentas);
		if(salida.size() == 1) {
			System.out.println("Gana:" + salida +  "[CantidadVentas=" + Resolucion.getCantidadVentasConsecutivas() + "]");
		}else if(salida.size() == 0) {
			System.out.println("No hay ganadoras");
		}else {
			System.out.println("No se puede desempatar");
			salida.forEach((key,entry) -> {
			System.out.println("Vendedora: " + key + " Maximo: "+ entry);
		});
		}
		
	}
	
	

}
