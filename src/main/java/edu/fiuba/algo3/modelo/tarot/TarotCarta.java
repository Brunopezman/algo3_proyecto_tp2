package edu.fiuba.algo3.modelo.tarot;


import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

public class TarotCarta extends Tarot {
    private String cartaQueModifica;
    //private EstrategiaCarta estrategia;

    /*
    public TarotCarta(int puntaje, int multiplicador, Carta carta, EstrategiaCarta estrategia) {
        this.puntaje = puntaje;
        this.multiplicador = multiplicador;
        this.cartaQueModifica = cartaQueModifica;
        this.estrategia = estrategia;
    }
    */

    public TarotCarta(String nombre, String descripcion, int puntos, int mult, String ejemplar){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntaje = puntos;
        this.multiplicador = mult;
        this.cartaQueModifica = ejemplar;
    }


    //HAY QUE AGREGAR UNA FORMA DE COPARAR CARTAS PARA APLICAR EFECTOS

    public void aplicarEfectos(List<Carta> cartas, Mano mano){
        for (Carta carta : cartas) {
            //if (carta..esIgual(cartaQueModifica)) {estrategia.modificarCarta(carta, puntaje, multiplicador);}
        }
    }



}
