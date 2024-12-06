package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.ParteDerecha;
import edu.fiuba.algo3.vistas.pantalla.ParteIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.text.Text;

import java.util.List;

public class BotonDescartarHandler implements EventHandler<ActionEvent> {

    private final Juego juego;
    private final List<Carta> cartasSeleccionadas;
    private final ParteIzquierda parteIzquierda;
    private Text cartasRestantesText;

    public BotonDescartarHandler(Juego juego, List<Carta> cartasSeleccionadas, ParteIzquierda parteIzquierda, Text cartasRestantesText) {
        this.juego = juego;
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.parteIzquierda = parteIzquierda;
        this.cartasRestantesText = cartasRestantesText;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        if (!cartasSeleccionadas.isEmpty()) {
            juego.quitarCartasUsadas(cartasSeleccionadas);
            juego.repartirCartasJugador(cartasSeleccionadas.size());
            cartasSeleccionadas.clear();
            parteIzquierda.actualizar();
            ParteDerecha.actualizarVisualCartas(cartasSeleccionadas);
        } else {
            System.out.println("No has seleccionado ninguna carta.");
        }
    }
}
