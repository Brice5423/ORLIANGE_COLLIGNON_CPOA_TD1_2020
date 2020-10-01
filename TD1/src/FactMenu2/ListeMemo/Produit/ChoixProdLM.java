/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.ListeMemo.Produit;

import FactMenu2.ListeMemo.Produit.Affiche.AfficheProd;
import FactMenu2.ListeMemo.Produit.Ajout.AjoutProd;
import FactMenu2.ListeMemo.Produit.Modif.ModifProd;
import FactMenu2.ListeMemo.Produit.Sup.SupProd;

import java.util.Scanner;

public class ChoixProdLM {
    public static void choixProd() {
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
                AfficheProd.afficheProd();
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
