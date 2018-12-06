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

    public void implementacioMenu (User [] users) {
        do {
            mostrarMenu();
            seleccioMenu(users);
        } while (opcio != 4);
    }

    private void seleccioMenu (User[] users) {
        Comparator c;
        List<Post> p = new ArrayList<Post>();
        for (User u:users) {
            for (Post p_aux:(u.getPosts())) {
                p.add(p_aux);
            }
        }
        switch (opcio) {
            case 1:
                c = new CompareTemporalitat();
                menuOrdenacio(p,c);
                break;
            case 2:
                c = new CompareUbicacio();
                float longitudRef;
                float latitutRef;
                System.out.println("Introdueixme una ubicacio:");
                System.out.println("Longitud:");
                Scanner sc = new Scanner(System.in);
                longitudRef = sc.nextFloat();
                System.out.println("Latitud:");
                Scanner sc2 = new Scanner(System.in);
                latitutRef = sc2.nextFloat();
                //Calculem la distancia amb la formula del haversine per a cada post
                for (Post post_aux2:p) {
                    post_aux2.calculHaversine(longitudRef,latitutRef);
                }
                menuOrdenacio(p,c);
                break;
            case 3:
                users[2].interesCategoria(users[0].getPosts().get(0));
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
        opcio = demanarOpcio();
    }

    private int demanarOpcio () {
        System.out.println("Introdueix opcio: ");
        Scanner sc = new Scanner (System.in);
        return sc.nextInt();
    }
    private void menuOrdenacio(List<Post>p, Comparator c) {
        int opcio_ordenacio;
        do {
            mostrarMenuOrdenacio();
            opcio_ordenacio = demanarOpcio();
            seleccioOrdenacio(p,c, opcio_ordenacio);
        } while(opcio_ordenacio < 1 || opcio_ordenacio > 4);
    }

    private void seleccioOrdenacio (List<Post>p, Comparator c, int opcio_ordenacio) {
        switch (opcio_ordenacio) {
            case 1:
                QuickSort q = new QuickSort();
                q.quickSort(p,c,0, p.size()-1);
                break;
            case 2:
                MergeSort m = new MergeSort();
                m.mergeSort(p,c,0,p.size()-1);
                break;
            case 3:
                RadixSort r = new RadixSort();
                r.radixSort (p,c);
                break;
            case 4:
                SelectionSort s = new SelectionSort();
                s.selectionSort(p,c);
                break;
            default:
                System.out.println("Opcio no valida, crec que t'has equivocat de carrera ༼ つ ◕_◕ ༽つ\n");
        }
        if (opcio_ordenacio >= 1 && opcio_ordenacio <= 4) {
            int cursor = 1;
            System.out.println("\nORDENACIO\n");
            for (Post p_aux:p) {
                System.out.println(cursor+"."+ " " + p_aux.getId());
                cursor++;
            }
            System.out.println("\n");
        }

    }
    private void mostrarMenuOrdenacio () {
        System.out.println("De quina forma vols stalkejar?:");
        System.out.println("1.Fent un QuickSort, corre como el viento perdigon");
        System.out.println("2.Fent un MergeSort, soc una persona practica");
        System.out.println("3.Fent un RadixSort, he aprovat Mates");
        System.out.println("4.Fent un SelectionSort, m'agraden les tortugues");
    }

    public FileReader menuFitxers() {
        int opcio_fitxer;
        String nom_fitxer;
        FileReader fitxer;
        do {
            mostrarMenuFitxers ();
            opcio_fitxer = demanarOpcio();
            fitxer = seleccioFitxer(opcio_fitxer);
        } while(fitxer == null && opcio_fitxer != 5);
        return fitxer;
    }
    private FileReader seleccioFitxer (int opcio_fitxer) {
        FileReader fitxer = null;
        String ubicacio = new String();
        switch (opcio_fitxer) {
            case 1:
                ubicacio= "datasets/xs_dataset.json";
                break;
            case 2:
                ubicacio = "datasets/s_dataset.json";
                break;
            case 3:
                ubicacio = "datasets/m_dataset.json";
                break;
            case 4:
                System.out.println("Nom del fitxer que es vol obrir:");
                InputStreamReader tmp = new InputStreamReader(System.in);
                BufferedReader sc = new BufferedReader (tmp);
                try {
                    ubicacio = "datasets/" + sc.readLine();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                break;
            case 5:
                break;
        }
        if (opcio_fitxer >= 1 && opcio_fitxer <= 4) {
            try {
                fitxer = new FileReader(ubicacio);
            } catch (FileNotFoundException e) {
                System.out.println("Error fitxer especificat no trobat (ha d'estar a la carpeta datasets),no ens petaras \nel programa tan facilment, fem PAED (⌐■_■)");
            }
        }
        return fitxer;
    }
    private void mostrarMenuFitxers () {
        System.out.println("Selecciona el fitxer que vols obrir");
        System.out.println("1.Fitxer xs_dataset.json");
        System.out.println("2.Fitxer s_dataset.json");
        System.out.println("3.Fitxer m_dataset.json");
        System.out.println("4.Tinc fitxer personalitzat, soc informatic/a");
        System.out.println("5.Ho reconec, soc de ADE, treiueme d'aqui ಡ_ಡ");
    }

}
