package com.Domain;

public class Jugador {
    private String nombre;
    private int dinero;

    public Jugador(String nombre, int pote) {
        this.nombre = nombre;
        this.dinero = pote;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void sumaDinero(Jugador jugador, int pote)
    {
        int suma = 0;
        suma = jugador.getDinero() + pote;
        jugador.setDinero(suma);
    }
    public void restaDinero(Jugador jugador, int pote)
    {
        int resta = 0;
        resta = jugador.getDinero() - pote;
        jugador.setDinero(resta);
    }
    public int elegirDado()
    {
        int numero = (int) (Math.random()*5)+1;
        return numero;
    }
}
