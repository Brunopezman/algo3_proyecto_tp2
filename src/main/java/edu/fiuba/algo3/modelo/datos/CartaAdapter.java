package edu.fiuba.algo3.modelo.datos;

import com.google.gson.*;
import edu.fiuba.algo3.modelo.carta.Carta;

import java.lang.reflect.Type;

class CartaAdapter implements JsonDeserializer<Carta> {
    @Override
    public Carta deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        JsonObject obj = json.getAsJsonObject();

        // Leer atributos del JSON
        String valor = obj.get("numero").getAsString(); // Valor actual
        String palo = obj.get("palo").getAsString();

        // Calcular el consecutivo
        String consecutivo = calcularConsecutivo(valor);

        System.out.println("Cargo el numero: " + valor);
        // Crear una instancia de Carta con los valores calculados
        return new Carta(valor, consecutivo, palo);
    }

    // Método para calcular el valor consecutivo
    private String calcularConsecutivo(String valor) {
        switch (valor.toUpperCase()) {
            case "AS": return "2";
            case "2": return "3";
            case "3": return "4";
            case "4": return "5";
            case "5" : return "6";
            case "6": return "7";
            case "7": return "8";
            case "8": return "9";
            case "9": return "10";
            case "10": return"Jota";
            case "JOTA": return "Reina";
            case "REINA": return "Rey";
            case "REY": return "As"; // No hay consecutivo para el Rey
            default: throw new IllegalArgumentException("Valor no válido: " + valor);
        }
    }
}