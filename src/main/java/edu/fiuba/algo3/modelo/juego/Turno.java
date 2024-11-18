package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.*;

import java.util.List;
import java.util.ArrayList;

public class Turno {
    private List<Mano> manosJugables;
    private int puntaje;
    private int cantidadDescartes;

    public Turno(){
        this.manosJugables = new ArrayList<>();
        this.puntaje = 0;
        this.manosJugables.add(new EscaleraReal());
        this.manosJugables.add(new EscaleraColor());
        this.manosJugables.add(new Poker());
        this.manosJugables.add(new FullHouse());
        this.manosJugables.add(new Color());
        this.manosJugables.add(new Escalera());
        this.manosJugables.add(new Trio());
        this.manosJugables.add(new DoblePar());
        this.manosJugables.add(new Par());
        this.manosJugables.add(new CartaAlta());
        this.cantidadDescartes = 0;
    }

    public boolean existeManoJugable(List<Carta> cartas){
        boolean existe = false;
        for (Mano mano : this.manosJugables){
            if (mano.esJugable(cartas)){
                existe = true;
            }
        }
        return existe;
    }

    public void sumarManoJugada(int valor){
        this.setPuntaje(valor);
    }

    public void sumarDescartes(int cantidad){
        this.cantidadDescartes += cantidad;
    }

    public boolean puedeDescartar(int cantidad){
        if(this.cantidadDescartes + cantidad > 3){
            return false;
        }
        return true;
    }

    private void setPuntaje(int nuevoPuntaje){
        this.puntaje = nuevoPuntaje;
    }

}

