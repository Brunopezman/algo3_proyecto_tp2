package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.controllers.BotonDescartarHandler;
import edu.fiuba.algo3.modelo.carta.Carta;
import javafx.scene.control.Button;

import java.util.List;

public class BotonDescartar extends Button {

    private final BotonDescartarHandler handler;
    private List<Carta> cartasSeleccionadas;

    public BotonDescartar(BotonDescartarHandler handler) {
        super("Descartar");
        configurarBoton();
        this.handler = handler;
        this.setOnAction(handler);
    }

    private void configurarBoton() {
        this.setStyle("-fx-font-size: 20px; -fx-background-color: \"#333333\"; -fx-font-weight: bold; -fx-text-fill: white;");

    }
}
