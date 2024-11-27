package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.modelo.lector.LectorJson;

import java.util.List;

public class Juego {
    private List<Ronda> rondas;
    private Mazo mazo;

    public Juego(String rutaDeJson){
        JuegoFactory fabrica = new JuegoFactory(rutaDeJson);
        this.rondas = fabrica.inicializarRondas();
        this.mazo = fabrica.inicializarMazo();
    }

    // Getters y setters
    public List<Ronda> getRondas() { return rondas; }
    public void setRondas(List<Ronda> rondas) { this.rondas = rondas; }

    public Mazo getMazo() { return mazo; }
    public void setMazo(Mazo mazo) { this.mazo = mazo; }

}