package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Map;

public class FourOfAKind extends ContablePorValor implements Mano{
    private int puntaje;
    private int multiplicador;

    public FourOfAKind(){
        this.puntaje = 60;
        this.multiplicador = 7;
    }
    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = this.contarPorValor(cartas);

        // Verificar si hay un valor con al menos 4 cartas
        for (int cantidad : conteoValores.values()) {
            if (cantidad >= 4) {
                return true;  // Se puede formar un Four of a Kind
            }
        }

        return false;
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
