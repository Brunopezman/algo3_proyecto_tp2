package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import javafx.geometry.Insets;
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
import javafx.scene.media.AudioClip;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ParteDerecha {
    private final BorderPane parteDerecha;
    private final Juego juego;
    private final List<Carta> cartasSeleccionadas;
    private final ParteIzquierda parteIzquierda;
    private HBox visualCartas;
    private Text cartasRestantesText;
    private PantallaJuego pantallaJuego;

    public ParteDerecha(Juego juego, ParteIzquierda parteIzquierda) {
        this.juego = juego;
        this.parteIzquierda = parteIzquierda;
        this.parteDerecha = new BorderPane();
        this.cartasSeleccionadas = new ArrayList<>();
        inicializarUI();
    }

    private void inicializarUI() {
        StackPane centro = new StackPane();

        // Cartas del jugador: inicialmente vacío, pero se llenará automáticamente
        visualCartas = new HBox();
        visualCartas.setSpacing(5);
        visualCartas.setAlignment(Pos.CENTER);

        // Llama a repartirCartas para inicializar las cartas desde el comienzo
        repartirCartas();

        centro.getChildren().add(visualCartas);
        parteDerecha.setCenter(centro);

        // Comodines y Tarots
        HBox comodinesTarots = crearComodinesTarots();
        parteDerecha.setTop(comodinesTarots);

        // Botones y Mazo
        HBox contenidoInferior = crearContenidoInferior();
        parteDerecha.setBottom(contenidoInferior);

        parteDerecha.setPadding(new Insets(10));
    }


    private HBox crearComodinesTarots() {
        HBox comodinesTarots = new HBox();
        comodinesTarots.setSpacing(20);
        comodinesTarots.setAlignment(Pos.CENTER);

        // Comodines
        Rectangle comodines = new Rectangle(200, 80);
        comodines.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        int cantidadComodines = juego.comodinesRonda();
        Text cantidadComodinesText = new Text(cantidadComodines + "/5");
        cantidadComodinesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #efe7e7;");
        VBox comodinesBox = new VBox(comodines, cantidadComodinesText);

        // Tarots
        Rectangle tarots = new Rectangle(120, 80);
        tarots.setStyle("-fx-fill: #ffffff; -fx-stroke: black; -fx-stroke-width: 1;");
        int cantidadTarots = 0;
        Text cantidadTarotsText = new Text(cantidadTarots + "/2");
        cantidadTarotsText.setStyle("-fx-font-size: 0.8em; -fx-fill: #ffffff;");
        VBox tarotsBox = new VBox(tarots, cantidadTarotsText);

        comodinesTarots.getChildren().addAll(comodinesBox, tarotsBox);
        return comodinesTarots;
    }

    private HBox crearContenidoInferior() {
        HBox contenidoInferior = new HBox();
        HBox botones = new HBox();
        botones.setSpacing(20);
        botones.setAlignment(Pos.CENTER);

        Button botonJugarMano = new Button("Jugar Mano");
        Button botonDescartar = new Button("Descartar");

        botonJugarMano.setStyle("-fx-font-size: 20px;-fx-background-color: \"#333333\"; -fx-font-weight: bold; -fx-text-fill: white;");
        botonDescartar.setStyle("-fx-font-size: 20px; -fx-background-color: \"#333333\"; -fx-font-weight: bold; -fx-text-fill: white;");

        // Configurar el evento para el botón "Jugar Mano"
        botonJugarMano.setOnAction(event -> {
            if (!cartasSeleccionadas.isEmpty()) {

                // Actualizar el puntaje de la ronda en la vista
//                parteIzquierda.actualizarPuntajeRonda(juego.jugarMano(cartasSeleccionadas,juego.queManoEs(cartasSeleccionadas)));

            } else {
                System.out.println("No has seleccionado ninguna carta.");
            }
        });

        botones.getChildren().addAll(botonJugarMano, botonDescartar);

        // Mazo
        String rutaImagen = "src/main/java/edu/fiuba/algo3/resources/cartas/reverso.jpg";
        Image imagen = new Image(Paths.get(rutaImagen).toUri().toString());
        ImageView imageView = new ImageView(imagen);
        imageView.setFitWidth(100);
        imageView.setFitHeight(150);

        cartasRestantesText = new Text(juego.getMazo().cartasRestantes() + "/52");
        cartasRestantesText.setFont(Font.font("Arial", 16));
        cartasRestantesText.setStyle("-fx-font-size: 0.8em; -fx-fill: #ffffff;");

        VBox imagenYTexto = new VBox(10, imageView, cartasRestantesText);
        imagenYTexto.setAlignment(Pos.CENTER_RIGHT);

        HBox botonesYMazo = new HBox(80, botones, imagenYTexto);
        contenidoInferior.getChildren().add(botonesYMazo);

        return contenidoInferior;
    }

    private void repartirCartas() {
        actualizarVisualCartas();

        if (juego.descartesActuales() == 0) {
            System.out.println("Ya tienes 8 cartas en pantalla, no puedes repartir más.");
            return;
        }

        juego.repartirCartasJugador();

        cartasRestantesText.setText(juego.getMazo().cartasRestantes() + "/52");
    }

    private void actualizarVisualCartas() {
        // Limpiar la visualización actual
        visualCartas.getChildren().clear();

        // Cargar el sonido para reproducir al hacer clic en las cartas
        String rutaSonido = "src/main/java/edu/fiuba/algo3/resources/sonidos/click.mp3"; // Cambia "click2.mp3" por tu archivo de sonido
        AudioClip sonido = new AudioClip(Paths.get(rutaSonido).toUri().toString());

        // Agregar las cartas nuevas
        for (Carta carta : juego.repartirCartasJugador()) {
            ImageView imagenCarta = new ImageView(new Image(Paths.get("src/main/java/edu/fiuba/algo3/resources/cartas/" + carta.numero() + "_" + carta.getPalo() + ".jpg").toUri().toString()));
            imagenCarta.setFitWidth(56);
            imagenCarta.setFitHeight(84);

            imagenCarta.setOnMouseClicked(event -> {
                if (cartasSeleccionadas.contains(carta)) {
                    // Si la carta ya está seleccionada, la deseleccionamos
                    cartasSeleccionadas.remove(carta);
                    imagenCarta.setStyle("-fx-effect: null;");
                } else if (cartasSeleccionadas.size() < 5) {
                    // Si la carta no está seleccionada y se puede seleccionar más, la agregamos
                    cartasSeleccionadas.add(carta);
                    imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
                    sonido.play(); // Reproduce el sonido solo si la carta se selecciona efectivamente
                } else {
                    // Si ya se han seleccionado 5 cartas, no se puede seleccionar más
                    System.out.println("No puedes seleccionar más de 5 cartas.");
                }
            });

            //sin sonido
//            imagenCarta.setOnMouseClicked(event -> {
//                if (cartasSeleccionadas.contains(carta)) {
//                    cartasSeleccionadas.remove(carta);
//                    imagenCarta.setStyle("-fx-effect: null;");
//                } else if (cartasSeleccionadas.size() < 5) {
//                    cartasSeleccionadas.add(carta);
//                    imagenCarta.setStyle("-fx-effect: dropshadow(gaussian, blue, 10, 0.5, 0, 0);");
//                } else {
//                    System.out.println("No puedes seleccionar más de 5 cartas.");
//                }
//            });

            visualCartas.getChildren().add(imagenCarta);
        }
    }

    public BorderPane crearParteDerecha() {
        return parteDerecha;
    }
}
