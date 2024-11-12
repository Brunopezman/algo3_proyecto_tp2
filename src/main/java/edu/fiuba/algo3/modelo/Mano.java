package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Mano {
    boolean esJugable(List<Carta> cartas);

    int getMultiplicador();

    void setMultiplicador (int nuevoMultiplicador);

    int calcularPuntaje(int valor);
}

