package ar.edu.unlp.info.oo2._Ejercicio18;

public class ExtensionDecorator extends FileDecorator {

	public ExtensionDecorator(FileComponent component) {
		super(component);
	}

	public String prettyPrint() {
		return this.getComponent().prettyPrint() + " - " + this.getExtension();
	}
}
