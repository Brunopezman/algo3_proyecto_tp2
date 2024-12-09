package edu.fiuba.algo3.modelo.tarot;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.mano.Mano;

import java.util.List;

public class TarotCarta extends Tarot {

    public TarotCarta(String nombre, String descripcion, int puntos, int mult, String ejemplar){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.puntaje = puntos;
        this.multiplicador = mult;
        this.aQueAplica = ejemplar;
    }


    //HAY QUE AGREGAR UNA FORMA DE COPARAR CARTAS PARA APLICAR EFECTOS

    public void aplicarEfectos(List<Carta> cartas, Mano mano) {
        /*for (Carta carta : cartas) {
            if (carta.esIgual(aQueAplica)) {carta.modificarPorTarot(puntaje, multiplicador);}
        }*/
        Carta cartaModificar = new Carta("", "", "", "", 0);
        for (Carta carta : cartas) {
            if (cartaModificar.puntaje() < carta.puntaje()) {
                cartaModificar = carta;
            }
        }
        cartaModificar.modificarPorTarot(puntaje, multiplicador);
    }



}
