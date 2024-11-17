package edu.fiuba.algo3.modelo;

public class ComodinMultiplicacion extends Comodin{

    private final int modificador;

    public ComodinMultiplicacion(int valor) {
        this.modificador = valor;
    }

    @Override
    public int modificarValor(int puntaje) {
        return (puntaje + modificador);
    }

}
