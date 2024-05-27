package tp1_Vendedoras_Premiadas;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		/// lectura de archivo
		try {
			DataFile lectura = Archivo.leerArchivo("entrada.in");

			HashMap<Integer, Integer> salida = Resolucion.calcularGanadora(lectura.getVentasDeVendedora(),
					lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());

			
			Archivo.guardarEnArchivo( salida, Resolucion.getCantidadVentasConsecutivas() );
			
//			if (salida.size() == 1) {
//				System.out.println(
//						"Gana:" + salida + "[CantidadVentas=" + Resolucion.getCantidadVentasConsecutivas() + "]");
//			} else if (salida.size() == 0) {
//				System.out.println("No hay ganadoras");
//			} else {
//				System.out.println("No se puede desempatar");
//				salida.forEach((key, entry) -> {
//					System.out.println("Vendedora: " + key + " Maximo: " + entry);
//				});
//			}
		} catch (Exception e) {
			System.out.println("Archvio no encontrado");
			System.out.println(e.getMessage());
		}

	}

}
