package tp1_Vendedoras_Premiadas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Archivo {
	
	public static DataFile leerArchivo(String nombreArchivo) throws FileNotFoundException {
		
		DataFile lectura = new DataFile();
		Scanner sc = new Scanner(new FileReader("LoteDePrueba/Entrada/" + nombreArchivo + ".in"));
		int cantidadVendedoras = sc.nextInt();
		
		int mayorCantidadVentas = 0;
		int numeroVentasConsecutivas;

		ArrayList<Vendedora> vendedoras = new ArrayList<Vendedora>(cantidadVendedoras);

		for (int i = 0; i < cantidadVendedoras; i++) {
			int ventasDeVendedora = sc.nextInt();
			ArrayList<Integer> importesVendedora = new ArrayList<>(ventasDeVendedora);
			for (int j = 0; j < ventasDeVendedora; j++) {
				importesVendedora.add(sc.nextInt());
			}
			vendedoras.add(new Vendedora(ventasDeVendedora, importesVendedora));

			// busco mayor para caso c
			if (ventasDeVendedora > mayorCantidadVentas) {
				mayorCantidadVentas = ventasDeVendedora;
			}
		}
		numeroVentasConsecutivas = sc.nextInt();
		sc.close();
		
		lectura.setVendedoras(vendedoras);
		lectura.setNumeroVentasConsecutivas(numeroVentasConsecutivas);;
		lectura.setMayorCantidadVentas(mayorCantidadVentas);
		
		return lectura;
	}

	public static void guardarEnArchivo(Resolucion lote1, HashMap<Integer, Integer> salida, int cantidadVentasConsecutivas, String nombreArchivo) {

		//** 1 hubo ganador // 0 no hay ganadora // < 1 no se puede desempatar
		try (PrintWriter writer = new PrintWriter(new FileWriter("LoteDePrueba/Salida/" + nombreArchivo + ".out"))) {
			if (salida.size() == 1) {
				int key = (int) salida.keySet().toArray()[0];
				writer.println(key);
				writer.println( lote1.getCantidadVentasConsecutivas() + " " + salida.get(key));
				
				System.out.println(
						"Gana:" + key + "/ CantidadVentas=" + lote1.getCantidadVentasConsecutivas()
								+ "/ Monto:" + salida.get(key));
			} else if (salida.size() == 0) {
				writer.println("No hay ganadoras");
				System.out.println("No hay ganadoras");
			} else {
				
				writer.println("No se puede desempatar");
				System.out.println("No se puede desempatar");
//				salida.forEach((key, entry) -> {
//					System.out.println("Vendedora: " + key + " Maximo: " + entry);
//				});
			}
			
			writer.close();
			
		} catch (IOException e) {
			System.err.println("Error al escribir en el archivo: " + e.getMessage());
		}
	}
}
