package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class TwoPair extends Mano{
    private int puntaje;
    private int multiplicador;

    public TwoPair() {
        this.puntaje = 20;
        this.multiplicador = 2;
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.contarPorValor(cartas);
        // Contar cuántos pares tenemos
        int pares = 0;

        // Recorrer el mapa para contar los pares
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 2) {
                pares++;
            }
        }

        // Si encontramos exactamente 2 pares, devolvemos true
        return pares == 2;
    }

    @Override
    public int calcularPuntaje(int valor) {
        return 0;
    }

    @Override
    public int getPuntaje() {
        return 0;
    }

    @Override
    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public int getMultiplicador() {
        return multiplicador;
    }

    @Override
    public void setPuntaje(int nuevoPuntaje) {

    }
}
