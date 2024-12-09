package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import java.util.ArrayList;
import java.util.List;

public class Jugador {

    private String nombre;
    private List<Carta> cartasActuales;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartasActuales = new ArrayList<>();
    }

    //Getters y Setters

    public String getNombre() { return nombre; }

    public List<Carta> setCartas(List<Carta> nuevasCartas) {
        this.cartasActuales = nuevasCartas;
        return this.cartasActuales;
    }

    public List<Carta> getCartasActuales() {return cartasActuales;}

    public List<Carta> recibirCartas(Mazo mazo, int cantidad) {
        List<Carta> cartasRecibidas = mazo.darCartas(cantidad);
        cartasActuales.addAll(cartasRecibidas);
        return cartasRecibidas;
    }

    public void eliminarCartasUsadas(List<Carta> cartas) {
        for (Carta cartaEliminar : cartas) {
            for (Carta cartaPropia : cartasActuales) {
                if (cartaPropia.esIgual(cartaEliminar.getNombre())){
                    cartasActuales.remove(cartaPropia);
                    break;
                }
            }
        }
    }
}
