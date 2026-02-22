package ar.edu.unlp.info.oo2._Ejercicio19;

import java.util.List;
import java.util.stream.Collectors;

public class CelciusAdapter implements WeatherData {
    private HomeWeatherStation weatherStation;

    public CelciusAdapter(HomeWeatherStation weatherStation) {
        this.weatherStation = weatherStation;
    }

    @Override
    public double getTemperatura() {
        return this.formatToCelcius(weatherStation.getTemperatura());
    }

    private double formatToCelcius(double tempInFahrenheit) {
        return (tempInFahrenheit - 32) / 1.8;
    }

    @Override
    public double getPresion() {
        return this.weatherStation.getPresion();
    }

    @Override
    public double getRadiacionSolar() {
        return this.weatherStation.getRadiacionSolar();
    }

    @Override
    public List<Double> getTemperaturas() {
        return this.weatherStation.getTemperaturas().stream()
                .map(temp -> this.formatToCelcius(temp))
                .collect(Collectors.toList());
    }

    @Override
    public String displayData() {
        return String.format("Temperatura C: %.0f; Presión atmosf: %.0f; Radiación solar: %.0f;",
                this.getTemperatura(), this.getPresion(), this.getRadiacionSolar());
    }
}