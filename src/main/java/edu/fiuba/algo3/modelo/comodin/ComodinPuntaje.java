package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinPuntaje extends Comodin {

    private final int modificador;
    private char operacion;

    public ComodinPuntaje(int valor, char simbolo) {
        this.modificador = valor;
        this.operacion = simbolo;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        int nuevoValor;
        if (this.operacion == '+') {
            nuevoValor = mano.getPuntaje() + modificador;
        }else {
            nuevoValor = mano.getPuntaje() * modificador;
        }
        mano.modificarPuntaje(nuevoValor);
    }
}


