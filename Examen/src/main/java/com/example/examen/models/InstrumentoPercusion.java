package com.example.examen.models;

public class InstrumentoPercusion extends TipoInstrumento {
    private String material;

    public InstrumentoPercusion(String tipo, String marca, String precio, String serie, String material) {
        super(tipo, marca, precio, serie);
        this.material = material;
    }
    @Override
    public String toString() {
        return tipo + " " + marca + " " + precio + " " + serie + " " + material;
    }
}