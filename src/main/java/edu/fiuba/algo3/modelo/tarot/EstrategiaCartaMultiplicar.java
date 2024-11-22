package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.carta.Carta;

public class EstrategiaCartaMultiplicar implements EstrategiaCarta {

    @Override
    public void modificarCarta(Carta carta, int puntaje, int multiplicador) {
        carta.multiplicarValor(multiplicador);
    }
}
