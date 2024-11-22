package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;

public class ComodinDescarte extends Comodin {

    public ComodinDescarte(int valorMultiplicador,int valorPuntos, EstrategiaModificador estrategia) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarEfecto(Jugada jugada) {
        if(jugada.seDescarto()) {
            estrategia.realizarModificacion(jugada,multiplicador,puntos);
        }
    }

}
