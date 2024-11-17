package edu.fiuba.algo3.modelo;

public class CartaNoNumerica extends Carta {

    public static int PUNTAJE_INICIAL = 10;

    public CartaNoNumerica(String valor, String palo) {
        this.setValor(valor);
        this.setPuntaje(PUNTAJE_INICIAL);
        this.setPalo(palo);
    }
}
