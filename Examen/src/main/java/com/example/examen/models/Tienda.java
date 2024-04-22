package com.example.examen.models;

import java.util.ArrayList;

public class Tienda {
    private ArrayList<TipoInstrumento> inventario;

    public Tienda(ArrayList<TipoInstrumento> inventario) {
        this.inventario = inventario;
    }

    public ArrayList<TipoInstrumento> getInventario() {
        return inventario;
    }
}
