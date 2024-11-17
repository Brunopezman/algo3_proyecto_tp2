package edu.fiuba.algo3.modelo;

public class ComodinSuma extends Comodin {

    private final int modificador;

    public ComodinSuma(int valor) {
        this.modificador = valor;
    }

    @Override
    public int modificarValor(int puntaje) {
        return (puntaje*modificador);
        //this.modificador.aplicarModificador(puntaje);
        //int nuevoPuntaje = mano.getPuntaje() + modificador;
        //mano.setPuntaje(nuevoPuntaje);
    }
}
