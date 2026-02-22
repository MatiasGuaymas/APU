package ar.edu.unlp.info.oo2._Ejercicio6;

public abstract class EstadoInscripcion {
	private Excursion excursion;
	
	public EstadoInscripcion(Excursion excursion) {
		this.excursion = excursion;
	}
	
	public Excursion getExcursion() {
		return this.excursion;
	}
	
	public String obtenerInformacion() {
		return this.excursion.toString() + this.informacionAdicional();
	}
	
	protected abstract String informacionAdicional();
	
	public abstract void inscribir(Usuario unUsuario);
}
