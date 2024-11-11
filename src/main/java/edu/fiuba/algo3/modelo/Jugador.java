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



}
