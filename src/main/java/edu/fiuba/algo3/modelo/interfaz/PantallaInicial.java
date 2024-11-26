package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
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

//        String musicaRuta = "src/main/java/edu/fiuba/algo3/resources/musica.mp3";
//        Media media = new Media(Paths.get(musicaRuta).toUri().toString());
//        MediaPlayer mediaPlayer = new MediaPlayer(media);
//        mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
//        mediaPlayer.setAutoPlay(true);

        StackPane fondo = new StackPane();
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/fondo_rya.jpeg";
        Image imagenFondo = new Image(Paths.get(rutaImagen).toUri().toString());
        BackgroundImage backgroundImage = new BackgroundImage(
                imagenFondo,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.CENTER,
                new BackgroundSize(
                        BackgroundSize.AUTO,
                        BackgroundSize.AUTO,
                        false,
                        false,
                        true,
                        true
                )
        );
        fondo.setBackground(new Background(backgroundImage));

        //sin imagen de fondo
        //StackPane fondo = new StackPane();
        //fondo.setBackground(new Background(new BackgroundFill(Color.web("#28a745"), CornerRadii.EMPTY, null)));

        VBox contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(50);

        // Titulo
        Text titulo = new Text("B A L A T R O");
        titulo.setFont(Font.font("Comic Sans MS", 120));
        titulo.setFill(Color.YELLOW);  // Color amarillo
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);"); // Efecto sombra para resaltar

        // Boton Comencemos
        Button botonComencemos = new Button("COMENCEMOS");
        botonComencemos.setFont(Font.font("Arial", 25));
        botonComencemos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-radius: 15; -fx-padding: 10px 20px;");

        AccionBoton accionComenzar = new ComenzarPartida(main);

        botonComencemos.setOnAction(new BotonHandler(accionComenzar));

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