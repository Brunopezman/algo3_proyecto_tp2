package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinMultiplicador extends Comodin{

    private final int modificador;
    private char operacion;

    public ComodinMultiplicador(int valor, char simbolo) {
        this.modificador = valor;
        this.operacion = simbolo;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        int nuevoValor;
        if (this.operacion == '+') {
            nuevoValor = mano.getMultiplicador() + modificador;
        }else {
            nuevoValor = mano.getMultiplicador() * modificador;
        }
        mano.modificarMultiplicador(nuevoValor);

    }
}
