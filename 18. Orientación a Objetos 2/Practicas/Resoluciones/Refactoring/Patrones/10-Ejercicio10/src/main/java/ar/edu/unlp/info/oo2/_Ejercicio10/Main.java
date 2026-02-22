package ar.edu.unlp.info.oo2._Ejercicio10;

/* Al momento de enviar un mensaje, ¿con cuantos algoritmos de cifrado puede trabajar el mensajero al mismo tiempo?
 * Se puede trabajar con sólo un algoritmo de cifrado a la vez.
 * */

public class Main {

	public static void main(String[] args) {
		FeistelCipherAdapter feistelCipher = new FeistelCipherAdapter();
		Mensajero mensajero = new Mensajero(feistelCipher);
		mensajero.enviar("Hola!");
		
		RC4Adapter rc4 = new RC4Adapter("Contraseña");
		mensajero.setStrategy(rc4);
		mensajero.enviar("Hola!");
	}

}
