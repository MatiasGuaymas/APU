package ar.edu.unlp.info.oo2._Ejercicio9;

import java.time.LocalDate;

public class PoliticaEstricta implements PoliticaDeCancelacion{

	@Override
	public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancelacion, double montoTotal) {
		return 0;
	}

}
