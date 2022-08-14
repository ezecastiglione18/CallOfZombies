package Jugadores;

import ControlDelJuego.Partida;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Equipo {
    @Id @GeneratedValue
    int id_equipo;

    //@Transient
    //private static Equipo instancia = null;
    private String nombre;
    private String correo;

    //@OneToMany
    private ArrayList<Jugador> jugadores = new ArrayList();
    private int puntos = 0;

    /*public static Equipo GetInstance(String nombre, String correo) {
        if (instancia == null) {
            instancia = new Equipo(nombre, correo);
        }
        return instancia;
    }*/

    public Equipo (String nombre, String correo) {
        this.nombre = nombre;
        this.correo = correo;
        this.jugadores.add(new Jugador());
        this.jugadores.add(new Jugador());
        this.jugadores.add(new Jugador());
        this.jugadores.add(new Jugador());

        for(Jugador jugador : this.jugadores){
            jugador.setEquipo(this);
        }
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

    public void recalcularPuntos(){
        for(Jugador jugador : this.jugadores){
            this.puntos += jugador.puntos();
        }
    }

    public void unJugadorMenos(Jugador jugador) {
        this.puntos += jugador.puntos();
        jugadores.remove(jugador);
    }

    public Integer puntos() {
        return puntos;
    }
}
