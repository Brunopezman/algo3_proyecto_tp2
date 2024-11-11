package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class Turno {
    private List<Mano> manosJugables;
    private int puntaje;

    public Turno(){
        this.manosJugables = new ArrayList<>();
        this.puntaje = 0;
        this.manosJugables.add(new RoyalFlush());
        this.manosJugables.add(new StraightFlush());
        this.manosJugables.add(new FourOfAKind());
        this.manosJugables.add(new FullHouse());
        this.manosJugables.add(new Flush());
        this.manosJugables.add(new Straight());
        this.manosJugables.add(new ThreeOfAKind());
        this.manosJugables.add(new TwoPair());
        this.manosJugables.add(new OnePair());
        this.manosJugables.add(new HighCard());
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
}

