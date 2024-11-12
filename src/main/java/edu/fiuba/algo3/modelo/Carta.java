package edu.fiuba.algo3.modelo;

public class Carta {

    private String valor;
    private String palo;
    private int puntaje;

    public Carta(String valor, String palo) {
        this.valor = valor;
        this.palo = palo;
        this.puntaje = this.asignarPuntaje(valor);
    }

    //Método para asignar puntaje basado en el valor de la carta
    private int asignarPuntaje(String valor) {
        switch (valor) {
            case "A": return 1;  // Puntaje para la carta "A"
            case "J": return 2;
            case "K": return 3;
            case "Q": return 4;
            default: return Integer.parseInt(valor);  // Para los valores numéricos
        }
    }

    public void setPuntaje(int valor) { this.puntaje = valor; }

    public String getValor() {
        return this.valor;
    }

    public String getPalo() { return this.palo; }

    public int getPuntaje() { return this.puntaje; }
}
