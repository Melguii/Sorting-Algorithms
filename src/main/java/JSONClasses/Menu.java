package JSONClasses;

import java.util.Scanner;

public class Menu {
    private int opcio;

    public void implementacioMenu () {
        do {
            mostrarMenu();
            seleccioMenu();
        } while (opcio != 4);
    }

    private void seleccioMenu () {
        switch (opcio) {
            case 1:
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
