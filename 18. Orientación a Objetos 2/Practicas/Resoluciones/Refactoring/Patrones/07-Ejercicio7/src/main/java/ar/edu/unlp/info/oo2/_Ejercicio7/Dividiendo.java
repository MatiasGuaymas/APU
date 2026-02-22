package ar.edu.unlp.info.oo2._Ejercicio7;

public class Dividiendo extends Operando {

    @Override
    public void setValor(double unValor, Calculadora c) {
        if (unValor == 0) {
            c.setEstado(new Error());
        } else {
            c.setValorAcumulado(c.getValorAcumulado() / unValor);
            c.setEstado(new Inicial());
        }
    }

}