package com.example.examen.models;

public class InstrumentoCuerda extends TipoInstrumento {
    private String numCerdas;

    public InstrumentoCuerda(String tipo, String marca, String precio, String serie, String numCuerdas) {
        super(tipo, marca, precio, serie);
        this.numCerdas = numCuerdas;
    }

    @Override
    public String toString() {
        return tipo + " " + marca + " " + precio + " " + serie + " " + numCerdas + ".";
    }
}