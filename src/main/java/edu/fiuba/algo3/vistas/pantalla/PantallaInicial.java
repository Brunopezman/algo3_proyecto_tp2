package edu.fiuba.algo3.vistas.pantalla;

import javafx.animation.FadeTransition;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
//import javafx.scene.media.Media;
//import javafx.scene.media.MediaPlayer;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.nio.file.Paths;

public class PantallaInicial {
    private final StackPane root;

    //musica
    //String musicaRuta = "src/main/java/edu/fiuba/algo3/resources/musica.mp3";
    //Media media = new Media(Paths.get(musicaRuta).toUri().toString());
    //MediaPlayer mediaPlayer = new MediaPlayer(media);
    //mediaPlayer.setCycleCount(MediaPlayer.INDEFINITE);
    //mediaPlayer.setAutoPlay(true);

    // Constructor recibe un Runnable para manejar la acción del botón
    public PantallaInicial(Runnable accionComenzar) {
        // Crear el fondo de pantalla
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


        // Contenido principal de la pantalla
        VBox contenido = new VBox();
        contenido.setAlignment(Pos.CENTER);
        contenido.setSpacing(50);

        // Título del juego
        Text titulo = new Text("B A L A T R O");
        titulo.setFont(Font.font("Comic Sans MS", 120));
        titulo.setFill(Color.YELLOW);  // Color amarillo
        titulo.setStyle("-fx-effect: dropshadow(gaussian, darkred, 5, 0.5, 0, 0);"); // Efecto sombra para resaltar

        // Botón "Comencemos"
        Button botonComencemos = new Button("COMENCEMOS");
        botonComencemos.setFont(Font.font("Arial", 25));
        botonComencemos.setStyle("-fx-background-color: #ffffff; -fx-text-fill: #000000; -fx-border-radius: 15; -fx-padding: 10px 20px;");

        // Manejador del evento usando el Runnable
        botonComencemos.setOnAction(event -> accionComenzar.run());

        // Efecto de transición en el botón
        FadeTransition fade = new FadeTransition(Duration.seconds(0.8), botonComencemos);
        fade.setFromValue(1.0);
        fade.setToValue(0.3);
        fade.setCycleCount(FadeTransition.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        // Agregar los componentes al contenedor principal
        contenido.getChildren().addAll(titulo, botonComencemos);
        fondo.getChildren().add(contenido);

        root = fondo;
    }

    // Método para obtener el nodo raíz de la vista
    public StackPane getRoot() {
        return root;
    }
}