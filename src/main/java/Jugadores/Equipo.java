package Jugadores;

import ControlDelJuego.Partida;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
public class Equipo {
    @Id @GeneratedValue
    int id_equipo;

    private String nombre;
    private String correo;

    @Transient
    public ArrayList<Jugador> jugadores = new ArrayList();
    public int puntos = 0;

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
            jugador.sumarPuntos(premio);
        }
    }

    public void sumarPuntos(int cantidad){
        this.puntos += cantidad;
    }

    public void eliminarJugador(Jugador jugador){
        this.jugadores.remove(jugador);
    }

    public void recalcularPuntos(){
        for(Jugador jugador : this.jugadores){
            this.puntos += jugador.puntos();
        }
    }

    public void unJugadorMenos(Jugador jugador) {
        this.jugadores.remove(jugador);
    }

    public Integer puntos() {
        return puntos;
    }

    public ArrayList<Jugador> getJugadores(){
        return this.jugadores;
    }
}
