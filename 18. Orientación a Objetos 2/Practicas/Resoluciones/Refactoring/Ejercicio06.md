# Ejercicio 6: Árboles binarios

<a href="https://ibb.co/xKcVMFmP"><img src="https://i.ibb.co/kVrYhm3k/Ejercicio6-Refactoring.png" alt="Ejercicio6-Refactoring" border="0"></a>

### Código original
```java
public class ArbolBinario {
    private int valor;
    private ArbolBinario hijoIzquierdo;
    private ArbolBinario hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArbolBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(ArbolBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public ArbolBinario getHijoDerecho() {
        return hijoDerecho;
    }

    public void setDerecha(ArbolBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

   public String recorrerPreorden() {
        String resultado = valor + " - ";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPreorden();
	    }
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPreorden();
        }
        return resultado;
    }

   public String recorrerInorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerInorden();
	    }
        resultado += valor + " - ";
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerInorden();
        }
        return resultado;
    }

   public String recorrerPostorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPostorden();
	    }
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPostorden();
        }
        resultado += valor + " - ";
        return resultado;
    }

}
```
### Bad Smell: *Duplicated Code*
La lógica para manejarse con un valor nulo en las variables `hijoIzquierdo` e `hijoDerecho` está duplicado por todo el código de la clase `ArbolBinario`.

### Solución: Aplicar *Introduce Null Object*
La idea es reemplazar la lógica de testeo por null con un Null Object. Primero que nada se creará la interfaz a implementar por la clase `ArbolBinario`.
```java
public interface IArbolBinario {
	public int getValor();
    public void setValor(int valor);
    public ArbolBinario getHijoIzquierdo();
    public void setHijoIzquierdo(ArbolBinario hijoIzquierdo);
    public ArbolBinario getHijoDerecho();
    public void setDerecha(ArbolBinario hijoDerecho);
    public String recorrerPreorden();
    public String recorrerInorden();
    public String recorrerPostorden();
}

public class ArbolBinario implements IArbolBinario{
    private int valor;
    private ArbolBinario hijoIzquierdo;
    private ArbolBinario hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public ArbolBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(ArbolBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public ArbolBinario getHijoDerecho() {
        return hijoDerecho;
    }

    public void setDerecha(ArbolBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public String recorrerPreorden() {
        String resultado = valor + " - ";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPreorden();
	    }
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPreorden();
        }
        return resultado;
    }

    public String recorrerInorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerInorden();
	    }
        resultado += valor + " - ";
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerInorden();
        }
        return resultado;
    }

    public String recorrerPostorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPostorden();
	    }
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPostorden();
        }
        resultado += valor + " - ";
        return resultado;
    }
}
```

### Paso 1: 
Crear el null object aplicando *Extract Subclass* sobre la clase que se quiere proteger del chequeo por null (`ArbolBinario`).
Alternativamente hacer que la nueva clase (`ArbolBinarioNull`) implemente la misma interface que la clase origen. Compilar.

```java
public interface IArbolBinario {
	public int getValor();
    public void setValor(int valor);
    public IArbolBinario getHijoIzquierdo();
    public void setHijoIzquierdo(IArbolBinario hijoIzquierdo);
    public IArbolBinario getHijoDerecho();
    public void setDerecha(IArbolBinario hijoDerecho);
    public String recorrerPreorden();
    public String recorrerInorden();
    public String recorrerPostorden();
}

public class ArbolBinario implements IArbolBinario{
    private int valor;
    private IArbolBinario hijoIzquierdo;
    private IArbolBinario hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    ...

}

public class ArbolBinarioNull implements IArbolBinario{

	public class ArbolBinarioNull implements IArbolBinario{

	@Override
	public int getValor() {
		return 0;
	}

	@Override
	public void setValor(int valor) {
		
	}

	@Override
	public IArbolBinario getHijoIzquierdo() {
		return this;
	}

	@Override
	public void setHijoIzquierdo(IArbolBinario hijoIzquierdo) {
	}

	@Override
	public IArbolBinario getHijoDerecho() {
		return null;
	}

	@Override
	public void setDerecha(IArbolBinario hijoDerecho) {
	}

	@Override
	public String recorrerPreorden() {
		return null;
	}

	@Override
	public String recorrerInorden() {
		return null;
	}

	@Override
	public String recorrerPostorden() {
		return null;
	}

}

}
```

### Paso 2:
Buscar un null check en el código cliente (`ArbolBinario`), es decir, código que invoque un método sobre una instancia de la clase origen si la misma no es null. Redefinir el método en la clase del null object para que implemente el comportamiento alternativo. Compilar.

```java
public interface IArbolBinario {
	public int getValor();
    public void setValor(int valor);
    public IArbolBinario getHijoIzquierdo();
    public void setHijoIzquierdo(IArbolBinario hijoIzquierdo);
    public IArbolBinario getHijoDerecho();
    public void setDerecha(IArbolBinario hijoDerecho);
    public String recorrerPreorden();
    public String recorrerInorden();
    public String recorrerPostorden();
}

public class ArbolBinario implements IArbolBinario{
    private int valor;
    private IArbolBinario hijoIzquierdo;
    private IArbolBinario hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public int getValor() {
        return valor;
    }

    ...

}

public class ArbolBinarioNull implements IArbolBinario{

	@Override
	public int getValor() {
		return Integer.MIN_VALUE;
	}

	...

}
```

