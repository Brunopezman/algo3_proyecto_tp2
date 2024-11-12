package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class Flush extends ContablePorPalo implements Mano{
    private int puntaje;
    private int multiplicador;


    public Flush(){
        this.puntaje = 35;
        this.multiplicador = 4;
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada palo
        Map<String, Integer> conteoPalos = this.contarPorPalo(cartas);
        // Verificar si alguno de los palos tiene al menos 5 cartas
        for (int cantidad : conteoPalos.values()) {
            if (cantidad >= 5) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int calcularPuntaje(int valor) {
        return (this.puntaje + valor)*this.multiplicador;
    }

    @Override
    public int getPuntaje() {
        return this.puntaje;
    }

    @Override
    public void setPuntaje(int nuevoPuntaje) {
        this.puntaje = nuevoPuntaje;
    }

    @Override
    public void setMultiplicador(int nuevoMultiplicador) {
        this.multiplicador = nuevoMultiplicador;
    }

    @Override
    public int getMultiplicador() {
        return this.multiplicador;
    }
}
