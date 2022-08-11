package Zombies;

public class ZombieEspecialFactory implements ZombiesFactory {

    public static Zombie crearZombie() {
        Zombie zombie = new Zombie();
        zombie.salud(200);
        return zombie;
    }
}
