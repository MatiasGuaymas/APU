package ar.edu.unlp.info.oo2._Ejercicio14;

public abstract class Prenda {
	public double calcularValor() {
		return this.getValor() * this.getLiquidez();
	}
	
	protected abstract double getValor();
	
	protected abstract double getLiquidez();
}
