package edu.fiuba.algo3.modelo.carta;

public class Carta {
    private String nombre;
    private Valor valor;
    private Palo palo;

    /*
    public Carta(String valor, String consecutivo, String palo) {
        this.valor = new Valor(valor, consecutivo);
        this.palo = new Palo(palo);
    }
    */
    public Carta(String nombre, String palo, String numero, String consecutivo, int puntos){
        this.nombre = nombre;
        this.valor = new Valor(numero, consecutivo, puntos);
        this.palo = new Palo(palo);
    }

    //Getters y Setters

    public String getNombre() {return this.nombre; }

    public String numero() { return this.valor.getNumero(); }

    public String getPalo() { return this.palo.getPalo(); }

    public int puntaje() { return this.valor.getPuntaje(); }

    ///////////////////////////////

    public boolean esConsecutiva(Carta otraCarta) { return valor.sonConsecutivos(otraCarta.numero()); }

    public boolean esIgual(String nombreCarta){ return this.nombre.equals(nombreCarta); };

    public boolean tieneMismoPalo(Carta otraCarta){ return this.palo.sonIgules(otraCarta); };

    public boolean tieneMismoNumero(Carta otraCarta){ return this.valor.sonIguales(otraCarta); };

    public void multiplicarValor(int multiplicador) { this.valor.multiplicarPuntaje(multiplicador);}

    public void modificarPorTarot(int puntosAgregar, int multiplicador){
        this.valor.sumarPuntaje(puntosAgregar);
        this.valor.multiplicarPuntaje(puntosAgregar);
    }
}
