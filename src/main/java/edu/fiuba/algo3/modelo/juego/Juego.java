package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.fabrica.JuegoFabrica;

import java.util.List;

public class Juego {
    private List<Ronda> rondas;
    private Mazo mazo;

    public Juego(String rutaDeJson){
        JuegoFabrica fabrica = new JuegoFabrica(rutaDeJson);
        this.rondas = fabrica.inicializarRondas();
        this.mazo = fabrica.inicializarMazo();
    }

    // Getters y setters
    public List<Ronda> getRondas() { return rondas; }
    public void setRondas(List<Ronda> rondas) { this.rondas = rondas; }

    public Mazo getMazo() { return mazo; }
    public void setMazo(Mazo mazo) { this.mazo = mazo; }

}