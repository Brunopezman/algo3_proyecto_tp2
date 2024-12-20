package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.*;
import java.util.stream.Collectors;

public class Operador {

    public Operador() {}

    public List<Carta> ordenarCartasPorValor(List<Carta> cartas) {
        List<String> ordenValores = Arrays.asList("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K");
        List<Carta> cartasOrdenadas = new ArrayList<>();

        for (String valor : ordenValores) {
            for (Carta carta : cartas) {
                if (carta.numero().equals(valor)) {
                    cartasOrdenadas.add(carta);
                }
            }
        }
        return cartasOrdenadas;
    }

    public Map<String, List<Carta>> agruparPorPalo(List<Carta> cartas) {
        Map<String, List<Carta>> cartasPorPalo = new HashMap<>();

        for (Carta carta : cartas) {
            cartasPorPalo.computeIfAbsent(carta.getPalo(), k -> new ArrayList<>()).add(carta);
        }

        return cartasPorPalo;
    }


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
            String numero = carta.numero();
            conteoValores.put(numero, conteoValores.getOrDefault(numero, 0) + 1);
        }
        return conteoValores;
    }

    public Map<String, List<Carta>> separarPorPalo(List<Carta> cartas) {
        return cartas.stream().collect(Collectors.groupingBy(Carta::getPalo));
    }

}
