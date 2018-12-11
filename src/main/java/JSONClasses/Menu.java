package JSONClasses;

import Compare.*;
import Sorts.MergeSort;
import Sorts.QuickSort;
import Sorts.RadixSort;
import Sorts.SelectionSort;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private int opcio;


    /**
     * Metode que ens permet realitzar una opcio o una altra segons els parametres introduits per argument
     * @param users LLista d'usuaris carregada des del JSON
     * @param args String dels arguments passats abans d'iniciar el programa
     */
    public void seleccioMenu(User[] users, String[] args) {
        Comparator c;
        boolean error;
        String s;
        List<Post> p = new ArrayList<Post>();
        for (User u : users) {
            for (Post p_aux : (u.getPosts())) {
                p.add(p_aux);
            }
        }
        s = args[0];
        do {
            if (s.equals("temporalitat")) {
                c = new CompareTemporalitat();
                seleccioOrdenacio(p, c, args);
                error = false;
            } else {
                if (s.equals("ubicacio")) {
                    c = new CompareUbicacio();
                    float longitudRef;
                    float latitutRef;
                    error = false;
                    longitudRef = Float.parseFloat(args[4]);
                    latitutRef = Float.parseFloat(args[3]);
                    //Calculem la distancia amb la formula del haversine per a cada post
                    for (Post post_aux2 : p) {
                        post_aux2.calculHaversine(longitudRef, latitutRef);
                    }
                    seleccioOrdenacio(p, c, args);
                } else {
                    if (s.equals("prioritats")) {
                        User user;
                        User[] users_2 = users.clone();
                        users_2 = quickSort(users_2, 0, users_2.length - 1);
                        user = busquedaUsuari(users_2, args[3]);
                        p = user.calculPrioritats();
                        c = new ComparePrioritats();
                        seleccioOrdenacio(p,c,args);
                        error = false;
                    } else {
                        System.out.println("Error, primer parametre no valid :(");
                        error = true;
                        System.out.println("La nostra generositat no coneix limits, torna a introduit opcio:");
                        Scanner sc = new Scanner(System.in);
                        s = sc.nextLine();
                    }
                }
            }
        } while (error);
        //Cambiar nomsss
        /*if (args[0].equals("temporalitat") || args[0].equals("ubicacio") || args[0].equals("prioritats")) {
            int cursor = 1;
            System.out.println("\nORDENACIO\n");
            if (args[0].equals("temporalitat")) {
                for (Post p_aux : p) {
                    System.out.println(cursor + "." + " "+ p_aux.getId() + "  " + p_aux.getPublished());
                    cursor++;
                }
                System.out.println("\n");
            } else {
                if (args[0].equals("ubicacio")) {
                    for (Post p_aux : p) {
                        System.out.println(cursor + "." + " " + p_aux.getComparacioUbicacio() + " " + p_aux.getLocation().get(0) + " " + p_aux.getLocation().get(1));
                        cursor++;
                    }
                    System.out.println("\n");
                } else {
                    if (args[0].equals("prioritats")) {
                        Post p_aux;
                        for (int index = p.size() - 1; index >= 0; index--) {
                            p_aux = p.get(index);
                            System.out.println(cursor + "." + " " + p_aux.getId() + " "+ p_aux.getPublished() + " " + p_aux.getCategory() + " res:" + p_aux.getValorPrioritat());
                            cursor++;
                        }
                        System.out.println("\n");
                    }
                }
            }
        }*/
    }

    /**
     * Metode que s'ocupa de escollir un metode d'ordenacio o un altre sgeons els arguments introduits
     * @param p Llista de posts que volem ordenar
     * @param c Tipus de comparador (Aquest varia, segons si el que volem comparar es ubicacio, temporalitat...)
     * @param args String dels arguments passats abans d'iniciar el programa
     */
    private void seleccioOrdenacio(List<Post> p, Comparator c, String[] args) {
        boolean error;
        String s;
        s = args[1];
        long time_start, time_end;
        time_start = System.currentTimeMillis();
        do {
            if (s.equals("Quicksort")) {
                QuickSort q = new QuickSort();
                q.quickSort(p, c, 0, p.size() - 1);
                error = false;
            } else {
                if (s.equals("Mergesort")) {
                    MergeSort m = new MergeSort();
                    m.mergeSort(p, c, 0, p.size() - 1);
                    error = false;
                } else {
                    if (s.equals("Radixsort")) {
                        RadixSort r = new RadixSort();
                        r.radixSort(p, c);
                        error = false;
                    } else {
                        if (s.equals("Selectionsort")) {
                            SelectionSort selct = new SelectionSort();
                            selct.selectionSort(p, c);
                            error = false;
                        } else {
                            System.out.println("Segon parametre no valid, crec que t'has equivocat de carrera ༼ つ ◕_◕ ༽つ\n");
                            error = true;
                            System.out.println("La nostra generositat no coneix limits, torna a introduit opcio:");
                            Scanner sc = new Scanner(System.in);
                            s = sc.nextLine();
                        }
                    }
                }
            }
        } while (error == true);
        time_end = System.currentTimeMillis();
        System.out.println("the task has taken "+ ( time_end - time_start ) +" milliseconds");
    }

    /**
     * S'ocupa de detectar quin és el fitxer escollit per obrir
     * @param args String dels arguments passats abans d'iniciar el programa
     * @return Retorna una variable tipus FileReader per tal que el fitxer pugui ser llegit/interpretat
     */
    public FileReader menuFitxers(String[] args) {
        FileReader fitxer;
        fitxer = seleccioFitxer(args);
        return fitxer;
    }

    /**
     * Control del nom de fitxer introduit( mirem si es correcte o si no existeix, i per tant hem de mostrar un error)
     * també establim que tots els fitxers estaran a la carpeta datasets
     * @param args String dels arguments passats abans d'iniciar el programa
     * @return Retorna una variable tipus FileReader per tal que el fitxer pugui ser llegit/interpretat
     */
    private FileReader seleccioFitxer(String[] args) {
        FileReader fitxer = null;
        String ubicacio = new String();
        ubicacio = "datasets/" + args[2];
        do {
            try {
                fitxer = new FileReader(ubicacio);
            } catch (FileNotFoundException e) {
                System.out.println("Error fitxer especificat no trobat (ha d'estar a la carpeta datasets),no ens petaras \nel programa tan facilment, fem PAED (⌐■_■)");
                System.out.println("La nostra generositat no coneix limits, trona'm a introduir nom del fitxer :):");
                Scanner sc = new Scanner(System.in);
                ubicacio = "datasets/" + sc.nextLine();
            }
        } while (fitxer == null);
        return fitxer;
    }

    /**
     * Metode de busqueda binaria, per tal de buscar un username concret (concretament el que busquem
     * és que ens passen per argument, per tal de poder mostrar la comparacio de prioritats d'aquell
     * usuari en concret)
     * @param users Array de users on buscarem el username introduit
     * @param valorBuscat Username que buscarem en l'array
     * @return Retornem tota la informacio del username trobat
     */
    private User busquedaUsuari (User[] users, String valorBuscat) {
        User user = null;
        User [] users_2;
        users_2 = users.clone();

        int principi = 0;
        int fin = users.length - 1;
        int valor_resultat = 0;
        int mig = (principi + fin)/2;
        boolean b = false;
        while (!b && (principi <= fin)){
            mig = (principi + fin)/2;
            if (users[mig].getUsername().equals(valorBuscat)) {
                b = true;
                valor_resultat = mig;
            }
            else {
                if (users[principi].getUsername().equals(valorBuscat)) {
                    b = true;
                    valor_resultat = principi;
                }
                else {
                    if (users[fin].getUsername().equals(valor_resultat)) {
                        b = true;
                        valor_resultat = fin;
                    }
                    else {
                        if (users[mig].getUsername().compareTo(valorBuscat) > 0) {
                            fin = mig - 1;
                        } else {
                            principi = mig + 1;
                        }
                    }
                }
            }
        }
        user = users[valor_resultat];
        return user;
    }

    /**
     * quickSort que ens servira per ordenar el array users per fer la busqueda binaria
     * @param p Array de users que volem ordenar
     * @param i Principi del array
     * @param j Final del array
     * @return Retornem el array introduit totalment ordenat
     */
    public User [] quickSort (User [] p, int i, int j) {
        int s;
        int t;
        int array_aux_ij [] = new int [2];
        int array_aux_st [] = new int [2];

        if (i >= j) {
            return p;
        }
        else{
            array_aux_ij[0] = i;
            array_aux_ij[1] = j;
            array_aux_st = particio(p,array_aux_ij);
            s = array_aux_st[0];
            t = array_aux_st[1];
            p = quickSort(p,i,t);
            p = quickSort(p,s,j);
        }
        return p;
    }

    /**
     * Metode que ens serveix per tal de poder realitzar correctament el quickSort
     * @param p Array de users que volem ordenar
     * @param array_aux_ij La i i la j en forma de array per tal  que el seu valor
     *                     canvii tambe en el  metode quicksort
     * @return Els nous valors de s i t
     */
    private int [] particio (User [] p, int array_aux_ij[]) {
        int mig;
        User pivot;
        User tmp = new User();
        int s;
        int t;
        s = array_aux_ij[0];
        t = array_aux_ij[1];
        mig = (array_aux_ij[0] + array_aux_ij[1])/2;
        pivot = p[mig];
        while (s <= t) {
            while (pivot.getUsername().compareTo(p[s].getUsername()) > 0) {
                s = s + 1;
            }
            while(pivot.getUsername().compareTo(p[t].getUsername()) < 0) {
                t = t - 1;
            }
            if (s < t) {
                tmp = p[s];
                p[s] = p[t];
                p[t] = tmp;
                s = s + 1;
                t = t - 1;
            }
            else {
                if (s == t) {
                    s = s + 1;
                    t = t - 1;
                }
            }
        }
        int [] array_aux_st = new int[2];
        array_aux_st[0]= s;
        array_aux_st[1]=t;

        return array_aux_st;
    }
}