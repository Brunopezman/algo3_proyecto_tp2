package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.controllers.BotonComencemosHandler;
import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.text.Font;
import javafx.util.Duration;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BotonComencemos extends Button {

    private final BotonComencemosHandler handler;

    public BotonComencemos(BotonComencemosHandler handler) {
        super("Comenzar");
        configurarBoton();
        this.handler = handler;
        this.setOnAction(handler);
    }

    private void configurarBoton() {
        Font fuenteComencemos = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 30);
        this.setFont(fuenteComencemos);
        this.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-radius: 15; -fx-padding: 10px 20px;");

        // Animación de desvanecimiento
        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), this);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();
    }

    private Font cargarFuente(String rutaFuente, int tamanio) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamanio);
        } catch (FileNotFoundException e) {
            System.err.println("Fuente no encontrada: " + rutaFuente);
            return Font.font("Arial", tamanio);
        }
    }
}
