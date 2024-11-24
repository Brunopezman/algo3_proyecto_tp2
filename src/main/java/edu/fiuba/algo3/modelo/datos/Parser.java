package edu.fiuba.algo3.modelo.datos;
import com.google.gson.*;
import com.google.gson.reflect.TypeToken;
import edu.fiuba.algo3.modelo.carta.Carta;
import edu.fiuba.algo3.modelo.juego.Juego;
import edu.fiuba.algo3.modelo.juego.Ronda;

import java.io.FileReader;
import java.util.List;
import java.util.Map;

public class Parser {
    public Parser(){}

    public void cargarInformacion(Juego juego, JsonObject informacion){
        Gson gson = new GsonBuilder()
                .registerTypeAdapter(Carta.class, new CartaAdapter()) // Registrar adaptador
                .create();
        for (Map.Entry<String, JsonElement> entry : informacion.entrySet()) {
            String nombreSeccion = entry.getKey();
            JsonElement contenidoSeccion = entry.getValue();
            if (nombreSeccion.equals("rondas")) {
                List<Ronda> rondas = new Gson().fromJson(contenidoSeccion, new TypeToken<List<Ronda>>(){}.getType());
                juego.setRondas(rondas);
                System.out.println("Cargadas " + rondas.size() + " rondas.");
            }else if(nombreSeccion.equals("mazo")){
                List<Carta> mazo = gson.fromJson(contenidoSeccion, new TypeToken<List<Carta>>(){}.getType());
                juego.setMazo(mazo);
                System.out.println("Cargadas " + mazo.size() + " cartas en el mazo.");
            }else {return;}
        }
    }
}
