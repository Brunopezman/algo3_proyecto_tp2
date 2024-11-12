package edu.fiuba.algo3.modelo;

public class Comodin1 extends Comodin {

    private int modificador;

    public Comodin1() {
        this.modificador = 10;
    }
    @Override
    public void modificarValor(Mano mano) {
        int nuevoPuntaje = mano.getPuntaje() + modificador;
        mano.setPuntaje(nuevoPuntaje);
    }
}
