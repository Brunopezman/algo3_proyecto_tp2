package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

public class TarotMano extends Tarot {
    private Mano manoQueModifica;

    public TarotMano(int puntaje, int multiplicador, Mano mano) {
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
        this.manoQueModifica = mano;
    }

    public void aplicarEfectos(List<Carta> cartas, Mano mano){
        mano.aumentarAtributos(puntaje, multiplicador);
    }
}
