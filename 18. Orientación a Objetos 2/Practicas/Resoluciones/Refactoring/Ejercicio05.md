# Ejercicio 5: Facturación de llamadas

### Código original
```java
public class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private String tipo;
	private String nombre;
	private String numeroTelefono;
	private String cuit;
	private String dni;

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
}

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	static double descuentoJur = 0.15;
	static double descuentoFis = 0;

	public boolean agregarNumeroTelefono(String str) {
		boolean encontre = guia.getLineas().contains(str);
		if (!encontre) {
			guia.getLineas().add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}

	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}

	public Cliente registrarUsuario(String data, String nombre, String tipo) {
		Cliente var = new Cliente();
		if (tipo.equals("fisica")) {
			var.setNombre(nombre);
			String tel = this.obtenerNumeroLibre();
			var.setTipo(tipo);
			var.setNumeroTelefono(tel);
			var.setDNI(data);
		}
		else if (tipo.equals("juridica")) {
			String tel = this.obtenerNumeroLibre();
			var.setNombre(nombre);
			var.setTipo(tipo);
			var.setNumeroTelefono(tel);
			var.setCuit(data);
		}
		clientes.add(var);
		return var;
	}

	public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		double c = 0;
		for (Llamada l : cliente.llamadas) {
			double auxc = 0;
			if (l.getTipoDeLlamada() == "nacional") {
				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
			} else if (l.getTipoDeLlamada() == "internacional") {
				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
			}

			if (cliente.getTipo() == "fisica") {
				auxc -= auxc*descuentoFis;
			} else if(cliente.getTipo() == "juridica") {
				auxc -= auxc*descuentoJur;
			}
			c += auxc;
		}
		return c;
	}

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() {
		return this.guia;
	}
}

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private String tipoGenerador = "ultimo";

	public SortedSet<String> getLineas() {
		return lineas;
	}

	public String obtenerNumeroLibre() {
		String linea;
		switch (tipoGenerador) {
			case "ultimo":
				linea = lineas.last();
				lineas.remove(linea);
				return linea;
			case "primero":
				linea = lineas.first();
				lineas.remove(linea);
				return linea;
			case "random":
				linea = new ArrayList<String>(lineas)
						.get(new Random().nextInt(lineas.size()));
				lineas.remove(linea);
				return linea;
		}
		return null;
	}

	public void cambiarTipoGenerador(String valor) {
		this.tipoGenerador = valor;
	}
}

public class Llamada {
	private String tipoDeLlamada;
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String tipoLlamada, String origen, String destino, int duracion) {
		this.tipoDeLlamada = tipoLlamada;
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
	}

	public String getTipoDeLlamada() {
		return tipoDeLlamada;
	}

	public String getRemitente() {
		return destino;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getOrigen() {
		return origen;
	}
}
```
### Bad Smell: *Feature Envy*
El método `agregarNumeroTelefono(String str)` en la clase `Empresa` ejecuta lógica que debería estar asignada a la clase `GestorNumerosDisponibles`, habiendo responsabilidades mal asignadas.

### Solución: Aplicar *Move Method*
```java
public class Cliente {
	...
}

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private List<Llamada> llamadas = new ArrayList<Llamada>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	static double descuentoJur = 0.15;
	static double descuentoFis = 0;

	public boolean agregarNumeroTelefono(String str) {
		return this.guia.agregarNumeroTelefono(str);
	}

	...
}

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private String tipoGenerador = "ultimo";

	...
    public boolean agregarNumeroTelefono(String str) {
		boolean encontre = this.getLineas().contains(str);
		if (!encontre) {
			this.getLineas().add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}
}

public class Llamada {
	...
}
```

### Bad Smell: *Long Method*
El método `agregarNumeroTelefono()` de la clase `GestorNumerosDisponibles` hace demasiadas cosas.

### Solución: Aplicar *Extract Method* para la verificación de números repetidos
```java
public class Cliente {
	...
}

public class Empresa {
	...
}

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private String tipoGenerador = "ultimo";

	...
    private boolean isNumeroRepetido(String numero) {
		return this.getLineas().contains(numero);
	}
	
	public boolean agregarNumeroTelefono(String str) {
		boolean encontre = this.isNumeroRepetido(str);
		if (!encontre) {
			this.getLineas().add(str);
			encontre= true;
			return encontre;
		}
		else {
			encontre= false;
			return encontre;
		}
	}
}

public class Llamada {
	...
}
```

### Bad Smell: Variable redudante
La variable `encontre` se utiliza de manera innecesaria.

### Solución: Eliminar variables redundantes
```java
public class Cliente {
	...
}

public class Empresa {
	...
}

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private String tipoGenerador = "ultimo";

	...
    private boolean isNumeroRepetido(String numero) {
		return this.getLineas().contains(numero);
	}
	
	public boolean agregarNumeroTelefono(String str) {
		if (!this.isNumeroRepetido(str)) {
			this.getLineas().add(str);
			return true;
		}
		else {
			return false;
		}
	}
}

public class Llamada {
	...
}
```
