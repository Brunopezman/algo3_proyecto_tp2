package edu.fiuba.algo3.modelo.carta;

import java.util.List;

public class Carta {

    private Valor valor;
    private Palo palo;

    public Carta(String valor, String consecutivo, String palo) {
        this.valor = new Valor(valor, consecutivo);
        this.palo = new Palo(palo);
    }

    public Valor getValor() { return this.valor; }

    public Palo getPalo() { return this.palo; }

    public boolean esConsecutiva(Carta otraCarta) { return valor.sonConsecutivos(valor.getNumero()); }

    public boolean esIgual(Carta otraCarta){ return (this.tieneMismoPalo(otraCarta) && this.tieneMismoValor(otraCarta)); };

    public boolean tieneMismoPalo(Carta otraCarta){ return (this.palo.equals(otraCarta.getPalo())); };

    public boolean tieneMismoValor(Carta otraCarta){ return (this.valor.equals(otraCarta.getValor())); };
}
