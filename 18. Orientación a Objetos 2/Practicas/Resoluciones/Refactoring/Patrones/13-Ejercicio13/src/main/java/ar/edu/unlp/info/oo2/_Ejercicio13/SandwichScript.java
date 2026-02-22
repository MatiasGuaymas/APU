package ar.edu.unlp.info.oo2._Ejercicio13;

public class SandwichScript {
	public static void main(String[] args) {
        SubteWay subteWay = new SubteWay();

        // Sándwich Clásico
        subteWay.setBuilder(new BuilderClasico());
        Sandwich clasico = subteWay.construirSanguche();
        System.out.println("Sándwich Clásico - Precio: " + clasico.calcularPrecio() + " pesos");

        // Sándwich Vegetariano
        subteWay.setBuilder(new BuilderVegetariano());
        Sandwich vegetariano = subteWay.construirSanguche();
        System.out.println("Sándwich Vegetariano - Precio: " + vegetariano.calcularPrecio() + " pesos");

        // Sándwich Vegano
        subteWay.setBuilder(new BuilderVegano());
        Sandwich vegano = subteWay.construirSanguche();
        System.out.println("Sándwich Vegano - Precio: " + vegano.calcularPrecio() + " pesos");

        // Sándwich Sin TACC
        subteWay.setBuilder(new BuilderSinTACC());
        Sandwich sinTACC = subteWay.construirSanguche();
        System.out.println("Sándwich Sin TACC - Precio: " + sinTACC.calcularPrecio() + " pesos");
	}
}
