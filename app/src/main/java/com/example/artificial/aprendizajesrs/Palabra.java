package com.example.artificial.aprendizajesrs;

/**
 * Created by alex on 11/11/16.
 */

public class Palabra {
    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }

    String palabra;

    public int getEquivocadas() {
        return equivocadas;
    }

    public void setEquivocadas(int equivocadas) {
        this.equivocadas = equivocadas;
    }

    int equivocadas;

    public int getCorrectas() {
        return correctas;
    }

    public void setCorrectas(int correctas) {
        this.correctas = correctas;
    }

    int correctas;

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }

    int categoria;

}
