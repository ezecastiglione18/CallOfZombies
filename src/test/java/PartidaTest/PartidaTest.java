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
        //Equipo equipo = partida.equipo();

        Assertions.assertEquals(false, partida.zombies.isEmpty());
    }

    @Test
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

    @Test
    public void seOrdenanLosElementosDeLaLista(){
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
        partida.iniciarPartida("Los maquinas", "");
        Equipo equipoMaquina = partida.equipo();

        Integer puntaje3 = equipoMaquina.puntos();

        RepositorioPuntajes.GetInstance().agregarPartida(equipoMaquina, puntaje3);

        RepositorioPuntajes.GetInstance().ordenarLista();

        ArrayList<Pair<Equipo, Integer>> lista = RepositorioPuntajes.GetInstance().puntajes;

        Assertions.assertEquals(puntaje2, lista.get(0).getValue());
    }
}
