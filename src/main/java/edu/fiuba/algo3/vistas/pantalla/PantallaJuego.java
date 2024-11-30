package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.vistas.boton.*;
import edu.fiuba.algo3.vistas.menu.MenuJuego;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;
import javafx.scene.layout.VBox;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;

import javafx.stage.Stage;

public class PantallaJuego {
    private VBox root;
    private GridPane contenidoJuego;
    private final MenuJuego menuJuego;
    private Mazo mazo;
    private Ronda ronda;
    private Jugador jugador;
    private List<Carta> cartas;
    private List<Carta> cartasSeleccionadas;
    private Text cartasRestantesText;
    private Stage stage;

    private HBox visualCartas;
    private Text mensajeInicio;

    public PantallaJuego(Jugador jugador, Stage stage) {
        this.stage = stage;
        this.root = new VBox();
        this.contenidoJuego = new GridPane();
        this.menuJuego = new MenuJuego(stage);
        //this.mazo = new Mazo();
        //this.ronda = new Ronda(8, 3, 300, jugador);
        Juego juego = new Juego("src/main/java/edu/fiuba/algo3/resources/archivosJson/balatro.json");
        this.mazo = juego.getMazo();
        this.ronda = juego.getRondas().get(0);
        this.jugador = jugador;
        this.cartas = new ArrayList<>(); // Vacío al inicio
        this.cartasSeleccionadas = new ArrayList<>();

        // Configuración inicial del GridPane
        contenidoJuego.setHgap(10);
        contenidoJuego.setVgap(10);

        // Crear las áreas izquierda y derecha
        contenidoJuego.add(crearLeftArea(), 0, 0);
        contenidoJuego.add(crearRightArea(), 1, 0);

        root.getChildren().addAll(menuJuego.getMenuBar(), contenidoJuego);

        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        contenidoJuego.setStyle("-fx-background-color: #28a745;");
    }

    private VBox crearLeftArea() {
        VBox leftArea = new VBox();
        leftArea.setAlignment(Pos.CENTER_LEFT);
        leftArea.setSpacing(15);

        // Cuadrados informativos
        StackPane puntajeNecesario = crearCuadrado("Puntaje necesario: 300", 50, 200, "lightblue");
        StackPane puntajeAcumulado = crearCuadrado("Puntaje acumulado: 20", 50, 200, "lightgreen");
        StackPane marcador = crearCuadrado("10 x 2", 100, 150, "lightyellow");

        HBox turnosDescartes = new HBox();
        turnosDescartes.setSpacing(10);
        StackPane turnosRestantes = crearCuadrado("Turnos:" + ronda.turnoActual() + "/" + ronda.cantidadDeTurnos(), 100, 120, "lightcoral");
        StackPane descartesRestantes = crearCuadrado("Descartes: 0", 100, 120, "lightpink");
        turnosDescartes.getChildren().addAll(turnosRestantes, descartesRestantes);

        StackPane rondaActual = crearCuadrado("Ronda: 1 / 8", 50, 150, "lightgray");

        leftArea.getChildren().addAll(
                puntajeNecesario,
                puntajeAcumulado,
                marcador,
                turnosDescartes,
                rondaActual
        );

        leftArea.setPadding(new Insets(20, 10, 20, 20));
        return leftArea;
    }

    private BorderPane crearRightArea() {
        BorderPane rightArea = new BorderPane();

        // Crear un StackPane para el mensaje inicial
        StackPane mensajeCentro = new StackPane();
        Text mensajeInstruccion = new Text("Tocá el mazo para comenzar");
        mensajeInstruccion.setStyle("-fx-fill: #ff0000; -fx-font-weight: bold;");
        mensajeInstruccion.setFont(new Font(20));
        mensajeCentro.getChildren().add(mensajeInstruccion);
        mensajeCentro.setAlignment(Pos.CENTER);

        // Colocar el StackPane en el centro de la pantalla
        rightArea.setCenter(mensajeCentro);

        // Comodines y Tarots
        HBox comodinesTarots = new HBox();
        comodinesTarots.setSpacing(50);
        comodinesTarots.setAlignment(Pos.CENTER);

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

        // Cartas del jugador: inicialmente vacío
        visualCartas = new HBox();
        visualCartas.setSpacing(10);
        visualCartas.setAlignment(Pos.CENTER);

        // Botones y Mazo
        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER_LEFT);

        Button botonJugarMano = new Button("Jugar Mano");
        Button botonDescartar = new Button("Descartar");
        botonJugarMano.setStyle("-fx-font-size: 20px; -fx-background-color: #104ec1;");
        botonDescartar.setStyle("-fx-font-size: 20px; -fx-background-color: #ec1111;");
        AccionBoton accionJugarMano = new JugarMano(jugador, cartasSeleccionadas, this);
        AccionBoton accionDescartar = new Descartar();
        botonJugarMano.setOnAction(new BotonHandler(accionJugarMano));
        botonDescartar.setOnAction(new BotonHandler(accionDescartar));

        botones.getChildren().addAll(botonJugarMano, botonDescartar);

        // Mazo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/reverso.jpg";
        Image imagen = new Image(Paths.get(rutaImagen).toUri().toString());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        int cartasRestantes = mazo.cartasRestantes();
        cartasRestantesText = new Text(cartasRestantes + "/52");
        cartasRestantesText.setFont(Font.font("Arial", 16));

