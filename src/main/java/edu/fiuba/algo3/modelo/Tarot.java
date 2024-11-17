package edu.fiuba.algo3.modelo;

public class Tarot {
    private int valor;

    public Tarot(int valor) {
        this.valor = valor;
    }

    public Carta modificarValorCarta(Mazo mazo, Carta carta) {
        for (Carta cartaActual: mazo.getCartas()){
            if(carta.esIgual(cartaActual)){
                cartaActual.setPuntaje(this.valor);
                carta.setPuntaje(this.valor);
                return carta;
            }
        }
        return carta;
    }

    public Mano modificarMultiplicador(Mano mano){
        mano.setMultiplicador(this.valor);
        return mano;
    }
}

