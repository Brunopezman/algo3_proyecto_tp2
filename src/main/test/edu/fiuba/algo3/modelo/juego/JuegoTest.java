package edu.fiuba.algo3.modelo.juego;

import com.google.gson.JsonObject;
import edu.fiuba.algo3.modelo.datos.LectorJson;
import edu.fiuba.algo3.modelo.datos.Parser;
import org.junit.jupiter.api.Test;

import java.util.List;

public class JuegoTest {
    @Test
    public void juegoTest(){
        Juego juego = new Juego();
        LectorJson lectorJson = new LectorJson();
        Parser parser = new Parser();
        JsonObject infomacion = lectorJson.obtenerInformacion("src/main/java/edu/fiuba/algo3/resources/balatro.json");
        parser.cargarInformacion(juego, infomacion);
        assert true;
    }
}
