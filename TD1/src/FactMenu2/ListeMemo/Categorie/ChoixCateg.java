package FactMenu2.ListeMemo.Categorie;

import FactMenu2.ListeMemo.Categorie.Affiche.AfficheCateg;
import FactMenu2.ListeMemo.Categorie.Ajout.AjoutCateg;
import FactMenu2.ListeMemo.Categorie.Modif.ModifCateg;
import FactMenu2.ListeMemo.Categorie.Sup.SupCateg;

import java.util.Scanner;

public class ChoixCateg {
    public static void choixCateg() {
        System.out.println("Faite un choix entre les actions possibles pour la categorie :");
        System.out.println("1: affiche toutes les categorie de la base.");
        System.out.println("2: ajouter une categorie.");
        System.out.println("3: modifier une categorie.");
        System.out.println("4: supprimer une categorie.");

        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));

        System.out.println();

        switch(choix) {
            case 1:
                System.out.println("Choix 1 : affiche toutes les categorie de la base.");
                AfficheCateg.afficheCateg();
                break;
            case 2:
                System.out.println("Choix 2 : ajouter un categorie.");
                AjoutCateg.ajoutCateg();
                break;
            case 3:
                System.out.println("Choix 3 : modifier un categorie.");
                ModifCateg.modifCateg();
            case 4:
                System.out.println("Choix 4 : supprime un categorie");
                SupCateg.supCateg();
                break;
        }
    }
}
