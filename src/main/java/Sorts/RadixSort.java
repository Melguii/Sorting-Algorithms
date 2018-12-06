package Sorts;

import Compare.Comparator;
import Compare.CompareTemporalitat;
import Compare.CompareUbicacio;
import JSONClasses.Post;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    public List<Post> radixSort(List<Post> p, Comparator c) {
        long digits;

        digits = maxDigits(p,c);

        for (int div = 1; (digits/div) > 0; div = div * 10){
            countingSort(p, div,c);
        }

        return p;

    }

    //Busquem el nombre amb mes digits per saber fins a quin digit hem d'ordenar
    private long maxDigits(List<Post> p, Comparator c){
        Post bigNum = new Post ();
        long numAux;

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

        for (int j = 0; j < 10; j++) {
            comptadorDig.add(0);
        }
        int valor;
        //Mirem quants numeros de cadam tenim entre 0 al 9
        for (int i = 0; i < p.size(); i++) {
            valor = comptadorDig.get((int)((c.retornarValor(p.get(i))/divisio)%10));
            comptadorDig.set((int)((c.retornarValor(p.get(i))/divisio)%10), (valor+ 1));
        }

        //Mtijancant un canvi necessari (sumes entre posicions anteriors i actuals) fem que el nostre array comptador apunti a les caselles
        //que li pertoquen de l'array aux
        for (int i = 1; i < comptadorDig.size(); i++) {
            comptadorDig.set(i, comptadorDig.get(i) + comptadorDig.get(i-1));
        }
        for(int j=0; j < p.size(); j++) {
            aux.add (null);
        }
        //Subtituim en els avalors de aux els nous valors ja ordenats per digits previament
        for (int i = (p.size() - 1); i >= 0; i--) {
            aux.set(comptadorDig.get((int)((c.retornarValor(p.get(i))/divisio)%10))-1, p.get(i));
            comptadorDig.set((int)((c.retornarValor(p.get(i))/divisio)%10), comptadorDig.get((int)((c.retornarValor(p.get(i))/divisio)%10))-1);
        }

        //Tornem a passar un array extern a un altre la informacio necessaria
        for (int i = 0; i < p.size(); i++) {
            p.set(i, aux.get(i));
        }
        return p;
    }

}
