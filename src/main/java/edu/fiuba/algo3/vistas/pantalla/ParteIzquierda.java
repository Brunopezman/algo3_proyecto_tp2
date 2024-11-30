package edu.fiuba.algo3.vistas.pantalla;

import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Ronda;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public class ParteIzquierda {

    private final VBox parteIzquierda;

    public ParteIzquierda(Ronda ronda, Jugador jugador) {
        this.parteIzquierda = new VBox();
        parteIzquierda.setAlignment(Pos.CENTER_LEFT);
        parteIzquierda.setSpacing(15);

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
        StackPane nombre = crearCuadrado(jugador.getNombre(), 50, 150, "lightgray");
        parteIzquierda.getChildren().addAll(
                puntajeNecesario,
                puntajeAcumulado,
                marcador,
                turnosDescartes,
                rondaActual,
                nombre
        );

        parteIzquierda.setPadding(new Insets(20, 10, 20, 20));
    }
    public VBox crearParteIzquierda() {
        return parteIzquierda;
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
}
