package Zombies;

import ControlDelJuego.Partida;
import Jugadores.Jugador;

public class Zombie {
    private int salud;

    public void salud(int salud) {
        this.salud = salud;
    }

    public void atacarA(Jugador jugador) {
        jugador.recibirDanio(20);
    }

    public void recibirDanio(int danio, Jugador jugador) {
        this.salud -= danio;
        if(this.salud <= 0) {
            this.morir();
            jugador.matoUnZombie();
        }
    }

    private void morir() {
        Partida.GetInstance().unZombieMenos(this);
    }
}
