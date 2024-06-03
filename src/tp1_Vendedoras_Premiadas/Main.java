package tp1_Vendedoras_Premiadas;

import java.io.FileNotFoundException;
import java.util.HashMap;

public class Main {

	public static void main(String[] args) throws FileNotFoundException {

		String nombreArchivo = "vuelve_a_considerar_todas_las_ventas";
		try {
			DataFile lectura = Archivo.leerArchivo(nombreArchivo);

			Resolucion lote1 = new Resolucion();
			HashMap<Integer, Integer> salida = lote1.calcularGanadora(lectura.getVentasDeVendedora(),
					lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
			
			Archivo.guardarEnArchivo( lote1, salida, lote1.getCantidadVentasConsecutivas(), nombreArchivo);
		} catch (Exception e) {
			System.out.println("Archvio no encontrado");
			System.out.println(e.getMessage());
		}

	}

}
