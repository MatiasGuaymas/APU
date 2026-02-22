package ar.edu.unlp.info.oo2._Ejercicio18;

public class TamDecorator extends FileDecorator {

	public TamDecorator(FileComponent component) {
		super(component);
	}

	public String prettyPrint() {
		return this.getComponent().prettyPrint() + " - " + this.getTam();
	}
}
