package ar.edu.unlp.info.oo2._Ejercicio19;

import java.util.Locale;

public class MaxDecorator extends WeatherDecorator {
    public MaxDecorator(WeatherData component) {
        super(component);
    }

    @Override
    public String displayData() {
        double max = this.getTemperaturas().stream()
                .max((t1, t2) -> Double.compare(t1, t2))
                .orElse(0.0);
        return super.displayData() + String.format(Locale.US, " Máximo: %.0f;", max);
    }
}