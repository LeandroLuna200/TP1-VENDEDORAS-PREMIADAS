package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;

import tp1_Vendedoras_Premiadas.DataFile;
import tp1_Vendedoras_Premiadas.Resolucion;

public class VendedorasPremiadasTest {

	@Test
	public void desempateConTodasLasVentasTest() throws FileNotFoundException {
		// Desempate_con_todas_las_Ventas.in

		// Arrange
//		DataFile.leerArchivo("entrada.in");
//
//		HashMap<Integer, Integer> salida = Resolucion.calcularGanadora(DataFile.getVentasDeVendedora(),
//				DataFile.getNumeroVentasConsecutivas(), DataFile.getMayorCantidadVentas());
//
//		if (salida.size() == 1) {
//			System.out
//					.println("Gana:" + salida + "[CantidadVentas=" + Resolucion.getCantidadVentasConsecutivas() + "]");
//		} else if (salida.size() == 0) {
//			System.out.println("No hay ganadoras");
//		} else {
//			System.out.println("No se puede desempatar");
//			salida.forEach((key, entry) -> {
//				System.out.println("Vendedora: " + key + " Maximo: " + entry);
//			});
//		}

		// Act
//		double obtenido = miCuenta.consultarSaldo();

		// Assert
//		assertEquals(0, obtenido, 0.0);
//		assertTrue(miCuenta.depositarDinero(10000));
	}
}
