package edu.fiuba.algo3.modelo;

import java.util.List;

public interface Mano {
    boolean esJugable(List<Carta> cartas);

    int calcularPuntaje(int valor);
}

