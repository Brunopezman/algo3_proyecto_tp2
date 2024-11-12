package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Mazo {

    private List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<Carta>();
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};
        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }
        this.barajar(cartas);
    }

    private void barajar(List<Carta> cartas) {

        Collections.shuffle(cartas);
    }

    // Método para dar una cantidad específica de cartas al jugador
    public List<Carta> darCartas(int cantidad) {
        List<Carta> cartasRecibidas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            if (!cartas.isEmpty()) {
                cartasRecibidas.add(cartas.remove(0)); // Elimina la carta del mazo y la añade a las cartas recibidas
            }
        }
        return cartasRecibidas;
    }

    public int cartasRestantes() {
        return cartas.size();
    }
}
