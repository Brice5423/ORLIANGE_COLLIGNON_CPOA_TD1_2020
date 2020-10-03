/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA             */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   TD2            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL;

import java.util.Scanner;

import FactMenu2.MySQL.Categorie.ChoixCategSQL;
import FactMenu2.MySQL.Client.ChoixClientSQL;
import FactMenu2.MySQL.Produit.ChoixProdSQL;

public class MenuSQL {
    public static void menuSQL() {
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
                ChoixCategSQL.choixCategSQL();
                break;
            case 2:
                System.out.println("Choix 2 : Client.");
                ChoixClientSQL.choixClientSQL();
                break;
            case 3:
                System.out.println("Choix 3 : Produit.");
                ChoixProdSQL.choixProdSQL();
                break;
        }
    }
}
