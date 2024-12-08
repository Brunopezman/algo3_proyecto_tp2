package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.controllers.BotonAplicarTarotHandler;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class BotonAplicarTarot extends Button {

    public BotonAplicarTarot(BotonAplicarTarotHandler handler) {
        super("Aplicar");
        configurarBoton();
        this.setOnAction(handler);
    }

    private void configurarBoton() {
        this.setStyle("-fx-font-size: 20px;-fx-background-color: \"#333333\"; -fx-font-weight: bold; -fx-text-fill: white;");
    }

}
