package edu.fiuba.algo3.vistas.boton;

import edu.fiuba.algo3.controllers.BotonJugarManoHandler;
import edu.fiuba.algo3.modelo.carta.Carta;
import javafx.scene.control.Button;

import java.util.List;

public class BotonJugarMano extends Button {

    private final BotonJugarManoHandler handler;
    private List<Carta> cartasSeleccionadas;

    public BotonJugarMano(BotonJugarManoHandler handler) {
        super("Jugar Mano");
        configurarBoton();
        this.handler = handler;
        this.setOnAction(handler);
    }

    private void configurarBoton() {
        this.setStyle("-fx-font-size: 20px;-fx-background-color: \"#333333\"; -fx-font-weight: bold; -fx-text-fill: white;");

    }

    public void setCartasSeleccionadas(List<Carta> cartasSeleccionadas) {
        this.cartasSeleccionadas = cartasSeleccionadas;
    }

}
