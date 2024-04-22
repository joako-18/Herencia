package com.example.examen.models;

public class TipoInstrumento {
    protected String tipo;
    protected String marca;
    protected String precio;
    protected String serie;

    public TipoInstrumento(String tipo, String marca, String precio, String serie) {
        this.tipo = tipo;
        this.marca = marca;
        this.precio = precio;
        this.serie = serie;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMarca() {
        return marca;
    }

    public String getPrecio() {
        return precio;
    }

    public String getSerie() {
        return serie;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public void setSerie(String serie) {
        this.serie = serie;
    }
}