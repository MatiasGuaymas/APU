package ar.edu.unlp.info.oo2._Ejercicio13;

public class BuilderClasico extends SandwichBuilder{

	@Override
    public void construirPan() {
        this.getSandwich().setPan("Brioche");
        this.getSandwich().setPrecioPan(100);
    }

    @Override
    public void construirAderezo() {
        this.getSandwich().setAderezo("Mayonesa");
        this.getSandwich().setPrecioAderezo(20);
    }

    @Override
    public void construirPrincipal() {
        this.getSandwich().setPrincipal("Carne de ternera");
        this.getSandwich().setPrecioPrincipal(300);
    }

    @Override
    public void construirAdicional() {
        this.getSandwich().setAdicional("Tomate");
        this.getSandwich().setPrecioAdicional(80);
    }

}
