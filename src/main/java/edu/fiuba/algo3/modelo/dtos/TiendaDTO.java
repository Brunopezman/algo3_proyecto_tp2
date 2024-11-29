package edu.fiuba.algo3.modelo.dtos;

import java.util.List;

public class TiendaDTO {
    private List<ComodinBaseDTO> comodines;
    private List<TarotDTO> tarots;
    private CartaDTO carta;

    public List<ComodinBaseDTO> getComodines() { return comodines; }

    public List<TarotDTO> getTarots() { return tarots; }

    public CartaDTO getCarta() { return carta; }

    public void setComodines(List<ComodinBaseDTO> comodines) { this.comodines = comodines; }

    public void setTarots(List<TarotDTO> tarots) { this.tarots = tarots; }

    public void setCarta(CartaDTO carta) { this.carta = carta; }
}
