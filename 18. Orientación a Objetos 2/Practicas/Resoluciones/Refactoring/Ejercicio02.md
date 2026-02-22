# Ejercicio 2

## 2.1 Empleados

### Código original

```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
    return this.sueldoBasico 
    + (this.horasTrabajadas * 500) 
    - (this.cantidadHijos * 1000) 
    - (this.sueldoBasico * 0.13);
    }
}


public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico 
            + (this.cantidadHijos * 2000)
            - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```
### Bad Smell: Duplicated Code
Las clases `EmpleadoTemporario`, `EmpleadoPlanta`, `EmpleadoPasante` cuentan con campos y métodos comunes.

### Solución: Aplicar *Extract Superclass*
```java
public abstract class Empleado {}

public class EmpleadoTemporario extends Empleado{
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
    return this.sueldoBasico 
    + (this.horasTrabajadas * 500) 
    - (this.cantidadHijos * 1000) 
    - (this.sueldoBasico * 0.13);
    }
}


public class EmpleadoPlanta extends Empleado{
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico 
            + (this.cantidadHijos * 2000)
            - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante extends Empleado{
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```

### Bad Smell: Duplicated Code
Las clases `EmpleadoTemporario`, `EmpleadoPlanta`, `EmpleadoPasante` siguen contando con los mismos campos.

### Solución: Aplicar *Pull Up Field*
```java
public abstract class Empleado {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
}

public class EmpleadoTemporario extends Empleado{
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
    return this.sueldoBasico 
    + (this.horasTrabajadas * 500) 
    - (this.cantidadHijos * 1000) 
    - (this.sueldoBasico * 0.13);
    }
}


public class EmpleadoPlanta extends Empleado{
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoBasico 
            + (this.cantidadHijos * 2000)
            - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante extends Empleado{
    // ......
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```

### Bad Smell: Duplicated Code
Las clases `EmpleadoTemporario`, `EmpleadoPlanta`, `EmpleadoPasante` siguen contando con los mismos métodos.

### Solución: Aplicar *Extract Method*
```java
public abstract class Empleado {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
}

public class EmpleadoTemporario extends Empleado{
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoConDescuento() + this.horasTrabajadas() + this.asignacionFamiliar();
    }

    private double sueldoConDescuento() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

    private double horasTrabajadas() {
        return this.horasTrabajas * 500;
    }

    private double aportes() {
        return this.sueldoBasico * 0.13;
    }
    
}

public class EmpleadoPlanta extends Empleado{
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return this.sueldoConDescuento() + this.asignacionFamiliar();
    }

    private double sueldoConDescuento() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

    private double aportes() {
        return this.sueldoBasico * 0.13;
    }
}

public class EmpleadoPasante extends Empleado{
    // ......
    
    public double sueldo() {
        return this.sueldoConDescuento();
    }

    private double sueldoConDescuento() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

}
```

### Bad Smell: Duplicated Code
Las clases `EmpleadoTemporario`, `EmpleadoPlanta`, `EmpleadoPasante` siguen contando con los mismos métodos: `sueldo` y `sueldoConDescuento` .

### Solución: Aplicar *Pull Up Method*
```java
public abstract class Empleado {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;

    public double sueldo() {
        return this.sueldoConDescuento();
    }

    private double sueldoConDescuento() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

}

public class EmpleadoTemporario extends Empleado{
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return super.sueldo() + this.horasTrabajadas() + this.asignacionFamiliar();
    }

    private double horasTrabajadas() {
        return this.horasTrabajas * 500;
    }

    private double asignacionFamiliar() {
        return (this.cantidadHijos * 1000);
    }
    
}

public class EmpleadoPlanta extends Empleado{
    public int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return super.sueldo() + this.asignacionFamiliar();
    }

}

public class EmpleadoPasante extends Empleado{
    // ......

}
```

### Bad Smell: Lazy Class
La clase `EmpleadoPasante` es pequeña, pero por un tema de expresividad y de diseño, se quiere dejar dejar la diferenciación entre `Empleado` y `EmpleadoPasante`.

