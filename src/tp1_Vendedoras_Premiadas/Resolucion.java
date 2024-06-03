package tp1_Vendedoras_Premiadas;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class Resolucion {

	private int nroVendedora;
	private int cantidadVentasConsecutivas;
	private int importeGanador;
	
	public int getImporteGanador() {
		return importeGanador;
	}

	public void setImporteGanador(int importeGanador) {
		this.importeGanador = importeGanador;
	}

	public int getCantidadVentasConsecutivas() {
		return cantidadVentasConsecutivas;
	}

	public void setCantidadVentasConsecutivas(int cantidadVentasConsecutivas) {
		this.cantidadVentasConsecutivas = cantidadVentasConsecutivas;
	}

	public HashMap<Integer, Integer> calcularGanadora(ArrayList<Vendedora> vendedoras, int cantidadVentas,
			int mayorCantidadVentas) {
		setCantidadVentasConsecutivas(cantidadVentas);
		HashMap<Integer, Integer> posiblesGanadoras = new HashMap<Integer, Integer>();

		if (cantidadVentasConsecutivas <= mayorCantidadVentas) {
			ArrayList<ArrayList<Integer>> calculosParciales = cargarImportesIniciales(vendedoras,
					cantidadVentasConsecutivas);
			posiblesGanadoras = buscaMayor(calculosParciales, vendedoras);
			
			while (posiblesGanadoras.size() > 1 && cantidadVentasConsecutivas <= mayorCantidadVentas) {
				cantidadVentasConsecutivas++;
				for (int i = 0; i < vendedoras.size(); i++) {
					
					if (vendedoras.get(i).isEnConcurso()) {
						// tiene ventas por la cantidad minima de ventas consecutivas
						if (vendedoras.get(i).getImportes().size() >= cantidadVentasConsecutivas) {
							// ver el caso en que es 1 venta consecutiva
							calcularImporteConsecutivo(vendedoras.get(i).getImportes(), calculosParciales.get(i),
									cantidadVentasConsecutivas-1);
						} else {
							vendedoras.get(i).quitarDeConcurso(); // la saco de competencia porque sus ventas son
																	// menores a n
						}
					}
				}
				// vuelvo a buscar mayores
				posiblesGanadoras = buscaMayor(calculosParciales, vendedoras);
			}
		}
		return posiblesGanadoras;
	}

	private ArrayList<ArrayList<Integer>> cargarImportesIniciales(ArrayList<Vendedora> vendedoras,
			int cantidadConsecutiva) {
		ArrayList<ArrayList<Integer>> calculosParciales = new ArrayList<>();

		for (int i = 0; i < vendedoras.size(); i++) {
			calculosParciales.add((ArrayList<Integer>) vendedoras.get(i).getImportes().clone());
			if (vendedoras.get(i).getImportes().size() >= cantidadConsecutiva) {
				for (int j = 1; j < cantidadConsecutiva; j++) {
					calcularImporteConsecutivo(vendedoras.get(i).getImportes(), calculosParciales.get(i), j);
				}
			}
		}
		return calculosParciales;
	}

	private void calcularImporteConsecutivo(ArrayList<Integer> ventas, ArrayList<Integer> calculosParciales,
			int cantidadVentasConsecutivas2) {

		Integer suma;
		for (int i = 0; i < ventas.size() - cantidadVentasConsecutivas2; i++) {
			suma = calculosParciales.get(i) + ventas.get(i + cantidadVentasConsecutivas2);
			calculosParciales.set(i, suma);
		}
		// quito la ultima posicion porque nunca va a ser mayor. Tengo un elemento menos
		// para iterar
		calculosParciales.remove(calculosParciales.size()-1);
	}

	private HashMap<Integer, Integer> buscaMayor(ArrayList<ArrayList<Integer>> calculosParciales,
			ArrayList<Vendedora> vendedoras) {
		HashMap<Integer, Integer> vendedoras_mayores = new HashMap<Integer, Integer>();
		ArrayList<Integer> mayores = new ArrayList<Integer>(); // maximo de cada vendedor
		Integer maximo;

		// busco el mayor consecutivo de cada vendedora
		calculosParciales.forEach((array) -> {
			mayores.add(Collections.max(array));
		});

		// busco el mayor de todos los mayores
		maximo = Collections.max(mayores);

		// busco cuales vendedoras tienen ese mayor
		for (int i = 0; i < vendedoras.size(); i++) {
			if (mayores.get(i) == maximo) {
				vendedoras_mayores.put(i + 1 , maximo); // las agrego a posibles ganadoras
			}
		}
		return vendedoras_mayores;
	}

}
