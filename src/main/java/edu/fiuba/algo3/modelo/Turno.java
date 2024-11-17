package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.ArrayList;

public class Turno {
    private List<Mano> manosJugables;
    private int puntaje;

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
    }

    public boolean existeManoJugable(List<Carta> cartas){
        boolean existe = false;
        Operador conjunto = new Operador(cartas);
        for (Mano mano : this.manosJugables){
            if (mano.esJugable(conjunto)){
                existe = true;
            }
        }
        return existe;
    }
}

