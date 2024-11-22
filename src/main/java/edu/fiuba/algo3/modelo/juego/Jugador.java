package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.ArrayList;
import java.util.List;

public class Jugador {
    private static final int CARTASARECIBIR = 8;

    private String nombre;
    private List<Carta> cartasActuales;
    private List<Comodin> comodines;
    private int descartes;

    public Jugador(String nombre) {
        this.nombre = nombre;
        this.cartasActuales = new ArrayList<>();
        //this.comodines = new ArrayList<>();
    }

    public List<Carta> recibirCartas(Mazo mazo) {
        List<Carta> cartasRecibidas = mazo.darCartas(CARTASARECIBIR);
        this.setCartasActuales(cartasRecibidas);
        return cartasRecibidas;
    }

    private boolean verificarExistenciaDeCartas(List<Carta> cartas){
        boolean encontrado = false;
        for(Carta carta : cartas){
            for(Carta cartaActual : cartasActuales){
                if(carta.esIgual(cartaActual)){
                    encontrado = true;
                    break;
                }
            }
            if(!encontrado){
                break;
            }
        }
        return encontrado;
    }

    private void setCartasActuales(List<Carta> cartas) {
        this.cartasActuales = cartas;
    }

    public boolean pudeJugarAlgunaMano(){
        return this.cartasActuales.size() >= 5;
    }

    public Mano jugarMano(List<Carta> cartas, Mano mano) {
        int puntaje = 0;


        for (Carta carta : cartas) {;
            puntaje += carta.puntaje();
        }

        mano.sumarPuntos(puntaje);
        mano.sumarDescartes(descartes);
        return mano;
    }

    public void descartar(Mazo mazo, List<Carta> cartasADescartar){
        if (this.descartes == 3 ) {
            throw new IllegalArgumentException("No puede realizar más descartes en este turno.");
        }

        if (!this.verificarExistenciaDeCartas(cartasADescartar)) {
            throw new IllegalArgumentException("Algunas cartas no están en la mano.");
        }

        this.descartes++;

        // Descartar cada carta
        for (Carta carta : cartasADescartar) {
            cartasActuales.remove(carta);
        }

        //dar nuevamente la cantidad de cartas que descartó
        int cantidadARecibir = cartasADescartar.size();
        List<Carta> nuevasCartas= mazo.darCartas(cantidadARecibir);
        for (int i = 0; i < cantidadARecibir; i++) {
            this.cartasActuales.add(nuevasCartas.get(i));
        }
    }
}
