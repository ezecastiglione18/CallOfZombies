package Zombies;

public class ZombieComunFactory implements ZombiesFactory {

    public static Zombie crearZombie() {
        Zombie zombie = new Zombie();
        zombie.salud(100);
        return zombie;
    }
}
