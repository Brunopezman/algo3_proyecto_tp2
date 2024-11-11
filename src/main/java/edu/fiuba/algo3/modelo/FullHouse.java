package edu.fiuba.algo3.modelo;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FullHouse implements Mano {
    private int puntaje;
    private int multiplicador;

    public FullHouse() {
        this.puntaje = 40;
        this.multiplicador = 4;
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

        // Variables para contar la presencia de una "triple" y un "par"
        boolean tieneTres = false;
        boolean tieneDos = false;

        // Verificar las cantidades en el mapa
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 3) {
                tieneTres = true;
            } else if (cantidad == 2) {
                tieneDos = true;
            } else if (cantidad >= 5) {
                // Si tienes más de tres del mismo valor (por ejemplo, 4), esto podría ser parte de una triple
                // y un par al mismo tiempo, por lo que lo dividimos
                tieneTres = true;
                tieneDos = true;
            }
        }
        return (tieneTres && tieneDos);
    }
}