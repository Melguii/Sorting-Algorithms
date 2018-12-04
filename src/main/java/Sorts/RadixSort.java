package Sorts;

import Compare.Comparator;
import JSONClasses.Post;

import java.util.ArrayList;
import java.util.List;

public class RadixSort {

    public List<Post> radixSort(List<Post> p, Comparator c) {
        int digits;

        digits = maxDigits(p,c);

        for (int div = 1; digits/div > 0; div *= 10){
            countingSort(p, div);
        }

        return p;

    }

    //Busquem el nombre amb mes digits per saber fins a quin digit hem d'ordenar
    private int maxDigits(List<Post> p, Comparator c){
        Post bigNum = p.get(0);
        int numAux;

        for (int i = 0; i < p.size(); i++){
            if (c.compararDigits(p.get(i), bigNum)){
                bigNum = p.get(i);
            }
        }

        //Mirem si es de temporalitat, ubicacio o prioritat
        if (c == de temps){
            numAux = bigNum.getPublished();
        }else{
            //Sino tornar de ubicacio
            //Falta implementar de per combinacio de prioritats
            numAux = bigNum.getPublished();
        }

        return numAux;
    }

    private List<Post> countingSort(List<Post> p, int div) {
        List<Post> aux = new ArrayList<Post>();
        List<Post> comptadorDig = new ArrayList<Post>();

        //Mirem quants numeros de cadam tenim entre 0 al 9
        for (int i = 0; i < p.size(); i++) {
            comptadorDig[(p.get(i)/div)%10]++;
        }

        //Mtijancant un canvi necessari (sumes entre posicions anteriors i actuals) fem que el nostre array comptador apunti a les caselles
        //que li pertoquen de l'array aux
        for (int i = 1; i < 19; i++) {
            comptadorDig[i] += comptadorDig[i - 1];
        }

        //Subtituim en els avalors de aux els nous valors ja ordenats per digits previament
        for (int i = p.size() - 1; i >= 0; i++) {
            aux
            comptadorDig
        }

        //Tornem a passar un array extern a un altre la informacio necessaria
        for (int i = 0; i < p.size(); i++) {
            p.set(i, aux.get(i));
        }
    }

}
