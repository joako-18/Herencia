package com.example.examen.models;

public class InstrumentoViento extends TipoInstrumento{
    private String numAgujeros;

    public InstrumentoViento(String tipo, String marca, String precio, String serie, String numAgujeros) {
        super(tipo, marca, precio, serie);
        this.numAgujeros = numAgujeros;
    }

    @Override
    public String toString() {
        return tipo + " "+ marca + " " + precio + " " + serie + " " + numAgujeros + ".";
    }
}