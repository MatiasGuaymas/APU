package ar.edu.unlp.info.oo2._Ejercicio5;

import java.util.List;
import java.util.function.Predicate;

public abstract class CriterioDeSugerencia {
	/* public List<Pelicula> obtenerSugerencias(Decodificador decodificador) {
		return this.aplicarCriterio(decodificador).stream().filter(pelicula -> !decodificador.reproducidaAnteriormente(pelicula)).limit(3).toList();
	}
	
	protected abstract List<Pelicula> aplicarCriterio (Decodificador decodificador); */
	
	// Por cuestiones de eficiencia voy a usar un Predicate, para filtrar ya de antes las listas y cuando haga el limit sea a una cantidad menor en el mejor de los casos
	
	public List<Pelicula> obtenerSugerencias(Decodificador decodificador) {
		Predicate<Pelicula> noVista = pelicula -> !decodificador.reproducidaAnteriormente(pelicula);
		return this.aplicarCriterio(decodificador, noVista).stream().limit(3).toList();
	}

	protected abstract List<Pelicula> aplicarCriterio(Decodificador decodificador, Predicate<Pelicula> filtro);
}
