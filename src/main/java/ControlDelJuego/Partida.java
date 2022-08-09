package ControlDelJuego;

import Jugadores.Equipo;

import java.util.ArrayList;

public class Partida {
    private static Partida instancia = null;
    private Equipo equipo;

    public static Partida GetInstance() {
        if (instancia == null) {
            instancia = new Partida();
        }
        return instancia;
    }

    public void inicializarPartida() {
        // TODO
    }

    public void finalizarPartida() {
        // TODO
    }
}