package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.ArrayList;
import java.util.List;

public class Mazo {

    private List<Carta> cartas;
    private int cantidadCartass;

    public Mazo(List<Carta> cartasParaElMazo) {
        this.cartas = cartasParaElMazo;
        this.cantidadCartass = cartasParaElMazo.size();
    }

    public List<Carta> darCartas(int cantidad) {
        List<Carta> cartasRecibidas = new ArrayList<>();
        for (int i = 0; i < cantidad; i++) {
            if (!cartas.isEmpty()) {
                int indexAleatorio = (int) (Math.random() * cartas.size());
                cartasRecibidas.add(cartas.remove(indexAleatorio)); // Elimina la carta del mazo y la añade a las cartas recibidas
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

}
