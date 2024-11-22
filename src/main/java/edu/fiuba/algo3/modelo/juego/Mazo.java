package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mazo {

    private List<Carta> cartas;

    public Mazo(){
        this.cartas = new ArrayList<Carta>();
        String[] valores = {"K", "Q", "J", "10", "9", "8", "7", "6", "5", "4", "3", "2", "A"};
        String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};
        for (String palo : palos) {
            String consecutivo = "A";
            for (String valor : valores) {
                Carta nuevaCarta = new Carta(valor, consecutivo, palo);
                this.cartas.add(nuevaCarta);
                consecutivo = valor;
            }
        }
        //this.barajar(cartas);
    }

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

    public List<Carta> getCartas() { return this.cartas; }

}
