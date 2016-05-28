package com.example.daniel.ejm_reqlo.componentes;
/**
 * Created by Daniel on 01-05-2016.
 */
public class Porcentaje {
    public Porcentaje() {}
    public int result(int num, double porcentaje) {
        return (int) Math.round(((porcentaje * num) / 100.0));
    }
}

