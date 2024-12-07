package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;

public class CartaAlta extends Mano {
    // Constantes
    public static int PUNTAJE_INICIAL = 5;
    public static int MULTIPLICADOR_INICIAL = 1;

    public CartaAlta() {
        this.nombre = "carta alta";
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
    }
    @Override
    public Mano esJugable(List<Carta> cartas) {
        return new CartaAlta();
    }
}
