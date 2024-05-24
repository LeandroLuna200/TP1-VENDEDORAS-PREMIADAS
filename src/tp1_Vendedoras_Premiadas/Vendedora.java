package tp1_Vendedoras_Premiadas;
import java.util.ArrayList;

public class Vendedora {
	private int cantidadDeVentas;
	private ArrayList<Integer> importes;
	private boolean enConcurso = true;

	public Vendedora(int ventasDeVendedora, ArrayList<Integer> importesVendedora) {
		this.cantidadDeVentas = ventasDeVendedora;
		this.importes = importesVendedora;
	}

	public int getCantidadDeVentas() {
		return cantidadDeVentas;
	}

	public void setCantidadDeVentas(int cantidadDeVentas) {
		this.cantidadDeVentas = cantidadDeVentas;
	}

	public ArrayList<Integer> getImportes() {
		return importes;
	}

	public void setImportes(ArrayList<Integer> importes) {
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
