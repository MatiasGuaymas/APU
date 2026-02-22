package ar.edu.unlp.info.oo2._Ejercicio5;

import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private int anioEstreno;
	private List<Pelicula> similares;
	private double puntaje;
	
	public Pelicula(String titulo, int anioEstreno, double puntaje) {
		this.titulo = titulo;
		this.anioEstreno = anioEstreno;
		this.puntaje = puntaje;
		this.similares = new ArrayList<Pelicula>();
	}
	
	public void agregarSimilar(Pelicula pelicula) {
		if (!this.similares.contains(pelicula)) {
			this.similares.add(pelicula);
			pelicula.agregarSimilar(this);
		}
	}
	
	public boolean reproducidaAnteriormente(Pelicula pelicula) {
		return this.similares.contains(pelicula);
	}
	
	public int getAnioEstreno() {
		return this.anioEstreno;
	}
	
	public double getPuntaje() {
		return this.puntaje;
	}
	
	public List<Pelicula> getSimilares() {
		return this.similares;
	}
}

