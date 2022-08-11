package ControlDelJuego;

import Jugadores.Equipo;
import Jugadores.Jugador;
import MailAPI.MailApi;
import Objetos.Objeto;
import Zombies.Zombie;
import Zombies.ZombieComunFactory;
import Zombies.ZombieEspecialFactory;

import java.util.ArrayList;

public class Partida {
    private static Partida instancia = null;
    private double ratioZombies = 1.0; // TODO
    private double ratioObjetos = 1.0;
    private Equipo equipo;
    private int numeroDeRonda = 0;
    private ArrayList<Zombie> zombies = new ArrayList<Zombie>();
    private ArrayList<Objeto> objetos = new ArrayList<Objeto>();

    private Partida() {};

    public static Partida GetInstance() {
        if (instancia == null) {
            instancia = new Partida();
        }
        return instancia;
    }

    public Equipo equipo() {
        return equipo;
    }

    public void iniciarPartida(String nombreEquipo, String correoEquipo) {
        this.equipo = Equipo.GetInstance(nombreEquipo, correoEquipo);
        this.iniciarRonda();
    }

    public void finalizarPartida() {
        MailApi.notificar(this.equipo);
        equipo = null;
    }

    private void iniciarRonda() {
        this.numeroDeRonda++;
        crearZombies();
        crearObjetos();
        this.equipo.malhumor();
        this.equipo.revitalizar();
    }

    private void crearZombies() {
        if (this.esRondaPar()) {
            // crea zombies
            for ( int i = 0; i < ratioZombies * numeroDeRonda; i++) {
                zombies.add(ZombieEspecialFactory.crearZombie());
            }
        } else {
            // crea zombies
            for ( int i = 0; i < ratioZombies * numeroDeRonda; i++) {
                zombies.add(ZombieComunFactory.crearZombie());
            }
        }
        // crea objetos
        for ( int i = 0; i < ratioObjetos * numeroDeRonda; i++) {
            // TODO
        }
    }

    private boolean esRondaPar() {
        return numeroDeRonda % 2 == 0;
    }

    private void finalizarRonda() {
        int premio = 10 * numeroDeRonda;
        this.equipo.premiarSupervivencia(premio);
        this.iniciarRonda();
    }

    public void unJugadorMenos(Jugador jugador) {
        equipo.unJugadorMenos(jugador);
        if(equipo.cantidadDeJugadoresVivos() == 0) {
            this.finalizarPartida();
        }
    }

    public void unZombieMenos(Zombie zombie) {
        zombies.remove(zombie);
        if(zombies.size() == 0) {
            this.finalizarRonda();
        }
    }


    private void crearObjetos() {
        // TODO
    }
}