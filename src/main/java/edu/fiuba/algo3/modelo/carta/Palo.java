package edu.fiuba.algo3.modelo.carta;

public class Palo {
    private String palo;

    public Palo(String palo) { this.palo = palo;}

    public String getPalo() {return this.palo;}

    public boolean sonIgules(Carta otraCarta) {
        return this.palo.equals(otraCarta.getPalo());
    }
}
