### Factura - LineaDeFactura - Producto

Bad smell: Feature Envy
Refactoring 1: Extract Method 
La funcionalidad de imprimir la información de una linea de factura dentro del método imprimirDetalleConTotales() de la clase Factura debería ser extraída en un nuevo método (imprimirLineaFactura(LineaDeFactura lineaDeFactura)).

Bad smell: Feature Envy
Refactoring 2: Move Method
El método imprimirLineaFactura(LineaDeFactura lineaDeFactura) de la clase Factura ejecuta lógica que debería estar asignada a la clase LineaDeFactura.

Bad smell: Reinventando la rueda
Refactoring 3: Replace loop with pipeline
El método imprimirDetalleConTotales() reinventa sus lazos, debería usarse streams para recorrer la colección.

Bad smell: Feature Envy
Refactoring 4: Extract Method
La funcionalidad de calcular el precio de una línea de factura dentro del método imprimirDetalleConTotales() de la clase Factura debería ser extraída en un nuevo método calcularLinea(LineaDeFactura lineaDeFactura).

Bad smell: Feature Envy
Refactoring 5: Move Method
El método calcularLinea(LineaDeFactura lineaDeFactura) de la clase Factura ejecuta lógica que debería estar asignada a la clase LineaDeFactura. Ya con este método se puede aprovechar el refactoring 2 y llamar al método que se movió en este punto.

Bad smell: Feature Envy
En la clase LineaDeFactura el imprimir(anteriormente imprimirLineaFactura(LineaDeFactura lineaDeFactura)) ejecuta lógica que debería estar asignada a la clase Producto, pero se debe mantener el comportamiento del programa y no se puede modificar. 

Bad smell: Magic Numbers
Refactoring 6: Replace Magic Number with Symbolic Constant
Se reemplaza el número de IVA (1.21) por una constante con un nombre significativo.

public class Factura {
    private List<LineaDeFactura> items;
    private final static double IMPUESTO_IVA;

    public void imprimirDetalleConTotales() {
        String message = "Detalle de los items facturados";
        message += personaje.stream().map(LineaDeFactura::imprimir).collect(Collectors.joining());
        message += "Total sin impuestos";
        double totalSinImpuestos = item.stream().mapToDouble(lineaDeFactura -> lineaDeFactura.calcularFactura()).sum();
        message += String.format("Total: %s", totalSinImpuestos);
        message += "Total con IVA";
        message += String.format("Total: %s, totalSinImpuestos*IMPUESTO_IVA);
        System.out.println(message);
    }
}

public class LineaDeFactura {
    private Producto producto;
    private int cantidad;

    public Producto getProducto() {
        return this.producto;
    }

    public int getCantidad() {
        return this.cantidad;
    }

    public String imprimir() {
        return String.format("Producto: %s", this.producto.getNombre()) + String.format(" Cantidad: %s", this.cantidad) + String.format("Precio unitario: %s", this.producto.getPrecio()) + String.format("Total por producto: %s", this.calcularLinea());
    }

    public double calcularLinea() {
        return this.cantidad * this.producto.getPrecio();
    }
}

public class Producto {
    private String nombre;
    private double precio;

    public double getPrecio() {
        return this.precio;
    }

    public double getNombre() {
        return this.nombre;
    }
    
}