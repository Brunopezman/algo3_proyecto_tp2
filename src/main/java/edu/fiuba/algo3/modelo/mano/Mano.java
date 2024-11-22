package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Mano {

    protected int puntaje;
    protected int multiplicador;
    protected Operador operador;
    protected int descartes;

    abstract public boolean esJugable(List<Carta> cartas);

    protected void setPuntaje(int nuevoPuntaje){ puntaje = nuevoPuntaje; }

    protected void setMultiplicador (int nuevoMultiplicador){ multiplicador = nuevoMultiplicador; }

    public int getPuntaje(){ return puntaje; };

    public int getMultiplicador(){ return multiplicador; };

    public int calcularPuntaje(int valor){ return (this.puntaje + valor)*this.multiplicador; };

    public void modificarPuntaje (int valor){ this.setPuntaje(valor); }

    public void modificarMultiplicador(int valor){ this.setMultiplicador(valor); }

    public boolean esMismaMano(Mano manoRecibida){ return this.getClass().equals(manoRecibida.getClass()); }

    public void sumarMultiplicador(int multiplicador) {
        this.setMultiplicador(this.multiplicador+multiplicador);
    }

    public void multiplicarMultiplicador(int multiplicador) {
        this.setMultiplicador(this.multiplicador*multiplicador);
    }

    public void sumarPuntos(int puntos) {
        this.puntaje += puntos;
    }

    public void sumarDescartes(int descartes){
        this.descartes += descartes;
    }

    public int puntajeFinal() {
        return (puntaje*multiplicador);
    }

    public int cantidadDescartes() {
        return descartes;
    }
}

