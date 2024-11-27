package edu.fiuba.algo3.modelo.lector;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.juego.Jugador;
import edu.fiuba.algo3.modelo.juego.Ronda;

import java.lang.reflect.Type;


public class RondaAdapter implements JsonDeserializer<Ronda> {
    @Override
    public Ronda deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();
        // Atributos de la ronda
        System.out.println("-----------------------------------");
        System.out.println("Ronda nro: " + obj.get("nro").getAsInt());
        int cantTurnos = obj.get("manos").getAsInt();
        System.out.println("Manos de este ronda: " + cantTurnos);
        int cantDeDescartes = obj.get("descartes").getAsInt();
        System.out.println("Cant de descartes: " + cantDeDescartes);
        int puntosASuperar = obj.get("puntajeASuperar").getAsInt();
        System.out.println("Puntos a superar: " + puntosASuperar);
        System.out.println("-----------------------------------");

        Jugador jugador = new Jugador("Pepe Chatruc");
        // Devolver la ronda
        return new Ronda(cantTurnos, cantDeDescartes, puntosASuperar, jugador);
    }
}
