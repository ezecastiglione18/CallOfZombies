package PartidaTest;

import ControlDelJuego.Partida;
import Jugadores.Equipo;
import Jugadores.Jugador;
import org.junit.Test;

public class PartidaTest {
    Partida partida = Partida.GetInstance();

    @Test
    public void iniciarPartida() {
        partida.iniciarPartida("Killers", "killers@gmail.com");
        Equipo equipo = partida.equipo();
        Jugador jugador1 = equipo.jugador(0);
        Jugador jugador2 = equipo.jugador(0);
        Jugador jugador3 = equipo.jugador(0);
        Jugador jugador4 = equipo.jugador(0);
    }
}
