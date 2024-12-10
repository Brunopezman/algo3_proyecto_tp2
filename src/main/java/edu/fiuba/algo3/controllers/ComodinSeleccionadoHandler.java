package edu.fiuba.algo3.controllers;

import edu.fiuba.algo3.modelo.comodin.Comodin;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.vistas.pantalla.PantallaTienda;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.control.Label;
import javafx.util.Duration;

import java.util.List;

public class ComodinSeleccionadoHandler implements EventHandler<ActionEvent> {

    private final Comodin comodin;
    private final ImageView cartaView;
    private final List<Comodin> comodinesSeleccionados;
    private final Label mensajeTemporal;

    public ComodinSeleccionadoHandler(Comodin comodin, ImageView cartaView, List<Comodin> comodinesSeleccionados, Label mensajeTemporal) {
        this.comodin = comodin;
        this.cartaView = cartaView;
        this.comodinesSeleccionados = comodinesSeleccionados;
        this.mensajeTemporal = mensajeTemporal;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        Juego juego = Juego.getInstance();
        if (comodinesSeleccionados.contains(comodin)) {
            comodinesSeleccionados.remove(comodin); //sacar efecto azul
            cartaView.setStyle("");
            PantallaTienda.reducirContador();
        } else if (PantallaTienda.sePuedeSeguirEligiendo()) {
            int comodinesYaGuardados = juego.getRondaActual().cantidadComodines();
            if ((comodinesYaGuardados + comodinesSeleccionados.size()) == 5){
                mostrarMensajeTemporal("Ya completaste/completarias los comodines maximos (5)");
            }else {
                comodinesSeleccionados.add(comodin);
                cartaView.setStyle("-fx-effect: dropshadow(gaussian, blue, 15, 0.8, 0, 0);");
                PantallaTienda.aumentarContador();

                PantallaTienda.mostrarDescripcionTemporal(comodin.getDescripcion());
            }
        }else{
            mostrarMensajeTemporal("¡No puedes seleccionar más comodines! Ya elegiste 3 opciones.");
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
