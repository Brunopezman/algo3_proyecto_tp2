package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.List;

public class TarotSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final List<Tarot> tarotsSeleccionados;
    private final ImageView imagenCarta;
    private final AudioClip sonido;

    public TarotSeleccionadoHandler(List<Tarot> tarotsSeleccionados, ImageView imagenTarot, AudioClip sonido) {
        this.tarotsSeleccionados = tarotsSeleccionados;
        this.imagenCarta = imagenTarot;
        this.sonido = sonido;
    }
    @Override
    public void handle(ActionEvent actionEvent) {

    }
}
