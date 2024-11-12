package edu.fiuba.algo3.modelo;

public class Comodin2 extends Comodin{

    private int modificador;

    public Comodin2() {
        this.modificador = 2;
    }

    @Override
    public void modificarValor(Mano mano) {
        int nuevoPuntaje = mano.getPuntaje() * modificador;
        mano.setPuntaje(nuevoPuntaje);
    }

}
