package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContablePorPalo {

    public Map<String, Integer> contarPorPalo(List<Carta> cartas) {

        Map<String, Integer> conteoPalos = new HashMap<>();
        // Contar las cartas por palo
        for (Carta carta : cartas) {
            String palo = carta.getPalo();
            conteoPalos.put(palo, conteoPalos.getOrDefault(palo, 0) + 1);
        }
        return conteoPalos;
    }
}
