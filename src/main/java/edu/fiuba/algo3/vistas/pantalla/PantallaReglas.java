package edu.fiuba.algo3.vistas.pantalla;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class PantallaReglas {
    private final Stage stage;

    public PantallaReglas(Stage owner) {
        this.stage = new Stage();
        stage.initOwner(owner); // Configurar como hijo del `Stage` principal
        stage.initModality(Modality.APPLICATION_MODAL); // Modalidad bloqueante
        stage.setTitle("Reglas del Juego");

        // Contenido de las reglas
        Text textoReglas = new Text("¿Qué es el Balatro?\n" +
                "La aplicación consiste en un juego por turnos, “roguelike”, de un solo jugador que busca ir perfeccionando un mazo de cartas, sumando puntos por manos jugadas.\n" +
                "El juego está dividido en hasta N rondas donde en cada ronda al jugador se le reparte una mano al azar de su mazo y este debe conformar manos de poker para sumar puntos.\n" +
                "Cada ronda posee un puntaje mínimo que el jugador debe anotar para poder seguir jugando. Tiene hasta cinco turnos para alcanzar la puntuación y en cada uno de ellos puede o jugar una mano o descartar cartas.\n" +
                "Existen varios tipos de cartas, que cambian su forma de calcular el puntaje o poseen efectos especiales.\n" +
                "También existen cartas que están por fuera del mazo, entre ellos los comodines que tienen efectos especiales sobre la forma de calcular el puntaje y pueden combinarse unos con otros; y las cartas de tarot que pueden modificar a las cartas del mazo. \n" +
                "El objetivo del juego es crear un mazo que permita sobrevivir la mayor cantidad de rondas siendo esta la puntuación final.\n" +
                "\n" +
                "Reglas\n" +
                "El Balatro va a seguir aproximadamente las reglas del poker con baraja inglesa. Con las cartas se pueden realizar las siguientes manos, con valor de mayor a menor:\n" +
                "-\tEscalera Real: A, K, Q, J, 10 (todas del mismo palo)\n" +
                "-\tEscalera de Color: combinación de cinco cartas consecutivas del mismo palo. Por ejemplo: 9, 8, 7, 6, 5.\n" +
                "-\tPoker: combinación de cuatro cartas del mismo valor y una carta cualquiera. Por ejemplo: A, A, A, A, 8.\n" +
                "-\tFull house: combinación de tres cartas del mismo valor más una pareja distinta. Por ejemplo: Q, Q, Q, 4, 4.\n" +
                "-\tColor: cualquier combinación de 5 cartas del mismo palo.\n" +
                "-\tEscalera: combinación de cinco cartas consecutivas, no necesariamente del mismo palo.\n" +
                "-\tTrio: combinación de tres cartas del mismo valor y otras dos cartas distintas al trío y distintas entre sí.\n" +
                "-\tDoble Par: combinación de dos pares diferentes.\n" +
                "-\tPar: combinación de un par del mismo palo.\n" +
                "-\tCarta Alta: las cinco cartas no interactúan entre sí.");
        textoReglas.setStyle("-fx-font-size: 14px;");
        // TextFlow para mostrar texto con desplazamiento
        TextFlow contenedorTexto = new TextFlow(textoReglas);
        contenedorTexto.setMaxWidth(600);
        contenedorTexto.setStyle("-fx-padding: 20px;");

        // Botón para cerrar la ventana
        Button botonCerrar = new Button("Cerrar");
        botonCerrar.setFont(Font.font("Arial",10));
        botonCerrar.setStyle("-fx-font-size: 20px;");
        botonCerrar.setOnAction(event -> stage.close());

        // Diseño vertical
        VBox layout = new VBox(20, contenedorTexto, botonCerrar);
        layout.setAlignment(Pos.CENTER);
        layout.setStyle("-fx-background-color: lightblue; -fx-padding: 20px;");
        VBox.setVgrow(contenedorTexto, Priority.ALWAYS);

        // ScrollPane para manejar texto largo
        ScrollPane scrollPane = new ScrollPane(layout);
        scrollPane.setFitToWidth(true);

        // Configurar y mostrar la escena
        Scene scene = new Scene(new StackPane(scrollPane), 800, 600);
        stage.setScene(scene);
    }

    public void mostrar() {
        stage.showAndWait();
    }

    private Font cargarFuente(String rutaFuente, int tamanio) {
        try {
            return Font.loadFont(new FileInputStream(rutaFuente), tamanio);
        } catch (FileNotFoundException e) {
            System.err.println("Fuente no encontrada: " + rutaFuente);
            return Font.font("Arial", tamanio);
        }
    }
}
