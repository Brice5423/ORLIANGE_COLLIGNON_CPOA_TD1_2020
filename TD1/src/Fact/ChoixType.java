/* *******************************|***************** */
/* Auteur : Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : VSC & Eclipse       |   ...            */
/* Langage : Java                 |                  */
/* Date : 17/09/2020              |                  */
/* *******************************|***************** */

package Fact;

import java.util.Scanner;

import ClasseSQL.*;

public class ChoixType {

    public void ChoixCategorie() {
        // Text explicative des choix possibles //
        System.out.println("Faite un choix entre les actions possibles pour la Categorie :");
        System.out.println("1: ajouter une Catégorie.");
        System.out.println("2: modifier une Catégorie.");
        System.out.println("3: supprimer une Catégorie.");
        System.out.println("4: renvoier toutes les Catégorie de la base.");

        // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));

        System.out.println();

        Categorie cat = new Categorie();
        switch(choix) {
            case 1:
                System.out.println("Choix 1 : ajouter une catégorie.");
                cat.AjoutCategorie();
                break;
            case 2:
                System.out.println("Choix 2 : modifier une catégorie.");
                cat.ModifCategorie();
                break;
            case 3:
                System.out.println("Choix 3 : supprimer une catégorie.");
                cat.SupCategorie();
                break;
            case 4:
                System.out.println("Choix 4 : renvoier toutes les catégories de la base.");
                cat.ArrayList();
                break;
        }
    }


    public static void ChoixProduit() {
        // Text explicative des choix possibles //
        System.out.println("Faite un choix entre les actions possibles pour le Produit :");
        System.out.println("1: ajouter une Produit.");
        System.out.println("2: modifier une Produit.");
        System.out.println("3: supprimer une Produit.");
        System.out.println("4: renvoier toutes les Produit de la base.");

        // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));

        System.out.println();

        Produit Prod = new Produit();
        switch(choix) {
            case 1:
                System.out.println("Choix 1 : ajouter une Produit.");
                Prod.AjoutProduit();
                break;
            case 2:
                System.out.println("Choix 2 : modifier une Produit.");
                Prod.ModifProduit();
                break;
            case 3:
                System.out.println("Choix 3 : supprimer une Produit.");
                Prod.SupProduit();
                break;
            case 4:
                System.out.println("Choix 4 : renvoier toutes les Produit de la base.");
                Prod.ArrayList();
                break;
        }
    }


    public static void ChoixClient() {
        // Text explicative des choix possibles //
        System.out.println("Faite un choix entre les actions possibles pour le Client :");
        System.out.println("1: ajouter une Client.");
        System.out.println("2: modifier une Client.");
        System.out.println("3: supprimer une Client.");
        System.out.println("4: renvoier toutes les Client de la base.");

        // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));

        System.out.println();

        Clients Cli = new Clients();
        switch(choix) {
            case 1:
                System.out.println("Choix 1 : ajouter une Client.");
                Cli.AjoutClients();
                break;
            case 2:
                System.out.println("Choix 2 : modifier une Client.");
                Cli.ModifClients();
                break;
            case 3:
                System.out.println("Choix 3 : supprimer une Client.");
                Cli.SupClients();
                break;
            case 4:
                System.out.println("Choix 4 : renvoier toutes les Client de la base.");
                Cli.ArrayList();
                break;
        }
    }
}
