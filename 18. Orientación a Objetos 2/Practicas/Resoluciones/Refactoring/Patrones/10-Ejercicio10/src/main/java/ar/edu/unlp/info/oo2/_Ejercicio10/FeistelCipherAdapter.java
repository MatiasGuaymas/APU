package ar.edu.unlp.info.oo2._Ejercicio10;

public class FeistelCipherAdapter implements AlgoritmoDeCifrado {
	private FeistelCipher encriptador;

	@Override
	public void encriptar(String mensaje) {
		this.encriptador = new FeistelCipher(mensaje);
		this.encriptador.encode(mensaje);
	}

	@Override
	public void desencriptar(String mensaje) {
		this.encriptador.encode(mensaje);
	}
	
	
}
