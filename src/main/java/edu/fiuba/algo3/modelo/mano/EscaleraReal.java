package edu.fiuba.algo3.modelo.mano;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.stream.Collectors;
import java.util.List;
import java.util.Map;

public class EscaleraReal extends Mano{

    // Constantes
    public static int PUNTAJE_INICIAL = 100;
    public static int MULTIPLICADOR_INICIAL = 8;

    // Atributos
    private int puntaje;
    private int multiplicador;
    private Operador operador;

    public EscaleraReal(){
        this.puntaje = PUNTAJE_INICIAL;
        this.multiplicador = MULTIPLICADOR_INICIAL;
        this.operador = new Operador();
    }

    @Override
    public boolean esJugable(List<Carta> cartas) {

        Map<String, List<Carta>> cartasPorPalo = operador.separarPorPalo(cartas);

        for (List<Carta> cartasDelMismoPalo : cartasPorPalo.values()) {
            List<String> valoresRequeridos = List.of("10", "J", "Q", "K", "A");
            List<String> valoresEnPalo = cartasDelMismoPalo.stream()
                    .map(Carta::getValor)
                    .collect(Collectors.toList());
            if (valoresEnPalo.containsAll(valoresRequeridos)) {
                return true;
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
