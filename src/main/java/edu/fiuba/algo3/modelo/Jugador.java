package edu.fiuba.algo3.modelo;

import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private List<Carta> cartasActuales;
    private List<Comodin> comodines;
    private static final int CARTASARECIBIR = 8;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartasActuales = new ArrayList<>();
        this.comodines = new ArrayList<>();
    }

    public List<Carta> recibirCartas(Mazo mazo) {
        List<Carta> cartasRecibidas = mazo.darCartas(CARTASARECIBIR);
        this.setCartasActuales(cartasRecibidas);
        return cartasRecibidas;
    }

    private void setCartasActuales(List<Carta> cartas) {
        this.cartasActuales = cartas;
    }

    public boolean pudeJugarAlgunaMano(){
        return this.cartasActuales.size() >= 5;
    }

    public int jugarMano(List<Carta> cartas, Mano mano) {
        int puntaje = 0;
        for (Carta carta : cartas) {
            puntaje += carta.getPuntaje();
        }
        for (Comodin comodin: comodines) {
            mano.aplicarComodin(comodin);
        }
        return mano.calcularPuntaje(puntaje);
    }

    public void agregarComodin(Comodin comodin) {
        comodines.add(comodin);
    }
}
