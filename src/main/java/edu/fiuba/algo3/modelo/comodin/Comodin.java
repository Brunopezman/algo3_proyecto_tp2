package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;

public abstract class Comodin {

    protected int multiplicador;
    protected int  puntos;
    protected estrategiaModificador estrategia;

    public abstract void aplicarEfecto(Jugada jugada);
}
