package ar.edu.unlp.info.oo2._Ejercicio6;

public class Provisoria extends EstadoInscripcion{

	public Provisoria(Excursion excursion) {
		super(excursion);
	}

	@Override
	protected String informacionAdicional() {
		return "Cantidad de usuarios faltantes para alcanzar el cupo minimo: " + this.getExcursion().cantFaltantesParaMinimo();
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		Excursion e = this.getExcursion();
		e.agregarInscripto(unUsuario);
		if(e.cumpleMinimoCuposInscriptos())
			e.changeState(new Definitiva(e));
	}

}
