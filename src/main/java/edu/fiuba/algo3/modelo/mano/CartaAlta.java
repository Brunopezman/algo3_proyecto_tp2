package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;

public class CartaAlta extends Mano {
    // Constantes
    public static int PUNTAJE_INICIAL = 40;
    public static int MULTIPLICADOR_INICIAL = 4;

    public CartaAlta() {
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
    }
    @Override
    public boolean esJugable(List<Carta> cartas) {
        return true;
    }
}
