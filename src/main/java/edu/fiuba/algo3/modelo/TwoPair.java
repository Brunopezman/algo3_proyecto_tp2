package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class TwoPair implements Mano{
    private int puntaje;
    private int multiplicador;

    public TwoPair() {
        this.puntaje = 20;
        this.multiplicador = 2;
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

        // Contar cuántos pares tenemos
        int pares = 0;

        // Recorrer el mapa para contar los pares
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 2) {
                pares++;
            }
        }

        // Si encontramos exactamente 2 pares, devolvemos true
        return pares == 2;
    }
}
