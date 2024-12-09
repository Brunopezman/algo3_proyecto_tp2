package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Mazo {

    private List<Carta> cartas;
    private int cantidadCartass;
    /*
    public Mazo(){
        this.cartas = new ArrayList<Carta>();
        String[] valores = {"Rey", "Reina", "Jota", "10", "9", "8", "7", "6", "5", "4", "3", "2", "As"};
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
    */
    public Mazo(List<Carta> cartasParaElMazo) {
        this.cartas = cartasParaElMazo;
        this.cantidadCartass = cartasParaElMazo.size();
        mezclarCartas(this.cartas);
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

    public void agregarCartasCompradas(List<Carta> cartasElegidas) {
        cartas.addAll(cartasElegidas);
        cantidadCartass += cartasElegidas.size();
    }

    public int cantidadCartasTotales() { return cantidadCartass; }

    private void mezclarCartas(List<Carta> cartas) {
        // Inicializar un generador de números aleatorios con una semilla variable
        Random random = new Random(System.nanoTime());

        // Algoritmo de Fisher-Yates
        for (int i = cartas.size() - 1; i > 0; i--) {
            int j = random.nextInt(i + 1); // Índice aleatorio entre 0 e i
            // Intercambiar las cartas en las posiciones i y j
            Carta temp = cartas.get(i);
            cartas.set(i, cartas.get(j));
            cartas.set(j, temp);
        }
    }

}
