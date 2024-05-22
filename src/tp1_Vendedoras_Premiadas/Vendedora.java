package tp1_Vendedoras_Premiadas;

public class Vendedora {
	private int cantidadDeVentas;
	private int[] importes;
	private boolean enConcurso = true;

	public Vendedora(int ventasDeVendedora, int[] importesVendedora) {
		this.cantidadDeVentas = ventasDeVendedora;
		this.importes = importesVendedora;
	}

	public int getCantidadDeVentas() {
		return cantidadDeVentas;
	}

	public void setCantidadDeVentas(int cantidadDeVentas) {
		this.cantidadDeVentas = cantidadDeVentas;
	}

	public int[] getImportes() {
		return importes;
	}

	public void setImportes(int[] importes) {
		this.importes = importes;
	}

	public boolean isEnConcurso() {
		return enConcurso;
	}

	public void setEnConcurso(boolean enConcurso) {
		this.enConcurso = enConcurso;
	}
	
	public void quitarDeConcurso() {
		setEnConcurso(false);
	}

}
