package edu.fiuba.algo3.modelo.dtos;

import java.util.List;

public class TiendaDTO {
    private List<ComodinDTO> comodines;
    private List<TarotDTO> tarots;
    private CartaDTO carta;

    public List<ComodinDTO> getComodines() { return comodines; }

    public List<TarotDTO> getTarots() { return tarots; }

    public CartaDTO getCarta() { return carta; }

    public void setComodines(List<ComodinDTO> comodines) { this.comodines = comodines; }

    public void setTarots(List<TarotDTO> tarots) { this.tarots = tarots; }

    public void setCarta(CartaDTO carta) { this.carta = carta; }
}