### Bad Smell: Duplicated Code
La clase `EmpleadoTemporario` y `EmpleadoPlanta` comparten la variable de instancia `cantidadHijos`, pero considero que no vale la pena generar otra super clase, y mover dicho atributo a la misma, por una sola variable y un metodo.

### Bad Smell: Rompe el encapsulamiento
En la clase `Empleado`, `EmpleadoTemporario` y `EmpleadoPlanta` las variables de instancias son públicas, lo que viola el encapsulamiento.

### Solución: Aplicar *Encapsulate Field* 
```java
public abstract class Empleado {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;

    public double sueldo() {
        return this.sueldoConDescuento();
    }

    private double sueldoConDescuento() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

}

public class EmpleadoTemporario extends Empleado{
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return super.sueldo() + this.horasTrabajadas() + this.asignacionFamiliar();
    }

    private double horasTrabajadas() {
        return this.horasTrabajas * 500;
    }

    private double asignacionFamiliar() {
        return (this.cantidadHijos * 1000);
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }
    
}

public class EmpleadoPlanta extends Empleado{
    private int cantidadHijos = 0;
    // ......
    
    public double sueldo() {
        return super.sueldo() + this.asignacionFamiliar();
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

}

public class EmpleadoPasante extends Empleado{
    // ......

}
```

### Bad Smell: Nombre de método poco explicativo
El nombre `sueldo()` no refleja claramente lo que hace.

### Solución: Aplicar *Rename Method*
```java
public abstract class Empleado {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;

    public double calcularSueldo() {
        return this.sueldoConDescuento();
    }

    private double sueldoConDescuento() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public double getSueldoBasico() {
        return this.sueldoBasico;
    }

    public void setSueldoBasico(double sueldoBasico) {
        this.sueldoBasico = sueldoBasico;
    }

}

public class EmpleadoTemporario extends Empleado{
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;
    // ......
    
    public double calcularSueldo() {
        return super.calcularSueldo() + this.horasTrabajadas() + this.asignacionFamiliar();
    }

    private double horasTrabajadas() {
        return this.horasTrabajas * 500;
    }

    private double asignacionFamiliar() {
        return (this.cantidadHijos * 1000);
    }

    public double getHorasTrabajadas() {
        return this.horasTrabajadas;
    }

    public void setHorasTrabajadas(double horasTrabajadas) {
        this.horasTrabajadas = horasTrabajadas;
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }
    
}

public class EmpleadoPlanta extends Empleado{
    private int cantidadHijos = 0;
    // ......
    
    public double calcularSueldo() {
        return super.calcularSueldo() + this.asignacionFamiliar();
    }

    public int getCantidadHijos() {
        return this.cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
        this.cantidadHijos = cantidadHijos;
    }

}

public class EmpleadoPasante extends Empleado{
    // ......

}
```

---

## 2.2 Juego

### Código original
```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
}
```

### Bad Smell: Rompe el encapsulamiento
En la clase `Jugador` las variables de instancias son públicas, lo que viola el encapsulamiento.

### Solución: Aplicar *Encapsulate Field* 

```java
public class Juego {
    // ......
    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
```

### Bad Smell: Nombres de métodos poco explicativos
Los nombres de métodos `incrementar()` y `decrementar()` no reflejan claramente lo que hacen.

### Solución: Aplicar *Rename Method*
```java
public class Juego {
    // ......
    public void incrementarPuntuacion(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementarPuntuacion(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }
}
```

### Bad Smell: *Feature Envy*
Los métodos `incrementarPuntuacion()` y `decrementarPuntuacion()` en la clase `Juego` ejecutan lógica que debería estar asignada a la clase `Jugador`, habiendo responsabilidades mal asignadas.

### Solución: Aplicar *Move Method*
Mover los dos métodos de incremento y decremento de puntos a la clase `Jugador` y, en la clase `Juego` convertir el código del método original en una referencia al nuevo método en la otra clase.
```java
public class Juego {
    // ......
    public void incrementarPuntuacion(Jugador j) {
        j.incrementarPuntuacion();
    }
    public void decrementarPuntuacion(Jugador j) {
        j.decrementarPuntuacion();
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return this.apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getPuntuacion() {
        return this.puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void incrementarPuntuacion() {
        this.puntuacion += 100;
    }

    public void decrementarPuntuacion() {
        this.puntuacion -= 50;
    }
}
```


