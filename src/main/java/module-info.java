module edu.fiuba.algo3 {
    requires javafx.controls;
    requires json.simple;
    requires java.desktop;
    requires com.google.gson;
    opens edu.fiuba.algo3.modelo.juego to com.google.gson;
    opens edu.fiuba.algo3.modelo.mano to com.google.gson;
    opens edu.fiuba.algo3.modelo.comodin to com.google.gson;
    opens edu.fiuba.algo3.modelo.datos to com.google.gson;
    opens edu.fiuba.algo3.modelo.carta to com.google.gson;
    opens edu.fiuba.algo3.modelo.tarot to com.google.gson;

    exports edu.fiuba.algo3;
    exports edu.fiuba.algo3.vistas;

//    requires javafx.media;
    exports edu.fiuba.algo3.modelo.interfaz;
}