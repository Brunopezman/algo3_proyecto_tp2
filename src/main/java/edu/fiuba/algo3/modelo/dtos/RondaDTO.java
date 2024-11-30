package edu.fiuba.algo3.modelo.dtos;

public class RondaDTO {
    private int nro;
    private int manos;
    private int descartes;
    private int puntajeASuperar;
    private TiendaDTO tienda;

    public int getNro() { return nro; }

    public int getTurnos() { return manos; }

    public int getDescartes() { return descartes; }

    public int getPuntajeASuperar() { return puntajeASuperar; }

    public TiendaDTO getTienda() { return tienda; }

    public void setNro(int nro) { this.nro = nro; }

    public void setTurnos(int manos) { this.manos = manos; }

    public void setDescartes(int descartes) { this.descartes = descartes; }

    public void setPuntajeASuperar (int puntajeASuperar) { this.puntajeASuperar = puntajeASuperar; }

    public void setTienda(TiendaDTO tienda) { this.tienda = tienda; }
}


