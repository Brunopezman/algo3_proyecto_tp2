package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.List;

public class Tienda {
    private List<Comodin> comodines;
    private List<Tarot> tarots;
    private Carta carta;

    public Tienda(List<Comodin> comodines, List<Tarot> tarots, Carta carta) {
        this.comodines = comodines;
        this.tarots = tarots;
        this.carta = carta;
    }

    /////////AUXILIARES//////

    public List<Comodin> getComodines() {return comodines;}

    public List<Tarot> getTarots() { return tarots; }

    public Carta getCarta() { return carta; }
}