---

## 2.3 Publicaciones

<a href="https://ibb.co/9HHY2rcG"><img src="https://i.ibb.co/1GG2Km7b/UML.jpg" alt="UML" border="0"></a>

### Código original
```java
/**
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
        
    List<Post> postsOtrosUsuarios = new ArrayList<Post>();
    for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }
        
   // ordena los posts por fecha
   for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
       int masNuevo = i;
       for(int j= i +1; j < postsOtrosUsuarios.size(); j++) {
           if (postsOtrosUsuarios.get(j).getFecha().isAfter(
     postsOtrosUsuarios.get(masNuevo).getFecha())) {
              masNuevo = j;
           }    
       }
      Post unPost = postsOtrosUsuarios.set(i,postsOtrosUsuarios.get(masNuevo));
      postsOtrosUsuarios.set(masNuevo, unPost);    
   }
        
    List<Post> ultimosPosts = new ArrayList<Post>();
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() &&  index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }
    return ultimosPosts;
}
```

### Bad Smell: *Long Method*
El método `ultimosPosts()` hace demasiadas cosas. 

### Solución: Aplicar *Extract Method*
Se extraen las funcionalidades de: obtener los posts que no pertenezcan a un usuario, ordenar posts por fecha, y el filtrado de los primeros post hasta una cantidad determinada.
```java
/**
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    List<Post> postsOtrosUsuarios = new ArrayList<Post>();
    getPostsOtrosUsuarios(user, postsOtrosUsuarios);
        
    ordenarPostsPorFecha(postsOtrosUsuarios);

    List<Post> ultimosPosts = new ArrayList<Post>();
    filtrarPrimerosNPosts(cantidad, postsOtrosUsuarios, ultimosPosts);
        
    return ultimosPosts;
}

private void getPostsOtrosUsuarios(Usuario user, List<Post> postsOtrosUsuarios) {
    for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }
}

private void ordenarPostsPorFecha(List<Post> postsOtrosUsuarios) {
    for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
        int masNuevo = i;
        for(int j = i +1; j < postsOtrosUsuarios.size(); j++) {
            if (postsOtrosUsuarios.get(j).getFecha().isAfter(
                    postsOtrosUsuarios.get(masNuevo).getFecha())) {
                masNuevo = j;
            }
        }
        Post unPost = postsOtrosUsuarios.set(i, postsOtrosUsuarios.get(masNuevo));
        postsOtrosUsuarios.set(masNuevo, unPost);
    }
}

private void filtrarPrimerosNPosts(int cantidad, List<Post> postsOtrosUsuarios, List<Post> ultimosPosts) {
    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() &&  index < cantidad) {
            ultimosPosts.add(postIterator.next());
    }
}
```

### Bad Smell: *Long Method*
El método `ultimosPosts()` aún puede simplificarse eliminando las variables temporales.

### Solución: Aplicar *Replace Temp with Query*
```java
/**
* Retorna los últimos N posts que no pertenecen al usuario user
*/
public List<Post> ultimosPosts(Usuario user, int cantidad) {
    List<Post> postsOtrosUsuarios = getPostsOtrosUsuarios(user);

    ordenarPostsPorFecha(postsOtrosUsuarios);
        
    return filtrarPrimerosNPosts(cantidad, postsOtrosUsuarios);
}

private List<Post> getPostsOtrosUsuarios(Usuario user) {
    List<Post> postsOtrosUsuarios = new ArrayList<Post>();

    for (Post post : this.posts) {
        if (!post.getUsuario().equals(user)) {
            postsOtrosUsuarios.add(post);
        }
    }

    return postsOtrosUsuarios;
}

private void ordenarPostsPorFecha(List<Post> postsOtrosUsuarios) {
    for (int i = 0; i < postsOtrosUsuarios.size(); i++) {
        int masNuevo = i;
        for(int j = i +1; j < postsOtrosUsuarios.size(); j++) {
            if (postsOtrosUsuarios.get(j).getFecha().isAfter(
                    postsOtrosUsuarios.get(masNuevo).getFecha())) {
                masNuevo = j;
            }
        }
        Post unPost = postsOtrosUsuarios.set(i, postsOtrosUsuarios.get(masNuevo));
        postsOtrosUsuarios.set(masNuevo, unPost);
    }
}

private List<Post> filtrarPrimerosNPosts(int cantidad, List<Post> postsOtrosUsuarios) {
    List<Post> ultimosPosts = new ArrayList<>();

    int index = 0;
    Iterator<Post> postIterator = postsOtrosUsuarios.iterator();
    while (postIterator.hasNext() &&  index < cantidad) {
        ultimosPosts.add(postIterator.next());
    }

    return ultimosPosts;
}
```

