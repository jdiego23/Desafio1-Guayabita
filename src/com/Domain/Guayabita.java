package com.Domain;

import java.util.ArrayList;

public class Guayabita {
    private String nombre;
    private int poteInicial;
    private int nroJugadores;
    private java.util.ArrayList<Jugador>  jugadores,jugadores2;

    public Guayabita(String nombre) {
        this.nombre = nombre;
        jugadores = new ArrayList<>();
        jugadores2= new ArrayList<>();
    }

    public ArrayList<Jugador> getJugadores() {
        return jugadores;
    }

    public ArrayList<Jugador> getJugadores2() {
        return jugadores2;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPoteInicial() {
        return poteInicial;
    }

    public void setPoteInicial(int poteInicial) {
        this.poteInicial = poteInicial;
    }

    public int getNroJugadores() {
        return nroJugadores;
    }

    public void setNroJugadores(int nroJugadores) {
        this.nroJugadores = nroJugadores;
    }

    public void incrementoPote(int pote)
    {
         int incremento = 0;
         incremento = getPoteInicial() + pote;
         setPoteInicial(incremento);
    }
    public void decrementoPote(int pote)
    {
        int decremento = 0;
        decremento = getPoteInicial() - pote;
        setPoteInicial(decremento);
    }

}
