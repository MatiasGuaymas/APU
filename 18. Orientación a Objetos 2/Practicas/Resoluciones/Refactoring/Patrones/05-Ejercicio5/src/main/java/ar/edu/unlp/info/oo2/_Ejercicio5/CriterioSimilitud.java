package ar.edu.unlp.info.oo2._Ejercicio5;

import java.util.List;
import java.util.function.Predicate;

public class CriterioSimilitud extends CriterioDeSugerencia{
	
	@Override
	protected List<Pelicula> aplicarCriterio(Decodificador decodificador, Predicate<Pelicula> filtro) {
		return decodificador.getReproducidas().stream()
			.flatMap(pelicula -> pelicula.getSimilares().stream())
			.filter(filtro)
			.distinct()
			.sorted((p1, p2) -> Integer.compare(p2.getAnioEstreno(), p1.getAnioEstreno()))
			.toList();
	}
}
