### Bad Smell: Long Method
### Refactoring 1: Extract Method
El método personajeConMasDaño() de la clase Videojuego tiene asignadas muchas responsabilidades, se extrae el cálculo del daño del personaje.

### Bad Smell: Feature Envy
### Refactoring 2: Move Method
El método que cálcula el daño del personaje de la clase Videojuego ejecuta lógica que debería estar asignada a la clase Personaje.

### Bad Smell: Reinventando la rueda
### Refactoring 3: Replace loop with pipeline
El método personajeConMasDaño() reinventa la ruedad en el for. Se usan streams.

### Bad Smell: Variables locales innecesarias
### Refactoring 4: Eliminación de variables innecesarias

### Bad Smell: Feature Envy
### Refactoring 5: Extract Method y luego Move Method
El método imprimirInfo(Personaje p) de la clase Videojuego ejecuta lógica de impresión que debería estar asignada a la clase Personaje. Primero se extrae toda esa funcionalidad en un método imprimir() y luego se mueve el método a la clase Personaje.

### Bad Smell: Switch Statement
### Refactoring 6: Replace conditional with polymorphism
El método imprimir de la clase Personaje tiene un if-else que se puede resolver aplicando polimorfismo y delegando responsabilidades.

### Código final
```java
public class Videojuego {
    // Se aplicó Refactoring 1, Refactoring 2, Refactoring 3 y Refactoring 4
    public Personaje personajeConMasDaño() {
        return this.personajes.stream().max(Comparator.comparingDouble(p -> p.calcularDaño())).orElse(null);
    }

    // Se aplicó Refactoring 5
    public void imprimirInfo(Personaje p) {
        System.out.println(p.imprimir());
    }
}

public class Personaje {
    // ...
    // Se aplicó Refactoring 5 y 6
    public String imprimir() {
        return p.getNombre() + "tiene como daño " + p.getDaño() + this.tipoAtaque.imprimir();
    }
}

public abstract class TipoAtaque { 
    // Se aplicó Refactoring 6
    public abstract String imprimir(); 
}

public class AtaqueHechizo { 
    // Se aplicó Refactoring 6
    public String imprimir() {
        return "Ataque tipo hechizo Este ataque dobla tu fuerza";
    }
}

public class AtaqueBasico {
    // Se aplicó Refactoring 6
    public String imprimir() {
        return "Ataque tipo Ataque Básico Este ataque mantiene tu fuerza";
    }
}

```