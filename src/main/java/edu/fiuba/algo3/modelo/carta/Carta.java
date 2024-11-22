package edu.fiuba.algo3.modelo.carta;

public class Carta {

    private Valor valor;
    private Palo palo;

    public Carta(String valor, String consecutivo, String palo) {
        this.valor = new Valor(valor, consecutivo);
        this.palo = new Palo(palo);
    }

    public String numero() { return this.valor.getNumero(); }

    public String getPalo() { return this.palo.getPalo(); }

    public int puntaje() { return this.valor.getPuntaje(); }

    public boolean esConsecutiva(Carta otraCarta) { return valor.sonConsecutivos(valor.getNumero()); }

    public boolean esIgual(Carta otraCarta){ return (this.tieneMismoPalo(otraCarta) && this.tieneMismoNumero(otraCarta)); };

    public boolean tieneMismoPalo(Carta otraCarta){ return this.palo.sonIgules(otraCarta); };

    public boolean tieneMismoNumero(Carta otraCarta){ return this.valor.sonIguales(otraCarta); };

    public void nuevoValor(int puntaje) { this.valor.actualizarPuntaje(puntaje); }

    public void multiplicarValor(int multiplicador) { this.valor.multiplicarPuntaje(multiplicador);}
}
