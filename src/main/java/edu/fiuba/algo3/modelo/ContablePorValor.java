package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ContablePorValor {

    public Map<String, Integer> contarPorValor(List<Carta> cartas) {

        Map<String, Integer> conteoValores = new HashMap<>();
        // Contar las cartas por palo
        for (Carta carta : cartas) {
            String palo = carta.getValor();
            conteoValores.put(palo, conteoValores.getOrDefault(palo, 0) + 1);
        }
        return conteoValores;
    }
}
