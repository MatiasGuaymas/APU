package ar.edu.unlp.info.oo2._Ejercicio18;

import java.time.LocalDate;

public interface FileComponent {
	
	public String prettyPrint();
	public String getNombre();
	public String getExtension();
	public String getTam();
	public LocalDate getFechaCreacion();
	public LocalDate getFechaModificacion();
	public String getPermisos();
	
}
