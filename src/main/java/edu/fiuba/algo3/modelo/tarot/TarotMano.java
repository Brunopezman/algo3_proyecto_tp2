package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

/**
public class TarotMano extends Tarot {
    //private String manoQueModifica;

    /*
    public TarotMano(int puntaje, int multiplicador, Mano mano) {
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
        this.manoQueModifica = mano;
    }
    */
/*
    public TarotMano(String nombre, String descripcion, int puntaje, int multiplicador, String mano) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
        this.aQueAplica = mano;
    }
    ///CAMBIARLO A UN MACHEO CON LA MANO CORRECTA
    public void aplicarEfectos(List<Carta> cartas, Mano mano){
        mano.aumentarAtributos(puntaje, multiplicador);
    }
}
*/

public class TarotMano extends Tarot {
    private String descripcion;
    private int puntaje;
    private int multiplicador;
    private String aQueAplica;

    public TarotMano(String nombre, String descripcion, int puntaje, int multiplicador, String mano) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
        this.aQueAplica = mano;
    }

    public void aplicarEfectos(List<Carta> cartas, Mano mano) {
        mano.aumentarAtributos(puntaje, multiplicador);
    }
}
