package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.ParteIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

import java.util.List;

public class BotonJugarManoHandler implements EventHandler<ActionEvent> {
    private final Juego juego;
    private final List<Carta> cartasSeleccionadas;
    private final ParteIzquierda parteIzquierda;

    public BotonJugarManoHandler(Juego juego, List<Carta> cartasSeleccionadas, ParteIzquierda parteIzquierda) {
        this.juego = juego;
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.parteIzquierda = parteIzquierda;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!cartasSeleccionadas.isEmpty()) {
            int puntaje = juego.jugarMano(cartasSeleccionadas, juego.queManoEs(cartasSeleccionadas));
            parteIzquierda.actualizarPuntajeRonda(puntaje);
        } else {
            System.out.println("No has seleccionado ninguna carta.");
        }
    }
}
