package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Ronda;

import java.util.List;

public class Juego {
    private List<Ronda> rondas;
    private List<Carta> mazo;

    // Getters y setters
    public List<Ronda> getRondas() { return rondas; }
    public void setRondas(List<Ronda> rondas) { this.rondas = rondas; }

    public List<Carta> getMazo() { return mazo; }
    public void setMazo(List<Carta> mazo) { this.mazo = mazo; }

}