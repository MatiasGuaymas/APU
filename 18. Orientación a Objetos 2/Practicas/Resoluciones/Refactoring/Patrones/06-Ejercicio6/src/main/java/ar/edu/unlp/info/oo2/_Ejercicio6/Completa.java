package ar.edu.unlp.info.oo2._Ejercicio6;

public class Completa extends EstadoInscripcion{
	public Completa(Excursion excursion) {
		super(excursion);
	}

	@Override
	protected String informacionAdicional() {
		return "";
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		this.getExcursion().agregarAEspera(unUsuario);
	}
}
