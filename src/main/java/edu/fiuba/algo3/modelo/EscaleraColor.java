package edu.fiuba.algo3.modelo;

import java.util.*;


public class EscaleraColor extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 100;
    public static int MULTIPLICADOR_INICIAL = 8;

    // Atributos
    private int puntaje;
    private int multiplicador;

    public EscaleraColor() {
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Mapa para agrupar las cartas por palo
        Map<String, List<Carta>> cartasPorPalo = new HashMap<>();

        // Agrupar las cartas por palo
        for (Carta carta : cartas) {
            cartasPorPalo.computeIfAbsent(carta.getPalo(), k -> new ArrayList<>()).add(carta);
        }

        // Verificar si hay un Straight Flush en algún palo
        for (List<Carta> cartasDelPalo : cartasPorPalo.values()) {
            if (cartasDelPalo.size() >= 5) {
                // Ordenar las cartas por su valor
                Collections.sort(cartasDelPalo, (a, b) -> Integer.compare(a.getPuntaje(), b.getPuntaje()));

                // Verificar si hay una secuencia de cartas consecutivas
                int secuenciaContador = 1;
                for (int i = 1; i < cartasDelPalo.size(); i++) {
                    if (cartasDelPalo.get(i).getPuntaje() == cartasDelPalo.get(i - 1).getPuntaje() + 1) {
                        secuenciaContador++;
                    } else if (cartasDelPalo.get(i).getPuntaje() != cartasDelPalo.get(i - 1).getPuntaje()) {
                        secuenciaContador = 1; // Si no son consecutivas, reiniciamos el contador
                    }

                    // Si encontramos una secuencia de 5 cartas consecutivas, es un Straight Flush
                    if (secuenciaContador >= 5) {
                        return true;
                    }
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
