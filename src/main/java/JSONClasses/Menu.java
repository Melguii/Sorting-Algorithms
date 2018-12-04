package JSONClasses;

import Compare.*;
import Sorts.QuickSort;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {
    private int opcio;

    public void implementacioMenu (User [] users) {
        do {
            mostrarMenu();
            seleccioMenu(users);
        } while (opcio != 4);
    }

    private void seleccioMenu (User[] users) {
        Comparator c;
        switch (opcio) {
            case 1:
                QuickSort q = new QuickSort();
                ArrayList<Post> p = new ArrayList<Post>();
                for (User u:users) {
                    for (Post p_aux:(u.getPosts())) {
                        p.add(p_aux);
                    }
                }
                c = new CompareTemporalitat();
                q.quickSort(p,c,0, (p.size()-1));
                for(Post p_aux_2:p) {
                    System.out.println(p_aux_2.getId());
                }
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            default:
                System.out.println("Error, opcio no valida :(");
                break;
        }
    }

    private void mostrarMenu () {
        System.out.println("Benvingut a InstaSalle, el intragram per programadors de veritat");
        System.out.println("\t1.Ordenar segons Temporalitat");
        System.out.println("\t2.Ordenar segons Ubicacio");
        System.out.println("\t3.Ordenar segons una combinacio de prioritats");
        System.out.println("\t4.Sortir");
        demanarOpcio();
    }

    private void demanarOpcio () {
        System.out.println("Introdueix opcio: ");
        Scanner sc = new Scanner (System.in);
        this.opcio = sc.nextInt();
    }


}