### Bad Smell: *Reinventando la rueda* en tres métodos distintos
Los métodos `getPostsOtrosUsuarios`, `filtrarPrimerosNPosts` y `ordenarPostsPorFecha` reinventan la rueda en sus lazos, y pueden reemplazarse con una solución más moderna usando streams.

### Solución: Aplicar *Replace Loop with Pipeline*
```java
public class PostApp {
    private List<Post> posts;

    public List<Post> ultimosPosts(Usuario user, int cantidad) {
        // También hice replace temp with query
        return filtrarPrimerosNPosts(cantidad, ordenarPostsPorFecha(getPostsOtrosUsuarios(user)));
    }

    private List<Post> getPostsOtrosUsuarios(Usuario user) {
        return posts.stream().filter(
                post -> !post.getUsuario().equals(user)) // ¿Delegación a Post? Hay envidia de atributos
                .collect(Collectors.toList());
    }

    private List<Post> ordenarPostsPorFecha(List<Post> postsOtrosUsuarios) {
        return postsOtrosUsuarios.stream()
                .sorted((post1, post2) -> post1.getFecha().compareTo(post2.getFecha()))
                .collect(Collectors.toList());
    }

    private List<Post> filtrarPrimerosNPosts(int cantidad, List<Post> postsOtrosUsuarios) {
        return postsOtrosUsuarios.stream().limit(cantidad).collect(Collectors.toList());
    }
}
```
--- 

## 2.4 Carrito de compras

<a href="https://ibb.co/VcdD2qL4"><img src="https://i.ibb.co/1t3K8m0W/UMLCarrito.jpg" alt="UMLCarrito" border="0"></a>

### Código original
```java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
        
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
        return this.items.stream()
            .mapToDouble(item -> 
                item.getProducto().getPrecio() * item.getCantidad())
            .sum();
    }
}
```
### Bad Smell: *Feature Envy*
El método `total()` en la clase `Carrito` ejecuta lógica que debería estar asignada a la clase `ItemCarrito`, habiendo responsabilidades mal asignadas.

### Solución: Aplicar *Move Method*
Mover la funcionalidad de obtener el precio total de un producto, ahora `getTotal()`, a la clase `ItemCarrito` y, en la clase `Carrito` convertir el código del método original en una referencia al nuevo método en la otra clase.
```java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
        
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

    public int getTotal() {
        return producto.getPrecio() * getCantidad();
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
        return this.items.stream()
            .mapToDouble(item -> 
                item.getTotal())
            .sum();
    }
}
```

### Bad Smell: Nombre de métodos poco explicativos
Los métodos `getTotal` de la clase `ItemCarrito` y `total` de `Carrito`, tienen nombres poco explicativos.

### Solución: Aplicar *Rename Method*
```java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
        
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

    public int getPrecioTotal() {
        return producto.getPrecio() * getCantidad();
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double getPrecioTotal() {
        return this.items.stream()
            .mapToDouble(item -> 
                item.getPrecioTotal())
            .sum();
    }
}
```

---

## 2.5 Envio de pedidos

<a href="https://ibb.co/Kvs4kJG"><img src="https://i.ibb.co/8ZxvpHB/UMLEnvios.jpg" alt="UMLEnvios" border="0"></a>

