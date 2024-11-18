package edu.fiuba.algo3.modelo.carta;

import java.util.List;

public class Carta {

    private String valor;
    private String palo;
    private int puntaje;

    public void setValor(String valor) { this.valor = valor; }

    public void setPuntaje(int valor) { this.puntaje = valor; }

    public void setPalo(String palo) { this.palo = palo; }

    public String getValor() { return this.valor; }

    public String getPalo() { return this.palo; }

    public int getPuntaje() { return this.puntaje; }

    public boolean esConsecutiva(Carta otraCarta) {
        List<String> orden = List.of("A", "2", "3", "4", "5","6", "7", "8", "9", "10","J", "Q", "K");

        String valorOtra = otraCarta.getValor();

        int posicionOtra = orden.indexOf(valorOtra);

        String valorConsecutivo = String.valueOf(orden.get(posicionOtra+1));

        return   valorConsecutivo.equals(this.getValor());
    }


    public boolean esIgual(Carta otraCarta){ return (this.tieneMismoPalo(otraCarta) && this.tieneMismoValor(otraCarta)); };

    public boolean tieneMismoPalo(Carta otraCarta){ return (this.palo.equals(otraCarta.getPalo())); };

    public boolean tieneMismoValor(Carta otraCarta){ return (this.valor.equals(otraCarta.getValor())); };
}
