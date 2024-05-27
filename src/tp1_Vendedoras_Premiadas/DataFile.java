package tp1_Vendedoras_Premiadas;

import java.util.ArrayList;

public class DataFile {
	private ArrayList<Vendedora> vendedoras;
	private int mayorCantidadVentas = 0;
	private int numeroVentasConsecutivas;

	public  void setVendedoras(ArrayList<Vendedora> vendedoras) {
		this.vendedoras = vendedoras;
	}

	public void setMayorCantidadVentas(int mayorCantidadVentas) {
		this.mayorCantidadVentas = mayorCantidadVentas;
	}

	public void setNumeroVentasConsecutivas(int numeroVentasConsecutivas) {
		this.numeroVentasConsecutivas = numeroVentasConsecutivas;
	}

	public ArrayList<Vendedora> getVentasDeVendedora() {
		return vendedoras;
	}

	public int getMayorCantidadVentas() {
		return mayorCantidadVentas;
	}

	public int getNumeroVentasConsecutivas() {
		return numeroVentasConsecutivas;
	}

	
}
