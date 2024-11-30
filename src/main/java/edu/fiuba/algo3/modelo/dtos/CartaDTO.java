package edu.fiuba.algo3.modelo.dtos;

public class CartaDTO {
    private String nombre;
    private String palo;
    private String numero;
    private int puntos;
    private String multiplicador;

    public String getNombre() { return nombre; }

    public String getPalo() { return palo; }

    public String getNumero() { return numero; }

    public int getPuntos() { return puntos; }

    public String getMultiplicador() { return multiplicador; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setPalo(String palo) { this.palo = palo; }

    public void setNumero(String numero) { this.numero = numero; }

    public void setPuntos(int puntos) { this.puntos = puntos; }

    public void setMultiplicador(String multiplicador) { this.multiplicador = multiplicador; }
}
