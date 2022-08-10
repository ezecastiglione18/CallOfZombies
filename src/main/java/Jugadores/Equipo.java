package Jugadores;

import java.util.ArrayList;

public class Equipo {
    ArrayList<Jugador> jugadores = new ArrayList<>();

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
}
