package Main;

import java.util.Scanner;

import ClasseSQL.*;

public class ChoixType {

    public static void ChoixCategorie() {
        // Text explicative des choix possibles //
        System.out.println("Faite un choix entre les actions possibles pour la Categorie :");
        System.out.println("1: ajouter une Catégorie.");
        System.out.println("2: modifier une Catégorie.");
        System.out.println("3: supprimer une Catégorie.");
        System.out.println("4: renvoier toutes les Catégorie de la base.");

        // Oblige de donner un des 4 choix (1, 2, 3 ou 4) //
        final Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));
        sc.close();

        System.out.println();

        switch(choix) {
            case 1:
                System.out.println("Choix 1 : ajouter une catégorie.");
                Categorie.AjoutCategorie();
                break;
            case 2:
                System.out.println("Choix 2 : modifier une catégorie.");
                //Categorie.ModifCategorie();
                break;
            case 3:
                System.out.println("Choix 3 : supprimer une catégorie.");
                //Categorie.SupCategorie();
                break;
            case 4:
                System.out.println("Choix 4 : renvoier toutes les catégories de la base.");
                //Categorie.ArrayList();
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
        final Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));
        sc.close();

        System.out.println();

        switch(choix) {
            case 1:
                System.out.println("Choix 1 : ajouter une Produit.");

                break;
            case 2:
                System.out.println("Choix 2 : modifier une Produit.");

                break;
            case 3:
                System.out.println("Choix 3 : supprimer une Produit.");

                break;
            case 4:
                System.out.println("Choix 4 : renvoier toutes les Produit de la base.");

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
        final Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));
        sc.close();

        System.out.println();

        switch(choix) {
            case 1:
                System.out.println("Choix 1 : ajouter une Client.");

                break;
            case 2:
                System.out.println("Choix 2 : modifier une Client.");

                break;
            case 3:
                System.out.println("Choix 3 : supprimer une Client.");

                break;
            case 4:
                System.out.println("Choix 4 : renvoier toutes les Client de la base.");

                break;
        }
    }
}
