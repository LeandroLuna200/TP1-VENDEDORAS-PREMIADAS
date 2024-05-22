package tp1_Vendedoras_Premiadas;

import java.util.ArrayList;

public class Resolucion {

	private static int nroVendedora;
	private static int cantidadVentasConsecutivas;
	private static int importeTotal;
	private static Boolean hayEmpate = false;

	public static void calcularGanadora(Vendedora[] vendedoras, int cantidadVentasConsecutivas) {

		
		// se itera siempre que haya empate
		while (!hayEmpate) {

			// Matrix dinamica en donde se guardan los calculos parciales
			ArrayList<ArrayList<Integer>> calculosParciales = new ArrayList<>();

			// itera por cada vendedora para calcular el importe de ventas consecutivas
			for (int i = 0; i < vendedoras.length - 1; i++) {

				// sigue en concurso?
				if (vendedoras[i].isEnConcurso()) {
					int[] ventas = vendedoras[i].getImportes();

					// tiene ventas por la cantidad minima de ventas consecutivas
					if (ventas.length >= cantidadVentasConsecutivas) {

						// se calcula en una matriz los importes segun las ventas consecutivas
						// ver el caso en que es 1 venta consecutiva
						calcularImporteConsecutivo(ventas, calculosParciales, cantidadVentasConsecutivas);

					} else {
						vendedoras[i].quitarDeConcurso();
					}

				}

			}

			// Ver Condiciones de empate
		}
	}

	private static void calcularImporteConsecutivo(int[] ventas, ArrayList<ArrayList<Integer>> calculosParciales,
			int cantidadVentasConsecutivas2) {
		
		

	}

}
