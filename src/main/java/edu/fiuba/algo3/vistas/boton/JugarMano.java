package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.modelo.carta.Carta;

import java.util.List;

public class JugarMano implements AccionBoton {

    private List<Carta> cartasSeleccionadas;

    public void setCartasSeleccionadas(List<Carta> cartasSeleccionadas) {
        this.cartasSeleccionadas = cartasSeleccionadas;
    }

    @Override
    public void ejecutar() {

    }
}
