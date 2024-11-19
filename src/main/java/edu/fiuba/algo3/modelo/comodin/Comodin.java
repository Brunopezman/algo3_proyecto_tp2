package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.mano.*;

public abstract class Comodin {

    private String tipo;

    //public boolean(Comodin otroComodin){ return }

    public abstract void aplicarEfecto(Jugada jugada);

    protected String getTipo() { return this.tipo; };

    public boolean esIgualA(Comodin otroComodin) { return tipo.equals(otroComodin.tipo); }
}
