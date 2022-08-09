package Jugadores;

import Humores.Humor;
import Humores.HumorMalo;
import Objetos.Objeto;
import Perks.Default;
import Perks.Perk;
import Zombies.Zombie;

import java.util.ArrayList;

public class Jugador {
    int salud = 100;
    Humor humor = new HumorMalo();
    int dinero = 0;
    ArrayList<Objeto> objetos;
    Perk perk = new Default();
    int puntajeAcumulado = 0;

    private void morir() {
        // TODO
    }

    private void alternarHumor() {
        // TODO
    }

    public void iniciarNuevaRonda() {
        // TODO
    }

    public void comprarPerk(Perk perk) {
        // TODO
    }

    public void activarPerk(Jugador this) {
        // TODO
    }

    public void atacar(Zombie zombie) {
        // TODO
    }

    public void recibirDanio(int danio){
        this.objetos.forEach(objeto -> {
            objeto.recibirDanio(danio);
        });
        this.salud -= danio;
    }

    public void repararObjetos(){
        this.objetos.forEach(objeto -> {
            objeto.reparar();
        });
    }

}