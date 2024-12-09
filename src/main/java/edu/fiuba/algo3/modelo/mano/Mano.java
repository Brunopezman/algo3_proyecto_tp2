package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;
import java.util.List;

public abstract class Mano {
    protected String nombre;
    protected int puntaje;
    protected int multiplicador;
    protected Operador operador;
    protected int descartes;

    abstract public Mano esJugable(List<Carta> cartas);

    protected void setPuntaje(int nuevoPuntaje) {
        puntaje = nuevoPuntaje;
    }

    protected void setMultiplicador(int nuevoMultiplicador) {
        multiplicador = nuevoMultiplicador;
    }

    public int getPuntaje() {
        return puntaje;
    }

    public int getMultiplicador() {
        return multiplicador;
    }

    public String getNombre(){ return nombre; }

    public boolean esMismaMano(String manoRecibida) {
        return this.nombre.equals(manoRecibida);
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    public void sumarDescartes(int descartes) {
        this.descartes += descartes;
    }

    public int puntajeFinal() {
        return (puntaje * multiplicador);
    }

    public int cantidadDescartes() {
        return descartes;
    }

    public void aumentarAtributos(int puntaje, int multiplicador) {
        this.puntaje += puntaje;
        this.multiplicador += multiplicador;
    }

    public void aumentarYMultiplicar(int puntos, int multiplicador) {
        this.puntaje += puntos;
        this.multiplicador *= multiplicador;
    }
}

