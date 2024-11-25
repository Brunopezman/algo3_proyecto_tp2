//package edu.fiuba.algo3.controllers;
//
//import com.google.gson.*;
//import edu.fiuba.algo3.modelo.carta.Carta;
//import edu.fiuba.algo3.modelo.datos.CartaAdapter;
//
//import java.io.FileReader;
//import java.util.ArrayList;
//import java.util.List;
//
//public class LeerMazo {
//    public static void main(String[] args) {
//        // Configurar GSON con el adaptador personalizado
//        Gson gson = new GsonBuilder()
//                .registerTypeAdapter(Carta.class, new CartaAdapter()) // Registrar adaptador
//                .create();
//
//        try (FileReader reader = new FileReader("src/main/java/edu/fiuba/algo3/resources/mazo.json")) {
//            // Leer el JSON y convertirlo a un objeto JsonObject
//            JsonObject jsonObject = gson.fromJson(reader, JsonObject.class);
//
//            // Obtener el array "mazo" del JSON
//            JsonArray cartasArray = jsonObject.getAsJsonArray("mazo");
//
//            // Convertir el JsonArray a una lista de CartaAux
//            List<Carta> cartas = new ArrayList<>();
//            for (JsonElement element : cartasArray) {
//                Carta carta = gson.fromJson(element, Carta.class);
//                cartas.add(carta);
//            }
//
//            //Racing Campeon
//
//            // Crear el mazo con la lista de cartas
//            // Mazo mazoAux = new Mazo(cartas);
//
//            // Imprimir las cartas
//            for (Carta cartaAux : cartas) {
//                System.out.println("Numero: " + cartaAux.numero());
//                System.out.println("Palo: " + cartaAux.getPalo());
//                System.out.println("Puntaje: " + cartaAux.puntaje());
//                System.out.println("-----------------------------------------");
//            }
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}