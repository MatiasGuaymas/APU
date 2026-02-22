package ar.edu.unlp.info.oo2._Ejercicio8;

public class FourGAdapter implements Connection{
	
	@Override
	public String sendData(String data, int crc) {
		FourGConnection connection = new FourGConnection();
		return connection.transmit(data, crc);
	}

	@Override
	public String pict() {
		FourGConnection connection = new FourGConnection();
		return connection.symb();
	}
}
