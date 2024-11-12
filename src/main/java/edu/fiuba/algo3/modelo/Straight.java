package edu.fiuba.algo3.modelo;

import java.util.List;
import java.util.Collections;

public class Straight implements Mano{
    private int puntaje;
    private int multiplicador;

    public Straight() {
        this.puntaje = 30;
        this.multiplicador = 4;
    }
    @Override
    public boolean esJugable(List<Carta> cartas) {
        // Ordenamos las cartas por su puntaje
        Collections.sort(cartas, (a, b) -> Integer.compare(a.getPuntaje(), b.getPuntaje()));

        // Verificamos si hay una secuencia de 5 cartas consecutivas
        int secuenciaContador = 1; // Contamos la secuencia, empezamos con 1 porque la primera carta es parte de la secuencia
        for (int i = 1; i < cartas.size(); i++) {
            // Si las cartas son consecutivas (sin saltos en los valores)
            if (cartas.get(i).getPuntaje() == cartas.get(i - 1).getPuntaje() + 1) {
                secuenciaContador++;
            } else if (cartas.get(i).getPuntaje() != cartas.get(i - 1).getPuntaje()) {
                // Si no hay un salto (y no son cartas repetidas), reiniciamos el contador de secuencia
                secuenciaContador = 1;
            }

            // Si encontramos una secuencia de 5 cartas consecutivas, podemos decir que hay una escalera
            if (secuenciaContador >= 5) {
                return true;
            }
        }

        // Si no encontramos una secuencia de 5, no es una escalera
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
