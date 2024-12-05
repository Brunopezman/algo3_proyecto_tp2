package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.controllers.BotonJugarManoHandler;
import javafx.scene.control.Button;


public class BotonJugarMano extends Button {


    public BotonJugarMano(BotonJugarManoHandler handler) {
        super("Jugar Mano");
        configurarBoton();
        this.setOnAction(handler);
    }

    private void configurarBoton() {
        this.setStyle("-fx-font-size: 20px;-fx-background-color: \"#333333\"; -fx-font-weight: bold; -fx-text-fill: white;");

    }

}
