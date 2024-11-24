package edu.fiuba.algo3.modelo.interfaz;
import edu.fiuba.algo3.Main;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.Objects;

public class PantallaInicial {
    private StackPane root;
    private Main main;

    public PantallaInicial(Main main) {
        this.main = main;

//        ImageView fondo = new ImageView(new Image(Objects.requireNonNull(getClass().getResourceAsStream("/edu/fiuba/algo3/resources/fondo.jpg"))));
//        fondo.setFitWidth(800);
//        fondo.setFitHeight(600);
//        fondo.setPreserveRatio(true);

        VBox contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(50);

        Text titulo = new Text("B A L A T R O");
        titulo.setFont(Font.font("Arial", 100));
        titulo.setStyle("-fx-fill: white; -fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        Button botonComencemos = new Button("COMENCEMOS");
        botonComencemos.setFont(Font.font("Arial", 25));
        botonComencemos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000;");

        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), botonComencemos);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        botonComencemos.setOnAction(event -> main.mostrarPantallaUser());

        contenido.getChildren().addAll(titulo, botonComencemos);

        root = new StackPane(contenido);
    }

    public StackPane getRoot() {
        return root;
    }
}
