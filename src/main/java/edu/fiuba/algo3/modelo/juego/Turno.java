package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.mano.*;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.List;
import java.util.ArrayList;

public class Turno {
    private List<Mano> manosJugables;
    private List<Comodin> comodines;
    private Tarot tarotUsar;
    private int puntaje;
    private int cantidadDescartes;

    public Turno(List<Comodin> comodines) {
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
        this.manosJugables = new ArrayList<>();
        this.comodines = comodines;
        this.tarotUsar = null;
        this.puntaje = 0;
        this.cantidadDescartes = 0;
    }
    /*
    public Turno() {
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
    }*/


    public int calcularJugada(List<Carta> cartas, Mano mano){
        int puntaje = 0;
        if (tarotUsar != null){
            tarotUsar.aplicarEfectos(cartas, mano);
        }
        for (Carta carta : cartas) {;
            puntaje += carta.puntaje();
        }
        mano.sumarPuntos(puntaje);
        for (Comodin comodin: comodines) {
            comodin.aplicarEfecto(mano);
        }
        puntaje = mano.puntajeFinal();
        return puntaje;
    }

    public Mano existeManoJugable(List<Carta> cartas){
        Mano mano = null;
        for (Mano manoPosible : this.manosJugables){
            mano = manoPosible.esJugable(cartas);
            if(mano != null){
                break;
            }
        }
        return mano;
    }

    public int puntajeDelTurno(){
        return puntaje;
    }

    public void sumarManoJugada(int valor){
        this.setPuntaje(valor);
    }

    public void sumarDescartes(int cantidad){
        this.cantidadDescartes += cantidad;
    }

    public boolean puedeDescartar(){
        if(this.cantidadDescartes == 3){
            return false;
        }
        return true;
    }

    private void setPuntaje(int nuevoPuntaje){
        this.puntaje = nuevoPuntaje;
    }

    public void registrarDescarte() {
        this.cantidadDescartes++;
    }

    public void agregarTarot(Tarot tarotElegido) {
        this.tarotUsar = tarotElegido;
    }
}

