package edu.fiuba.algo3.modelo.juego;

import edu.fiuba.algo3.modelo.lector.LectorJson;
import org.junit.jupiter.api.Test;

public class JuegoTest {
    @Test
    public void juegoTest(){
        LectorJson lectorJson = new LectorJson("src/main/java/edu/fiuba/algo3/resources/archivosJson/balatro.json");
        lectorJson.ejemploComoSeGuarda();
        assert true;
    }
}
