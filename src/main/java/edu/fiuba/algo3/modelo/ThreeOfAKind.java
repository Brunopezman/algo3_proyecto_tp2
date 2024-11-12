package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class ThreeOfAKind extends ContablePorValor implements Mano{
    private int puntaje;
    private int multiplicador;

    public ThreeOfAKind() {
        this.puntaje = 30;
        this.multiplicador = 3;
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
    public void setMultiplicador(int multiplicador) {
        this.multiplicador = multiplicador;
    }

    @Override
    public int getMultiplicador() {
        return multiplicador;
    }
}


