package edu.fiuba.algo3.modelo.carta;
import edu.fiuba.algo3.modelo.ValorInvalidoException;
import edu.fiuba.algo3.modelo.PaloInvalidoException;

public class CartaNoNumerica extends Carta {

    private static final String[] VALORES_VALIDOS = {"A", "J", "Q", "K"};
    private static final String[] PALOS_VALIDOS = {"Picas", "Corazones", "Diamantes", "Treboles"};

    public static int PUNTAJE_INICIAL = 10;

    public CartaNoNumerica(String valor, String palo) {

        if (!esValorValido(valor)) {
            throw new ValorInvalidoException(); //excepción si el valor es inválido
        }

        if (!esPaloValido(palo)) {
            throw new PaloInvalidoException(); //excepción si el palo es inválido
        }

        this.setValor(valor);
        this.setPalo(palo);
        this.setPuntaje(PUNTAJE_INICIAL);
    }

    private boolean esValorValido(String valor) {
        for (String valorValido : VALORES_VALIDOS) {
            if (valor.equals(valorValido)) {
                return true;
            }
        }
        return false;
    }

    private boolean esPaloValido(String palo) {
        for (String paloValido : PALOS_VALIDOS) {
            if (palo.equals(paloValido)) {
                return true;
            }
        }
        return false;
    }
}