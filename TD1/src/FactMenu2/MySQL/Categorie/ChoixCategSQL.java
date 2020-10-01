/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Categorie;

import java.util.Scanner;

import FactMenu2.MySQL.Categorie.Affiche.AfficheCateg;
import FactMenu2.MySQL.Categorie.Ajout.AjoutCateg;
import FactMenu2.MySQL.Categorie.Modif.ModifCateg;
import FactMenu2.MySQL.Categorie.Sup.SupCateg;

public class ChoixCategSQL {
    public static void choixCategSQL() {
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
                break;
            case 4:
                System.out.println("Choix 4 : supprime un categorie");
                SupCateg.supCateg();
                break;
        }
    }
}
