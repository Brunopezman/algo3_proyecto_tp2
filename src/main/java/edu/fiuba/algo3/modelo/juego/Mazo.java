package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.carta.CartaNoNumerica;
import edu.fiuba.algo3.modelo.carta.CartaNumerica;

import java.util.ArrayList;
import java.util.List;

public class Mazo {

    private List<Carta> cartas;

    public Mazo(){
        this.cartas = new ArrayList<Carta>();
        String[] valores = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"};
        String[] palos = {"Corazones", "Diamantes", "Treboles", "Picas"};
        for (String palo : palos) {
            int index = 0;
            for (int i = 0; i < valores.length; i++) {
                String valor = valores[i];
                // Si el valor es entre 2 y 8 (índice de 0 a 7), es una carta numérica
                if (i <= 8) {
                    // Carta numérica
                    this.cartas.add(new CartaNumerica(valor, palo));
                } else {
                    // Carta no numérica (9, 10, J, Q, K, A)
                    this.cartas.add(new CartaNoNumerica(valor, palo));
                }
            }
        }
        //this.barajar(cartas);
    }

    //private void barajar(List<Carta> cartas) {

    //Collections.shuffle(cartas);
    //}

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

    public List<Carta> getCartas() { return this.cartas; }

}
