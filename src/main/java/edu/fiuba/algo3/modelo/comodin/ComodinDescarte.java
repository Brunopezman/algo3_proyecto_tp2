package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinDescarte extends Comodin {

    private Comodin comodin;

    public ComodinDescarte(Comodin comodin) {
        this.comodin = comodin;
    }

    @Override
    public void aplicarEfecto(Jugada jugada) {
        if(jugada.seDescarto()) {
            this.comodin.aplicarEfecto(jugada);
        }
    }

}
