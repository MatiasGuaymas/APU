# Ejercicio 4: Pedidos

<a href="https://ibb.co/twQzPTQw"><img src="https://i.ibb.co/kV5J6s5V/UMLEJ4.jpg" alt="UMLEJ4" border="0"></a>

### Código original
```java
01: public class Pedido {
02:  private Cliente cliente;
03:  private List<Producto> productos;
04:  private String formaPago;
05:  public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
06:     if (!"efectivo".equals(formaPago)
07:        && !"6 cuotas".equals(formaPago)
08:        && !"12 cuotas".equals(formaPago)) {
09:          throw new Error("Forma de pago incorrecta");
10:    }
11:    this.cliente = cliente;
12:    this.productos = productos;
13:    this.formaPago = formaPago;
14:   }
15:   public double getCostoTotal() {
16:     double costoProductos = 0;
17:     for (Producto producto : this.productos) {
18:       costoProductos += producto.getPrecio();
19:     }
20:     double extraFormaPago = 0;
21:     if ("efectivo".equals(this.formaPago)) {
22:       extraFormaPago = 0;
23:     } else if ("6 cuotas".equals(this.formaPago)) {
24:       extraFormaPago = costoProductos * 0.2;
25:     } else if ("12 cuotas".equals(this.formaPago)) {
26:       extraFormaPago = costoProductos * 0.5;
27:     }
28:     int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
29:     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
30:     if (añosDesdeFechaAlta > 5) {
31:       return (costoProductos + extraFormaPago) * 0.9;
32:     }
33:     return costoProductos + extraFormaPago;
34:   }
35: }
36: public class Cliente {
37:   private LocalDate fechaAlta;
38:   public LocalDate getFechaAlta() {
39:     return this.fechaAlta;
40:   }
41: }
42: public class Producto {
43:   private double precio;
44:   public double getPrecio() {
45:     return this.precio;
46:   }
47: }
```

### Bad Smell en líneas 16 a 19

### Solución: Aplicar *Replace Loop with Pipeline*
```java
01:	 public class Pedido {
02:  private Cliente cliente;
03:  private List<Producto> productos;
04:  private String formaPago;
05:  public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
06:     if (!"efectivo".equals(formaPago)
07:        && !"6 cuotas".equals(formaPago)
08:        && !"12 cuotas".equals(formaPago)) {
09:          throw new Error("Forma de pago incorrecta");
10:    }
11:    this.cliente = cliente;
12:    this.productos = productos;
13:    this.formaPago = formaPago;
14:   }
15:   public double getCostoTotal() {
16:     double costoProductos = this.productos
				.stream()
				.mapToDouble(producto -> producto.getCosto())
				.sum();
20:     double extraFormaPago = 0;
21:     if ("efectivo".equals(this.formaPago)) {
22:       extraFormaPago = 0;
23:     } else if ("6 cuotas".equals(this.formaPago)) {
24:       extraFormaPago = costoProductos * 0.2;
25:     } else if ("12 cuotas".equals(this.formaPago)) {
26:       extraFormaPago = costoProductos * 0.5;
27:     }
28:     int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
29:     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
30:     if (añosDesdeFechaAlta > 5) {
31:       return (costoProductos + extraFormaPago) * 0.9;
32:     }
33:     return costoProductos + extraFormaPago;
34:   }
35: }
36: public class Cliente {
37:   private LocalDate fechaAlta;
38:   public LocalDate getFechaAlta() {
39:     return this.fechaAlta;
40:   }
41: }
42: public class Producto {
43:   private double precio;
44:   public double getPrecio() {
45:     return this.precio;
46:   }
47: }
```

### Bad Smell en líneas 21 a 27

### Solución: Aplicar *Replace Conditional with Polymorphism*
```java
01:	 public class Pedido {
02:  private Cliente cliente;
03:  private List<Producto> productos;
04:  private FormaDePago formaPago;
05:  public Pedido(Cliente cliente, List<Producto> productos, FormaDePago formaPago) {
06:    this.formaPago = formaPago;
11:    this.cliente = cliente;
12:    this.productos = productos;
13:    this.formaPago = formaPago;
14:   }
15:   public double getCostoTotal() {
16:     double costoProductos = this.productos
				.stream()
				.mapToDouble(producto -> producto.getCosto())
				.sum();
20:     double extraFormaPago = this.formaPago.calcularPrecio(costoProductos);
28:     int añosDesdeFechaAlta = Period.between(this.cliente.getFechaAlta(), LocalDate.now()).getYears();
29:     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
30:     if (añosDesdeFechaAlta > 5) {
31:       return (costoProductos + extraFormaPago) * 0.9;
32:     }
33:     return costoProductos + extraFormaPago;
34:   }
35: }
36: public class Cliente {
37:   private LocalDate fechaAlta;
38:   public LocalDate getFechaAlta() {
39:     return this.fechaAlta;
40:   }
41: }
42: public class Producto {
43:   private double precio;
44:   public double getPrecio() {
45:     return this.precio;
46:   }
47: }

public interface FormaDePago{
	public double calcularPrecio(double costo);
}

public class Efectivo implements FormaDePago{
	public double calcularPrecio(double costo){
		return 0;
	}
}

public class SeisCuotas implements FormaDePago{
	public double calcularPrecio(double costo){
		return costo * 0.2;
	}
}

public class DoceCuotas implements FormaDePago{
	public double calcularPrecio(double costo){
		return costo * 0.5;
	}
}
```

