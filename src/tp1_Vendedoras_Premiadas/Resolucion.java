package tp1_Vendedoras_Premiadas;

import java.util.ArrayList;

public class Resolucion {

	private static int nroVendedora;
	private static int cantidadVentasConsecutivas;
	private static int importeTotal;
	private static Boolean hayEmpate = false;

	public static void calcularGanadora(Vendedora[] vendedoras, int cantidadVentasConsecutivas) {

		// Matrix dinamica en donde se guardan los calculos parciales
		ArrayList<ArrayList<Integer>> calculosParciales = cargarImportesIniciales(vendedoras, cantidadVentasConsecutivas);

		// itera por cada vendedora para calcular el importe de ventas consecutivas
//		for (int i = 0; i < vendedoras.length - 1; i++) {
//			// sigue en concurso?
//			if (vendedoras[i].isEnConcurso()) {
//				// tiene ventas por la cantidad minima de ventas consecutivas
//				if (vendedoras[i].getImportes().size() >= cantidadVentasConsecutivas) {
//					
//					// ver el caso en que es 1 venta consecutiva
//					calcularImporteConsecutivo(vendedoras[i].getImportes(), calculosParciales.get(i), cantidadVentasConsecutivas);
//
//				} else {
//					vendedoras[i].quitarDeConcurso();
//				}
//
//			}
//		}
		
		
	}

//	private static ArrayList<ArrayList<Integer>> cargarImportesIniciales(Vendedora[] vendedoras) {
//		ArrayList<ArrayList<Integer>> calculosParciales = new ArrayList<>();
//
//		for (int i = 0; i < vendedoras.length - 1; i++) {
//			calculosParciales.add(vendedoras[i].getImportes());
//		}
//
//		return calculosParciales;
//	}
	
	private static ArrayList<ArrayList<Integer>> cargarImportesIniciales(Vendedora[] vendedoras, int cantidadConsecutiva) {
		ArrayList<ArrayList<Integer>> calculosParciales = new ArrayList<>();

		for (int i = 0; i < vendedoras.length - 1; i++) {
			calculosParciales.add(vendedoras[i].getImportes());
			if(vendedoras[i].getImportes().size() >= cantidadVentasConsecutivas) {
				for(int j = 1; j < cantidadVentasConsecutivas; j++) {
					calcularImporteConsecutivo(vendedoras[i].getImportes(), calculosParciales.get(i), j);
				}
			}else {
				vendedoras[i].quitarDeConcurso();
			}
		}
		
		return calculosParciales;
	}

	private static void calcularImporteConsecutivo(ArrayList<Integer> ventas,
			ArrayList<Integer> calculosParciales, int cantidadVentasConsecutivas2) {
		
		int suma;
		for(int i = 0; i < ventas.size() - cantidadVentasConsecutivas2; i++) {
			suma = calculosParciales.get(i) + ventas.get(i + cantidadVentasConsecutivas2);
			calculosParciales.set(i, suma);
		}
		//quito la ultima posicion porque nunca va a ser mayor. Tengo un elemento menos para iterar
		calculosParciales.remove(calculosParciales.size()-1);
	}

}
