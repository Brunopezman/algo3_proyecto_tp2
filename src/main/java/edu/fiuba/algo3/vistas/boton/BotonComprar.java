package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.controllers.BotonComprarHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BotonComprar extends Button {

    public BotonComprar(BotonComprarHandler handler) {
        super("Comprar");
        configurarBoton();
        this.setOnAction(handler);
    }

    private void configurarBoton() {
        Font fuenteConfirmar = cargarFuente("src/main/java/edu/fiuba/algo3/resources/fuentes/fuente2.otf", 20);
        this.setFont(fuenteConfirmar);
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
