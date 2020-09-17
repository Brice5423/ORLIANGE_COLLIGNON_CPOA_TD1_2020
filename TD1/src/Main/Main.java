/* *******************************|***************** */
/* Auteur : Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : VSC & Eclipse       |   ...            */
/* Langage : Java                 |                  */
/* Date : 17/09/2020              |                  */
/* *******************************|***************** */

package Main;

import java.util.Scanner;

public class Main {
    public static void main(final String[] args) {
        boolean continu;
        do {
            // Text explicative des choix possibles //
            System.out.println("Faite un choix entre les 3 zones :");
            System.out.println("1: Categorie.");
            System.out.println("2: Produit.");
            System.out.println("3: Client.");

            // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
            final Scanner sc = new Scanner(System.in);
            int choix;
            do {
                choix = sc.nextInt();
            } while ((choix < 1) || (choix > 4));
            sc.close();

            System.out.println();

            switch (choix) {
                case 1:
                    System.out.println("Choix 1 : Categorie.");
                    ChoixType.ChoixCategorie();
                    break;
                case 2:
                    System.out.println("Choix 2 : Produit.");
                    ChoixType.ChoixProduit();
                    break;
                case 3:
                    System.out.println("Choix 3 : Client.");
                    ChoixType.ChoixClient();
                    break;
            }

            System.out.println("Voulez-vous continue (yes/no) :");
            String rep;
            do {
                rep = sc.next();
            } while ((rep!="yes")||(rep!="no"));

            if (rep=="yes")
                continu=true;
            else
                continu=false;
            sc.close();
        } while (continu);
    }
}
