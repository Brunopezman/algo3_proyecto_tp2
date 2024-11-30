package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

public abstract class Tarot {
    private final static String MANO = "mano";

    protected String nombre;
    protected String descripcion;
    protected int puntaje;
    protected int multiplicador;

    public static Tarot con (String nombre, String descripcion, int puntos, int mult, String sobreQueAfecta, String ejemplar){
        if(sobreQueAfecta == MANO){
            return new TarotMano(nombre,descripcion,puntos,mult,ejemplar);
        }else{
            return new TarotCarta(nombre,descripcion,puntos,mult,ejemplar);
        }
    }

    abstract void aplicarEfectos(List<Carta> cartas, Mano mano);

}

