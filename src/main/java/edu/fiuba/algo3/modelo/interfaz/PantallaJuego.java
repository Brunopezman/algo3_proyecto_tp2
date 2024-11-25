package edu.fiuba.algo3.modelo.interfaz;

import edu.fiuba.algo3.Main;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class PantallaJuego {
    private GridPane root;
    private Mazo mazo;
    private Ronda ronda;
    private Jugador jugador;
    private List<Carta> cartas;
    private List<Carta> cartasSeleccionadas;

    public PantallaJuego(Main main, Jugador jugador) {
        this.root = new GridPane();
        this.mazo = new Mazo();
        this.ronda = new Ronda(8, 3, 300, jugador);
        this.jugador = jugador;
        this.cartas = jugador.recibirCartas(mazo);
        this.cartasSeleccionadas = new ArrayList<>();

        root.setHgap(10);
        root.setVgap(10);

        root.add(crearLeftArea(main), 0, 0);
        root.add(crearRightArea(),1,0);

        // Crear ScrollPane solo para la parte que necesita desplazarse
        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);
    }

    private VBox crearLeftArea(Main main) {
        VBox leftArea = new VBox();
        leftArea.setAlignment(Pos.CENTER_LEFT);
        leftArea.setSpacing(15);

        StackPane puntajeNecesario = crearCuadrado("Puntaje necesario: 300", 50, 150, "lightblue");
        StackPane puntajeAcumulado = crearCuadrado("Puntaje acumulado: 20", 50, 150, "lightgreen");
        StackPane marcador = crearCuadrado("10 x 2", 100, 150, "lightyellow");

        HBox turnosDescartes = new HBox();
        turnosDescartes.setSpacing(10);
        StackPane turnosRestantes = crearCuadrado("Turnos:" + ronda.turnoActual() + "/" + ronda.cantidadDeTurnos(), 100, 100, "lightcoral");
        StackPane descartesRestantes = crearCuadrado("Descartes: 2", 100, 100, "lightpink");
        turnosDescartes.getChildren().addAll(turnosRestantes, descartesRestantes);

        StackPane rondaActual = crearCuadrado("Ronda: 1 / 8", 50, 150, "lightgray");

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

        leftArea.setPadding(new Insets(20, 10, 20, 20));
        return leftArea;
    }

    private BorderPane crearRightArea() {
        BorderPane rightArea = new BorderPane();

        // Comodines y Tarots (zona superior)
        HBox comodinesTarots = new HBox();
        comodinesTarots.setSpacing(50);
        comodinesTarots.setAlignment(Pos.CENTER);  // Centrado en la parte superior

        int cantidadComodines = ronda.cantidadComodines();
        int cantidadTarots = 0;

        // Comodines
        Rectangle comodines = new Rectangle(200, 80);
        comodines.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        Text cantidadComodinesText = new Text(cantidadComodines + "/5");
        cantidadComodinesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #101010;");
        VBox comodinesBox = new VBox(comodines, cantidadComodinesText);
        comodinesBox.setAlignment(Pos.TOP_LEFT);
        comodinesBox.setSpacing(5);

        // Tarots
        Rectangle tarots = new Rectangle(120, 80);
        tarots.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        Text cantidadTarotsText = new Text(cantidadTarots + "/2");
        cantidadTarotsText.setStyle("-fx-font-size: 0.8em; -fx-fill: #101010;");
        VBox tarotsBox = new VBox(tarots, cantidadTarotsText);
        tarotsBox.setAlignment(Pos.TOP_RIGHT);
        tarotsBox.setSpacing(5);

        comodinesTarots.getChildren().addAll(comodinesBox, tarotsBox);
        rightArea.setTop(comodinesTarots);

        // Cartas del jugador
        HBox visualCartas = crearVisualCartas();
        rightArea.setCenter(visualCartas);

        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER_LEFT);  // Los botones alineados a la izquierda

        Button botonJugarMano = new Button("Jugar Mano");
        Button botonDescartar = new Button("Descartar");
        botonJugarMano.setStyle("-fx-font-size: 20px; -fx-background-color: #104ec1;");
        botonDescartar.setStyle("-fx-font-size: 20px; -fx-background-color: #ec1111;");
        AccionBoton accionJugarMano = new JugarMano(jugador, cartasSeleccionadas, this);
        AccionBoton accionDescartar = new Descartar();
        botonJugarMano.setOnAction(new BotonHandler(accionJugarMano));
        botonDescartar.setOnAction(new BotonHandler(accionDescartar));

        botones.getChildren().addAll(botonJugarMano, botonDescartar);

        //Mazo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/reverso.jpg";
        Image imagen = new Image(Paths.get(rutaImagen).toUri().toString());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        int cartasRestantes = mazo.cartasRestantes();
        Text cartasRestantesText = new Text(cartasRestantes + "/52");
        cartasRestantesText.setFont(Font.font("Arial", 16));

        // Agregar la imagen y el texto de cartas restantes a la derecha
        VBox imagenYTexto = new VBox(10, imageView, cartasRestantesText);
        imagenYTexto.setAlignment(Pos.CENTER_RIGHT);  // Alineación de la imagen a la derecha

        // Añadir el HBox con los botones y la imagen
        HBox botonesYMazo = new HBox(40, botones, imagenYTexto);
        VBox contenidoInferior = new VBox(botonesYMazo);
        contenidoInferior.setAlignment(Pos.CENTER_RIGHT);  // Centrado de los elementos dentro del HBox
        rightArea.setBottom(contenidoInferior);

        rightArea.setPadding(new Insets(10));

        return rightArea;
    }

    private HBox crearVisualCartas() {
        HBox visualCartas = new HBox();
        visualCartas.setSpacing(10);
        visualCartas.setAlignment(Pos.CENTER);

        for (Carta carta : cartas) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/" + carta.puntaje() + "_"+carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(80);
            imagenCarta.setFitHeight(120);

            imagenCarta.setOnMouseClicked(event -> {
                if (cartasSeleccionadas.contains(carta)) {
                    cartasSeleccionadas.remove(carta);
                    imagenCarta.setStyle("-fx-effect: null;");
                } else if (cartasSeleccionadas.size() < 5) {
                    cartasSeleccionadas.add(carta);
                    imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
                }
            });

            visualCartas.getChildren().add(imagenCarta);
        }

        return visualCartas;
    }

    public GridPane getRoot() {
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
