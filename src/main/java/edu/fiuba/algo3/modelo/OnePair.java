package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class OnePair extends Mano{
    private int puntaje;
    private int multiplicador;

    public OnePair(){
        this.puntaje = 60;
        this.multiplicador = 7;
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
