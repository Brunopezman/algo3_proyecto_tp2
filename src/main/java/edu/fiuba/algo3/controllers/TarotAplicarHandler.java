package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.tarot.Tarot;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;

import java.util.List;

public class TarotAplicarHandler implements EventHandler<ActionEvent> {

    private final List<Tarot> tarotSeleccionados;
    private final Tarot tarot;
    private final ImageView imagenCarta;
    private final AudioClip sonido;

    public TarotAplicarHandler(List<Tarot> tarotSeleccionados, Tarot tarot, ImageView imagenCarta, AudioClip sonido) {
        this.tarotSeleccionados = tarotSeleccionados;
        this.tarot = tarot;
        this.imagenCarta = imagenCarta;
        this.sonido = sonido;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        sonido.play();
        if (tarotSeleccionados.contains(tarot)) {
            tarotSeleccionados.remove(tarot);
            imagenCarta.setStyle("");
        }else if(tarotSeleccionados.isEmpty()){
            tarotSeleccionados.add(tarot);
            imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
        }else{
            System.out.println("Solo un tarot puede ser seleccionado para usarse!!!");
        }
        System.out.println(tarotSeleccionados.size());


    }
}
