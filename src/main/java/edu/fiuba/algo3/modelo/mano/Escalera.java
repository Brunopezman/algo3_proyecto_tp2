package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;

public class Escalera extends Mano{
    // Constantes
    public static int PUNTAJE_INICIAL = 30;
    public static int MULTIPLICADOR_INICIAL = 4;

    public Escalera() {
        this.nombre = "escalera";
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {
        return (this.verificarEscalera(cartas));
    }

    public boolean verificarEscalera(List<Carta> cartas){

        List<Carta> cartasOrdenadas = this.operador.ordenarCartasPorValor(cartas);

        int secuenciaContador = 1; // Contamos la secuencia, empezamos con 1 porque la primera carta es parte de la secuencia

        for (int i = 1; i < cartasOrdenadas.size(); i++) {

            Carta cartaActual = cartasOrdenadas.get(i);
            Carta cartaAnterior = cartasOrdenadas.get(i - 1);

            // Si las cartas son consecutivas (sin saltos en los valores)
            if (cartaActual.esConsecutiva(cartaAnterior)) {
                secuenciaContador++;
            }
            else if (!(cartaActual.tieneMismoNumero(cartaAnterior))) {
                secuenciaContador = 1;
            }
            // Si encontramos una secuencia de 5 cartas consecutivas, podemos decir que hay una escalera
            if (secuenciaContador >= 5) {
                return true;
            }
        }
        return false;
    }
}
