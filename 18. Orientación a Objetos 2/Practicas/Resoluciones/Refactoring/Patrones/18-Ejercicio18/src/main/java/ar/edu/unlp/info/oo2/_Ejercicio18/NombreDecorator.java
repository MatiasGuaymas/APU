package ar.edu.unlp.info.oo2._Ejercicio18;

public class NombreDecorator extends FileDecorator {

	public NombreDecorator(FileComponent component) {
		super(component);
	}

	public String prettyPrint() {
		//return this.getComponent().prettyPrint() + " - " + this.getNombre();
		return super.prettyPrint();
	}
}
