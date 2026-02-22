package ar.edu.unlp.info.oo2._Ejercicio5;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DecodificadorTest {
	
	private Decodificador deco;
	private List<Pelicula> pelis;
	private List<Pelicula> reproducidas;
	Pelicula pelicula1;
	Pelicula pelicula2;
	Pelicula pelicula3;
	Pelicula pelicula4;
	Pelicula pelicula5;
	Pelicula pelicula6;
	Pelicula pelicula7;
	Pelicula pelicula8;
	Pelicula pelicula9;
	Pelicula pelicula10;

	@BeforeEach
	void setUp() throws Exception {
		pelicula1 = new Pelicula("El Padrino", 1972, 9.2);
        pelicula2 = new Pelicula("Titanic", 1997, 7.8);
        pelicula3 = new Pelicula("Avatar", 2009, 7.8);
        pelicula4 = new Pelicula("Pulp Fiction", 1994, 8.9);
        pelicula5 = new Pelicula("Forrest Gump", 1994, 8.8);
        pelicula6 = new Pelicula("El Senior de los Anillos: El Retorno del Rey", 2003, 8.9);
        pelicula7 = new Pelicula("La lista de Schindler", 1993, 8.9);
        pelicula8 = new Pelicula("Matrix", 1999, 8.7);
        pelicula9 = new Pelicula("Interestelar", 2014, 8.6);
        pelicula10 = new Pelicula("Gladiador", 2000, 8.5);
        
        pelicula3.agregarSimilar(pelicula6);
        pelicula3.agregarSimilar(pelicula9);
        pelicula1.agregarSimilar(pelicula4);
        pelicula1.agregarSimilar(pelicula10);
        pelicula7.agregarSimilar(pelicula5);
        
        pelis = new ArrayList<Pelicula>();
        reproducidas = new ArrayList<Pelicula>();
        
        pelis.add(pelicula1);
        pelis.add(pelicula2);
        pelis.add(pelicula3);
        pelis.add(pelicula4);
        pelis.add(pelicula5);
        pelis.add(pelicula6);
        pelis.add(pelicula7);
        pelis.add(pelicula8);
        pelis.add(pelicula9);
        pelis.add(pelicula10);
        
        reproducidas.add(pelicula1);
        reproducidas.add(pelicula3);
        reproducidas.add(pelicula5);
        reproducidas.add(pelicula7);
        
        deco = new Decodificador(pelis, reproducidas);
	}

	@Test
	void testObtenerSugerenciasPorSimilitud() {
		deco.setStrategy(new CriterioSimilitud());
		List<Pelicula> similares = deco.sugerirPeliculas();
		
		assertTrue(similares.contains(pelicula6));
		assertTrue(similares.contains(pelicula10));
		assertTrue(similares.contains(pelicula9));
	}
	
	@Test
	void testObtenerSugerenciasPorPuntaje() {
		deco.setStrategy(new CriterioPuntaje());
		List<Pelicula> similares = deco.sugerirPeliculas();
		
		assertTrue(similares.contains(pelicula6));
		assertTrue(similares.contains(pelicula4));
		assertTrue(similares.contains(pelicula8));
	}

}
