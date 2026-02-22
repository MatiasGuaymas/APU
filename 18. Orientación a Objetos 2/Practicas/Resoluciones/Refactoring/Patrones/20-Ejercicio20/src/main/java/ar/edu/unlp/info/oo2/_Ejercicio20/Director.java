package ar.edu.unlp.info.oo2._Ejercicio20;

public class Director {
	private PersonajeBuilder builder;
	
	public Director (PersonajeBuilder builder) {
		this.builder = builder;
	} 
	
	public void setBuilder (PersonajeBuilder builder) {
		this.builder = builder;
	}
	
	public Personaje build (String nombre) {
		this.builder.reset();
		this.builder.setNombre(nombre);
		this.builder.setVida();
		this.builder.setArmadura();
		this.builder.setArma();
		this.builder.setHabilidades();
		return this.builder.getPersonaje();
	}
	
}
