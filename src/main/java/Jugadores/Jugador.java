package Jugadores;

import Humores.Humor;
import Humores.HumorBueno;
import Humores.HumorMalo;
import Objetos.Objeto;
import Perks.Default;
import Perks.Perk;
import Zombies.Zombie;

import java.util.ArrayList;

public class Jugador {
    int salud = 100;
    Humor humor = new HumorMalo();

    int zombiesEliminados = 0;
    int dinero = 0;
    ArrayList<Objeto> objetos;
    Perk perk = new Default();
    int puntajeAcumulado = 0;

    private void morir() {
        // TODO
    }

    public void comprarPerk(Perk perk) throws Exception {
        this.humor.comprarPerk(perk, this);
    }

    public void realizarCompraDePerk(Perk perk) {
        this.dinero -= perk.costo();
        this.perk = perk;
    }

    public void revitalizar(int puntosDeSalud) {
        if(salud + puntosDeSalud > 100) {
            salud = 100;
        } else {
            salud += puntosDeSalud;
        }
    }

    public void atacar(Zombie zombie) {
        zombie.recibirDanio(30, this);
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

    public void sumarPuntos(int puntos) {
        this.puntajeAcumulado += puntos;
    }

    public void killRealizada() {
        this.perk.recompensarKill(this);

        this.zombiesEliminados++;
        if (zombiesEliminados == 50) {
            this.ponerDeBuenHumor();
        }
    }

    public boolean tieneDinero(int costo) {
        return dinero >= costo;
    }

    public void ponerDeMalHumor() {
        this.humor = new HumorMalo();
        this.zombiesEliminados = 0;
    }

    public void ponerDeBuenHumor() {
        this.humor = new HumorBueno();
    }

    public boolean estaDeBuenHumor() {
        return humor.estaDeBuenHumor();
    }

    public boolean estaVivo() {
        return salud > 0;
    }
}