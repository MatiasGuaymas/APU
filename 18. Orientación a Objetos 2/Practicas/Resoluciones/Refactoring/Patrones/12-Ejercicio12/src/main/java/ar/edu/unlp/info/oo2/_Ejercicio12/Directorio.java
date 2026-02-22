package ar.edu.unlp.info.oo2._Ejercicio12;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Directorio extends Elemento{
	private List<Elemento> contenido;

	public Directorio(String nombre, LocalDate fechaCreacion) {
		super(nombre, fechaCreacion);
		this.contenido = new ArrayList<Elemento>();
	}
	
	public void agregarElemento(Elemento elem) {
		this.contenido.add(elem);
	}
	
	@Override
	public int getTamanio() {
		return 32 + this.contenido.stream().mapToInt(elem -> elem.getTamanio()).sum();
	}

	@Override
	public Archivo archivoMasGrande() {
        return contenido.stream().map(elem -> elem.archivoMasGrande())
        		.max((archivo1, archivo2) -> Integer.compare(archivo1.getTamanio(), archivo2.getTamanio())) 
                .orElse(null);
    }
	
	@Override
	public Archivo archivoMasNuevo() {
        return contenido.stream().map(elem -> elem.archivoMasNuevo())
        		.max((archivo1, archivo2) -> archivo1.getFechaCreacion().compareTo(archivo2.getFechaCreacion())) 
                .orElse(null);
    }
	
	@Override
	public Elemento buscar(String nombre) {
        return this.compareName(nombre) ? this : 
        		this.contenido.stream().map(elem -> elem.buscar(nombre))
                .filter(elemento -> elemento != null).findFirst().orElse(null);
    }
	
	protected void buscarEnHijos(String nombre, List<Elemento> lista) {
        this.contenido.stream().forEach(elem -> elem.buscarTodos(nombre, lista));
    }
	
	@Override
    public String listadoDeContenido(String prefijo) {
        StringBuilder resultado = new StringBuilder();
        String pathActual = prefijo + this.getNombre();
        resultado.append(pathActual).append("\n");
        resultado.append(
            contenido.stream()
                .map(elem -> elem.listadoDeContenido(pathActual + "/"))
                .collect(Collectors.joining())
        );
        return resultado.toString();
    }
}
