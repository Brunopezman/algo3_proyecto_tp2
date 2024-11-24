package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javax.swing.text.Element;
import java.awt.*;
import java.nio.file.Paths;

public class PantallaJuego {
    private BorderPane root;
    private Mazo mazo;
    private Ronda ronda;
    private String nombre;

    public PantallaJuego(Main main, Jugador jugador) {
        root = new BorderPane();
        mazo = new Mazo();
        ronda = new Ronda(8,3,300,jugador);
        root.setTop(crearTopArea());
        root.setBottom(crearBottomArea());
        root.setLeft(crearLeftArea(main));
        root.setRight(crearRightArea());
        root.setCenter(crearCenterArea());
    }

    private VBox crearTopArea() {
        VBox topArea = new VBox();
        int cantidadComodines = ronda.cantidadComodines();
        Text cantidadComodinesText = new Text(cantidadComodines + "/5");
        cantidadComodinesText.setStyle("-fx-font-size: 3em; -fx-fill: black;");
        topArea.getChildren().add(cantidadComodinesText);
        topArea.setAlignment(Pos.CENTER);
        return topArea;
    }

    private VBox crearBottomArea() {
        VBox bottomArea = new VBox();
        Text textoInferior = new Text("Área inferior");
        textoInferior.setStyle("-fx-font-size: 2em; -fx-fill: black;");
        bottomArea.getChildren().add(textoInferior);
        bottomArea.setAlignment(Pos.TOP_CENTER);
        return bottomArea;
    }
    private VBox crearLeftArea(Main main) {
        VBox leftArea = new VBox();
        leftArea.setAlignment(Pos.CENTER_LEFT);
        leftArea.setSpacing(15);

        //PUNTAJE NECESARIO Y ACUMULADO
        StackPane puntajeNecesario = crearCuadrado("Puntaje necesario: 50", 50, 150, "lightblue");
        StackPane puntajeAcumulado = crearCuadrado("Puntaje acumulado: 20", 50, 150, "lightgreen");
        StackPane marcador = crearCuadrado("10 x 2", 100, 150, "lightyellow");

        //TURNOS Y DESCARTES
        HBox turnosDescartes = new HBox();
        turnosDescartes.setSpacing(10);
        StackPane turnosRestantes = crearCuadrado("Turnos: 3", 100, 100, "lightcoral");
        StackPane descartesRestantes = crearCuadrado("Descartes: 2", 100, 100, "lightpink");
        turnosDescartes.getChildren().addAll(turnosRestantes, descartesRestantes);

        //Ronda
        StackPane rondaActual = crearCuadrado("Ronda: 1 / 5", 50, 150, "lightgray");

        // BOTON PARA SALIR
        Button botonSalir = new Button("Salir");
        botonSalir.setStyle("-fx-font-size: 14px; -fx-background-color: #ffcccc;");
        AccionBoton accionSalir = new Salir(main);
        botonSalir.setOnAction(new BotonHandler(accionSalir));

        leftArea.getChildren().addAll(
                puntajeNecesario,
                puntajeAcumulado,
                marcador,
                turnosDescartes,
                rondaActual,
                botonSalir
        );

        return leftArea;
    }

    // MAZO
    private VBox crearRightArea() {
        VBox rightArea = new VBox();
        rightArea.setAlignment(Pos.CENTER);
        rightArea.setSpacing(15);

//        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/reverso.jpg";
//        Image imagen = new Image(Paths.get(rutaImagen).toUri().toString());
//        ImageView imageView = new ImageView(imagen);

        int cartasRestantes = mazo.cartasRestantes();
        Text cartasRestantesText = new Text(cartasRestantes + "/52");
        cartasRestantesText.setFont(Font.font("Arial", 16));

        rightArea.getChildren().addAll(cartasRestantesText);

        return rightArea;
    }

    private VBox crearCenterArea() {
        VBox centerArea = new VBox();
        Text textoCentro = new Text("Área central de juego");
        textoCentro.setStyle("-fx-font-size: 2.5em; -fx-fill: black;");
        centerArea.getChildren().add(textoCentro);
        centerArea.setAlignment(Pos.CENTER);
        return centerArea;
    }

    public BorderPane getRoot() {
        return root;
    }

    private StackPane crearCuadrado(String texto, double altura, double anchura, String color) {
        Rectangle rect = new Rectangle(anchura, altura);
        rect.setStyle("-fx-fill: " + color + "; -fx-stroke: black; -fx-stroke-width: 1;");
        Text text = new Text(texto);
        text.setFont(Font.font("Arial", 12));
        StackPane stack = new StackPane(rect, text);
        return stack;
    }

}