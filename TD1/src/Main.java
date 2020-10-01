/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 17/09/2020              |                  */
/*****************************************************/

import FactMenu1.Menu1;
import FactMenu2.Menu2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Text de choix entre les 2 types de menus //
        System.out.println("Faite un choix entre les 2 menus :");
        System.out.println("1: Menu1 (TD1)");
        System.out.println("2: Menu2 (TD2)");

        // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
        Scanner sc = new Scanner(System.in);
        int choix = 1;
        do {
            choix = sc.nextInt();
        } while ((choix < 1) || (choix > 2));

        System.out.println();

        switch (choix) {
            case 1:
                System.out.println("Choix 1 : Categorie.");
                Menu1.menu1();
                break;
            case 2:
                System.out.println("Choix 2 : Produit.");
                Menu2.menu2();
                break;
        }
    }
}