        // Evento al hacer clic en el mazo
        imageView.setOnMouseClicked(event -> {
            if (rightArea.getCenter() != null) {
                // Eliminar el mensaje de instrucción al hacer clic en el mazo por primera vez
                rightArea.setCenter(null);
                // Mostrar las cartas después de hacer clic por primera vez
                rightArea.setCenter(visualCartas);
                repartirCartas();
            }
        });

        VBox imagenYTexto = new VBox(10, imageView, cartasRestantesText);
        imagenYTexto.setAlignment(Pos.CENTER_RIGHT);

        // Añadir el HBox con los botones y la imagen
        HBox botonesYMazo = new HBox(40, botones, imagenYTexto);
        VBox contenidoInferior = new VBox(botonesYMazo);
        contenidoInferior.setAlignment(Pos.CENTER_RIGHT);
        rightArea.setBottom(contenidoInferior);

        rightArea.setPadding(new Insets(10));
        return rightArea;
    }

    private HBox crearVisualCartas() {
        HBox visualCartas = new HBox();
        visualCartas.setSpacing(10);
        visualCartas.setAlignment(Pos.CENTER);

        for (Carta carta : cartas) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/" + carta.numero() + "_" + carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(80);
            imagenCarta.setFitHeight(120);

            imagenCarta.setOnMouseClicked(event -> {
                if (cartasSeleccionadas.contains(carta)) {
                    cartasSeleccionadas.remove(carta);
                    imagenCarta.setStyle("-fx-effect: null;");
                } else if (cartasSeleccionadas.size() < 5) {
                    cartasSeleccionadas.add(carta);
                    imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
                } else {
                    System.out.println("No puedes seleccionar más de 5 cartas.");
                }
            });

            visualCartas.getChildren().add(imagenCarta);
        }

        return visualCartas;
    }

    private void repartirCartas() {
        // Verificar cuántas cartas hay actualmente en pantalla
        if (cartas.size() >= 8) {
            System.out.println("Ya tienes 8 cartas en pantalla, no puedes repartir más.");
            return; // No repartir más cartas si ya hay 8 en pantalla
        }

        // Calcular cuántas cartas necesitamos repartir
        int cartasNecesarias = 8 - cartas.size();

        // Usar un Set para evitar cartas duplicadas
        Set<String> cartasEnPantalla = new HashSet<>(); // Usamos un Set para guardar los identificadores únicos de las cartas

        // Agregar las cartas actuales de la pantalla al Set (con identificador único)
        for (Carta carta : cartas) {
            cartasEnPantalla.add(carta.numero() + "_" + carta.getPalo());
        }

        // Repartir cartas sin duplicados
        List<Carta> nuevasCartas = new ArrayList<>();
        while (nuevasCartas.size() < cartasNecesarias) {
            // Dar una carta desde el mazo
            Carta carta = mazo.darCartas(1).get(0); // darCartas(1) da una carta a la vez

            // Crear un identificador único para la carta
            String idCarta = carta.puntaje() + "_" + carta.getPalo();

            // Verificar si la carta ya ha sido repartida o si ya está en la pantalla
            if (!cartasEnPantalla.contains(idCarta)) {
                nuevasCartas.add(carta);  // Añadir la carta a la lista de nuevas cartas
                cartasEnPantalla.add(idCarta); // Añadir al Set para evitar duplicados en el futuro
            }
        }

        // Si se obtuvieron cartas, agregar al listado de cartas en la pantalla
        if (!nuevasCartas.isEmpty()) {
            cartas.addAll(nuevasCartas); // Agregar las nuevas cartas a la lista
            actualizarVisualCartas();    // Actualizar la visualización de las cartas
        }

        // Actualizar el texto con las cartas restantes
        cartasRestantesText.setText(mazo.cartasRestantes() + "/52");
    }


    private void actualizarVisualCartas() {
        // Limpiar la visualización actual
        visualCartas.getChildren().clear();

        // Agregar las cartas nuevas
        for (Carta carta : cartas) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/" + carta.puntaje() + "_" + carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(80);
            imagenCarta.setFitHeight(120);

            imagenCarta.setOnMouseClicked(event -> {
                if (cartasSeleccionadas.contains(carta)) {
                    cartasSeleccionadas.remove(carta);
                    imagenCarta.setStyle("-fx-effect: null;");
                } else if (cartasSeleccionadas.size() < 5) {
                    cartasSeleccionadas.add(carta);
                    imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
                } else {
                    System.out.println("No puedes seleccionar más de 5 cartas.");
                }
            });

            visualCartas.getChildren().add(imagenCarta);
        }
    }

    private StackPane crearCuadrado(String texto, int alto, int ancho, String color) {
        Rectangle fondo = new Rectangle(ancho, alto);
        fondo.setStyle("-fx-fill: " + color + "; -fx-stroke: black; -fx-stroke-width: 2;");

        Text textoInterno = new Text(texto);
        textoInterno.setStyle("-fx-font-size: 16px; -fx-fill: black;");

        StackPane stackPane = new StackPane();
        stackPane.getChildren().addAll(fondo, textoInterno);

        return stackPane;
    }



    public VBox getRoot() {
        return root;
    }
}