### Bad Smell en línea 28

### Solución: Aplicar *Extract Method y Move Method*
```java
01:	 public class Pedido {
02:  private Cliente cliente;
03:  private List<Producto> productos;
04:  private FormaDePago formaPago;
05:  public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
06:    this.formaPago = formaPago;
11:    this.cliente = cliente;
12:    this.productos = productos;
13:    this.formaPago = formaPago;
14:   }
15:   public double getCostoTotal() {
16:     double costoProductos = this.productos
				.stream()
				.mapToDouble(producto -> producto.getCosto())
				.sum();
20:     double extraFormaPago = this.formaPago.calcularPrecio(costoProductos);
28:     int añosDesdeFechaAlta = this.cliente.calcularAntiguedad();
29:     // Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
30:     if (añosDesdeFechaAlta > 5) {
31:       return (costoProductos + extraFormaPago) * 0.9;
32:     }
33:     return costoProductos + extraFormaPago;
34:   }
35: }
36: public class Cliente {
37:   private LocalDate fechaAlta;
38:   public LocalDate getFechaAlta() {
39:     return this.fechaAlta;
40:   }		
	  public int calcularAntiguedad(){
		return Period.between(this.fechaAlta, LocalDate.now().getYears());
	  }
41: }
42: public class Producto {
43:   private double precio;
44:   public double getPrecio() {
45:     return this.precio;
46:   }
47: }

public interface FormaDePago{
	public double calcularPrecio(double costo);
}

public class Efectivo implements FormaDePago{
	public double calcularPrecio(double costo){
		return 0;
	}
}

public class SeisCuotas implements FormaDePago{
	public double calcularPrecio(double costo){
		return costo * 0.2;
	}
}

public class DoceCuotas implements FormaDePago{
	public double calcularPrecio(double costo){
		return costo * 0.5;
	}
}
```

### Bad Smell en líneas 28 a 33

### Solución: Aplicar *Extract Method y Replace Temp with Query*
```java
01:	 public class Pedido {
02:  private Cliente cliente;
03:  private List<Producto> productos;
04:  private FormaDePago formaPago;
05:  public Pedido(Cliente cliente, List<Producto> productos, String formaPago) {
06:    this.formaPago = formaPago;
11:    this.cliente = cliente;
12:    this.productos = productos;
13:    this.formaPago = formaPago;
14:   }
15:   public double getCostoTotal() {
16:     double costoProductos = this.productos
				.stream()
				.mapToDouble(producto -> producto.getCosto())
				.sum();
20:     double extraFormaPago = this.formaPago.calcularPrecio(costoProductos);
30:     return this.calcularDescuento(costoProductos, extraFormaPago);
34:   }
35: }
// Aplicar descuento del 10% si el cliente tiene más de 5 años de antiguedad
public double calcularDescuento(double costoP, double extra){
	if(this.cliente.calcularAntiguedad(); > 5){
		return(costoP + extra) * 0.9;
	}
	return costoP + extra;
}

36: public class Cliente {
37:   private LocalDate fechaAlta;
38:   public LocalDate getFechaAlta() {
39:     return this.fechaAlta;
40:   }		
	  public int calcularAntiguedad(){
		return Period.between(this.fechaAlta, LocalDate.now().getYears());
	  }
41: }

public class Producto {
    private double precio;
    public double getPrecio() {
        return this.precio;
    }
}

public interface FormaDePago{
	public double calcularPrecio(double costo);
}

public class Efectivo implements FormaDePago{
	public double calcularPrecio(double costo){
		return 0;
	}
}

public class SeisCuotas implements FormaDePago{
	public double calcularPrecio(double costo){
		return costo * 0.2;
	}
}

public class DoceCuotas implements FormaDePago{
	public double calcularPrecio(double costo){
		return costo * 0.5;
	}
}
```

### UML: 
<a href="https://ibb.co/9mqP5Gj6"><img src="https://i.ibb.co/qLR6QxwK/UMLEJ4-Refactor.jpg" alt="UMLEJ4-Refactor" border="0"></a>


