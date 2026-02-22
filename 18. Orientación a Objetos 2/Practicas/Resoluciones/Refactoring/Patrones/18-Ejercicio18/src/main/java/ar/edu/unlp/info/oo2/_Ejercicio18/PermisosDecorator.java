package ar.edu.unlp.info.oo2._Ejercicio18;

public class PermisosDecorator extends FileDecorator {

	public PermisosDecorator(FileComponent component) {
		super(component);
	}

	public String prettyPrint() {
		return this.getComponent().prettyPrint() + " - " + this.getPermisos();
	}
}
