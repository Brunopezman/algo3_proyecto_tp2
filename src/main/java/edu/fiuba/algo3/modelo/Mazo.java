package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Mazo {

    private List<Carta> cartas;

    public Mazo() {
        this.cartas = new ArrayList<>();
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] palos = {"Corazones", "Diamantes", "Tréboles", "Picas"};

        for (String palo : palos) {
            for (String valor : valores) {
                cartas.add(new Carta(valor, palo));
            }
        }

    }

    public int cartasRestantes() {
        return cartas.size();
    }
}
