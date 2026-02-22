package ar.edu.unlp.info.oo2._Ejercicio20;

public class Martillo implements Arma{

	@Override
	public int dañoContraCuero() {
		return 15;
	}

	@Override
	public int dañoContraHierro() {
		return 12;
	}

	@Override
	public int dañoContraAcero() {
		return 10;
	}

}
