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
    public int recibirCartas(Mazo mazo) {
        this.cartasActuales.add(mazo.darCartas(8));
        return this.cartasActuales;
    }

    public obtenerCartas()

}
