package EquipoTest;

import Jugadores.Equipo;
import Jugadores.Jugador;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class EquipoTest {
  @Test
  public void todosLosJugadoresSumanPuntos(){
    Equipo equipo = new Equipo("","");

    for(Jugador jugador : equipo.jugadores){
      jugador.sumarPuntos(75);
    }

    Assertions.assertEquals(75*4, equipo.puntos());
  }

  @Test
  public void muereUnJugadorPeroNoPierdePuntosElEquipo(){
    Equipo equipo = new Equipo("","");

    for(Jugador jugador : equipo.jugadores){
      jugador.sumarPuntos(75);
    }

    Jugador jugadorMuerto = equipo.jugadores.get(1);
    jugadorMuerto.morir();

    Assertions.assertEquals(75*4, equipo.puntos());
  }
}
