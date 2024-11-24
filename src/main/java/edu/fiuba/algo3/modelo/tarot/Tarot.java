package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

public abstract class Tarot {
    protected int puntaje;
    protected int multiplicador;

    abstract void aplicarEfectos(List<Carta> cartas, Mano mano);

}

