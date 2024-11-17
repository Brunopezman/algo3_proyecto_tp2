package edu.fiuba.algo3.modelo;

public class CartaNumerica extends Carta{

    public CartaNumerica(String valor, String palo) {
        this.setValor(valor);
        this.setPuntaje(Integer.parseInt(valor));
        this.setPalo(palo);
    }

}