### Código original
```java
public class Supermercado {
    public void notificarPedido(long nroPedido, Cliente cliente) {
        String notificacion = MessageFormat.format("Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}", new Object[] { nroPedido, cliente.getDireccionFormateada() });

        // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
        System.out.println(notificacion);
  }
}

public class Cliente {
    public String getDireccionFormateada() {
	    return 
		    this.direccion.getLocalidad() + ", " +
		    this.direccion.getCalle() + ", " +
		    this.direccion.getNumero() + ", " +
		    this.direccion.getDepartamento();
    }
}
```

### Bad Smell: Feature Envy
`Cliente` está accediendo a múltiples atributos de `Direccion`, lo que indica que probablemente `Direccion` debería encargarse de formatearse a sí misma.

### Solución: Aplicar *Move Method*
```java
public class Supermercado {
    public void notificarPedido(long nroPedido, Cliente cliente) {
        String notificacion = MessageFormat.format("Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}", new Object[] { nroPedido, cliente.getDireccionFormateada() });

        // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
        System.out.println(notificacion);
  }
}

public class Cliente {
    private Direccion direccion;

    public String getDireccionFormateada() {
	    return this.direccion.toString();
    }
}

public class Direccion {
    public String localidad;
    public String calle;
    public int numero;
    public String departamento;

    @Override
    public String toString() {
        return this.localidad + ", " + this.calle  + ", " + this.numero + ", " + this.departamento;
    }
}
```

### Bad Smell: Rompe el encapsulamiento
En la clase `Direccion`, las variables de instancias son públicas, lo que viola el encapsulamiento.

### Solución: Aplicar *Encapsulate Field*
```java
public class Supermercado {
    public void notificarPedido(long nroPedido, Cliente cliente) {
        String notificacion = MessageFormat.format("Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}", new Object[] { nroPedido, cliente.getDireccionFormateada() });

        // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
        System.out.println(notificacion);
  }
}

public class Cliente {
    private Direccion direccion;

    public String getDireccionFormateada() {
	    return this.direccion.toString();
    }
}

public class Direccion {
    private String localidad;
    private String calle;
    private int numero;
    private String departamento;

    public String getLocalidad() {
        return localidad;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return this.localidad + ", " + this.calle + ", " + this.numero + ", " + this.departamento;
    }
}
```

### Bad Smell: Middle Man
La clase `Cliente`, solo actúa como intermediario entre la clase `Supermercado` y la clase `Direccion`.

### Solución: Aplicar *Remove Middle Man*
```java
public class Supermercado {
    public void notificarPedido(long nroPedido, Direccion direccion) {
        String notificacion = MessageFormat.format("Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}", new Object[] { nroPedido, direccion.toString() });

        // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
        System.out.println(notificacion);
  }
}

public class Direccion {
    private String localidad;
    private String calle;
    private int numero;
    private String departamento;

    public String getLocalidad() {
        return localidad;
    }

    public String getCalle() {
        return calle;
    }

    public int getNumero() {
        return numero;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    @Override
    public String toString() {
        return this.localidad + ", " + this.calle + ", " + this.numero + ", " + this.departamento;
    }
}
```

---

## 2.6 Peliculas

<a href="https://ibb.co/DBzX0dB"><img src="https://i.ibb.co/XnjBcHn/UMLPeliculas.jpg" alt="UMLPeliculas" border="0"></a>

### Código original
```java
public class Usuario {
    String tipoSubscripcion;
    // ...

    public void setTipoSubscripcion(String unTipo) {
   	 this.tipoSubscripcion = unTipo;
    }
    
    public double calcularCostoPelicula(Pelicula pelicula) {
   	 double costo = 0;
   	 if (tipoSubscripcion=="Basico") {
   		 costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
   	 }
   	 else if (tipoSubscripcion== "Familia") {
   		 costo = (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
   	 }
   	 else if (tipoSubscripcion=="Plus") {
   		 costo = pelicula.getCosto();
   	 }
   	 else if (tipoSubscripcion=="Premium") {
   		 costo = pelicula.getCosto() * 0.75;
   	 }
   	 return costo;
    }
}

public class Pelicula {
    LocalDate fechaEstreno;
    // ...

    public double getCosto() {
   	 return this.costo;
    }
    
    public double calcularCargoExtraPorEstreno(){
	// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
   	return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
    }
}
```

