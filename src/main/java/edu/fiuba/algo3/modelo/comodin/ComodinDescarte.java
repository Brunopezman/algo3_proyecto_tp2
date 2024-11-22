package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinDescarte extends Comodin {

    public ComodinDescarte(int valorMultiplicador,int valorPuntos, EstrategiaModificador estrategia) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarEfecto(Mano mano) {
        for (int i = 0; i < mano.cantidadDescartes(); i++) {
            estrategia.realizarModificacion(mano, multiplicador, puntos);
        }
    }

}
