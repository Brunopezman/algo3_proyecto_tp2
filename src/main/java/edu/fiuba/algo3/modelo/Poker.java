package edu.fiuba.algo3.modelo;

import java.util.Map;

public class Poker extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 60;
    public static int MULTIPLICADOR_INICIAL = 7;

    // Atributos
    private int puntaje;
    private int multiplicador;

    public Poker(){
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
    }
    @Override
    public boolean esJugable(Operador cartas) {
        // Mapa para contar la cantidad de cartas por cada valor
        Map<String, Integer> conteoValores = cartas.contarPorValor();

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
