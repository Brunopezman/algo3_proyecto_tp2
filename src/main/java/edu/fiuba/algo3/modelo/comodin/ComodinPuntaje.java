package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinPuntaje extends Comodin {

    public ComodinPuntaje(int valorMultiplicador,int valorPuntos, estrategiaModificador estrategia) {
        this.multiplicador = valorMultiplicador;
        this.puntos = valorPuntos;
        this.estrategia = estrategia;
    }

    @Override
    public void aplicarEfecto(Jugada jugada) { jugada.modificarPuntajeMano(operacion, modificador); }
}


