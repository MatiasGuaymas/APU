package ar.edu.unlp.info.oo2._Ejercicio5;

import java.util.List;
import java.util.function.Predicate;

public class CriterioNovedad extends CriterioDeSugerencia {
	
	@Override
	protected List<Pelicula> aplicarCriterio(Decodificador decodificador, Predicate<Pelicula> filtro) {
		return decodificador.getGrilla().stream()
			.filter(filtro)
			.sorted((p1, p2) -> Integer.compare(p2.getAnioEstreno(), p1.getAnioEstreno())) // Más nuevo primero
			.toList();
	}
}
