package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.vistas.pantalla.PantallaJuego;

import java.util.List;

public class JugarMano implements AccionBoton {


    private final Jugador jugador;
    private final List<Carta> cartasSeleccionadas;
    private final PantallaJuego pantallaJuego;

    public JugarMano(Jugador jugador, List<Carta> cartasSeleccionadas, PantallaJuego pantallaJuego) {
        this.jugador = jugador;
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.pantallaJuego = pantallaJuego;
    }

    @Override
    public void ejecutar() {

    }
}
