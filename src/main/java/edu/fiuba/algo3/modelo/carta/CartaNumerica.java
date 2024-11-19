package edu.fiuba.algo3.modelo.carta;
import edu.fiuba.algo3.modelo.ValorInvalidoException;
import edu.fiuba.algo3.modelo.PaloInvalidoException;

public class CartaNumerica extends Carta{

    private static final String[] VALORES_VALIDOS = {"2", "3", "4", "5", "6", "7", "8", "9", "10"};
    private static final String[] PALOS_VALIDOS = {"Picas", "Corazones", "Diamantes", "Treboles"};

    public CartaNumerica(String valor, String palo) {

        if (!esValorValido(valor)) {
            throw new ValorInvalidoException(); //excepción si el valor es inválido
        }

        if (!esPaloValido(palo)) {
            throw new PaloInvalidoException(); //excepción si el palo es inválido
        }

        this.setValor(valor);
        this.setPalo(palo);
        this.setPuntaje(Integer.parseInt(valor));
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