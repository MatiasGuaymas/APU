package ar.edu.unlp.info.oo2._Ejercicio13;

public abstract class SandwichBuilder {
	private Sandwich sandwich;
	
	public void reset() {
		this.sandwich = new Sandwich();
	}
	
	public abstract void construirPan();
	
	public abstract void construirAderezo();
	
	public abstract void construirPrincipal();
	
	public abstract void construirAdicional();
	
	public Sandwich getSandwich() {
		return this.sandwich;
	}
	
}
