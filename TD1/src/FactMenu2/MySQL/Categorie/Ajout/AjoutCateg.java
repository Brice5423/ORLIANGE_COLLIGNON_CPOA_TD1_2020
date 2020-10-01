/*****************************************************/
/** @Auteur Brice Bricou & Nico.C | CPOA TD1         */
/* OS : Windows 10 64bits         | Bute du projet : */
/* Logiciel : IntelliJ & Eclipse  |   ...            */
/* Langage : Java & SQL           |                  */
/* Date : 01/10/2020              |                  */
/*****************************************************/

package FactMenu2.MySQL.Categorie.Ajout;

import java.util.Scanner;

public class AjoutCateg {
    public static void ajoutCateg() {
        String titre_cat = null, visuel_cat = null;

        Scanner sc = new Scanner(System.in);

        System.out.println("Donner un titre de la nouvelle Categorie : ");
        titre_cat = sc.next();
        System.out.println("Donner un visuel de la nouvelle Categorie : ");
        visuel_cat = sc.next();

        AjoutCategSQL.ajoutCategSQL(titre_cat,visuel_cat);
    }
}
