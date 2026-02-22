package ar.edu.unlp.info.oo2._Ejercicio10;

public class RC4Adapter implements AlgoritmoDeCifrado{
	private RC4 encriptador;
	private String key;

	public RC4Adapter (String key) {
		this.key = key;
	}
	
	@Override
	public void encriptar(String mensaje) {
		this.encriptador = new RC4();
		this.encriptador.encriptar(mensaje, this.key);
	}

	@Override
	public void desencriptar(String mensaje) {
		this.encriptador.desencriptar(mensaje, this.key);
	}
}
