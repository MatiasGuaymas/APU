package ar.edu.unlp.info.oo2._Ejercicio13;

public class BuilderVegetariano extends SandwichBuilder {

    @Override
    public void construirPan() {
        this.getSandwich().setPan("Pan con semillas");
        this.getSandwich().setPrecioPan(120);
    }

    @Override
    public void construirAderezo() {
        this.getSandwich().setAderezo("Sin aderezo");
        this.getSandwich().setPrecioAderezo(0);
    }

    @Override
    public void construirPrincipal() {
        this.getSandwich().setPrincipal("Provoleta grillada");
        this.getSandwich().setPrecioPrincipal(200);
    }

    @Override
    public void construirAdicional() {
        this.getSandwich().setAdicional("Berenjenas al escabeche");
        this.getSandwich().setPrecioAdicional(100);
    }
}