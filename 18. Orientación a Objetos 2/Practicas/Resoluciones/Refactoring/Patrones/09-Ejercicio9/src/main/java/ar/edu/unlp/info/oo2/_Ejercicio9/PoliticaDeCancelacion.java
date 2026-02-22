package ar.edu.unlp.info.oo2._Ejercicio9;

import java.time.LocalDate;

public interface PoliticaDeCancelacion {
	public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancelacion, double montoTotal);
}
