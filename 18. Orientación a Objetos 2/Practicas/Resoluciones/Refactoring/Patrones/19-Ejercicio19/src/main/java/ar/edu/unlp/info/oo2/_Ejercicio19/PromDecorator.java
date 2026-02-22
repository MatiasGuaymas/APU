package ar.edu.unlp.info.oo2._Ejercicio19;

import java.util.Locale;

public class PromDecorator extends WeatherDecorator {
    public PromDecorator(WeatherData component) {
        super(component);
    }

    @Override
    public String displayData() {
        double prom = this.getTemperaturas().stream()
                .mapToDouble(Double::doubleValue)
                .average()
                .orElse(0.0);
        return super.displayData() + String.format(Locale.US, " Promedio: %.0f;", prom);
    }
}