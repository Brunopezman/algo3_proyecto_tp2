package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class PantallaUser {
    private VBox root;
    private Main main;

    public PantallaUser(Main main) {
        this.main = main;
        this.root = new VBox();
        
        Text textoIngreseNombre = new Text("Ingrese su nombre:");
        textoIngreseNombre.setFont(Font.font("Arial", 20));
        textoIngreseNombre.setStyle("-fx-fill: black;");

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Tu nombre aquí...");
        campoNombre.setMaxWidth(200);

        Button botonConfirmar = new Button("Comenzar Partida");
        botonConfirmar.setFont(Font.font("Verdana", 15));
        botonConfirmar.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #fd0052;");

        botonConfirmar.setOnAction(event -> {
            String nombreIngresado = campoNombre.getText().trim();
            if (!nombreIngresado.isEmpty()) {
                main.registrarJugador(nombreIngresado);
                main.mostrarPantallaJuego();
            } else {
                // Mostrar un mensaje si no se ingresó ningún nombre
                textoIngreseNombre.setText("Por favor, ingrese su nombre.");
            }
        });
        root.setAlignment(Pos.CENTER);
        root.setSpacing(20);
        root.getChildren().addAll(textoIngreseNombre, campoNombre, botonConfirmar);

    }

    public VBox getRoot() {
        return root;
    }
}


