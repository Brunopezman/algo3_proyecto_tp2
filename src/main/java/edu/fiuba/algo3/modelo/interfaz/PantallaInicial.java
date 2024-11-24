package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.nio.file.Paths;
import java.util.Objects;

public class PantallaInicial {
    private StackPane root;
    private Main main;

    public PantallaInicial(Main main) {
        this.main = main;

        StackPane fondo = new StackPane();
        fondo.setBackground(new Background(new BackgroundFill(Color.web("#28a745"), CornerRadii.EMPTY, null))); // Verde personalizado

        VBox contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(50);

        Text titulo = new Text("B A L A T R O");
        titulo.setFont(Font.font("Comic Sans MS", 120)); // Fuente personalizada (puedes cambiar el nombre por la fuente que desees)
        titulo.setFill(Color.YELLOW);  // Color amarillo
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);"); // Efecto sombra para resaltar

        Button botonComencemos = new Button("COMENCEMOS");
        botonComencemos.setFont(Font.font("Arial", 25));
        botonComencemos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-radius: 15; -fx-padding: 10px 20px;");

        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), botonComencemos);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        botonComencemos.setOnAction(event -> main.mostrarPantallaUser());

        contenido.getChildren().addAll(titulo, botonComencemos);

        fondo.getChildren().add(contenido);

        root = fondo;
    }

    public StackPane getRoot() {
        return root;
    }
}