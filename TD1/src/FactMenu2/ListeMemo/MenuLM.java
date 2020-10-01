/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.ListeMemo;

import FactMenu2.ListeMemo.Categorie.ChoixCategLM;
import FactMenu2.ListeMemo.Client.ChoixClientLM;
import FactMenu2.ListeMemo.Produit.ChoixProdLM;

import java.util.Scanner;

public class MenuLM {
    public static void menuLM() {
        // Text explicative des choix possibles //
        System.out.println("Faite un choix entre les 3 zones à interagire :");
        System.out.println("1: Categorie.");
        System.out.println("2: Client.");
        System.out.println("3: Produit.");

        // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
        Scanner sc = new Scanner(System.in);
        int choix = 1;
        do {
            choix = sc.nextInt();
        } while ((choix < 1) || (choix > 3));

        System.out.println();

        switch (choix) {
            case 1:
                System.out.println("Choix 1 : Categorie.");
                ChoixCategLM.choixCateg();
                break;
            case 2:
                System.out.println("Choix 2 : Client.");
                ChoixClientLM.choixClient();
                break;
            case 3:
                System.out.println("Choix 3 : Produit.");
                ChoixProdLM.choixProd();
                break;
        }

    }
}
