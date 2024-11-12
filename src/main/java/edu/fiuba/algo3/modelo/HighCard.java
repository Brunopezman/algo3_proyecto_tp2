package edu.fiuba.algo3.modelo;

import java.util.List;

public class HighCard extends Mano {
    private int puntaje;
    private int multiplicador;

    public HighCard() {
        this.puntaje = 40;
        this.multiplicador = 4;
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
