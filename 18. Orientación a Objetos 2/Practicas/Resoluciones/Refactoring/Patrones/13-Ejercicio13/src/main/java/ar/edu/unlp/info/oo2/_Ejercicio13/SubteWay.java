package ar.edu.unlp.info.oo2._Ejercicio13;

public class SubteWay {
	private SandwichBuilder builder;
	
	public SubteWay() {
		this.builder = new BuilderClasico();
	}
	
	public void setBuilder(SandwichBuilder builder) {
		this.builder = builder;
	}
	
	public SandwichBuilder getBuilder() {
		return this.builder;
	}

	public Sandwich construirSanguche() {
		this.builder.reset();
		this.builder.construirPan();
		this.builder.construirAderezo();
		this.builder.construirPrincipal();
		this.builder.construirAdicional();
		return this.builder.getSandwich();
	}
}
