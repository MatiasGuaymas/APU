package ar.edu.unlp.info.oo2._Ejercicio12;

import java.time.LocalDate;
import java.util.List;

public abstract class Elemento {
	private String nombre;
	private LocalDate fechaCreacion;
	
	public Elemento(String nombre, LocalDate fechaCreacion) {
		super();
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
	}

	public String getNombre() {
        return nombre;
    }
	
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}
	
	public boolean compareName(String nombre) {
		return this.nombre.equals(nombre);
	}
	
	public abstract int getTamanio();
	public abstract Archivo archivoMasGrande();
	public abstract Archivo archivoMasNuevo();
	public abstract Elemento buscar(String nombre);
	
	public void buscarTodos(String nombre, List<Elemento> lista) {
		if (this.compareName(nombre)) lista.add(this);
		this.buscarEnHijos(nombre, lista);
	}
	protected abstract void buscarEnHijos(String nombre, List<Elemento> lista);
	
	public abstract String listadoDeContenido(String prefijo);
}
