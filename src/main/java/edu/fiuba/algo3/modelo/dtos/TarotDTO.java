package edu.fiuba.algo3.modelo.dtos;

public class TarotDTO {
    private String nombre;
    private String descripcion;
    private EfectoDTO efecto;
    private String sobre;
    private String ejemplar;

    public String getNombre() { return nombre; }

    public String getDescripcion() { return descripcion; }

    public EfectoDTO getEfecto() { return efecto; }

    public String getSobre() { return sobre; }

    public String getEjemplar() { return ejemplar; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public void setEfecto(EfectoDTO efecto) { this.efecto = efecto; }

}
