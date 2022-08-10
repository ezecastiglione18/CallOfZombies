package ControlDelJuego;

import Jugadores.Equipo;
import Jugadores.Jugador;

import java.util.ArrayList;

public class Partida {
    private static Partida instancia = null;
    private Equipo equipo;
    private int numeroDeRonda = 0;
    private int cantidadDeJugadoresVivos = 4;
    private int cantidadDezombiesVivos = 0;

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

    public void unJugadorMenos() {
        this.cantidadDeJugadoresVivos--;
        if(cantidadDeJugadoresVivos == 0) {
            this.finalizarPartida();
        }
    }

    public void unZombieMenos() {
        this.cantidadDezombiesVivos--;
        if(cantidadDezombiesVivos == 0) {
            this.finalizarRonda();
        }
    }

    private void iniciarRonda() {
        this.equipo.malhumor();
        this.equipo.revitalizar();
    }

    private void finalizarRonda() {

    }

    private void crearZombies() {
        // TODO
    }

    private void crearObjetos() {
        // TODO
    }
}