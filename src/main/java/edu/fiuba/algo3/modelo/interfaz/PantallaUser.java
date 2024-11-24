package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PantallaUser {
    private VBox root;
    private Main main;

    public PantallaUser(Main main) {
        this.main = main;
        this.root = new VBox();

        root.setStyle("-fx-background-color: #4682B4;");  // Celeste oscuro

        Text textoIngreseNombre = new Text("Ingrese su nombre:");
        textoIngreseNombre.setFont(Font.font("Arial", 30));  // Aumentar tamaño de fuente
        textoIngreseNombre.setStyle("-fx-fill: white;");  // Cambiar color a blanco para contraste

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Tu nombre aquí...");
        campoNombre.setMaxWidth(250);

        Button botonConfirmar = new Button("Comenzar Partida");
        botonConfirmar.setFont(Font.font("Verdana", 20));  // Aumentar tamaño de fuente
        botonConfirmar.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #fd0052;");

        botonConfirmar.setOnAction(event -> {
            String nombreIngresado = campoNombre.getText().trim();
            if (!nombreIngresado.isEmpty()) {
                main.registrarJugador(nombreIngresado);
                main.mostrarPantallaJuego();
            } else {
                textoIngreseNombre.setText("Por favor, ingrese su nombre.");
            }
        });

        root.setAlignment(Pos.CENTER);
        root.setSpacing(30);

        root.getChildren().addAll(textoIngreseNombre, campoNombre, botonConfirmar);
    }

    public VBox getRoot() {
        return root;
    }
}