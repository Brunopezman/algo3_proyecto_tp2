package edu.fiuba.algo3.modelo.comodin;

import edu.fiuba.algo3.modelo.juego.Jugada;
import edu.fiuba.algo3.modelo.mano.Mano;

public class ComodinManoEspecifica extends Comodin{
    private Comodin comodin;
    private Mano manoModificable;

    public ComodinManoEspecifica(Mano manoModificable, Comodin comodin) {
        this.comodin = comodin;
        this.manoModificable = manoModificable;
    }

    @Override
    public void aplicarEfecto(Jugada jugada) {
        if (jugada.jugoEstaMano(manoModificable)) {
            comodin.aplicarEfecto(jugada);
        }
    }
}
