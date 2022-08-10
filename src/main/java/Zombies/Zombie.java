package Zombies;

import ControlDelJuego.Partida;
import Jugadores.Jugador;

abstract public class Zombie {
    private int salud;

    public void atacarA(Jugador jugador) {
        jugador.recibirDanio(20);
    }

    private void morir() {
        Partida.GetInstance().unZombieMenos();
    }

    public void recibirDanio(int danio, Jugador jugador) {
        this.salud -= danio;
        if(this.salud <= 0) {
            this.morir();
            jugador.killRealizada();
        }
    }
}
