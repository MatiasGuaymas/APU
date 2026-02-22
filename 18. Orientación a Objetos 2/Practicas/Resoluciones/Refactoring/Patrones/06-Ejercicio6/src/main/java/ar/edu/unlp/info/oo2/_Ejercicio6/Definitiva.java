package ar.edu.unlp.info.oo2._Ejercicio6;

public class Definitiva extends EstadoInscripcion{
	
	public Definitiva(Excursion excursion) {
		super(excursion);
	}

	@Override
	protected String informacionAdicional() {
		return "Cantidad de usuarios faltantes para alcanzar el cupo maximo: " + this.getExcursion().cantFaltantesParaMaximo() + "\n"
		+  "Mails de los Usuarios Inscriptos: " + this.getExcursion().mailsDeInscriptos();
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		Excursion e = this.getExcursion();
		e.agregarInscripto(unUsuario);
		if(e.cumpleMaximoCuposInscriptos())
			e.changeState(new Completa(e));
	}
}
