package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Mano {
    abstract boolean esJugable(List<Carta> cartas);

    abstract void setPuntaje(int nuevoPuntaje);

    abstract void setMultiplicador (int nuevoMultiplicador);

    abstract int calcularPuntaje(int valor);

    abstract int getPuntaje();

    abstract public int getMultiplicador();

    public Map<String, Integer> contarPorPalo(List<Carta> cartas) {
        Map<String, Integer> conteoPalos = new HashMap<>();
        for (Carta carta : cartas) {
            String palo = carta.getPalo();
            conteoPalos.put(palo, conteoPalos.getOrDefault(palo, 0) + 1);
        }
        return conteoPalos;
    }

    public Map<String, Integer> contarPorValor(List<Carta> cartas) {
        Map<String, Integer> conteoValores = new HashMap<>();
        for (Carta carta : cartas) {
            String palo = carta.getValor();
            conteoValores.put(palo, conteoValores.getOrDefault(palo, 0) + 1);
        }
        return conteoValores;
    }
}

