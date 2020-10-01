/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Produit;

import java.util.Scanner;

import FactMenu2.MySQL.Produit.Affiche.AfficheProdSQL;
import FactMenu2.MySQL.Produit.Ajout.AjoutProd;
import FactMenu2.MySQL.Produit.Modif.ModifProd;
import FactMenu2.MySQL.Produit.Sup.SupProd;

public class ChoixProdSQL {
    public static void choixProdSQL() {
        System.out.println("Faite un choix entre les actions possibles pour la produit :");
        System.out.println("1: affiche toutes les produit de la base.");
        System.out.println("2: ajouter une produit.");
        System.out.println("3: modifier une produit.");
        System.out.println("4: supprimer une produit.");

        Scanner sc = new Scanner(System.in);
        int choix;
        do {
            choix = sc.nextInt();
        } while((choix < 1) || (choix > 4));

        System.out.println();

        switch(choix) {
            case 1:
                System.out.println("Choix 1 : affiche toutes les produit de la base.");
                AfficheProdSQL.afficheProdSQL();
                break;
            case 2:
                System.out.println("Choix 2 : ajouter un produit.");
                AjoutProd.ajoutProd();
                break;
            case 3:
                System.out.println("Choix 3 : modifier un produit.");
                ModifProd.modifProd();
                break;
            case 4:
                System.out.println("Choix 4 : supprime un produit");
                SupProd.supProd();
                break;
        }
    }
}
