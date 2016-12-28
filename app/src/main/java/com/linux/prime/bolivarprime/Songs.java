package com.linux.prime.bolivarprime;

import java.io.Serializable;

/**
 * Created by prime on 26-12-16.
 */

public class Songs implements Serializable {
    private String Titulo;
    private String Letra;
    private String LLetra;

    public Songs(String titulo, String letra, String LLetra) {
        Titulo = titulo;
        Letra = letra;
        this.LLetra = LLetra;
    }

    public String getTitulo() {
        return Titulo;
    }

    public void setTitulo(String titulo) {
        Titulo = titulo;
    }

    public String getLetra() {
        return Letra;
    }

    public void setLetra(String letra) {
        Letra = letra;
    }

    public String getLLetra() {
        return LLetra;
    }

    public void setLLetra(String LLetra) {
        this.LLetra = LLetra;
    }
}