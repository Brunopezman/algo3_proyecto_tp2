package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.*;


public class EscaleraColor extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 100;
    public static int MULTIPLICADOR_INICIAL = 8;

    // Atributos
    private int puntaje;
    private int multiplicador;
    private Operador operador;
    private Escalera escalera;


    public EscaleraColor() {
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.escalera = new Escalera();
        this.operador = new Operador();
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {

        Map<String, List<Carta>> cartasPorPalo = this.operador.agruparPorPalo(cartas);

        // Verificar si hay un Straight Flush en algún palo
        for (List<Carta> cartasDelPalo : cartasPorPalo.values()) {
            if (cartasDelPalo.size() >= 5) {
                if (this.escalera.verificarEscalera(cartasDelPalo)) {
                    return true;
                }
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