### Bad Smell: Switch Statement
El método `calcularCostoPelicula` de la clase `Usuario` está lleno de if-else (switch).

### Solución: Aplicar *Replace Conditional with Polymorphism*
```java
public class Usuario {
    // ...
    private Subscripcion tipoSubscripcion;

    public void setTipoSubscripcion(Subscripcion unTipo) {
        this.tipoSubscripcion = unTipo;
    }

    public double calcularCostoPelicula(Pelicula pelicula) {
        return tipoSubscripcion.calcularCostoPelicula(pelicula);
    }
}

public interface Subscripcion {
    public double calcularCostoPelicula(Pelicula pelicula);
}

public class SubscripcionBasica implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
    }
}

public class SubscripcionFamilia implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
    }
}

public class SubscripcionPlus implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto();
    }
}

public class SubscripcionPremium implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto() * 0.75;
    }
}

public class Pelicula {
    private LocalDate fechaEstreno;
    // ...

    public double getCosto() {
   	 return this.costo;
    }
    
    public double calcularCargoExtraPorEstreno(){
	// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
   	return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
    }
}
```

### Bad Smell: Feature Envy
El método `calcularCostoPelicula` de las subclases `SubscripcionBasica` y `SubscripcionFamilia` ejecuta lógica que debería estar asignada a la clase `Pelicula`.

### Solución: Aplicar *Replace Conditional with Polymorphism*
```java
public class Usuario {
    // ...
    private Subscripcion tipoSubscripcion;

    public void setTipoSubscripcion(Subscripcion unTipo) {
        this.tipoSubscripcion = unTipo;
    }

    public double calcularCostoPelicula(Pelicula pelicula) {
        return tipoSubscripcion.calcularCostoPelicula(pelicula);
    }
}

public interface Subscripcion {
    public double calcularCostoPelicula(Pelicula pelicula);
}

public class SubscripcionBasica implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.calcularCostoConCargoExtra();
    }
}

public class SubscripcionFamilia implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.calcularCostoConCargoExtra() * 0.90;
    }
}

public class SubscripcionPlus implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto();
    }
}

public class SubscripcionPremium implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto() * 0.75;
    }
}

public class Pelicula {
    private LocalDate fechaEstreno;
    // ...

    public double getCosto() {
   	 return this.costo;
    }
    
    public double calcularCostoConCargoExtra() {
        return this.getCosto() + this.calcularCargoExtraPorEstreno();
    }

    public double calcularCargoExtraPorEstreno(){
	// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
   	return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
    }
}
```

### Bad Smell: Comments
Se puede eliminar el comentario del método `calcularCargoExtraPorEstreno` de la clase `Pelicula` ya que es autoexplicativo.

### Solución: Remover comentarios
```java
public class Usuario {
    // ...
    private Subscripcion tipoSubscripcion;

    public void setTipoSubscripcion(Subscripcion unTipo) {
        this.tipoSubscripcion = unTipo;
    }

    public double calcularCostoPelicula(Pelicula pelicula) {
        return tipoSubscripcion.calcularCostoPelicula(pelicula);
    }
}

public interface Subscripcion {
    public double calcularCostoPelicula(Pelicula pelicula);
}

public class SubscripcionBasica implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.calcularCostoConCargoExtra();
    }
}

public class SubscripcionFamilia implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.calcularCostoConCargoExtra() * 0.90;
    }
}

public class SubscripcionPlus implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto();
    }
}

public class SubscripcionPremium implements Subscripcion{
    @Override
    public double calcularCostoPelicula(Pelicula pelicula) {
        return pelicula.getCosto() * 0.75;
    }
}

public class Pelicula {
    private LocalDate fechaEstreno;
    // ...

    public double getCosto() {
   	 return this.costo;
    }
    
    public double calcularCostoConCargoExtra() {
        return this.getCosto() + this.calcularCargoExtraPorEstreno();
    }

    public double calcularCargoExtraPorEstreno(){
   	    return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
    }
}
```