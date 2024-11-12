package edu.fiuba.algo3.modelo;

public class ComodinSuma extends Comodin {

    private int modificador;

    public ComodinSuma(int valor) {
        this.modificador = valor;
    }
    @Override
    public void modificarValor(Mano mano) {
        int nuevoPuntaje = mano.getPuntaje() + modificador;
        mano.setPuntaje(nuevoPuntaje);
    }
}
