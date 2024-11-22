package edu.fiuba.algo3.modelo.tarot;


import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

public class TarotCarta extends Tarot {
    private Carta cartaQueModifica;
    private EstrategiaCarta estrategia;

    public TarotCarta(int puntaje, int multiplicador, Carta carta, EstrategiaCarta estrategia) {
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
        this.cartaQueModifica = cartaQueModifica;
        this.estrategia = estrategia;
    }

    public void aplicarEfectos(List<Carta> cartas, Mano mano){
        for (Carta carta : cartas) {
            if (carta.esIgual(cartaQueModifica)) {estrategia.modificarCarta(carta, puntaje, multiplicador);}
        }
    }

}
