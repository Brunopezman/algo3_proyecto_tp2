package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

public class ThreeOfAKind implements Mano{
    private int puntaje;
    private int multiplicador;

    public ThreeOfAKind() {
        this.puntaje = 30;
        this.multiplicador = 3;
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = new HashMap<>();

        // Contar las cartas por valor
        for (Carta carta : cartas) {
            String valor = carta.getValor();
            conteoValores.put(valor, conteoValores.getOrDefault(valor, 0) + 1);
        }

        // Verificar si hay al menos un valor con exactamente 3 cartas
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 3) {
                return true;  // Se puede formar un Three of a Kind
            }
        }

        return false;  // No se puede formar un Three of a Kind
    }
}


