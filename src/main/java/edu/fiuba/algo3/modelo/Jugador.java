package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private List<Carta> cartasActuales;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartasActuales = new ArrayList<>();
    }

    public List<Carta> recibirCartas(Mazo mazo) {
        List<Carta> cartasRecibidas = mazo.darCartas(8);
        this.setCartasActuales(cartasRecibidas);
        return cartasRecibidas;
    }

    private void setCartasActuales(List<Carta> cartas) {
        this.cartasActuales = cartas;
    }

    public int jugarMano(List<Carta> cartas, Mano mano) {

        int valor = 0;
        for (Carta carta : cartas) {
            valor += carta.getPuntaje();
        }
        return mano.calcularPuntaje(valor);
    }
}
