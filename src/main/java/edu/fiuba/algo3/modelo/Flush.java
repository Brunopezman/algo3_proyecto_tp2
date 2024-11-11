package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class Flush implements Mano{
    private int puntaje;
    private int multiplicador;

    public Flush(){
        this.puntaje = 35;
        this.multiplicador = 4;
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada palo
        Map<String, Integer> conteoPalos = new HashMap<>();
        // Contar las cartas por palo
        for (Carta carta : cartas) {
            String palo = carta.getPalo();
            conteoPalos.put(palo, conteoPalos.getOrDefault(palo, 0) + 1);
        }
        // Verificar si alguno de los palos tiene al menos 5 cartas
        for (int cantidad : conteoPalos.values()) {
            if (cantidad >= 5) {
                return true;
            }
        }
        return false;
    }
}
