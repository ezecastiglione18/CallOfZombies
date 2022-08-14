package Jugadores;

import ControlDelJuego.Partida;
import Humores.Humor;
import Humores.HumorBueno;
import Humores.HumorMalo;
import Objetos.Objeto;
import Perks.Default;
import Perks.Perk;
import Zombies.Zombie;

import javax.persistence.*;
import javax.transaction.TransactionScoped;
import java.util.ArrayList;

@Entity
public class Jugador {
    @Id @GeneratedValue
    int id_jugador;
    @Transient
    int salud = 100;

    @Transient //@ManyToOne
    Humor humor = new HumorMalo();

    @ManyToOne
    Equipo equipo;

    @Transient
    int zombiesEliminados = 0;
    @Transient
    int dinero = 0;
    @Transient
    ArrayList<Objeto> objetos;

    @Transient //@OneToOne
    Perk perk = new Default();

    int puntos = 0;

    public void morir() {
        this.equipo.eliminarJugador(this);
        Partida.GetInstance().unJugadorMenos(this);
    }

    public void setEquipo (Equipo equipo){
        this.equipo = equipo;
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

    public int getDinero(){
        return this.dinero;
    }

    public void atacar(Zombie zombie) {
        zombie.recibirDanio(30, this);
    }

    public void recibirDanio(int danio){
        this.objetos.forEach(objeto -> {
            objeto.recibirDanio(danio);
            if(objeto.getVidaUtil() == 0){
                this.objetos.remove(objeto);
            }
        });
        this.salud -= danio;
        if (salud <= 0) {
            this.morir();
        }
    }

    public void repararObjetos(){
        this.objetos.forEach(objeto -> {
            objeto.reparar();
        });
    }

    public void sumarPuntos(int puntos) {
        this.puntos += puntos;
        //this.equipo.recalcularPuntos();
        this.equipo.sumarPuntos(puntos);
    }

    public void matoUnZombie() {
        this.perk.sumarPuntosPorMatar(this);
        this.ganarDinero(5);
        this.zombiesEliminados++;
        if (zombiesEliminados == 50) {
            this.ponerDeBuenHumor();
        }
    }

    public Humor getHumor(){
        return this.humor;
    }

    public void ganarDinero(int dinero) {
        this.dinero += dinero;
    }

    public boolean tieneDinero(int costo) {
        return dinero >= costo;
    }

    public void ponerDeMalHumor() {
        this.humor = new HumorMalo();
        //this.zombiesEliminados = 0;
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

    public int puntos() {
        return puntos;
    }

    public void recolectarObjeto(Objeto objeto){this.objetos.add(objeto);}
}