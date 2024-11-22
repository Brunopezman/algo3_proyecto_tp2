package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;

public class ComodinRegular extends Comodin {

    public ComodinRegular(int valorMultiplicador,int valorPuntos, EstrategiaModificador estrategia) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarEfecto(Jugada jugada) {
        estrategia.realizarModificacion(jugada, multiplicador, puntos);
    }
}
