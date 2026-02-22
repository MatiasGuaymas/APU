package ar.edu.unlp.info.oo2._Ejercicio5;

import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;

public class CriterioPuntaje extends CriterioDeSugerencia{

	/* Este método ordena las películas de la grilla del decodificador, 
	 * dando prioridad a las que tienen mayor puntaje "reversed()", y entre las que empatan, a las más recientes. */
	
	@Override
	protected List<Pelicula> aplicarCriterio(Decodificador decodificador, Predicate<Pelicula> filtro) {
		return decodificador.getGrilla().stream()
			.filter(filtro)
			.sorted(Comparator.comparing(Pelicula::getPuntaje).reversed()
				.thenComparing(Pelicula::getAnioEstreno, Comparator.reverseOrder()))
			.toList();
	}
}
