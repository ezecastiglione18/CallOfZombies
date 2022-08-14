package PartidaTest;

import ControlDelJuego.Partida;
import ControlDelJuego.RepositorioPuntajes;
import Jugadores.Equipo;
import Jugadores.Jugador;
import javafx.util.Pair;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;

public class PartidaTest {
    Partida partida = Partida.GetInstance();

    @Test
    public void seGeneranZombiesCorrectamente(){
        partida.iniciarPartida("Killers", "killers@gmail.com");
        Equipo equipo = partida.equipo();
        Jugador jugador1 = equipo.jugador(0);
        Jugador jugador2 = equipo.jugador(1);
        Jugador jugador3 = equipo.jugador(2);
        Jugador jugador4 = equipo.jugador(3);

        Assertions.assertEquals(false, partida.zombies.isEmpty());
    }

    @Test
    //TODO ==> REVISAR PORQUE LA LISTA DE PUNTAJES ES NULL
    public void seGuardaBienElPuntajeDeEquipoDistintos(){
        partida.iniciarPartida("Killers", "killers@gmail.com");
        Equipo equipoKiller = partida.equipo();

        for(Jugador jugador : equipoKiller.getJugadores()){
            jugador.sumarPuntos(80);
        }

        Integer puntaje = equipoKiller.puntos();

        RepositorioPuntajes.GetInstance().agregarPartida(equipoKiller, puntaje);
        ///////////////////////////////////////////////////////////////////////////////////////////////////
        partida.iniciarPartida("Los mmortales", "");
        Equipo equipoMortal = partida.equipo();

        for(Jugador jugador : equipoMortal.getJugadores()){
            jugador.sumarPuntos(100);
        }

        Integer puntaje2 = equipoMortal.puntos();

        RepositorioPuntajes.GetInstance().agregarPartida(equipoMortal, puntaje2);
        ///////////////////////////////////////////////////////////////////////////////////////////////////

        ArrayList<Pair<Equipo, Integer>> equipos = RepositorioPuntajes.GetInstance().getPuntajes();

        Assertions.assertEquals(false, equipos.isEmpty());
    }
}
