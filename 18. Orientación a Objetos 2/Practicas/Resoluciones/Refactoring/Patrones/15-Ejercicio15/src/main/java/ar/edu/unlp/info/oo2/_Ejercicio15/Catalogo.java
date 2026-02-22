package ar.edu.unlp.info.oo2._Ejercicio15;

import java.util.ArrayList;
import java.util.List;

public class Catalogo {
	private static List<Componente> componentes;
	
	public Catalogo() {
		componentes = new ArrayList<Componente>();
	}
	
	public static void setComponentes(List<Componente> componentes) {
		Catalogo.componentes= componentes;
	}
	
	public static Componente getComponente(String prompt) {
		return componentes.stream()
				.filter(elem -> elem.getNombre().equals(prompt))
				.findFirst()
				.orElse(null);
	}
}
