package HumorTest;

import Humores.Humor;
import Jugadores.Equipo;
import Jugadores.Jugador;
import Perks.Diamante;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class HumorTest {
  @Test
  public void mataZobiesYPasaABuenHumor(){
    Equipo equipo = new Equipo("","");

    Jugador jugador = equipo.jugador(2);

    for(int i = 0; i <= 50; i++){
      jugador.matoUnZombie();
    }

    Humor humor = jugador.getHumor();

    Assertions.assertEquals(true, humor.estaDeBuenHumor());
  }

  @Test
  public void seGeneraConMalHumor(){
    Equipo equipo = new Equipo("","");

    Jugador jugador = equipo.jugador(2);

    Humor humor = jugador.getHumor();

    Assertions.assertEquals(false, humor.estaDeBuenHumor());
  }

  @Test
  public void estaDeBuenHumorYCompraPerkConDineroInsuficiente() throws Exception {
    Equipo equipo = new Equipo("","");

    Jugador jugador = equipo.jugador(2);

    for(int i = 0; i <= 100; i++){
      jugador.matoUnZombie();
    }

    Integer dinero = jugador.getDinero(); //Dinero = 505

    jugador.comprarPerk(new Diamante());

    Assertions.assertEquals(false, jugador.getHumor().estaDeBuenHumor());
  }
}
