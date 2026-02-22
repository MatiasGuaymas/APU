package ar.edu.unlp.info.oo2._Ejercicio20;

public class ArmaduraDeAcero implements Armadura {

	@Override
	public int recibirDaño(Arma arma) {
		return arma.dañoContraAcero();
	}

}
