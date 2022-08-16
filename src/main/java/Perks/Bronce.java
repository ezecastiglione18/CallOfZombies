package Perks;

import ControlDelJuego.Partida;
import Jugadores.Jugador;

public class Bronce extends Perk {
    private static Bronce instancia = null;
    private int costo = 700;

    public static Bronce GetInstance() {
        if (instancia == null) {
            instancia = new Bronce();
        }
        return instancia;
    }

    @Override
    public int costo() {
        return this.costo;
    }

    public void sumarPuntosPorMatar(Jugador jugador) {
        jugador.sumarPuntos(5);
    }
}