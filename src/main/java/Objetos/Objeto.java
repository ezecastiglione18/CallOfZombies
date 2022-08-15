package Objetos;

abstract public class Objeto {
    NombreDeObjeto nombre;

    public Objeto(NombreDeObjeto nombreParam){
        this.nombre = nombreParam;
    }

    abstract public void reparar();

    abstract public void recibirDanio(int valor);

    abstract public int getVidaUtilOriginal();

    abstract public int getCantidadDeObjetos();

    abstract public int getVidaUtil();
}
