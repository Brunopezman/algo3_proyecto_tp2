package edu.fiuba.algo3.modelo;

import java.util.List;

public class CartaAlta extends Mano {
    // Constantes
    public static int PUNTAJE_INICIAL = 40;
    public static int MULTIPLICADOR_INICIAL = 4;

    // Atributos
    private int puntaje;
    private int multiplicador;

    public CartaAlta() {
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
    }
    @Override
    public boolean esJugable(List<Carta> cartas) {
        return true;
    }

    @Override
    public int calcularPuntaje(int valor) {
        return 0;
    }

    @Override
    public int getPuntaje() {
        return 0;
    }

    @Override
    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public int getMultiplicador() {
        return multiplicador;
    }

    @Override
    public void setPuntaje(int nuevoPuntaje) {

    }
}
