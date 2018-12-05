package Sorts;

import Compare.Comparator;
import Compare.CompareTemporalitat;
import Compare.CompareUbicacio;
import JSONClasses.Post;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    public List<Post> radixSort(List<Post> p, Comparator c) {
        int digits;

        digits = maxDigits(p,c);

        for (int div = 1; digits/div > 0; div *= 10){
            countingSort(p, div,c);
        }

        return p;

    }

    //Busquem el nombre amb mes digits per saber fins a quin digit hem d'ordenar
    private int maxDigits(List<Post> p, Comparator c){
        Post bigNum = new Post ();
        int numAux;

        for (int i = 0; i < p.size(); i++){
            if (i == 0) {
                bigNum = p.get(0);

            }
            else {
                if (c.compararp1top2(p.get(i), bigNum)){
                    bigNum = p.get(i);
                }
            }
        }
        numAux = c.retornarValor(bigNum);
        return numAux;
    }

    private List<Post> countingSort(List<Post> p, int divisio, Comparator c) {
        List<Post> aux = new ArrayList<Post>();
        List<Integer> comptadorDig = new ArrayList<Integer>();

        //Mirem quants numeros de cadam tenim entre 0 al 9
        for (int i = 0; i < p.size(); i++) {
            comptadorDig.set((c.retornarValor(p.get(i))/divisio)%10, ((c.retornarValor(p.get(i))/divisio)%10) + 1);
        }

        //Mtijancant un canvi necessari (sumes entre posicions anteriors i actuals) fem que el nostre array comptador apunti a les caselles
        //que li pertoquen de l'array aux
        for (int i = 1; i < comptadorDig.size(); i++) {
            comptadorDig.set(i, comptadorDig.get(i) + comptadorDig.get(i-1));
        }

        //Subtituim en els avalors de aux els nous valors ja ordenats per digits previament
        for (int i = p.size() - 1; i >= 0; i++) {
            aux.set (comptadorDig.get(i), p.get(i));
        }

        //Tornem a passar un array extern a un altre la informacio necessaria
        for (int i = 0; i < p.size(); i++) {
            p.set(i, aux.get(i));
        }
        return p;
    }

}
