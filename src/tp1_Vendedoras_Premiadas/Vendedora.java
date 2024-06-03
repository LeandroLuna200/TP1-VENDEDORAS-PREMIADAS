package tp1_Vendedoras_Premiadas;
import java.util.ArrayList;

public class Vendedora {
	public int id = 0;
	private int idVendedora;
	private int cantidadDeVentas;
	private ArrayList<Integer> importes;
	private boolean enConcurso = true;

	public Vendedora(int ventasDeVendedora, ArrayList<Integer> importesVendedora) {
		this.cantidadDeVentas = ventasDeVendedora;
		this.importes = importesVendedora;
		this.idVendedora = ++id;
		id++;
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
	
	public int getIdVendedora() {
		return idVendedora;
	}

	public void setIdVendedora(int idVendedora) {
		this.idVendedora = idVendedora;
	}


	@Override
	public String toString() {
		return "Vendedora [idVendedora=" + idVendedora + "]";
	}

}
