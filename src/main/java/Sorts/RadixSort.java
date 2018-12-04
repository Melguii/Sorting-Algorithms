package Sorts;

import Compare.Comparator;
import JSONClasses.Post;

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

    private List<Post> countingSort(List<Post> p, int div){
        int
        int unitat[] =

        for(int i = 0; i < p.size(); i++){

        }
    }

    private

}
