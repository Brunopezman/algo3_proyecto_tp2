package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.controllers.BotonReinicioHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BotonReinicio extends Button {

    private BotonReinicioHandler handler;

    public BotonReinicio(BotonReinicioHandler handler) {
        super("Volver a pantalla inicio");
        configurarBoton();
        this.setOnAction(handler);
    }

    private void configurarBoton() {
        Font fuenteConfirmar = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 30);
        this.setFont(fuenteConfirmar);
        this.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #FF0000;");
    }

    private Font cargarFuente(String rutaFuente, int tamaño) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamaño);
        } catch (FileNotFoundException e) {
            System.err.println("Fuente no encontrada: " + rutaFuente);
            return Font.font("Arial", tamaño);
        }
    }
}