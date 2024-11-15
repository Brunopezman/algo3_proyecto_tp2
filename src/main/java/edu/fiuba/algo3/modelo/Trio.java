package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class Trio extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 30;
    public static int MULTIPLICADOR_INICIAL = 3;

    // Atributos
    private int puntaje;
    private int multiplicador;

    public Trio() {
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.contarPorValor(cartas);

        // Verificar si hay al menos un valor con exactamente 3 cartas
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 3) {
                return true;  // Se puede formar un Three of a Kind
            }
        }

        return false;  // No se puede formar un Three of a Kind
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


