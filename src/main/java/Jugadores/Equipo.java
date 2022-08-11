package Jugadores;

import ControlDelJuego.Partida;

import java.util.ArrayList;

public class Equipo {
    private static Equipo instancia = null;
    private String nombre;
    private String correo;
    private ArrayList<Jugador> jugadores = new ArrayList();
    private int puntos = 0;

    public static Equipo GetInstance(String nombre, String correo) {
        if (instancia == null) {
            instancia = new Equipo(nombre, correo);
        }
        return instancia;
    }

    private Equipo (String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.jugadores.add(new Jugador());
        this.jugadores.add(new Jugador());
        this.jugadores.add(new Jugador());
        this.jugadores.add(new Jugador());
    }

    public String nombre() {
        return nombre;
    }

    public Jugador jugador(int numeroDeJugador) {
        return jugadores.get(numeroDeJugador);
    }

    public void malhumor() {
        for (Jugador jugador : jugadores) {
            jugador.ponerDeMalHumor();
        }
    }

    public void revitalizar() {
        for (Jugador jugador : jugadores) {
            if (jugador.estaVivo()) {
                jugador.revitalizar(50);
            }
        }
    }

    public int cantidadDeJugadoresVivos() {
        return jugadores.size();
    }

    public void premiarSupervivencia(int premio) {
        for (Jugador jugador : jugadores) {
            if (jugador.estaVivo()) {
                jugador.sumarPuntos(premio);
            }
        }
    }

    public void unJugadorMenos(Jugador jugador) {
        this.puntos += jugador.puntos();
        jugadores.remove(jugador);
    }

    public Object puntos() {
        return puntos;
    }
}
