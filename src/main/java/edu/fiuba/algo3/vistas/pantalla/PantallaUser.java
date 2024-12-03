package edu.fiuba.algo3.vistas.pantalla;

import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.nio.file.Paths;
import java.util.function.Consumer;

public class PantallaUser {
    private StackPane root;

    public PantallaUser(Consumer<String> onNombreIngresado) {
        // Crear el StackPane que contendrá la imagen de fondo
        StackPane fondo = new StackPane();

        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondo_rya2.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());

        // Configurar el fondo
        BackgroundImage backgroundImage = new BackgroundImage(
                imagenFondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, true, true, true, true)
        );
        fondo.setBackground(new Background(backgroundImage));

        // Crear el VBox para el contenido
        VBox contenido = new VBox();
        contenido.setStyle("-fx-background-color: rgba(70, 130, 180, 0.25);"); // semi-transparente

        // Texto de encabezado
        Text textoIngreseNombre = new Text("Ingrese su nombre:");
        textoIngreseNombre.setFont(Font.font("Arial", 35));
        textoIngreseNombre.setStyle("-fx-fill: white;");

        TextField campoNombre = new TextField();
        campoNombre.setPromptText("Tu nombre...");
        campoNombre.setMaxWidth(300);

        // Botón de confirmar
        Button botonConfirmar = new Button("Comenzar Partida");
        botonConfirmar.setFont(Font.font("Verdana", 25));
        botonConfirmar.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #FF0000;");

        // Evento para el botón confirmar
        botonConfirmar.setOnAction(event -> {
            String nombreIngresado = campoNombre.getText().trim();
            if (!nombreIngresado.isEmpty()) {
                // Llamar al Consumer pasado como argumento para notificar al Main
                onNombreIngresado.accept(nombreIngresado);
            } else {
                textoIngreseNombre.setText("Por favor, ingresá tu nombre.");
            }
        });

        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(30);

        // Añadir elementos al VBox
        contenido.getChildren().addAll(textoIngreseNombre, campoNombre, botonConfirmar);

        // Agregar el VBox al StackPane (imagen de fondo)
        fondo.getChildren().add(contenido);

        // Configurar el root de la pantalla
        this.root = fondo;
    }

    public StackPane getRoot() {
        return root;
    }
}