package edu.fiuba.algo3.modelo.interfaz;
import edu.fiuba.algo3.Main;
import javafx.animation.FadeTransition;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

public class PantallaInicial {
    private StackPane root;
    private Main main;

    public PantallaInicial(Main main) {
        this.main = main;
        this.root = new StackPane();

        // Fondo
//        ImageView fondo = new ImageView(new Image("edu/fiuba/algo3/resources/imagen.webp"));
//        fondo.setFitWidth(800);
//        fondo.setFitHeight(600);
//        fondo.setPreserveRatio(true);

        // Título
        Text titulo = new Text("B A L A T R O");
        titulo.setFont(Font.font("Arial", 100));
        titulo.setStyle("-fx-fill: white; -fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);");

        // Botón
        Button botonComencemos = new Button("COMENCEMOS");
        botonComencemos.setFont(Font.font("Arial", 25));
        botonComencemos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000;");

        // Animación del botón
        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), botonComencemos);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        botonComencemos.setOnAction(event -> main.mostrarPantallaJuego());

        root.getChildren().addAll(titulo, botonComencemos);
        StackPane.setAlignment(titulo, javafx.geometry.Pos.TOP_CENTER);
        StackPane.setAlignment(botonComencemos, javafx.geometry.Pos.CENTER);
    }

    public StackPane getRoot() {
        return root;
    }
}
