package edu.fiuba.algo3.modelo.carta;

public class Valor {
    private String numero;
    private String consecutivo;
    private int puntaje;

    public Valor(String numero, String consecutivo) {
        this.numero = numero;
        this.consecutivo = consecutivo;
        if (numero.equals("Jota") || numero.equals("Reina") || numero.equals("Rey")) {this.puntaje = 10;}
        else if(numero.equals("As")){this.puntaje = 11;}
        else this.puntaje = Integer.parseInt(numero);
    }

    public String getNumero() { return numero; }

    public int getPuntaje() {return puntaje; }

    public boolean sonConsecutivos(String otroNumero) { return numero.equals(otroNumero); }

    public boolean sonIguales(Carta otraCarta) { return this.numero.equals(otraCarta.numero());}

    public void actualizarPuntaje(int puntaje) { this.puntaje = puntaje; }

    public void multiplicarPuntaje(int multiplicador) { this.puntaje *= multiplicador; }
}
