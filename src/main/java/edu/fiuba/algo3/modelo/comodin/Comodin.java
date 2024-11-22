package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.mano.Mano;

public abstract class Comodin {

    protected int multiplicador;
    protected int  puntos;
    protected EstrategiaModificador estrategia;

    public void setEstrategia(EstrategiaModificador estrategia) { this.estrategia = estrategia; }
    public abstract void aplicarEfecto(Mano mano);
}
