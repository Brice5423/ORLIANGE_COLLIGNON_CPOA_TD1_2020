/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 17/09/2020              |                  */
/*****************************************************/

import Fact.ChoixType;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Text explicative des choix possibles //
        System.out.println("Faite un choix entre les 3 zones :");
        System.out.println("1: Categorie.");
        System.out.println("2: Produit.");
        System.out.println("3: Client.");
        
        // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
        Scanner sc = new Scanner(System.in);
        int choix = 1;
        do {
            choix = sc.nextInt();
        } while ((choix < 1) || (choix > 3));

        System.out.println();

        ChoixType Type = new ChoixType();
        switch (choix) {
            case 1:
                System.out.println("Choix 1 : Categorie.");
                Type.ChoixCategorie();
                break;
            case 2:
                System.out.println("Choix 2 : Produit.");
                Type.ChoixProduit();
                break;
            case 3:
                System.out.println("Choix 3 : Client.");
                Type.ChoixClient();
                break;
            }
    }
}
