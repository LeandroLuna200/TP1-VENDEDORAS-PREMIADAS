package test;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.HashMap;

import org.junit.Test;

import tp1_Vendedoras_Premiadas.Archivo;
import tp1_Vendedoras_Premiadas.DataFile;
import tp1_Vendedoras_Premiadas.Resolucion;

public class VendedorasPremiadasTest {

	//** 1 hubo ganador // 0 no hay ganadora // < 1 no se puede desempatar
	
	@Test
	public void desempateConTodasLasVentasTest() throws FileNotFoundException {

		// Arrange
		String nombreArchivo = "Desempate_con_todas_las_Ventas";
		Resolucion lote1 = new Resolucion();
		DataFile lectura = Archivo.leerArchivo(nombreArchivo);
		
		// Act
		HashMap<Integer, Integer> salida = lote1.calcularGanadora(lectura.getVentasDeVendedora(),
				lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
		int keyVendedora = (int) salida.keySet().toArray()[0];
		int cantVConsecutivas = lote1.getCantidadVentasConsecutivas();
		int sumaTotal = salida.get(keyVendedora);
				
		// Assert
		assertEquals(1, keyVendedora, 0.0);
		assertEquals(3, cantVConsecutivas, 0.0);
		assertEquals(40, sumaTotal, 0.0);
//		assertTrue(miCuenta.depositarDinero(10000));
	}
	
//	@Test
//	public void soloDesempateEntreVendedorasEmpatadasTest() throws FileNotFoundException {
//		// Desempate_con_todas_las_Ventas.in
//
//		// Arrange
//		String nombreArchivo = "solo_vendedoras_que_empataron";
//		Resolucion lote1 = new Resolucion();
//		DataFile lectura = Archivo.leerArchivo(nombreArchivo);
//		
//		// Act
//		HashMap<Integer, Integer> salida = lote1.calcularGanadora(lectura.getVentasDeVendedora(),
//				lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
//		int keyVendedora = (int) salida.keySet().toArray()[0];
//		int cantVConsecutivas = lote1.getCantidadVentasConsecutivas();
//		int sumaTotal = salida.get(keyVendedora);
//				
//		// Assert
//		assertEquals(3, keyVendedora, 0.0);
//		assertEquals(3, cantVConsecutivas, 0.0);
//		assertEquals(160, sumaTotal, 0.0);
//	}
	
	@Test
	public void vuelveAConsiderarTodasLasVentasTest() throws FileNotFoundException {
		// Desempate_con_todas_las_Ventas.in

		// Arrange
		String nombreArchivo = "vuelve_a_considerar_todas_las_ventas";
		Resolucion lote2 = new Resolucion();
		DataFile lectura = Archivo.leerArchivo(nombreArchivo);
		
		// Act
		HashMap<Integer, Integer> salida2 = lote2.calcularGanadora(lectura.getVentasDeVendedora(),
				lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
		int keyVendedora = (int) salida2.keySet().toArray()[0];
		int cantVConsecutivas = lote2.getCantidadVentasConsecutivas();
		int sumaTotal = salida2.get(keyVendedora);
				
		// Assert
		assertEquals(3, keyVendedora);
		assertEquals(2, cantVConsecutivas, 0.0);
		assertEquals(21, sumaTotal, 0.0);
	}
	
	@Test
	public void ningunaVendedoraRealizoVentasNecesariasTest() throws FileNotFoundException {

		// Arrange
		String nombreArchivo = "error_ninguna_vendedora_realizo_ventas_necesarias";
		Resolucion lote2 = new Resolucion();
		DataFile lectura = Archivo.leerArchivo(nombreArchivo);
		String actual = "";
		// Act
		HashMap<Integer, Integer> salida2 = lote2.calcularGanadora(lectura.getVentasDeVendedora(),
				lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
		
		if (salida2.size() == 0) {
			actual = "No hay ganadoras";
		} else {
			actual = "No se puede desempatar";
		}
		
				
		// Assert
		assertEquals( "No hay ganadoras", actual);
	}
	
	@Test
	public void tomarSoloPrimerasVentasTest() throws FileNotFoundException {

		// Arrange
		String nombreArchivo = "error_tomar_primeras_ventas";
		Resolucion lote2 = new Resolucion();
		DataFile lectura = Archivo.leerArchivo(nombreArchivo);
		String actual = "";
		// Act
		HashMap<Integer, Integer> salida2 = lote2.calcularGanadora(lectura.getVentasDeVendedora(),
				lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
		int keyVendedora = (int) salida2.keySet().toArray()[0];
		int cantVConsecutivas = lote2.getCantidadVentasConsecutivas();
		int sumaTotal = salida2.get(keyVendedora);
				
		// Assert
		assertEquals(2, keyVendedora);
		assertEquals(3, cantVConsecutivas, 0.0);
		assertEquals(31, sumaTotal, 0.0);
	}
	
	@Test
	public void noSePuedeDesempatarTest() throws FileNotFoundException {

		// Arrange
		String nombreArchivo = "no_se_puede_desempatar";
		Resolucion lote2 = new Resolucion();
		DataFile lectura = Archivo.leerArchivo(nombreArchivo);
		String actual = "";
		// Act
		HashMap<Integer, Integer> salida2 = lote2.calcularGanadora(lectura.getVentasDeVendedora(),
				lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
		
		if (salida2.size() == 0) {
			actual = "No hay ganadoras";
		} else {
			actual = "No se puede desempatar";
		}
		
				
		// Assert
		assertEquals( "No se puede desempatar", actual);
	}
	
	@Test
	public void cantidadMaximaVendedorasTest() throws FileNotFoundException {
		// Desempate_con_todas_las_Ventas.in

		// Arrange
		String nombreArchivo = "maxima_cantidad_vendedoras";
		Resolucion lote2 = new Resolucion();
		DataFile lectura = Archivo.leerArchivo(nombreArchivo);
		
		// Act
		HashMap<Integer, Integer> salida2 = lote2.calcularGanadora(lectura.getVentasDeVendedora(),
				lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
		int keyVendedora = (int) salida2.keySet().toArray()[0];
		int cantVConsecutivas = lote2.getCantidadVentasConsecutivas();
		int sumaTotal = salida2.get(keyVendedora);
				
		// Assert
		assertEquals(1000, keyVendedora);
		assertEquals(1, cantVConsecutivas, 0.0);
		assertEquals(10, sumaTotal, 0.0);
	}
	
	@Test
	public void cantidadMaximaVentasDeVendedorasEmpatandoTest() throws FileNotFoundException {
		// Desempate_con_todas_las_Ventas.in

		// Arrange
		String nombreArchivo = "maxima_cantidad_ventas_de_vendedoras_empate";
		Resolucion lote2 = new Resolucion();
		DataFile lectura = Archivo.leerArchivo(nombreArchivo);
		String actual = "";
		
		// Act
		HashMap<Integer, Integer> salida2 = lote2.calcularGanadora(lectura.getVentasDeVendedora(),
				lectura.getNumeroVentasConsecutivas(), lectura.getMayorCantidadVentas());
		if (salida2.size() == 0) {
			actual = "No hay ganadoras";
		} else {
			actual = "No se puede desempatar";
		}
		
				
		// Assert
		assertEquals( "No se puede desempatar", actual);
	}
}
