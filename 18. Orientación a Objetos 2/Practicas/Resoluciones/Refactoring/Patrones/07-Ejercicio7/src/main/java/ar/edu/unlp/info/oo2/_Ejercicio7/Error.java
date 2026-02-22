package ar.edu.unlp.info.oo2._Ejercicio7;

public class Error implements EstadoCalculadora {
    @Override
    public void mas(Calculadora c) {}

    @Override
    public void menos(Calculadora c) {}

    @Override
    public void por(Calculadora c) {}

    @Override
    public void dividido(Calculadora c) {}

    @Override
    public void setValor(double unValor, Calculadora c) {}

    @Override
    public String getResultado(Calculadora c) {
        return "Error";
    }
}