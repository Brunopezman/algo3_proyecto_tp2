package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.mano.Mano;
import edu.fiuba.algo3.vistas.pantalla.ParteIzquierda;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;

public class CartaSeleccionadaHandler implements EventHandler<ActionEvent> {
    private final List<Carta> cartasSeleccionadas;
    private final Carta carta;
    private final ImageView imagenCarta;
    private ParteIzquierda parteIzquierda;
    private final Label mensajeTemporal;

    public CartaSeleccionadaHandler(List<Carta> cartasSeleccionadas, Carta carta, ImageView imagenCarta, ParteIzquierda parteIzquierda, Label mensajeTemporal) {
        this.cartasSeleccionadas = cartasSeleccionadas;
        this.carta = carta;
        this.imagenCarta = imagenCarta;
        this.parteIzquierda = parteIzquierda;
        this.mensajeTemporal = mensajeTemporal;
    }

    @Override
    public void handle(ActionEvent event) {
        System.out.println(cartasSeleccionadas.size());
        if (cartasSeleccionadas.contains(carta)) {
            // Deseleccionar carta
            cartasSeleccionadas.remove(carta);
            if (cartasSeleccionadas.size() < 5){
                parteIzquierda.cuadroParaManoPorJugar("","0","0");
            }
            imagenCarta.setStyle("-fx-effect:null;");
        } else if (cartasSeleccionadas.size() < 5) {
            // Seleccionar carta
            cartasSeleccionadas.add(carta);
            imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
            if (cartasSeleccionadas.size() == 5) {
                Juego juego = Juego.getInstance();
                Mano posibleMano = juego.queManoEs(cartasSeleccionadas);
                String nombre = posibleMano.getNombre();
                String puntos = String.valueOf(posibleMano.getPuntaje());
                String multiplicador = String.valueOf(posibleMano.getMultiplicador());
                parteIzquierda.cuadroParaManoPorJugar(nombre,puntos,multiplicador);
            }
        } else {
            mostrarMensajeTemporal("No puedes seleccionar más de 5 cartas.");
        }
    }

    private void mostrarMensajeTemporal(String mensaje) {
        mensajeTemporal.setText(mensaje);
        mensajeTemporal.setVisible(true);

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(2), e -> mensajeTemporal.setVisible(false)));
        timeline.setCycleCount(1); // Solo ejecutar una vez
        timeline.play();
    }
}