### Paso 3:
Repetir el paso 2 para todos los null checks asociados a la clase origen (`ArbolBinario`).
```java
public interface IArbolBinario {
	public int getValor();
    public void setValor(int valor);
    public IArbolBinario getHijoIzquierdo();
    public void setHijoIzquierdo(IArbolBinario hijoIzquierdo);
    public IArbolBinario getHijoDerecho();
    public void setDerecha(IArbolBinario hijoDerecho);
    public String recorrerPreorden();
    public String recorrerInorden();
    public String recorrerPostorden();
}

public class ArbolBinario implements IArbolBinario{
    private int valor;
    private IArbolBinario hijoIzquierdo;
    private IArbolBinario hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public IArbolBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(IArbolBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public IArbolBinario getHijoDerecho() {
        return hijoDerecho;
    }

    public void setDerecha(IArbolBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public String recorrerPreorden() {
        String resultado = valor + " - ";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPreorden();
        }
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPreorden();
        }
        return resultado;
    }

    public String recorrerInorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerInorden();
        }
        resultado += valor + " - ";
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerInorden();
        }
        return resultado;
    }

    public String recorrerPostorden() {
        String resultado = "";
        if (this.getHijoIzquierdo() != null) {
        	resultado += this.getHijoIzquierdo().recorrerPostorden();
        }
        if (this.getHijoDerecho() != null) {
        	resultado += this.getHijoDerecho().recorrerPostorden();
        }
        resultado += valor + " - ";
        return resultado;
    }

}

public class ArbolBinarioNull implements IArbolBinario{

	@Override
	public int getValor() {
		return Integer.MIN_VALUE;
	}

	@Override
	public void setValor(int valor) {}

	@Override
	public IArbolBinario getHijoIzquierdo() {
		return new ArbolBinarioNull();
	}

	@Override
	public void setHijoIzquierdo(IArbolBinario hijoIzquierdo) {}

	@Override
	public IArbolBinario getHijoDerecho() {
		return new ArbolBinarioNull();
	}

	@Override
	public void setDerecha(IArbolBinario hijoDerecho) {}

	@Override
	public String recorrerPreorden() {
		return "";
	}

	@Override
	public String recorrerInorden() {
		return "";
	}

	@Override
	public String recorrerPostorden() {
		return "";
	}

}
```

### Paso 4: 
Encontrar todos los lugares que pueden retornar null cuando se le pide una instancia de la clase origen. Inicializar con una instancia del null object lo antes posible. Compilar.

```java
public interface IArbolBinario {
	public int getValor();
    public void setValor(int valor);
    public IArbolBinario getHijoIzquierdo();
    public void setHijoIzquierdo(IArbolBinario hijoIzquierdo);
    public IArbolBinario getHijoDerecho();
    public void setDerecha(IArbolBinario hijoDerecho);
    public String recorrerPreorden();
    public String recorrerInorden();
    public String recorrerPostorden();
}

public class ArbolBinario implements IArbolBinario{
    private int valor;
    private IArbolBinario hijoIzquierdo;
    private IArbolBinario hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = new ArbolBinarioNull();
        this.hijoDerecho = new ArbolBinarioNull();
    }

    ...

}

public class ArbolBinarioNull implements IArbolBinario{

	...

}
```

### Paso 5:
Para cada lugar elegido en el paso 4, eliminar los null checks asociados. 
```java
public interface IArbolBinario {
	public int getValor();
    public void setValor(int valor);
    public IArbolBinario getHijoIzquierdo();
    public void setHijoIzquierdo(IArbolBinario hijoIzquierdo);
    public IArbolBinario getHijoDerecho();
    public void setDerecha(IArbolBinario hijoDerecho);
    public String recorrerPreorden();
    public String recorrerInorden();
    public String recorrerPostorden();
}

public class ArbolBinario implements IArbolBinario{
    private int valor;
    private IArbolBinario hijoIzquierdo;
    private IArbolBinario hijoDerecho;

    public ArbolBinario(int valor) {
        this.valor = valor;
        this.hijoIzquierdo = new ArbolBinarioNull();
        this.hijoDerecho = new ArbolBinarioNull();
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public IArbolBinario getHijoIzquierdo() {
        return hijoIzquierdo;
    }

    public void setHijoIzquierdo(IArbolBinario hijoIzquierdo) {
        this.hijoIzquierdo = hijoIzquierdo;
    }

    public IArbolBinario getHijoDerecho() {
        return hijoDerecho;
    }

    public void setDerecha(IArbolBinario hijoDerecho) {
        this.hijoDerecho = hijoDerecho;
    }

    public String recorrerPreorden() {
        return valor + " - " + this.getHijoIzquierdo().recorrerPreorden() + this.getHijoDerecho().recorrerPreorden();
     }

    public String recorrerInorden() {
        return "" + this.getHijoIzquierdo().recorrerInorden() + valor + " - " + this.getHijoDerecho().recorrerInorden();
     }

    public String recorrerPostorden() {
    	return "" + this.getHijoIzquierdo().recorrerPostorden() + this.getHijoDerecho().recorrerPostorden() + valor + " - ";
    }

}

public class ArbolBinarioNull implements IArbolBinario{

	@Override
	public int getValor() {
		return Integer.MIN_VALUE;
	}

	@Override
	public void setValor(int valor) {}

	@Override
	public IArbolBinario getHijoIzquierdo() {
		return new ArbolBinarioNull();
	}

	@Override
	public void setHijoIzquierdo(IArbolBinario hijoIzquierdo) {}

	@Override
	public IArbolBinario getHijoDerecho() {
		return new ArbolBinarioNull();
	}

	@Override
	public void setDerecha(IArbolBinario hijoDerecho) {}

	@Override
	public String recorrerPreorden() {
		return "";
	}

	@Override
	public String recorrerInorden() {
		return "";
	}

	@Override
	public String recorrerPostorden() {
		return "";
	}

}
```

### UML: 
<a href="https://ibb.co/vCSRq2Gk"><img src="https://i.ibb.co/qLvVjbfp/Ejercicio6-Null-Refactoring.png" alt="Ejercicio6-Null-Refactoring" border="0"></a>