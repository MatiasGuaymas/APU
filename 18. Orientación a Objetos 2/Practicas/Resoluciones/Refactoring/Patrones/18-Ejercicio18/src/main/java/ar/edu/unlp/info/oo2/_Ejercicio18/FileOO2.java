package ar.edu.unlp.info.oo2._Ejercicio18;

import java.time.LocalDate;

public class FileOO2 implements FileComponent{
	private String nombre;
	private String extension;
	private String tam;
	private LocalDate fechaCreacion;
	private LocalDate fechaModificacion;
	private String permisos;
	
	public FileOO2(String nombre, String extension, String tam, LocalDate fechaCreacion, LocalDate fechaModificacion, String permisos) {
		super();
		this.nombre = nombre;
		this.extension = extension;
		this.tam = tam;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.permisos = permisos;
	}
	public String getNombre() {
		return this.nombre;
	}
	public String getExtension() {
		return this.extension;
	}
	public String getTam() {
		return this.tam;
	}
	public LocalDate getFechaCreacion() {
		return this.fechaCreacion;
	}
	public LocalDate getFechaModificacion() {
		return this.fechaModificacion;
	}
	public String getPermisos() {
		return this.permisos;
	}
	public String prettyPrint() {
		return this.getNombre();
	}

}
