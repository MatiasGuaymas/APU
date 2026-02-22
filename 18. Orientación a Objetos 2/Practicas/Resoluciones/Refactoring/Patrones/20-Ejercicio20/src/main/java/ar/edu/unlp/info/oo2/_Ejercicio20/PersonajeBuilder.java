package ar.edu.unlp.info.oo2._Ejercicio20;

public abstract class PersonajeBuilder {
	private Personaje personaje;
	
	public PersonajeBuilder() {
		this.reset();
	}
	
	public void reset() {
		this.personaje = new Personaje();
	}
	
	public void setNombre(String nombre) {
		this.personaje.setNombre(nombre);
	}
	
	public void setVida() {
		this.personaje.setVida(100);
	}
	
	public abstract void setArmadura();
	
	public abstract void setArma();
	
	public abstract void setHabilidades();
	
	public Personaje getPersonaje() {
		return this.personaje;
	}
}
