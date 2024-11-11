package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FourOfAKind implements Mano{
    private int puntaje;
    private int multiplicador;

    public FourOfAKind(){
        this.puntaje = 60;
        this.multiplicador = 7;
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

        // Verificar si hay un valor con al menos 4 cartas
        for (int cantidad : conteoValores.values()) {
            if (cantidad >= 4) {
                return true;  // Se puede formar un Four of a Kind
            }
        }

        return false;
    }
}
