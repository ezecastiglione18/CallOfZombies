package Objetos;

import java.util.ArrayList;
import java.util.Random;

public class ObjetosFactory {
    static Integer[] probabilidades = new Integer[]{
        1,1,1,1,1,1,1,1,2,2
    };
    //Como hay mas probabilidades de encontrarte con un objeto simple, 1 == simple y 2 == complejo

    static NombreDeObjeto[] objSimples = new NombreDeObjeto[]{
        NombreDeObjeto.MADERA, NombreDeObjeto.ORO, NombreDeObjeto.PIEDRA, NombreDeObjeto.POLVORA, NombreDeObjeto.SOGA
    };

    static NombreDeObjeto[] objComplejos = new NombreDeObjeto[]{
        NombreDeObjeto.LANZALLAMAS, NombreDeObjeto.LANZA, NombreDeObjeto.CATAPULTA, NombreDeObjeto.ARCO_Y_FLECHA,
        NombreDeObjeto.ANTORCHA
    };

    public static Objeto crearObjeto(){
        int rnd = new Random().nextInt(probabilidades.length);
        int objetoElegido = probabilidades[rnd];

        if(objetoElegido == 1){
            NombreDeObjeto nombre = objSimples[new Random().nextInt(objSimples.length)];
            Objeto objetoCreado = new ObjetoSimple(nombre);
            return objetoCreado;
        }

        NombreDeObjeto nombre = objComplejos[new Random().nextInt(objComplejos.length)];

        ArrayList<Objeto> lista = new ArrayList<>();
        NombreDeObjeto nombre1 = objSimples[new Random().nextInt(objSimples.length)];
        Objeto objetoCreado1 = new ObjetoSimple(nombre1);
        NombreDeObjeto nombre2 = objSimples[new Random().nextInt(objSimples.length)];
        Objeto objetoCreado2 = new ObjetoSimple(nombre2);
        NombreDeObjeto nombre3 = objSimples[new Random().nextInt(objSimples.length)];
        Objeto objetoCreado3 = new ObjetoSimple(nombre3);
        lista.add(objetoCreado1);
        lista.add(objetoCreado2);
        lista.add(objetoCreado3);


        Objeto objetoCreadoComplejo = new ObjetoComplejo(lista, nombre);
        return objetoCreadoComplejo;
    }
}
