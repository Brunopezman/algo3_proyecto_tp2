/*package edu.fiuba.algo3.modelo;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.tarot.Tarot;

import java.util.ArrayList;
import java.util.List;

public class EleccionJugador {
    private List<Comodin> comodines;
    private List<Tarot> tarots;
    private List<Carta> cartas;

    public EleccionJugador() {
        this.comodines = new ArrayList<>();
        this.tarots = new ArrayList<>();
        this.cartas = new ArrayList<>();
    }

    public void agregarComodin(Comodin comodin) {
        comodines.add(comodin);
    }

    public void agregarTarot(Tarot tarot) {
        tarots.add(tarot);
    }

    public void agregarCarta(Carta carta) {
        cartas.add(carta);
    }

    public List<Comodin> getComodines() {
        return comodines;
    }

    public List<Tarot> getTarots() {
        return tarots;
    }

    public List<Carta> getCartas() {
        return cartas;
    }
}
