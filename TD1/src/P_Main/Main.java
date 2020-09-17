/* *******************************|***************** */
/* Auteur : Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : VSC & Eclipse       |   ...            */
/* Langage : Java                 |                  */
/* Date : 17/09/2020              |                  */
/* *******************************|***************** */

package P_Main;

import java.util.Scanner;

import P_ClasseSQL.Connexion;

public class Main {
    public static void main(final String[] args) {
        Connexion.creeConnexion();

        // Text explicative des choix possibles //
        System.out.println("Faite un choix :");
        System.out.println("1: ajouter une catégorie.");
        System.out.println("2: modifier une catégorie.");
        System.out.println("3: supprimer une catégorie.");
        System.out.println("4: renvoier toutes les catégories de la base.");

        // Oblige de donner un des 4 choix //
        final Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));
        sc.close();

        System.out.println("");

        switch(choix) {
            case 1:
                System.out.println("Choix 1 : ajouter une catégorie.");
                break;
            case 2:
                System.out.println("Choix 2 : modifier une catégorie.");
                break;
            case 3:
                System.out.println("Choix 3 : supprimer une catégorie.");
                break;
            case 4:
                System.out.println("Choix 4 : renvoier toutes les catégories de la base.");
                break;
        }
    }
}
