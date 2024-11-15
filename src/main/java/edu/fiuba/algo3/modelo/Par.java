package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class Par extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 10;
    public static int MULTIPLICADOR_INICIAL = 2;

    // Atributos
    private int puntaje;
    private int multiplicador;

    public Par(){
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
    }
    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.contarPorValor(cartas);
        // Verificar si hay al menos un valor con exactamente 2 cartas
        for (int cantidad : conteoValores.values()) {
            if (cantidad == 2) {
                return true;  // Se puede formar un par
            }
        }

        return false;
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
