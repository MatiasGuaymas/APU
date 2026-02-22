Bad smell: Feature Envy
Refactoring 1: Extract Method
La funcionalidad de calcular el precio de un producto junto a su IVA  debería ser extraída en un nuevo método (getPrecioConIVA(Producto p)) para luego poder hacer un movimiento de métodos entre clases.

Bad smell: Feature Envy
Refactoring 2: Move Method
El método calcularPrecioProd de la clase Pago ejecuta lógica que debería estar asignada a la clase Producto.

Bad smell: Reinventando la rueda
Refactoring 3: Replace loop with pipeline
El método calcularMontoFinal() de la clase Pago reinventa sus lazos, debería reemplazarse con una solución usando streams.

Bad smell: Long Method
Refactoring 4: Extract Method
El método calcularMontoFinal() puede simplificarse aún más. Se extrae en un método calcularProductos() la funcionalidad de calcular los precios de todos los productos, con sus respectivos condicionales y adicionales.

Bad smell: Switch Statement
Refactoring 5: Replace Conditional Logic with Strategy
5.1) Crear una clase Strategy
5.2) Move Method en este caso del método calcularProductos() -> ahora recibirá la lista de productos para luego de calcular el total aplicar el adicional correspondiente a la estrategia seleccionada
   1. Se define una V.I en el contexto para referenciar al Strategy y un setter
   2. Dejar un método (calcularMontoFinal()) en el contexto que delegue
   3. Elegir los parámetros necesarios para el Strategy (ninguno, pero el método de la estrategia sí recibe uno)
5.3) Extract Parameter en el código del contexto que inicializa un Strategy concreto
5.4) Replace Conditional with Polymorphism en el método del Strategy

public class Pago {
    private List<Producto> productos;
    private Strategy estrategia;

    public Pago(Strategy estrategia, List<Producto> productos) {
        this.estrategia = estrategia;
        this.productos = productos;
    }

    public double calcularMontoFinal() {
        // Se elimina la variable double total innecesaria -> Refactoring eliminacion de variables innecesarias
        return this.estrategia.calcularProductos(this.productos);
    }
}

public interface Strategy {
    public double calcularProductos(List<Producto> productos);
}

public class Efectivo implements Strategy {
    private static final double DESCUENTO_EFECTIVO = 2000.0;

    public double calcularProductos(List<Producto> productos) {
        double total = productos.stream().mapToDouble(p -> p.getPrecioConIVA()).sum();
        return total > 100000 ? total - DESCUENTO_EFECTIVO : total;
    }
}

public class Tarjeta implements Strategy {
    private static final double ADICIONAL_TARJETA = 1000.0;

    public double calcularProductos(List<Producto> productos) {
        return productos.stream().mapToDouble(p -> p.getPrecioConIVA()).sum() + ADICIONAL_TARJETA;
    }
}

public class Producto {
    private double precio;
    private double IVA;

    public Producto(double precio, double IVA) {
        this.precio = precio;
        this.IVA = IVA;
    }

    public double getPrecio() {
        return this.precio;
    }

    public double getIVA() {
        return this.IVA;
    }

    public double getPrecioConIVA() {
        return this.precio + (this.precio * this.IVA);
    }
}