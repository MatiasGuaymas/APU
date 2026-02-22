package ar.edu.unlp.info.oo2._Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Decodificador {
	private List<Pelicula> grilla;
	private List<Pelicula> reproducidas;
	private CriterioDeSugerencia criterio;
	
	public Decodificador() {
		this.grilla = new ArrayList<Pelicula>();
		this.reproducidas = new ArrayList<Pelicula>();
	}
	
	public Decodificador(List<Pelicula> grilla, List<Pelicula> reproducidas) {
		this.grilla = grilla;
		this.reproducidas = reproducidas;
	}
	
	public List<Pelicula> sugerirPeliculas() {
		return this.criterio.obtenerSugerencias(this);
	}
	
	public void agregarPeliculaGrilla (Pelicula pelicula) {
		this.grilla.add(pelicula);
	}
	
	public void agregarPeliculaReproducidas (Pelicula pelicula) {
		this.reproducidas.add(pelicula);
	}
	
	public void setStrategy(CriterioDeSugerencia criterio) {
		this.criterio = criterio;
	}

	public List<Pelicula> getGrilla() {
		return grilla;
	}
	
	public boolean reproducidaAnteriormente(Pelicula pelicula) {
		return this.reproducidas.contains(pelicula);
	}

	public List<Pelicula> getReproducidas() {
		return reproducidas;
	}
	
}
