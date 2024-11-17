package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class Color extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 35;
    public static int MULTIPLICADOR_INICIAL = 4;

    // Atributos
    private int puntaje;
    private int multiplicador;
    private final Operador operador;

    public Color(){
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada palo
        Map<String, Integer> conteoPalos = this.operador.contarPorPalo(cartas);
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
