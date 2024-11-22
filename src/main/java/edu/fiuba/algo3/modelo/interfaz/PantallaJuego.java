package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Text;

public class PantallaJuego {
    private StackPane root;
    private Main main;

    public PantallaJuego(Main main) {
        this.main = main;
        this.root = new StackPane();

        Text textoJuego = new Text("Pantalla de Juego");
        textoJuego.setStyle("-fx-font-size: 24px; -fx-fill: black;");

        root.getChildren().add(textoJuego);
    }

    public StackPane getRoot() {
        return root;
    }
}

