package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinRegular extends Comodin {

    public ComodinRegular(int valorMultiplicador,int valorPuntos, EstrategiaComodin estrategia) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        estrategia.realizarModificacion(puntos, multiplicador, mano);
    }
}
