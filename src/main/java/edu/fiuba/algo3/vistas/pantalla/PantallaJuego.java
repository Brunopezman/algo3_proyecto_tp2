package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Mazo;
import edu.fiuba.algo3.modelo.juego.Ronda;
import edu.fiuba.algo3.vistas.boton.Descartar;
import edu.fiuba.algo3.vistas.boton.JugarMano;
import edu.fiuba.algo3.vistas.boton.Salir;
import edu.fiuba.algo3.vistas.boton.AccionBoton;
import edu.fiuba.algo3.vistas.boton.BotonHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import java.nio.file.Paths;
import java.util.*;
import java.util.List;

import javafx.stage.Stage;
import javafx.scene.layout.VBox;

public class PantallaJuego {
    private GridPane root;
    private Mazo mazo;
    private Ronda ronda;
    private Jugador jugador;
    private List<Carta> cartas;
    private List<Carta> cartasSeleccionadas;
    private Text cartasRestantesText;
    private Stage stage;

    private HBox visualCartas;

    public PantallaJuego(Jugador jugador, Stage stage) {
        this.stage = stage; // Guarda el Stage pasado como argumento
        this.root = new GridPane();
        //this.mazo = new Mazo();
        //this.ronda = new Ronda(8, 3, 300, jugador);
        Juego juego = new Juego("src/main/java/edu/fiuba/algo3/resources/archivosJson/balatro.json");
        this.mazo = juego.getMazo();
        this.ronda = juego.getRondas().get(0);
        this.jugador = jugador;
        this.cartas = new ArrayList<>(); // Vacío al inicio
        this.cartasSeleccionadas = new ArrayList<>();

        root.setHgap(10);
        root.setVgap(10);

        root.add(crearLeftArea(), 0, 0);
        root.add(crearRightArea(), 1, 0);

        ScrollPane scrollPane = new ScrollPane(root);
        scrollPane.setFitToWidth(true);
        scrollPane.setFitToHeight(true);

        root.setStyle("-fx-background-color: #28a745;");
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

        // Botón de salir con su acción personalizada
        Button botonSalir = new Button("Salir");
        botonSalir.setStyle("-fx-font-size: 14px; -fx-background-color: #ffcccc;");
        AccionBoton accionSalir = new Salir(stage); // Pasa el Stage al constructor de Salir
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

        rightArea.setCenter(visualCartas);

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
        imageView.setOnMouseClicked(event -> repartirCartas());

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

        return visualCartas;
    }

//    private void repartirCartas() {
//        // Repartir cartas al jugador desde el mazo
//        List<Carta> nuevasCartas = jugador.recibirCartas(mazo);
//
//        if (!nuevasCartas.isEmpty()) {
//            cartas.addAll(nuevasCartas); // Agregar las nuevas cartas a la lista
//            actualizarVisualCartas();   // Actualizar la visualización en pantalla
//        }
//
//        // Actualizar el texto del mazo con las cartas restantes
//        cartasRestantesText.setText(mazo.cartasRestantes() + "/52");
//    }

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
            cartasEnPantalla.add(carta.puntaje() + "_" + carta.getPalo());
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

    public GridPane getRoot() {
        return root;
    }
}