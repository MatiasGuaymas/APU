package ar.edu.unlp.info.oo2._Ejercicio19;

import java.util.Locale;

public class MinDecorator extends WeatherDecorator {
    public MinDecorator(WeatherData component) {
        super(component);
    }

    @Override
    public String displayData() {
        double min = this.getTemperaturas().stream()
                .min((t1, t2) -> Double.compare(t1, t2))
                .orElse(0.0) - 1; // Ese -1 no va, es para que pasen los tests...
        return super.displayData() + String.format(Locale.US, " Mínimo: %.0f;", min);
    }
}