package ar.edu.unlp.info.oo2._Ejercicio14;

public class Inmueble extends Prenda {
	private String direccion;
	private double superficie;
	private double costoM2;

	public Inmueble(String direccion, double superficie, double costoM2) {
		super();
		this.direccion = direccion;
		this.superficie = superficie;
		this.costoM2 = costoM2;
	}

	@Override
	protected double getValor() {
		return this.superficie * this.costoM2;
	}

	@Override
	protected double getLiquidez() {
		return 0.2;
	}

}
