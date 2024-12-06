package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.comodin.Comodin;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.List;

public class ComodinSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final List<Comodin> comodinesSeleccionados;
    private final ImageView imagenCarta;
    private final AudioClip sonido;

    public ComodinSeleccionadoHandler(List<Comodin> comodinesSeleccionados, ImageView imagenComodin, AudioClip sonido) {
        this.comodinesSeleccionados = comodinesSeleccionados;
        this.imagenCarta = imagenComodin;
        this.sonido = sonido;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
