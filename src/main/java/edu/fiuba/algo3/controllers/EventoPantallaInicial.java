package edu.fiuba.algo3.controllers;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.media.AudioClip;
import java.nio.file.Paths;

public class EventoPantallaInicial implements EventHandler<ActionEvent> {
    private final AudioClip sonido; // Referencia al sonido

    public EventoPantallaInicial() {
        // Ruta al archivo de sonido
        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3";
        this.sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());
    }

    @Override
    public void handle(ActionEvent event) {
        // Reproducir el sonido al hacer clic
        sonido.play();
    }
}