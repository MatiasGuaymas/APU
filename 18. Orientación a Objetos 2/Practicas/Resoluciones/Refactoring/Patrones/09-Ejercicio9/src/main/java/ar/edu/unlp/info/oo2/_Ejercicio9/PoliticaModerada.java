package ar.edu.unlp.info.oo2._Ejercicio9;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class PoliticaModerada implements PoliticaDeCancelacion{
	@Override
	public double montoAReembolsar(LocalDate fechaInicio, LocalDate fechaCancelacion, double montoTotal) {
		long diasDiferencia = ChronoUnit.DAYS.between(fechaCancelacion, fechaInicio);
        if (diasDiferencia >= 7) {
            return montoTotal;
        } else if (diasDiferencia >= 2) {
            return montoTotal * 0.5;
        } else {
            return 0;
        }
	}
}
